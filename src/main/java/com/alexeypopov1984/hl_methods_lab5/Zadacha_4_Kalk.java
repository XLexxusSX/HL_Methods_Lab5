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

        Button[] numberButtons = new Button[10];

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            int num = i;
            numberButtons[i].setOnAction(e -> appendNum(String.valueOf(num)));
            numberButtons[i].setMinWidth(40);
        }

        Button clearButton = new Button("C");
        clearButton.setOnAction(e -> clear());
        clearButton.setMinWidth(40);

        Button dotButton = new Button(".");
        dotButton.setOnAction(e -> appendNum("."));
        dotButton.setMinWidth(40);

        Button plusButton = new Button("+");
        plusButton.setOnAction(e -> setOperation("+"));
        plusButton.setMinWidth(40);

        Button minusButton = new Button("-");
        minusButton.setOnAction(e -> setOperation("-"));
        minusButton.setMinWidth(40);

        Button multButton = new Button("*");
        multButton.setOnAction(e -> setOperation("*"));
        multButton.setMinWidth(40);

        Button divButton = new Button("/");
        divButton.setOnAction(e -> setOperation("/"));
        divButton.setMinWidth(40);

        Button equalsButton = new Button("=");
        equalsButton.setOnAction(e -> equals());
        equalsButton.setMinWidth(40);

        Button plusMinusButton = new Button("+/-");
        plusMinusButton.setOnAction(e -> plusMinus());
        plusMinusButton.setMinWidth(40);

        GridPane grid = new GridPane();
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setAlignment(Pos.CENTER);

        grid.add(numberButtons[7], 0, 0);
        grid.add(numberButtons[8], 1, 0);
        grid.add(numberButtons[9], 2, 0);
        grid.add(divButton,        3, 0);

        grid.add(numberButtons[4], 0, 1);
        grid.add(numberButtons[5], 1, 1);
        grid.add(numberButtons[6], 2, 1);
        grid.add(multButton,       3, 1);

        grid.add(numberButtons[1], 0, 2);
        grid.add(numberButtons[2], 1, 2);
        grid.add(numberButtons[3], 2, 2);
        grid.add(minusButton,      3, 2);

        grid.add(plusMinusButton,  0, 3);
        grid.add(numberButtons[0], 1, 3);
        grid.add(dotButton,        2, 3);
        grid.add(plusButton,       3, 3);

        grid.add(clearButton, 0, 4);

//        gridSec.add(equalsButton, 0, 0);
//        gridSec.add(multButton, 1, 0);
//        gridSec.add(divButton, 2, 0);
//        gridSec.add(dotButton, 3, 0);
//        gridSec.add(plusMinusButton, 4, 0);

        //grid.add(clearButton, 0, 4, 4, 1);

        VBox vbox = new VBox(10, textFieldForNums, grid);
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
    
    private static void plusMinus(){
        String currentText = textFieldForNums.getText();
        if (!currentText.equals("0")) {
            if (currentText.startsWith("-")) {
                textFieldForNums.setText(currentText.substring(1));
            } else {
                textFieldForNums.setText("-" + currentText);
            }
        }
    }
}
