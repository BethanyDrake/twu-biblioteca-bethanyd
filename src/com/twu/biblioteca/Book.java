package com.twu.biblioteca;

public class Book extends Item {


    public String author;
    public int year;

    public Book (String title, String author, int year)
    {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString()
    {
        return title + ", " + author + ", " + year;
    }

}
