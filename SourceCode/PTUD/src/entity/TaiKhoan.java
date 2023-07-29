package entity;

import java.util.Objects;

public class TaiKhoan {
	private String id;
	private String matKhau;
	private String email;
	private NhanVien maNV;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public NhanVien getMaNV() {
		return maNV;
	}
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}
	public TaiKhoan(String id) {
		super();
		this.id = id;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String id, String matKhau, String email, NhanVien maNV) {
		super();
		this.id = id;
		this.matKhau = matKhau;
		this.email = email;
		this.maNV = maNV;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "TaiKhoan [id=" + id + ", matKhau=" + matKhau + ", email=" + email + ", maNV=" + maNV + "]";
	}
	
	
	
}
