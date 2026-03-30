import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) {
		// 오라클자바데이터커넥티비티
		// db=>3종
		// db_test
		// select (R) - rs
		// insert (C) / update(U), delete(D) - rs 필요 없음x
		// 결과가 없으니까

		// st.excuteQuery() => rs
		// st.excuteUpdate() => ??

		String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
		String sql = "insert into db_test values(db_test_seq.nextval,'test2',30)";
		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결 성공");

			st = con.createStatement();
			int row = st.executeUpdate(sql);

			if (row == 1) {
				System.out.println("등록 성공!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 사용 역순으로 닫아주기.
				st.close();
				con.close();

			} catch (SQLException e) {
			}
		}

	}
}
