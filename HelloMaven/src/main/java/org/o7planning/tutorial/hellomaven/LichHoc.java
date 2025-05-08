package org.o7planning.tutorial.hellomaven;

public class LichHoc {
		private String thu;
		private String tietBD;
		private String soTiet;
		private String phongHoc;
		private String giangVien;
		private String thoiGianHoc;
		
		public LichHoc() {
			
		}
		
		public LichHoc(String thu, String tietBD,String soTiet,String phongHoc,String giangVien,String thoiGianHoc) {
			this.thu = thu;
			this.tietBD = tietBD;
			this.soTiet = soTiet;
			this.phongHoc = phongHoc;
			this.giangVien = giangVien;
			this.thoiGianHoc = thoiGianHoc;
		}

		public String getThu() {
			return thu;
		}

		public void setThu(String thu) {
			this.thu = thu;
		}

		public String getTietBD() {
			return tietBD;
		}

		public void setTietBD(String tietBD) {
			this.tietBD = tietBD;
		}

		public String getSoTiet() {
			return soTiet;
		}

		public void setSoTiet(String soTiet) {
			this.soTiet = soTiet;
		}

		public String getPhongHoc() {
			return phongHoc;
		}

		public void setPhongHoc(String phongHoc) {
			this.phongHoc = phongHoc;
		}

		public String getGiangVien() {
			return giangVien;
		}

		public void setGiangVien(String giangVien) {
			this.giangVien = giangVien;
		}

		public String getThoiGianHoc() {
			return thoiGianHoc;
		}

		public void setThoiGianHoc(String thoiGianHoc) {
			this.thoiGianHoc = thoiGianHoc;
		}
		
		@Override
	    public String toString() {
	        return String.format("Thứ: %s | Tiết: %s-%s | Phòng: %s | Giảng viên: %s | Thời gian: %s",
	                thu, tietBD, Integer.parseInt(tietBD) + Integer.parseInt(soTiet) - 1, phongHoc, giangVien, thoiGianHoc);
	    }
		
}
