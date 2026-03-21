package combobox.cargarcombobox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private  ComboBox<String> combo;

    @FXML

    private Label  lblNombre=new Label();;

   ObservableList<String> paises = FXCollections.observableArrayList();


  @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

      paises.addAll("Türkiye", "Azerbaijan", "Turkestan", "Utopia",
              "Liechtenstein", "Russian", "Italy", "Belgium",
              "Germany", "Kuştepe");

      combo.setPromptText("Grupos");
            combo.setItems(paises);


    }

    public void cbxCombo(ActionEvent actionEvent) {

      String s=combo.getSelectionModel().getSelectedItem().toString();

      lblNombre.setText(s);

        /**
         * para tofdos los items
         */
      //lblNombre.setText(String.valueOf(combo.getItems()));

    }
}