package BaiToanTinChi2;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SinhVien extends NhanSu {
	
	private String tenLop;
	private Map<String, MonHoc> monHocMap = new HashMap<>();
	//private List<MonHoc> MonHocList = new ArrayList<MonHoc>();
	
	public SinhVien() {
		
	}

	public SinhVien(String maNS) {
		this.maNS = maNS;
	}
	
	public SinhVien(String maNS,String hoTen) {
		super(maNS,hoTen);
	}
	
	public SinhVien(String maNS,String hoTen, String diaChi) {
		super(maNS,hoTen);
		this.diaChi = diaChi;
	}
	
	public SinhVien(String maNS,String hoTen, String diaChi, String tenLop ) {
		this(maNS,hoTen,diaChi);
		this.tenLop = tenLop;
	}
	
	public void addMonHoc(MonHoc MH) {
		monHocMap.put(MH.getMaMonHoc(), MH);
	}
	
	public float diemTBMonHoc() {
		float ts = 0;
		int tc = 0;
		for(MonHoc MH: monHocMap.values()) {
			ts += MH.getSoTinChi()* MH.chuyenSangHeBon();
			tc += MH.getSoTinChi();		
			}
	return ts/tc;
	}
	
	@Override
	public void nhapThongTin(Scanner sc) {
		System.out.println("Nhap Ma: ");
		maNS = sc.nextLine();
		System.out.println("Nhap ho va ten: ");
		hoTen = sc.nextLine();
		System.out.println("Nhap ten lop: ");
		tenLop = sc.nextLine();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		//Hai SV la tuong duong ve hoc luc neu tri tuyet doi hieu so diemTBHK < 0,3
		SinhVien sinhVienKhac = (SinhVien)obj;
		float d = Math.abs(this.diemTBMonHoc() - sinhVienKhac.diemTBMonHoc());
		return d <0.3;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	
	public void xoaMonHocTheoMa(String maMonHoc) {
        if (monHocMap.containsKey(maMonHoc)) {
            monHocMap.remove(maMonHoc);
            System.out.println("Đã xóa môn học có mã: " + maMonHoc);
        } else {
            System.out.println("Không tìm thấy môn học với mã: " + maMonHoc);
        }
    }
	
	@Override
	public String toString() {
		return maNS + "-" + hoTen + "-" + tenLop;
	}
	
	public Map<String, MonHoc> timMonHocTheoTen(String tenMonHoc) {
	    Map<String, MonHoc> ketQua = new HashMap<>();
	    tenMonHoc.toLowerCase();

	    for (MonHoc mh : monHocMap.values()) {
	        if (mh.getTenMonHoc().toLowerCase().contains(tenMonHoc)) {
	            ketQua.put(mh.getTenMonHoc(), mh);  // Lưu tên môn học làm khóa
	        }
	    }

	    return ketQua;
	}

}
