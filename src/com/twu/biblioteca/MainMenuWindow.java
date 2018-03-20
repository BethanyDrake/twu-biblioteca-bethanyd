package com.twu.biblioteca;

public class MainMenuWindow extends Window{



    public int numOptions = 1;
    public MainMenuWindow()
    {

        setText("(1) List Books\n");

    }

    @Override
    public Window putInput(String input)
    {
        if (isNumeric(input))
        {
            int optionSelected = Integer.parseInt(input);

            if (optionSelected ==1)
            {
                return new BooklistWindow();

            }

        }
        return super.putInput(input);
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
