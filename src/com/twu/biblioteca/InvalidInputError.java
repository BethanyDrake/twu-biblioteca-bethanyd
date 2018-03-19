package com.twu.biblioteca;

public class InvalidInputError extends Window {


    public Window previousWindow;
    public InvalidInputError(Window previousWindow)
    {
        this.previousWindow = previousWindow;
        setText("Select a valid option!\n");
    }

}
