package com.twu.biblioteca;




import java.util.ArrayList;

public class MainMenuWindow extends MenuWindow {


    private ArrayList<Option> options;


    public MainMenuWindow() {


        addOptions();

        setText();

    }

    private void addOptions() {

        options = new ArrayList<Option>();
        options.add(new Option("List Books", new BooklistWindow()));
        options.add(new Option("List Movies", new MovieListWindow()));
        options.add(new Option("Accounts", new AccountsWindow()));
    }


}
