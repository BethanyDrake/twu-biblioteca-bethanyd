package com.twu.biblioteca;

import java.util.ArrayList;

public class AccountsWindow extends MenuWindow{


    public AccountsWindow() {


        addOptions();

        setText();

    }

    public AccountsWindow(String user) {


        addOptions();

        if (user != null)
        {
            options.add(new Option("Account information", new UserInformationWindow(user)));
        }
        setText();

    }

    private void addOptions() {

        options = new ArrayList<Option>();
        options.add(new Option("Login", new LoginWindow()));
        //options.add(new Option("User information", new LoginWindow()));

    }

}
