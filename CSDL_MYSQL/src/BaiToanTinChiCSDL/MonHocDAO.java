package BaiToanTinChiCSDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MonHocDAO {
private Connection connection;
private ConnectDB connectmysql;
	
	public MonHocDAO() {
		connectmysql = new ConnectDB();
		connectmysql.connectMySQL();
		connection=connectmysql.getConnect();
	}
	
	public boolean addSubject(MonHoc subject) {
		String query = "INSERT INTO tblmonhoc ( TenMh, SoTinChi, HeSo1, HeSo2, HeSo3, HeSo4, HeSo5) VALUES(?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, subject.getTenMH());
			stmt.setInt(2, subject.getSoTC());
			stmt.setInt(3, subject.getHeSo1());
			stmt.setInt(4, subject.getHeSo2());
			stmt.setInt(5, subject.getHeSo3());
			stmt.setInt(6, subject.getHeSo4());
			stmt.setInt(7, subject.getHeSo5());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateSubject(MonHoc subject) {
		String query = "UPDATE Subject SET TenMh =?,SoTinChi=?,HeSo1=?,HeSo2=?, HeSo3=?,HeSo4=?,HeSo5=?  WHERE MaMh=?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, subject.getTenMH());
			stmt.setInt(2, subject.getSoTC());
			stmt.setInt(3, subject.getHeSo1());
			stmt.setInt(4, subject.getHeSo2());
			stmt.setInt(5, subject.getHeSo3());
			stmt.setInt(6, subject.getHeSo4());
			stmt.setInt(7, subject.getHeSo5());
			stmt.setInt(8, subject.getMaMH());

			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteSubject(int subjectId) {
		String query = "DELETE FROM Subject WHERE MaMh =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, subjectId);
			int rowDeleted = stmt.executeUpdate();
			return rowDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}
