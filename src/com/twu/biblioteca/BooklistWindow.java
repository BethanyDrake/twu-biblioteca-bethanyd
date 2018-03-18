package com.twu.biblioteca;

import java.util.ArrayList;

public class BooklistWindow extends Window {



    public ArrayList<Book> books;

    public BooklistWindow() {
        super();
        setTitle("Booklist");
        setDefaultBooklist();


    }

    private void setDefaultBooklist() {
        ArrayList<Book> booklist  = new ArrayList<Book>();
        booklist.add(new Book("Harry Potter", "JK Rowling",1996));
        booklist.add(new Book("Twilight", "S Meyer", 2002));
        setBooks(booklist);
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
