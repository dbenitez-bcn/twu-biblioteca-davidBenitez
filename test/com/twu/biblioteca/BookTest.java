package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


public class BookTest {
    @Test
    public void bookShouldExist() {
        // Arrange
        Book actual;
        // Act
        actual = new Book("First author", 2019);
        // Assert
        assertThat(actual, notNullValue());
    }

    @Test
    public void bookShouldReturnStringWellFormatted(){
        Book book;
        String actual;
        String expected;

        book = new Book("Example Author", 2019);
        actual = book.toString();
        expected = "Example Author - 2019";

        assertThat(actual, is(expected));
    }

    @Test
    public void checkinABookShouldSetItAsCheckedIn(){
        Book book;
        boolean actual;
        boolean expected;

        book = new Book("Testerino Author", 1919);
        book.checkin();
        actual = book.isInLibrary();
        expected = true;

        assertThat(actual, is(expected));
    }

    @Test
    public void checkoutABookShouldSetItAsNotCheckedIn(){
        Book book;
        boolean actual;
        boolean expected;

        book = new Book("Testerino Author", 1919);
        book.checkout();
        actual = book.isInLibrary();
        expected = false;

        assertThat(actual, is(expected));
    }
}
