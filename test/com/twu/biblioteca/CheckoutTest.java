package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class CheckoutTest {



    @Test
    public void checkoutTitleIsValidCommandFromBooklistWindowIfBookIsListed()
    {
        IOManager m = new IOManager();
        m.currentWindow = new BooklistWindow();
        boolean isValid = m.isValidInput("checkout Harry Potter");
        boolean expected = true;
        assertEquals(expected,isValid);
    }





    @Test
    public void checkedOutBooksShouldNoLongerBeListed()
    {

        BooklistWindow booklistWindow = new BooklistWindow();
        ArrayList<Book> booklist  = new ArrayList<Book>();

        Book toCheckout =  new Book("title2", "author2", 2002);
        booklist.add(new Book("title1", "author1",2001));
        booklist.add(toCheckout);
        booklist.add(new Book("title3", "author3", 2003));
        booklistWindow.setBooks(booklist);

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
