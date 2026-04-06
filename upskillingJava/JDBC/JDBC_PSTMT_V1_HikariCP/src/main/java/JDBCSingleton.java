import com.zaxxer.hikari.HikariDataSource;


import java.sql.Connection;
import java.sql.SQLException;

public class JDBCSingleton {

    private String urlValue = "jdbc:mysql://localhost:3306/test";
    private String usernameValue = "root";
    private String passwordValue = "admin";



    //class private
    private static final class InstanceHolder {
        private static final  JDBCSingleton instance = new JDBCSingleton();
    }


    //return instance
    public static JDBCSingleton getInstance() {
        return InstanceHolder.instance;
    }


    HikariDataSource ds;


    //constructor
    private  JDBCSingleton() {
        ds = new HikariDataSource();
        ds.setJdbcUrl(urlValue);
        ds.setUsername(usernameValue);
        ds.setPassword(passwordValue);

        //pool conections
        ds.setMaximumPoolSize(5);
        ds.setMinimumIdle(1);
        ds.setConnectionTimeout(5000);


    }
    public Connection getConnection()  {
        Connection connection = null;
        try {
            connection = ds.getConnection();
            System.out.println("La conexion esta establecida correctamente");
        } catch ( SQLException e) {
            System.out.println("Error de conexion");
            throw new RuntimeException("Error", e);
        }

        return connection;
    }


}

