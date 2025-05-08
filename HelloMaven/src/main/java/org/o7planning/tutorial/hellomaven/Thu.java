package org.o7planning.tutorial.hellomaven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Thu {
	private String tenThu; // Ví dụ: "2", "3", ..., "CN"
    private List<LichHoc> dsLichHoc;

    public Thu(String tenThu) {
        this.tenThu = tenThu;
        this.dsLichHoc = new ArrayList<>();
    }

    public String getTenThu() {
        return tenThu;
    }

    public void setTenThu(String tenThu) {
        this.tenThu = tenThu;
    }

    public List<LichHoc> getDsLichHoc() {
        return dsLichHoc;
    }

    public void setDsLichHoc(List<LichHoc> dsLichHoc) {
        this.dsLichHoc = dsLichHoc;
    }

    public void themLichHoc(LichHoc lh) {
        this.dsLichHoc.add(lh);
    }
    
    public void hienThiLichHoc() {
        for (LichHoc lichHoc : dsLichHoc) {
            System.out.println(lichHoc);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lịch học Thứ " + tenThu + ":\n");
        if (dsLichHoc.isEmpty()) {
            sb.append("  (Không có lịch học)\n");
        } else {
            for (LichHoc lh : dsLichHoc) {
                sb.append("  - ").append(lh.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
