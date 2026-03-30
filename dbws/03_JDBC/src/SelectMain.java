import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectMain {
	public static void main(String[] args) throws SQLException {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 사람? : ");
		String name = sc.nextLine();
		System.out.println(name);

		try {

			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");
			st = con.createStatement(); // sql injection
										// 'or 1 = 1 --
			String sql = "select * from student3_db where s_name = '" + name + "'";

			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println("---------");

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