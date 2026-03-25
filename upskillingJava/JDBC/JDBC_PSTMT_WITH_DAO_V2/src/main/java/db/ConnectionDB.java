package JDBC_PSTMT_WITH_DAO_V2.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private  String url="jdbc:mysql://localhost:3306/test?useSSL=false";
    private  String username="root"; //usuario de bd;
    private  String password="admin";  //contraseña de bd

    //atencion aca creo uns instancia estatica de la clase
    private static ConnectionDB instance=null;

    //CONSTRUCTORI PRIVADO NO SE PUEDE CREAR NUEVAS INSTANCIAS SOLO SE ACCEDE POR LA UNICA ESTATICA
    private ConnectionDB()
    {

    }


    //PATRON SINGLETON APLICAOD SINO EXISTE INSTANCIA DE LA CONEXION SE CREA UNA NUEVA
    public static synchronized ConnectionDB getInstance() {

       if(instance == null)
       {
       instance =new ConnectionDB();
       }

       return instance;

    }


/*
se utiliza a getInstance para poder conectarse a la bd ,es decir la unica instancia
* */
    public Connection getConnection() {
        Connection cnn = null;
        try {
            cnn = DriverManager.getConnection(url, username, password);
            if (cnn != null) {
                System.out.println("Conexion establecida con la bd ");
            }

        } catch (Exception e) {

            System.out.println("Error el conectar con la BD " + e.getMessage());
            e.printStackTrace();
        }

        return cnn;
      }





}
