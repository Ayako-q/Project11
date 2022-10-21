package com.example.project11;

import java.util.Scanner;

// Item class
public class Bicycle {
    // 1.1 Contains public and private members.
    // Contains numeric properties
    // public properties
    public String brand;
    public String model;
    // private properties
    private String type;
    private int modelYear; // numeric properties
    private int kilometersRange;

    // 1.2 Contains getters and setters for private properties
    // setters
    // For type
    public void setType(String type) {
        this.type = type;
    }

    // For model year
    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    // For kilometers range
    public void setKilometersRange(int kilometersRange) {
        this.kilometersRange = kilometersRange;
    }

    // getters

    public String getType() {
        return type;
    }

    // For model year
    public int getModelYear() {
        return modelYear;
    }

    // For kilometers range
    public int getKilometersRange() {
        return kilometersRange;
    }

    // 1.3 method to return detailed formatted information about the item
    public String getDescription() {
        return "\nBrand: " + brand +
                "\nModel: " + model +
                "\nModel year: " + modelYear +
                "\nType: " + type +
                "\nKilometer range: " + kilometersRange;
    }

    // 1.4 method to return short one line item description
    public String getTitle() {
        return "\nThis is " + modelYear + " " + brand + " " + model + "\n";
    }

    // 1.5 other methods
    public float kmPerDay() {
        System.out.println("\nHow long (in months) do you own " + brand + "?");
        return (float) (kilometersRange / getUserInput() / 30.437);
    }

    // Method for taking users input as integer
    public static int getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}