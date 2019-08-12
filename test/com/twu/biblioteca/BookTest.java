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
    public void bookSouldReturnStringWellFormatted(){
        Book book;
        String actual;
        String expected;

        book = new Book("Example Author", 2019);
        actual = book.toString();
        expected = "Example Author - 2019";

        assertThat(actual, is(expected));
    }
}
