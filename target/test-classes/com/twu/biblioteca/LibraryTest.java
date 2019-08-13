package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class LibraryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void libraryExists() {
        Library actual;

        actual = new Library();

        assertThat(actual, notNullValue());
    }

    @Test
    public void libraryCreatedWithZeroBooks() {
        Library library;
        int actual;
        int expected;

        library = Library.emptyCollection();
        actual = library.countOfBooks();
        expected = 0;

        assertThat(actual, is(expected));
    }

    @Test
    public void libraryCreatedWithTenBooks() {
        Library library;
        int actual;
        int expected;

        library = Library.filledCollection();
        actual = library.countOfBooks();
        expected = 10;

        assertThat(actual, is(expected));
    }

    @Test
    public void libraryShouldBeCreatedFromAnArray() {
        Library library;
        Book[] books;
        Book bookTemplate;
        int actual;
        int expected;

        bookTemplate = new Book("Testerino Author", 9999);
        books = new Book[]{bookTemplate, bookTemplate, bookTemplate, bookTemplate, bookTemplate};
        library = Library.fromArray(books);
        actual = library.countOfBooks();
        expected = 5;

        assertThat(actual, is(expected));
    }

    @Test
    public void libraryShouldShowTheListOfBooks() {
        Library library;
        Book[] books;
        Book bookTemplate;
        String actual;
        String expected;

        bookTemplate = new Book("Testerino Author", 9999);
        books = new Book[]{bookTemplate, bookTemplate, bookTemplate};
        library = Library.fromArray(books);
        library.showList();
        actual = outContent.toString();
        expected = "1.Testerino Author - 9999\n" + "2.Testerino Author - 9999\n" + "3.Testerino Author - 9999\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowTheBookWhenCheckedIn() {
        Library library;
        Book[] books;
        String actual;
        String expected;

        books = new Book[]{new Book("Testerino Author", 9999), new Book("Testerino Author", 9999), new Book("Testerino Author", 9999)};
        library = Library.fromArray(books);
        library.checkIn(1);
        outContent.reset();
        library.showList();
        actual = outContent.toString();
        expected = "1.Testerino Author - 9999\n" + "2.Testerino Author - 9999\n" + "3.Testerino Author - 9999\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldHideTheBookWhenCheckedOut() {
        Library library;
        Book[] books;
        String actual;
        String expected;

        books = new Book[]{new Book("Testerino Author", 9999), new Book("Testerino Author", 9999), new Book("Testerino Author", 9999)};
        library = Library.fromArray(books);
        library.checkOut(1);
        outContent.reset();
        library.showList();
        actual = outContent.toString();
        expected = "2.Testerino Author - 9999\n" + "3.Testerino Author - 9999\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowASuccessfullyMessageWhenCheckoutSuccess(){
        Library library;
        String actual;
        String expected;

        library = Library.filledCollection();
        library.checkOut(2);
        actual = outContent.toString();
        expected = "Thank you! Enjoy the book\n";


        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowAUnsuccessfullyMessageWhenCheckoutFails(){
        Library library;
        String actual;
        String expected;

        library = Library.filledCollection();
        library.checkOut(99);
        actual = outContent.toString();
        expected = "Sorry, that book is not available\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowSuccessfullyMessageWhenCheckinSuccess(){
        Library library;
        String actual;
        String expected;

        library = Library.filledCollection();
        library.checkOut(3);
        outContent.reset();
        library.checkIn(3);
        actual = outContent.toString();
        expected = "Thank you for returning the book\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowUnsuccessfullyMessageWhenCheckinFails(){
        Library library;
        String actual;
        String expected;

        library = Library.filledCollection();
        library.checkIn(30);
        actual = outContent.toString();
        expected = "That is not a valid book to return\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldFailToCheckinIfBookIsAlreadyCheckedIn(){
        Library library;
        String actual;
        String expected;

        library = Library.filledCollection();
        library.checkIn(1);
        actual = outContent.toString();
        expected = "That is not a valid book to return\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldFailToCheckoutIfBookIsAlreadyCheckedOut(){
        Library library;
        String actual;
        String expected;

        library = Library.filledCollection();
        library.checkOut(1);
        outContent.reset();
        library.checkOut(1);
        actual = outContent.toString();
        expected = "Sorry, that book is not available\n";

        assertThat(actual, is(expected));
    }
}
