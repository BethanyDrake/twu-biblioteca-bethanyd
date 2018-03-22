package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuWindow extends Window {

    public ArrayList<Option> options;





    public void setText()
    {
        String text = "";
        int i = 1;
        for (Option opt : options)
        {
            text += "("+i+") " + opt.text + "\n";
            i++;
        }
        super.setText(text);

    }

    @Override
    public Window putInput(String input)
    {

        if (isNumeric(input))
        {
            int optionSelected = Integer.parseInt(input);

            if (optionSelected <= options.size())
            {
                return (options.get(optionSelected-1).toOpen);
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

    public class Option {


        public final String text;
        public final Window toOpen;

        public Option(String text, Window toOpen) {
            this.text = text;
            this.toOpen = toOpen;

        }
    }
}
