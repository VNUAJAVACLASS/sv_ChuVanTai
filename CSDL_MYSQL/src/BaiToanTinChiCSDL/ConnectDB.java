package BaiToanTinChiCSDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private Connection connect;
	
	public Connection getConnect() {
		return connect;
	}

	public void connectMySQL() {
		try {
			String url = "jdbc:mysql://localhost:3306/qlsv"; // tên CSDL của bạn
            String username = "root"; // ví dụ: root
            String password = "Chuvantai26082005@#"; // mật khẩu tương ứng
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối thành công đến MySQL!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
