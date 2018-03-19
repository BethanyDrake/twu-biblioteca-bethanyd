package com.twu.biblioteca;

public class InvalidInputError extends MessageWindow {


    public Window previousWindow;
    public InvalidInputError(Window previousWindow)
    {
        super(previousWindow, "Select a valid option!\n");

    }

}
