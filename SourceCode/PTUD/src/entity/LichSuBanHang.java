package entity;

import java.sql.Date;

import javax.management.loading.PrivateClassLoader;

public class LichSuBanHang {
	private Date ngay;
	private String maHD;
	private String tenNV;
	private String tenKH;
	private String SDT;
	private double tongTienHD;
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public double getTongTienHD() {
		return tongTienHD;
	}
	public void setTongTienHD(double tongTienHD) {
		this.tongTienHD = tongTienHD;
	}
	public LichSuBanHang(Date ngay, String maHD, String tenNV, String tenKH, String sDT, double tongTienHD) {
		super();
		this.ngay = ngay;
		this.maHD = maHD;
		this.tenNV = tenNV;
		this.tenKH = tenKH;
		SDT = sDT;
		this.tongTienHD = tongTienHD;
	}
	
}
