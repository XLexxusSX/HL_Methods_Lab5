package com.alexeypopov1984.hl_methods_lab6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Zadacha_1_PereSlov extends Application {
    private final Button button = new Button("->");
    private final TextField textField1 = new TextField();
    private final TextField textField2 = new TextField();
    private boolean tag = true;

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Перекидыватль слов");

        HBox hbox = new HBox(30, textField1, button, textField2);
        hbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hbox, 450, 150);
        stage.setResizable(false);

        textField1.setPrefWidth(150);
        textField2.setPrefWidth(150);

        textField1.setText("Text");
        button.setOnAction(e -> Foo());
        textField1.setFocusTraversable(false);

        stage.setScene(scene);
        stage.show();
    }

    private void Foo() {
        if (tag) {
            textField2.setText(textField1.getText());
            textField1.clear();
            button.setText("<-");
            tag = false;
        }
        else {
            textField1.setText(textField2.getText());
            textField2.clear();
            button.setText("->");
            tag = true;
        }
    }
}
