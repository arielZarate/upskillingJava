module fx.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens fx.calculadora to javafx.fxml;
    exports fx.calculadora;
}