import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletMain2 {
	public static void main(String[] args) throws SQLException {
		// 사람 이름으로 삭제
		Connection con = null;
		PreparedStatement pstmt = null;

		Scanner sc = new Scanner(System.in);

		try {
			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");
			String sql = "delete student3_db where s_name = ?";

			pstmt = con.prepareStatement(sql);
			System.out.println("삭제할 사람 이름? :");
			String name = sc.next();
			pstmt.setString(1, name);

			// rs - executeQuery() : ResultSet
			// 1 - executeUpdate() : int가 반환되면 1
			if (pstmt.executeUpdate() >= 1) {
				System.out.println("삭제성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();

		}

	}
}
