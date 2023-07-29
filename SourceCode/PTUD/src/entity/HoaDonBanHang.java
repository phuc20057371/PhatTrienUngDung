package entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class HoaDonBanHang {
	private String maHoaDon;
	private Date ngayLapHoaDon;
	private KhachHang maKhachHang;
	private NhanVien maNhanVien;
	private double giamGia;
	private double tienKhachDua;
	private double tongTienHD;
	private ArrayList<ChiTietHoaDon> chiTietHoaDon;
	
	public double getTienKhachDua() {
		return tienKhachDua;
	}

	public void setTienKhachDua(double tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}

	public ArrayList<ChiTietHoaDon> getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(ArrayList<ChiTietHoaDon> chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public double getTongTienHD() {
		return tongTienHD;
	}
	public void setTongTienHD(double tongTienHD) {
		this.tongTienHD = tongTienHD;
	}

	public HoaDonBanHang(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
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
	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	public HoaDonBanHang(String maHoaDon, Date ngayLapHoaDon, KhachHang maKhachHang, NhanVien maNhanVien,
			double giamGia, double tienKhachDua, double tongTienHD, ArrayList<ChiTietHoaDon> chiTietHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.giamGia = giamGia;
		this.tienKhachDua = tienKhachDua;
		this.tongTienHD = tongTienHD;
		this.chiTietHoaDon = chiTietHoaDon;
	}
	public HoaDonBanHang(String maHoaDon, Date ngayLapHoaDon, KhachHang maKhachHang, double tongTienHD) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.maKhachHang = maKhachHang;
		this.tongTienHD = tongTienHD;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonBanHang other = (HoaDonBanHang) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	
}
