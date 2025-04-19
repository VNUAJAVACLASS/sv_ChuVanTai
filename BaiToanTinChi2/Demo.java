package BaiToanTinChi2;

import java.util.Map;

public class Demo {
	 public static void main(String[] args) {
	        SinhVien sv = new SinhVien("SV001", "Nguyễn Văn A", "K68CNTTA");

	        // Tạo môn học và nhập điểm
	        JavaSubject mh1 = new JavaSubject("M001", "Lập trình hướng đối tượng", 3);
	        mh1.setDiemCC(9);
	        mh1.setDiemGK(8);
	        mh1.setDiemCK(7.5f);

	        JavaSubject mh2 = new JavaSubject("M002", "Cấu trúc lập dữ liệu", 3);
	        mh2.setDiemCC(10);
	        mh2.setDiemGK(9);
	        mh2.setDiemCK(8.5f);

	        PythonSubject mh3 = new PythonSubject("M003", "Phát triển phần mềm", 3);
	        mh3.setDiemCC(8);
	        mh3.setDiemBTL(9);
	        mh3.setDiemGK(7.5f);
	        mh3.setDiemCK(8);

	        sv.addMonHoc(mh1);
	        sv.addMonHoc(mh2);
	        sv.addMonHoc(mh3);

	        // In kết quả
	        System.out.println("==== Thông tin sinh viên ====");
	        System.out.println("Mã SV: " + sv.maNS);
	        System.out.println("Họ tên: " + sv.hoTen);
	        System.out.println("Lớp: " + sv.getTenLop());
	        System.out.printf("Điểm trung bình học kỳ (hệ 4): %.2f\n", sv.diemTBMonHoc());

	        // Tìm môn theo tên
	        System.out.println("\nTìm môn học theo tên chứa 'lập':");
	        Map<String, MonHoc> ketQua = sv.timMonHocTheoTen("lập");

	     // In tên môn học
	     for (String tenMon : ketQua.keySet()) {
	         System.out.println("Tên môn học: " + tenMon);
	     }
	        
	    }
}
