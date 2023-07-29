package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;

import database.ConnectDB;
import entity.NhanVien;

public class DAO_NhanVien {
	
	private ArrayList<NhanVien>ds;
	
	public DAO_NhanVien() {
		
	}
	
	public ArrayList<NhanVien>getDS(){
		return ds;
	}
	
	public void setDS(ArrayList<NhanVien>ds) {
		this.ds=ds;
	}
	public ArrayList<NhanVien> getAllNhanVien(){
		ds = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from NhanVien where tinhTrang = N'Đang làm'";
	//		String sql = "select * from NhanVien ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sdt=rs.getString(3);
				String diaChi=rs.getString(4);
				String chucVu=rs.getString(5);
				String gt=rs.getString(6);
				Date ngaySinh=rs.getDate(7);
				Date ngayVaoLam=rs.getDate(8);
				
				String gioiTinh;
				if(gt.compareToIgnoreCase("0")==1) {
					gioiTinh="Nữ";
				}
				else {
					gioiTinh="Nam";
				}
				NhanVien nv=new NhanVien(ma, ten, sdt, diaChi, chucVu, gioiTinh,ngaySinh,ngayVaoLam);
				ds.add(nv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhanVien> getAllNhanVien_TT(String ttt){
		ds = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from NhanVien where tinhTrang = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ttt);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sdt=rs.getString(3);
				String diaChi=rs.getString(4);
				String chucVu=rs.getString(5);
				String gt=rs.getString(6);
				Date ngaySinh=rs.getDate(7);
				Date ngayVaoLam=rs.getDate(8);
				String tt = rs.getString(9);
				String gioiTinh;
				if(gt.compareToIgnoreCase("0")==1) {
					gioiTinh="Nữ";
				}
				else {
					gioiTinh="Nam";
				}
				NhanVien nv=new NhanVien(ma, ten, sdt, diaChi, chucVu, gioiTinh,ngaySinh,ngayVaoLam,tt);
				ds.add(nv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public NhanVien getNhanVienMa(String maa){
		NhanVien nv = new NhanVien();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from NhanVien where maNhanVien = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maa);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sdt=rs.getString(3);
				String diaChi=rs.getString(4);
				String chucVu=rs.getString(5);
				String gt=rs.getString(6);
				Date ngaySinh=rs.getDate(7);
				Date ngayVaoLam=rs.getDate(8);
				String tt = rs.getString(9);
				String gioiTinh;
				if(gt.compareToIgnoreCase("0")==1) {
					gioiTinh="Nữ";
				}
				else {
					gioiTinh="Nam";
				}
				nv=new NhanVien(ma, ten, sdt, diaChi, chucVu, gioiTinh,ngaySinh,ngayVaoLam,tt);
				ds.add(nv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	public ArrayList<NhanVien> getAllNhanVien2(){
		ds = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from NhanVien";
	//		String sql = "select * from NhanVien ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sdt=rs.getString(3);
				String diaChi=rs.getString(4);
				String chucVu=rs.getString(5);
				String gt=rs.getString(6);
				Date ngaySinh=rs.getDate(7);
				Date ngayVaoLam=rs.getDate(8);
				String tt = rs.getString(9);
				String gioiTinh;
				if(gt.compareToIgnoreCase("0")==1) {
					gioiTinh="Nữ";
				}
				else {
					gioiTinh="Nam";
				}
				NhanVien nv=new NhanVien(ma, ten, sdt, diaChi, chucVu, gioiTinh,ngaySinh,ngayVaoLam,tt);
				ds.add(nv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhanVien> timKiemMaNV(String ma){
		ds = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien where maNhanVien like ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+ma+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNV=rs.getString(1);
				String ten=rs.getString(2);
				String sdt=rs.getString(3);
				String diaChi=rs.getString(4);
				String chucVu=rs.getString(5);
				String gt=rs.getString(6);
				Date ngaySinh=rs.getDate(7);
				Date ngayVaoLam=rs.getDate(8);
				
				String gioiTinh;
				if(gt.compareToIgnoreCase("0")==1) {
					gioiTinh="Nữ";
				}
				else {
					gioiTinh="Nam";
				}
				NhanVien nv=new NhanVien(maNV, ten, sdt, diaChi, chucVu, gioiTinh,ngaySinh,ngayVaoLam);
				ds.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhanVien> timKiemTenNV(String ten){
		ds = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien where tenNhanVien like ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+ten+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				String sdt=rs.getString(3);
				String diaChi=rs.getString(4);
				String chucVu=rs.getString(5);
				String gt=rs.getString(6);
				Date ngaySinh=rs.getDate(7);
				Date ngayVaoLam=rs.getDate(8);
				
				String gioiTinh;
				if(gt.compareToIgnoreCase("0")==1) {
					gioiTinh="Nữ";
				}
				else {
					gioiTinh="Nam";
				}
				NhanVien nv=new NhanVien(maNV, tenNV, sdt, diaChi, chucVu, gioiTinh,ngaySinh,ngayVaoLam);
				ds.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public NhanVien timKiemNV_Ten(String ten){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien where tenNhanVien = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,ten);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				String sdt=rs.getString(3);
				String diaChi=rs.getString(4);
				String chucVu=rs.getString(5);
				String gt=rs.getString(6);
				Date ngaySinh=rs.getDate(7);
				Date ngayVaoLam=rs.getDate(8);
				
				String gioiTinh;
				if(gt.compareToIgnoreCase("0")==1) {
					gioiTinh="Nữ";
				}
				else {
					gioiTinh="Nam";
				}
				NhanVien nv=new NhanVien(maNV, tenNV, sdt, diaChi, chucVu, gioiTinh,ngaySinh,ngayVaoLam);
				return nv;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<NhanVien> timKiemSDTNV(String sdtt){
		ds = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien where SDT like ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+sdtt+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				String sdt=rs.getString(3);
				String diaChi=rs.getString(4);
				String chucVu=rs.getString(5);
				String gt=rs.getString(6);
				Date ngaySinh=rs.getDate(7);
				Date ngayVaoLam=rs.getDate(8);
				
				String gioiTinh;
				if(gt.compareToIgnoreCase("0")==1) {
					gioiTinh="Nữ";
				}
				else {
					gioiTinh="Nam";
				}
				NhanVien nv=new NhanVien(maNV, tenNV, sdt, diaChi, chucVu, gioiTinh,ngaySinh,ngayVaoLam);
				ds.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhanVien> timKiemsdtNV(String sdt){
		ds = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien where SDT like ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,sdt+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				String sdtNV=rs.getString(3);
				String diaChi=rs.getString(4);
				String chucVu=rs.getString(5);
				String gt=rs.getString(6);
				Date ngaySinh=rs.getDate(7);
				Date ngayVaoLam=rs.getDate(8);
				
				String gioiTinh;
				if(gt.compareToIgnoreCase("0")==1) {
					gioiTinh="Nữ";
				}
				else {
					gioiTinh="Nam";
				}
				NhanVien nv=new NhanVien(maNV, tenNV, sdtNV, diaChi, chucVu, gioiTinh,ngaySinh,ngayVaoLam);
				ds.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public void createNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into NhanVien values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1,nv.getMaNV());
			ps.setString(2, nv.getTenNV());
			ps.setString(3,nv.getSoDienThoai());
			ps.setString(4,nv.getDiaChi());
			ps.setString(5,nv.getChucVu());
			ps.setString(6,nv.getGioiTinh());
			ps.setDate(7,(Date) nv.getNgaySinh());
			ps.setDate(8,(Date) nv.getNgayVaoLam());
			ps.setString(9,"Đang làm");
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Connection close");
				e.printStackTrace();
			}
		}
	}
	public boolean deleteNV(String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("delete from TaiKhoan where maNhanVien=? delete from NhanVien where maNhanVien=?");
			ps.setString(1, maNV);
			ps.setString(2, maNV);
			n = ps.executeUpdate();
		}catch (SQLException e) {
			System.err.println("Không thể xóa");
		}finally {
			try {
				ps.close();
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Connection close");
				e.printStackTrace();
			}
		}
		ds.remove(new NhanVien(maNV));
		return n >0;
	}
	public boolean deleteNV2(String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update NhanVien set tinhTrang = N'Nghỉ việc' where maNhanVien= ?");
			ps.setString(1, maNV);
			n = ps.executeUpdate();
		}catch (SQLException e) {
			System.err.println("Không thể xóa");
		}finally {
			try {
				ps.close();
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Connection close");
				e.printStackTrace();
			}
		}
		ds.remove(new NhanVien(maNV));
		return n >0;
	}
	public void updateNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update NhanVien set tenNhanVien=?,SDT=?,diaChi=?,chucVu=?  where maNhanVien=?");
			ps.setString(1,nv.getTenNV());
			ps.setString(2,nv.getSoDienThoai());
			ps.setString(3,nv.getDiaChi());
			ps.setString(4,nv.getChucVu());
			ps.setString(5, nv.getMaNV());
			n = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Connection close");
				e.printStackTrace();
			}
		}
	}
	
	public NhanVien getObject(String id) {
		NhanVien o = new NhanVien(id);
		if (ds.contains(o))
			return ds.get(ds.indexOf(o));
		return null;

	}

	public int indexOf(Object o) {
		return ds.indexOf(o);
	}

	public int size() {
		return ds.size();
	}

	public boolean contains(String id) {
		NhanVien o = new NhanVien(id);
		if (ds.contains(o))
			return true;
		return false;
	}

	
}

