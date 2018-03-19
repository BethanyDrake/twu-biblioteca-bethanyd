package com.twu.biblioteca;

public class FailedCheckoutWindow extends MessageWindow {
    public Window previousWindow;
    public FailedCheckoutWindow(Window previousWindow) {
        super(previousWindow, "That book is not available.\n");

    }



}



