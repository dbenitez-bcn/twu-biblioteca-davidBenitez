package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
public class UserTest {
    @Test
    public void userShouldExist(){
        User user;

        user = new User();

        assertThat(user, notNullValue());
    }

    @Test
    public void toStringShouldReturnTheRightInformation(){
        User user;
        String actual;
        String expected;

        user = new User("Testerino", "testerino@testing.com", 123456789);
        actual = user.toString();
        expected = "Name: Testerino\nEmail: testerino@testing.com\nPhone: 123456789";

        assertThat(actual, is(expected));
    }

    @Test
    public void userIsNotLoggetInIfHasntCodeAndPassword(){
        User user;
        boolean actual;
        boolean expected;

        user = new User("Testerino", "testerino@testing.com", 123456789);
        actual = user.isLoggetIn();
        expected = false;

        assertThat(actual, is(expected));
    }

    @Test
    public void userShouldBeLoggedInAfterAddingPassworkdAndCode(){
        User user;
        boolean actual;
        boolean expected;

        user = new User("Testerino", "testerino@testing.com", 123456789);
        user.login("xxx-xxxx", "testing password");
        actual = user.isLoggetIn();
        expected = true;

        assertThat(actual, is(expected));
    }
}
