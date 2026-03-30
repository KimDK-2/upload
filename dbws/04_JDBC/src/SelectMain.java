import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain {
	public static void main(String[] args) throws SQLException {
		// 모든 커피 조회
		// 껍데기 3종 con, pstmt, rs
		// R,C-커피등록,U-pk선택 후 그 커피 가겨 수정,D->삭제할 수 있게

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Scanner sc = new Scanner(System.in);

		try {
			String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
			con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결 성공!");
			String sql = "select * from coffee_test";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String inSql = "insert into coffee_test values(coffee_test_seq.nextval,?,?,?)";
			String deSql = "delete coffee_test where c_no = ?";
			String upSql = "update coffee_test set c_price = ? where c_no = ?";
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "/" + rs.getString(2) + "/" + rs.getInt(3) + "/" + rs.getString(4));
				System.out.println("------------------------");
			}
			System.out.println("1커피 등록 ,2커피 삭제 ,3커피 수정");
			int st = sc.nextInt();
			if (st == 1) {
				pstmt = con.prepareStatement(inSql);
				System.out.println("품명 :");
				String name = sc.next();
				System.out.println("가격 :");
				int price = sc.nextInt();
				System.out.println("원산지 :");
				String origin = sc.next();

				pstmt.setString(1, name);
				pstmt.setInt(2, price);
				pstmt.setString(3, origin);
				if (pstmt.executeUpdate() == 1) {
					System.out.println("등록성공");
				}
			} else if (st == 2) {
				System.out.println("번호 선택");
				pstmt = con.prepareStatement(deSql);
				int no = sc.nextInt();
				pstmt.setInt(1, no);

				if (pstmt.executeUpdate() == 1) {
					System.out.println("삭제성공");
				}
			} else if (st == 3) {
				pstmt = con.prepareStatement(upSql);
				System.out.println("수정할 품목 번호?");
				int num = sc.nextInt();
				System.out.println("얼마로??");
				int price = sc.nextInt();

				pstmt.setInt(2, num);
				pstmt.setInt(1, price);

				if (pstmt.executeUpdate() == 1) {
					System.out.println("수정 성공");
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