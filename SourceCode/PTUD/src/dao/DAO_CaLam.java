package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.CaLam;
import entity.NhanVien;
public class DAO_CaLam {

	private ArrayList<CaLam>ds;
	
	public DAO_CaLam() {
		
	}
	
	public ArrayList<CaLam>getDS(){
		return ds;
	}
	
	public void setDS(ArrayList<CaLam>ds) {
		this.ds=ds;
	}
	public ArrayList<CaLam> getAllCaLam(){
		 ds = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from CaLam";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				Date ngay=rs.getDate(2);
				String buoiLam=rs.getString(3);
				NhanVien nv=new NhanVien(rs.getString(4));
				CaLam cl=new CaLam(ma, ngay, buoiLam, nv);
				ds.add(cl);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<CaLam> getAllCaLam2(){
		 ds = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT CaLam.maCaLam, CaLam.ngay, CaLam.buoiLam, CaLam.maNhanVien, NhanVien.tenNhanVien "
					+ "FROM CaLam INNER JOIN NhanVien ON CaLam.maNhanVien = NhanVien.maNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				Date ngay=rs.getDate(2);
				String buoiLam=rs.getString(3);
				NhanVien nv=new NhanVien(rs.getString(4),rs.getString(5));
				CaLam cl=new CaLam(ma, ngay, buoiLam, nv);
				ds.add(cl);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public String[] getTeNV(String buoiLam) {
		String[] s = new String[8];
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT NhanVien.tenNhanVien\r\n"
					+ "FROM     CaLam INNER JOIN\r\n"
					+ "                  NhanVien ON CaLam.maNhanVien = NhanVien.maNhanVien\r\n"
					+ "Where buoiLam = '"+buoiLam+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			int i = 1;
			while(rs.next()) {
				s[i] = rs.getString(1);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}
	public void createCL(CaLam cl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("insert into CaLam values(?,?,?,?)");
			ps.setString(1,cl.getMaCaLam());
			ps.setDate(2,(Date) cl.getNgay());
			ps.setString(3,cl.getBuoiLam());
			ps.setString(4,cl.getMaNV().getMaNV());
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
		ds.add(cl);
	}
	public boolean deleteCL(String maCL) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("delete from CaLam where maCaLam=?");
			ps.setString(1, maCL);
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
		ds.remove(new CaLam(maCL));
		return n >0;
	}
	public void updateCL(CaLam cl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update CaLam set ngay=?,buoiLam=?,maNhanVien=?  where maCaLam=?");
			ps.setDate(1,(Date) cl.getNgay());
			ps.setString(2, cl.getBuoiLam());
			ps.setString(3,cl.getMaNV().getMaNV());
			ps.setString(4,cl.getMaCaLam());
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
		ds.set(ds.indexOf(cl), cl);
	}
	public void updateCL2(CaLam cl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update CaLam set maNhanVien=?  where maCaLam=?");
			ps.setString(1,cl.getMaNV().getMaNV());
			ps.setString(2,cl.getMaCaLam());
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
	public CaLam getObject(String id) {
		CaLam o=new CaLam(id);
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
		CaLam o=new CaLam(id);
		if (ds.contains(o))
			return true;
		return false;
	}
}
