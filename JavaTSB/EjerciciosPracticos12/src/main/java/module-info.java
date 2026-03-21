module com.example.fx_amb {
    requires javafx.controls;
    requires javafx.fxml;


    opens FX_AMB to javafx.fxml;
    exports FX_AMB;
}