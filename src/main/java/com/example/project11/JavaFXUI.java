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
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        // scene 1
        Label l1 = new Label("Welcome to the Bicycle collection! Click the button below to continue!");
        Button b1 = new Button("Continue");
        b1.setOnAction(e -> window.setScene(s2));

        VBox layout1 = new VBox(17);
        layout1.getChildren().addAll(l1, b1);
        s1 = new Scene(layout1, 600, 240);

        // scene 2
        Label l2 = new Label("This scene is still unready, click the button to come back");
        Button b2 = new Button("Back");
        b2.setOnAction(e -> window.setScene(s1));

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(b2, l2);
        s2 = new Scene(layout2, 700, 500);

        window.setScene(s1);
        window.setTitle("Bicycle collection");
        window.show();
    }

}
