import java.sql.Connection;
import java.sql.DriverManager;

public class CProvider {
    public static Connection createC() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String password = "admin";
            String url = "jdbc:mysql://localhost:3306/tempstudent";
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
