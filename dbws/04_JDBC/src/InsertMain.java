import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) throws SQLException {
		// 3종 rs - select
		// CUD - rs가필요없음. 2종만

		// CRUD중 C를 맡고있는 친구
		// insert 니까 rs가 필요없음
		Connection con = null;
		PreparedStatement pstmt = null;

		Scanner sc = new Scanner(System.in);

		try {
			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");
			String sql = "insert into student3_db values(student3_db_seq.nextval,?,?,?)";

			pstmt = con.prepareStatement(sql);
			System.out.println("name :");
			String name = sc.next();
			System.out.println("age :");
			int age = sc.nextInt();
			System.out.println("addr :");
			String addr = sc.next();

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, addr);

			// rs - executeQuery() : ResultSet
			// 1 - executeUpdate() : int가 반환되면 1
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();

		}

	}
}
