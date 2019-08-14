package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private static Library library = Library.filledCollection();
    private static User user = new User("David Benitez", "david.benitez@thoguhtworks.com", 634691525);

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

            if (isLoggedIn()){
                System.out.println("===1.List of books | 2.List of Movies | 3.My information | 4.Logout | 5.Quit===");
                optionSelected = getUserInputAsNumber();
                switch (optionSelected) {
                    case 1:
                        showList();
                        break;
                    case 2:
                        break;
                    case 3:
                        showUserInformation();
                        break;
                    case 4:
                        logout();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        showInvalidOptionMessage();
                        break;
                }
            }else {
                System.out.println("===1.Login | 2.Quit===");
                optionSelected = getUserInputAsNumber();
                switch (optionSelected) {
                    case 1:
                        login();
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
    }

    private static void login(){
        String code;
        String password;

        System.out.println("Type your library number");
        code = getUserInput();
        System.out.println("Type your password");
        password = getUserInput();

        user.login(code, password);
    }

    private static int getUserInputAsNumber() {
        String userInput = getUserInput();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            return -1;
        }
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

    private static boolean isLoggedIn(){
        return user.isLoggetIn();
    }

    private static void logout() {
        user.logout();
    }

    private static void showUserInformation(){
        System.out.println(user);
    }
}
