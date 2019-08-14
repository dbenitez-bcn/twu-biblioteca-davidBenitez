package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class BookTest {
    Book book;

    @Before
    public void setup() {
        book = new Book("Example Author", 2019);
    }

    @Test
    public void bookShouldReturnStringWellFormattedWhenInvoked() {
        String actual;
        String expected;

        actual = book.toString();
        expected = "Example Author - 2019";

        assertThat(actual, is(expected));
    }

    @Test
    public void checkinABookShouldSetItAsCheckedInWhenUserReturnsTheBook() {
        boolean actual;
        boolean expected;

        book.checkin();
        actual = book.isInLibrary();
        expected = true;

        assertThat(actual, is(expected));
    }

    @Test
    public void checkingOutShouldSetTheBookOutOfTheLibraryWhenUsersChecksoutsABook() {
        boolean actual;
        boolean expected;

        book.checkout();
        actual = book.isInLibrary();
        expected = false;

        assertThat(actual, is(expected));
    }
}
