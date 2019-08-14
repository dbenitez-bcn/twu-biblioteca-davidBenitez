package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;
    private String chekedOutBy;

    public Movie(){

    }

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.chekedOutBy = null;
        if (rating > 10) this.rating = 10;
        else if (rating < 1) this.rating = 1;
        else this.rating = rating;
    }

    public boolean isInLibrary(){
        if (this.chekedOutBy == null) return true;
        return false;
    }

    public void checkin(){
        this.chekedOutBy = null;
    }

    public void checkout(String userName){
        this.chekedOutBy = userName;
    }

    @Override
    public String toString() {
        if(isInLibrary()) return this.name + "(" + year + ") - " + director + ": " +rating;
        return this.name + " is checked out by " + this.chekedOutBy;
    }

}
