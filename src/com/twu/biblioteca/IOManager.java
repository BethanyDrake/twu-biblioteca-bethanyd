package com.twu.biblioteca;


public class IOManager {


    public Window currentWindow;
    public int numWaitingOutputs = 0;


    public String currentUser;

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

        else if (currentWindow instanceof ExitWindow)
        {
            System.exit(0);
        }

        else if (currentWindow instanceof LoginWindow)
        {
            LoginWindow loginWindow = ((LoginWindow) currentWindow);

            if (loginWindow.isLoggedIn)
            {
                currentUser = loginWindow.libraryNumber;
                currentWindow = new MainMenuWindow(currentUser);
                numWaitingOutputs++;

            }
        }

        numWaitingOutputs--;
        return output;


    }


    public void putInput(String input)
    {


        Window newWindow = currentWindow.putInput(input);
        if (newWindow != null)
        {
            currentWindow = newWindow;
            numWaitingOutputs++;
        }




    }
}
