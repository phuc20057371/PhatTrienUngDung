package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.NhaCungCap;



public class DAO_NhaCungCap {
private ArrayList<NhaCungCap>ds;
	
	public DAO_NhaCungCap() {
		
	}
	
	public ArrayList<NhaCungCap>getDS(){
		return ds;
	}
	
	public void setDS(ArrayList<NhaCungCap>ds) {
		this.ds=ds;
	}
	public ArrayList<NhaCungCap> getAllNCC(){
		 ds = new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sdt=rs.getString(3);
				String dc=rs.getString(4);
				NhaCungCap ncc=new NhaCungCap(ma, ten, sdt, dc);
				ds.add(ncc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public void createNCC(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("insert into NhaCungCap values(?,?,?,?)");
			ps.setString(1,ncc.getMaNCC());
			ps.setString(2,ncc.getTenNCC());
			ps.setString(3,ncc.getSoDienThoai());
			ps.setString(4,ncc.getDiaChi());
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
	public boolean deleteNCC(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("delete from NhaCungCap where maNCC=?");
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
		return n >0;
	}
	public void updateNCC(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n =0;
		try {
			ps = con.prepareStatement("update NhaCungCap set tenNCC=?,SDT=?,diaChi=?  where maNCC=?");
			ps.setString(1,ncc.getTenNCC());
			ps.setString(2,ncc.getSoDienThoai());
			ps.setString(3,ncc.getDiaChi());
			ps.setString(4,ncc.getMaNCC());
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
	public ArrayList<NhaCungCap> getDsMaNCC(String ma){
		ds = new ArrayList<NhaCungCap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhaCungCap where maNCC like ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+ma+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNCC=rs.getString(1);
				String tenNCC=rs.getString(2);
				String sdtNCC=rs.getString(3);
				String diaChi=rs.getString(4);	
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, sdtNCC, diaChi);
				ds.add(ncc);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhaCungCap> getDsTenNCC(String ten){
		ds = new ArrayList<NhaCungCap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhaCungCap where tenNCC like ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+ten+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNCC=rs.getString(1);
				String tenNCC=rs.getString(2);
				String sdtNCC=rs.getString(3);
				String diaChi=rs.getString(4);	
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, sdtNCC, diaChi);
				ds.add(ncc);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhaCungCap> getDsSdtNCC(String sdt){
		ds = new ArrayList<NhaCungCap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhaCungCap where SDT like ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+sdt+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNCC=rs.getString(1);
				String tenNCC=rs.getString(2);
				String sdtNCC=rs.getString(3);
				String diaChi=rs.getString(4);	
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, sdtNCC, diaChi);
				ds.add(ncc);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public NhaCungCap getObject(String id) {
		NhaCungCap o=new NhaCungCap(id);
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
		NhaCungCap o=new NhaCungCap(id);
		if (ds.contains(o))
			return true;
		return false;
	}
}
