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
    private static final TextField textFieldForNums = new TextField();
    private static double firstNumber = 0;
    private static String thisOperation = "";
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


        Button plusButton = new Button("+");
        plusButton.setOnAction(e -> setOperation("+"));

        Button minusButton = new Button("-");
        minusButton.setOnAction(e -> setOperation("-"));

        Button multButton = new Button("*");
        multButton.setOnAction(e -> setOperation("*"));

        Button divButton = new Button("/");
        divButton.setOnAction(e -> setOperation("/"));

        Button equalsButton = new Button("=");
        equalsButton.setOnAction(e -> equals());


        grid.add(numberButtons[0], 0, 0);
        grid.add(numberButtons[1], 1, 0);
        grid.add(numberButtons[2], 2, 0);

        grid.add(numberButtons[3], 0, 1);
        grid.add(numberButtons[4], 1, 1);
        grid.add(numberButtons[5], 2, 1);

        grid.add(numberButtons[6], 0, 2);
        grid.add(numberButtons[7], 1, 2);
        grid.add(numberButtons[8], 2, 2);

        grid.add(clearButton, 0, 3);
        grid.add(plusButton, 1, 3);
        grid.add(minusButton, 2, 3);

        //grid.add(clearButton, 0, 4, 4, 1);

        VBox vbox = new VBox(10, textFieldForNums, grid, equalsButton, multButton, divButton);
        vbox.setAlignment(Pos.CENTER);
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

    private static void equals() {

        double secondNumber = Double.parseDouble(textFieldForNums.getText());
        double result = 0;

        switch (thisOperation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    textFieldForNums.setText("Ошибка: деление на 0");
                    return;
                }
                result = firstNumber / secondNumber;
                break;
        }

        textFieldForNums.setText(String.valueOf(result));
        startNewNumber = true;
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
        thisOperation = "";
        startNewNumber = true;
    }

    private static void setOperation(String operation) {
        firstNumber = Double.parseDouble(textFieldForNums.getText());
        thisOperation = operation;
        startNewNumber = true;
    }
}
