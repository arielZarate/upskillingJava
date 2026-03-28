package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {

    // Configuración para H2 en memoria
    private String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private String username = "sa";
    private String password = "";
    private static ConnectionJDBC instance = null;

    private ConnectionJDBC() {
        // metodo privado solo se puede acceder a traves de la instancia
    }

    public static synchronized ConnectionJDBC getInstance() {
        if (instance == null) {
            instance = new ConnectionJDBC();
        }
        return instance;
    }

    public Connection getConnectionJDBC() {
        Connection cnn = null;
        try {
            cnn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return cnn;
    }
}
