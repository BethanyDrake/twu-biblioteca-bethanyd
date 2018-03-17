package com.twu.biblioteca;

import java.util.Scanner;

public class Console {
    public Window currentWindow;

    public Console()
    {
        new WelcomeWindow(this);

        Scanner sc = new Scanner(System.in);
        while (true)
        {
            String input = sc.nextLine();
            if (input.equals(""))
            {
                currentWindow.advance();
            }



        }

    }
}
