module com.alexeypopov1984.hl_methods_lab6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.alexeypopov1984.hl_methods_lab6 to javafx.fxml;
    exports com.alexeypopov1984.hl_methods_lab6;
}