package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Library() {

    }

    public Library(ArrayList<Book> books, ArrayList<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public static Library emptyCollection() {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        return new Library(books, movies);
    }

    public static Library filledCollection() {
        ArrayList<Book> books = new ArrayList<Book>(
                Arrays.asList(
                        new Book("Brandom Sanderson", 2009),
                        new Book("Patrick Rothfuss", 1999),
                        new Book("George R.R. Martin", 2019),
                        new Book("Anonymous", 2003),
                        new Book("J.K. Rowling", 2015),
                        new Book("J.R.R. Tolkien", 2004),
                        new Book("Agatha Christie", 2023),
                        new Book("Laura Gallego", 1969),
                        new Book("Stephen King", 1987),
                        new Book("Christie Golden", 2001)
                )
        );

        ArrayList<Movie> movies = new ArrayList<Movie>(
                Arrays.asList(
                        new Movie("Pulp Fiction", 1990, "Tarantino", 10),
                        new Movie("Avengers: End", 2019, "Roussou Brothers", 9),
                        new Movie("Avatar", 2010, "JAmes Cameron", 9),
                        new Movie("Piratas del Caribe", 2017, "Disney", 7)
                )
        );

        return new Library(books, movies);
    }

    public static Library fromArray(Book[] booksList, Movie[] moviesList) {
        ArrayList<Book> books = new ArrayList<Book>(
                Arrays.asList(booksList)
        );

        ArrayList<Movie> movies = new ArrayList<Movie>(
                Arrays.asList(moviesList)
        );

        return new Library(books, movies);
    }

    public int countOfBooks() {
        return this.books.size();
    }

    public int countOfMovies() {
        return this.movies.size();
    }

    public void listBooks() {
        for (int i = 0; i < this.books.size(); i++) {
            if (isBookInLibrary(i)) {
                System.out.println((i + 1) + "." + this.books.get(i));
            }
        }
    }

    public void listMovies() {
        for (int i = 0; i < this.movies.size(); i++) {
            System.out.println((i + 1) + "." + this.movies.get(i));
        }
    }

    private boolean isBookInLibrary(int index) {
        return this.books.get(index).isInLibrary();
    }

    public void checkInABook(int i) {
        int index = getIndexForCheck(i);
        try {
            Book book = this.books.get(index);
            if (!book.isInLibrary()) {
                book.checkin();
                showSuccessMessageCheckinForBook();
            } else {
                showFailureMessageCheckinForBook();
            }
        } catch (Exception e) {
            showFailureMessageCheckinForBook();
        }
    }

    public void checkOutABook(int i) {
        int index = getIndexForCheck(i);
        try {

            Book book = this.books.get(index);
            if (book.isInLibrary()) {
                book.checkout();
                showSuccessMessageCheckoutForBook();
            } else {
                showFailureMessageCheckoutForBook();
            }
        } catch (Exception e) {
            showFailureMessageCheckoutForBook();
        }
    }

    public void checkOutAMovie(int i, String userName){
        int index = getIndexForCheck(i);
        try {
            Movie movie = this.movies.get(index);
            if(movie.isInLibrary()){
                movie.checkout(userName);
                showSuccessMessageCheckoutForMovie();
            }else{
                showFailureMessageCheckinForMovie();
            }
        }catch(Exception e){
            showFailureMessageCheckinForMovie();
        }
    }

    private int getIndexForCheck(int index) {
        return --index;
    }

    private void showSuccessMessageCheckoutForBook() {
        System.out.println("Thank you! Enjoy the book");
    }

    private void showFailureMessageCheckoutForBook() {
        System.out.println("Sorry, that book is not available");
    }

    private void showSuccessMessageCheckinForBook() {
        System.out.println("Thank you for returning the book");
    }

    private void showFailureMessageCheckinForBook() {
        System.out.println("That is not a valid book to return");
    }

    private void showSuccessMessageCheckoutForMovie() {
        System.out.println("Thank you! Enjoy the movie");
    }

    private void showFailureMessageCheckoutForMovie() {
        System.out.println("Sorry, that movie is not available");
    }

    private void showSuccessMessageCheckinForMovie() {
        System.out.println("Thank you for returning the Movie");
    }

    private void showFailureMessageCheckinForMovie() {
        System.out.println("That is not a valid movie to return");
    }
}
