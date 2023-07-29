package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.ThuongHieu;

public class DAO_ThuongHieu {
private ArrayList<ThuongHieu>ds;
	
	public DAO_ThuongHieu() {
		
	}
	
	public ArrayList<ThuongHieu>getDS(){
		return ds;
	}
	
	public void setDS(ArrayList<ThuongHieu>ds) {
		this.ds=ds;
	}
	public String getMaTHTheoTen(String id){
		String ma="";
		PreparedStatement stmt = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("select maTH from ThuongHieu where tenTH = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTH = rs.getString(1);
				ma=maTH;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ma;
	}
	public ArrayList<ThuongHieu> getAllThuongHieu(){
		 ds = new ArrayList<ThuongHieu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from ThuongHieu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String moTa=rs.getString(3);
				ThuongHieu xx=new ThuongHieu(ma, ten, moTa);
				ds.add(xx);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public void createTH(ThuongHieu th) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("insert into ThuongHieu values(?,?,?)");
			ps.setString(1,th.getMaTH());
			ps.setString(2,th.getTenTH());
			ps.setString(3,th.getMoTa());
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
		ds.add(th);
	}
	public boolean deleteTH(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("delete from ThuongHieu where maTH=?");
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
		ds.remove(new ThuongHieu(ma));
		return n >0;
	}
	
	ThuongHieu getThuongHieu(String maTH) {
		ThuongHieu thuongHieu = null ;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT ThuongHieu.*\r\n"
					+ "FROM     ThuongHieu\r\n"
					+ "Where maTH = '"+maTH+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				thuongHieu = new ThuongHieu(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return thuongHieu;
	}
	
	public void updateTH(ThuongHieu th) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update ThuongHieu set tenTH=?,moTa=?  where maTH=?");
			ps.setString(1,th.getTenTH());
			ps.setString(2,th.getMoTa());
			ps.setString(3,th.getMaTH());
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
		ds.set(ds.indexOf(th), th);
	}
	public ThuongHieu getObject(String id) {
		ThuongHieu o=new ThuongHieu(id);
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
		ThuongHieu o=new ThuongHieu(id);
		if (ds.contains(o))
			return true;
		return false;
	}
}
