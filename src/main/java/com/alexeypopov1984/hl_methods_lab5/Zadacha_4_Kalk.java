package com.alexeypopov1984.hl_methods_lab5;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.geometry.Insets;

import javafx.stage.Stage;

public class Zadacha_4_Kalk {
    private static TextField textFieldForNums = new TextField();
    private static double firstNumber = 0;
    private static String operation = "";
    private static boolean startNewNumber = true;

    public static void showWindow(Stage owner) {

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        Button[] numberButtons = new Button[10];

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            int num = i;
            numberButtons[i].setOnAction(e -> appendNum(String.valueOf(num)));
        }

        Button clearButton = new Button("C");
        clearButton.setOnAction(e -> clear());

        grid.add(numberButtons[0], 0, 0);
        grid.add(numberButtons[1], 1, 0);
        grid.add(numberButtons[2], 2, 0);

        VBox vbox = new VBox(10, textFieldForNums, grid, clearButton);
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

    private static void appendNum (String num){
        if (startNewNumber) {
            textFieldForNums.setText(num);
            startNewNumber = false;
        } else {
            textFieldForNums.setText(textFieldForNums.getText() + num);
        }
    }

    private static void clear() {
        textFieldForNums.setText("0");
        firstNumber = 0;
        operation = "";
        startNewNumber = true;
    }
}
