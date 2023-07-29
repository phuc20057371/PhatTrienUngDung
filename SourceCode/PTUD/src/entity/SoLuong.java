package entity;

public class SoLuong {
	
	private String maSanPham;
	private String loaiSize;
	private String tenMau;
	private int soLuong;
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getLoaiSize() {
		return loaiSize;
	}
	public void setLoaiSize(String loaiSize) {
		this.loaiSize = loaiSize;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public SoLuong(String maSanPham, String loaiSize, String tenMau, int soLuong) {
		super();
		this.maSanPham = maSanPham;
		this.loaiSize = loaiSize;
		this.tenMau = tenMau;
		this.soLuong = soLuong;
	}
}
