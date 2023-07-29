package entity;

import java.util.ArrayList;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private double giaGoc;
	private String hinhAnh;
	private String moTa;
	private String gioiTinh;
	private String phongCach;
	private String loai;
	private String coAo;
	private int soLuongLoi;
	private ChatLieu chatLieu;
	private ThuongHieu thuongHieu;
	private XuatXu xuatXu;
	private NhaCungCap nhaCungCap;
	private String tinhTrang;
	private ArrayList<ChiTietSanPham> chiTietSanPham;

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getPhongCach() {
		return phongCach;
	}

	public void setPhongCach(String phongCach) {
		this.phongCach = phongCach;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getCoAo() {
		return coAo;
	}

	public void setCoAo(String coAo) {
		this.coAo = coAo;
	}

	public int getSoLuongLoi() {
		return soLuongLoi;
	}

	public void setSoLuongLoi(int soLuongLoi) {
		this.soLuongLoi = soLuongLoi;
	}

	public ChatLieu getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(ChatLieu chatLieu) {
		this.chatLieu = chatLieu;
	}

	public ThuongHieu getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(ThuongHieu thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public XuatXu getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(XuatXu xuatXu) {
		this.xuatXu = xuatXu;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public ArrayList<ChiTietSanPham> getChiTietSanPham() {
		return chiTietSanPham;
	}

	public void setChiTietSanPham(ArrayList<ChiTietSanPham> chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}

	public SanPham(String maSanPham, String tenSanPham, double giaGoc, String hinhAnh, String moTa, String gioiTinh,
			String phongCach, String loai, String coAo, int soLuongLoi, ChatLieu chatLieu, ThuongHieu thuongHieu,
			XuatXu xuatXu, NhaCungCap nhaCungCap, String tinhTrang, ArrayList<ChiTietSanPham> chiTietSanPham) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaGoc = giaGoc;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
		this.gioiTinh = gioiTinh;
		this.phongCach = phongCach;
		this.loai = loai;
		this.coAo = coAo;
		this.soLuongLoi = soLuongLoi;
		this.chatLieu = chatLieu;
		this.thuongHieu = thuongHieu;
		this.xuatXu = xuatXu;
		this.nhaCungCap = nhaCungCap;
		this.tinhTrang = tinhTrang;
		this.chiTietSanPham = chiTietSanPham;
	}

	public int getSoLuong(String mau, String size) {
		int sl = 0;
		for (ChiTietSanPham c : chiTietSanPham) {
			if (c.getMau().equals(mau) && c.getSize().equals(size)) {
				sl = c.getSoLuong();
			}
		}
		return sl;
	}
	public SanPham(String tenSanPham,  int soLuongLoi) {
		super();
		this.tenSanPham = tenSanPham;
		this.soLuongLoi = soLuongLoi;
	}
	public SanPham(String maSanPham, String tenSanPham, ThuongHieu thuongHieu,XuatXu xuatXu, ChatLieu chatLieu, String gioiTinh, String loai, double giaGoc
			, int soLuongLoi, String tinhTrang) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaGoc = giaGoc;
		this.gioiTinh = gioiTinh;
		this.loai = loai;
		this.soLuongLoi = soLuongLoi;
		this.chatLieu = chatLieu;
		this.thuongHieu = thuongHieu;
		this.xuatXu = xuatXu;
		this.tinhTrang = tinhTrang;
	}

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  maSanPham + ", " + tenSanPham + ", giaGoc=" + giaGoc + ", hinhAnh="
				+ hinhAnh + ", moTa=" + moTa + ", gioiTinh=" + gioiTinh + ", phongCach=" + phongCach + ", loai=" + loai
				+ ", coAo=" + coAo + ", soLuongLoi=" + soLuongLoi + ", " + chatLieu.getMaCL() + ", "
				+ thuongHieu.getMaTH() + ", " + xuatXu.getMaXX() + ", " + nhaCungCap.getMaNCC() + ", " + tinhTrang
				+ "\n, chiTietSanPham=" + chiTietSanPham + "]";
	}
	
}
