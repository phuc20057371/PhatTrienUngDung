package entity;

import java.util.Objects;

public class XuatXu {
	private String maXX;
	private String tenXX;
	private String moTa;
	public XuatXu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XuatXu(String maXX, String tenXX, String moTa) {
		super();
		this.maXX = maXX;
		this.tenXX = tenXX;
		this.moTa = moTa;
	}
	public XuatXu(String maXX, String tenXX) {
		super();
		this.maXX = maXX;
		this.tenXX = tenXX;
	}
	public XuatXu(String maXX) {
		super();
		this.maXX = maXX;
	}
	public String getMaXX() {
		return maXX;
	}
	public void setMaXX(String maXX) {
		this.maXX = maXX;
	}
	public String getTenXX() {
		return tenXX;
	}
	public void setTenXX(String tenXX) {
		this.tenXX = tenXX;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maXX);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XuatXu other = (XuatXu) obj;
		return Objects.equals(maXX, other.maXX);
	}
	@Override
	public String toString() {
		return "XuatXu [maXX=" + maXX + ", tenXX=" + tenXX + ", moTa=" + moTa + "]";
	}
	
}
