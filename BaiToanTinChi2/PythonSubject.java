package BaiToanTinChi2;

public class PythonSubject extends MonHoc {
	private float diemCC;
	private float diemBTL;
	private float diemGK;
	private float diemCK;
	
	public PythonSubject(String maMonHoc,String tenMonHoc,int soTinChi) {
		  super(maMonHoc, tenMonHoc, soTinChi);
	}

	
	public float getDiemCC() {
		return diemCC;
	}


	public void setDiemCC(float diemCC) {
		this.diemCC = diemCC;
	}


	public float getDiemBTL() {
		return diemBTL;
	}


	public void setDiemBTL(float diemBTL) {
		this.diemBTL = diemBTL;
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


	public float diemMonHoc() {
		float sm =(diemCC + diemBTL*2 + diemGK*2 + diemCK*6)/10;
		return sm;
	}
	
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
}
