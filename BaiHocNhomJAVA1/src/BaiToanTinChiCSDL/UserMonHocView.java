package BaiToanTinChiCSDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserMonHocView {
	private Connection connection;

	public UserMonHocView() {
		try {
			String URL = "jdbc:ucanaccess://lib/QLNN.accdb";
			connection = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showUserSubject() {
		String query = "SELECT u.HoTen,s.TenMh,us.Diem1,us.Diem2,us.Diem3,us.Diem4,us.Diem5" + "FROM User u"
				+ "INNER JOIN UserSubject us ON u.MaNguoiDung=us.MaNguoiDung"
				+ "INNER JOIN Subject s ON s.MaMh=us.MaMh";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				String hoTen = rs.getString("HoTen");
				String tenMh = rs.getString("TenMh");
				int diem1 = rs.getInt("Diem1");
				int diem2 = rs.getInt("Diem2");
				int diem3 = rs.getInt("Diem3");
				int diem4 = rs.getInt("Diem4");
				int diem5 = rs.getInt("Diem5");
				System.out.println("Họ tên: " + hoTen + "Môn: " + tenMh + "| Diểm: " + diem1 + "," + diem2 + "," + diem3
						+ "," + diem4 + "," + diem5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
