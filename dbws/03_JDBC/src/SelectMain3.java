import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain3 {
	public static void main(String[] args) throws SQLException {

		// 실행하면 1. 이름 조회 2.나이(이상) 조회

		// 1 -> 입력한 이름 포함된 사람들 정보 출력
		// 2 -> 입력한 나이 이상인 사람들 정보 출력

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		try {

			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결성공");
			String sql = "select * from student3_db where s_name = ?";
			String sql2 = "select * from student3_db where s_age >= ?";

			System.out.println("1. 이름 조회 2.나이(이상)조회");
			int choose = sc.nextInt();

			if (choose == 1) {
				st = con.prepareStatement(sql);
				System.out.println("이름을 입력하세요 :");
				st.setString(1, sc.next());

			} else if (choose == 2) {
				st = con.prepareStatement(sql2);
				System.out.println("몇살 이상 검색? :");
				st.setInt(1, sc.nextInt());
			}

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