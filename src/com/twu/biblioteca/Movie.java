package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean chekedIn;

    public Movie(){

    }

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.chekedIn = true;
        if (rating > 10) this.rating = 10;
        else if (rating < 1) this.rating = 1;
        else this.rating = rating;
    }

    public boolean isInLibrary(){
        return this.chekedIn;
    }

    public void checkin(){
        this.chekedIn = true;
    }

    public void checkout(){
        this.chekedIn = false;
    }

    @Override
    public String toString() {
        return this.name + "(" + year + ") - " + director + ": " +rating;
    }

}
