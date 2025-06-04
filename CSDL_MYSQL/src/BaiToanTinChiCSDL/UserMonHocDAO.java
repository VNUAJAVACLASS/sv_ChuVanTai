package BaiToanTinChiCSDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserMonHocDAO {
private Connection connection;
private ConnectDB connectmysql;
	
	public UserMonHocDAO() {
		connectmysql = new ConnectDB();
		connectmysql.connectMySQL();
		connection=connectmysql.getConnect();
	}
	
	public boolean addUserSubject(UserMonHoc userMonHoc) {
		String query = "INSERT INTO tblSinhVien_MonHoc ( MaNguoiDung,MaMh,Diem1,Diem2,Diem3,Diem4,Diem5) VALUES(?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, userMonHoc.getMaNguoiDung());
			stmt.setInt(2, userMonHoc.getMaMh());
			stmt.setFloat(3, userMonHoc.getDiem1());
			stmt.setFloat(4, userMonHoc.getDiem2());
			stmt.setFloat(5, userMonHoc.getDiem3());
			stmt.setFloat(6, userMonHoc.getDiem4());
			stmt.setFloat(7, userMonHoc.getDiem5());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserSubject(UserMonHoc userMonHoc) {
		String query = "UPDATE tblSinhVien_MonHoc SET MaNguoiDung =?,MaMh=?,Diem1=?,Diem2=?,Diem3=?,Diem4=?,Diem5=? WHERE MaMhNguoiDung=?";
		try (PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setInt(1, userMonHoc.getMaNguoiDung());
			stmt.setInt(2, userMonHoc.getMaMh());
			stmt.setFloat(3, userMonHoc.getDiem1());
			stmt.setFloat(4, userMonHoc.getDiem2());
			stmt.setFloat(5, userMonHoc.getDiem3());
			stmt.setFloat(6, userMonHoc.getDiem4());
			stmt.setFloat(7, userMonHoc.getDiem5());
			stmt.setInt(8, userMonHoc.getMaMhNguoiDung());
			
			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate >0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteUserSubject(int userSubjectId) {
		String query = "DELETE FROM tblSinhVien_MonHoc WHERE MaMhNguoiDung =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setInt(1, userSubjectId);
			int rowDeleted = stmt.executeUpdate();
			return rowDeleted >0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
