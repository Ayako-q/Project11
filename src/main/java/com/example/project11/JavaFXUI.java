package com.example.project11;

/* Massage for Valentyna, Vladyslav, Sergiy
this is test part of my project
while I have no more assignments
I want to try myself in JavaFX
I believe there will be no issues with it
 */

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Project 11");
        Button button = new Button();
        button.setText("Davai clikai");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 720, 360);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}