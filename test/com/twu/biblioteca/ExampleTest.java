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



}
