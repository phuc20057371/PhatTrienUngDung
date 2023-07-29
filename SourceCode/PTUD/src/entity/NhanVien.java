package entity;


import java.util.Date;
import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String soDienThoai;
	private String diaChi;
	private String chucVu;
	private String gioiTinh;
	private Date ngaySinh;
	private Date ngayVaoLam;
	private String tinhTrang;
	public NhanVien(String maNV, String tenNV, String soDienThoai, String diaChi, String chucVu, String gioiTinh,
			Date ngaySinh, Date ngayVaoLam) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
	}
	
	
	public NhanVien(String maNV, String tenNV, String soDienThoai, String diaChi, String chucVu, String gioiTinh,
			Date ngaySinh, Date ngayVaoLam, String tinhTrang) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
		this.tinhTrang = tinhTrang;
	}


	public String getTinhTrang() {
		return tinhTrang;
	}


	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}


	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV, String ten) {
		super();
		this.maNV = maNV;
		this.tenNV = ten;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi
				+ ", chucVu=" + chucVu + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", ngayVaoLam="
				+ ngayVaoLam + "]";
	}
	
}
