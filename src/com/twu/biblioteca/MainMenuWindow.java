package com.twu.biblioteca;

public class MainMenuWindow extends Window{



    public int numOptions = 1;
    public MainMenuWindow()
    {
        super();

        setText("List Books\n");

    }

    @Override
    public boolean isValidCommand(String input) {


        if (isNumeric(input) )
        {
            int option = Integer.parseInt(input);
            if (option >0 && option <=numOptions)
            {
                return true;
            }


        }
        return super.isValidCommand(input);
    }

    private boolean isNumeric(String string)
    {
        if (string == "") return false;
        for (char c : string.toCharArray())
        {
            if (!Character.isDigit(c))
            {
                return false;
            }
        }
        return true;
    }
}
