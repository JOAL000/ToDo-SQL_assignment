package org.example;

import java.util.Scanner;

public class UI {

    Scanner scanner = new Scanner(System.in);


    public void start() {

        boolean iterate = true;

        while (iterate) {
            displayMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    itemMenu();
                    break;
                case 2:
                    personMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    iterate = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    protected void displayMenu(){
        System.out.println("Please choose an option:");
        System.out.println("1. TodoItem Menu");
        System.out.println("2. Person Menu");
        System.out.println("3. Exit");
    }

    protected void itemMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Create a new task");
        System.out.println("2. View all tasks");
        System.out.println("3. Update a task");
        System.out.println("4. Delete a task");
        System.out.println("5. Back to main menu");

        int choice = scanner.nextInt();

        boolean iterate = true;
        while (iterate) {
            switch (choice) {
                case 1:
                    // Create a new task
                    break;
                case 2:
                    // View all tasks
                    break;
                case 3:
                    // Update a task
                    break;
                case 4:
                    // Delete a task
                    break;
                case 5:
                    iterate = false;
                    System.out.println("Back...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    protected void personMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Create a new person");
        System.out.println("2. View all persons");
        System.out.println("3. Update a person");
        System.out.println("4. Delete a person");
        System.out.println("5. Exit");
    }
}
