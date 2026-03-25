package JDBC_PSTMT_V1;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {



    //String url="jdbc:h2:~/test";  //url conexion a bd H2
  private  String url="jdbc:mysql://localhost:3306/test?useSSL=false";
  private  String username="root"; //usuario de bd;
  private  String password="admin";  //contraseña de bd
  private static ConnectionJDBC instance;


//CONSTRUCTOR PRIVADO NO SE PUEDE CREAR NUEVAS INSTANCIAS SOLO SE ACCEDE POR LA UNICA ESTATICA
  private ConnectionJDBC(){
      // es  privado para evitar la instanciacion
  }




  //PATRON SINGLETON APLICAOD SINO EXISTE INSTANCIA DE LA CONEXION SE CREA UNA NUEVA
    public static synchronized ConnectionJDBC getInstance()
  {
      if(instance== null)
      {
          instance=new ConnectionJDBC();
      }
      return instance;
  }


    public Connection getConnectionJDBC(){

        Connection cnn=null;
        try {
            cnn= DriverManager.getConnection(url,username,password);
            System.out.println("Conexion establecida con exito");

        }catch(Exception e){

            System.out.println(e.getMessage());
            e.printStackTrace();

        }

        return cnn;
    }


}
