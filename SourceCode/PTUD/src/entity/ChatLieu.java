package entity;

import java.util.Objects;

public class ChatLieu {
	private String maCL;
	private String tenCL;
	private String moTa;
	public ChatLieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatLieu(String maCL, String tenCL, String moTa) {
		super();
		this.maCL = maCL;
		this.tenCL = tenCL;
		this.moTa = moTa;
	}
	
	public ChatLieu(String maCL, String tenCL) {
		super();
		this.maCL = maCL;
		this.tenCL = tenCL;
	}
	
	public ChatLieu(String maCL) {
		super();
		this.maCL = maCL;
	}
	public String getMaCL() {
		return maCL;
	}
	public void setMaCL(String maCL) {
		this.maCL = maCL;
	}
	public String getTenCL() {
		return tenCL;
	}
	public void setTenCL(String tenCL) {
		this.tenCL = tenCL;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCL);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatLieu other = (ChatLieu) obj;
		return Objects.equals(maCL, other.maCL);
	}
	@Override
	public String toString() {
		return "ChatLieu [maCL=" + maCL + ", tenCL=" + tenCL + ", moTa=" + moTa + "]";
	}
	
}
