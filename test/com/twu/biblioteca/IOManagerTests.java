package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class IOManagerTests {

    /*
    @Test
    public void invalidInputsDisplayError()
    {

    }
    */

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
