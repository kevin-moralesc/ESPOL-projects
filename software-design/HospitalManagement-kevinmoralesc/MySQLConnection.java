package HospitalManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection implements DatabaseConnection {
    private String url;
    private String user;
    private String password;

    public MySQLConnection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Error conectando a la BD");
        }
    }
}