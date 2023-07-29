package entity;

public class ChiTietSanPham {
	@Override
	public String toString() {
		return "ChiTietSanPham [maChiTietSanPham=" + maChiTietSanPham + ", maSanPham=" + maSanPham + ", size=" + size
				+ ", mau=" + mau + ", soLuong=" + soLuong + "]";
	}
	private String maChiTietSanPham;
	private String maSanPham;
	private String size;
	private String mau;
	private int soLuong;
	public String getMaChiTietSanPham() {
		return maChiTietSanPham;
	}
	public void setMaChiTietSanPham(String maChiTietSanPham) {
		this.maChiTietSanPham = maChiTietSanPham;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getMau() {
		return mau;
	}
	public void setMau(String mau) {
		this.mau = mau;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public ChiTietSanPham(String maChiTietSanPham, String maSanPham, String size, String mau, int soLuong) {
		super();
		this.maChiTietSanPham = maChiTietSanPham;
		this.maSanPham = maSanPham;
		this.size = size;
		this.mau = mau;
		this.soLuong = soLuong;
	}
	
	public ChiTietSanPham(String maChiTietSanPham) {
		super();
		this.maChiTietSanPham = maChiTietSanPham;
	}
	public ChiTietSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
}
