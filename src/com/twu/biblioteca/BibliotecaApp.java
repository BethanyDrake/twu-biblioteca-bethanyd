package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {

        IOManager manager = new IOManager();
        Scanner sc = new Scanner(System.in);









        while (true)
        {

            while (manager.numWaitingOutputs > 0)
            {
                System.out.println(manager.getOutput());
            }


            String input = sc.nextLine();
            manager.putInput(input);


        }





    }



}
