package entity;

public class Mau {
	private String maSanPham;
	private String tenMau;
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	public Mau(String maSanPham, String tenMau) {
		super();
		this.maSanPham = maSanPham;
		this.tenMau = tenMau;
	}
	@Override
	public String toString() {
		return "" + tenMau + ",";
	}
}
