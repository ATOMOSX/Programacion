module co.edu.uniquindio.ingesis.javafx.ejemplo {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.ingesis.javafx.ejemplo to javafx.fxml;
    exports co.edu.uniquindio.ingesis.javafx.ejemplo;
    exports co.edu.uniquindio.ingesis.javafx.ejemplo.model;
    opens co.edu.uniquindio.ingesis.javafx.ejemplo.model to javafx.fxml;
    exports co.edu.uniquindio.ingesis.javafx.ejemplo.controllers;
    opens co.edu.uniquindio.ingesis.javafx.ejemplo.controllers to javafx.fxml;
    exports co.edu.uniquindio.ingesis.javafx.ejemplo.utils;
    opens co.edu.uniquindio.ingesis.javafx.ejemplo.utils to javafx.fxml;
    exports co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions;
    opens co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions to javafx.fxml;
}