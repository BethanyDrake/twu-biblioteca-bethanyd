package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class CheckoutTest {



    @Test
    public void checkoutTitleIsValidCommandFromBooklistWindow()
    {

        BooklistWindow booklistWindow = new BooklistWindow();
        boolean isValid = !(booklistWindow.putInput("checkout Harry Potter") instanceof InvalidInputError);
        boolean expected = true;
        assertEquals(expected,isValid);
    }



    @Test
    public void returnTitleIsValidCommandFromBooklistWindow()
    {

        BooklistWindow booklistWindow = new BooklistWindow();
        boolean isValid = !(booklistWindow.putInput("return Harry Potter") instanceof InvalidInputError);

        boolean expected = true;
        assertEquals(expected,isValid);
    }


    @Test
    public void returnTitleIsUnsuccessfulIfNotCheckedOut()
    {

        BooklistWindow booklistWindow = new BooklistWindow();

        boolean isUnsuccessful= (booklistWindow .putInput("return Harry Potter")instanceof FailedReturnWindow);
        boolean expected = true;
        assertEquals(expected,isUnsuccessful);
    }


    @Test
    public void returnTitleIsSuccessfulIfCheckedOut()
    {
        IOManager m = new IOManager();
        m.currentWindow = new BooklistWindow();
        m.getOutput();
        m.putInput("checkout Harry Potter");
        m.getOutput();
        m.putInput("return Harry Potter");
        boolean isSuccessful = m.currentWindow instanceof SuccessfulReturnWindow;
        boolean expected = true;
        assertEquals(expected,isSuccessful);
    }


    @Test
    public void returnedTitlesAreDisplayedInBooklist()
    {

        BooklistWindow booklistWindow = new BooklistWindow();
        ArrayList<Item> booklist  = new ArrayList<Item>();


        booklist.add(new Book("title1", "author1",2001));
        booklistWindow.setItems(booklist);

        Book toReturn =  new Book("title2", "author2", 2002);

        booklistWindow.checkedOutItems.add(toReturn);
        booklistWindow.returnItem(toReturn);
        String expected = "title1, author1, 2001\ntitle2, author2, 2002\n";

        assertEquals(expected, booklistWindow.getText());

    }



    @Test
    public void checkedOutBooksShouldNoLongerBeListed()
    {

        BooklistWindow booklistWindow = new BooklistWindow();
        ArrayList<Item> booklist  = new ArrayList<Item>();

        Book toCheckout =  new Book("title2", "author2", 2002);
        booklist.add(new Book("title1", "author1",2001));
        booklist.add(toCheckout);
        booklist.add(new Book("title3", "author3", 2003));
        booklistWindow.setItems(booklist);

        booklistWindow.checkout(toCheckout);


        String expected = "title1, author1, 2001\ntitle3, author3, 2003\n";
        assertEquals(expected, booklistWindow.getText());


    }




    @Test
    public void displayCheckoutSuccessScreenAfterSuccessfulCheckout()
    {
        IOManager m = new IOManager();
        BooklistWindow booklistWindow = new BooklistWindow();
        m.currentWindow = booklistWindow;
        m.putInput("checkout Harry Potter");


        assertEquals("Thankyou! Enjoy the book!\n", m.getOutput());

    }

    @Test
    public void displayCheckoutFailureScreenIfBookNotAvailable()
    {
        IOManager m = new IOManager();
        BooklistWindow booklistWindow = new BooklistWindow();
        m.currentWindow = booklistWindow;
        m.putInput("checkout Lord of the Rings");

        assertEquals("That book is not available.\n", m.getOutput());
    }





}
