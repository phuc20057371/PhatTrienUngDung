package entity;

import java.util.Objects;

public class ChiTietHoaDon {
	private ChiTietSanPham maCTSP;
	private String maHD;
	private int soLuong;
	
	public ChiTietSanPham getMaCTSP() {
		return maCTSP;
	}
	public void setMaCTSP(ChiTietSanPham maCTSP) {
		this.maCTSP = maCTSP;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public ChiTietHoaDon(ChiTietSanPham maCTSP, String maHD, int soLuong) {
		super();
		this.maCTSP = maCTSP;
		this.maHD = maHD;
		this.soLuong = soLuong;
	}
	
}
