import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 1. Crear la base de datos: Genera un script para crear una base de datos y córrelo en H2.
 *
 */


public class ConnectionH2WithDataSource {

    public static void main(String[] args) {


        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:testdb");
        ds.setUser("sa"); //system administrator;
        ds.setPassword("");


        try {

            Connection cnn = ds.getConnection();
            //statement object
            Statement statement = cnn.createStatement();

            // Delete table if exists
            String dropTableQuery = "DROP TABLE IF EXISTS users";
            statement.executeUpdate(dropTableQuery);


            //create table
            String createTableQuery = """
                    CREATE TABLE IF NOT EXISTS users(
                    id INT AUTO_INCREMENT PRIMARY KEY  ,
                    name VARCHAR(50)
                    ); 
                    """;
            statement.executeUpdate(createTableQuery);


            // Insert new register
            String insertQuery = "INSERT INTO users (id, name) VALUES "
                    + "(1, 'John Doe'), "
                    + "(2, 'Jane Smith')";
            statement.executeUpdate(insertQuery);


            String sql = "select * from users";

            //get user with Result Set
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.print("Id:" + result.getInt(1));
                System.out.print(" Nombre:" + result.getString(2));

                System.out.println(" ");

            }

            System.out.println("***************************** ");


            // IMPORTANT , CLOSED QUERY
            result.close();

            // CLOSE STATEMENT
            statement.close();

            // CLOSE CONNECTION
            cnn.close();

            System.out.println("registros insertados exitosamente en la tala usuarios y bd test");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}



