package FX_AMB;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class abmController implements Initializable {

    @FXML
    public TableView tbl_personas;
    @FXML
    private TextField nombre;
    @FXML
    private TextField dni;
    @FXML
    private TextField edad;


    @FXML
    ListView lista;

    ArrayList<Persona> personas = new ArrayList<>();


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    public void btn_add(ActionEvent actionEvent) {

        String dni = this.dni.getText();
        String nombre = this.nombre.getText();
        int edad = 0;


        try{
            edad= Integer.parseInt(this.edad.getText());
        }
        catch(NumberFormatException ex)
        {

           // System.out.println(ex.getMessage());

            /**
             * es un modal
             */
            Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
            dialogo.setTitle("Saludo");
            String saludo = null;
            dialogo.setHeaderText(saludo);
            dialogo.setContentText("Mensaje de bienvenida");
            dialogo.showAndWait();



        }

        if (dni != null && nombre != null && edad != 0) {
            Persona p = new Persona(dni, nombre, edad);
            personas.add(p);
           lista.getItems().add(p);
            tbl_personas.getItems().add(p);

            this.clear();

        }


    }




    public void clear()
    {
        nombre.setText("");
        dni.setText("");
        edad.setText("");
    }

    public void btn_delete(ActionEvent actionEvent) {

        Persona elem = (Persona) tbl_personas.getSelectionModel().getSelectedItem();

        //ahgora tengo el elemento  seleccionado

        personas.remove(elem);
        tbl_personas.getItems().remove(elem);






    }

    @FXML
    public void lst_lista(ListView.EditEvent editEvent) {

       /*
       public void initialize(URL location, ResourceBundle resources) {
            TableColumn<Punto, Double> colX = new TableColumn<>("X");
            TableColumn<Punto, Double> colY = new TableColumn<>("Y");

            colX.setCellValueFactory(new PropertyValueFactory<>("x"));
            colY.setCellValueFactory(new PropertyValueFactory<>("y"));

            tblPuntos.getColumns().addAll(colX,colY);

        }
        */



        if (!personas.isEmpty()) {
           System.out.println("Elementos dela lista");
            for (int i = 0; i < personas.size(); i++) {
                //imprimirmos por pantalla
               // System.out.println(personas.get(i));
                //lista.getItems().add(personas);
                //lista.getItems();
            }
        } else System.out.println("No hay Datos en la lista ");



        // for (Persona p: personas ) {
        //   System.out.println(p.toString());
        //}



    }

    public void btn_update(ActionEvent actionEvent) {

        /*
        Persona elem = (Persona) tbl_personas.getSelectionModel().getSelectedItem();

        //ahgora tengo el elemento  seleccionado

        personas.(elem);
        tbl_personas.getItems().remove(elem);
         */


        //gracias chicos!!
    }

    public void txt_dni(ActionEvent actionEvent) {
    }

    public void txt_nombre(ActionEvent actionEvent) {
    }

    public void txt_edad(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<Persona, String> colX = new TableColumn<>("Documento");
        TableColumn<Persona, String> colY = new TableColumn<>("Nombre");
        TableColumn<Persona, Integer> colZ = new TableColumn<>("Edad");



        colX.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colY.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colZ.setCellValueFactory(new PropertyValueFactory<>("edad"));

        tbl_personas.getColumns().addAll(colX, colY,colZ);

    }
}