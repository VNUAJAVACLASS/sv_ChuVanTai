package org.o7planning.tutorial.hellomaven;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CTrinhChinh {

    private List<Tuan> danhSachTuan;
    private final LocalDate ngayBatDauHK;

    public CTrinhChinh() {
        this.danhSachTuan = new ArrayList<>();
        this.ngayBatDauHK = LocalDate.of(2025, 1, 13); // Ngày bắt đầu học kỳ cố định
    }

    // Lấy hoặc tạo mới tuần theo số tuần
    private Tuan getOrCreateTuan(int soTuan) {
        for (Tuan tuan : danhSachTuan) {
            if (tuan.getSoTuan() == soTuan) {
                return tuan;
            }
        }
        Tuan tuanMoi = new Tuan(soTuan);
        danhSachTuan.add(tuanMoi);
        return tuanMoi;
    }

    // Thêm lịch học vào
    public void themLichHoc(LichHoc lichHoc) {
        String thoiGianHoc = lichHoc.getThoiGianHoc();
        if (thoiGianHoc == null || thoiGianHoc.isEmpty()) {
            return;
        }
        for (int i = 0; i < thoiGianHoc.length() && i < 20; i++) {
            char c = thoiGianHoc.charAt(i);
            if (Character.isDigit(c) && c != '0') {
                int soTuan = i + 1;
                Tuan tuan = getOrCreateTuan(soTuan);
                // Cần thêm lichHoc vào đúng thứ của tuần, lấy thứ từ lichHoc.getThu() giả sử
                String soThu = lichHoc.getThu(); // VD: "2" - Thứ Hai, "3" - Thứ Ba, ...
                tuan.themLichHoc(soThu, lichHoc);
            }
        }
    }

    // Hiển thị toàn bộ thời khóa biểu
    public void hienThiThoiKhoaBieu() {
        if (danhSachTuan.isEmpty()) {
            System.out.println("Thời khóa biểu trống.");
            return;
        }
        danhSachTuan.sort((t1, t2) -> Integer.compare(t1.getSoTuan(), t2.getSoTuan()));
        for (Tuan tuan : danhSachTuan) {
            System.out.println(tuan);
        }
    }

   
    // Tìm lịch học theo thứ
    public List<LichHoc> timLichHocTheoThu(String soThu) {
        List<LichHoc> ketQua = new ArrayList<>();
        for (Tuan tuan : danhSachTuan) {
            Map<String, Thu> dsThu = tuan.getDsThu();
            Thu thu = dsThu.get(soThu);
            if (thu != null) {
                ketQua.addAll(thu.getDsLichHoc());
            }
        }
        return ketQua;
    }

    // Tìm lịch học theo tuần
    public Tuan timLichHocTheoTuan(int soTuan) {
        for (Tuan tuan : danhSachTuan) {
            if (tuan.getSoTuan() == soTuan) {
                return tuan;
            }
        }
        return null;
    }

    // Tìm lịch học theo ngày cụ thể
    public List<LichHoc> timLichHocTheoNgay(LocalDate date) {
        List<LichHoc> ketQua = new ArrayList<>();

        int dayOfWeek = date.getDayOfWeek().getValue(); // 1=Monday...7=Sunday
        if (dayOfWeek == 7) return ketQua; // Chủ Nhật không có lịch học

        // Theo chuẩn dữ liệu, "2" là Thứ Hai, nên ta cộng thêm 1
        String soThu = String.valueOf(dayOfWeek + 1);

        long daysSinceStart = java.time.temporal.ChronoUnit.DAYS.between(ngayBatDauHK, date);
        int soTuan = (int)(daysSinceStart / 7) + 1;

        if (soTuan < 1 || soTuan > 20) return ketQua;

        Tuan tuan = timLichHocTheoTuan(soTuan);
        if (tuan != null) {
            Thu thu = tuan.getThu(soThu);
            if (thu != null) {
                ketQua.addAll(thu.getDsLichHoc());
            }
        }
        return ketQua;
    }

    // Lấy tuần hiện tại từ ngày
    public int getCurrentWeek(LocalDate date) {
        long daysSinceStart = java.time.temporal.ChronoUnit.DAYS.between(ngayBatDauHK, date);
        int soTuan = (int)(daysSinceStart / 7) + 1;
        return Math.max(1, Math.min(20, soTuan));
    }
}