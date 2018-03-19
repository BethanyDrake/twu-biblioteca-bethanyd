package com.twu.biblioteca;

public class SuccessfulCheckoutWindow extends MessageWindow{

    public Window previousWindow;
    public SuccessfulCheckoutWindow(Window previousWindow)
    {
        super(previousWindow, "Thankyou! Enjoy the book!\n");

    }
}
