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
        expected = "Testerino Author - 9999\n" + "Testerino Author - 9999\n" + "Testerino Author - 9999\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldStoreANewBook() {
        Library library;
        Book book;
        int actual;
        int expected;

        library = Library.filledCollection();
        book = new Book("Testerino Author", 2020);
        library.checkIn(book);
        actual = library.countOfBooks();
        expected = 11;

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnTheCorrectBook() {
        Library library;
        Book[] list;
        Book expected;
        Book actual;

        expected = new Book("Expected", 1000);
        list = new Book[]{expected, new Book("Not expected", 1020), new Book("Also not expected", 2323)};
        library = Library.fromArray(list);
        actual = library.checkOut(1);

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldRemoveTheBookWhenCheckedOut() {
        Library library;
        Book[] books;
        Book bookTemplate;
        int actual;
        int expected;

        bookTemplate = new Book("Testerino Author", 9999);
        books = new Book[]{bookTemplate, bookTemplate, bookTemplate};
        library = Library.fromArray(books);
        library.checkOut(1);
        expected = 2;
        actual = library.countOfBooks();

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
}
