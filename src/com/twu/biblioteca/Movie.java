package com.twu.biblioteca;

public class Movie extends Item{

    public String director;

    public int year;

    public int rating = -1;
    public boolean hasRating;

    public Movie (String name, int year, String director, int rating)
    {
        this.title = name;
        this.director= director;
        this.year = year;
        this.rating = rating;
        this.hasRating = true;
    }

    public Movie (String name, int year, String director)
    {
        this.title = name;
        this.director = director;
        this.year = year;
        this.hasRating = false;
    }

    public String toString()
    {

        String text = title + ", " + year + ", " + director + ", ";
        if (hasRating) text += rating;
        else text += "unrated";
        return text;
    }
}
