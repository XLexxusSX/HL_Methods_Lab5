package com.alexeypopov1984.hl_methods_lab5;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

public class Zadacha_2_Vidzhety {

    public static Stage showWindow(Stage owner) {

        Button buttonWid = new Button("Кнопка");
        buttonWid.setMinWidth(170);

        TextField textFieldWid = new TextField("");
        textFieldWid.setMinWidth(170);

        Label labelWid = new Label("Label");
        labelWid.setMinWidth(170);

        CheckBox checkBoxButton = new CheckBox("Скрыть кнопку");
        CheckBox checkBoxField = new CheckBox("Скрыть поле ввода");
        CheckBox checkBoxLabel = new CheckBox("Скрыть Label");

        Stage stage = new Stage();
        stage.setTitle("Виджеты-невидимки");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);

        HBox hbox1 = new HBox(78, buttonWid, checkBoxButton);
        buttonWid.setTranslateX(40);

        HBox hbox2 = new HBox(78, textFieldWid, checkBoxField);
        textFieldWid.setTranslateX(40);

        HBox hbox3 = new HBox(78, labelWid, checkBoxLabel);
        labelWid.setTranslateX(40);

        VBox vbox = new VBox(15, hbox1, hbox2, hbox3);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 410, 150);
        stage.setResizable(false);

        checkBoxButton.setOnAction(e -> buttonWid.setVisible(!checkBoxButton.isSelected()));
        checkBoxField.setOnAction(e -> {textFieldWid.setVisible(!checkBoxField.isSelected()); textFieldWid.setText("");});
        checkBoxLabel.setOnAction(e -> labelWid.setVisible(!checkBoxLabel.isSelected()));
        buttonWid.setOnAction(e -> textFieldWid.setText(labelWid.getText()));

        stage.setScene(scene);
        stage.show();

        stage.setX(owner.getWidth() / 2 - stage.getWidth() / 2);
        stage.setY(owner.getHeight() / 2 - stage.getHeight() / 2);

        return stage;
    }
}
