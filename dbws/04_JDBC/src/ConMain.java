import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConMain {
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
		Connection con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
		System.out.println("연결 성공!");
	}
}
