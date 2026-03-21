module fx.calculadora {
    requires javafx.controls;
    requires javafx.fxml;


    opens fx.calculadora to javafx.fxml;
    exports fx.calculadora;
}