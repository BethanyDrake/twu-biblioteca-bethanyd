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

        else if (currentWindow instanceof MessageWindow)
        {
            currentWindow = ((MessageWindow)currentWindow).previousWindow;
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
            return ((BooklistWindow)currentWindow).isValidCommand(input);


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
            if (booklistWindow.isValidCommand(input))
            {

                if (input.startsWith("checkout "))
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

                if (input.startsWith("return "))
                {
                    String title = input.substring("return ".length());
                    if (booklistWindow.isCheckedOut(title))
                    {
                        //booklistWindow.checkout(input); //TODO put this back...frankly I'm not sure why it still works
                        booklistWindow.returnBook(title);
                        currentWindow = new SuccessfulReturnWindow(currentWindow);
                        numWaitingOutputs++;
                    }
                    else
                    {
                        currentWindow = new FailedReturnWindow(currentWindow);
                        numWaitingOutputs++;
                    }

                }


            }

        }




    }
}
