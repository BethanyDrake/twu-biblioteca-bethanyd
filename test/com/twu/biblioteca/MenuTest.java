package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class MenuTest {
    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void mainMenuShouldDisplayListOfOptions()
    {
        MainMenuWindow mainMenuWindow = new MainMenuWindow();
        String expected = "option1\noption2\n";
        assertEquals(expected,mainMenuWindow.getText());



    }


}
