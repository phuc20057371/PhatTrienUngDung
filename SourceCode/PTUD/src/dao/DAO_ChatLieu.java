package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.ChatLieu;
import database.ConnectDB;


public class DAO_ChatLieu {
	private ArrayList<ChatLieu>ds;
	
	public DAO_ChatLieu() {
		
	}
	
	public ArrayList<ChatLieu>getDS(){
		return ds;
	}
	
	public void setDS(ArrayList<ChatLieu>ds) {
		this.ds=ds;
	}
	public ArrayList<ChatLieu> getAllChatLieu(){
		 ds = new ArrayList<ChatLieu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from ChatLieu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String moTa=rs.getString(3);
				ChatLieu cl=new ChatLieu(ma, ten, moTa);
				ds.add(cl);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public String getMaCLTheoTen(String id){
		String ma="";
		PreparedStatement stmt = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("select maCL from ChatLieu where tenCL =?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maCL = rs.getString(1);
				ma = maCL;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ma;
	}
	public void createCL(ChatLieu cl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("insert into ChatLieu values(?,?,?)");
			ps.setString(1,cl.getMaCL());
			ps.setString(2,cl.getTenCL());
			ps.setString(3,cl.getMoTa());
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
			ps = con.prepareStatement("delete from ChatLieu where maCL=?");
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
		ds.remove(new ChatLieu(maCL));
		return n >0;
	}
	
	ChatLieu getChatLieu(String maCL) {
		ChatLieu cLieu = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT ChatLieu.*\r\n"
					+ "FROM     ChatLieu\r\n"
					+ "WHERE maCL = '"+maCL+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				cLieu  = new ChatLieu(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cLieu;
	}
	
	public void updateCL(ChatLieu cl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update ChatLieu set tenCL=?,moTa=?  where maCL=?");
			ps.setString(1,cl.getTenCL());
			ps.setString(2,cl.getMoTa());
			ps.setString(3,cl.getMaCL());
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
	public ChatLieu getObject(String id) {
		ChatLieu o=new ChatLieu(id);
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
		ChatLieu o=new ChatLieu(id);
		if (ds.contains(o))
			return true;
		return false;
	}
}
