package com.example.leerarchivotextojavafx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private ListView<String> lista;
    @FXML
    private TableView<String> table;
    @FXML
    private ComboBox  cbx=new ComboBox();

    ObservableList<String> list = FXCollections.observableArrayList();

    public void cbxCombo(ActionEvent actionEvent) {
       // ObservableList<String> obs = FXCollections.observableArrayList("Manzana", "Plátano", "Pera", "Fresa", "Melocotón", "Naranja", "Ciruela");


    }

    public void btnCargar(ActionEvent actionEvent) throws FileNotFoundException, FileNotFoundException {


    }





       // TableColumn<String, String> colX = new TableColumn<>("Numeros");
        //TableColumn<Persona, String> colY = new TableColumn<>("Nombre");
        //TableColumn<Persona, Integer> colZ = new TableColumn<>("Edad");


          // colX.cellFactoryProperty();
      //  colX.setCellValueFactory(new PropertyValueFactory<>("Numeros"));
      // colY.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        //colZ.setCellValueFactory(new PropertyValueFactory<>("edad"));

        // table.getColumns().addAll(colX);



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File f = new File("lote01.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);

        String linea = null;
        String datos;
        try {
            while ((linea = br.readLine()) != null) {
                // datos = linea.replace("\"", "").split(",");
                datos=linea;

                lista.getItems().add(linea);
                list.addAll(datos);
                cbx.setItems(list);



            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        cbx.setItems(list);
    }


    /*

     if (dni != null && nombre != null && edad != 0) {
            Persona p = new Persona(dni, nombre, edad);
            personas.add(p);
           lista.getItems().add(p);
            tbl_personas.getItems().add(p);

            this.clear();







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
     */

}