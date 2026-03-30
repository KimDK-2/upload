import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain4 {
	public static void main(String[] args) throws SQLException {

		// 이름 검색(포함)
		// "s" 로 검색하면 그게 이름에 포함된 사람들의 나이를 입력받은 값으로 수정
		// sql like %%
		Connection con = null;
		PreparedStatement pstmt = null;

		Scanner sc = new Scanner(System.in);

		try {
			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");
			String upSql = "update student3_db set s_age = ? where s_name like '%'||?||'%'";

			System.out.println("이름 검색(포함) ?");
			String name = sc.next();
			System.out.println("몇살로?? :");
			int age = sc.nextInt();

			pstmt = con.prepareStatement(upSql);

			pstmt.setInt(1, age);
			pstmt.setString(2, name);

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
