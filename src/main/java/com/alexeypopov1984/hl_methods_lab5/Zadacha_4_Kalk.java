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

import javafx.stage.Stage;

public class Zadacha_4_Kalk {
    public static void showWindow(Stage owner) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPadding(new Insets(20));
        Stage stage = new Stage();
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

    
}
