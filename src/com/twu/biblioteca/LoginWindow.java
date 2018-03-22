package com.twu.biblioteca;

public class LoginWindow extends Window {

    public boolean enteredLibraryNumber = false;
    public LoginWindow()
    {

        setText("Enter library number: ");
    }

    @Override
    public Window putInput(String input)
    {
        if( enteredLibraryNumber)
        {

            return new MessageWindow(new MainMenuWindow(), "Successful login!");
        }


        if (isValidAccountNumber(input))
        {
            setText("Enter password: ");
            enteredLibraryNumber = true;
            return this;
        }



        return super.putInput(input);
    }

    private boolean isValidAccountNumber(String input) {
        if (input.length() != 8) return false;
        if (input.charAt(3)!='-') return false;
        for (int i = 0; i < input.length(); i++)
        {
            if (i!=3 && !(Character.isDigit(input.charAt(i))))
            {
                return false;
            }
        }


        return true;
    }
}
