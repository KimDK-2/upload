import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBMain2 {
	public static void main(String[] args) {
		// db => 껍데기 3종
		// interface. con, st, rs

		String url = "jdbc:oracle:thin:@192.168.0.57:1521:XE";
		String sql = "select * from snack";

		try {
			Connection con = DriverManager.getConnection(url, "c##dh1004", "dh1004");
			System.out.println("연결");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("s_name"));
				System.out.println(rs.getInt(5));
				System.out.println("----------------");
			}

			rs.next();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
