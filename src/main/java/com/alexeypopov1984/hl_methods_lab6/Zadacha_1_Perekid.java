package com.alexeypopov1984.hl_methods_lab6;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Zadacha_1_Perekid {
    private static final Button button = new Button("->");
    private static final TextField textField1 = new TextField();
    private static final TextField textField2 = new TextField();
    private static boolean tag = true;

    public static Stage showWindow(Stage owner) {
        Stage stage = new Stage();
        stage.setTitle("Перекидыватль слов");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);

        HBox hbox = new HBox(30, textField1, button, textField2);
        //VBox vbox = new VBox();
        hbox.setAlignment(Pos.CENTER);
        //vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hbox, 450, 150);
        stage.setResizable(false);

        textField1.setText("Text");
        button.setOnAction(e -> Foo());
        textField1.setFocusTraversable(false);

        stage.setScene(scene);

        stage.show();

        stage.setX(owner.getWidth() / 2 - stage.getWidth() / 2);
        stage.setY(owner.getHeight() / 2 - stage.getHeight() / 2);

        return stage;
    }

    private static void Foo() {
        if (tag) {
            textField2.setText(textField1.getText());
            textField1.clear();
            button.setText("<-");
            tag = false;
        } else {
            textField1.setText(textField2.getText());
            textField2.clear();
            button.setText("->");
            tag = true;
        }
    }
}