package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class MovieTest {
    Movie movie;
    @Before
    public void setup(){
        movie = new Movie("Test movie", 1234, "Testerino", 99);
    }

    @Test
    public void toStringShouldReturnTheMovieInformation(){
        String actual;
        String expected;

        actual = movie.toString();
        expected = "Test movie(1234) - Testerino: 10";

        assertThat(actual, is(expected));
    }

    @Test
    public void toStringShouldReturnTheUserNameAndTheNameWhenIsCheckedOut(){
        String actual;
        String expected;

        movie.checkout("UserName");
        actual = movie.toString();
        expected = "Test movie is checked out by UserName";

        assertThat(actual, is(expected));
    }

    @Test
    public void movieShouldBeMarkAsCheckedOutWhenUserChecksout(){
        boolean actual;
        boolean expected;

        movie.checkout("UserNameTest");
        actual = movie.isInLibrary();
        expected = false;

        assertThat(actual, is(expected));
    }

    @Test
    public void movieShouldBeMarkAsCheckedin(){
        boolean actual;
        boolean expected;

        movie.checkin();
        actual = movie.isInLibrary();
        expected = true;

        assertThat(actual, is(expected));
    }
}
