package com.twu.biblioteca;

public abstract class Window
{

    String title;
    String text;




    public Window()
    {
        //this.parent = c;

    }

    public void open()
    {
        System.out.println(text);

    }

    //public abstract void advance();



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

