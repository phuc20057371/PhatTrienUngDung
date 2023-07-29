package entity;

import java.util.Objects;

public class ThuongHieu {
	private String maTH;
	private String tenTH;
	private String moTa;
	public ThuongHieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThuongHieu(String maTH, String tenTH, String moTa) {
		super();
		this.maTH = maTH;
		this.tenTH = tenTH;
		this.moTa = moTa;
	}
	public ThuongHieu(String maTH, String tenTH) {
		super();
		this.maTH = maTH;
		this.tenTH = tenTH;
	}
	public String getMaTH() {
		return maTH;
	}
	public void setMaTH(String maTH) {
		this.maTH = maTH;
	}
	public String getTenTH() {
		return tenTH;
	}
	public void setTenTH(String tenTH) {
		this.tenTH = tenTH;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public ThuongHieu(String maTH) {
		super();
		this.maTH = maTH;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThuongHieu other = (ThuongHieu) obj;
		return Objects.equals(maTH, other.maTH);
	}
	@Override
	public String toString() {
		return "ThuongHieu [maTH=" + maTH + ", tenTH=" + tenTH + ", moTa=" + moTa + "]";
	}
	
}	
