package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChiTietTraHang;
import entity.HoaDonBanHang;
import entity.HoaDonTraHang;
import entity.LichSuBanHang;

public class DAO_HoaDonTraHang {
	
	public ArrayList<LichSuBanHang> getHoaDonNam(String nam, String tenNV) {
		ArrayList<LichSuBanHang> listLSBH = new ArrayList<LichSuBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonTraHang.maHDTH, NhanVien.tenNhanVien, HoaDonTraHang.ngayLapHoaDon, KhachHang.TenKhachHang, KhachHang.SDT, HoaDonTraHang.tongTienHoaDon\r\n"
					+ "FROM     HoaDonTraHang INNER JOIN\r\n"
					+ "                  NhanVien ON HoaDonTraHang.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDonTraHang.maKhachHang = KhachHang.maKhachHang\r\n"
					+ "Where YEAR(ngayLapHoaDon) = "+nam+" and tenNhanVien = N'"+tenNV+"'";
			// ngayLapHoaDon = '"+ngay.toString()+"' and 
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Date ngaylapHD = rs.getDate(3);
				String maHD = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				String tenKH = rs.getString(4);
				String SDT = rs.getString(5);
				double tongTienHD = rs.getDouble(6);
				
				listLSBH.add(new LichSuBanHang(ngaylapHD, maHD, tenNhanVien, tenKH, SDT, tongTienHD));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listLSBH;
	}

	public ArrayList<LichSuBanHang> getHoaDonThang(String thang, String nam, String tenNV) {
		ArrayList<LichSuBanHang> listLSBH = new ArrayList<LichSuBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonTraHang.maHDTH, NhanVien.tenNhanVien, HoaDonTraHang.ngayLapHoaDon, KhachHang.TenKhachHang, KhachHang.SDT, HoaDonTraHang.tongTienHoaDon\r\n"
					+ "FROM     HoaDonTraHang INNER JOIN\r\n"
					+ "                  NhanVien ON HoaDonTraHang.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDonTraHang.maKhachHang = KhachHang.maKhachHang\r\n"
					+ "Where YEAR(ngayLapHoaDon) = "+nam+" and MONTH(ngayLapHoaDon) = "+thang+" and tenNhanVien = N'"+tenNV+"'";
			// ngayLapHoaDon = '"+ngay.toString()+"' and 
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Date ngaylapHD = rs.getDate(3);
				String maHD = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				String tenKH = rs.getString(4);
				String SDT = rs.getString(5);
				double tongTienHD = rs.getDouble(6);
				
				listLSBH.add(new LichSuBanHang(ngaylapHD, maHD, tenNhanVien, tenKH, SDT, tongTienHD));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listLSBH;
	}
	
	public ArrayList<LichSuBanHang> getHoaDonNgay(Date ngay, String tenNV) {
		ArrayList<LichSuBanHang> listLSBH = new ArrayList<LichSuBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonTraHang.maHDTH, NhanVien.tenNhanVien, HoaDonTraHang.ngayLapHoaDon, KhachHang.TenKhachHang, KhachHang.SDT, HoaDonTraHang.tongTienHoaDon\r\n"
					+ "FROM     HoaDonTraHang INNER JOIN\r\n"
					+ "                  NhanVien ON HoaDonTraHang.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDonTraHang.maKhachHang = KhachHang.maKhachHang\r\n"
					+ "Where ngayLapHoaDon = '"+ngay+"' and  tenNhanVien = N'" + tenNV + "'";
			// ngayLapHoaDon = '"+ngay.toString()+"' and 
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Date ngaylapHD = rs.getDate(3);
				String maHD = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				String tenKH = rs.getString(4);
				String SDT = rs.getString(5);
				double tongTienHD = rs.getDouble(6);
				
				listLSBH.add(new LichSuBanHang(ngaylapHD, maHD, tenNhanVien, tenKH, SDT, tongTienHD));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listLSBH;
	}
	
	public void createHDTH(HoaDonTraHang hdth) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into HoaDonTraHang values(?,?,?,?,?,?)");
			ps.setString(1, hdth.getMaHDTH());
			ps.setString(2, hdth.getMaHoaDon());
			ps.setDate(3, (Date) hdth.getNgayLapHoaDon());
			ps.setString(4, hdth.getKhachHang().getMaKhachHang());
			ps.setString(5, hdth.getNhanVien().getMaNV());
			ps.setDouble(6, hdth.getTongTienHoaDon());
			n = ps.executeUpdate();
			for (ChiTietTraHang ct : hdth.getChiTietTraHang()) {
				try {
					ps1 = con.prepareStatement("insert into ChiTietTraHang values(?,?,?)");
					ps1.setString(1, ct.getCTSP().getMaChiTietSanPham());
					ps1.setString(2, ct.getMaHDTH());
					ps1.setInt(3, ct.getSoLuong());
					ps1.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Connection close");
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<String> getMaHD() {
		ArrayList<String> listMaHD = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT maHoaDon\r\n"
					+ "FROM     HoaDonTraHang";
			// ngayLapHoaDon = '"+ngay.toString()+"' and 
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				listMaHD.add(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listMaHD;
	}
	
	public int getTongHoaDon() {
		int sl = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT count(maHDTH) FROM  HoaDonTraHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// System.out.println(sl);
		return sl;
	}

	
}
