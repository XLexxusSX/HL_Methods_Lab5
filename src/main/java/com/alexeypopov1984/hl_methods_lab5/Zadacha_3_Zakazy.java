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

public class Zadacha_3_Zakazy {
    public static void showWindow(Stage owner) {

        Stage stage = new Stage();

        String[] foods = {"Буханка хлеба", "Сырок", "Пузырь", "Соль", "Чеснок"};
        double[] prices = {0.14, 0.13, 5.52, 0.1, 3.5};

        CheckBox[] checkBoxes = new CheckBox[foods.length];
        TextField[] textFieldkolvo = new TextField[foods.length];

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPadding(new Insets(20));

        for (int i = 0; i < foods.length; i++) {
            checkBoxes[i] = new CheckBox();
            checkBoxes[i].setText(foods[i] + " - " + prices[i] + " руб.");
            checkBoxes[i].setPrefWidth(250);

            textFieldkolvo[i] = new TextField();
            textFieldkolvo[i].setText("1");
            textFieldkolvo[i].setPrefWidth(30);

            HBox hbox = new HBox(10, checkBoxes[i], textFieldkolvo[i], new Label("шт."));
            hbox.setAlignment(Pos.CENTER_LEFT);
            vbox.getChildren().add(hbox);
        }

        Button orderButton = new Button("Заказать");
        orderButton.setOnAction(e -> chek(stage, checkBoxes, textFieldkolvo, foods, prices));
        vbox.getChildren().add(orderButton);

        Scene scene = new Scene(vbox, 400, 250);
        stage.setTitle("Заказ в ресторане");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setX((owner.getWidth() - stage.getWidth()) / 2);
        stage.setY((owner.getHeight() - stage.getHeight()) / 2);
    }

    private static void chek(Stage owner, CheckBox[] chb, TextField[] tf, String[] foods, double[] prices) {
        String chekZaHavku = "";
        double total = 0;

        for (int i = 0; i < foods.length; i++) {
            if (chb[i].isSelected()) {
                int kolvo = Integer.parseInt(tf[i].getText());
                double generalPrice = prices[i] * kolvo;
                generalPrice = Math.round(generalPrice * 100) / 100.0;
                chekZaHavku += foods[i] + " - " + kolvo + " шт. - " + generalPrice + " руб.\n";
                total += generalPrice;
                total = Math.round(total * 100) / 100.0;
            }
        }

        if (total != 0) {
            {
                total = Math.round(total * 100) / 100.0;
                chekZaHavku += "\nИтого: " + total + " руб.";
            }

            Stage stage = new Stage();
            stage.setTitle("Чек");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(owner);
            stage.setResizable(false);

            TextArea textArea = new TextArea(chekZaHavku);
            textArea.setMinHeight(144);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            VBox vbox = new VBox(textArea);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(3));

            Scene scene = new Scene(vbox, 300, 150);
            stage.setScene(scene);
            stage.show();
            stage.setX((owner.getWidth() - stage.getWidth()) / 2 + owner.getX());
            stage.setY((owner.getHeight() - stage.getHeight()) / 2 + owner.getY());
        }
    }
}