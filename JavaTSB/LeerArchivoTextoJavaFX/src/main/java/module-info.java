module com.example.leerarchivotextojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.leerarchivotextojavafx to javafx.fxml;
    exports com.example.leerarchivotextojavafx;
}