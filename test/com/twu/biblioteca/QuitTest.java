package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class QuitTest {


    @Test
    public void QuittingFromWindowCausesExitScreenToDisplay()
    {
        IOManager m = new IOManager();
        m.currentWindow = new BooklistWindow();
        m.putInput("quit");

        boolean exiting = m.currentWindow instanceof ExitWindow;

        assertEquals(true,exiting);


    }





}
