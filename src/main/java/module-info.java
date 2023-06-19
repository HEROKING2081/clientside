module ru.clientside {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.clientside to javafx.fxml;
    exports ru.clientside;
    exports ru.clientside.controller;
    opens ru.clientside.controller to javafx.fxml;
    exports ru.clientside.model;
    opens ru.clientside.model to javafx.fxml;
}