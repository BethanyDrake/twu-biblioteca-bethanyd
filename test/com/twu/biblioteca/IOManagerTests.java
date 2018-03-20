package com.twu.biblioteca;

import org.junit.Test;
import sun.applet.Main;


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



    private boolean isValidInput(Window window, String input)
    {
        return !(window.putInput(input) instanceof InvalidInputError);
    }

    @Test
    public void numericalInputsAreValidIfMenuIsOpen()
    {

        boolean isValid = isValidInput(new MainMenuWindow(), "1");
        boolean expected = true;
        assertEquals(expected, isValid);
    }


    @Test
    public void numericalInputsAreInvalidIfNoOptionHasThatNumber()
    {

        boolean isValid = isValidInput(new MainMenuWindow(), "73");
        boolean expected = false;
        assertEquals(expected,isValid);
    }



}
