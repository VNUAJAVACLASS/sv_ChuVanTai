package BaiToanTinChiCSDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NhanSuDAO {
private Connection connection;
private ConnectDB connectmysql;
	
	public NhanSuDAO() {
		connectmysql = new ConnectDB();
		connectmysql.connectMySQL();
		connection = connectmysql.getConnect();
	}
	
	public boolean addUser(NhanSu nhanSu) {
		String query = "INSERT INTO tblgiangvien ( HoTen, DiaChi, MatKhau, Loai) VALUES(?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, nhanSu.getHoTen());
			stmt.setString(2, nhanSu.getDiaChi());
			stmt.setString(3, nhanSu.getMatKhau());
			stmt.setString(4, nhanSu.getLoai());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(NhanSu nhanSu) {
		String query = "UPDATE tblgiangvien SET HoTen =?,DiaChi=?,MatKhau=?,Loai=? WHERE MaND=?";
		try (PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setString(1, nhanSu.getHoTen());
			stmt.setString(2, nhanSu.getDiaChi());
			stmt.setString(3, nhanSu.getMatKhau());
			stmt.setString(4, nhanSu.getLoai());
			stmt.setInt(5, nhanSu.getMaND());
			
			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate >0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteUser(int userId) {
		String query = "DELETE FROM tblgiangvien WHERE MaND =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setInt(1, userId);
			int rowDeleted = stmt.executeUpdate();
			return rowDeleted >0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
