package entity;

public class Size {
	private String maSanPham;
	private String loaiSize;
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
	public Size(String maSanPham, String loaiSize) {
		super();
		this.maSanPham = maSanPham;
		this.loaiSize = loaiSize;
	}
	
}
