package BaiToanTinChiCSDL;

public class NhanSu {
	private int maND;
	private String hoTen;
	private String diaChi;
	private String matKhau;
	private String loai;
	
	public NhanSu(String hoTen, String diaChi, String matKhau, String loai) {
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.loai = loai;
	}
	
	public NhanSu(int maND,String hoTen, String diaChi, String matKhau, String loai) {
		this.maND = maND;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.loai = loai;
	}

	public int getMaND() {
		return maND;
	}

	public void setMaND(int maND) {
		this.maND = maND;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}
}
