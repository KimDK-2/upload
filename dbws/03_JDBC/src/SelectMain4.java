import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain4 {
	public static void main(String[] args) throws SQLException {

		// 나이조회

		// 1. 이상 2. 이하
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		try {

			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");
			String sql = "select * from student3_db where s_age";

			System.out.println("1. 이상 2. 이하");
			int choose = sc.nextInt();
			System.out.println("나이를 입력하세요:");
			if (choose == 1) {
				sql += ">= ?";

			} else if (choose == 2) {
				sql += "<=?";
			}
			st = con.prepareStatement(sql);
			st.setInt(1, sc.nextInt());

			rs = st.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt("s_age");
				String addr = rs.getString(4);

				System.out.printf("%d] %s/%d/%s\n", no, name, age, addr);
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