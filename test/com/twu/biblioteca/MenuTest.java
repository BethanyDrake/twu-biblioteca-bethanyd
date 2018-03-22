package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void mainMenuShouldDisplayOListBooksAndListMoviesOption()
    {
        MainMenuWindow mainMenuWindow = new MainMenuWindow();
        String expected = "(1) List Books\n(2) List Movies\n(3) Accounts\n";
        assertEquals(expected,mainMenuWindow.getText());

    }

    @Test
    public void fromMainMenuCanSelectListBooksToDisplayBookList()
    {
        IOManager m = new IOManager();
        m.currentWindow = new MainMenuWindow();
        m.putInput("1");
        assertEquals(true, m.currentWindow instanceof BooklistWindow);
        assertEquals(true, m.numWaitingOutputs > 0);


    }

    @Test
    public void fromMainMenuCanSelectListMoviesToDisplayMovieList()
    {
        IOManager m = new IOManager();
        m.currentWindow = new MainMenuWindow();
        m.putInput("2");
        assertTrue(m.currentWindow instanceof MovieListWindow);


    }

    @Test
    public void fromMainMenuCanGoToAccountsWindow()
    {
        IOManager m = new IOManager();
        m.currentWindow = new MainMenuWindow();
        m.putInput("3");
        assertTrue(m.currentWindow instanceof AccountsWindow);

    }




}
