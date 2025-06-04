package org.o7planning.tutorial.hellomaven;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CTrinhChinh qltkb = new CTrinhChinh();

        // Đọc dữ liệu từ HTML
        DocHTML docHTML = new DocHTML();
        List<LichHoc> dsLichHoc = docHTML.docThoiKhoaBieu("D:\\java Space\\WorkSpace\\HelloMaven\\src\\main\\java\\org\\o7planning\\tutorial\\hellomaven\\Chuvantai.html");

        // Thêm từng lịch học vào chương trình chính
        for (LichHoc lh : dsLichHoc) {
            qltkb.themLichHoc(lh);
        }

        // Menu
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Xem TKB hôm nay");
            System.out.println("2. Xem TKB theo tuần");
            System.out.println("3. Xem TKB theo tuần + thứ");
            System.out.println("4. Xem TKB theo ngày cụ thể");
            System.out.println("5. Hiển thị toàn bộ TKB");
            System.out.println("0. Thoát");
            System.out.print(">> Chọn: ");
            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> {
                    LocalDate homNay = LocalDate.now();
                    List<LichHoc> homNayList = qltkb.timLichHocTheoNgay(homNay);
                    System.out.println("Lịch học hôm nay (" + homNay + "):");
                    if (homNayList.isEmpty()) {
                        System.out.println("Không có lịch học.");
                    } else {
                        homNayList.forEach(System.out::println);
                    }
                }
                case 2 -> {
                    System.out.print("Nhập tuần: ");
                    int t = Integer.parseInt(sc.nextLine());
                    Tuan tuan = qltkb.timLichHocTheoTuan(t);
                    if (tuan == null) {
                        System.out.println("Không có lịch học cho tuần này.");
                    } else {
                        System.out.println(tuan);
                    }
                }
                case 3 -> {
                    System.out.print("Nhập tuần: ");
                    int t = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập thứ (2-7): ");
                    String thu = sc.nextLine();
                    Tuan tuan = qltkb.timLichHocTheoTuan(t);
                    if (tuan == null || tuan.getThu(thu) == null) {
                        System.out.println("Không có lịch học.");
                    } else {
                        List<LichHoc> ds = tuan.getThu(thu).getDsLichHoc();
                        ds.forEach(System.out::println);
                    }
                }
                case 4 -> {
                    System.out.print("Nhập ngày (dd/mm/yyyy): ");
                    String[] parts = sc.nextLine().split("/");
                    int ngay = Integer.parseInt(parts[0]);
                    int thang = Integer.parseInt(parts[1]);
                    int nam = Integer.parseInt(parts[2]);
                    LocalDate date = LocalDate.of(nam, thang, ngay);
                    List<LichHoc> list = qltkb.timLichHocTheoNgay(date);
                    if (list.isEmpty()) {
                        System.out.println("Không có lịch học.");
                    } else {
                        list.forEach(System.out::println);
                    }
                }
                case 5 -> qltkb.hienThiThoiKhoaBieu();
                case 0 -> {
                    System.out.println("Tạm biệt!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}