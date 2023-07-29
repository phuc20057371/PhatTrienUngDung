package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class DAO_TaiKhoan {
private ArrayList<TaiKhoan>ds;
	
	public DAO_TaiKhoan() {
		
	}
	
	public ArrayList<TaiKhoan>getDS(){
		return ds;
	}
	
	public void setDS(ArrayList<TaiKhoan>ds) {
		this.ds=ds;
	}
	public ArrayList<TaiKhoan> getAllTaiKhoan(){
		 ds = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);	
			while (rs.next()) {
				String id=rs.getString(1);
				String mk=rs.getString(2);
				String email = rs.getString(3);
				NhanVien nv=new NhanVien(rs.getString(4));
				TaiKhoan tk=new TaiKhoan(id, mk,email, nv);
				ds.add(tk);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	
	public void createTK(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into TaiKhoan values(?,?,?,?)");
			ps.setString(1,tk.getId());
			ps.setString(2,tk.getMatKhau());
			ps.setString(3, tk.getEmail());
			ps.setString(4, tk.getMaNV().getMaNV());
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
	public boolean deleteTK(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("delete from TaiKhoan where id=?");
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
		ds.remove(new TaiKhoan(ma));
		return n >0;
	}
	public void updatMatKhau(String id, String matKhau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("update TaiKhoan set matKhau=? where maNhanVien =?");
			ps.setString(1,matKhau);
			ps.setString(2,id);
			n = ps.executeUpdate();
		} catch (SQLException e) {
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
	public void updateTK(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update TaiKhoan set matKhau=?,email=?, maNhanVien=?  where id=?");
			ps.setString(1,tk.getMatKhau());
			ps.setString(2, tk.getEmail());
			ps.setString(3,tk.getMaNV().getMaNV());
			ps.setString(4,tk.getId());
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
	public void updateMail(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("update TaiKhoan set email=? where id=?");
			ps.setString(1, tk.getEmail());
			ps.setString(2,tk.getId());
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
	public TaiKhoan getObject(String id) {
		TaiKhoan o = new TaiKhoan(id);
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
		TaiKhoan o=new TaiKhoan(id);
		if (ds.contains(o))
			return true;
		return false;
	}
}
