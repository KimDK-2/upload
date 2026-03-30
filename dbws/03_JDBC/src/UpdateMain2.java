import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain2 {
	public static void main(String[] args) throws SQLException {
		// 리스트업 (전체 조회)

		// pk를 입력하면 -> 나이를 수정
		// @ oo님의 나이가 oo살로 수정 되었습니다.

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Scanner sc = new Scanner(System.in);

		try {
			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");
			String upSql = "update student3_db set s_age = ? where s_no = ?";
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
			pstmt = con.prepareStatement(upSql);

			System.out.println("수정할 사람 pk? :");
			int no = sc.nextInt();
			System.out.println("몇살로?? :");
			int age = sc.nextInt();

			pstmt.setInt(1, age);
			pstmt.setInt(2, no);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("수정성공");
				String selectByPK = "select* from student3_db where s_no =" + no;
				pstmt = con.prepareStatement(selectByPK);
				rs = pstmt.executeQuery();
				rs.next();
				System.out.printf("%s님의 나이가%d살로수정되었습니다", rs.getString(2), age);
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
