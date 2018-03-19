package com.twu.biblioteca;

public class SuccessfulReturnWindow extends MessageWindow {
    public SuccessfulReturnWindow(Window previousWindow)
    {
        super(previousWindow, "Return was successful.\n");
    }
}
