package entity;

public class ChiTietTraHang {
	private ChiTietSanPham CTSP;
	private String maHDTH;
	private int soLuong;
	public ChiTietSanPham getCTSP() {
		return CTSP;
	}
	public void setCTSP(ChiTietSanPham cTSP) {
		CTSP = cTSP;
	}
	public String getMaHDTH() {
		return maHDTH;
	}
	public void setMaHDTH(String maHDTH) {
		this.maHDTH = maHDTH;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public ChiTietTraHang(ChiTietSanPham cTSP, String maHDTH, int soLuong) {
		super();
		CTSP = cTSP;
		this.maHDTH = maHDTH;
		this.soLuong = soLuong;
	}
}
