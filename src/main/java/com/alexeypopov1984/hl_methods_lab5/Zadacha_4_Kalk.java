package com.alexeypopov1984.hl_methods_lab5;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class Zadacha_4_Kalk {

    private static final TextField fieldNumEnter = new TextField();
    public static void showWindow(Stage owner) {

        Button clearButton = new Button("C");
        clearButton.setOnAction(e -> clear());

        GridPane grid = new GridPane();
        grid.add(clearButton, 0, 4, 4, 1);

        VBox vbox = new VBox(10, fieldNumEnter, grid);
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPadding(new Insets(20));
        Stage stage = new Stage();
        Scene scene = new Scene(vbox, 400, 250);
        stage.setTitle("Калькулятор");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setX((owner.getWidth() - stage.getWidth()) / 2);
        stage.setY((owner.getHeight() - stage.getHeight()) / 2);
    }

    private static void clear() {
        fieldNumEnter.setText("0");
    }

}
