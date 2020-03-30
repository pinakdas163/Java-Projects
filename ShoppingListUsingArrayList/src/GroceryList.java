package com.pinakdas;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void readList() {
        int size = groceryList.size();
        if (size > 0) {
            System.out.println("Items in the list are:");
            for (int i = 0; i < size; i++) {
                System.out.println(groceryList.get(i));
            }
        } else {
            System.out.println("No item found in the grocery list");
        }
    }

    public void addToList(String item) {
        item = item.trim();
        if (item.equals("")) {
            System.out.println("Invalid item");
        } else {
            item = capitalize(item);
            if (findPos(item) != -1) {
                System.out.println("Item " + item + " is already present");
            } else {
                addItem(item);
            }
        }
    }

    private void addItem(String item) {
        boolean add = groceryList.add(item);
        if (add == true) {
            System.out.println("1 item added successfully to the list - " + item);
        } else {
            System.out.println("Item failed to be added - " + item);
        }
    }

    private String capitalize(String item) {
        item = item.trim();
        String firstChar = item.substring(0, 1).toUpperCase();
        String remaining = item.substring(1);
        item =  firstChar + remaining;

        return item;
    }

    public void modifyList(String currentItem, String newItem) {
        int index = findPos(capitalize(currentItem));
        if (index == -1) {
            System.out.println("Item " + currentItem + " not present to be modified");
        } else {
            groceryList.set(index, capitalize(newItem));
            System.out.println("Item " + currentItem + " is updated to " + newItem);
        }
    }

    private int findPos(String item) {
        return groceryList.indexOf(item);
    }

    public void deleteFromList(String item) {
        int index = findPos(capitalize(item));
        if (index == -1) {
            System.out.println("Item " + item + " not present to be deleted");
        } else {
            groceryList.remove(index);
            System.out.println("Item " + item + " is removed from the list");
        }
    }

    public void itemAt(String item) {
        int index = findPos(capitalize(item));
        if (index == -1) {
            System.out.println("Item " + item + " not present in the list");
        } else {
            System.out.println("Item " + item + " has priority " + (index + 1) + " in your list");
        }
    }
}
