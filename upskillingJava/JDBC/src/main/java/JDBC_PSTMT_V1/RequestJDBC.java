package JDBC_PSTMT_V1;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class RequestJDBC {

    Connection cnn = null;
    final  String  USER_TABLE="usuarios"   ;
    //METODO CONSTRUCTOR
    public RequestJDBC()
    {
        this.cnn=ConnectionJDBC.getInstance().getConnectionJDBC();
    }


  public void createTable(){
      //crear tabla
      String createTableQuery="CREATE TABLE IF NOT EXISTS " +USER_TABLE+ " (" +
              "id INT AUTO_INCREMENT PRIMARY KEY,  " +
              "name VARCHAR(50)) ";

      try(PreparedStatement pstmt=cnn.prepareStatement(createTableQuery)){

          int rows=pstmt.executeUpdate(createTableQuery);

          if(rows >0 )
          {
              System.out.println("Tabla creada con exito");
          }else {
              System.out.println("Error tabla no creada ");
          }

      }
      catch(SQLException e){
          System.out.println(e.getMessage());
          e.printStackTrace();
      }

  }


  //GET USUARIOS
    public void getUsuarios() {
        try(
                PreparedStatement pstmt = cnn.prepareStatement("SELECT * FROM "+USER_TABLE);
                ResultSet res = pstmt.executeQuery();
          )
        {  //ahora itero
            while (res.next()) {
                System.out.println("ID:" + res.getInt("id")+ " "+ "Nombre: " + res.getString("name") );
                }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    //INSERT USUARIOS
    public void InsertUsuario(String name) {

        //genero un id aleatorio
        Random random=new Random();
        int id =random.nextInt();

      String sql="INSERT INTO "+ USER_TABLE+ " (id,name) VALUES (?,?)";
        try(PreparedStatement pstmt = cnn.prepareStatement(sql))
        {

        pstmt.setInt(1,id);
        pstmt.setString(2,name);

        int files=pstmt.executeUpdate();
            System.out.println("Filas insertadas : " + files);

        } catch (SQLException e) {
            System.out.println("Error al insertar usuario : " +  e.getMessage());
        }

    }


    //UPDATE usuarios
    public void updateUsuario(int id , String name){
       String sql="UPDATE " +USER_TABLE+ " SET name= ? WHERE id=?";
        try(PreparedStatement pstmt=cnn.prepareStatement(sql)){


            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            int res=   pstmt.executeUpdate();

            System.out.println("Filas actualizadas :" +  res);
        }catch(SQLException e)
        {
            System.out.println("Error al actualizar usuario ");
            e.printStackTrace();
        }
    }



  /// Usuarios getbyid

    public void getUsuarioPorId(int id ){
        String sql="SELECT * FROM " +USER_TABLE+  " WHERE id=?";
        try(PreparedStatement pstmt=cnn.prepareStatement(sql)){

            pstmt.setInt(1,id);
            ResultSet res=   pstmt.executeQuery();
           while(res.next())
           {
               System.out.println("Nombre :" +  res.getString("name"));
           }
        }catch(SQLException e)
        {
            System.out.println("Error al actualizar usuario ");
            e.printStackTrace();
        }
    }



    //DELETE usuarios
    public void deleteUsuario(int id ){
        String sql="DELETE FROM " +USER_TABLE+ "  WHERE id=?";
        try(PreparedStatement pstmt=cnn.prepareStatement(sql)){

            //pstmt.setString(1,name);
            pstmt.setInt(1,id);
            int res=   pstmt.executeUpdate();

            System.out.println("Filas eliminadas :" +  res);
        }catch(SQLException e)
        {
            System.out.println("Error al actualizar usuario ");
            e.printStackTrace();
        }


    }



    //CERRAR CONEXION
    public void CloseConnectionJDBC()
    {
        if(cnn != null){
            try{
                cnn.close();
                System.out.println("Conexion cerrada con exito");
            }catch(SQLException e)
            {
                System.out.println("Error al cerrar la conexion " + e.getMessage());
            }

        }

    }
}




/*


/*EN ESTE CASO USAMOS EL TRY CATCH Y FINALLY PERO EXISTE OTRA FORMA MAS SENCILLA
 try (Connection cnn = ConnectionJDBC.getInstance().getConnectionJDBC();
           PreparedStatement stmt = cnn.prepareStatement("SELECT * FROM usuarios");
           ResultSet res = stmt.executeQuery())
 {
   //CODIGO
 }catch(SQLException e){
 e.printStackTrace();
 }

//=================================================================================


    public void getUsuarios() {
        try {
            this.cnn = ConnectionJDBC.getInstance().getConnectionJDBC();

            if (cnn != null) {

                PreparedStatement stmt = cnn.prepareStatement("SELECT * FROM usuarios");
                ResultSet res = stmt.executeQuery();

                //ahora itero

                while (res.next()) {

                    System.out.println("ID:" + res.getInt("id")+ " "+ "Nombre: " + res.getString("name") );

                }

                res.close();
                stmt.close();
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            if (cnn != null) {
                try {
                    cnn.close();
                    System.out.println("Conexion cerrada con exito");

                } catch (SQLException e) {

                    e.printStackTrace();
                }
            }


        }

    }

*/


