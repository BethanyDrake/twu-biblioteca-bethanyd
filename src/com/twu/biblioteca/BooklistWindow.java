package com.twu.biblioteca;

import java.util.ArrayList;

public class BooklistWindow extends Window {


    //public Window pendingMessage;

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

    public boolean isValidCheckout(String command)
    {
        if (command.startsWith("checkout "))
        {
            return true;
        }

        return false;
    }

    public void checkout(Book book)
    {
        books.remove(book);
        setBooks(books);

    }

    public void checkout(String input) {
        if (!input.startsWith("checkout "))
        {
            return;
        }

        String title = input.substring("checkout ".length());
        for (Book b : books)
        {
            if (b.title.equals(title))
            {
                checkout(b);
                return;
            }
        }

    }

    public boolean isAvailable(String title)
    {
        for (Book b : books)
        {
            if (b.title.equals(title))
            {
                checkout(b);
                return true;
            }
        }
        return false;
    }




}
