package com.twu.biblioteca;

public class WelcomeWindow extends Window {



    public WelcomeWindow(Console c)
    {
        super(c);
        setTitle("Welcome Message");
        setText("Welcome to Biblioteca! (press ENTER to advance)");
        open();
    }

    @Override
    public void advance() {
        new BooklistWindow(this.getParent());


    }


}
