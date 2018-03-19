package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StartUpTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void shouldDisplayWelcomeMessageOnStartUp()
    {
        IOManager m = new IOManager();

        String WELCOME_MESSAGE = "Welcome!";
        String output = m.getOutput();
        assertEquals(WELCOME_MESSAGE, output);

    }




    @Test
    public void shouldProceedToMainMenuAfterWelcomeScreenAutomatically()
    {
        IOManager m = new IOManager();
        WelcomeWindow welcomeWindow = new WelcomeWindow();
        m.currentWindow = welcomeWindow;
        m.getOutput();

        boolean isMainMenuCurrentWindow = m.currentWindow instanceof MainMenuWindow;

        assertEquals(true, isMainMenuCurrentWindow);
        assertEquals(1, m.numWaitingOutputs);

    }

    @Test
    public void bookListShouldIncludeBookDetails()
    {
       BooklistWindow booklistWindow = new BooklistWindow();
       ArrayList<Book> booklist  = new ArrayList<Book>();
       booklist.add(new Book("title1", "author1",2001));
       booklist.add(new Book("title2", "author2", 2002));

       booklistWindow.setBooks(booklist);


       String expected = "title1, author1, 2001\ntitle2, author2, 2002\n";
       assertEquals(expected, booklistWindow.getText());

    }




}
