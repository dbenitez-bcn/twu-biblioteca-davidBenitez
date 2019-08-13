package com.twu.biblioteca;

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
        for (int i = 0; i < this.collection.size(); i++){
            if(isBookInLibrary(i)){
                System.out.println((i+1) + "." + this.collection.get(i));
            }
        }
    }

    private boolean isBookInLibrary(int index){
        return this.collection.get(index).isInLibrary();
    }

    public void checkIn(int index) {
        try{
            this.collection.get(index).checkin();
            System.out.println("Thank you for returning the book");
        }catch (Exception e){
            System.out.println("That is not a valid book to return");
        }
    }

    public void checkOut(int i) {
        int index = getIndexForCheckout(i);
        try {
            hideBookByIndex(index);
            showSuccessMessage();
        } catch (Exception e) {
            showFailureMessage();
        }
    }

    private Book getBookByIndex(int index) {
        return this.collection.get(index);
    }

    private void hideBookByIndex(int index) {
        this.collection.get(index).checkout();
    }

    private int getIndexForCheckout(int index) {
        return --index;
    }

    private void showSuccessMessage(){
        System.out.println("Thank you! Enjoy the book");
    }

    private void showFailureMessage(){
        System.out.println("Sorry, that book is not available");
    }
}
