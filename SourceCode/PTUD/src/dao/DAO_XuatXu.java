package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.ThuongHieu;
import entity.XuatXu;

public class DAO_XuatXu {
private ArrayList<XuatXu>ds;
	
	public DAO_XuatXu() {
		
	}
	
	public ArrayList<XuatXu>getDS(){
		return ds;
	}
	
	public void setDS(ArrayList<XuatXu>ds) {
		this.ds=ds;
	}
	public ArrayList<XuatXu> getAllXuatXu(){
		 ds = new ArrayList<XuatXu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from XuatXu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String moTa=rs.getString(3);
				XuatXu xx=new XuatXu(ma, ten, moTa);
				ds.add(xx);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public String getMaXXTheoTen(String id){
		String ma="";
		PreparedStatement stmt = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("select* from XuatXu where tenXX = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maXX = rs.getString(1);	
				ma=maXX;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ma;
	}
	public void createXX(XuatXu xx) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("insert into XuatXu values(?,?,?)");
			ps.setString(1,xx.getMaXX());
			ps.setString(2,xx.getTenXX());
			ps.setString(3,xx.getMoTa());
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
		ds.add(xx);
	}
	public boolean deleteXX(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("delete from XuatXu where maXX=?");
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
		ds.remove(new XuatXu(ma));
		return n >0;
	}
	
	public XuatXu getXuatXu(String maXX) {
		XuatXu xuatXu = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT XuatXu.*\r\n"
					+ "FROM     XuatXu\r\n"
					+ "Where maXX = '"+maXX+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				xuatXu = new XuatXu(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return xuatXu;
	}
	
	public void updateXX(XuatXu xx) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update XuatXu set tenXX=?,moTa=?  where maXX=?");
			ps.setString(1,xx.getTenXX());
			ps.setString(2,xx.getMoTa());
			ps.setString(3,xx.getMaXX());
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
		ds.set(ds.indexOf(xx), xx);
	}
	public XuatXu getObject(String id) {
		XuatXu o=new XuatXu(id);
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
		XuatXu o=new XuatXu(id);
		if (ds.contains(o))
			return true;
		return false;
	}
}
