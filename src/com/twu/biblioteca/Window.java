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


    public boolean isValidCommand(String input)
    {
        if (input.equals("q")) return true;
        return false;
    }
}

