package org.o7planning.tutorial.hellomaven;

import java.util.HashMap;
import java.util.Map;

public class Tuan {
	private int soTuan;
    private Map<String, Thu> dsThu; // Key: 2 (Thứ Hai) đến 8 (Chủ Nhật)

    public Tuan(int soTuan) {
        this.soTuan = soTuan;
        this.dsThu = new HashMap<>();
    }

    public int getSoTuan() {
        return soTuan;
    }

    public void setSoTuan(int soTuan) {
        this.soTuan = soTuan;
    }

    public Map<String, Thu> getDsThu() {
        return dsThu;
    }

    public Thu getThu(int soThu) {
        return dsThu.get(soThu);
    }

    public void themLichHoc(String soThu, LichHoc lichHoc) {
        Thu thu = dsThu.get(soThu);
        if (thu == null) {
            thu = new Thu(soThu);
            dsThu.put(soThu, thu);
        }
        thu.themLichHoc(lichHoc);
    }
    
    public void hienThiThoiKhoaBieu() {
        for (Map.Entry<String, Thu> entry : dsThu.entrySet()) {
            System.out.println("Thứ " + entry.getKey() + ":");
            entry.getValue().hienThiLichHoc();
        	}
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tuần ").append(soTuan).append(":\n");
        for (String thu : dsThu.keySet()) {
            sb.append("  Thứ ").append(thu).append(":\n");
            sb.append(dsThu.get(thu)).append("\n");
        }
        return sb.toString();
    }
}
