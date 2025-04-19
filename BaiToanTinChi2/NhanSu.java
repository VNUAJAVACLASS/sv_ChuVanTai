package BaiToanTinChi2;

import java.util.Scanner;

public abstract class NhanSu {
	protected String hoTen;
	protected String diaChi;
	protected String maNS;
	
	
	

	public NhanSu() {
		
	}
	
	public NhanSu( String maNS) {
		this.maNS = maNS;
	}
	
	public NhanSu(String maNS,String hoTen) {
		this.maNS = maNS;
		this.hoTen = hoTen;
		
	}
	
	public NhanSu( String maNS, String hoTen, String diaChi) {
		this(maNS,hoTen);
		this.diaChi = diaChi;
		
	}
	
	public abstract void nhapThongTin(Scanner sc);
	
	@Override
	public boolean equals(Object obj) {
		NhanSu nhanSuKhac = (NhanSu)obj;
		return this.maNS.equals(nhanSuKhac.maNS);
		
	}

}
