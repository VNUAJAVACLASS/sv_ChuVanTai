package BaiToanTinChi;

import java.util.Scanner;

public class NhanSu {
	protected String hoTen;
	protected String diaChi;
	protected String maNS;
	
	public NhanSu() {
		
	}
	
	public NhanSu(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public NhanSu(String hoTen,String diaChi) {
		this.hoTen = hoTen;
		this.diaChi = diaChi;
	}
	
	public NhanSu(String hoTen, String diaChi, String maNS) {
		this(hoTen,diaChi);
		this.maNS = maNS;
		
	}
	
	public void nhapThongTin(Scanner sc) {
		System.out.println("Nhap Ma: ");
		maNS = sc.nextLine();
		System.out.println("Nhap ho va ten: ");
		hoTen = sc.nextLine();
		System.out.println("Nhap dia chi: ");
		diaChi = sc.nextLine();
	}
	
	@Override
	public String toString() {
		return maNS + "-" + hoTen + "-" + diaChi;
	}
	
	@Override
	public boolean equals(Object obj) {
		NhanSu nhanSuKhac = (NhanSu)obj;
		return this.maNS.equals(nhanSuKhac.maNS);
		
	}

}
