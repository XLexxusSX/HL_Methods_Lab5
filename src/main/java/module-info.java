//module com.alexeypopov1984.hl_methods_lab6 {
//    requires javafx.controls;
//    requires javafx.fxml;
//
//    opens com.alexeypopov1984.hl_methods_lab6 to javafx.fxml;
//    exports com.alexeypopov1984.hl_methods_lab6;
//}

//module com.alexeypopov1984.hl_methods_lab6 {
//        requires javafx.controls;
//        requires javafx.fxml;
//        requires javafx.web;
//        }

module com.alexeypopov1984.hlmethods.lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Экспортируйте нужные пакеты
    exports com.alexeypopov1984.hl_methods_lab6;
}

