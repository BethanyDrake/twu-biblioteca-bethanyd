package com.twu.biblioteca;

public class MessageWindow extends Window {
    public Window previousWindow;
    public MessageWindow(Window previousWindow, String message) {

        this.previousWindow = previousWindow;
        setText(message);
    }

}
