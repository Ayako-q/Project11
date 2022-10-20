package com.example.project11;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Collection collection = new Collection();
        collection.start();
    }

    public static String getUserInput(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }


}
