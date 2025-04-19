package BaiToanTinChi2;

public class JavaSubject extends MonHoc {
	private float diemCC;
	private float diemGK;
	private float diemCK;
	
	public JavaSubject(String maMonHoc,String tenMonHoc,int soTinChi) {
		  super(maMonHoc, tenMonHoc, soTinChi);
		
	}
	
	public float getDiemCC() {
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

	@Override
	public float diemMonHoc() {
		float sm =(diemCC + diemGK*3 + diemCK*6)/10;
		return sm;
	}
	

}
