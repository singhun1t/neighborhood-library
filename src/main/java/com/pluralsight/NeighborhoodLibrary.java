package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {
        Book[] library = new Book[5];
        library[0] = new Book("The Hitchhiker's Guide to the Galaxy", "1-123-12", 1);
        library[1] = new Book("Dune", "9-842-37", 2);
        library[2] = new Book("The Hobbit", "8-123-234", 3);
        library[3] = new Book("Lord of the Rings", "7-546-978", 4);
        library[4] = new Book("Huckleberry Finn", "4-954-654", 5);

        Scanner scanner = new Scanner(System.in);




        boolean active = true;
        while (active) {
            System.out.println("\n Show Available Books");
            System.out.println(" Show Checked Out Books");
            System.out.println(" Exit- close out of application");
            System.out.println("Choose an option(1-3)");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAvailableBooks(library);
                    break;
                case 2:
                    showCheckedOutBooks(library);
                    break;
                case 3:
                    active = false;
                    System.out.println("you have exited the application");
                    break;
                default:
                    System.out.println("Invalid selection");


            }
        }


    }

    private static void showAvailableBooks(Book[] library) {
        System.out.println("Availabe books:");
        boolean availableBooks = false;
        boolean exitToMenu = false;
        for (Book book : library) {

            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + " Title: " + book.getTitle() + " ISBN " + book.getIsbn());
                availableBooks = true;
            }

            // scanner = new Scanner(System.in);


            /*else book.checkOut(input);
           if (exitToMenu){
               break;
           }

             */
        }
        if (!availableBooks) {
            System.out.println("There are no available books to check out");

        }
        System.out.println("Enter name of the book you want to check out, or enter X to exit");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("x")) {
            return;
        }
        System.out.println("What is your Name:");

        String userName = scanner.nextLine();
        for(Book book : library){
            if (book.getTitle().equalsIgnoreCase(input)){
                book.checkOut(userName);
            }

        }

    }


    private static void showCheckedOutBooks(Book[] library) {
        System.out.println("checked out books: ");
        boolean checkedOut = false;
        for (Book book : library) {

            if (book.isCheckedOut()) {
                checkedOut = true;
                System.out.println("ID: " + book.getId() + " Title: " + book.getTitle() + " ISBN " + book.getIsbn() + " checked out to: " + book.getCheckedOutTo());
            }

        }
        if (!checkedOut) {
            System.out.println("No books have currently been checked out");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'C' to check in a book or Type X to go back to the home Screen");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("X")) {
            return;
        } else if (input.equalsIgnoreCase("C")) {
            checkInBook(library);
        }
    }

    private static void checkInBook(Book[] library) {

        while (true) {
            System.out.println("Enter the ID for the book you want to check in");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            for (Book book : library) {
                if (input == book.getId() && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("The book " + book.getTitle() + "has been checked in");
                    return;
                }
            }
            System.out.println("Book not found or possbily already checked in");
        }


    }

}


