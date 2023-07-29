package entity;

import java.util.ArrayList;
import java.util.Date;

public class HoaDonTraHang {
	private String maHDTH;
	private String maHoaDon;
	private Date ngayLapHoaDon;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private double tongTienHoaDon;
	private ArrayList<ChiTietTraHang> chiTietTraHang;
	public String getMaHDTH() {
		return maHDTH;
	}
	public void setMaHDTH(String maHDTH) {
		this.maHDTH = maHDTH;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public double getTongTienHoaDon() {
		return tongTienHoaDon;
	}
	public void setTongTienHoaDon(double tongTienHoaDon) {
		this.tongTienHoaDon = tongTienHoaDon;
	}
	public ArrayList<ChiTietTraHang> getChiTietTraHang() {
		return chiTietTraHang;
	}
	public void setChiTietTraHang(ArrayList<ChiTietTraHang> chiTietTraHang) {
		this.chiTietTraHang = chiTietTraHang;
	}
	public HoaDonTraHang(String maHDTH, String maHoaDon, Date ngayLapHoaDon, KhachHang khachHang, NhanVien nhanVien,
			double tongTienHoaDon, ArrayList<ChiTietTraHang> chiTietTraHang) {
		super();
		this.maHDTH = maHDTH;
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.tongTienHoaDon = tongTienHoaDon;
		this.chiTietTraHang = chiTietTraHang;
	}
}
