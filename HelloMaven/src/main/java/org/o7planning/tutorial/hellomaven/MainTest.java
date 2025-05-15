package org.o7planning.tutorial.hellomaven;

import java.io.File;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainTest {
    public static void main(String[] args) throws Exception {
        CTrinhChinh qltkb = new CTrinhChinh();
        Document doc = Jsoup.parse(new File("D:\\java Space\\WorkSpace\\HelloMaven\\src\\main\\java\\org\\o7planning\\tutorial\\hellomaven\\Chuvantai.html"), "UTF-8");

        Elements rows = doc.select("tbody tr");
        for (Element row : rows) {
            Elements tds = row.select("td");
            if (tds.size() >= 14) {
                String thu = tds.get(8).text();
                String tietBD = tds.get(9).text();
                String soTiet = tds.get(10).text();
                String phong = tds.get(11).text();
                String giangVien = tds.get(12).text();
                String thoiGianHoc = tds.get(13).text();

                if (thu.isBlank() || tietBD.isBlank() || soTiet.isBlank() || thoiGianHoc.isBlank()) {
                    continue; // Bỏ qua dòng thiếu thông tin cần thiết
                }

                LichHoc lh = new LichHoc(thu, tietBD, soTiet, phong, giangVien, thoiGianHoc);

                // Duyệt chuỗi tuần, thêm từng tuần có lịch học
                for (char c : thoiGianHoc.toCharArray()) {
                    if (Character.isDigit(c)) {
                        int tuan = Character.getNumericValue(c);
                        qltkb.themLichHoc(tuan, thu, lh);
                    }
                }
            }
        }

        // Menu
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Xem TKB hôm nay");
            System.out.println("2. Xem TKB theo tuần");
            System.out.println("3. Xem TKB theo tuần + thứ");
            System.out.println("4. Xem TKB theo ngày cụ thể");
            System.out.println("0. Thoát");
            System.out.print(">> Chọn: ");
            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    qltkb.xemHomNay();
                    break;
                case 2:
                    System.out.print("Nhập tuần: ");
                    int t = Integer.parseInt(sc.nextLine());
                    qltkb.xemTheoTuan(t);
                    break;
                case 3:
                    System.out.print("Tuần: ");
                    t = Integer.parseInt(sc.nextLine());
                    System.out.print("Thứ: ");
                    String thu = sc.nextLine();
                    qltkb.xemTheoTuanThu(t, thu);
                    break;
                case 4:
                    System.out.print("Nhập ngày (dd/mm/yyyy): ");
                    String[] parts = sc.nextLine().split("/");
                    int ngay = Integer.parseInt(parts[0]);
                    int thang = Integer.parseInt(parts[1]);
                    int nam = Integer.parseInt(parts[2]);
                    qltkb.xemTheoNgay(ngay, thang, nam);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}