package com.twu.biblioteca;

import java.util.ArrayList;

public class BooklistWindow extends Window {


    //public Window pendingMessage;

    public ArrayList<Book> books;
    public ArrayList<Book> checkedOutBooks;

    public BooklistWindow() {
        super();


        setDefaultBooklist();


    }

    private void setDefaultBooklist() {
        ArrayList<Book> booklist  = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();
        booklist.add(new Book("Harry Potter", "JK Rowling",1996));
        booklist.add(new Book("Twilight", "S Meyer", 2002));

        this.books = booklist;
        setText();

    }



    public ArrayList<Book> getBooks() {
        return books;
    }


    public void setBooks(ArrayList<Book> booklist)
    {
        this.books = booklist;
        setText();

    }
    public void setText() {
        text = "";
        for (Book b : books)
        {
            text += b.title+", " + b.author + ", " + b.year + "\n";

        }


        this.books = books;
    }

    @Override
    public boolean isValidCommand(String command)
    {
        if (super.isValidCommand(command)) return true;

        if (command.startsWith("checkout "))
        {
            return true;
        }

        if (command.startsWith("return "))
        {
            return true;
        }

        return false;
    }

    public void checkout(Book book)
    {
        books.remove(book);
        setText();
        checkedOutBooks.add(book);

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

    public void returnBook(Book book)
    {
        checkedOutBooks.remove(book);
        books.add(book);
        setText();

    }


    public void returnBook(String title)
    {
        for (Book b : checkedOutBooks)
        {
            if (b.title.equals(title))
            {
                returnBook(b);
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
                checkout(b); //TODO THIS IS WHERE I DID IT!! move this to more sensible place
                return true;
            }
        }
        return false;
    }

    public boolean isCheckedOut(String title)
    {
        for (Book b : checkedOutBooks)
        {
            if (b.title.equals(title))
            {
                return true;
            }
        }

        return false;

    }




}
