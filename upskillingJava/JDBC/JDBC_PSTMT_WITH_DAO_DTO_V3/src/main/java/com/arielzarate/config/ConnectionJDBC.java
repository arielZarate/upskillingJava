package com.arielzarate.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {



    private  String url="jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
    private  String username="root"; //usuario de bd;
    private  String password="admin";  //contraseña de bd

    private static volatile ConnectionJDBC instance=null;


     private ConnectionJDBC()
     {
      //metdo privado solo se puede acceder a traves d ela instacia
     }

     public static synchronized  ConnectionJDBC   getInstance(){

        if(instance ==null)
        {instance=new ConnectionJDBC();}
        return instance;
     }


     public Connection getConnectionJDBC(){
         Connection cnn=null;
      try{
          if(cnn ==null)
         {cnn= DriverManager.getConnection(url,username,password);}
      }
      catch(Exception e){
          System.out.println(e.getMessage());
          e.printStackTrace();
      }

         return cnn;
     }



}
