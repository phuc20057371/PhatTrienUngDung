package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.KhachHang;


public class DAO_KhachHang {
private ArrayList<KhachHang>ds;
	
	public DAO_KhachHang() {
		
	}
	
	public ArrayList<KhachHang>getDS(){
		return ds;
	}
	
	public void setDS(ArrayList<KhachHang>ds) {
		this.ds=ds;
	}
	public ArrayList<KhachHang> getAllKhachHang(){
		 ds = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement statement = con.createStatement();
			String sql = "select * from KhachHang";
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String hoTen=rs.getString(2);
				String sdt=rs.getString(3);
				String loai=rs.getString(4);
				KhachHang kh=new KhachHang(ma, hoTen, sdt, loai);
				ds.add(kh);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public void createKH(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("insert into KhachHang values(?,?,?,?)");
			ps.setString(1,kh.getMaKhachHang());
			ps.setString(2,kh.getHoTenKhachHang());
			ps.setString(3,kh.getSoDienThoai());
			ps.setString(4,kh.getLoaiKhachHang());
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
		ds.add(kh);
	}
	public boolean deleteKH(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("delete from KhachHang where maKhachHang=?");
			ps.setString(1, ma);
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
		ds.remove(new KhachHang(ma));
		return n >0;
	}
	public void updateKH(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update KhachHang set tenKhachHang=?,SDT=? where maKhachHang=?");
			ps.setString(1,kh.getHoTenKhachHang());
			ps.setString(2,kh.getSoDienThoai());
			ps.setString(3,kh.getMaKhachHang());
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
	
	public Double getTongTienDaMua(String maKH) {
		Double tt = 0.0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement statement = con.createStatement();
			String sql = "SELECT tongTienHoaDon\r\n"
					+ "FROM     HoaDonBanHang\r\n"
					+ "where maKhachHang = '"+maKH+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				tt += rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tt;
	}
	
	public KhachHang getKhachHang(String maKH) {
		KhachHang khachHang = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement statement = con.createStatement();
			String sql = "select * from KhachHang where maKhachHang = '"+maKH+"'";
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String hoTen=rs.getString(2);
				String sdt=rs.getString(3);
				String loai=rs.getString(4);
				khachHang = new KhachHang(ma, hoTen, sdt, loai);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return khachHang;
	}
	
	public ArrayList<KhachHang> timSDT(String sdt) {
		ArrayList<KhachHang> listkh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement statement = con.createStatement();
			String sql = "SELECT KhachHang.*\r\n"
					+ "FROM     KhachHang\r\n"
					+ "WHERE SDT like '%"+sdt+"%'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma=rs.getString(1);
				String hoTen=rs.getString(2);
				String soString=rs.getString(3);
				String loai=rs.getString(4);
				listkh.add(new KhachHang(ma, hoTen, soString, loai));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listkh;
	}
	
	public KhachHang getObject(String id) {
		KhachHang o=new KhachHang(id);
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
		KhachHang o=new KhachHang(id);
		if (ds.contains(o))
			return true;
		return false;
	}
}
