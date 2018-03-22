package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class AccountsTest {


    @Test
    public void canLoginFromAccountWindow()
    {

        AccountsWindow booklistWindow = new AccountsWindow();
        boolean isLoginScreen = (booklistWindow.putInput("1") instanceof LoginWindow);
        assertTrue(isLoginScreen);

    }

    @Test public void loginScreenAsksForLibraryNumber()
    {
        IOManager m = new IOManager();

        LoginWindow loginWindow = new LoginWindow();
        m.currentWindow = loginWindow;
        String output = m.getOutput();
        assertEquals("Enter library number: ", output);

    }



    @Test public void afterEnteringLibraryNumberLoginScreenAsksForPassword()
    {
        IOManager m = new IOManager();

        LoginWindow loginWindow = new LoginWindow();
        m.currentWindow = loginWindow;
        m.getOutput();
        m.putInput("111-1111");
        String output = m.getOutput();
        assertEquals("Enter password: ", output);

    }

    @Test public void libraryNumbersOfIncorrectLengthAreInvalid()
    {
        IOManager m = new IOManager();

        LoginWindow loginWindow = new LoginWindow();
        m.currentWindow = loginWindow;
        m.getOutput();
        m.putInput("1112-11112");
        assertTrue(m.currentWindow instanceof InvalidInputError);

    }

    @Test public void libraryNumbersWithIncorrectHyphenPlacementAreInvalid()
    {
        IOManager m = new IOManager();

        LoginWindow loginWindow = new LoginWindow();
        m.currentWindow = loginWindow;
        m.getOutput();
        m.putInput("1111-111");
        assertTrue(m.currentWindow instanceof InvalidInputError);

    }

    @Test public void nonNumericLibraryNumbersAreInvalid()
    {
        IOManager m = new IOManager();

        LoginWindow loginWindow = new LoginWindow();
        m.currentWindow = loginWindow;
        m.getOutput();
        m.putInput("1111-hey");
        assertTrue(m.currentWindow instanceof InvalidInputError);

    }

    @Test
    public void afterEnteringAccountNumberOnlyCorrectPasswordsAreValid()
    {
        //aaand all passwords are correct...
        IOManager m = new IOManager();
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.enteredLibraryNumber = true;
        m.currentWindow = loginWindow;
        m.getOutput();
        m.putInput("password");
        assertFalse(m.currentWindow instanceof InvalidInputError);

    }



}
