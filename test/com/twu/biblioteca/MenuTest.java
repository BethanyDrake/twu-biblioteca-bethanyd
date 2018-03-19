package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class MenuTest {
    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void mainMenuShouldDisplayOnlyListBooksOption()
    {
        MainMenuWindow mainMenuWindow = new MainMenuWindow();
        String expected = "List Books\n";
        assertEquals(expected,mainMenuWindow.getText());

    }

    @Test
    public void fromPublicMenuCanSelectListBooksToDisplayBookList()
    {
        IOManager m = new IOManager();
        m.currentWindow = new MainMenuWindow();
        m.putInput("1");
        assertEquals(true, m.currentWindow instanceof BooklistWindow);
        assertEquals(true, m.numWaitingOutputs > 0);


    }




}
