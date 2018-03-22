package com.twu.biblioteca;

import java.util.ArrayList;

public class ItemListWindow extends Window {

    public ArrayList<Item> items;
    public ArrayList<Item> checkedOutItems;

    public boolean loggedIn;

    public ItemListWindow(String user) {

        loggedIn = false;
        if (user != null) loggedIn = true;

        //setDefaultBooklist();


    }

    /*
    private void setDefaultBooklist() {
        ArrayList<Book> booklist  = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();
        booklist.add(new Book("Harry Potter", "JK Rowling",1996));
        booklist.add(new Book("Twilight", "S Meyer", 2002));

        this.books = booklist;
        setText();

    }
    */




    public void setText() {
        text = "";
        for (Item item : items)
        {

            text += item.toString() + "\n";
            //text += b.title+", " + b.author + ", " + b.year + "\n";

        }

    }

    public void setItems(ArrayList<Item> itemList)
    {
        this.items = itemList;
        setText();

    }

    @Override
    public Window putInput(String input)
    {

        if (!loggedIn) return super.putInput(input);

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



    public void checkout(Item item)
    {
        items.remove(item);
        setText();
        checkedOutItems.add(item);

    }

    public void checkout(String title) {

        for (Item i : items)
        {
            if (i.title.equals(title))
            {
                checkout(i);
                return;
            }
        }

    }

    public void returnItem(Item item)
    {
        checkedOutItems.remove(item);
        items.add(item);
        setText();

    }


    public void returnBook(String title)
    {
        for (Item i : checkedOutItems)
        {
            if (i.title.equals(title))
            {
                returnItem(i);
                return;

            }
        }


    }
    public boolean isAvailable(String title)
    {
        for (Item i : items)
        {
            if (i.title.equals(title))
            {

                return true;
            }
        }
        return false;
    }

    public boolean isCheckedOut(String title)
    {
        for (Item i : checkedOutItems)
        {
            if (i.title.equals(title))
            {
                return true;
            }
        }

        return false;

    }



}
