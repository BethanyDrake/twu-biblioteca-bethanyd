package com.twu.biblioteca;

import java.util.ArrayList;

public class BooklistWindow extends Window {



    public ArrayList<Book> books;

    public BooklistWindow() {
        super();
        setTitle("Booklist");
        setText("Harry Potter\nTwilight\n");


    }

    /*
    @Override
    public void advance() {

    }
    */

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        text = "";
        for (Book b : books)
        {
            text += b.title+", " + b.author + ", " + b.year + "\n";

        }


        this.books = books;
    }

}
