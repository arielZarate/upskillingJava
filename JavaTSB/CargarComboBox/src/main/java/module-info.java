module combobox.cargarcombobox {
    requires javafx.controls;
    requires javafx.fxml;


    opens combobox.cargarcombobox to javafx.fxml;
    exports combobox.cargarcombobox;
}