import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain2 {
	public static void main(String[] args) throws SQLException {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 사람? : ");
		String name = sc.nextLine();
		System.out.println(name);

		try {

			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");
			String sql = "select * from student3_db where s_name = ?";
			st = con.prepareStatement(sql);
			st.setString(1, name);

			rs = st.executeQuery();

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