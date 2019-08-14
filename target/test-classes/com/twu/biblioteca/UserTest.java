package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
public class UserTest {
    User user;

    @Before
    public void setup(){
        user = new User("Testerino", "testerino@testing.com", 123456789);
    }

    @Test
    public void toStringShouldReturnTheRightInformation(){
        String actual;
        String expected;

        actual = user.toString();
        expected = "Name: Testerino\nEmail: testerino@testing.com\nPhone: 123456789";

        assertThat(actual, is(expected));
    }

    @Test
    public void userIsNotLoggetInIfHasntCodeAndPassword(){
        boolean actual;
        boolean expected;

        actual = user.isLoggetIn();
        expected = false;

        assertThat(actual, is(expected));
    }

    @Test
    public void userShouldBeLoggedInAfterAddingPassworkdAndCode(){
        boolean actual;
        boolean expected;

        user.login("xxx-xxxx", "testing password");
        actual = user.isLoggetIn();
        expected = true;

        assertThat(actual, is(expected));
    }

    @Test
    public void userShouldRemoveCodeAndPasswordWhenUserLogsOut(){
        boolean actual;
        boolean expected;

        user.logout();
        actual = user.isLoggetIn();
        expected = false;

        assertThat(actual, is(expected));
    }
}
