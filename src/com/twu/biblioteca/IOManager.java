package com.twu.biblioteca;

import com.sun.tools.javah.Util;

import java.util.Scanner;

public class IOManager {

    public static enum Input {ADVANCE}
    public Window currentWindow;
    public int numWaitingOutputs = 0;


    public IOManager()
    {
        currentWindow =  new WelcomeWindow();
        numWaitingOutputs++;



    }

    public String getOutput()
    {




        String output = currentWindow.getText();

        //do side effects
        if (currentWindow instanceof WelcomeWindow)
        {
            currentWindow = new MainMenuWindow();
            numWaitingOutputs++;
        }

        else if (currentWindow instanceof InvalidInputError)
        {
            currentWindow = ((InvalidInputError)currentWindow).previousWindow;
            numWaitingOutputs++;
        }

        else if (currentWindow instanceof SuccessfulCheckoutWindow)
        {
            currentWindow = ((SuccessfulCheckoutWindow)currentWindow).previousWindow;
            numWaitingOutputs++;
        }

        else if (currentWindow instanceof FailedCheckoutWindow)
        {
            currentWindow = ((FailedCheckoutWindow)currentWindow).previousWindow;
            numWaitingOutputs++;
        }






        numWaitingOutputs--;
        return output;
    }



    public void putInput(int input)
    {

        if (currentWindow instanceof  MainMenuWindow)
        {
            if (input ==1)
            {
                currentWindow = new BooklistWindow();
                numWaitingOutputs++;
            }
        }





    }

    public boolean isValidInput(String input)
    {

        if (currentWindow instanceof Window)
        {
            if (input.equals("q"))
            {
                return true;
            }
        }

        if (currentWindow instanceof MainMenuWindow)
        {
            MainMenuWindow menu = (MainMenuWindow) currentWindow;
            if (isNumeric(input) )
            {
                int option = Integer.parseInt(input);
                if (option >0 && option <=menu.numOptions)
                {
                    return true;
                }


            }
        }

        if (currentWindow instanceof BooklistWindow)
        {
            return ((BooklistWindow)currentWindow).isValidCheckout(input);


        }


        return false;
    }

    private boolean isNumeric(String string)
    {
        if (string == "") return false;
        for (char c : string.toCharArray())
        {
            if (!Character.isDigit(c))
            {
                return false;
            }
        }
        return true;
    }


    public void putInput(String input)
    {

        if (!isValidInput(input))
        {
            currentWindow = new InvalidInputError(currentWindow);
            numWaitingOutputs++;
            return;
        }

        if (isNumeric(input))
        {
            putInput(Integer.parseInt(input));
            return;
        }

        if (input.equals("q"))
        {
            currentWindow = new ExitWindow();
            numWaitingOutputs++;
        }


        if (currentWindow instanceof BooklistWindow)
        {
            BooklistWindow booklistWindow = (BooklistWindow) currentWindow;
            if (booklistWindow.isValidCheckout(input))
            {
                if (booklistWindow.isAvailable(input.substring("checkout ".length())))
                {
                    //booklistWindow.checkout(input); //TODO put this back...frankly I'm not sure why it still works
                    currentWindow = new SuccessfulCheckoutWindow(currentWindow);
                    numWaitingOutputs++;
                }
                else
                {
                    currentWindow = new FailedCheckoutWindow(currentWindow);
                    numWaitingOutputs++;
                }

            }

        }



        /*

        //do post-input updates
        if (currentWindow instanceof BooklistWindow)
        {
            BooklistWindow booklistWindow = (BooklistWindow)currentWindow;
            if (booklistWindow.pendingMessage != null)
            {
                currentWindow = booklistWindow.pendingMessage;
                booklistWindow.pendingMessage = null;
                numWaitingOutputs++;
            }

        }
        */








    }
}
