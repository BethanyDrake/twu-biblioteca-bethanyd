package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class IOManagerTests {



    @Test
    public void invalidInputsDisplayError()
    {
        IOManager m = new IOManager();
        m.putInput("Hi! I'm an invalid input!");
        String output = m.getOutput();
        String expected = "Select a valid option!\n";
        assertEquals(expected,output);


    }

    @Test
    public void afterDisplayMessageAutomaticallyReturnTPreviousWindow()
    {

        IOManager m = new IOManager();

        Window previousWindow = m.currentWindow;
        m.currentWindow = new MessageWindow(previousWindow, "message");
        m.getOutput();
        assertEquals(previousWindow,m.currentWindow);

    }


    @Test
    public void numericalInputsAreValidIfMenuIsOpen()
    {
        IOManager m = new IOManager();
        m.currentWindow = new MainMenuWindow();
        boolean isValid = m.isValidInput("1");
        boolean expected = true;
        assertEquals(expected, isValid);
    }

    @Test
    public void nonNumericalInputsAreInvalid()
    {
        IOManager m = new IOManager();
        boolean isValid = m.isValidInput("hi");
        boolean expected = false;
        assertEquals(expected, isValid);
    }

    @Test
    public void noInputsAreValidIfNoMenuIsOpen()
    {
        IOManager m = new IOManager();
        m.currentWindow = new WelcomeWindow();
        boolean isValid = m.isValidInput("1");
        boolean expected = false;
        assertEquals(expected,isValid);


    }

    @Test
    public void numericalInputsAreInvalidIfNoOptionHasThatNumber()
    {
        IOManager m = new IOManager();
        m.currentWindow = new MainMenuWindow();
        boolean isValid = m.isValidInput("73");
        boolean expected = false;
        assertEquals(expected,isValid);
    }


}
