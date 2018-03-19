package com.twu.biblioteca;

public class SuccessfulCheckoutWindow extends Window{

    public Window previousWindow;
    public SuccessfulCheckoutWindow(Window previousWindow)
    {
        this.previousWindow = previousWindow;
        setText("Thankyou! Enjoy the book!\n");
    }
}
