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
        Bicycle[] arr = new Bicycle[countOfObjects + 1]; // manually creating a new array with +1 size
        for (int i = 0; i < arr.length - 1; i++) { // looping trough this array to copy old elements to a new array
            arr[i] = collection[i];
        }
        arr[countOfObjects] = c; // adding new element to an array
        collection = arr; // new value for collection
        countOfObjects++; // increasing this value cuz we have now one more item in collection
        System.out.println("\nYour bike has been successfully added");
    }

    // part of ADD method
    public void toBicycleProperties() {
        try{
            Bicycle[] arr = new Bicycle[countOfObjects + 1];
            System.out.println("Please, enter you bike info in format: " +
                    "\n'Brand' 'Model' 'Model year' 'Type' 'Kilometers range'");
            String i = getUserInput();
            String[] o = i.trim().split("\s+"); // dividing input string into array elements
            Bicycle b = new Bicycle(); // creating a new object to save it
            b.brand = o[0]; // assigning values to bicycle properties
            b.model = o[1];
            b.setModelYear(Integer.parseInt(o[2])); // using setters cuz these three properties are private
            b.setType(o[3]);
            b.setKilometersRange(Integer.parseInt(o[4]));
            addBike(b); // going to method that will add my item to collection
        } catch(Exception e) {
            System.out.println("Error! Please check if you've done everything right!\n");
        }
    }

    // 2. Remove method
    public void remove(int i) {
        if (countOfObjects == 0 || i < 0 || i >= countOfObjects) { // prevent user from removing non-existing element
            System.out.println("Error, this item does not exist");
            return;
        }
        Bicycle[] newArray = new Bicycle[countOfObjects - 1];
        // copy elements before i to new array
        System.arraycopy(collection, 0, newArray, 0, i);
        countOfObjects--; // decreasing count of objects cuz we have -1 object
        // copy all teh elements after i
        System.arraycopy(collection, i - 1, newArray, i, countOfObjects - 1);
        collection = newArray;
    }

    // 3. Print description for one item
    public void printOne(int i) {
        collection[i].getDescription();
    }

    // 4. Print one line description for each bike
    public void printList() {
        for (Bicycle b : collection) { // improved for loop
            System.out.println(b.getTitle());
        }
    }

    // 5. Print all bikes method
    public void printAll() {
        if (countOfObjects == 0) { // prevention from error
            System.out.println("Error, add bikes to your collection first!");
            return;
        }
        int index = 0; // index variable so user will know what is number of element in collection array
        for (Bicycle b : collection) {
            System.out.println("\nBike " + index + ":");
            System.out.println(b.getDescription() + "\n");
            index++;
        }
    }

    // 6. Sort by model year method
    public void sortBikes() {
        // simple sort method as we have used already many times
        if (countOfObjects == 0) { // prevent user from sorting empty array
            System.out.println("Error, this array is empty, please, add bikes to it first\n");
            return;
        }
        boolean isSorted = false;
        int outIterations = 0;
        while (!isSorted) {
            isSorted = true;
            for (int j = 0; j < countOfObjects - outIterations - 1; j++) {
                if (collection[j].getModelYear() > collection[j + 1].getModelYear()) {
                    isSorted = false; // optimized inner loop
                    Bicycle temp = collection[j];
                    collection[j] = collection[j + 1];
                    collection[j + 1] = temp;
                }
            }
            outIterations++; // optimized outer loop
        }
        System.out.println("After sorting your collection looks like:");
        printAll(); // output user collection after sorting
    }

    // 8. Search by year
    public void searchByYear() {
        System.out.println("\nPlease, enter model year of the bike you're looking for:");
        int year = Integer.parseInt(getUserInput());
        System.out.println("\nFound results:");
        for (Bicycle b : collection) {
            if (b.getModelYear() == year) {
                System.out.println(b.getDescription());
            }
        }
    }

    // Addition functionality
    // Method to output array of objects to file
    public void outputToFile() {
        try {
            FileWriter myWriter = new FileWriter("output_data.txt"); // Creating a new file writer
            for (Bicycle b : collection) // An improved for loop that goes through each bike
            {
                myWriter.write(b.getDescription()); // Writing the string to txt file
                myWriter.write(" "); // Writes new line, so that code looks better
            }
            myWriter.close(); // Closing the writer
            System.out.println("Output successful!");
        } catch (IOException e) // Catching errors if there are some
        {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    // Method to read from file
    public void readFile() {
        try {
            FileInputStream myFile = null;
            try {
                myFile = new FileInputStream("output_data.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Scanner myFileReader = new Scanner(myFile);
            while (myFileReader.hasNextLine()) { // if we have a new line - go further
                String current_line = myFileReader.nextLine(); // Gives data from current line to variable
                System.out.println(current_line); // prints that line from variable where we store it
            }
            myFileReader.close(); // closing reader}
        } catch (Exception e){
            System.out.println("Sorry, the file you want to read from doesn't exist\n");
        }
    }

    public void getKmPerDay() {
        if (countOfObjects == 0) { // if array is empty, prevent from error
            System.out.println("You have no bicycles!\n");
            return;
        }
        float kilometersPerDay = 0; // variable that contains average KM per day
        for (Bicycle b : collection) { // Using improved for loop
            kilometersPerDay += b.kmPerDay();
        }
        System.out.println("You ride " + kilometersPerDay + " km per day!");
    }
    public String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();}
}
