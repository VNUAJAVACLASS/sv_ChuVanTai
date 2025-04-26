package BaiToanTinChiCSDL;

public class MonHoc {
	private int maMH;
	private String tenMH;
	private int soTC;
	private int heSo1;
	private int heSo2;
	private int heSo3;
	private int heSo4;
	private int heSo5;
	
	public MonHoc(String tenMH, int soTC, int heSo1, int heSo2, int heSo3, int heSo4, int heSo5) {
		this.tenMH = tenMH;
		this.soTC = soTC;
		this.heSo1 = heSo1;
		this.heSo2 = heSo2;
		this.heSo3 = heSo3;
		this.heSo4 = heSo4;
		this.heSo5 = heSo5;
	}
	
	public MonHoc(int maMH,String tenMH, int soTC, int heSo1, int heSo2, int heSo3, int heSo4, int heSo5) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soTC = soTC;
		this.heSo1 = heSo1;
		this.heSo2 = heSo2;
		this.heSo3 = heSo3;
		this.heSo4 = heSo4;
		this.heSo5 = heSo5;
	}

	public int getMaMH() {
		return maMH;
	}

	public void setMaMH(int maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public int getSoTC() {
		return soTC;
	}

	public void setSoTC(int soTC) {
		this.soTC = soTC;
	}

	public int getHeSo1() {
		return heSo1;
	}

	public void setHeSo1(int heSo1) {
		this.heSo1 = heSo1;
	}

	public int getHeSo2() {
		return heSo2;
	}

	public void setHeSo2(int heSo2) {
		this.heSo2 = heSo2;
	}

	public int getHeSo3() {
		return heSo3;
	}

	public void setHeSo3(int heSo3) {
		this.heSo3 = heSo3;
	}

	public int getHeSo4() {
		return heSo4;
	}

	public void setHeSo4(int heSo4) {
		this.heSo4 = heSo4;
	}

	public int getHeSo5() {
		return heSo5;
	}

	public void setHeSo5(int heSo5) {
		this.heSo5 = heSo5;
	}
	
}
