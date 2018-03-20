package com.twu.biblioteca;

public abstract class Window
{


    String text;


    public Window()
    {


    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Window putInput(String input)
    {
        if (input.equals("quit")) return new ExitWindow();
        return new InvalidInputError(this);
    }


}

