package BaiToanTinChi2;


public abstract class MonHoc implements ICreditSubject {
	private String maMonHoc;
	private String tenMonHoc;
	private int soTinChi;
	
	public MonHoc() {
		
	}

	public MonHoc(String maMonHoc, String tenMonHoc,int soTinChi) {
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.soTinChi = soTinChi;	
	}
	
	//Phuong thuc tinh diem hoc phan
	public abstract float diemMonHoc();
	
	//TInh thang diem sang thang diem 4
	public float chuyenSangHeBon() {
		float diemHe10 = diemMonHoc();
		float diemHe4 = -1;
		if(diemHe10<=3.9) {
			diemHe4 =0;
		}else if(diemHe10<=4.9) {
			diemHe4 = 1;
		}else if(diemHe10<=5.4) {
			diemHe4 = 1.5f;
		}else if(diemHe10<=6.4) {
			diemHe4 = 2;
		}else if(diemHe10<=6.9) {
			diemHe4 = 2.5f;
		}else if(diemHe10<=7.4) {
			diemHe4 = 3;
		}else if(diemHe10<=8.4) {
			diemHe4 = 3.5f;
		}else if(diemHe10<=10) {
			diemHe4 = 4;
		}
		return diemHe4;
	}
	
	public String chuyenSangHeChu() {
		float diemHe10 = diemMonHoc();
		String diemHeChu = null;
		if(diemHe10<=3.9) {
			diemHeChu = "F";
		}else if(diemHe10<=4.9) {
			diemHeChu = "D";
		}else if(diemHe10<=5.4) {
			diemHeChu = "D+";
		}else if(diemHe10<=6.4) {
			diemHeChu = "C";
		}else if(diemHe10<=6.9) {
			diemHeChu = "C+";
		}else if(diemHe10<=7.4) {
			diemHeChu = "B";
		}else if(diemHe10<=8.4) {
			diemHeChu = "B+";
		}else if(diemHe10<=10) {
			diemHeChu = "A";
		}
		
		return diemHeChu;
	}
	
	public float chuyenSangHeBon(String diemHeChu) {
		float diemHe4 = -1;
		switch(diemHeChu) {
		case "F":
			diemHe4 = 0;
			break;
			
		case "D":
			diemHe4 = 1;
			break;
			
		case "D+":
			diemHe4 = 1.5f;
			break;
		
		case "C":
			diemHe4 = 2;
			break;
			
		case "C+":
			diemHe4 = 2.5f;
			break;
			
		case "B":
			diemHe4 = 3;
			break;
			
		case "B+":
			diemHe4 = 3.5f;
			break;
			
		case "A":
			diemHe4 = 4;
			break;
		}
		
		return diemHe4;
	}
	
	
	public String getTenMonHoc(String tenMonHoc){
		return tenMonHoc;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	/*public float getDiemCC() {
		return diemCC;
	}

	public void setDiemCC(float diemCC) {
		this.diemCC = diemCC;
	}

	public float getDiemGK() {
		return diemGK;
	}

	public void setDiemGK(float diemGK) {
		this.diemGK = diemGK;
	}

	public float getDiemCK() {
		return diemCK;
	}

	public void setDiemCK(float diemCK) {
		this.diemCK = diemCK;
	}
	*/
	
	/*@Override
	public String toString() {
		return tenMonHoc + "-" + maMonHoc + "-" + soTinChi + "\n" +  diemMonHoc() + "-" + chuyenSangHeBon() + "-" + chuyenSangHeChu(); 
	}*/
	
	
	/*public static void main(String[] args) {
		MonHoc MH = new MonHoc("TH1511","Lap trinh Java",3);
		MH.setDiemCC(8.5f);
		MH.setDiemGK(8);
		MH.setDiemCK(9.2f);
		System.out.println(MH);
		
		MonHoc MH2 = new MonHoc();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma mon hoc: ");
		String maMonHoc = sc.nextLine();
		System.out.println("Nhap ten mon hoc: ");
		String tenMonHoc = sc.nextLine();
		System.out.println("Nhap so tin chi: ");
		int soTinChi = sc.nextInt();
		
		MH2.setMaMonHoc(maMonHoc);
		MH2.setTenMonHoc(tenMonHoc);
		MH2.setSoTinChi(soTinChi);
		
		System.out.println(MH2);
	}*/
	
}
