package com.example.project11;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Collection {
    private int countOfObjects;
    private Bicycle[] collection;

    public int getCountOfObjects() {
        return countOfObjects;
    }

    // 1. Method for adding a new item
    public void addBike(Bicycle c) {
        Bicycle[] arr = new Bicycle[countOfObjects + 1];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = collection[i];
        }
        arr[countOfObjects] = c;
        collection = arr;
        countOfObjects++;
        System.out.println("\nYour bike has been successfully added");
    }

    // part of ADD method
    public void toBicycleProperties() {
        Bicycle[] arr = new Bicycle[countOfObjects + 1];
        System.out.println("Please, enter you bike info in format: " +
                "\n'Brand' 'Model' 'Model year' 'Type' 'Kilometers range'");
        String i = getUserInput();
        String[] o = i.trim().split("\s+");
        Bicycle b = new Bicycle();
        b.brand = o[0];
        b.model = o[1];
        b.setModelYear(Integer.parseInt(o[2]));
        b.setType(o[3]);
        b.setKilometersRange(Integer.parseInt(o[4]));
        addBike(b);
    }

    // 2. Remove method
    public void remove(int i) {
        if (countOfObjects == 0 || i < 0 || i >= countOfObjects){ // prevent user from removing non-existing element
            System.out.println("Error, this item does not exist");
            return;}
        Bicycle[] newArray = new Bicycle[countOfObjects];
        // copy elements before i to new array
        System.arraycopy(collection, 0, newArray, 0, i);
        countOfObjects--; // decreasing count of objects cuz we have -1 object
        // copy all teh elements after i
        System.arraycopy(collection, i + 1, newArray, i, countOfObjects);
        collection = newArray;
    }
    // 3. Print description for one item
    public void printOne(int i) {
        collection[i].getDescription();
    }

    // 4. Print one line description for each bike
    public void printList() {
        for (Bicycle b : collection) {
            b.getTitle();
        }
    }

    // 5. Print all bikes method
    public void printAll() {
        int index = 0;
        for (Bicycle b : collection) {
            System.out.println("\nBike " + index + ":");
            System.out.println(b.getDescription());
        }
    }

    // 6. Sort by model year method
    public void sortBikes() {
        if (countOfObjects == 0){ // prevent user from sorting empty array
            System.out.println("Error, this array is empty, please, add bikes to it first\n");
            return;}
        boolean isSorted = false;
        int outIterations = 0;
        while (!isSorted) {
            isSorted = true;
            for (int j = 0; j < countOfObjects - outIterations - 1; j++) {
                if (collection[j].getModelYear() > collection[j + 1].getModelYear()) {
                    isSorted = false;
                    Bicycle temp = collection[j];
                    collection[j] = collection[j + 1];
                    collection[j + 1] = temp;
                }
            }
            outIterations++;
        }
        System.out.println("After sorting your collection looks like:");
        printAll();
    }

    // 8. Search by year
    public void searchByYear() {
        System.out.println("\nPlease, enter model year of the bike you're looking for:");
        int year = Integer.parseInt(getUserInput());
        for (Bicycle b : collection) {
            if (b.getModelYear() == year) {
                b.getDescription();
            }
        }
    }

    // Addition functionality
    // Method to output array of objects to file
    public void outputToFile() {
        FileOutputStream myFile = null;
        try {
            myFile = new FileOutputStream("output_data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        PrintWriter myFileWriter = new PrintWriter(myFile);

        for (Bicycle b : collection) {
            myFileWriter.println(b.getDescription());
        }
        System.out.println("Output complete!");
    }

    // Method to read from file
    public void readFile() {
        FileInputStream myFile = null;
        try {
            myFile = new FileInputStream("output_data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner myFileReader = new Scanner(myFile);
        while (myFileReader.hasNextLine()) {
            String current_line = myFileReader.nextLine();
            System.out.println(current_line);
        }
        myFileReader.close();
    }

    public void getKmPerDay(){
        if (countOfObjects == 0){ // if array is empty, prevent from error
            System.out.println("You have no bicycles!\n");
            return;}
        int kilometersPerDay = 0;
        for(Bicycle b : collection){
            kilometersPerDay += b.kmPerDay();
        }
        System.out.println("You ride " + kilometersPerDay + "km per day!");
    }

    // User dialogue part

    public void userInterface() {
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

    public void start() {
        boolean isHere = true;
        while (isHere){
            userInterface();
            String input = getUserInput();
            if (input.equals("1")) {
                printAll();
            } else if (input.equals("2")) {
                toBicycleProperties();
            } else if (input.equals("3")) {
                System.out.println("\nPlease, enter index of element that you would like to delete:");
                int index = Integer.parseInt(getUserInput());
                remove(index);
            } else if (input.equals("4")) {
                sortBikes();
            } else if (input.equals("5")) {
                getKmPerDay();
            } else if (input.equals("6")) {
                searchByYear();
            } else if (input.equals("7")) {
                printAll();
            } else if (input.equals("8")) {
                readFile();
            } else if (input.equals("9")) {
                outputToFile();
            } else if (input.equals("0")){
                isHere = false;
            } else{ System.out.println("\nPlease, try again, this is not a proper answer!\n");}
        }
    }

    public String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
