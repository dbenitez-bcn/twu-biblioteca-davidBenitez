package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private static Library library = Library.filledCollection();

    public static void main(String[] args) {
        showWelcomeMessage();
        showMenu();
    }

    private static void showWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!");
    }

    private static void showMenu() {
        boolean exit = false;
        while (!exit) {
            int optionSelected;

            System.out.println("===1.List of books | 2.Quit===");
            optionSelected = getUserInputAsNumber();
            switch (optionSelected) {
                case 1:
                    showList();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    showInvalidOptionMessage();
                    break;
            }
        }
    }

    private static int getUserInputAsNumber() {
        String userInput = getUserInput();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
        }
        return -1;
    }

    private static String getUserInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    private static void showList() {
        boolean exit = false;
        while (!exit) {
            int optionSelected;

            library.listBooks();
            System.out.println("\n===1.Checkout a book | 2.Return a book | 3.Back===");
            optionSelected = getUserInputAsNumber();
            switch (optionSelected) {
                case 1:
                    checkoutABook();
                    break;
                case 2:
                    checkinABook();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    showInvalidOptionMessage();
                    break;
            }
        }
    }

    private static void checkoutABook() {
        int bookNumber;

        System.out.println("Type the number of the book to checkout");
        bookNumber = getUserInputAsNumber();
        library.checkOutABook(bookNumber);
    }

    private static void checkinABook() {
        int bookNumber;

        System.out.println("Type the number of the book to checkin");
        bookNumber = getUserInputAsNumber();
        library.checkInABook(bookNumber);
    }

    private static void showInvalidOptionMessage() {
        System.out.println("Please select a valid option!");
    }
}
