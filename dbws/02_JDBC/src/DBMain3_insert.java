import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBMain3_insert {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		// snack 과자 추가하기.
		// db => 껍3종 rs x

		System.out.println("과자명 :");
		String name = sc.next();
		System.out.println("가격 :");
		int price = sc.nextInt();
		System.out.println("무게 :");
		double weight = sc.nextDouble();
		System.out.println("회사명 :");
		String comp = sc.next();
		String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";

		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결 성공!");

			String sql = "insert into snack values" + "(snack_seq.nextval,?,?,?,?,sysdate)";
			st = con.prepareStatement(sql);
			System.out.println(sql);

			st.setString(1, name);
			st.setString(2, comp);
			st.setDouble(3, weight);
			st.setInt(4, price);

			int row = st.executeUpdate();
			if (row == 1) {
				System.out.println("등록 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace(); // 오류터지면 봐야하니까
		} finally {
			st.close();
			con.close();
		}

	}
}
