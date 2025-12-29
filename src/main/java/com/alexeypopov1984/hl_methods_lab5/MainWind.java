package com.alexeypopov1984.hl_methods_lab5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainWind extends Application {
    private Stage primaryStage;
    private Stage currentChildStage = null;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);

        Button buttonPerekid = new Button("Перекидыватель слов");
        buttonPerekid.setMinSize(150, 150);

        Button buttonVidget = new Button("Виджеты-невидимки");
        buttonVidget.setMinSize(150, 150);

        Button buttonZakazy = new Button("Заказы в ресторане");
        buttonZakazy.setMinSize(150, 150);

        Button buttonKalk = new Button("Калькулятор");
        buttonKalk.setMinSize(150, 150);

        Button buttonFlag = new Button("Текстовый флаг");
        buttonFlag.setMinSize(150, 150);

        buttonPerekid.setOnAction(e -> {
            closeCurrentChild();
            currentChildStage = Zadacha_1_Perekid.showWindow(primaryStage);
        });

        buttonVidget.setOnAction(e -> {
            closeCurrentChild();
            currentChildStage = Zadacha_2_Vidzhety.showWindow(primaryStage);
        });

        buttonZakazy.setOnAction(e -> {
            closeCurrentChild();
            currentChildStage = Zadacha_3_Zakazy.showWindow(primaryStage);
        });

        HBox hbox = new HBox(10, buttonPerekid, buttonVidget, buttonZakazy, buttonFlag, buttonKalk);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));

        Scene scene = new Scene(hbox, 400, 100);
        primaryStage.setTitle("Лабораторная работа №6");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void closeCurrentChild() {
        if (currentChildStage != null && currentChildStage.isShowing()) {
            currentChildStage.close();
        }
    }
}