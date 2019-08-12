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

        bookTemplate = new Book("Author testerino", 9999);
        books = new Book[]{bookTemplate, bookTemplate, bookTemplate, bookTemplate, bookTemplate};
        library = Library.fromArray(books);
        actual = library.countOfBooks();
        expected = 5;

        assertThat(actual, is(expected));
    }
    @Test
    public void out() {
        System.out.print("hello");
        assertThat("hello", is(outContent.toString()));
    }


}