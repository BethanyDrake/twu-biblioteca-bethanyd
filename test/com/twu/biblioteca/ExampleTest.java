package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

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
    public void shouldDisplayListOfBooksWhenBooklistWindowIsOpen()
    {
        IOManager m = new IOManager();
        BooklistWindow window = new BooklistWindow();
        m.currentWindow = window;

        String LIST_OF_BOOKS = "Harry Potter\nTwilight\n";
        //window.open();
        String output = m.getOutput();
        assertEquals(LIST_OF_BOOKS,output);

    }

    @Test
    public void shouldProceedToBooklistAfterWelcomeScreenAutomatically()
    {
        IOManager m = new IOManager();
        WelcomeWindow welcomeWindow = new WelcomeWindow();
        m.currentWindow = welcomeWindow;
        m.getOutput();

        boolean isBooklistCurrentWindow = m.currentWindow instanceof BooklistWindow;

        assertEquals(true, isBooklistCurrentWindow);
        assertEquals(1, m.numWaitingOutputs);

    }






}
