package com.twu.biblioteca;

public class FailedReturnWindow extends MessageWindow {
    public FailedReturnWindow(Window previousWindow)
    {
        super(previousWindow, "Return was unsuccessful.\n");
    }
}
