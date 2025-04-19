package BaiToanTinChi;

import java.util.ArrayList;
import java.util.List;

public class SinhVien extends NhanSu {
	
	private String tenLop;
	private List<MonHoc> MonHocList = new ArrayList<MonHoc>();
	
	public SinhVien() {
		
	}

	public SinhVien(String maNS) {
		this.maNS = maNS;
	}
	
	public SinhVien(String maNS,String hoTen) {
		super(maNS,hoTen);
	}
	
	public SinhVien(String maNS,String hoTen, String tenLop) {
		super(maNS,hoTen);
		this.tenLop = tenLop;
	}
	
	public SinhVien(String maNS,String hoTen, String tenLop, String diaChi ) {
		this(maNS,tenLop,hoTen);
		this.diaChi = diaChi;
	}
	
	public void addMonHoc(MonHoc MH) {
		MonHocList.add(MH);
	}
	
	public float diemTBMonHoc() {
		float ts = 0;
		int tc = 0;
		for(MonHoc MH: MonHocList) {
			ts += MH.getSoTinChi()* MH.chuyenSangHeBon();
			tc += MH.getSoTinChi();		
			}
	return ts/tc;
	}
	
	@Override
	public String toString() {
		return maNS + "-" + hoTen + "-" + tenLop;
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
	
	public static void main(String[] args) {
		SinhVien std = new SinhVien("683177","Chu Van Tai","K68CNTTA");
		
		MonHoc sub1 = new MonHoc("TH23002","LTHDT",3);
		sub1.setDiemCC(10);
		sub1.setDiemGK(8.5f);
		sub1.setDiemCK(8);
		
		MonHoc sub2 = new MonHoc("TH20345","CTDLGT",4);
		sub2.setDiemCC(10);
		sub2.setDiemGK(6.4f);
		sub2.setDiemCK(9);
		
		MonHoc sub3 = new MonHoc("TH2301","HQTCSDL",3);
		sub3.setDiemCC(8);
		sub3.setDiemGK(7);
		sub3.setDiemCK(7);
		
		std.addMonHoc(sub1);
		std.addMonHoc(sub2);
		std.addMonHoc(sub3);
		
		System.out.println("TBHK"+std.diemTBMonHoc());
	}
}
