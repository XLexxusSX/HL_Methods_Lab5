package com.alexeypopov1984.hl_methods_lab5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
public class MainWind extends Application {

    @Override
    public void start(Stage primaryStage) {

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

        buttonPerekid.setOnAction(e -> Zadacha_1_Perekid.showWindow(primaryStage));

        buttonVidget.setOnAction(e -> Zadacha_2_Vidzhety.showWindow(primaryStage));

        buttonZakazy.setOnAction(e -> Zadacha_3_Zakazy.showWindow(primaryStage));

        buttonKalk.setOnAction(e -> Zadacha_4_Kalk.showWindow(primaryStage));

        buttonFlag.setOnAction(e -> Zadacha_5_Flag.showWindow(primaryStage));

        HBox hbox = new HBox(10, buttonPerekid, buttonVidget, buttonZakazy, buttonKalk, buttonFlag);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));

        Scene scene = new Scene(hbox, 800, 600);
        primaryStage.setTitle("Лабораторная работа №5");


        //primaryStage.setAlwaysOnTop(true);

        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth()  - 80);
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight() - 80);
        primaryStage.setX(40);
        primaryStage.setY(40);

        primaryStage.setScene(scene);
        primaryStage.show();
        //primaryStage.setMaximized(true);
    }
}
