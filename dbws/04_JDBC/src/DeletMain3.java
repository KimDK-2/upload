import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletMain3 {
	public static void main(String[] args) throws SQLException {
		// 삭제는 좋지만 누굴 지울 수 있는지 리스트업(pk)
		// rs=전체조회
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Scanner sc = new Scanner(System.in);

		try {
			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");

			String deleteSql = "delete student3_db where s_no = ?";
			String seletSql = "select * from student3_db order by s_no";
			pstmt = con.prepareStatement(seletSql);
			rs = pstmt.executeQuery(); // 실행
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt("s_age");
				String addr = rs.getString(4);

				System.out.printf("%d] %s/%d/%s\n", no, name, age, addr);
				System.out.println("---------");
			}

			System.out.println("삭제할 no? :");
			int no = sc.nextInt();
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setInt(1, no);

			// rs - executeQuery() : ResultSet
			// 1 - executeUpdate() : int가 반환되면 1
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			con.close();

		}

	}
}
