package BaiToanTinChi;

import java.util.Scanner;

public class GiangVien extends NhanSu {
	private String matKhau;
	
	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public GiangVien() {
		
	}

	public GiangVien(String maNS,String matKhau) {
		this.maNS = maNS;
		this.matKhau = matKhau;
	}
	
	public GiangVien(String maNS, String hoTen, String diaChi) {
		super(maNS,hoTen,diaChi);
	}
	
	@Override
	public void nhapThongTin(Scanner sc) {
		super.nhapThongTin(sc);//Goi phuong thuc nhap thong tin cua lop cha
		System.out.println("Nhap mat khau: ");
		matKhau = sc.nextLine();
	}
}
