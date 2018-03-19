package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class QuitTest {


    @Test
    public void QuittingFromWindowCausesExitScreenToOccur()
    {
        IOManager m = new IOManager();
        m.currentWindow = new BooklistWindow();
        m.putInput("q");

        String output = m.getOutput();
        String expected = "Goodbye!\n";

        assertEquals(expected,output);


    }

    @Test
    public void qIsValidCommand()
    {
        IOManager m = new IOManager();
        m.currentWindow = new BooklistWindow();
        boolean qIsValid = m.isValidInput("q");

        boolean expected = true;

        assertEquals(expected, qIsValid);


    }

}
