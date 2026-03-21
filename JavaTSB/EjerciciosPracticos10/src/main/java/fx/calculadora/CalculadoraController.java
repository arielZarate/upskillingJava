package fx.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class CalculadoraController {





        @FXML private TextField txtOp1, txtOp2;
        @FXML private Label lblResultado;

        @FXML
        private void btnSumarClick() {
            int op1 = Integer.parseInt(txtOp1.getText());
            int op2 = Integer.parseInt(txtOp2.getText());

            int suma = op1 + op2;
            lblResultado.setText(String.valueOf(suma));





    }

}
