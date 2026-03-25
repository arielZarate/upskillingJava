import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 1. Crear la base de datos: Genera un script para crear una base de datos y córrelo en H2.
 *
 */


public class ConnectionH2WithHikariCP {

    public static void main(String[] args) {


        HikariConfig hc = new HikariConfig();

        hc.setJdbcUrl("jdbc:h2:mem:testdb");
        hc.setUsername("sa");
        hc.setPassword("");


        hc.setMaximumPoolSize(10); //maximun of connection
        hc.setMinimumIdle(2); //minim in repose
        hc.setIdleTimeout(30000);//time iddle
        hc.setMaxLifetime(1800000); //life of conection


        // create object Datasource of hikari
        HikariDataSource ds = new HikariDataSource(hc);

        try {

            Connection cnn = ds.getConnection();

            System.out.println("Conectado con pool 🚀");
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
            String insertQuery = "INSERT INTO users (id, name) VALUES " + "(1, 'John Doe'), " + "(2, 'Jane Smith')";
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

            closeConnections(result, statement, cnn);

            System.out.println("registros insertados exitosamente en la tala usuarios y bd test");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private static void closeConnections(ResultSet res, Statement sta, Connection cnn) throws SQLException {

        if (res != null) {
            res.close();
        }

        if (sta != null) {
            sta.close();
        }

        if (cnn != null) {
            cnn.close();
        }

    }
}



