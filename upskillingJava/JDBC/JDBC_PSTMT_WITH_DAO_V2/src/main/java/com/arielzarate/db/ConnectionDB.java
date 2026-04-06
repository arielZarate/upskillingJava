package com.arielzarate.db;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private  String url="jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
    private  String username="root"; //usuario de bd;
    private  String password="admin";  //contraseña de bd

    HikariDataSource ds;
    private ConnectionDB(){
       ds = new HikariDataSource();
      ds.setJdbcUrl(url);
      ds.setUsername(username);
      ds.setPassword(password);

        //pool conections
        ds.setMaximumPoolSize(5);
        ds.setMinimumIdle(1);
        ds.setConnectionTimeout(5000);

    }


    private static final class  SingletonHolder{
        private static final ConnectionDB INSTANCE=new ConnectionDB();
    }


    public static  ConnectionDB getInstance() {
       return SingletonHolder.INSTANCE;
    }


/*
se utiliza a getInstance para poder conectarse a la bd ,es decir la unica instancia
* */
    public Connection getConnection() {
        Connection cnn = null;
        try {
            cnn = ds.getConnection();
            if (cnn != null) {
                System.out.println("Conexion establecida con la bd ");
            }

        } catch (SQLException e) {

            System.out.println("Error el conectar con la BD " + e.getMessage());
            e.printStackTrace();
        }

        return cnn;
      }





}
