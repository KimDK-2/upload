import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	public static void main(String[] args) throws SQLException {
		// 사람 이름을 입력하면 -> 나이를 수정
		Connection con = null;
		PreparedStatement pstmt = null;

		Scanner sc = new Scanner(System.in);

		try {
			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");
			String sql = "update student3_db set s_age = ? where s_name = ?";

			pstmt = con.prepareStatement(sql);

			System.out.println("수정할 사람 이름? :");
			String name = sc.next();
			System.out.println("몇살로?? :");
			int age = sc.nextInt();

			pstmt.setInt(1, age);
			pstmt.setString(2, name);

			// rs - executeQuery() : ResultSet
			// 1 - executeUpdate() : int가 반환되면 1
			// 중복되는 값이 있을때 수정 확인하고 싶으면 == 1 이아닌 >=1 로 수정
			if (pstmt.executeUpdate() >= 1) {
				System.out.println("수정 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();

		}
	}
}
