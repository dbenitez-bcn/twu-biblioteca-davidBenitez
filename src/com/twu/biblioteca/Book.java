package com.twu.biblioteca;

public class Book {
    private String author;
    private int year;

    public Book(String author, int year) {
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return author + " - " + year;
    }
}
