

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public class ConnectionJDBC {

  private  String url="jdbc:mysql://localhost:3306/test?useSSL=false";
  private  String username="root"; //usuario de bd;
  private  String password="admin";  //contraseña de bd

  private static  ConnectionJDBC instance ;
    HikariDataSource ds =null;

//CONSTRUCTOR PRIVADO NO SE PUEDE CREAR NUEVAS INSTANCIAS SOLO SE ACCEDE POR LA UNICA ESTATICA
// Constructor privado
private ConnectionJDBC() {
    ds = new HikariDataSource();

    ds.setJdbcUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);

    ds.setMaximumPoolSize(5);
    ds.setMinimumIdle(1);
    ds.setConnectionTimeout(10000);
    ds.setIdleTimeout(10000);
    ds.setAutoCommit(false);
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



    public Connection getConnectionJDBC()  {
        Connection cnn=null;
        try {
            cnn= ds.getConnection();
            System.out.println("Conexion establecida con exito");

        }catch(Exception e){

            System.out.println(e.getMessage());
            System.err.println("Error al conectar a la BD");
            e.printStackTrace();

        }

        return cnn;
    }


}
