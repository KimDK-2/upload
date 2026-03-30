import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BMIMain {
	public static void main(String[] args) throws SQLException {
		// 이름, 키, 체중, bmi, status
		// db 구축, 저장할 수 있게끔 CRUD
		// 1. 조회(검사이력 조회) 2. 검사실시

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		try {
			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결 성공!");
			System.out.println("1 입력시 검사시작. 2 입력시 이력조회");
			String seletSql = "select * from bmi";
			String sql = "insert into bmi values(bmi_seq.nextval,?,?,?,?,?)";
			pstmt = con.prepareStatement(seletSql);
			rs = pstmt.executeQuery();
			int num = sc.nextInt();
			if (num == 1) {
				pstmt = con.prepareStatement(sql);

				System.out.println("이름 입력");
				String name = sc.next();
				System.out.println("키(소수점 1자리까지) 입력");
				Double height = sc.nextDouble();
				System.out.println("몸무게(소수점 1자리까지) 입력");
				Double weight = sc.nextDouble();

				Double bmi = weight / ((height / 100) * (height / 100));
				String status = "";
				if (bmi < 18.5) {
					status = "뼈다귀";
				} else if (18.5 <= bmi && bmi < 23) {
					status = "정상 체중";
				} else if (23 <= bmi && bmi < 25) {
					status = "돼지(진)";
				} else if (25 <= bmi) {
					status = "돼지";
				}
				pstmt.setString(1, name);
				pstmt.setDouble(2, height);
				pstmt.setDouble(3, weight);
				pstmt.setDouble(4, bmi);
				pstmt.setString(5, status);

				System.out.printf("%s님키%.1fcm몸무게%.1f시고BMI는%.1f이며%s이십니다.\n", name, height, weight, bmi, status);
				if (pstmt.executeUpdate() == 1) {
					System.out.println("수정 성공");
				}
			}
			if (num == 2) {
				while (rs.next()) {

					String name = rs.getString(2);
					Double height = rs.getDouble(3);
					Double weight = rs.getDouble(4);
					Double bmi = rs.getDouble(5);
					String status = rs.getString(6);

					System.out.printf("%s님키%.1fcm몸무게%.1f시고BMI는%.1f이며%s이십니다.\n", name, height, weight, bmi, status);

				}
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
