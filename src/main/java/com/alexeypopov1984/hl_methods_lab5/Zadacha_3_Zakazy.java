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


        CheckBox checkBox1 = new CheckBox(foods[0] + " - " + prices[0] + " руб.");
        CheckBox checkBox2 = new CheckBox(foods[1] + " - " + prices[1] + " руб.");
        CheckBox checkBox3 = new CheckBox(foods[2] + " - " + prices[2] + " руб.");


        TextField quantity1 = new TextField("1");
        TextField quantity2 = new TextField("1");
        TextField quantity3 = new TextField("1");


        Button orderButton = new Button("Заказать");
        orderButton.setOnAction(e -> chek(stage, checkBox1, checkBox2, checkBox3, quantity1, quantity2, quantity3, foods, prices));


        HBox hbox1 = new HBox(10, checkBox1, new Label("Количество:"), quantity1);
        hbox1.setAlignment(Pos.CENTER_LEFT);

        HBox hbox2 = new HBox(10, checkBox2, new Label("Количество:"), quantity2);
        hbox2.setAlignment(Pos.CENTER_LEFT);

        HBox hbox3 = new HBox(10, checkBox3, new Label("Количество:"), quantity3);
        hbox3.setAlignment(Pos.CENTER_LEFT);


        VBox vbox = new VBox(10, hbox1, hbox2, hbox3, orderButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 600, 250);
        stage.setTitle("Заказ в ресторане");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        stage.setScene(scene);
        stage.show();
        stage.setX((owner.getWidth() - stage.getWidth()) / 2);
        stage.setY((owner.getHeight() - stage.getHeight()) / 2);
    }

    private static void chek(Stage owner, CheckBox chb1, CheckBox chb2, CheckBox chb3, TextField q1, TextField q2, TextField q3, String[] foods, double[] prices) {
        String chekZaHavku = "";
        double total = 0;

        if (chb1.isSelected()) {
            int kolvo = Integer.parseInt(q1.getText());
            double generalPrice = prices[0] * kolvo;
            generalPrice = Math.round(generalPrice * 100) / 100.0;
            chekZaHavku += foods[0] + " - " + kolvo + " шт. - " + generalPrice + " руб.\n";
            total += generalPrice;
            total = Math.round(total * 100) / 100.0;
        }
        if (chb2.isSelected()) {
            int kolvo = Integer.parseInt(q2.getText());
            double generalPrice = prices[1] * kolvo;
            generalPrice = Math.round(generalPrice * 100) / 100.0;
            chekZaHavku += foods[1] + " - " + kolvo + " шт. - " + generalPrice + " руб.\n";
            total += generalPrice;
            total = Math.round(total * 100) / 100.0;
        }
        if (chb3.isSelected()) {
            int kolvo = Integer.parseInt(q3.getText());
            double generalPrice = prices[2] * kolvo;
            generalPrice = Math.round(generalPrice * 100) / 100.0;
            chekZaHavku += foods[2] + " - " + kolvo + " шт. - " + generalPrice + " руб.\n";
            total += generalPrice;
            total = Math.round(total * 100) / 100.0;
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
            textArea.setMinHeight(494);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            VBox vbox = new VBox(textArea);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(3));

            Scene scene = new Scene(vbox, 300, 500);
            stage.setScene(scene);
            stage.show();
        }
    }
}