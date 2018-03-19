package com.twu.biblioteca;

public class FailedCheckoutWindow extends Window {
    public Window previousWindow;
    public FailedCheckoutWindow(Window previousWindow) {

        this.previousWindow = previousWindow;
        setText("That book is not available.\n");
    }



}



