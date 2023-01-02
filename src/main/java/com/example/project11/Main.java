package com.example.project11;

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
public class Main{
    public static void main(String[] args){
        Collection collection = new Collection();
        start(collection);
    }
    public static void userInterface() {
        System.out.println("""
                ====== Bike database ======
                Choose an option to proceed:
                1 - print bike list
                2 - add new bike
                3 - remove bike
                4 - sort bikes by model year
                5 - count average km count per day
                6 - search bikes by year
                7 - print detailed bike list
                8 - read bikes from the file
                9 - save bikes to the file
                0 - exit the program
                """);
    }

    public static void start(Collection c) {
        boolean isHere = true;
        while (isHere) {
            userInterface();
            String input = getUserInput();
            if (input.equals("1")) {
                c.printList();
            } else if (input.equals("2")) {
                c.toBicycleProperties();
            } else if (input.equals("3")) {
                System.out.println("\nPlease, enter index of element that you would like to delete:");
                int index = Integer.parseInt(getUserInput());
                c.remove(index);
            } else if (input.equals("4")) {
                c.sortBikes();
            } else if (input.equals("5")) {
                c.getKmPerDay();
            } else if (input.equals("6")) {
                c.searchByYear();
            } else if (input.equals("7")) {
                c.printAll();
            } else if (input.equals("8")) {
                c.readFile();
            } else if (input.equals("9")) {
                c.outputToFile();
            } else if (input.equals("0")) {
                System.out.println("\nNo problem, goodbye!");
                isHere = false;
            } else {
                System.out.println("\nPlease, try again, this is not a proper answer!\n");
            }
        }
    }
    public static String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
