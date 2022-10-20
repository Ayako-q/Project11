package com.example.project11;

import java.io.*;
import java.util.Scanner;

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
        System.out.println("\nYour camera has been successfully added");
    }

    // part of ADD method
    public void toBicycleProperties() {
        System.out.println("Please, enter you bike info in format: " +
                "\n'Brand' 'Model' 'Model year' 'Type' 'Kilometers range'");
        String i = getUserInput();
        String[] o = i.trim().split("\s+");
        for (Bicycle b : collection) {
            b.brand = o[0];
            b.model = o[1];
            b.setModelYear(Integer.parseInt(o[2]));
            b.setType(o[3]);
            b.setKilometersRange(Integer.parseInt(o[4]));
        }
        Bicycle bike = new Bicycle();
        addBike(bike);
    }

    // 2. Remove method
    public void remove(int i) {
        collection[i] = null;
        /*Collection newColl = new Collection();
        for(Bicycle b : collection){
            if(b != null){
                newColl.addBike(b);
            }*/
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
        for (Bicycle b : collection) {
            b.getDescription();
        }
    }

    // 6. Sort by model year method
    public void sortBikes() {
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
            }
            isHere = false;
        }
    }

    public String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
