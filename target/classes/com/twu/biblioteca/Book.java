package com.twu.biblioteca;

public class Book {
    private String author;
    private int year;
    private boolean checkedIn;

    public Book(String author, int year) {
        this.author = author;
        this.year = year;
        this.checkedIn = true;
    }

    void checkin(){
        this.checkedIn = true;
    }

    public  void checkout(){
        this.checkedIn = false;
    }

    public boolean isInLibrary(){
        return this.checkedIn;
    }

    @Override
    public String toString() {
        return author + " - " + year;
    }


}
