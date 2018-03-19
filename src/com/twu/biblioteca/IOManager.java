package com.twu.biblioteca;

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



        numWaitingOutputs--;
        return output;
    }

    public void putInput(Input input) {
        if (input == Input.ADVANCE) currentWindow = new BooklistWindow();


    }

}
