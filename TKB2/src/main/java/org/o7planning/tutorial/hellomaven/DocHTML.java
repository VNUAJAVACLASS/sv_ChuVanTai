package org.o7planning.tutorial.hellomaven;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocHTML {
    public List<LichHoc> docThoiKhoaBieu(String filePath) {
        List<LichHoc> danhSachLichHoc = new ArrayList<>();
        try {
            File file = new File(filePath);
            Document doc = Jsoup.parse(file, "UTF-8");

            Element table = doc.selectFirst("table.table");
            if (table == null) {
                System.out.println("Không tìm thấy bảng thời khóa biểu trong file HTML.");
                return danhSachLichHoc;
            }

            Elements rows = table.select("tbody tr");
            int currentRowSpan = 0;
            int cellOffset = 0;

            for (Element row : rows) {
                Elements cells = row.select("td");

                if (cells.size() == 0) continue;

                // Nếu có rowspan thì là hàng đầu tiên của môn học
                if (cells.get(0).hasAttr("rowspan")) {
                    currentRowSpan = Integer.parseInt(cells.get(0).attr("rowspan"));
                    cellOffset = 8;
                } else {
                    currentRowSpan--;
                    cellOffset = 0;
                }

                // Đảm bảo đủ cột để đọc dữ liệu
                if (cells.size() < cellOffset + 6) continue;

                String thu = cells.get(cellOffset).text().trim();
                String tietBD = cells.get(cellOffset + 1).text().trim();
                String soTiet = cells.get(cellOffset + 2).text().trim();
                String phong = cells.get(cellOffset + 3).text().trim();
                String giangVien = cells.get(cellOffset + 4).text().trim();

                Element span = cells.get(cellOffset + 5).selectFirst("span.text-left");
                String thoiGianHoc = (span != null) ? span.text().trim() : cells.get(cellOffset + 5).text().trim();

                LichHoc lichHoc = new LichHoc(thu, tietBD, soTiet, phong, giangVien, thoiGianHoc);
                danhSachLichHoc.add(lichHoc);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file HTML: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
        }
        return danhSachLichHoc;
    }
}