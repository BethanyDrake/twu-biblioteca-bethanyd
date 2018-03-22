package com.twu.biblioteca;

import java.util.ArrayList;

public class AccountsWindow extends MenuWindow{


    public AccountsWindow() {


        addOptions();

        setText();

    }

    private void addOptions() {

        options = new ArrayList<Option>();
        options.add(new Option("Login", new LoginWindow()));

    }

}
