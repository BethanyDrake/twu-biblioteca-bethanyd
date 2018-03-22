package com.twu.biblioteca;




import java.util.ArrayList;

public class MainMenuWindow extends Window{




    private ArrayList<Option> options;


    public MainMenuWindow()
    {

        options = new ArrayList<Option>();
        options.add(new Option("List Books", new BooklistWindow()));
        options.add(new Option("List Movies", new MovieListWindow()));
        setText();

    }


    private void setText()
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

            if (optionSelected ==1)
            {
                return new BooklistWindow();

            }

            if (optionSelected == 2)
            {
                return new MovieListWindow();
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

    private class Option {


        public final String text;
        public final Window toOpen;

        public Option(String text, Window toOpen) {
            this.text = text;
            this.toOpen = toOpen;

        }
    }
}
