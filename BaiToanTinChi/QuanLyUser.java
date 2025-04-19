package BaiToanTinChi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QuanLyUser {
	//Đối tượng Connection khai báo như thuộc tính để sử dụng chung
		private Connection connection;
		
		public QuanLyUser() {
			try {
				//Cập nhật đường dẫn đến file .accbd của b
				String dbURL = "jdbc:ucanaccess://lib/QLSV.accdb";//Đường dẫn tới file cơ sở dữ liệu ACCESS
				connection = DriverManager.getConnection(dbURL);//Tạo kết nối khi đói tượng UserDAO đc tạo ra
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public List<SinhVien> getAllUsers(){
			List<SinhVien> userList = new ArrayList<>();
			String query = "SELECT * FROM tblSinhVien";
			
			try {Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					String maNS = rs.getString("MaNS");
					String hoTen = rs.getString("HoTen");
					String diaChi = rs.getString("DiaChi");
					String tenLop = rs.getString("TenLop");
					
					//Đóng gói đối tượng sinh viên
					SinhVien sv = new SinhVien(maNS,hoTen,diaChi,tenLop);
					userList.add(sv);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return userList;
		}
		
		 public boolean addSinhVien(SinhVien sinhVien) {
		        String query = "INSERT INTO tblSinhVien (MaNS, HoTen, DiaChi , TenLop) VALUES (?, ?, ?, ?)";
		        try (PreparedStatement stmt = connection.prepareStatement(query)) {
		            stmt.setString(1, sinhVien.maNS);
		            stmt.setString(2, sinhVien.hoTen);
		            stmt.setString(3, sinhVien.diaChi);
		            stmt.setString(4, sinhVien.getTenLop());
		            
		            int rowInserted = stmt.executeUpdate();
		            return rowInserted > 0;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return false;
		    }
		 
		 public boolean updateSinhVien(SinhVien sinhVien) {
		        String query = "UPDATE tblSinhVien SET HoTen = ?, DiaChi = ?, TenLop = ? WHERE MaNS = ?";
		        try (PreparedStatement stmt = connection.prepareStatement(query)) {
		            stmt.setString(1, sinhVien.hoTen);
		            stmt.setString(2, sinhVien.diaChi);
		            stmt.setString(3, sinhVien.getTenLop());
		            stmt.setString(4, sinhVien.maNS);
		            int rowUpdated = stmt.executeUpdate();
		            return rowUpdated > 0;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return false;
		    }
		 
		 public boolean deleteSinhVien(String maNS) {
		        String query = "DELETE FROM tblSinhVien WHERE MaNS = ?";
		        try (PreparedStatement stmt = connection.prepareStatement(query)) {
		            stmt.setString(1, maNS);
		            int rowsDeleted = stmt.executeUpdate();
		            return rowsDeleted > 0;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return false;
		    }
		 
		public static void main(String[] args) {
			QuanLyUser quanLyUser = new QuanLyUser();
	        Scanner scanner = new Scanner(System.in);
	        

	        int choice;
	        do {
	            System.out.println("\n--- Quản lý Sinh viên ---");
	            System.out.println("1. Thêm Sinh viên");
	            System.out.println("2. Sửa Sinh viên");
	            System.out.println("3. Xóa Sinh viên");
	            System.out.println("4. Hiển thị tất cả Sinh viên");
	            System.out.println("0. Thoát");
	            System.out.print("Chọn thao tác: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Đọc dòng new line

	            switch (choice) {
	                case 1:
	                    System.out.println("\n--- Thêm Sinh viên ---");
	                    System.out.print("Mã Sinh viên (MaNS): ");
	                    String maSV = scanner.nextLine();
	                    System.out.print("Họ và tên: ");
	                    String hoTen = scanner.nextLine();
	                    System.out.print("Địa chỉ: ");
	                    String diaChi = scanner.nextLine();
	                    System.out.print("Tên lớp: ");
	                    String tenLop = scanner.nextLine();
	                    SinhVien svMoi = new SinhVien(maSV, hoTen, diaChi, tenLop);
	                    if (quanLyUser.addSinhVien(svMoi)) {
	                        System.out.println("Thêm sinh viên thành công!");
	                    } else {
	                        System.out.println("Thêm sinh viên thất bại.");
	                    }
	                    break;
	                case 2:
	                    System.out.println("\n--- Sửa Sinh viên ---");
	                    System.out.print("Nhập Mã Sinh viên (MaNS) cần sửa: ");
	                    String maSVSua = scanner.nextLine();
	                    System.out.print("Họ và tên mới: ");
	                    String hoTenMoi = scanner.nextLine();
	                    System.out.print("Địa chỉ mới: ");
	                    String diaChiMoi = scanner.nextLine();
	                    System.out.print("Tên lớp mới: ");
	                    String tenLopMoi = scanner.nextLine();
	                    SinhVien svSua = new SinhVien(maSVSua, hoTenMoi, diaChiMoi, tenLopMoi);
	                    if (quanLyUser.updateSinhVien(svSua)) {
	                        System.out.println("Sửa sinh viên thành công!");
	                    } else {
	                        System.out.println("Sửa sinh viên thất bại.");
	                    }
	                    break;
	                case 3:
	                    System.out.println("\n--- Xóa Sinh viên ---");
	                    System.out.print("Nhập Mã Sinh viên (MaNS) cần xóa: ");
	                    String maSVXoa = scanner.nextLine();
	                    if (quanLyUser.deleteSinhVien(maSVXoa)) {
	                        System.out.println("Xóa sinh viên thành công!");
	                    } else {
	                        System.out.println("Xóa sinh viên thất bại.");
	                    }
	                    break;
	                case 4:
	                    System.out.println("\n--- Danh sách Sinh viên ---");
	                    List<SinhVien> listSV = quanLyUser.getAllUsers();
	                    if (listSV.isEmpty()) {
	                        System.out.println("Không có sinh viên nào trong danh sách.");
	                    } else {
	                        for (SinhVien sv : listSV) {
	                            System.out.println(sv); // Assuming SinhVien has a proper toString() method
	                        }
	                    }
	                    break;
	                case 0:
	                    System.out.println("Thoát chương trình.");
	                    break;
	                default:
	                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
	            }
	        } while (choice != 0);

	        scanner.close();
	        
		}
}
