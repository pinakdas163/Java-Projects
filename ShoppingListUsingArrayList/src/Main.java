package com.pinakdas;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Grocery List App:");
        printOptions();
        boolean exit = false;
        GroceryList list = new GroceryList();
        int input = 0;
        while (exit != true) {
            System.out.println("Select an option:");
            if (scanner.hasNextInt() == true) {
                 input = scanner.nextInt();
            } else {
                input = 100;
            }

            scanner.nextLine();
            switch (input) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    list.readList();
                    break;
                case 2:
                    System.out.println("Enter item name:");
                    String it1 = scanner.nextLine();
                    list.addToList(it1);
                    break;
                case 3:
                    System.out.println("Enter current item name:");
                    String currentItem = scanner.nextLine();
                    System.out.println("Enter new item name:");
                    String newItem = scanner.nextLine();
                    list.modifyList(currentItem, newItem);
                    break;
                case 4:
                    System.out.println("Enter item name to delete:");
                    String it2 = scanner.nextLine();
                    list.deleteFromList(it2);
                    break;
                case 5:
                    System.out.println("Enter item name to check:");
                    String it3 = scanner.nextLine();
                    list.itemAt(it3);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input pressed - Try again");
            }
        }
    }

    public static void printOptions() {
        System.out.println("0 - Print Options");
        System.out.println("1 - Read list items");
        System.out.println("2 - Add an item in the list");
        System.out.println("3 - Modify an item in the list");
        System.out.println("4 - Delete an item in the list");
        System.out.println("5 - Check an item exists");
        System.out.println("6 - Exit the application");
    }
}
