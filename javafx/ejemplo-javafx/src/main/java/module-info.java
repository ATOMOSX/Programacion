module co.edu.uniquindio.ingesis.ejemplojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.ingesis.ejemplojavafx to javafx.fxml;
    exports co.edu.uniquindio.ingesis.ejemplojavafx;
}