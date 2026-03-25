package jdbcConnectWithMYSQL;

import java.sql.*;

public class JDBCConecction {




    public static void main(String[] args) {

        //String url="jdbc:h2:~/test";  //url conexion a bd H2
        String url="jdbc:mysql://localhost:3306/test?useSSL=false";
        String username="root"; //usuario de bd;
        String password="admin";  //contraseña de bd


        try{
            //&establecer la conexion

            Connection cnn= DriverManager.getConnection(url,username,password);

            //statement
            Statement stemen= cnn.createStatement();

            // Eliminar la tabla si ya existe
            String dropTableQuery = "DROP TABLE IF EXISTS usuarios";
            stemen.executeUpdate(dropTableQuery);



            //crear tabla
            String createTableQuery="CREATE TABLE IF NOT EXISTS usuarios(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY,  " +
                    "name VARCHAR(50)) ";
            stemen.executeUpdate(createTableQuery);






            // Insertar registros
            String insertQuery = "INSERT INTO usuarios (id, name) VALUES "
                    + "(1, 'John Doe'), "
                    + "(2, 'Jane Smith')";
            stemen.executeUpdate(insertQuery);


            String sql = "select * from usuarios";
            ResultSet result = stemen.executeQuery(sql);
            while (result.next()) {
                System.out.print("Id:" + result.getInt(1));
                System.out.print(" Nombre:" + result.getString(2));

                System.out.println(" ");

            }

            System.out.println("***************************** ");


            // Cerrar ResultSet
            result.close();

            // Cerrar Statement
            stemen.close();

            // Cerrar Connection
            cnn.close();

            System.out.println("registros insertados exitosamente en la tala usuarios y bd test");

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
