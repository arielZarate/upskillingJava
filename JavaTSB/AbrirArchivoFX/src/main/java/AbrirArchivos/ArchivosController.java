package AbrirArchivos;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import soporte.TextFile;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ArchivosController implements Initializable {

    @FXML
    private Label lblPath = new Label();
    @FXML
    private Label lblNombre = new Label();


    /**
     * codigo de filechooser
     * @param actionEvent
     */

    /*
      FileChooser d = new FileChooser();


        /**
         * primera opcion
         */
        /*
        File f= d.showOpenDialog(null);
        System.out.println(f);
        String Nombre = f.getName();

        String ruta = f.getPath();
        System.out.println("nombre :" + Nombre);
        System.out.println("path :" + ruta);
         */

    /**
     * segunda opcion una lista de archivos (*)
     */
       /*
         List<File> lista=d.showOpenMultipleDialog(null);

        for(File f:lista){
            System.out.println(f);
        }
        */


    /**
     * 3era opcion una lista de archivos con filtros (*)
     */
    /*
    FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Archivos");
    //fileChooser.getExtensionFilters();


    //fileChooser.showOpenDialog ();
    /** esto es para cargar varis opciones
     // Agregar filtros para facilitar la busqueda
     fileChooser.getExtensionFilters().addAll(
     new FileChooser.ExtensionFilter("All Images", "*.*"),
     new FileChooser.ExtensionFilter("JPG", "*.jpg"),
     new FileChooser.ExtensionFilter("PNG", "*.png")
     );
     */

    //ExtensionFilter("Archivos de Texto", "*.txt", "*.csv");
    //d.getExtensionFilters().add(f1);
    //  List<File> lista = d.showOpenMultipleDialog(null);

   /*
        if (!(lista == null)) {

            for (File f : lista) {
                System.out.println(f);
                File f = new File("D:\\Java\\JavaTSB\\prueba.csv");
                ManejadorArchivos.ProcesarArchivo(f);




    */

             /**
                clase directory
              final DirectoryChooser dc  = new DirectoryChooser();
              dc.setTitle("Abrir Ubicacion del archivo");
              // dc.setInitialDirectory(new File(lblPath.getText()));
              File f = dc.showDialog(null);



              if(f !=null) {
              //System.out.println(f);
              //String Nombre = f.getName();
              //String Nombre = f.getName();
              String ruta = f.getAbsolutePath();
              lblPath.setText(ruta);
              //lblNombre.setText(Nombre);

              */



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void BuscarArchivo(ActionEvent actionEvent) {

        FileChooser fc=new FileChooser();
        fc.setTitle("Buscar Archivos");

        //esto es para cargar varis opciones
         // Agregar filtros para facilitar la busqueda
         fc.getExtensionFilters().addAll(
         new FileChooser.ExtensionFilter("All Images", "*.*"),
         new FileChooser.ExtensionFilter("JPG", "*.jpg"),
         new FileChooser.ExtensionFilter("PNG", "*.png"),
         new FileChooser.ExtensionFilter("CSV", "*.csv")
         );

        File f=fc.showOpenDialog (null);

        lblPath.setText(f.getPath());
        System.out.println(f.getPath());
        System.out.println(f.getName());
        lblNombre.setText(f.getName());


    }


    public void CargarDatos(ActionEvent actionEvent) {

        TextFile tf=new TextFile(lblPath.getText());
       tf.LeerArchivo();
    }






}






