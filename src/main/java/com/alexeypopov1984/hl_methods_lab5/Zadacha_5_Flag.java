package com.alexeypopov1984.hl_methods_lab5;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;

public class Zadacha_5_Flag {

    private static String selectedColor1 = null;
    private static String selectedColor2 = null;
    private static String selectedColor3 = null;

    public static void showWindow(Stage owner) {

        Button drawButton = new Button("Нарисовать");
        Label resultLabel = new Label("Выберите цвета и нажмите \"Нарисовать\":");

        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();

        String[] colors = {"Оранжевый", "Зелёный", "Синий", "Красный", "Фиолетовыый"};

        VBox vboxPolosa1 = new VBox(5);
        vboxPolosa1.getChildren().add(new Label("Полоса 1:"));
        for (String color : colors) {
            RadioButton rb = new RadioButton(color);
            rb.setToggleGroup(group1);
            rb.setOnAction(e -> selectedColor1 = rb.getText());
            vboxPolosa1.getChildren().add(rb);
        }

        VBox vboxPolosa2 = new VBox(5);
        vboxPolosa2.getChildren().add(new Label("Полоса 2:"));
        for (String color : colors) {
            RadioButton rb = new RadioButton(color);
            rb.setToggleGroup(group2);
            rb.setOnAction(e -> selectedColor2 = rb.getText());
            vboxPolosa2.getChildren().add(rb);
        }

        VBox vboxPolosa3 = new VBox(5);
        vboxPolosa3.getChildren().add(new Label("Полоса 3:"));
        for (String color : colors) {
            RadioButton rb = new RadioButton(color);
            rb.setToggleGroup(group3);
            rb.setOnAction(e -> selectedColor3 = rb.getText());
            vboxPolosa3.getChildren().add(rb);
        }

        drawButton.setOnAction(e -> {
            if (selectedColor1 != null && selectedColor2 != null && selectedColor3 != null) {
                String flag = selectedColor1 + ", " + selectedColor2 + ", " + selectedColor3;
                resultLabel.setText("Флаг: " + flag);
            } else {
                resultLabel.setText("Выберите цвет для каждой полосы!");
            }
        });

        HBox polosyBox = new HBox(20, vboxPolosa1, vboxPolosa2, vboxPolosa3);
        polosyBox.setAlignment(Pos.CENTER);

        VBox mainBox = new VBox(20, polosyBox, resultLabel, drawButton);
        mainBox.setAlignment(Pos.CENTER);

        Stage stage = new Stage();
        Scene scene = new Scene(mainBox, 380, 265);
        stage.setTitle("Текстовый флаг");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setX((owner.getWidth() - stage.getWidth()) / 2 + 40);
        stage.setY((owner.getHeight() - stage.getHeight()) / 2 + 40);
    }
}
