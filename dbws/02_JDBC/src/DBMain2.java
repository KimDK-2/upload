import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain2 {
	public static void main(String[] args) throws SQLException {
		// 3종 셀렉트
		System.out.println(11);
		String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결 성공");
			st = con.createStatement();
			rs = st.executeQuery("select * from db_test");
			rs.next();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString("d_name");
				int age = rs.getInt(3);
				System.out.printf("%d] %s = %d\n", no, name, age);
				System.out.println("-------------------");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			con.close();
		}

	}
}
