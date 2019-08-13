package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    private ArrayList<Book> collection;

    public Library() {

    }

    public Library(ArrayList<Book> collection) {
        this.collection = collection;
    }

    public static Library emptyCollection() {
        ArrayList<Book> books = new ArrayList<Book>();
        return new Library(books);
    }

    public static Library filledCollection() {
        ArrayList<Book> books = new ArrayList<Book>(
                Arrays.asList(
                        new Book("Brandom Sanderson", 2009),
                        new Book("Patrick Rothfuss", 1999),
                        new Book("George R.R. Martin", 2019),
                        new Book("Anonymous", 2003),
                        new Book("J.K. Rowling", 2009),
                        new Book("J.R.R. Tolkien", 2009),
                        new Book("Agatha Christie", 2009),
                        new Book("Laura Gallego", 2009),
                        new Book("Stephen King", 2009),
                        new Book("Christie Golden", 2009)
                )
        );

        return new Library(books);
    }

    public static Library fromArray(Book[] list) {
        ArrayList<Book> books = new ArrayList<Book>(
                Arrays.asList(list)
        );

        return new Library(books);
    }

    public int countOfBooks() {
        return this.collection.size();
    }

    public void showList() {
        for (Book book : this.collection) System.out.println(book);
    }

    public void checkIn(Book book){
        this.collection.add(book);
    }
}
