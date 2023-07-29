package entity;


import java.util.Date;
import java.util.Objects;

public class CaLam {
	private String maCaLam;
	private Date ngay;
	private String buoiLam;
	private NhanVien maNV;
	public CaLam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaLam(String maCaLam,Date ngay, String buoiLam, NhanVien maNV) {
		super();
		this.maCaLam = maCaLam;
		this.ngay = ngay;
		this.buoiLam = buoiLam;
		this.maNV = maNV;
	}
	public CaLam(String maCaLam, NhanVien maNV) {
		super();
		this.maCaLam = maCaLam;
		this.maNV = maNV;
	}
	public CaLam(String maCaLam) {
		super();
		this.maCaLam = maCaLam;
	}
	public String getMaCaLam() {
		return maCaLam;
	}
	public void setMaCaLam(String maCaLam) {
		this.maCaLam = maCaLam;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public String getBuoiLam() {
		return buoiLam;
	}
	public void setBuoiLam(String buoiLam) {
		this.buoiLam = buoiLam;
	}
	public NhanVien getMaNV() {
		return maNV;
	}
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCaLam);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaLam other = (CaLam) obj;
		return Objects.equals(maCaLam, other.maCaLam);
	}
	@Override
	public String toString() {
		return "CaLam [maCaLam=" + maCaLam + ", ngay=" + ngay + ", buoiLam=" + buoiLam + ", maNV=" + maNV + "]";
	}
	
}
