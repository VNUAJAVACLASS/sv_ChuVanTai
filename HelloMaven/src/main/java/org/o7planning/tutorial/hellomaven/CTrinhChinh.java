package org.o7planning.tutorial.hellomaven;

import java.util.HashMap;
import java.util.Map;

public class CTrinhChinh {
	private Map<Integer, Tuan> danhSachTuan;

    public CTrinhChinh() {
        // Khởi tạo danh sách các tuần học
        this.danhSachTuan = new HashMap<>();
    }

    // Thêm thông tin cho một tuần
    public void themTuan(int soTuan, Tuan tuan) {
        danhSachTuan.put(soTuan, tuan);
    }

    // Lấy thông tin của một tuần
    public Tuan getTuan(int soTuan) {
        return danhSachTuan.get(soTuan);
    }

    // Hiển thị toàn bộ thời khóa biểu
    public void hienThiTKB() {
        for (Map.Entry<Integer, Tuan> entry : danhSachTuan.entrySet()) {
            System.out.println("Tuần " + entry.getKey() + ":");
            entry.getValue().hienThiThoiKhoaBieu();
        }
    }
}
