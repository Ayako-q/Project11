package com.example.project11;

/* Massage for Valentyna, Vladyslav, Sergiy
this is a test part of my project
while I have no more assignments
I want to try myself in JavaFX
I believe there will be no issues with it
 */

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXUI extends Application {

    Stage window;
    Scene s1, s2;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        // scene 1
        Label l1 = new Label("Welcome to the Bicycle collection!\nClick the button below to continue!");
        Button b1 = new Button("Continue");
        b1.setOnAction(e -> window.setScene(s2));

        VBox layout1 = new VBox(17);
        layout1.getChildren().addAll(l1, b1);
        s1 = new Scene(layout1, 600, 240);

        // scene 2
        Label l2 = new Label("This scene is still unready\n click the button to come back");
        Label l3 = new Label("Woops, it didn't work, try again later, I will fix it!");
        Button printList = new Button("Print bike list");
        Button add = new Button("Add");
        Button remove = new Button("Remove");
        Button sort = new Button("Sort");
        Button avg = new Button("AVG kmpd");
        Button search = new Button("Search");
        Button print = new Button("Show all");
        Button read = new Button("Read");
        Button save = new Button("Save");
        Button b2 = new Button("Back");
        b2.setOnAction(e -> window.setScene(s1));

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(l2, printList, add, remove, sort, avg, search, print, read, save, b2);
        s2 = new Scene(layout2, 600, 600);
        printList.setOnAction(e -> layout2.getChildren().add(l3));

        window.setScene(s1);
        window.setTitle("Bicycle collection");
        window.show();
    }

}
