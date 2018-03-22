package com.twu.biblioteca;




import java.util.ArrayList;

public class MainMenuWindow extends MenuWindow {






    public MainMenuWindow() {


        this(null);
    }



    public MainMenuWindow(String user) {



        options = new ArrayList<Option>();
        options.add(new Option("List Books", new BooklistWindow(user)));
        options.add(new Option("List Movies", new MovieListWindow(user)));
        options.add(new Option("Accounts", new AccountsWindow(user)));

        setText();


    }



    /*
    private void addOptions() {

        options = new ArrayList<Option>();
        options.add(new Option("List Books", new BooklistWindow()));
        options.add(new Option("List Movies", new MovieListWindow()));
        options.add(new Option("Accounts", new AccountsWindow()));
    }
    */

}
