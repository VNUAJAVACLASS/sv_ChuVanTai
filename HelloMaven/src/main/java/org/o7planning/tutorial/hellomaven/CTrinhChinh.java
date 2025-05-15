package org.o7planning.tutorial.hellomaven;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class CTrinhChinh {
    Map<Integer, Tuan> dsTuan = new HashMap<>();

    // Ngày bắt đầu học kỳ
    private static final int NAM_BD = 2025;
    private static final int THANG_BD = 1; // Tháng 1
    private static final int NGAY_BD = 13; // Ngày 13

    // Thêm lịch học theo tuần và thứ (dùng trong HTMLParser)
    public void themLichHoc(int soTuan, String soThu, LichHoc lh) {
        dsTuan.putIfAbsent(soTuan, new Tuan(soTuan));
        dsTuan.get(soTuan).themLichHoc(soThu, lh);
    }

    // Xem thời khóa biểu của tuần
    public void xemTheoTuan(int soTuan) {
        if (!dsTuan.containsKey(soTuan)) {
            System.out.println("Không có dữ liệu tuần " + soTuan);
            return;
        }

        Tuan tuan = dsTuan.get(soTuan);
        System.out.println("==== Thời khóa biểu tuần " + soTuan + " ====");

        for (int i = 2; i <= 8; i++) {
            String soThu = (i == 8) ? "CN" : String.valueOf(i);
            Thu thu = tuan.getThu(soThu);
            String ngay = quyDoiNgay(soTuan, soThu);

            System.out.println("Ngày " + ngay + " (Thứ " + soThu + "):");
            if (thu != null && !thu.getDsLichHoc().isEmpty()) {
                thu.hienThiLichHoc();
            } else {
                System.out.println("  (Không có lịch học)");
            }
        }
    }

    // Xem thời khóa biểu hôm nay
    public void xemHomNay() {
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        String thu = convertDayOfWeekToThu(dayOfWeek);

        int soTuan = getSoTuanFromDate(cal);
        xemTheoTuanThu(soTuan, thu);
    }

    // Xem thời khóa biểu ngày cụ thể
    public void xemTheoNgay(int ngay, int thang, int nam) {
        Calendar cal = new GregorianCalendar(nam, thang - 1, ngay);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        String thu = convertDayOfWeekToThu(dayOfWeek);

        int soTuan = getSoTuanFromDate(cal);
        xemTheoTuanThu(soTuan, thu);
    }

    // Xem TKB theo tuần và thứ cụ thể
    public void xemTheoTuanThu(int soTuan, String soThu) {
        if (!dsTuan.containsKey(soTuan)) {
            System.out.println("Không có tuần " + soTuan);
            return;
        }

        Thu thu = dsTuan.get(soTuan).getThu(soThu);
        String ngay = quyDoiNgay(soTuan, soThu);
        System.out.println("Ngày " + ngay + " (Thứ " + soThu + "):");

        if (thu != null && !thu.getDsLichHoc().isEmpty()) {
            thu.hienThiLichHoc();
        } else {
            System.out.println("  (Không có lịch học)");
        }
    }

    // Quy đổi tuần + thứ thành ngày (dạng chuỗi)
    public String quyDoiNgay(int soTuan, String soThu) {
        Calendar cal = new GregorianCalendar(NAM_BD, THANG_BD - 1, NGAY_BD);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.add(Calendar.WEEK_OF_YEAR, soTuan - 1);

        int dayOffset = soThu.equals("CN") ? 6 : Integer.parseInt(soThu) - 2;
        cal.add(Calendar.DAY_OF_MONTH, dayOffset);

        return String.format("%02d/%02d/%d", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
    }

    // Helper: chuyển DAY_OF_WEEK của Calendar thành chuỗi thứ
    private String convertDayOfWeekToThu(int dayOfWeek) {
        if (dayOfWeek == Calendar.SUNDAY) return "CN";
        return String.valueOf(dayOfWeek);
    }

    // Helper: tính số tuần học kỳ từ một ngày bất kỳ
    private int getSoTuanFromDate(Calendar cal) {
        Calendar bd = new GregorianCalendar(NAM_BD, THANG_BD - 1, NGAY_BD);
        long diffMillis = cal.getTimeInMillis() - bd.getTimeInMillis();
        int diffDays = (int) (diffMillis / (1000 * 60 * 60 * 24));
        return diffDays / 7 + 1;
    }
}