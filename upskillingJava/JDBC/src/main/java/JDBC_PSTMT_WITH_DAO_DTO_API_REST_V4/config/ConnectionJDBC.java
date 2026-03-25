package JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {

    // VARIABLES DE ENTORNO

                                                                 // ruta del archivo .env java 2024/JDBC

    ///media/ariel/ssd Datos_aux/Java/java 2024/JDBC/src/main/java/JDBC_PSTMT_WITH_DAO_DTO_V3

    Dotenv dotenv=Dotenv.configure().directory("/media/ariel/ssd Datos_aux/Java/java 2024/JDBC/src/main/java/JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4/.env").load();
    private  String url=dotenv.get("DB_URL");
    private  String username=dotenv.get("DB_USERNAME");
    private  String password=dotenv.get("DB_PASSWORD");
    private static ConnectionJDBC instance=null;


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
          cnn = DriverManager.getConnection(url, username, password);
      }
      catch(Exception e){
          System.out.println(e.getMessage());
          e.printStackTrace();
      }

         return cnn;
     }



}
