package com.alexeypopov1984;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.scene.control.ComboBox;

public class Zadacha_2_Vidzhety {

    public static void showWindow(Stage owner) {

        Button buttonWid = new Button("Кнопка");
        buttonWid.setMinWidth(170);
        buttonWid.setMinHeight(30);

        TextField textFieldWid = new TextField("");
        textFieldWid.setMinWidth(170);
        textFieldWid.setMinHeight(30);

        Label labelWid = new Label("Label");
        labelWid.setMinWidth(170);
        labelWid.setMinHeight(30);

        ComboBox<String> comboBoxWid = new ComboBox<>();
        comboBoxWid.setMinWidth(170);
        comboBoxWid.setMinHeight(30);

        CheckBox checkBoxButton = new CheckBox("Скрыть кнопку");
        CheckBox checkBoxField = new CheckBox("Скрыть поле ввода");
        CheckBox checkBoxLabel = new CheckBox("Скрыть Label");
        CheckBox checkBoxComboBox  = new CheckBox("Скрыть Комбобокс");

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

        HBox hbox4 = new HBox(78, comboBoxWid, checkBoxComboBox);
        comboBoxWid.setTranslateX(40);

        VBox vbox = new VBox(25, hbox1, hbox2, hbox3, hbox4);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 450, 250);
        stage.setResizable(false);

        checkBoxButton.setOnAction(e -> buttonWid.setVisible(!checkBoxButton.isSelected()));
        checkBoxField.setOnAction(e -> {textFieldWid.setVisible(!checkBoxField.isSelected()); textFieldWid.setText("");});
        checkBoxLabel.setOnAction(e -> labelWid.setVisible(!checkBoxLabel.isSelected()));
        checkBoxComboBox.setOnAction(e -> comboBoxWid.setVisible(!checkBoxComboBox.isSelected()));

        buttonWid.setOnAction(e -> textFieldWid.setText(labelWid.getText()));

        stage.setScene(scene);
        stage.show();

        stage.setX((owner.getWidth() - stage.getWidth()) / 2 + 40);
        stage.setY((owner.getHeight() - stage.getHeight()) / 2 + 40);
    }
}
