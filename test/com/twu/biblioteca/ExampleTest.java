package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void shouldDisplayWelcomeMessageOnOpen()
    {
        Console c = new Console();
        assertEquals(c.currentWindow.title, "Welcome Message");

    }

    @Test
    public void shouldDisplayListOfBooksAfterWelcome()
    {
        Console c = new Console();
        new WelcomeWindow(c);
        c.currentWindow.advance();
        assertEquals(c.currentWindow.title, "Booklist");


    }

}
