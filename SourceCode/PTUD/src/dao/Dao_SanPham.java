package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import database.ConnectDB;
import entity.ChatLieu;
import entity.ChiTietSanPham;
import entity.NhaCungCap;
import entity.SanPham;
import entity.ThuongHieu;
import entity.XuatXu;

public class Dao_SanPham {
//	private ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
	private ArrayList<String> listSize = new ArrayList<String>();
//	private ArrayList<String> listMau = new ArrayList<String>();

	public ArrayList<SanPham> getAllSanPham() {
		ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
		try {

			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT *\r\n" + "FROM     SanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				// System.out.println(maSanPham);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);

				ChatLieu chatLieu = new DAO_ChatLieu().getChatLieu(rs.getString(11));
				ThuongHieu thuongHieu = new DAO_ThuongHieu().getThuongHieu(rs.getString(12));
				XuatXu xuatXu = new DAO_XuatXu().getXuatXu(rs.getString(13));
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(14));
				String tinhTrang = rs.getString(15);

				String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM     ChiTietSanPham\r\n" + "WHERE maSP = '"
						+ maSanPham + "'";
				Statement statement1 = con.createStatement();
				ResultSet rs1 = statement1.executeQuery(sql1);
				while (rs1.next()) {

					String maCTSP = rs1.getString(1);
					String maSP = rs1.getString(2);
					String size = rs1.getString(3);
					String mau = rs1.getString(4);
					int soLuong = rs1.getInt(5);
					listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
				}

				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);
				listSanPham.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listSanPham;
	}
	public ArrayList<SanPham> getAllSanPham_V2(String thh,String xxx,String cll,String loaii, String ttt) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh,\r\n"
					+ "SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH,\r\n"
					+ "SanPham.maXX, XuatXu.tenXX, SanPham.maCL, ChatLieu.tenCL, SanPham.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM SanPham INNER JOIN\r\n"
					+ "ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC \r\n"
					+ "WHERE ThuongHieu.tenTH like ? \r\n"
					+ "and XuatXu.tenXX like ?\r\n"
					+ "and ChatLieu.tenCL like ?\r\n"
					+ "and loai like ?\r\n"
					+ "and SanPham.tinhTrang like ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+thh+"%");
			ps.setString(2, "%"+xxx+"%");
			ps.setString(3, "%"+cll+"%");
			ps.setString(4, "%"+loaii+"%");
			ps.setString(5, "%"+ttt+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "'";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);

				list.add(sp);			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<SanPham> getAllSanPham_V2_SM(String loaii) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {		
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh, SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH, \r\n"
					+ "                  SanPham.maXX, XuatXu.tenXX, SanPham.maCL, ChatLieu.tenCL, SanPham.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC "
					+ "WHERE SanPham.tinhTrang = N'Còn bán' and SanPham.loai like ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,"%"+loaii+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "'";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);

				list.add(sp);			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<String> getAllSize(String maSP) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT DISTINCT Size\r\n" + "FROM     ChiTietSanPham\r\n" + "WHERE maSP = '" + maSP + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String size = rs.getString(1);
				System.out.println(size);
				listSize.add(size);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSize;
	}
	public ArrayList<SanPham> tkSanPham(String maSp) {
		ArrayList<SanPham> listSP = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT SanPham.*\r\n" + "FROM     SanPham\r\n" + "WHERE maSanPham like '%" + maSp + "%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);

				ChatLieu chatLieu = new DAO_ChatLieu().getChatLieu(rs.getString(11));
				ThuongHieu thuongHieu = new DAO_ThuongHieu().getThuongHieu(rs.getString(12));
				XuatXu xuatXu = new DAO_XuatXu().getXuatXu(rs.getString(13));
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(14));
				String tinhTrang = rs.getString(15);

				String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM     ChiTietSanPham\r\n" + "WHERE maSP = '"
						+ maSanPham + "'";
				Statement statement1 = con.createStatement();
				ResultSet rs1 = statement1.executeQuery(sql1);
				while (rs1.next()) {

					String maCTSP = rs1.getString(1);
					String maSP = rs1.getString(2);
					String size = rs1.getString(3);
					String mau = rs1.getString(4);
					int soLuong = rs1.getInt(5);
					listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
				}

				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);
				listSP.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSP;
	}
	public void capNhatSoLuong(String maCTSP, int sl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("update ChiTietSanPham set soLuong = soLuong + "+sl+"\r\n"
					+ "Where maCTSP = '"+maCTSP+"'");
			ps.executeUpdate();
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
	public ArrayList<String> getAllMau(String maSP, String size) {
		ArrayList<String> listMau = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT mau\r\n" + "FROM     ChiTietSanPham\r\n" + "WHERE maSP = '" + maSP + "' and size = '"
					+ size + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String mau = rs.getString(1);
				listMau.add(mau);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listMau;
	}
	public ArrayList<SanPham> getAllSanPhamV2() {
		ArrayList<SanPham> listV2 = new ArrayList<SanPham>();
		Statement statement = null;
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh, SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH, \r\n"
					+ "                  XuatXu.maXX, XuatXu.tenXX, ChatLieu.maCL, ChatLieu.tenCL, NhaCungCap.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC"
					+ " where SanPham.tinhTrang = N'Còn bán'";
			
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "'";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);
				if((listV2.contains(sp))) {
					
				}
				else {
					listV2.add(sp);
				}

				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			}catch (SQLException e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
		}
		
		return listV2;
	}
	public ArrayList<ChiTietSanPham> getAllCTSanPham(String ma) {
		ArrayList<ChiTietSanPham> list = new ArrayList<ChiTietSanPham>();
		PreparedStatement ps = null;
			
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT *\r\n"
					+ "FROM     ChiTietSanPham\r\n"
					+ "where maSP = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,ma);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String maCTSP = rs.getString(1);
				String maSP = rs.getString(2);
				String size = rs.getString(3);
				String mau = rs.getString(4);
				int soLuong = rs.getInt(5);
				list.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<SanPham> getAllSanPham_V2_1(String maSP1) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		PreparedStatement ps=null;
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh, SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH, \r\n"
					+ "                  SanPham.maXX, XuatXu.tenXX, SanPham.maCL, ChatLieu.tenCL, SanPham.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC "
					+ "WHERE SanPham.maSanPham like ? and SanPham.tinhTrang = N'Còn bán'";
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+ maSP1+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "' ";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);

				list.add(sp);			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {			
				ps.close();
			}catch (SQLException e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<SanPham> getAllSanPham_V2_2(String tenSP1) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		PreparedStatement ps=null;
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh, SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH, \r\n"
					+ "                  SanPham.maXX, XuatXu.tenXX, SanPham.maCL, ChatLieu.tenCL, SanPham.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC "
					+ "WHERE SanPham.tenSP like ? and SanPham.tinhTrang = N'Còn bán'";
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+ tenSP1+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "'";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);

				list.add(sp);			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<SanPham> getAllSanPham_V2_Loai(String loaii) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh, SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH, \r\n"
					+ "                  SanPham.maXX, XuatXu.tenXX, SanPham.maCL, ChatLieu.tenCL, SanPham.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC "
					+ "WHERE SanPham.loai = ? and SanPham.tinhTrang = N'Còn bán'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loaii);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "'";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);

				list.add(sp);			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<SanPham> getAllSanPham_V2_XX(String xxx) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh, SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH, \r\n"
					+ "                  SanPham.maXX, XuatXu.tenXX, SanPham.maCL, ChatLieu.tenCL, SanPham.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC "
					+ "WHERE XuatXu.tenXX = ? and SanPham.tinhTrang = N'Còn bán'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, xxx);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "'";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);

				list.add(sp);			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<SanPham> getAllSanPham_V2_TH(String thh) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh, SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH, \r\n"
					+ "                  SanPham.maXX, XuatXu.tenXX, SanPham.maCL, ChatLieu.tenCL, SanPham.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC "
					+ "WHERE ThuongHieu.tenTH = ? and SanPham.tinhTrang = N'Còn bán'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, thh);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "'";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);

				list.add(sp);			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<SanPham> getAllSanPham_V2_CL(String cll) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh, SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH, \r\n"
					+ "                  SanPham.maXX, XuatXu.tenXX, SanPham.maCL, ChatLieu.tenCL, SanPham.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC "
					+ "WHERE ChatLieu.tenCL = ? and SanPham.tinhTrang = N'Còn bán'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cll);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "'";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);

				list.add(sp);			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public SanPham getSanPham_Ma(String maSP1) {
		SanPham sp = new SanPham();
		PreparedStatement ps=null;
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  SanPham.maSanPham, SanPham.tenSP, SanPham.giaGoc, SanPham.hinhAnh, SanPham.moTa, SanPham.gioiTinh, SanPham.phongCach, SanPham.loai, SanPham.coAo, SanPham.soLuongLoi, SanPham.maTH, ThuongHieu.tenTH, \r\n"
					+ "                  SanPham.maXX, XuatXu.tenXX, SanPham.maCL, ChatLieu.tenCL, SanPham.maNCC, NhaCungCap.tenNCC, SanPham.tinhTrang\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ThuongHieu ON SanPham.maTH = ThuongHieu.maTH INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXX = XuatXu.maXX INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maCL = ChatLieu.maCL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC "
					+ "WHERE SanPham.maSanPham like ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1,maSP1+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ArrayList<ChiTietSanPham> listCTSP = new ArrayList<ChiTietSanPham>();
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double giaGoc = rs.getDouble(3);
				String hinhAnh = rs.getString(4);
				String moTa = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String phongCach = rs.getString(7);
				String loai = rs.getString(8);
				String coAo = rs.getString(9);
				int soLuongLoi = rs.getInt(10);
				
				ThuongHieu thuongHieu = new ThuongHieu(rs.getString(11),rs.getString(12));
				XuatXu xuatXu = new XuatXu(rs.getString(13),rs.getString(14));		
				ChatLieu chatLieu = new ChatLieu(rs.getString(15),rs.getString(16));	
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(17),rs.getString(18));
				String tinhTrang = rs.getString(19);

				
					String sql1 = "SELECT ChiTietSanPham.*\r\n" + "FROM ChiTietSanPham\r\n" + "WHERE maSP = '"
							+ maSanPham + "'";
					Statement statement1 = con.createStatement();
					ResultSet rs1 = statement1.executeQuery(sql1);
					while (rs1.next()) {
						
						String maCTSP = rs1.getString(1);
						String maSP = rs1.getString(2);
						String size = rs1.getString(3);
						String mau = rs1.getString(4);
						int soLuong = rs1.getInt(5);
						listCTSP.add(new ChiTietSanPham(maCTSP, maSP, size, mau, soLuong));
					}
				
				
				sp = new SanPham(maSanPham, tenSanPham, giaGoc, hinhAnh, moTa, gioiTinh, phongCach, loai, coAo,
						soLuongLoi, chatLieu, thuongHieu, xuatXu, nhaCungCap, tinhTrang, listCTSP);

	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return sp;
	}
	public boolean themMoi_SP(SanPham sp) {
		int n = 0;
		PreparedStatement ps=null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "insert into SanPham values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
			ps = con.prepareStatement(sql);
			ps.setString(1,sp.getMaSanPham());
			ps.setString(2,sp.getTenSanPham());
			ps.setDouble(3,sp.getGiaGoc());
			ps.setString(4,sp.getHinhAnh());
			ps.setString(5,sp.getMoTa());
			ps.setString(6,sp.getGioiTinh());
			ps.setString(7,sp.getPhongCach());
			ps.setString(8,sp.getLoai());
			ps.setString(9,sp.getCoAo());
			ps.setInt(10,sp.getSoLuongLoi());
			ps.setString(11,sp.getChatLieu().getMaCL());
			ps.setString(12,sp.getThuongHieu().getMaTH());
			ps.setString(13,sp.getXuatXu().getMaXX());
			ps.setString(14,sp.getNhaCungCap().getMaNCC());
			ps.setString(15, sp.getTinhTrang());
			n=ps.executeUpdate();
			for(ChiTietSanPham ct :sp.getChiTietSanPham()) {
				themMoi_CTSP(ct);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("import SP pending ...");
		}finally {
			try {
				ps.close();
				
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public void themMoi_CTSP(ChiTietSanPham ct) {

		PreparedStatement ps1=null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();		
			String sql1 = "insert into ChiTietSanPham  values(?,?,?,?,?) ";
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, ct.getMaChiTietSanPham());
			ps1.setString(2, ct.getMaSanPham());
			ps1.setString(3, ct.getSize());
			ps1.setString(4, ct.getMau());
			ps1.setDouble(5, ct.getSoLuong());
			ps1.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("import CTSP pending ...");
		}finally {
			try {
				ps1.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public boolean capNhat_SP(SanPham sp) {
		int n = 0;
		PreparedStatement ps=null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "update SanPham set tenSP = ?, giaGoc = ?,"
					+ "hinhAnh= ?, moTa = ?,"
					+ "gioiTinh= ?, loai = ?, maCL = ?, maTH= ?,"
					+ "maXX = ?, maNCC= ? , tinhTrang = ? , soLuongLoi = ? "
					+ "where maSanPham = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1,sp.getTenSanPham());
			ps.setDouble(2,sp.getGiaGoc());
			ps.setString(3,sp.getHinhAnh());
			ps.setString(4,sp.getMoTa());
			ps.setString(5,sp.getGioiTinh());
			ps.setString(6,sp.getLoai());
			ps.setString(7,sp.getChatLieu().getMaCL());
			ps.setString(8,sp.getThuongHieu().getMaTH());
			ps.setString(9,sp.getXuatXu().getMaXX());
			ps.setString(10,sp.getNhaCungCap().getMaNCC());
			ps.setString(11,sp.getTinhTrang());
			ps.setInt(12,sp.getSoLuongLoi());
			ps.setString(13,sp.getMaSanPham());
			n=ps.executeUpdate();
			for(ChiTietSanPham ct :sp.getChiTietSanPham()) {
				capNhat_CTSP(ct);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public void capNhat_CTSP(ChiTietSanPham ct) {

		PreparedStatement ps1=null;
		try {
			ConnectDB.getInstance();
			Connection conn = ConnectDB.getConnection();		
			String sql1 = "update ChiTietSanPham set Mau = ? where maCTSP = ?";
			ps1 = conn.prepareStatement(sql1);	
			ps1.setString(1, ct.getMau());
			ps1.setString(2, ct.getMaChiTietSanPham());
			ps1.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps1.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public ChiTietSanPham getChiTietSanPham(String maCTSP) {
		ChiTietSanPham ctsp = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT     ChiTietSanPham.*\r\n"
					+ "FROM        ChiTietSanPham\r\n"
					+ "Where maCTSP = '"+maCTSP+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ctsp = new ChiTietSanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ctsp;
	}
	
	public boolean them_CTSP(ChiTietSanPham ct) {

		PreparedStatement ps1=null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection conn = ConnectDB.getConnection();		
			String sql1 = "insert into ChiTietSanPham values (?,?,?,?,?)";
			ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, ct.getMaChiTietSanPham());
			ps1.setString(2, ct.getMaSanPham());
			ps1.setString(3, ct.getSize());
			ps1.setString(4, ct.getMau());
			ps1.setInt(5, ct.getSoLuong());
			n = ps1.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps1.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public ArrayList<SanPham> getSPBanChayNgay(LocalDate lcd) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT SanPham.tenSP,COUNT(ChiTietHoaDon.maCTSP) AS sl\r\n"
					+ "FROM     HoaDonBanHang INNER JOIN\r\n"
					+ "                  ChiTietHoaDon ON HoaDonBanHang.maHoaDon = ChiTietHoaDon.maHD INNER JOIN\r\n"
					+ "                  ChiTietSanPham ON ChiTietHoaDon.maCTSP = ChiTietSanPham.maCTSP INNER JOIN\r\n"
					+ "                  SanPham ON ChiTietSanPham.maSP = SanPham.maSanPham\r\n"
					+ "WHERE (DAY(HoaDonBanHang.ngayLapHoaDon) = ?) "
					+ "AND (MONTH(HoaDonBanHang.ngayLapHoaDon) = ?) AND (YEAR(HoaDonBanHang.ngayLapHoaDon) = ?)\r\n"
					+ "GROUP BY SanPham.tenSP\r\n"
					+ "ORDER BY sl DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,lcd.getDayOfMonth());
			ps.setInt(2,lcd.getMonthValue());
			ps.setInt(3,lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String ten = rs.getString(1);
				int sl = rs.getInt(2);
				SanPham sp = new SanPham(ten, sl);
				list.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public ArrayList<SanPham> getSPBanChay_Thang(LocalDate lcd) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT SanPham.tenSP,COUNT(ChiTietHoaDon.maCTSP) AS sl\r\n"
					+ "FROM     HoaDonBanHang INNER JOIN\r\n"
					+ "                  ChiTietHoaDon ON HoaDonBanHang.maHoaDon = ChiTietHoaDon.maHD INNER JOIN\r\n"
					+ "                  ChiTietSanPham ON ChiTietHoaDon.maCTSP = ChiTietSanPham.maCTSP INNER JOIN\r\n"
					+ "                  SanPham ON ChiTietSanPham.maSP = SanPham.maSanPham\r\n"
					+ "WHERE (MONTH(HoaDonBanHang.ngayLapHoaDon) = ?) AND (YEAR(HoaDonBanHang.ngayLapHoaDon) = ?)\r\n"
					+ "GROUP BY SanPham.tenSP\r\n"
					+ "ORDER BY sl DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,lcd.getMonthValue());
			ps.setInt(2,lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String ten = rs.getString(1);
				int sl = rs.getInt(2);
				SanPham sp = new SanPham(ten, sl);
				list.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public ArrayList<SanPham> getSPBanChay_Nam(LocalDate lcd) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT SanPham.tenSP,COUNT(ChiTietHoaDon.maCTSP) AS sl\r\n"
					+ "FROM     HoaDonBanHang INNER JOIN\r\n"
					+ "                  ChiTietHoaDon ON HoaDonBanHang.maHoaDon = ChiTietHoaDon.maHD INNER JOIN\r\n"
					+ "                  ChiTietSanPham ON ChiTietHoaDon.maCTSP = ChiTietSanPham.maCTSP INNER JOIN\r\n"
					+ "                  SanPham ON ChiTietSanPham.maSP = SanPham.maSanPham\r\n"
					+ "WHERE (YEAR(HoaDonBanHang.ngayLapHoaDon) = ?)\r\n"
					+ "GROUP BY SanPham.tenSP\r\n"
					+ "ORDER BY sl DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,lcd.getYear());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String ten = rs.getString(1);
				int sl = rs.getInt(2);
				SanPham sp = new SanPham(ten, sl);
				list.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
