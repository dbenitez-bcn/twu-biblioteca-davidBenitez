package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        showWelcomeMessage();
        showMenu();
    }

    private static void showWelcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!");
    }

    private static void showMenu(){
        boolean exit = false;
        while(!exit){
            int optionSelected;

            System.out.println("===1.List of books | 2.Quit===");
            optionSelected = getMenuOption();
            switch (optionSelected){
                case 1:
                    showList();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Please select a valid option!");
            }
        }
    }

    private static int getMenuOption(){
        String userInput = getUserInput();
        try{
            return Integer.parseInt(userInput);
        }catch (Exception e){
        }
        return -1;
    }

    private static String getUserInput(){
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    private static void showList(){
        Library library = Library.filledCollection();
        boolean exit = false;
        while (!exit){
            int optionSelected;

            library.showList();
            System.out.println("\n===1.Checkout a book | 2.Return a book | 3.Back===");
            optionSelected = getMenuOption();


        }
    }
}
