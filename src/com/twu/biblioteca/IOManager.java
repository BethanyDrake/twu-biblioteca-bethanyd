package com.twu.biblioteca;

import java.util.Scanner;

public class IOManager {
    public Window currentWindow;

    public IOManager()
    {
        currentWindow =  new WelcomeWindow();
        /*
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            String input = sc.nextLine();
            if (input.equals(""))
            {
                currentWindow.advance();
            }



        }
        */

    }

    public String getOutput()
    {
        return currentWindow.getText();
    }
}
