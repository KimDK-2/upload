import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) {
		System.out.println(11);
		// db -> snack
		// java로 뽑아내기

		// 껍데기 3개 - con, st, rs
		String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
		// No suitable driver 에러 자바와 오라클을 연결하는jar파일이 필요
		try {
			Connection con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결 성공");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from snack");
			rs.next();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString("s_name");
				int price = rs.getInt(5);
				// %d 숫자 통합, %s 문자 통합, %f 는 소수점
				System.out.printf("%d] %s = %d\n", no, name, price);
				System.out.println("-------------------");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
