module com.example.abrirarchivo {
    requires javafx.controls;
    requires javafx.fxml;


    opens AbrirArchivos to javafx.fxml;
    exports AbrirArchivos;
}