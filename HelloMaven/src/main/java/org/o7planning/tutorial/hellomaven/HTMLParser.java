package org.o7planning.tutorial.hellomaven;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;

public class HTMLParser {
	 public static void parse(File htmlFile, CTrinhChinh ctrinhChinh) throws IOException {
	        Document doc = (Document) Jsoup.parse(htmlFile, "UTF-8");

	        // Bảng thời khóa biểu chính
	        Element table = doc.select("table").first();
	        Elements rows = table.select("tbody > tr");

	        for (Element row : rows) {
	            Elements cells = row.select("td");
	            if (cells.size() < 14) continue; // Không đủ cột
	            
	            // Lấy dữ liệu từ cột
	            String maMH = cells.get(0).text().trim();
	            String tenMH = cells.get(1).text().trim();
	            String nhomTo = cells.get(2).text().trim();
	            String soTinChi = cells.get(3).text().trim();
	            String lop = cells.get(6).text().trim();
	            String thu = cells.get(8).text().trim();
	            String tietBD = cells.get(9).text().trim();
	            String soTiet = cells.get(10).text().trim();
	            String phong = cells.get(11).text().trim();
	            String giangVien = cells.get(12).text().trim();
	            String thoiGianHoc = cells.get(13).text().trim();

	            // Tự động tính tuần học từ chuỗi thời gian học (ví dụ: ---45--- => tuần 4 và 5)
	            int[] tuans = extractTuanHoc(thoiGianHoc);

	            for (int t : tuans) {
	                LichHoc lh = new LichHoc(thu, tietBD, soTiet, phong, giangVien, thoiGianHoc);
	                ctrinhChinh.themLichHoc(t, thu, lh);
	            }
	        }
	    }

	    private static int[] extractTuanHoc(String str) {
	        // Mỗi dấu "-" là tuần trống, mỗi số là tuần có học
	        return str.replaceAll("[^0-9]", "")
	                  .chars()
	                  .map(c -> c - '0')
	                  .toArray();
	    }
}
