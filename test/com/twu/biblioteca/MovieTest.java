package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class MovieTest {
    @Test
    public void movieShouldExist(){
        Movie movie;

        movie = new Movie();

        assertThat(movie, notNullValue());
    }

    @Test
    public void toStringShouldReturnTheMovieInformation(){
        Movie movie;
        String actual;
        String expected;

        movie = new Movie("Test movie", 1234, "Testerino", 99);
        actual = movie.toString();
        expected = "Test movie(1234) - Testerino: 10";

        assertThat(actual, is(expected));
    }

    @Test
    public void toStringShouldReturnTheUserNameAndTheNameWhenIsCheckedOut(){
        Movie movie;
        String actual;
        String expected;

        movie = new Movie("Test movie", 1234, "Testerino", 8);
        movie.checkout("UserName");
        actual = movie.toString();
        expected = "Test movie is checked out by UserName";

        assertThat(actual, is(expected));
    }

    @Test
    public void movieShouldBeMarkAsCheckedOutWhenUserChecksout(){
        Movie movie;
        boolean actual;
        boolean expected;

        movie = new Movie("Test movie", 1234, "Testerino", 99);
        movie.checkout("UserNameTest");
        actual = movie.isInLibrary();
        expected = false;

        assertThat(actual, is(expected));
    }

    @Test
    public void movieShouldBeMarkAsCheckedin(){
        Movie movie;
        boolean actual;
        boolean expected;

        movie = new Movie("Test movie", 1234, "Testerino", 99);
        movie.checkin();
        actual = movie.isInLibrary();
        expected = true;

        assertThat(actual, is(expected));
    }
}
