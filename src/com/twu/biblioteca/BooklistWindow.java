package com.twu.biblioteca;

import java.util.ArrayList;

public class BooklistWindow extends ItemListWindow {


    //public Window pendingMessage;

    private void setDefaultBooklist() {
        ArrayList<Item> booklist  = new ArrayList<Item>();
        checkedOutItems = new ArrayList<Item>();
        booklist.add(new Book("Harry Potter", "JK Rowling",1996));
        booklist.add(new Book("Twilight", "S Meyer", 2002));

        this.items = booklist;
        setText();

    }

    public BooklistWindow(String user) {

        super (user);
        setDefaultBooklist();

    }

    /*

    public ArrayList<Book> books;
    public ArrayList<Book> checkedOutBooks;

    public BooklistWindow() {

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
    public Window putInput(String input)
    {

        if (input.startsWith("checkout "))
        {

            String title = input.substring("checkout ".length());

            if (isAvailable(title))
            {

                checkout(title);
                return new SuccessfulCheckoutWindow(this);

            }
            else
            {
                return new FailedCheckoutWindow(this);

            }

        }

        if (input.startsWith("return "))
        {
            String title = input.substring("return ".length());
            if (isCheckedOut(title))
            {

                returnBook(title);
                return new SuccessfulReturnWindow(this);

            }
            else
            {
                return new FailedReturnWindow(this);

            }

        }
        return super.putInput(input);
    }



    public void checkout(Book book)
    {
        books.remove(book);
        setText();
        checkedOutBooks.add(book);

    }

    public void checkout(String title) {

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

*/



}
