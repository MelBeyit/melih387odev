import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public Connection connectToDb(String dbname, String user, String pass) {

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection successful");
            } else
                System.out.println("Connection failed");


        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }
}
