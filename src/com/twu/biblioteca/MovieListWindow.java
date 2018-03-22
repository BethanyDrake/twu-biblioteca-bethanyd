package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieListWindow extends ItemListWindow {

    private void setDefaultMovieListlist() {
        ArrayList<Item> movieList = new ArrayList<Item>();
        checkedOutItems = new ArrayList<Item>();
        movieList.add(new Movie("Avatar", 2009, "James Cameron", 6));
        movieList.add(new Movie("Incredibles", 2018, "Brad Bird"));

        movieList.add(new Movie("Titanic", 1997, "James Cameron", 8));

        this.items = movieList;
        setText();

    }

    public MovieListWindow() {

        setDefaultMovieListlist();


    }
}