package gui;

import java.awt.EventQueue;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.CaLam;
import entity.ChiTietSanPham;
import entity.FormatTien;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.LichSuBanHang;
import entity.NhanVien;
import entity.SanPham;
import entity.TaiKhoan;
import gui.Form_TrangChu_QuanLi.runFile;
import test.OpenPDF;
import test.TaoHoaDonPDF;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatter;

import org.jfree.ui.Spinner;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import com.itextpdf.io.image.Jpeg2000ImageData;
import com.toedter.calendar.JDateChooser;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JYearChooser;

import ae.java.awt.Dialog.ModalityType;
import dao.DAO_CaLam;
import dao.DAO_HoaDonBanHang;
import dao.DAO_HoaDonTraHang;
import dao.DAO_KhachHang;
import dao.DAO_TaiKhoan;
import dao.Dao_SanPham;
import database.ConnectDB;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

public class FormNhanVien extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	ArrayList<Panel_Item> listItem = new ArrayList<Panel_Item>();

	private JPanel contentPane, panel_item;
	private JTextField textField_TimKiem, tf_TKHK;
	private JTabbedPane tabbedPane_Main;
	private JButton btn_DoiSize, btn_DoiHangLoi, btn_QLKH, btn_CaLam, btn_ThongKe, btn_CNTTKH;
	private JTable table_KH, tb_LSBH_Ngay, tb_LSBH_Nam, tb_LSBH_Thang, table_LSMuaHang;
	int xoa;
	ImageIcon icon = new ImageIcon("image/cart.png");
	Dao_SanPham dao_SanPham = new Dao_SanPham();
	DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
	DAO_HoaDonBanHang dao_HoaDonBanHang = new DAO_HoaDonBanHang();
	DAO_CaLam dao_Calam = new DAO_CaLam();
	private NhanVien nhanVien;
	private ArrayList<SanPham> listsp;
	JPanel panel_10_1, panel_10_1_1;

	Locale localeVD = new Locale("vi", "VN");
	NumberFormat nbFormat = NumberFormat.getCurrencyInstance(localeVD);
	static FormNhanVien frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					frame = new FormNhanVien();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public FormNhanVien(NhanVien nhanVien) throws IOException {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.nhanVien = nhanVien;
		/*-------------------------------------------------------- Giao Diện ------------------------------------------------------*/
		//		nhanVien = new NhanVien("NV0001", "Lê Thị Thảo", getName(), getTitle(), getWarningString(), getName(), new Date(2002,8,2),
		//				new Date(2002,8,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 50, 1500, 750);
		contentPane = new JPanel();
		contentPane.setBorder(null);


		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTitle("Trang chủ nhân viên - "+ nhanVien.getTenNV()+ " - "+nhanVien.getMaNV());
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1485, 713);

		panel.setPreferredSize(new Dimension(1500, 720));
		contentPane.add(panel);
		panel.setLayout(null);

		tabbedPane_Main = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Main.setBounds(251, -23, 1235, 733);
		panel.add(tabbedPane_Main);

		JPanel panel_BanHang = new JPanel();
		tabbedPane_Main.addTab("New tab", null, panel_BanHang, null);
		panel_BanHang.setLayout(null);

		JScrollPane scrollPane_DSHang = new JScrollPane();
		scrollPane_DSHang.setBounds(0, 47, 810, 649);
		panel_BanHang.add(scrollPane_DSHang);
		scrollPane_DSHang.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_DSHang.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		panel_item = new JPanel();

		panel_item.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		scrollPane_DSHang.setViewportView(panel_item);

		panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.Y_AXIS));

		// JPanel panel_ItemDH = new JPanel();
		// scrollPane_DonHang.setViewportView(panel_ItemDH);
		// panel_ItemDH.setLayout(new BoxLayout(panel_ItemDH, BoxLayout.Y_AXIS));

		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBounds(0, 0, 810, 49);
		panel_BanHang.add(panel_TimKiem);
		panel_TimKiem.setBackground(new Color(0, 160, 215));
		panel_TimKiem.setLayout(null);

		textField_TimKiem = new JTextField();
		textField_TimKiem.setBounds(497, 10, 286, 29);
		panel_TimKiem.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nhập mã sản phẩm :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(323, 10, 164, 29);
		panel_TimKiem.add(lblNewLabel);

		JPanel pl_DoiHang = new JPanel();
		pl_DoiHang.setBounds(10, 10, 130, 29);
		panel_TimKiem.add(pl_DoiHang);
		pl_DoiHang.setLayout(null);
		pl_DoiHang.setBackground(new Color(85, 65, 118));

		JLabel lbl_DoiHang = new JLabel("Trả Hàng");

		lbl_DoiHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DoiHang.setForeground(new Color(255, 255, 255));
		lbl_DoiHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_DoiHang.setBounds(0, 0, 130, 29);
		pl_DoiHang.add(lbl_DoiHang);

		lbl_DoiHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pl_DoiHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
				if (pl_DoiHang.getBackground().equals(new Color(0, 150, 186))) {

				} else {
					pl_DoiHang.setBackground(new Color(85, 65, 118));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (pl_DoiHang.getBackground().equals(new Color(0, 150, 186))) {

				} else {
					pl_DoiHang.setBackground(new Color(54, 33, 89));
				}

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				FormDoiHang formDH = new FormDoiHang(nhanVien, panel_item, listItem);
				formDH.setVisible(true);
			}
		});

		// panel_TimKiem.setLayout(new BoxLayout(panel_TimKiem, BoxLayout.Y_AXIS));

		JTabbedPane tabbedPane_GioHang = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_GioHang.setBounds(810, 0, 425, 712);
		panel_BanHang.add(tabbedPane_GioHang);

		JPanel panel_QLKH = new JPanel();
		panel_QLKH.setBackground(new Color(240, 240, 240));
		tabbedPane_Main.addTab("New tab", null, panel_QLKH, null);
		panel_QLKH.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 133, 835, 563);
		panel_QLKH.add(scrollPane);

		table_KH = new JTable();
		table_KH.setBackground(new Color(255, 255, 255));
		table_KH.setRowHeight(50);

		DefaultTableModel tbModelKH = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Khách Hàng", "Họ Têm", "SĐT", "Loại Khách Hàng", "Tổng tiền đã mua" });
		table_KH.setModel(tbModelKH);
		ArrayList<KhachHang> listKH = dao_KhachHang.getAllKhachHang();
		for (KhachHang khachHang : listKH) {

			String[] st = { khachHang.getMaKhachHang(), khachHang.getHoTenKhachHang(), khachHang.getSoDienThoai(),
					khachHang.getLoaiKhachHang(),
					nbFormat.format(dao_KhachHang.getTongTienDaMua(khachHang.getMaKhachHang())) + "" };
			tbModelKH.addRow(st);
		}
		scrollPane.setViewportView(table_KH);

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(new Color(255, 255, 255));
		panel_Header.setBounds(0, 30, 1230, 55);
		panel_QLKH.add(panel_Header);
		panel_Header.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 160, 215)));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(0, 0, 1230, 55);
		panel_Header.add(lblNewLabel_2);

		JButton btn_locKH = new JButton("Lọc");
		btn_locKH.setFont(new Font("Dialog", Font.BOLD, 12));

		btn_locKH.setBounds(310, 98, 75, 25);
		panel_QLKH.add(btn_locKH);

		tf_TKHK = new JTextField();
		tf_TKHK.setFont(new Font("Tahoma", Font.ITALIC, 15));
		tf_TKHK.setColumns(10);
		tf_TKHK.setBounds(10, 99, 120, 24);
		panel_QLKH.add(tf_TKHK);
		tf_TKHK.setText("Tìm SĐT");
		tf_TKHK.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (tf_TKHK.getText().equals("Tìm SĐT")) {
					tf_TKHK.setText("");
					tf_TKHK.setFont(new Font("Tahoma", Font.PLAIN, 10));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				if (tf_TKHK.getText().equals("")) {
					tf_TKHK.setText("");
					tf_TKHK.setFont(new Font("Tahoma", Font.PLAIN, 10));
				}
			}
		});

		JButton btn_CNTTKH = new JButton("Cập nhật TTKH");
		btn_CNTTKH.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_CNTTKH.setBounds(569, 98, 135, 25);
		panel_QLKH.add(btn_CNTTKH);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(845, 133, 375, 563);
		panel_QLKH.add(scrollPane_2);

		table_LSMuaHang = new JTable();
		//		table_LSMuaHang.setBackground(new Color(184, 160, 217));
		//		table_LSMuaHang.setForeground(new Color(0, 0, 0));
		table_LSMuaHang.setRowHeight(50);
		DefaultTableModel tbModel_LSMuaHang = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Ngày lập HĐ", "Tổng tiền HĐ" });
		table_LSMuaHang.setModel(tbModel_LSMuaHang);
		scrollPane_2.setViewportView(table_LSMuaHang);

		table_KH.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				tbModel_LSMuaHang.setRowCount(0);
				int row = table_KH.getSelectedRow();
				String maKH = table_KH.getModel().getValueAt(row, 0).toString();
				ArrayList<HoaDonBanHang> listHD = dao_HoaDonBanHang.getHDBH(maKH);
				for (HoaDonBanHang hd : listHD) {
					String[] strings = { hd.getMaHoaDon(), hd.getNgayLapHoaDon() + "",
							nbFormat.format(hd.getTongTienHD()) + "" };
					tbModel_LSMuaHang.addRow(strings);
				}
			}
		});

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(834, 88, 396, 46);
		panel_QLKH.add(panel_7);
		panel_7.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Lịch sử mua hàng");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 0, 376, 46);
		panel_7.add(lblNewLabel_6);

		JComboBox cbb_LocKH = new JComboBox();
		cbb_LocKH.setBounds(150, 98, 135, 25);
		panel_QLKH.add(cbb_LocKH);
		cbb_LocKH.addItem("Tất cả");
		cbb_LocKH.addItem("Thân thiết");
		cbb_LocKH.addItem("Khách thường");

		JButton btn_LamMoi = new JButton("Làm mới");
		btn_LamMoi.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_LamMoi.setBounds(714, 98, 100, 25);
		panel_QLKH.add(btn_LamMoi);

		JButton btn_ThemKH = new JButton("Thêm KH");
		btn_ThemKH.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_ThemKH.setBounds(459, 98, 100, 25);
		panel_QLKH.add(btn_ThemKH);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(new Color(0, 160, 215));
		lblNewLabel_8.setBounds(0, 0, 1230, 30);
		panel_QLKH.add(lblNewLabel_8);

		btn_ThemKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormThemKH dialog = new FormThemKH();
				String maKH = "KH" + String.format("%04d", listKH.size() + 1) + "";
				dialog.textField.setText(maKH);
				dialog.textField.setEditable(false);
				dialog.getBtn_XacNhan().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (dialog.ktSDT() && dialog.ktTenKH()) {
							String maKH = "KH" + String.format("%04d", listKH.size() + 1) + "";
							String loaiKH = "Khách thường";
							String tenKH = dialog.getTf_TenKH().getText();
							String sdt = dialog.getTf_SDT().getText();
							KhachHang khachHang = new KhachHang(maKH, tenKH, sdt, loaiKH);
							dao_KhachHang.createKH(khachHang);
							JOptionPane.showMessageDialog(null, "Thêm thành công.");
							dialog.dispose();
						}
					}
				});
				dialog.setVisible(true);
			}
		});

		btn_LamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tbModelKH.setRowCount(0);
				ArrayList<KhachHang> listKH = dao_KhachHang.getAllKhachHang();
				for (KhachHang khachHang : listKH) {

					String[] st = { khachHang.getMaKhachHang(), khachHang.getHoTenKhachHang(),
							khachHang.getSoDienThoai(), khachHang.getLoaiKhachHang(),
							nbFormat.format(dao_KhachHang.getTongTienDaMua(khachHang.getMaKhachHang())) + "" };
					tbModelKH.addRow(st);
				}
			}
		});

		JPanel panel_LichLamViec = new JPanel();
		tabbedPane_Main.addTab("New tab", null, panel_LichLamViec, null);
		panel_LichLamViec.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 30, 1230, 90);
		panel_LichLamViec.add(panel_3);

		JLabel lblLichLam = new JLabel("LỊCH LÀM VIỆC CỦA NHÂN VIÊN");
		lblLichLam.setHorizontalAlignment(SwingConstants.CENTER);
		lblLichLam.setForeground(Color.BLUE);
		lblLichLam.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLichLam.setBackground(new Color(255, 255, 128));
		lblLichLam.setBounds(0, 0, 1230, 90);
		panel_3.add(lblLichLam);



		ArrayList<CaLam> arrCalam = new ArrayList<CaLam>();
		arrCalam = dao_Calam.getAllCaLam2();

		DefaultTableModel modelCalam = new DefaultTableModel();	
		JTable tableCalam = new JTable(modelCalam);
		String[] row0 = {"","Thứ 2","Thứ 3","Thứ 4","Thứ 5","Thứ 6","Thứ 7","Chủ nhật"};
		Object[][] data = {
				{"Ca Sáng",arrCalam.get(0).getMaNV().getTenNV(),arrCalam.get(2).getMaNV().getTenNV()
					,arrCalam.get(4).getMaNV().getTenNV(),arrCalam.get(6).getMaNV().getTenNV()
					,arrCalam.get(8).getMaNV().getTenNV(),arrCalam.get(10).getMaNV().getTenNV(),
					arrCalam.get(12).getMaNV().getTenNV()},
				{"Ca Tối",arrCalam.get(1).getMaNV().getTenNV(),arrCalam.get(3).getMaNV().getTenNV()
						,arrCalam.get(5).getMaNV().getTenNV(),arrCalam.get(7).getMaNV().getTenNV()
						,arrCalam.get(9).getMaNV().getTenNV(),arrCalam.get(11).getMaNV().getTenNV()
						,arrCalam.get(13).getMaNV().getTenNV()}
		};
		modelCalam.setDataVector(data, row0);
		for(int i = 1;i<8;i++) {
			String row = tableCalam.getValueAt(0, i).toString();
			if(!row.equals(nhanVien.getTenNV())){
				tableCalam.setValueAt("", 0, i);
			}
		}
		for(int i = 1;i<8;i++) {
			String row = tableCalam.getValueAt(1, i).toString();
			if(!row.equals(nhanVien.getTenNV())){
				tableCalam.setValueAt("", 1, i);
			}
		}
		//		tableCalam.setForeground(Color.);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tableCalam.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableCalam.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableCalam.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableCalam.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableCalam.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableCalam.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tableCalam.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		tableCalam.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		tableCalam.setRowHeight(198);
		JScrollPane scrollPane_4 = new JScrollPane(tableCalam);
		scrollPane_4.setBounds(10, 184, 1210, 420);
		panel_LichLamViec.add(scrollPane_4);

		//		table = new JTable();
		//		DefaultTableModel tb_Model_CaLam = new DefaultTableModel(new Object[][] {},
		//				new String[] { "Ca Làm", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật" });
		//		table.setModel(tb_Model_CaLam);
		//		String[] caSang = new DAO_CaLam().getTeNV("0");
		//		caSang[0] = "Sáng";
		//		tb_Model_CaLam.addRow(caSang);
		//		String[] caToi = new DAO_CaLam().getTeNV("1");
		//		caToi[0] = "Tối";
		//		tb_Model_CaLam.addRow(caToi);
		//		scrollPane_4.setViewportView(table);
		//		table.setRowHeight(200);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setBackground(new Color(0, 160, 215));
		lblNewLabel_9.setBounds(0, 0, 1230, 30);
		panel_LichLamViec.add(lblNewLabel_9);

		JPanel panel_ThongKe = new JPanel();
		tabbedPane_Main.addTab("New tab", null, panel_ThongKe, null);
		panel_ThongKe.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 91, 1230, 592);
		panel_ThongKe.add(tabbedPane);

		JPanel panel_Ngay = new JPanel();
		panel_Ngay.setBackground(new Color(0, 191, 255));
		tabbedPane.addTab("Ngày", null, panel_Ngay, null);
		panel_Ngay.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(0, 62, 836, 493);
		panel_Ngay.add(scrollPane_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(930, 16, 185, 30);
		panel_Ngay.add(dateChooser);
		LocalDate today = LocalDate.now();
		Date todayDate = java.sql.Date.valueOf(today);
		dateChooser.setDate(todayDate);

		tb_LSBH_Ngay = new JTable();
		tb_LSBH_Ngay.setRowHeight(50);
		DefaultTableModel tbModel_LSBH_Ngay = new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Ngày",
				"Mã hóa đơn", "Tên nhân viên", "Tên KH", "Số điện thoại", "tổng tiền HĐ" });
		tb_LSBH_Ngay.setModel(tbModel_LSBH_Ngay);

		Date ngayDate1 = java.sql.Date.valueOf(today);

		ArrayList<LichSuBanHang> listLSBH_Ngay = dao_HoaDonBanHang.getHoaDonNgay(ngayDate1, nhanVien.getTenNV());
		ArrayList<LichSuBanHang> listLSTH_Ngay = new DAO_HoaDonTraHang().getHoaDonNgay(ngayDate1, nhanVien.getTenNV());
		listLSBH_Ngay.addAll(listLSTH_Ngay);

		scrollPane_1.setViewportView(tb_LSBH_Ngay);

		JButton btn_LocTheoNgay = new JButton("Lọc");
		btn_LocTheoNgay.setBounds(1130, 16, 85, 30);
		panel_Ngay.add(btn_LocTheoNgay);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(846, 62, 369, 210);
		panel_Ngay.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("TỔNG HÓA ĐƠN:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 369, 45);
		panel_4.add(lblNewLabel_3);

		JLabel lbl_TongHDNgay = new JLabel(tongSLHD(listLSBH_Ngay) + "");
		lbl_TongHDNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_TongHDNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TongHDNgay.setBounds(0, 66, 369, 115);
		panel_4.add(lbl_TongHDNgay);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_4_1.setBackground(new Color(255, 255, 255));
		panel_4_1.setBounds(846, 345, 369, 210);
		panel_Ngay.add(panel_4_1);

		JLabel lblNewLabel_3_1 = new JLabel("TỔNG DOANH THU:");
		lblNewLabel_3_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(0, 0, 369, 45);
		panel_4_1.add(lblNewLabel_3_1);

		JLabel lbl_TongDTNgay = new JLabel(nbFormat.format(tongDT(listLSBH_Ngay)) + "");
		lbl_TongDTNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_TongDTNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TongDTNgay.setBounds(0, 71, 369, 115);
		panel_4_1.add(lbl_TongDTNgay);

		btn_LocTheoNgay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				java.util.Date utilDate = dateChooser.getDate();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

				tbModel_LSBH_Ngay.setRowCount(0);
				ArrayList<LichSuBanHang> listLSBH1 = dao_HoaDonBanHang.getHoaDonNgay(sqlDate, nhanVien.getTenNV());
				ArrayList<LichSuBanHang> listLSTH_Ngay = new DAO_HoaDonTraHang().getHoaDonNgay(sqlDate, nhanVien.getTenNV());
				listLSBH1.addAll(listLSTH_Ngay);
				int stt1 = 1;
				for (LichSuBanHang lsbh : listLSBH1) {
					String[] row = { stt1 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
							lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
					tbModel_LSBH_Ngay.addRow(row);
					stt1++;
				}
				lbl_TongDTNgay.setText(nbFormat.format(tongDT(listLSBH1)) + "");
				lbl_TongHDNgay.setText(tongSLHD(listLSBH1) + "");
			}
		});

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 836, 62);
		panel_Ngay.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("LỊCH SỬ BÁN HÀNG");
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 191, 255)));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 836, 62);
		panel_6.add(lblNewLabel_4);

		JComboBox cbLoai_Ngay = new JComboBox();
		cbLoai_Ngay.setBounds(679, 27, 147, 25);
		panel_6.add(cbLoai_Ngay);
		cbLoai_Ngay.addItem("Tất Cả");
		cbLoai_Ngay.addItem("HD Bán Hàng");
		cbLoai_Ngay.addItem("HD Trả Hàng");

		cbLoai_Ngay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbLoai_Ngay.getSelectedItem().toString().equals("HD Trả Hàng")) {
					java.util.Date utilDate = dateChooser.getDate();
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

					tbModel_LSBH_Ngay.setRowCount(0);
					ArrayList<LichSuBanHang> listLSTH_Ngay = new DAO_HoaDonTraHang().getHoaDonNgay(sqlDate, nhanVien.getTenNV());
					int stt1 = 1;
					for (LichSuBanHang lsbh : listLSTH_Ngay) {
						String[] row = { stt1 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
								lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
						tbModel_LSBH_Ngay.addRow(row);
						stt1++;
					}
				} else if(cbLoai_Ngay.getSelectedItem().toString().equals("HD Bán Hàng")) {
					java.util.Date utilDate = dateChooser.getDate();
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

					tbModel_LSBH_Ngay.setRowCount(0);
					ArrayList<LichSuBanHang> listLSBH1 = dao_HoaDonBanHang.getHoaDonNgay(sqlDate, nhanVien.getTenNV());
					int stt1 = 1;
					for (LichSuBanHang lsbh : listLSBH1) {
						String[] row = { stt1 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
								lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
						tbModel_LSBH_Ngay.addRow(row);
						stt1++;
					}
				} else {
					java.util.Date utilDate = dateChooser.getDate();
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

					tbModel_LSBH_Ngay.setRowCount(0);
					ArrayList<LichSuBanHang> listLSBH1 = dao_HoaDonBanHang.getHoaDonNgay(sqlDate, nhanVien.getTenNV());
					ArrayList<LichSuBanHang> listLSTH_Ngay = new DAO_HoaDonTraHang().getHoaDonNgay(sqlDate, nhanVien.getTenNV());
					listLSBH1.addAll(listLSTH_Ngay);
					int stt1 = 1;
					for (LichSuBanHang lsbh : listLSBH1) {
						String[] row = { stt1 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
								lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
						tbModel_LSBH_Ngay.addRow(row);
						stt1++;
					}
				}
			}
		});

		JLabel lblNewLabel_7_1_1 = new JLabel("Loại");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1_1.setBounds(609, 27, 60, 25);
		panel_6.add(lblNewLabel_7_1_1);

		JPanel panel_Thang = new JPanel();
		panel_Thang.setBackground(new Color(0, 191, 255));
		panel_Thang.setLayout(null);
		tabbedPane.addTab("Tháng", null, panel_Thang, null);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1_1.setBounds(0, 62, 836, 493);
		panel_Thang.add(scrollPane_1_1);

		JComboBox cb_Thang = new JComboBox();
		cb_Thang.setBounds(930, 16, 85, 30);
		panel_Thang.add(cb_Thang);
		cb_Thang.addItem(1);
		cb_Thang.addItem(2);
		cb_Thang.addItem(3);
		cb_Thang.addItem(4);
		cb_Thang.addItem(5);
		cb_Thang.addItem(6);
		cb_Thang.addItem(7);
		cb_Thang.addItem(8);
		cb_Thang.addItem(9);
		cb_Thang.addItem(10);
		cb_Thang.addItem(11);
		cb_Thang.addItem(12);
		cb_Thang.setSelectedIndex(today.getMonthValue() - 1);

		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(1030, 16, 85, 30);
		panel_Thang.add(yearChooser);

		JButton btn_LocThang = new JButton("Lọc");
		btn_LocThang.setBounds(1130, 16, 85, 30);
		panel_Thang.add(btn_LocThang);

		tb_LSBH_Thang = new JTable();
		tb_LSBH_Thang.setRowHeight(50);
		DefaultTableModel tbModel_LSBH_Thang = new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Ngày",
				"Mã hóa đơn", "Tên nhân viên", "Tên KH", "Số điện thoại", "tổng tiền HĐ" });
		tb_LSBH_Thang.setModel(tbModel_LSBH_Thang);
		scrollPane_1_1.setViewportView(tb_LSBH_Thang);

		ArrayList<LichSuBanHang> listLSBH_Thang = dao_HoaDonBanHang.getHoaDonThang(today.getMonthValue() + "",
				yearChooser.getYear() + "", nhanVien.getTenNV());
		ArrayList<LichSuBanHang> listLSTH_Thang = new DAO_HoaDonTraHang().getHoaDonThang(today.getMonthValue() + "",
				yearChooser.getYear() + "", nhanVien.getTenNV());
		listLSBH_Thang.addAll(listLSTH_Thang);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_4_2.setBackground(new Color(255, 255, 255));
		panel_4_2.setBounds(846, 62, 369, 210);
		panel_Thang.add(panel_4_2);

		JLabel lblNewLabel_3_2 = new JLabel("TỔNG HÓA ĐƠN:");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(0, 0, 369, 45);
		panel_4_2.add(lblNewLabel_3_2);

		JLabel lbl_TongHD_Thang = new JLabel(tongSLHD(listLSBH_Thang) + "");
		lbl_TongHD_Thang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_TongHD_Thang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TongHD_Thang.setBounds(0, 72, 369, 95);
		panel_4_2.add(lbl_TongHD_Thang);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_4_1_1.setBackground(new Color(255, 255, 255));
		panel_4_1_1.setBounds(846, 345, 369, 210);
		panel_Thang.add(panel_4_1_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("TỔNG DOANH THU:");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(0, 0, 369, 45);
		panel_4_1_1.add(lblNewLabel_3_1_1);

		JLabel lbl_TongDT_Thang = new JLabel(nbFormat.format(tongDT(listLSBH_Thang)) + "");
		lbl_TongDT_Thang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_TongDT_Thang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TongDT_Thang.setBounds(0, 72, 369, 95);
		panel_4_1_1.add(lbl_TongDT_Thang);

		btn_LocThang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String thang = cb_Thang.getSelectedItem().toString();
				String nam = yearChooser.getYear() + "";

				tbModel_LSBH_Thang.setRowCount(0);
				ArrayList<LichSuBanHang> listLSBH_Thang = dao_HoaDonBanHang.getHoaDonThang(thang + "", nam,
						nhanVien.getTenNV());
				ArrayList<LichSuBanHang> listLSTH_Thang = new DAO_HoaDonTraHang().getHoaDonThang(thang + "", nam,
						nhanVien.getTenNV());
				listLSBH_Thang.addAll(listLSTH_Thang);
				int stt2 = 1;
				for (LichSuBanHang lsbh : listLSBH_Thang) {
					String[] row = { stt2 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
							lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
					tbModel_LSBH_Thang.addRow(row);
					stt2++;
				}
				lbl_TongHD_Thang.setText(tongSLHD(listLSBH_Thang) + "");
				lbl_TongDT_Thang.setText(nbFormat.format(tongDT(listLSBH_Thang)) + "");
			}
		});

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBounds(0, 0, 836, 62);
		panel_Thang.add(panel_6_1);

		JLabel lblNewLabel_4_1 = new JLabel("LỊCH SỬ BÁN HÀNG");
		lblNewLabel_4_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 191, 255)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(0, 0, 836, 62);
		panel_6_1.add(lblNewLabel_4_1);

		JComboBox cbLoai_Thang = new JComboBox();
		cbLoai_Thang.setBounds(679, 27, 147, 25);
		panel_6_1.add(cbLoai_Thang);
		cbLoai_Thang.addItem("Tất cả");
		cbLoai_Thang.addItem("HD Bán Hàng");
		cbLoai_Thang.addItem("HD Trả Hàng");

		cbLoai_Thang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbLoai_Thang.getSelectedItem().toString().equals("HD Trả Hàng")) {
					String thang = cb_Thang.getSelectedItem().toString();
					String nam = yearChooser.getYear() + "";
					tbModel_LSBH_Thang.setRowCount(0);
					ArrayList<LichSuBanHang> listLSTH_Thang = new DAO_HoaDonTraHang().getHoaDonThang(thang + "", nam,
							nhanVien.getTenNV());
					int stt2 = 1;
					for (LichSuBanHang lsbh : listLSTH_Thang) {
						String[] row = { stt2 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
								lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
						tbModel_LSBH_Thang.addRow(row);
						stt2++;
					} 
				} else if(cbLoai_Thang.getSelectedItem().toString().equals("HD Bán Hàng")) {
					String thang = cb_Thang.getSelectedItem().toString();
					String nam = yearChooser.getYear() + "";

					tbModel_LSBH_Thang.setRowCount(0);
					ArrayList<LichSuBanHang> listLSBH_Thang = dao_HoaDonBanHang.getHoaDonThang(thang + "", nam,
							nhanVien.getTenNV());
					int stt2 = 1;
					for (LichSuBanHang lsbh : listLSBH_Thang) {
						String[] row = { stt2 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
								lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
						tbModel_LSBH_Thang.addRow(row);
						stt2++;
					}
				} else {
					String thang = cb_Thang.getSelectedItem().toString();
					String nam = yearChooser.getYear() + "";

					tbModel_LSBH_Thang.setRowCount(0);
					ArrayList<LichSuBanHang> listLSBH_Thang = dao_HoaDonBanHang.getHoaDonThang(thang + "", nam,
							nhanVien.getTenNV());
					ArrayList<LichSuBanHang> listLSTH_Thang = new DAO_HoaDonTraHang().getHoaDonThang(today.getMonthValue() + "",
							yearChooser.getYear() + "", nhanVien.getTenNV());
					listLSBH_Thang.addAll(listLSTH_Thang);
					int stt2 = 1;
					for (LichSuBanHang lsbh : listLSBH_Thang) {
						String[] row = { stt2 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
								lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
						tbModel_LSBH_Thang.addRow(row);
						stt2++;
					}
				}
			}
		});

		JLabel lblNewLabel_7_1 = new JLabel("Loại");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(609, 27, 60, 25);
		panel_6_1.add(lblNewLabel_7_1);

		JPanel panel_Nam = new JPanel();
		panel_Nam.setBackground(new Color(0, 191, 255));
		panel_Nam.setLayout(null);
		tabbedPane.addTab("Năm", null, panel_Nam, null);

		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1_1_1.setBounds(0, 62, 836, 493);
		panel_Nam.add(scrollPane_1_1_1);

		JYearChooser yearChooser_1 = new JYearChooser();
		yearChooser_1.setBounds(1030, 16, 85, 30);
		panel_Nam.add(yearChooser_1);

		JButton btn_LocNam = new JButton("Lọc");
		btn_LocNam.setBounds(1130, 16, 85, 30);
		panel_Nam.add(btn_LocNam);

		tb_LSBH_Nam = new JTable();
		tb_LSBH_Nam.setRowHeight(50);
		DefaultTableModel tbModel_LSBH_Nam = new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Ngày",
				"Mã hóa đơn", "Tên nhân viên", "Tên KH", "Số điện thoại", "tổng tiền HĐ" });
		tb_LSBH_Nam.setModel(tbModel_LSBH_Nam);

		ArrayList<LichSuBanHang> listLSBH_Nam = dao_HoaDonBanHang.getHoaDonNam(yearChooser_1.getYear() + "",
				nhanVien.getTenNV());
		ArrayList<LichSuBanHang> lisLSTH_Nam = new DAO_HoaDonTraHang().getHoaDonNam(yearChooser_1.getYear() + "",
				nhanVien.getTenNV());
		listLSBH_Nam.addAll(lisLSTH_Nam);
		scrollPane_1_1_1.setViewportView(tb_LSBH_Nam);
		JPanel panel_4_2_1 = new JPanel();
		panel_4_2_1.setLayout(null);
		panel_4_2_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_4_2_1.setBackground(new Color(255, 255, 255));
		panel_4_2_1.setBounds(846, 62, 369, 210);
		panel_Nam.add(panel_4_2_1);

		JLabel lblNewLabel_3_2_1 = new JLabel("TỔNG HÓA ĐƠN:");
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2_1.setBounds(0, 0, 369, 45);
		panel_4_2_1.add(lblNewLabel_3_2_1);

		JLabel lbl_TongHD_Nam = new JLabel(tongSLHD(listLSBH_Nam) + "");
		lbl_TongHD_Nam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TongHD_Nam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_TongHD_Nam.setBounds(0, 69, 369, 98);
		panel_4_2_1.add(lbl_TongHD_Nam);

		JPanel panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setLayout(null);
		panel_4_1_1_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_4_1_1_1.setBackground(new Color(255, 255, 255));
		panel_4_1_1_1.setBounds(846, 345, 369, 210);
		panel_Nam.add(panel_4_1_1_1);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("TỔNG DOANH THU:");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_1_1.setBounds(0, 0, 369, 45);
		panel_4_1_1_1.add(lblNewLabel_3_1_1_1);

		JLabel lbl_TongDT_Nam = new JLabel(nbFormat.format(tongDT(listLSBH_Nam)) + "");
		lbl_TongDT_Nam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_TongDT_Nam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TongDT_Nam.setBounds(0, 84, 369, 85);
		panel_4_1_1_1.add(lbl_TongDT_Nam);

		btn_LocNam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tbModel_LSBH_Nam.setRowCount(0);
				int stt3 = 1;
				ArrayList<LichSuBanHang> listLSBH_Nam = dao_HoaDonBanHang.getHoaDonNam(yearChooser_1.getYear() + "",
						nhanVien.getTenNV());
				ArrayList<LichSuBanHang> listTH = new DAO_HoaDonTraHang().getHoaDonNam(yearChooser_1.getYear() + "",
						nhanVien.getTenNV());
				listLSBH_Nam.addAll(listTH);
				for (LichSuBanHang lsbh : listLSBH_Nam) {
					String[] row = { stt3 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
							lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
					tbModel_LSBH_Nam.addRow(row);
					stt3++;
				}
				lbl_TongHD_Nam.setText(tongSLHD(listLSBH_Nam) + "");
				lbl_TongDT_Nam.setText(nbFormat.format(tongDT(listLSBH_Nam)) + "");
			}
		});

		JPanel panel_6_1_1 = new JPanel();
		panel_6_1_1.setLayout(null);
		panel_6_1_1.setBounds(0, 0, 836, 62);
		panel_Nam.add(panel_6_1_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("LỊCH SỬ BÁN HÀNG");
		lblNewLabel_4_1_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 191, 255)));
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1_1.setBounds(0, 0, 836, 62);
		panel_6_1_1.add(lblNewLabel_4_1_1);

		JComboBox cbLoai_Nam = new JComboBox();
		cbLoai_Nam.setBounds(679, 22, 147, 25);
		panel_6_1_1.add(cbLoai_Nam);
		cbLoai_Nam.addItem("Tất cả");
		cbLoai_Nam.addItem("HD Bán Hàng");
		cbLoai_Nam.addItem("HD Trả Hàng");

		cbLoai_Nam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int stt3 = 1;

				if(cbLoai_Nam.getSelectedItem().toString().equals("HD Trả Hàng")) {
					tbModel_LSBH_Nam.setRowCount(0);
					ArrayList<LichSuBanHang> listTH = new DAO_HoaDonTraHang().getHoaDonNam(yearChooser_1.getYear() + "",
							nhanVien.getTenNV());
					for (LichSuBanHang lsbh : listTH) {
						String[] row = { stt3 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
								lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
						tbModel_LSBH_Nam.addRow(row);
						stt3++;
					}
				} else if(cbLoai_Nam.getSelectedItem().toString().equals("HD Bán Hàng")) {
					tbModel_LSBH_Nam.setRowCount(0);
					ArrayList<LichSuBanHang> listLSBH_Nam = dao_HoaDonBanHang.getHoaDonNam(yearChooser_1.getYear() + "",
							nhanVien.getTenNV());
					for (LichSuBanHang lsbh : listLSBH_Nam) {
						String[] row = { stt3 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
								lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
						tbModel_LSBH_Nam.addRow(row);
						stt3++;
					}
				} else {
					tbModel_LSBH_Nam.setRowCount(0);
					ArrayList<LichSuBanHang> listLSBH_Nam = dao_HoaDonBanHang.getHoaDonNam(yearChooser_1.getYear() + "",
							nhanVien.getTenNV());
					ArrayList<LichSuBanHang> listTH = new DAO_HoaDonTraHang().getHoaDonNam(yearChooser_1.getYear() + "",
							nhanVien.getTenNV());
					listLSBH_Nam.addAll(listTH);
					for (LichSuBanHang lsbh : listLSBH_Nam) {
						String[] row = { stt3 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
								lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
						tbModel_LSBH_Nam.addRow(row);
						stt3++;
					}
				}
			}
		});

		JLabel lblNewLabel_7 = new JLabel("Loại");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(609, 22, 60, 25);
		panel_6_1_1.add(lblNewLabel_7);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 30, 1230, 51);
		panel_ThongKe.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Thống Kê");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 1230, 51);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBackground(new Color(0, 160, 215));
		lblNewLabel_10.setOpaque(true);
		lblNewLabel_10.setBounds(0, 0, 1230, 30);
		panel_ThongKe.add(lblNewLabel_10);

		JPanel panel_TroGiup = new JPanel();
		tabbedPane_Main.addTab("New tab", null, panel_TroGiup, null);
		panel_TroGiup.setLayout(null);

		//		JPanel panel_8 = new JPanel();
		//		panel_8.setBounds(872, 0, 360, 706);
		//		panel_TroGiup.add(panel_8);
		//		panel_8.setLayout(null);
		//
		//		JButton btnNewButton = new JButton("New button");
		//		btnNewButton.setBounds(0, 0, 360, 42);
		//		panel_8.add(btnNewButton);
		//
		//		JScrollPane scrollPane_3 = new JScrollPane();
		//		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//		scrollPane_3.setBounds(0, 0, 873, 706);
		//		panel_TroGiup.add(scrollPane_3);
		//
		//		JPanel panel_9 = new JPanel();
		////		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		//		panel_9.setLayout(null);
		//
		//		scrollPane_3.setViewportView(panel_9);
		//
		//		panel_9.setPreferredSize(new Dimension(700, 10000));
		//
		//		JLabel lblNewLabel_5 = new JLabel("");
		//		lblNewLabel_5.setBounds(436, 5, 0, 0);
		//		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//		panel_9.add(lblNewLabel_5);
		//
		//		ImageBox imageBox = new ImageBox("image/ao-thun-2.jpg", 700, 700);
		//		imageBox.setBounds(441, 5, -1, -1);
		//		panel_9.add(imageBox);
		//		ImageBox imageBox_1 = new ImageBox("image/ao-thun-2.jpg", 700, 700);
		//		imageBox_1.setBounds(75, 58, 700, 700);
		//		panel_9.add(imageBox_1);

		JPanel panel_ChucNang = new JPanel();
		panel_ChucNang.setBackground(new Color(155, 231, 255));
		panel_ChucNang.setBounds(0, 0, 250, 710);
		panel.add(panel_ChucNang);
		panel_ChucNang.setLayout(null);

		JPanel panel_10 = new JPanel();
		panel_10.setBounds(0, 130, 250, 60);
		panel_ChucNang.add(panel_10);
		panel_10.setLayout(null);

		btn_QLKH = new JButton("Quản lý khách hàng");
		btn_QLKH.setBackground(new Color(0, 191, 255));
		btn_QLKH.setBounds(0, 0, 250, 60);
		panel_10.add(btn_QLKH);
		btn_QLKH.setHorizontalAlignment(SwingConstants.LEADING);
		btn_QLKH.setIcon(new ImageIcon("image/MenuQLNV.png"));
		btn_QLKH.addActionListener(this);

		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0, 250, 250, 60);
		panel_ChucNang.add(panel_12);
		panel_12.setLayout(null);

		btn_CaLam = new JButton("Ca Làm");
		btn_CaLam.setBackground(new Color(0, 191, 255));
		btn_CaLam.setBounds(0, 0, 250, 60);
		panel_12.add(btn_CaLam);
		btn_CaLam.setIcon(new ImageIcon("image/Actions-view-calendar-timeline-icon.png"));
		btn_CaLam.setHorizontalAlignment(SwingConstants.LEADING);
		btn_CaLam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		// listPanelDonHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTongTienInput().setText("abc");

		btn_CaLam.addActionListener(this);
		// Image img = new ImageIcon("test.png").getImage();
		Path source = Paths.get("image/MenuHelp.png");
		InputStream is = new FileInputStream(source.toFile());
		BufferedImage originalImage = ImageIO.read(is);

		ImageIcon icon = new ImageIcon("image/MenuHelp.png");

		JPanel panel_13 = new JPanel();
		panel_13.setBounds(0, 310, 250, 60);
		panel_ChucNang.add(panel_13);
		panel_13.setLayout(null);

		JButton btn_TroGiup = new JButton("Trợ giúp");
		btn_TroGiup.setBackground(new Color(0, 191, 255));
		btn_TroGiup.setBounds(0, 0, 250, 60);
		panel_13.add(btn_TroGiup);

		btn_TroGiup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				runFile.run("HD/HTML/html.html");
				
			}
		});
		btn_TroGiup.setIcon(icon);

		btn_TroGiup.setHorizontalAlignment(SwingConstants.LEADING);
		btn_TroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	 		}
		});

		JButton btn_DangXuat = new JButton("Đăng xuất");
		btn_DangXuat.setIcon(new ImageIcon("image/User-Interface-Logout-icon.png"));
		btn_DangXuat.setBounds(0, 660, 250, 50);
		panel_ChucNang.add(btn_DangXuat);

		btn_DangXuat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int b = JOptionPane.showConfirmDialog(null, "Xác nhận đăng xuất ?", "Đăng Xuất",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (b == 0) {
					dispose();
					new DangNhap().setVisible(true);
				}
			}
		});

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 190, 250, 60);
		panel_ChucNang.add(panel_11);
		panel_11.setLayout(null);

		btn_ThongKe = new JButton("Thống kê");
		btn_ThongKe.setBackground(new Color(0, 191, 255));
		btn_ThongKe.setBounds(0, 0, 250, 60);
		panel_11.add(btn_ThongKe);
		btn_ThongKe.setIcon(new ImageIcon("image/MenuTK.png"));
		btn_ThongKe.setHorizontalAlignment(SwingConstants.LEADING);

		btn_ThongKe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tabbedPane_Main.setSelectedIndex(3);
				tbModel_LSBH_Ngay.setRowCount(0);
				//				ArrayList<LichSuBanHang> listLSBH_Ngay = dao_HoaDonBanHang.getHoaDonNgay(ngayDate1,
				//						nhanVien.getTenNV());
				int stt1 = 1;
				for (LichSuBanHang lsbh : listLSBH_Ngay) {
					String[] row = { stt1 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
							lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
					tbModel_LSBH_Ngay.addRow(row);
					stt1++;
				}
				lbl_TongHDNgay.setText(tongSLHD(listLSBH_Ngay) + "");
				lbl_TongDTNgay.setText(nbFormat.format(tongDT(listLSBH_Ngay)) + "");

				//				ArrayList<LichSuBanHang> listLSBH_Thang = dao_HoaDonBanHang.getHoaDonThang(thang + "", nam,
				//						nhanVien.getTenNV());

				tbModel_LSBH_Thang.setRowCount(0);
				int stt2 = 1;
				for (LichSuBanHang lsbh : listLSBH_Thang) {
					String[] row = { stt2 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
							lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
					tbModel_LSBH_Thang.addRow(row);
					stt2++;
				}
				lbl_TongDT_Thang.setText(nbFormat.format(tongDT(listLSBH_Thang)) + "");
				lbl_TongHD_Thang.setText(tongSLHD(listLSBH_Thang) + "");

				//				ArrayList<LichSuBanHang> listLSBH_Nam = dao_HoaDonBanHang.getHoaDonNam(yearChooser_1.getYear() + "",
				//						nhanVien.getTenNV());
				tbModel_LSBH_Nam.setRowCount(0);
				int stt3 = 1;
				for (LichSuBanHang lsbh : listLSBH_Nam) {
					String[] row = { stt3 + "", lsbh.getNgay().toString(), lsbh.getMaHD(), lsbh.getTenNV(),
							lsbh.getTenKH(), lsbh.getSDT(), nbFormat.format(lsbh.getTongTienHD()) + "" };
					tbModel_LSBH_Nam.addRow(row);
					stt3++;
				}
				lbl_TongDT_Nam.setText(nbFormat.format(tongDT(listLSBH_Nam)) + "");
				lbl_TongHD_Nam.setText(tongSLHD(listLSBH_Nam) + "");
			}
		});
		btn_ThongKe.addActionListener(this);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 160, 215));
		panel_2.setBounds(0, 0, 250, 70);
		panel_ChucNang.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbl_TenNhanVien = new JLabel(nhanVien.getTenNV());
		lbl_TenNhanVien.setBackground(new Color(0, 160, 215));
		lbl_TenNhanVien.setOpaque(true);
		lbl_TenNhanVien.setBounds(0, 0, 250, 70);
		panel_2.add(lbl_TenNhanVien);
		lbl_TenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_TenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);

		lbl_TenNhanVien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lbl_TenNhanVien.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				TaiKhoan tk = new TaiKhoan();
				for (TaiKhoan tkk : new DAO_TaiKhoan().getAllTaiKhoan()) {
					if (tkk.getId().equalsIgnoreCase(nhanVien.getMaNV())) {
						tk = tkk;
						System.out.println("1");
					}
				}
				// tk.setMaNV(nhanVien);
				new Form_TT_NV(nhanVien, tk).setVisible(true);

			}
		});

		btn_DoiSize = new JButton("Đổi size, màu");
		btn_DoiSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_DoiSize.setBounds(0, 1, 245, 50);
		// panel_TacVuBH.add(btn_DoiSize);

		btn_DoiHangLoi = new JButton("Đổi hàng bị lỗi");
		btn_DoiHangLoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_DoiHangLoi.setBounds(0, 52, 245, 50);
		int a = 1;

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 70, 250, 60);
		panel_ChucNang.add(panel_5);
		panel_5.setLayout(null);

		JButton btn_BanHang = new JButton("Bán hàng");
		btn_BanHang.setBackground(new Color(255, 255, 255));
		btn_BanHang.setIcon(new ImageIcon("image/US-dollar-icon.png"));
		btn_BanHang.setBounds(0, 0, 250, 60);
		panel_5.add(btn_BanHang);
		btn_BanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_Main.setSelectedIndex(0);

			}
		});
		btn_BanHang.setHorizontalAlignment(SwingConstants.LEADING);

		ArrayList<PanelGioHang> listPanelGioHang = new ArrayList<PanelGioHang>();
		for (int i = 0; i < 5; i++) {
			listPanelGioHang.add(new PanelGioHang());
			// tabbedPane_GioHang.addTab("Giỏ " + (i + 1), listPanelDonHang.get(i));
			tabbedPane_GioHang.addTab("Giỏ " + (i + 1), new ImageIcon("image/cart.png"), listPanelGioHang.get(i));
		}

		/*-----------------------------------------------------------Load Data--------------------------------------------------------*/
		// System.out.println("0");
		listsp = dao_SanPham.getAllSanPham(); // Lấy danh sách sản phẩm trong database

		for (SanPham sanPham : listsp) {
			for(ChiTietSanPham ctsp : sanPham.getChiTietSanPham()) {
				listItem.add(new Panel_Item(ctsp)); // tạo Panel Item tương ứng cho sản phẩm và add vào danh sách panel
			}
		}

		for (Panel_Item item : listItem) {
			panel_item.add(item); // add panelitem và panel chính (panel lớn chứa nhiều panelitem)
		}

		// Tạo arraylist lưu arraylist panelitemGioHang (Arraylist lồng trong arraylist)
		ArrayList<ArrayList<PanelItemGioHang>> listArrayList = new ArrayList<ArrayList<PanelItemGioHang>>();
		for (int i = 0; i < 5; i++) {
			listArrayList.add(new ArrayList<PanelItemGioHang>());
		}

		for (Panel_Item item : listItem) {
			item.getBtnThem().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if (Integer.parseInt(item.getLblKhoData().getText()) <= 0) {
						JOptionPane.showMessageDialog(null, "Sản phẩm đã hết"); // Kiểm tra số lượng sản phẩm
					} else {

						JPanel paneldsh = listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getPanel_DSHang();
						// Lấy panel danh sách sản phẩm trong tabbedpanel giỏ hàng tương ứng

						int tbindex = tabbedPane_GioHang.getSelectedIndex(); // Số của tabbedpanel đang được chọn

						PanelItemGioHang itemTrongGioHang = new PanelItemGioHang(item.getCtsp());
						// Tạo panelItem cho sản phẩm trong giỏ hàng

						// Kiểm tra nếu sản phẩm đã có trong giỏ hàng thì tăng số lượng sản phẩm trong
						// giỏ hàng lên 1
						boolean b = false;
						for (PanelItemGioHang i : listArrayList.get(tbindex)) {
							if (i.getMau().equals(itemTrongGioHang.getMau())
									&& i.getSizeSP().equals(itemTrongGioHang.getSizeSP())
									&& i.getSp().getMaSanPham().equals(itemTrongGioHang.getSp().getMaSanPham())) {
								int sl = Integer.parseInt(i.getSpinner().getValue().toString()) + 1;
								i.getSpinner().setValue(sl);
								b = true;
								break;
							}
						}
						if (b == false) {
							listArrayList.get(tbindex).add(itemTrongGioHang);
						}

						paneldsh.add(listArrayList.get(tbindex).get(listArrayList.get(tbindex).size() - 1));
						paneldsh.repaint();
						paneldsh.revalidate();

						// thay đổi tiền * số lượng
						Locale localeVN = new Locale("vi", "VN");
						NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
						numberFormat.setCurrency(Currency.getInstance(localeVN));

						itemTrongGioHang.lbl_ThanhTien1.setText(numberFormat.format(itemTrongGioHang.getThanhTien()));

						// Xử lý thay đổi tiền
						Double tongTien = 0.0;
						for (PanelItemGioHang pi : listArrayList.get(tbindex)) {
							tongTien = tongTien + pi.getThanhTien();

						}
						listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTienHang1()
						.setText(numberFormat.format(tongTien));
						if (listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getKhachHang() != null) {
							double tile = 0.0;
							if (listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getKhachHang()
									.getLoaiKhachHang().equals("Thân thiết"))
								tile = 0.05;
							listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTienGiamData()
							.setText(numberFormat.format((tongTien * tile)));
							listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).setTienGiam(tongTien * tile);
							listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex())
							.setTongCong(tongTien - tongTien * tile);

							listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTongCongData()
							.setText(numberFormat.format(tongTien - tongTien * tile));
						}

						// Xử lý sự kiện cho icon loại sản phẩm ra khỏi giỏ hàng
						itemTrongGioHang.getPanel_deleteIcon().addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								xoa = JOptionPane.showConfirmDialog(null, "Xóa sản phẩm khỏi giỏ hàng ?",
										"Xóa sản phẩm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if (xoa == 0) {
									listArrayList.get(tbindex).remove(itemTrongGioHang);
									paneldsh.removeAll();
									paneldsh.repaint();
									paneldsh.revalidate();

									for (PanelItemGioHang b : listArrayList.get(tbindex)) {
										paneldsh.add(b);
										paneldsh.repaint();
										paneldsh.revalidate();
									}

									// Xử lý thay đổi tiền
									Double tongTien = 0.0;
									for (PanelItemGioHang pi : listArrayList.get(tbindex)) {
										tongTien = tongTien + pi.getThanhTien();
									}

									listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTienHang1()
									.setText(numberFormat.format(tongTien));
									if (listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex())
											.getKhachHang() != null) {
										double tile = 0.0;
										if (listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getKhachHang()
												.getLoaiKhachHang().equals("Thân thiết"))
											tile = 0.05;
										listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTienGiamData()
										.setText(numberFormat.format(tongTien * tile));
										listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex())
										.setTienGiam(tongTien * tile);
										listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex())
										.setTongCong(tongTien - tongTien * tile);

										listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTongCongData()
										.setText(numberFormat.format(tongTien - tongTien * tile));
									}
								}
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								itemTrongGioHang.getPanel_deleteIcon().setCursor(new Cursor(Cursor.HAND_CURSOR));
							}
						});

						// xử lý sự kiện cho sự thay đổi số lượng hàng trong giỏ hàng
						JSpinner spinner = itemTrongGioHang.getSpinner();

						spinner.addChangeListener(new ChangeListener() {

							@Override
							public void stateChanged(ChangeEvent e) {
								// TODO Auto-generated method stub
								int value = (Integer) itemTrongGioHang.getSpinner().getValue();
								if (value > item.getSp().getSoLuong(itemTrongGioHang.getMau(),
										itemTrongGioHang.getSizeSP())) {
									JOptionPane.showMessageDialog(null, "Số lượng không đủ.");
									itemTrongGioHang.getSpinner().setValue(value - 1);
								} else {

									Locale localeVN = new Locale("vi", "VN");
									NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
									numberFormat.setCurrency(Currency.getInstance(localeVN));

									// Xửa lý đổi tổng tiên tương ứng
									Double tongTien = 0.0;
									for (PanelItemGioHang pi : listArrayList.get(tbindex)) {
										// tongTien = tongTien + Double.parseDouble(pi.getLbl_ThanhTien1().getText());
										tongTien = tongTien + pi.getThanhTien();
									}
									itemTrongGioHang.getLbl_ThanhTien1()
									.setText(numberFormat.format(itemTrongGioHang.getThanhTien()));

									listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTienHang1()
									.setText(numberFormat.format(tongTien));

									if (listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex())
											.getKhachHang() != null) {
										double tile = 0.0;
										if (listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getKhachHang()
												.getLoaiKhachHang().equals("Thân thiết"))
											tile = 0.05;
										listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTienGiamData()
										.setText(numberFormat.format((tongTien * tile)));
										listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex())
										.setTienGiam(tongTien * tile);
										listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex())
										.setTongCong(tongTien - tongTien * tile);

										listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex()).getLblTongCongData()
										.setText(numberFormat.format(tongTien - tongTien * tile));
									}
								}

							}

						});

					}

				}
			});

			item.getBtnXemChiTiet().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// new FormTTSP(item.getSp()).setVisible(true);
				}
			});

		}
		btn_QLKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_QLKH.setBackground(Color.WHITE);
				btn_BanHang.setBackground(new Color(0,191,255));			
				btn_CaLam.setBackground(new Color(0,191,255));
				btn_ThongKe.setBackground(new Color(0,191,255));
				btn_TroGiup.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btn_QLKH.getBackground().equals(new Color(0,191,255))) {
					btn_QLKH.setBackground(new Color(30,144,255));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btn_QLKH.getBackground().equals(new Color(30,144,255))) {
					btn_QLKH.setBackground(new Color(0,191,255));
				}
			}
		});
		btn_BanHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_BanHang.setBackground(Color.WHITE);
				btn_QLKH.setBackground(new Color(0,191,255));
				btn_CaLam.setBackground(new Color(0,191,255));
				btn_ThongKe.setBackground(new Color(0,191,255));
				btn_TroGiup.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btn_BanHang.getBackground().equals(new Color(0,191,255))) {
					btn_BanHang.setBackground(new Color(30,144,255));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btn_BanHang.getBackground().equals(new Color(30,144,255))) {
					btn_BanHang.setBackground(new Color(0,191,255));
				}
			}
		});
		btn_CaLam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_BanHang.setBackground(new Color(0,191,255));
				btn_QLKH.setBackground(new Color(0,191,255));
				btn_CaLam.setBackground(Color.WHITE);
				btn_ThongKe.setBackground(new Color(0,191,255));
				btn_TroGiup.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btn_CaLam.getBackground().equals(new Color(0,191,255))) {
					btn_CaLam.setBackground(new Color(30,144,255));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btn_CaLam.getBackground().equals(new Color(30,144,255))) {
					btn_CaLam.setBackground(new Color(0,191,255));
				}
			}
		});
		btn_ThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_BanHang.setBackground(new Color(0,191,255));
				btn_QLKH.setBackground(new Color(0,191,255));
				btn_CaLam.setBackground(new Color(0,191,255));
				btn_ThongKe.setBackground(Color.WHITE);
				btn_TroGiup.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btn_ThongKe.getBackground().equals(new Color(0,191,255))) {
					btn_ThongKe.setBackground(new Color(30,144,255));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btn_ThongKe.getBackground().equals(new Color(30,144,255))) {
					btn_ThongKe.setBackground(new Color(0,191,255));
				}
			}
		});
		btn_TroGiup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_BanHang.setBackground(new Color(0,191,255));
				btn_QLKH.setBackground(new Color(0,191,255));
				btn_CaLam.setBackground(new Color(0,191,255));
				btn_ThongKe.setBackground(new Color(0,191,255));
				btn_TroGiup.setBackground(Color.WHITE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btn_TroGiup.getBackground().equals(new Color(0,191,255))) {
					btn_TroGiup.setBackground(new Color(30,144,255));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btn_TroGiup.getBackground().equals(new Color(30,144,255))) {
					btn_TroGiup.setBackground(new Color(0,191,255));
				}
			}
		});
		// Xử lý sự kiện thanh toán
		for (PanelGioHang lGioHang : listPanelGioHang) {
			lGioHang.getBtnThanhToan().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// listPanelGioHang.get(tabbedPane_GioHang.getSelectedIndex());
					if (listArrayList.get(tabbedPane_GioHang.getSelectedIndex()).size() == 0) {
						JOptionPane.showMessageDialog(null, "Chưa có sản phẩm");
					} else if (lGioHang.getKhachHang() == null) {
						JOptionPane.showMessageDialog(null, "Chưa có khách hàng");
					} else if (!tinhTienTraLai(lGioHang)) {
						//JOptionPane.showMessageDialog(null, "Tiền khách trả chưa hợp lệ");
						JOptionPane.showMessageDialog(null, "Tiền khách trả chưa hợp lệ"
								+ "\nGợi ý: Số tiền phải lớn hơn tổng tiền các sản phẩm )",
							      "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						int xacNhan = JOptionPane.showConfirmDialog(null, "Xác nhận thanh toán ?", "thanh toán ?",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (xacNhan == 0) {
							try {

								int slHD = dao_HoaDonBanHang.getTongHoaDon();
								String maHD = "HD" + String.format("%04d", slHD + 1);
								TaoHoaDonPDF taoHoaDonPDF = new TaoHoaDonPDF(lGioHang, nhanVien,
										listArrayList.get(tabbedPane_GioHang.getSelectedIndex()), maHD);
								dao_SanPham.getAllSanPham();
								ArrayList<SanPham> listSPMoi = dao_SanPham.getAllSanPham();

								int i = 0;
								for (SanPham sp : listSPMoi) {
									for(ChiTietSanPham cTietSanPham : sp.getChiTietSanPham()) {
										listItem.get(i).setCtsp(cTietSanPham);
										i++;
									}
								}

								panel_item.removeAll();
								panel_item.repaint();
								panel_item.revalidate();
								for (Panel_Item item : listItem) {

									panel_item.add(item); // add panelitem và panel chính (panel lớn chứa nhiều
									// panelitem)
									panel_item.repaint();
									panel_item.revalidate();
								}

								listArrayList.get(tabbedPane_GioHang.getSelectedIndex())
								.removeAll(listArrayList.get(tabbedPane_GioHang.getSelectedIndex()));
								lGioHang.getPanel_DSHang().removeAll();
								lGioHang.getPanel_DSHang().repaint();
								lGioHang.getPanel_DSHang().revalidate();
								lGioHang.xoaBang();

								//	JOptionPane.showMessageDialog(null, "Thanh toán thành công, Mã hóa đơn: " + maHD);

								new DialogHoaDon("Thanh toán thành công, Mã hóa đơn: " + maHD,
										"hoa don/" + maHD + ".pdf").setVisible(true);
								;
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}

				}
			});

			lGioHang.getBtnThem().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					String sdt = lGioHang.gettF_SDT().getText();
					ArrayList<KhachHang> listKH = dao_KhachHang.getAllKhachHang();
					boolean b = false;
					for (KhachHang kh : listKH) {
						if (kh.getSoDienThoai().equals(sdt)) {
							//							lGioHang.getLblMaKH_1().setText(kh.getMaKhachHang());
							//							lGioHang.getLblTen_1().setText(kh.getHoTenKhachHang());
							//							lGioHang.getLbl_SDT_1().setText(kh.getSoDienThoai());
							//							lGioHang.getLbl_LoaiKH_1().setText(kh.getLoaiKhachHang());
							lGioHang.setKhachHang(kh);
							b = true;
							break;
						}
					}
					if (!b) {
						int a = JOptionPane.showConfirmDialog(null, "Không tìm thấy KH Bạn có muốn thêm khách hàng?",
								"Không tìm thấy", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (a == 0) {
							FormThemKH formThemKH = new FormThemKH();
							String maKH = "KH" + String.format("%04d", listKH.size() + 1) + "";
							formThemKH.textField.setText(maKH);
							formThemKH.textField.setEditable(false);
							formThemKH.getBtn_XacNhan().addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									if (formThemKH.ktSDT() && formThemKH.ktTenKH()) {
										String maKH = "KH" + String.format("%04d", listKH.size() + 1) + "";
										String loaiKH = "Khách thường";
										String tenKH = formThemKH.getTf_TenKH().getText();
										String sdt = formThemKH.getTf_SDT().getText();
										KhachHang khachHang = new KhachHang(maKH, tenKH, sdt, loaiKH);
										dao_KhachHang.createKH(khachHang);
										lGioHang.setKhachHang(khachHang);
										JOptionPane.showMessageDialog(null, "Thêm thành công.");
										formThemKH.dispose();
									}
								}
							});
							formThemKH.setVisible(true);
						}
					}
					if (lGioHang.getKhachHang() != null) {
						Double tongTien = 0.0;
						for (PanelItemGioHang pi : listArrayList.get(tabbedPane_GioHang.getSelectedIndex())) {
							// tongTien = tongTien + Double.parseDouble(pi.getLbl_ThanhTien1().getText());
							tongTien = tongTien + pi.getThanhTien();
						}
						Locale localeVN = new Locale("vi", "VN");
						NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
						numberFormat.setCurrency(Currency.getInstance(localeVN));

						lGioHang.getLblTienHang1().setText(numberFormat.format(tongTien));

						double tile = 0.0;
						if (lGioHang.getKhachHang().getLoaiKhachHang().equals("Thân thiết"))
							tile = 0.05;
						lGioHang.getLblTienGiamData().setText(numberFormat.format((tongTien * tile)));
						lGioHang.setTienGiam((tongTien * tile));

						lGioHang.setTongCong(tongTien - tongTien * tile);
						// Tính tổng tiền
						lGioHang.getLblTongCongData().setText(numberFormat.format(tongTien - tongTien * tile));

					}
				}
			});

			lGioHang.getTf_TienKhachDua().getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					if (lGioHang.getKhachHang() != null) {
						tinhTienTraLai(lGioHang);
					}
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					if (lGioHang.getKhachHang() != null) {
						tinhTienTraLai(lGioHang);
					}
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					if (lGioHang.getKhachHang() != null) {
						tinhTienTraLai(lGioHang);
					}
				}
			});
		}

		tf_TKHK.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String std = tf_TKHK.getText();
				ArrayList<KhachHang> listKH = dao_KhachHang.timSDT(std);
				tbModelKH.setRowCount(0);
				for (KhachHang khachHang : listKH) {

					String[] st = { khachHang.getMaKhachHang(), khachHang.getHoTenKhachHang(),
							khachHang.getSoDienThoai(), khachHang.getLoaiKhachHang(),
							dao_KhachHang.getTongTienDaMua(khachHang.getMaKhachHang()) + "" };
					tbModelKH.addRow(st);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String std = tf_TKHK.getText();
				ArrayList<KhachHang> listKH = dao_KhachHang.timSDT(std);
				tbModelKH.setRowCount(0);
				for (KhachHang khachHang : listKH) {

					String[] st = { khachHang.getMaKhachHang(), khachHang.getHoTenKhachHang(),
							khachHang.getSoDienThoai(), khachHang.getLoaiKhachHang(),
							dao_KhachHang.getTongTienDaMua(khachHang.getMaKhachHang()) + "" };
					tbModelKH.addRow(st);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String std = tf_TKHK.getText();
				ArrayList<KhachHang> listKH = dao_KhachHang.timSDT(std);
				tbModelKH.setRowCount(0);
				for (KhachHang khachHang : listKH) {

					String[] st = { khachHang.getMaKhachHang(), khachHang.getHoTenKhachHang(),
							khachHang.getSoDienThoai(), khachHang.getLoaiKhachHang(),
							dao_KhachHang.getTongTienDaMua(khachHang.getMaKhachHang()) + "" };
					tbModelKH.addRow(st);
				}
			}
		});

		btn_CNTTKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (table_KH.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng.");
				} else {
					int row = table_KH.getSelectedRow();
					String maKH = table_KH.getModel().getValueAt(row, 0).toString();

					KhachHang khachHang = dao_KhachHang.getKhachHang(maKH);
					FormCNTTKH formCNTTKH = new FormCNTTKH(khachHang);
					formCNTTKH.getBtn_Luu().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							int a = JOptionPane.showConfirmDialog(null, "Xác Nhận lưu ?", "lưu ?",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (a == 0) {
								if(formCNTTKH.ktTenKH()&&formCNTTKH.ktSDT()) {
									khachHang.setHoTenKhachHang(formCNTTKH.getTf_TenKH().getText());
									khachHang.setSoDienThoai(formCNTTKH.getTf_SDT().getText());
									new DAO_KhachHang().updateKH(khachHang);

									tbModelKH.setRowCount(0);
									ArrayList<KhachHang> listKH = dao_KhachHang.getAllKhachHang();
									for (KhachHang khachHang1 : listKH) {

										String[] st = { khachHang1.getMaKhachHang(), khachHang1.getHoTenKhachHang(),
												khachHang1.getSoDienThoai(), khachHang1.getLoaiKhachHang(),
												nbFormat.format(dao_KhachHang.getTongTienDaMua(khachHang1.getMaKhachHang()))
												+ "" };
										tbModelKH.addRow(st);
									}
									JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								}

							}
							formCNTTKH.dispose();
							
						}
					});

					formCNTTKH.setVisible(true);
				}

			}
		});

		btn_locKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String loaiKH = cbb_LocKH.getSelectedItem().toString();
				ArrayList<KhachHang> listKH = dao_KhachHang.getAllKhachHang();
				if (loaiKH.equals("Thân thiết") || loaiKH.equals("Khách thường")) {
					tbModelKH.setRowCount(0);
					for (KhachHang khachHang : listKH) {
						if (khachHang.getLoaiKhachHang().equals(loaiKH)) {

							String[] st = { khachHang.getMaKhachHang(), khachHang.getHoTenKhachHang(),
									khachHang.getSoDienThoai(), khachHang.getLoaiKhachHang(),
									dao_KhachHang.getTongTienDaMua(khachHang.getMaKhachHang()) + "" };
							tbModelKH.addRow(st);
						}
					}
				} else {
					tbModelKH.setRowCount(0);
					for (KhachHang khachHang : listKH) {
						String[] st = { khachHang.getMaKhachHang(), khachHang.getHoTenKhachHang(),
								khachHang.getSoDienThoai(), khachHang.getLoaiKhachHang(),
								dao_KhachHang.getTongTienDaMua(khachHang.getMaKhachHang()) + "" };
						tbModelKH.addRow(st);
					}
				}
			}
		});

		textField_TimKiem.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				timKiemSP();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				timKiemSP();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				timKiemSP();
			}
		});
		btn_DoiSize.addActionListener(this);
	}

	public void timKiemSP() {
		String ma = textField_TimKiem.getText();
		panel_item.removeAll();
		boolean b = false;
		for (Panel_Item item : listItem) {
			// add panelitem và panel chính (panel lớn chứa nhiều panelitem)
			if (item.getCtsp().getMaChiTietSanPham().contains(ma)) {
				panel_item.add(item);
				panel_item.repaint();
				panel_item.revalidate();
				b = true;
			}
			if (!b) {
				panel_item.removeAll();
				panel_item.repaint();
				panel_item.revalidate();
			}
		}
	}

	public boolean tinhTienTraLai(PanelGioHang p) {
		if (!isDouble(p.getTf_TienKhachDua())) {
			p.getLblTienTraLaiKhach_1().setText("Số tiền không hợp lệ");
			p.getLblTienTraLaiKhach_1().setForeground(Color.RED);
			return false;
		} else if (Double.parseDouble(p.getTf_TienKhachDua().getText()) < p.getTongCong()) {
			p.getLblTienTraLaiKhach_1().setText("Chưa đủ tiền");
			p.getLblTienTraLaiKhach_1().setForeground(Color.RED);
			return false;
		} else {
			Locale localeVN = new Locale("vi", "VN");
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
			numberFormat.setCurrency(Currency.getInstance(localeVN));
			p.getLblTienTraLaiKhach_1().setForeground(Color.BLACK);
			Double tienKhachDua = Double.parseDouble(p.getTf_TienKhachDua().getText());
			Double tongCong = p.getTongCong();
			p.getLblTienTraLaiKhach_1().setText(numberFormat.format(tienKhachDua - tongCong));
			return true;
		}

	}

	public int tongSLHD(ArrayList<LichSuBanHang> lSBH) {
		return lSBH.size();
	}

	public double tongDT(ArrayList<LichSuBanHang> lSBH) {
		double t = 0.0;
		for (LichSuBanHang lichSuBanHang : lSBH) {
			t += lichSuBanHang.getTongTienHD();
		}
		return t;
	}

	public boolean isDouble(JTextField tf) {
		try {
			Double.parseDouble(tf.getText());
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btn_CaLam)) {
			tabbedPane_Main.setSelectedIndex(2);
		}
		if (e.getSource().equals(btn_DoiSize)) {

		}
		//		if (e.getSource().equals(btn_BanHang)) {
		//			tabbed_TacVu.setSelectedIndex(0);
		//			tabbedPane_Main.setSelectedIndex(0);
		//		}
		if (e.getSource().equals(btn_QLKH)) {
			tabbedPane_Main.setSelectedIndex(1);
		}
	}
	public class runFile {
	    public static void run(String path) {
	        String command = "cmd /c start " + path;
	        try {
	            Runtime rt = Runtime.getRuntime();
	            Process pr = rt.exec(command);
	        } catch (IOException ex) {
	            Logger.getLogger(runFile.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	}
}
