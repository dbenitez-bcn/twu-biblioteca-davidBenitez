package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LibraryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    Library filledLibrary;
    Library emptyLibrary;
    Library library;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        emptyLibrary = Library.emptyCollection();
        filledLibrary = Library.filledCollection();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void libraryCreatedWithZeroBooks() {
        int actual;
        int expected;

        actual = emptyLibrary.countOfBooks();
        expected = 0;

        assertThat(actual, is(expected));
    }

    @Test
    public void libraryCreatedWithZeroMovies() {
        int actual;
        int expected;

        actual = emptyLibrary.countOfMovies();
        expected = 0;

        assertThat(actual, is(expected));
    }

    @Test
    public void libraryCreatedWithTenBooks() {
        int actual;
        int expected;

        actual = filledLibrary.countOfBooks();
        expected = 10;

        assertThat(actual, is(expected));
    }

    @Test
    public void libraryCreatedWithFourMovies() {
        int actual;
        int expected;

        actual = filledLibrary.countOfMovies();
        expected = 4;

        assertThat(actual, is(expected));
    }

    @Test
    public void libraryShouldBeCreatedFromAnArray() {
        Book[] books;
        Book bookTemplate;
        int actual;
        int expected;

        bookTemplate = new Book("Testerino Author", 9999);
        books = new Book[]{bookTemplate, bookTemplate, bookTemplate, bookTemplate, bookTemplate};
        library = Library.fromArray(books, new Movie[]{});
        actual = library.countOfBooks();
        expected = 5;

        assertThat(actual, is(expected));
    }

    @Test
    public void libraryShouldShowTheListOfBooks() {
        Book[] books;
        Book bookTemplate;
        String actual;
        String expected;

        bookTemplate = new Book("Testerino Author", 9999);
        books = new Book[]{bookTemplate, bookTemplate, bookTemplate};
        library = Library.fromArray(books, new Movie[]{});
        library.listBooks();
        actual = outContent.toString();
        expected = "1.Testerino Author - 9999\n" + "2.Testerino Author - 9999\n" + "3.Testerino Author - 9999\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void libraryShouldShowTheListOfMoviesWhenUserAskForThem() {
        Movie[] movies;
        Movie movieTemplate;
        String actual;
        String expected;

        movieTemplate = new Movie("Test movie", 1234, "Director", 5);
        movies = new Movie[]{movieTemplate, movieTemplate};
        library = Library.fromArray(new Book[]{}, movies);
        library.listMovies();
        actual = outContent.toString();
        expected = "1.Test movie(1234) - Director: 5\n2.Test movie(1234) - Director: 5\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void userShouldCheckoutAMovieWhenAsksForIt(){
        Movie[] movies;
        String actual;
        String expected;

        movies = new Movie[]{new Movie("Test movie", 1234, "Director", 5),new Movie("Test movie", 1234, "Director", 5)};
        library = Library.fromArray(new Book[]{}, movies);
        library.checkOutAMovie(1, "UserName");
        outContent.reset();
        library.listMovies();
        actual = outContent.toString();
        expected = "1.Test movie is checked out by UserName\n2.Test movie(1234) - Director: 5\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowTheBookWhenCheckedIn() {
        Book[] books;
        String actual;
        String expected;

        books = new Book[]{new Book("Testerino Author", 9999), new Book("Testerino Author", 9999), new Book("Testerino Author", 9999)};
        library = Library.fromArray(books, new Movie[]{});
        library.checkInABook(1);
        outContent.reset();
        library.listBooks();
        actual = outContent.toString();
        expected = "1.Testerino Author - 9999\n" + "2.Testerino Author - 9999\n" + "3.Testerino Author - 9999\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldHideTheBookWhenCheckedOut() {
        Book[] books;
        String actual;
        String expected;

        books = new Book[]{new Book("Testerino Author", 9999), new Book("Testerino Author", 9999), new Book("Testerino Author", 9999)};
        library = Library.fromArray(books, new Movie[]{});
        library.checkOutABook(1);
        outContent.reset();
        library.listBooks();
        actual = outContent.toString();
        expected = "2.Testerino Author - 9999\n" + "3.Testerino Author - 9999\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowASuccessfullyMessageWhenCheckoutSuccess(){
        String actual;
        String expected;

        library = Library.filledCollection();
        library.checkOutABook(2);
        actual = outContent.toString();
        expected = "Thank you! Enjoy the book\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowAUnsuccessfullyMessageWhenCheckoutFails(){
        String actual;
        String expected;

        filledLibrary.checkOutABook(99);
        actual = outContent.toString();
        expected = "Sorry, that book is not available\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowSuccessfullyMessageWhenCheckinSuccess(){
        String actual;
        String expected;

        filledLibrary.checkOutABook(3);
        outContent.reset();
        filledLibrary.checkInABook(3);
        actual = outContent.toString();
        expected = "Thank you for returning the book\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldShowUnsuccessfullyMessageWhenCheckinFails(){
        String actual;
        String expected;

        filledLibrary.checkInABook(30);
        actual = outContent.toString();
        expected = "That is not a valid book to return\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldFailToCheckinIfBookIsAlreadyCheckedIn(){
        String actual;
        String expected;

        filledLibrary.checkInABook(1);
        actual = outContent.toString();
        expected = "That is not a valid book to return\n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldFailToCheckoutIfBookIsAlreadyCheckedOut(){
        String actual;
        String expected;

        filledLibrary.checkOutABook(1);
        outContent.reset();
        filledLibrary.checkOutABook(1);
        actual = outContent.toString();
        expected = "Sorry, that book is not available\n";

        assertThat(actual, is(expected));
    }
}
