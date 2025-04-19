package BaiToanTinChi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRM {
	private List<NhanSu> hrList;
	
	public HRM() {
		hrList = new ArrayList<NhanSu>();
	}
	
	public void addHR(NhanSu NS) {
		hrList.add(NS);
	}
	
	public void addHR(Scanner sc) {
		int loai;
		System.out.println("Chon loai nhan su(sv:0 ; gv:1): ");
		loai = sc.nextInt(); sc.nextLine();
		
		NhanSu NS = null;
		if(loai ==0) {
			NS = new SinhVien();
		}else if(loai == 1) {
			NS = new GiangVien();
		}
		
		NS.nhapThongTin(sc);
		
		addHR(NS);
	}
	
	public void printHRList() {
		for(NhanSu NS: hrList) {
				System.out.println(NS.toString());
			}
		}
	
	public void printSinhVienList() {
		for(NhanSu NS: hrList) {
			if(NS instanceof SinhVien) {
				SinhVien std = (SinhVien)NS;
				System.out.println(std.getTenLop());
			}
		}
	}
	
	public void khoiTaoData() {
		NhanSu h1 = new SinhVien("683090","Le Thi Thu Hue","K69KTC");
		NhanSu h2 = new GiangVien("cnpm01","Nguyen Huu Giang","Ha Noi");
		
		addHR(h1);
		addHR(h2);
	}
	
	public void khoiTaoData(Scanner sc) {
		String chon;
		do {
			//Nhap thong tin nhan su
			addHR(sc);
			
			//Hoi muon nhap tiep khong
			System.out.println("Ban co muon nhap tiep (c/k)");
			chon = sc.nextLine();
		}while("c".equalsIgnoreCase(chon));
	}
	
	public List<NhanSu> timNhanSu(String maNS){
		List<NhanSu> NSList = new ArrayList<NhanSu>();
		for(NhanSu NS: hrList) {
			if(NS.maNS != null && NS.maNS.contains(maNS)) {
				NSList.add(NS);;
				printHRList();
			}
		}
		return NSList;
	}
	
	public static void main(String[] args) {
		HRM hrm = new HRM();
		Scanner sc = new Scanner(System.in);
		hrm.khoiTaoData(sc);
		hrm.printHRList();
		hrm.timNhanSu("68");
	}
}
