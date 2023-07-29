package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import database.ConnectDB;
import entity.CaLam;
import entity.ChiTietHoaDon;
import entity.ChiTietSanPham;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.LichSuBanHang;
import entity.NhanVien;

public class DAO_HoaDonBanHang {
	private ArrayList<HoaDonBanHang> ds;

	public DAO_HoaDonBanHang() {

	}

	public ArrayList<HoaDonBanHang> getDS() {
		return ds;
	}

	public void setDS(ArrayList<HoaDonBanHang> ds) {
		this.ds = ds;
	}

	public ArrayList<HoaDonBanHang> getAllHoaDonBanHang() {
		ds = new ArrayList<HoaDonBanHang>();
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from HoaDonBanHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString(1);
				Date ngayLapHoaDon = rs.getDate(2);
				KhachHang kh = new KhachHang(rs.getString(3));
				NhanVien nv = new NhanVien(rs.getString(4));
				Double giamGia = rs.getDouble(5);
				Double tienKT = rs.getDouble(6);
				Double tongTien = rs.getDouble(7);

				String sql1 = "SELECT ChiTietHoaDon.*\r\n" + "FROM     ChiTietHoaDon";
				Statement statement1 = con.createStatement();
				ResultSet rs1 = statement1.executeQuery(sql1);

				while (rs1.next()) {
					list.add(new ChiTietHoaDon(new ChiTietSanPham(rs1.getString(1)), rs1.getString(2), rs1.getInt(3)));
				}
				ds.add(new HoaDonBanHang(ma, ngayLapHoaDon, kh, nv, giamGia, tienKT, tongTien, list));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public void createHDBH(HoaDonBanHang hdbh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into HoaDonBanHang values(?,?,?,?,?,?,?)");
			ps.setString(1, hdbh.getMaHoaDon());
			ps.setDate(2, (Date) hdbh.getNgayLapHoaDon());
			ps.setString(3, hdbh.getMaKhachHang().getMaKhachHang());
			ps.setString(4, hdbh.getMaNhanVien().getMaNV());
			ps.setDouble(5, hdbh.getGiamGia());
			ps.setDouble(6, hdbh.getTienKhachDua());
			ps.setDouble(7, hdbh.getTongTienHD());
			n = ps.executeUpdate();
			for (ChiTietHoaDon ct : hdbh.getChiTietHoaDon()) {
				try {
					ps1 = con.prepareStatement("insert into ChiTietHoaDon values(?,?,?)");
					ps1.setString(1, ct.getMaCTSP().getMaChiTietSanPham());
					ps1.setString(2, hdbh.getMaHoaDon());
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

	public boolean deleteHDBH(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("delete from HoaDonBanHang where maHoaDon=?");
			ps.setString(1, ma);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Không thể xóa");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Connection close");
				e.printStackTrace();
			}
		}
		ds.remove(new HoaDonBanHang(ma));
		return n > 0;
	}

	public void updateHDBH(HoaDonBanHang hdbh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement(
					"update HoaDonBanHang set ngayLapHoaDon=?,maKhachHang=?,maNhanVien=?,maCaLam=?,giamGia=?,VAT=? where maHoaDon=?");
			ps.setDate(1, (Date) hdbh.getNgayLapHoaDon());
			ps.setString(2, hdbh.getMaKhachHang().getMaKhachHang());
			ps.setString(3, hdbh.getMaNhanVien().getMaNV());

			ps.setDouble(5, hdbh.getGiamGia());
			ps.setString(7, hdbh.getMaHoaDon());
			n = ps.executeUpdate();
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
		ds.set(ds.indexOf(hdbh), hdbh);
	}

	public Double TongHoaDon(LocalDate lcd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		double dt = 0;

		try {
			ps = con.prepareStatement("SELECT  giaBan = sum(giaGoc*1.1*ChiTietHoaDon.soLuong) "
					+ "FROM HoaDonBanHang INNER JOIN ChiTietHoaDon ON HoaDonBanHang.maHoaDon = ChiTietHoaDon.maHoaDon "
					+ "INNER JOIN SanPham ON ChiTietHoaDon.maSanPham = SanPham.maSanPham "
					+ "where day(HoaDonBanHang.ngayLapHoaDon) = ? and MONTH(HoaDonBanHang.ngayLapHoaDon) =? and YEAR (HoaDonBanHang.ngayLapHoaDon)=?");
			ps.setInt(1, lcd.getDayOfMonth());
			ps.setInt(2, lcd.getMonthValue());
			ps.setInt(3, lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getDouble(1);
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
		return dt;

	}

	public ArrayList<HoaDonBanHang> getHDBH(String maKH) {
		ArrayList<HoaDonBanHang> listhDonBanHang = new ArrayList<HoaDonBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonBanHang.*\r\n" + "FROM     HoaDonBanHang\r\n" + "Where maKhachHang = '" + maKH
					+ "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				Date ngayLapHoaDon = rs.getDate(2);
				KhachHang kh = new KhachHang(rs.getString(3));
				NhanVien nv = new NhanVien(rs.getString(4));
				Double giamGia = rs.getDouble(5);
				Double tienKT = rs.getDouble(6);
				Double tongTien = rs.getDouble(7);

				HoaDonBanHang hd = new HoaDonBanHang(ma, ngayLapHoaDon, kh, nv, giamGia, tienKT, tongTien, null);
				listhDonBanHang.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listhDonBanHang;
	}

	public ArrayList<LichSuBanHang> getHoaDonNgay(Date ngay, String tenNV) {
		ArrayList<LichSuBanHang> listLSBH = new ArrayList<LichSuBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonBanHang.ngayLapHoaDon, HoaDonBanHang.maHoaDon, NhanVien.tenNhanVien, KhachHang.TenKhachHang, KhachHang.SDT, HoaDonBanHang.tongTienHoaDon\r\n"
					+ "FROM     HoaDonBanHang INNER JOIN\r\n"
					+ "                  NhanVien ON HoaDonBanHang.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDonBanHang.maKhachHang = KhachHang.maKhachHang\r\n"
					+ "Where ngayLapHoaDon = '"+ngay+"' and  tenNhanVien = N'" + tenNV + "'";
			// ngayLapHoaDon = '"+ngay.toString()+"' and 
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Date ngaylapHD = rs.getDate(1);
				String maHD = rs.getString(2);
				String tenNhanVien = rs.getString(3);
				String tenKH = rs.getString(4);
				String SDT = rs.getString(5);
				double tongTienHD = rs.getDouble(6);
				
				listLSBH.add(new LichSuBanHang(ngaylapHD, maHD, tenNhanVien, tenKH, SDT, tongTienHD));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listLSBH;
	}
	
	public ArrayList<LichSuBanHang> getHoaDonThang(String thang, String nam, String tenNV) {
		ArrayList<LichSuBanHang> listLSBH = new ArrayList<LichSuBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonBanHang.ngayLapHoaDon, HoaDonBanHang.maHoaDon, NhanVien.tenNhanVien, KhachHang.TenKhachHang, KhachHang.SDT, HoaDonBanHang.tongTienHoaDon\r\n"
					+ "FROM     HoaDonBanHang INNER JOIN\r\n"
					+ "                  NhanVien ON HoaDonBanHang.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDonBanHang.maKhachHang = KhachHang.maKhachHang\r\n"
					+ "Where MONTH(ngayLapHoaDon) = "+thang+" and YEAR(ngayLapHoaDon) = "+nam+" and tenNhanVien = N'" + tenNV + "'";
			// ngayLapHoaDon = '"+ngay.toString()+"' and 
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Date ngaylapHD = rs.getDate(1);
				String maHD = rs.getString(2);
				String tenNhanVien = rs.getString(3);
				String tenKH = rs.getString(4);
				String SDT = rs.getString(5);
				double tongTienHD = rs.getDouble(6);
				
				listLSBH.add(new LichSuBanHang(ngaylapHD, maHD, tenNhanVien, tenKH, SDT, tongTienHD));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listLSBH;
	}
	
	public ArrayList<LichSuBanHang> getHoaDonNam(String nam, String tenNV) {
		ArrayList<LichSuBanHang> listLSBH = new ArrayList<LichSuBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonBanHang.ngayLapHoaDon, HoaDonBanHang.maHoaDon, NhanVien.tenNhanVien, KhachHang.TenKhachHang, KhachHang.SDT, HoaDonBanHang.tongTienHoaDon\r\n"
					+ "FROM     HoaDonBanHang INNER JOIN\r\n"
					+ "                  NhanVien ON HoaDonBanHang.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDonBanHang.maKhachHang = KhachHang.maKhachHang\r\n"
					+ "Where YEAR(ngayLapHoaDon) = "+nam+" and tenNhanVien = N'" + tenNV + "'";
			// ngayLapHoaDon = '"+ngay.toString()+"' and 
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Date ngaylapHD = rs.getDate(1);
				String maHD = rs.getString(2);
				String tenNhanVien = rs.getString(3);
				String tenKH = rs.getString(4);
				String SDT = rs.getString(5);
				double tongTienHD = rs.getDouble(6);
				
				listLSBH.add(new LichSuBanHang(ngaylapHD, maHD, tenNhanVien, tenKH, SDT, tongTienHD));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listLSBH;
	}

	public int getTongHoaDon() {
		int sl = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT count(maHoaDon)\r\n" + "FROM     HoaDonBanHang";
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
	public Double TongDoanhThuNgay_NV(LocalDate lcd, String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		double dt = 0;

		try {
			ps = con.prepareStatement("select SUM(tongTienHoaDon) \r\n"
					+ "from HoaDonBanHang	\r\n"
					+ "where day(HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and MONTH(HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and YEAR (HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and maNhanVien = ?");
			ps.setInt(1, lcd.getDayOfMonth());
			ps.setInt(2, lcd.getMonthValue());
			ps.setInt(3, lcd.getYear());
			ps.setString(4, maNV);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getDouble(1);
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
		return dt;

	}
	public int TongHDNgay_NV(LocalDate lcd, String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		int dt = 0;

		try {
			ps = con.prepareStatement("select COUNT(maHoaDon) from HoaDonBanHang\r\n"
					+ "where day(HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and MONTH(HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and YEAR (HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and maNhanVien = ? ");
			ps.setInt(1, lcd.getDayOfMonth());
			ps.setInt(2, lcd.getMonthValue());
			ps.setInt(3, lcd.getYear());
			ps.setString(4, maNV);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getInt(1);
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
		return dt;

	}
	public Double TongDoanhThuThang_NV(LocalDate lcd, String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		double dt = 0;

		try {
			ps = con.prepareStatement("select SUM(tongTienHoaDon) from HoaDonBanHang\r\n"
					+ "where MONTH(HoaDonBanHang.ngayLapHoaDon) =? and YEAR (HoaDonBanHang.ngayLapHoaDon)=? " 
					+ "and maNhanVien = ?");
			ps.setInt(1, lcd.getMonthValue());
			ps.setInt(2, lcd.getYear());
			ps.setString(3, maNV);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getDouble(1);
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
		return dt;

	}
	public int TongHDThang_NV(LocalDate lcd, String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		int dt = 0;

		try {
			ps = con.prepareStatement("select COUNT(maHoaDon) from HoaDonBanHang\r\n"
					+ "where MONTH(HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and YEAR (HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and maNhanVien = ?");
			ps.setInt(1, lcd.getMonthValue());
			ps.setInt(2, lcd.getYear());
			ps.setString(3, maNV);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getInt(1);
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
		return dt;

	}
	public Double TongDoanhThuNam_NV(LocalDate lcd, String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		double dt = 0;

		try {
			ps = con.prepareStatement("select SUM(tongTienHoaDon) from HoaDonBanHang\r\n"
					+ "where YEAR (HoaDonBanHang.ngayLapHoaDon)=? "
					+ "and maNhanVien = ?");
			ps.setInt(1, lcd.getYear());
			ps.setString(2, maNV);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getDouble(1);
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
		return dt;

	}
	public int TongHDNam_NV(LocalDate lcd, String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int dt = 0;

		try {
			ps = con.prepareStatement("select COUNT(maHoaDon) from HoaDonBanHang\r\n"
					+ "where YEAR (HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and maNhanVien = ?");
			ps.setInt(1, lcd.getYear());
			ps.setString(2, maNV);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				dt = rs.getInt(1);
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
		return dt;

	}
	public Double TongDoanhThuNgay(LocalDate lcd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		double dt = 0;

		try {
			ps = con.prepareStatement("select SUM(tongTienHoaDon) from HoaDonBanHang\r\n"
					+ "where day(HoaDonBanHang.ngayLapHoaDon) = ? and "
					+ "MONTH(HoaDonBanHang.ngayLapHoaDon) =? and YEAR (HoaDonBanHang.ngayLapHoaDon)=?");
			ps.setInt(1, lcd.getDayOfMonth());
			ps.setInt(2, lcd.getMonthValue());
			ps.setInt(3, lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getDouble(1);
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
		return dt;

	}
	public int TongHDNgay(LocalDate lcd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		int dt = 0;

		try {
			ps = con.prepareStatement("select COUNT(maHoaDon) from HoaDonBanHang\r\n"
					+ "where day(HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and MONTH(HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and YEAR (HoaDonBanHang.ngayLapHoaDon) = ?");
			ps.setInt(1, lcd.getDayOfMonth());
			ps.setInt(2, lcd.getMonthValue());
			ps.setInt(3, lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getInt(1);
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
		return dt;

	}
	public Double TongDoanhThuThang(LocalDate lcd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		double dt = 0;

		try {
			ps = con.prepareStatement("select SUM(tongTienHoaDon) from HoaDonBanHang\r\n"
					+ "where MONTH(HoaDonBanHang.ngayLapHoaDon) =? and YEAR (HoaDonBanHang.ngayLapHoaDon)=?");
			ps.setInt(1, lcd.getMonthValue());
			ps.setInt(2, lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getDouble(1);
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
		return dt;

	}
	public int TongHDThang(LocalDate lcd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		int dt = 0;

		try {
			ps = con.prepareStatement("select COUNT(maHoaDon) from HoaDonBanHang\r\n"
					+ "where MONTH(HoaDonBanHang.ngayLapHoaDon) = ? "
					+ "and YEAR (HoaDonBanHang.ngayLapHoaDon) = ?");
			ps.setInt(1, lcd.getMonthValue());
			ps.setInt(2, lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getInt(1);
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
		return dt;

	}
	public Double TongDoanhThuNam(LocalDate lcd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		double dt = 0;

		try {
			ps = con.prepareStatement("select SUM(tongTienHoaDon) from HoaDonBanHang\r\n"
					+ "where YEAR (HoaDonBanHang.ngayLapHoaDon)=?");
			ps.setInt(1, lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getDouble(1);
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
		return dt;

	}
	public int TongHDNam(LocalDate lcd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int dt = 0;

		try {
			ps = con.prepareStatement("select COUNT(maHoaDon) from HoaDonBanHang\r\n"
					+ "where YEAR (HoaDonBanHang.ngayLapHoaDon) = ?");
			ps.setInt(1, lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dt = rs.getInt(1);
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
		return dt;

	}
	public ArrayList<HoaDonBanHang> getHD_TK_Ngay(String maNV, LocalDate lcd) {
		ArrayList<HoaDonBanHang> listhDonBanHang = new ArrayList<HoaDonBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonBanHang.maHoaDon, KhachHang.maKhachHang, KhachHang.TenKhachHang, KhachHang.SDT, "
					+ "HoaDonBanHang.tongTienHoaDon, HoaDonBanHang.ngayLapHoaDon\r\n"
					+ "FROM  HoaDonBanHang INNER JOIN\r\n"
					+ "      NhanVien ON HoaDonBanHang.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "      KhachHang ON HoaDonBanHang.maKhachHang = KhachHang.maKhachHang\r\n"
					+ "where NhanVien.maNhanVien = ? "
					+ "and (DAY(HoaDonBanHang.ngayLapHoaDon) = ?) AND (MONTH(HoaDonBanHang.ngayLapHoaDon) = ?) "
					+ "AND (YEAR(HoaDonBanHang.ngayLapHoaDon) = ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,maNV);
			ps.setInt(2,lcd.getDayOfMonth());
			ps.setInt(3,lcd.getMonthValue());
			ps.setInt(4,lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString(1);
				KhachHang kh = new KhachHang(rs.getString(2),rs.getString(3),rs.getString(4));
				Double tongTien = rs.getDouble(5);
				Date ngayLapHoaDon = rs.getDate(6);
				
				

				HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLapHoaDon, kh, tongTien);
				listhDonBanHang.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listhDonBanHang;
	}
	public ArrayList<HoaDonBanHang> getHD_TK_Thang(String maNV, LocalDate lcd) {
		ArrayList<HoaDonBanHang> listhDonBanHang = new ArrayList<HoaDonBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonBanHang.maHoaDon, KhachHang.maKhachHang, KhachHang.TenKhachHang, KhachHang.SDT, "
					+ "HoaDonBanHang.tongTienHoaDon, HoaDonBanHang.ngayLapHoaDon\r\n"
					+ "FROM  HoaDonBanHang INNER JOIN\r\n"
					+ "      NhanVien ON HoaDonBanHang.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "      KhachHang ON HoaDonBanHang.maKhachHang = KhachHang.maKhachHang\r\n"
					+ "where NhanVien.maNhanVien = ? "
					+ "AND (MONTH(HoaDonBanHang.ngayLapHoaDon) = ?) "
					+ "AND (YEAR(HoaDonBanHang.ngayLapHoaDon) = ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,maNV);
			ps.setInt(2,lcd.getMonthValue());
			ps.setInt(3,lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString(1);
				KhachHang kh = new KhachHang(rs.getString(2),rs.getString(3),rs.getString(4));
				Double tongTien = rs.getDouble(5);
				Date ngayLapHoaDon = rs.getDate(6);
				
				

				HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLapHoaDon, kh, tongTien);
				listhDonBanHang.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listhDonBanHang;
	}
	public ArrayList<HoaDonBanHang> getHD_TK_Nam(String maNV, LocalDate lcd) {
		ArrayList<HoaDonBanHang> listhDonBanHang = new ArrayList<HoaDonBanHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonBanHang.maHoaDon, KhachHang.maKhachHang, KhachHang.TenKhachHang, KhachHang.SDT, "
					+ "HoaDonBanHang.tongTienHoaDon, HoaDonBanHang.ngayLapHoaDon\r\n"
					+ "FROM  HoaDonBanHang INNER JOIN\r\n"
					+ "      NhanVien ON HoaDonBanHang.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "      KhachHang ON HoaDonBanHang.maKhachHang = KhachHang.maKhachHang\r\n"
					+ "where NhanVien.maNhanVien = ? "
					+ "AND (YEAR(HoaDonBanHang.ngayLapHoaDon) = ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,maNV);
			ps.setInt(2,lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString(1);
				KhachHang kh = new KhachHang(rs.getString(2),rs.getString(3),rs.getString(4));
				Double tongTien = rs.getDouble(5);
				Date ngayLapHoaDon = rs.getDate(6);
				
				

				HoaDonBanHang hd = new HoaDonBanHang(maHD, ngayLapHoaDon, kh, tongTien);
				listhDonBanHang.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listhDonBanHang;
	}
	
	public HoaDonBanHang getHoaDonBanHang(String maHD) {
		HoaDonBanHang hd = null;
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT HoaDonBanHang.*\r\n"
					+ "FROM     HoaDonBanHang\r\n"
					+ "WHERE maHoaDon = '"+maHD+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString(1);
				Date ngayLapHoaDon = rs.getDate(2);
				KhachHang kh = new KhachHang(rs.getString(3));
				NhanVien nv = new NhanVien(rs.getString(4));
				Double giamGia = rs.getDouble(5);
				Double tienKT = rs.getDouble(6);
				Double tongTien = rs.getDouble(7);

				String sql1 = "SELECT ChiTietHoaDon.*\r\n"
						+ "FROM     ChiTietHoaDon\r\n"
						+ "WHERE maHD = '"+maHD+"'";
				Statement statement1 = con.createStatement();
				ResultSet rs1 = statement1.executeQuery(sql1);

				while (rs1.next()) {
					list.add(new ChiTietHoaDon(new ChiTietSanPham(rs1.getString(1)), rs1.getString(2), rs1.getInt(3)));
				}
				hd = new HoaDonBanHang(ma, ngayLapHoaDon, kh, nv, giamGia, tienKT, tongTien, list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hd;
	}
	
	public HoaDonBanHang getObject(String id) {
		HoaDonBanHang o = new HoaDonBanHang(id);
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
		HoaDonBanHang o = new HoaDonBanHang(id);
		if (ds.contains(o))
			return true;
		return false;
	}
}
