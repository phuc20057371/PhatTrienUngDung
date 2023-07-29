package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.DefaultCellEditor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;


import database.ConnectDB;
import dao.DAO_CaLam;
import dao.DAO_ChatLieu;
import dao.DAO_HoaDonBanHang;
import dao.DAO_NhaCungCap;
import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;
import dao.DAO_ThuongHieu;
import dao.DAO_XuatXu;
import dao.Dao_SanPham;
import entity.CaLam;
import entity.ChatLieu;
import entity.ChiTietSanPham;
import entity.HoaDonBanHang;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.SanPham;
import entity.TaiKhoan;
import entity.ThuongHieu;
import entity.XuatXu;

import com.toedter.calendar.JYearChooser;

import ae.java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.EtchedBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.calendar.JMonthChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.UIManager;
public class Form_TrangChu_QuanLi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_MaSP;
	private JTextField text_TenSP;
	private JTextField text_MaNV;
	private JTextField txt_TenNV;
	private JTextField text_SdtNV;
	private JTextField txtMaNCC;
	private JTextField txtTenMCC;
	private JTextField txtSdtNCC;
	private JTextField txtMa_TK_NV_Ngay;
	private JTextField txtTen_TK_NV_Ngay;
	private JTextField textMa_TK_NV_Thang;
	private JTextField textTen_TK_NV_Thang;
	private JTextField textMa_TK_NV_Nam;
	private JTextField textTen_TK_NV_Nam;
	JTable table_NV;
	DefaultTableModel modelDsNV;

	DefaultTableModel modelCalam;
	JTable tableCalam;
	JComboBox cbbSang;

	JTable tableNCC;
	DefaultTableModel modelNCC;

	JTable tableTatCaSP;
	DefaultTableModel model1SP;

	JTable tableSapHetSP;
	DefaultTableModel model2SP;

	JTable tableLoiSP;
	DefaultTableModel model3SP;

	JTable tableNgayTKHD;	
	JTable table_NV_TKHD_Ngay;
	DefaultTableModel modelnTKHD;
	/**
	 * Launch the application.
	 */
	DAO_NhaCungCap dao_NCC = new DAO_NhaCungCap();
	DAO_NhanVien dao_NV = new DAO_NhanVien();
	DAO_CaLam dao_Calam = new DAO_CaLam();
	Dao_SanPham dao_SP = new Dao_SanPham();
	DAO_HoaDonBanHang dao_HD = new DAO_HoaDonBanHang();
	DAO_XuatXu dao_XX = new DAO_XuatXu();
	DAO_ThuongHieu dao_TH = new DAO_ThuongHieu();
	DAO_ChatLieu dao_CL = new DAO_ChatLieu();
	DAO_TaiKhoan dao_TK = new DAO_TaiKhoan();

	LocalDate currentDate = java.time.LocalDate.now();
	Locale localeVN = new Locale("vi", "VN");
	NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	private JTable table_TK_NV_Thang;
	private JTable table_TK_NV_Nam;
	private JTable table_TK_HD_Nam;
	private JTable table_TK_HD_Nam_2;
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					NhanVien nv = new NhanVien("NV0001","Hồ Ngọc Thủy Ly","0909090909","Q.Gò Vấp,Tp.HCM"
	//							,"Quản lí","Nam",new Date(2002,8,2),new Date(2002,8,2));        
	//					Form_TrangChu_QuanLi frame = new Form_TrangChu_QuanLi(nv);
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public Form_TrangChu_QuanLi(NhanVien nv) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(currentDate);
		setTitle("Trang chủ quản lí - "+nv.getTenNV()+" - "+nv.getMaNV());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1330, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel panelContent = new JPanel();
		panelContent.setBounds(0, 0, 1316, 720);
		contentPane.add(panelContent);
		panelContent.setLayout(null);

		JPanel panel_Cover = new JPanel();
		panel_Cover.setBackground(new Color(0, 160, 215));
		panel_Cover.setBounds(241, 2, 1075, 33);
		panelContent.add(panel_Cover);
		panel_Cover.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setBackground(new Color(0, 160, 215));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_Cover.add(lblNewLabel_2);

		JPanel panel_Control = new JPanel();
		panel_Control.setBackground(new Color(155, 231, 255));
		panel_Control.setBorder(null);
		panel_Control.setBounds(0, 0, 242, 710);
		panelContent.add(panel_Control);
		panel_Control.setLayout(null);

		JPanel panel_Menu = new JPanel();
		panel_Menu.setBounds(0, 0, 242, 370);
		panel_Control.add(panel_Menu);
		panel_Menu.setLayout(null);

		JPanel panel_TT_NV = new JPanel();
		panel_TT_NV.setBackground(new Color(0, 160, 215));
		panel_TT_NV.setBounds(0, 2, 242, 70);
		panel_TT_NV.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Menu.add(panel_TT_NV);
		panel_TT_NV.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lbl_TT_NV = new JLabel(nv.getTenNV());
		lbl_TT_NV.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lbl_TT_NV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_TT_NV.setIcon(new ImageIcon("image/UsersName.png"));
		lbl_TT_NV.setHorizontalAlignment(SwingConstants.CENTER);
		panel_TT_NV.add(lbl_TT_NV);

		JPanel panel_M_QLSP = new JPanel();
		panel_M_QLSP.setBounds(0, 70, 242, 60);
		panel_M_QLSP.setBorder(null);
		panel_M_QLSP.setBackground(new Color(255, 255, 255));
		panel_Menu.add(panel_M_QLSP);
		panel_M_QLSP.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btn_M_QLSP = new JButton("Quản lí sản phẩm");	
		btn_M_QLSP.setBackground(new Color(255, 255, 255));
		btn_M_QLSP.setIcon(new ImageIcon("image/MenuQLSP.png"));
		btn_M_QLSP.setHorizontalAlignment(SwingConstants.LEADING);
		panel_M_QLSP.add(btn_M_QLSP);
		btn_M_QLSP.setMnemonic(KeyEvent.VK_F1);


		JPanel panelmnQLNV = new JPanel();
		panelmnQLNV.setBounds(0, 130, 242, 60);
		panelmnQLNV.setBorder(null);
		panelmnQLNV.setBackground(new Color(0, 191, 255));
		panel_Menu.add(panelmnQLNV);
		panelmnQLNV.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnmnQLNV = new JButton("Quản lí nhân viên");
		btnmnQLNV.setBackground(new Color(0, 191, 255));
		btnmnQLNV.setIcon(new ImageIcon("image/MenuQLNV.png"));
		btnmnQLNV.setHorizontalAlignment(SwingConstants.LEADING);
		panelmnQLNV.add(btnmnQLNV);

		JPanel panelmnQLNCC = new JPanel();
		panelmnQLNCC.setBounds(0, 190, 242, 60);
		panelmnQLNCC.setBorder(null);
		panelmnQLNCC.setBackground(new Color(0, 191, 255));
		panel_Menu.add(panelmnQLNCC);
		panelmnQLNCC.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnmnQLNCC = new JButton("Quản lí nhà cung cấp");
		btnmnQLNCC.setBackground(new Color(0, 191, 255));
		btnmnQLNCC.setIcon(new ImageIcon("image/MenuNCC.png"));
		btnmnQLNCC.setHorizontalAlignment(SwingConstants.LEADING);
		panelmnQLNCC.add(btnmnQLNCC);

		JPanel panelmnTK = new JPanel();
		panelmnTK.setBounds(0, 250, 242, 60);
		panelmnTK.setBorder(null);
		panelmnTK.setBackground(new Color(0, 191, 255));
		panel_Menu.add(panelmnTK);
		panelmnTK.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnmnTK = new JButton("Thống kê");
		btnmnTK.setBackground(new Color(0, 191, 255));
		btnmnTK.setIcon(new ImageIcon("image/MenuTK.png"));
		btnmnTK.setHorizontalAlignment(SwingConstants.LEADING);
		panelmnTK.add(btnmnTK);

		JPanel panelmnGD = new JPanel();
		panelmnGD.setBounds(0, 310, 242, 60);
		panelmnGD.setBorder(null);
		panelmnGD.setBackground(new Color(0, 191, 255));
		panel_Menu.add(panelmnGD);
		panelmnGD.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnmnGD = new JButton("Giúp đỡ");
		btnmnGD.setBackground(new Color(0, 191, 255));
		btnmnGD.setIcon(new ImageIcon("image/MenuHelp.png"));
		btnmnGD.setHorizontalAlignment(SwingConstants.LEADING);
		panelmnGD.add(btnmnGD);

		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon("image/User-Interface-Logout-icon.png"));
		btnDangXuat.setBounds(0, 651, 242, 32);
		panel_Control.add(btnDangXuat);

		JTabbedPane tab_Main = new JTabbedPane(JTabbedPane.TOP);
		tab_Main.setBounds(241, 10, 1075, 677);
		panelContent.add(tab_Main);
		//// Quản lí sản phẩm		
		JPanel panel_QLSP = new JPanel();
		panel_QLSP.setBackground(new Color(255, 255, 255));
		tab_Main.addTab("New tab", null, panel_QLSP, null);
		panel_QLSP.setLayout(null);

		JTabbedPane tab_SP = new JTabbedPane(JTabbedPane.TOP);
		tab_SP.setBounds(0, 155, 1083, 494);
		panel_QLSP.add(tab_SP);
		//Trang tất cả sản phẩm		
		JPanel panel_SP_TatCa = new JPanel();
		tab_SP.addTab("Tất cả sản phẩm", null, panel_SP_TatCa, null);
		//Table trang 1	

		tableTatCaSP = new JTable();	
		String []header1SP = "Mã sản phẩm;Tên sản phẩm;Thương hiệu;Xuất xứ;Chất liệu;Giới tính;Loại;Giá gốc;Tình trạng".split(";");		
		model1SP = new DefaultTableModel(header1SP,0);

		JScrollPane scroll1;
		scroll1 = new JScrollPane();
		scroll1.setBorder(null);
		scroll1.setBounds(0, 64, 1068, 396);
		scroll1.setViewportView(tableTatCaSP = new JTable(model1SP));
		tableTatCaSP.setRowHeight(25);
		tableTatCaSP.setAutoCreateRowSorter(true);
		tableTatCaSP.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableTatCaSP.setLayout(null);
		tableTatCaSP.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableTatCaSP.getColumnModel().getColumn(1).setPreferredWidth(250);
		tableTatCaSP.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableTatCaSP.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableTatCaSP.getColumnModel().getColumn(4).setPreferredWidth(100);
		panel_SP_TatCa.setLayout(null);

		ArrayList<SanPham> listSP = dao_SP.getAllSanPhamV2();
		loadDataQLSP1(model1SP,listSP);
		panel_SP_TatCa.add(scroll1);

		JLabel lblTH = new JLabel("Thương hiệu:");
		lblTH.setBounds(10, 10, 111, 23);
		panel_SP_TatCa.add(lblTH);
		lblTH.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox comboBoxTH = new JComboBox();
		comboBoxTH.addItem("Tất cả");
		ArrayList<ThuongHieu> dsTH = new ArrayList<ThuongHieu>();
		dsTH=dao_TH.getAllThuongHieu();
		for(ThuongHieu th:dsTH) {
			comboBoxTH.addItem(th.getTenTH());
		}		

		comboBoxTH.setBounds(117, 10, 175, 21);
		panel_SP_TatCa.add(comboBoxTH);

		JLabel lblXX = new JLabel("Xuất xứ:");
		lblXX.setBounds(344, 10, 79, 23);
		panel_SP_TatCa.add(lblXX);
		lblXX.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox comboBoxXX = new JComboBox();
		comboBoxXX.addItem("Tất cả");
		ArrayList<XuatXu> dsXX = new ArrayList<XuatXu>();
		dsXX=dao_XX.getAllXuatXu();
		for(XuatXu xx:dsXX) {
			comboBoxXX.addItem(xx.getTenXX());
		}



		comboBoxXX.setBounds(433, 10, 181, 21);
		panel_SP_TatCa.add(comboBoxXX);

		JLabel lblCL = new JLabel("Chất liệu:");
		lblCL.setBounds(624, 10, 67, 23);
		panel_SP_TatCa.add(lblCL);
		lblCL.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox comboBoxCL = new JComboBox();
		comboBoxCL.addItem("Tất cả");
		ArrayList<ChatLieu> dsCL = new ArrayList<ChatLieu>();
		dsCL=dao_CL.getAllChatLieu();
		for(ChatLieu cl:dsCL) {
			comboBoxCL.addItem(cl.getTenCL());
		}

		comboBoxCL.setBounds(701, 10, 122, 21);
		panel_SP_TatCa.add(comboBoxCL);
		
		JLabel lblTnhTrng = new JLabel("Trạng thái:");
		lblTnhTrng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnhTrng.setBounds(844, 10, 79, 23);
		panel_SP_TatCa.add(lblTnhTrng);
		
		String tt[]= {"Tất cả","Còn bán","Ngừng bán"};
		JComboBox comboBoxTT = new JComboBox(tt);
		comboBoxTT.setBounds(933, 10, 122, 21);
		panel_SP_TatCa.add(comboBoxTT);

		//Trang sản phẩm sắp hết		
		JPanel panel_SP_SizeMau = new JPanel();
		tab_SP.addTab("Size-Màu Sản phẩm", null, panel_SP_SizeMau, null);
		//Table trang 2
		tableSapHetSP = new JTable();	
		String []header2SP = "Mã sản phẩm;Mã chi tiết;Tên sản phẩm;Màu;Size;Số lượng;Loại;Nhà cung cấp".split(";");

		model2SP = new DefaultTableModel(header2SP,0);

		JScrollPane scroll2;
		scroll2 = new JScrollPane();
		scroll2.setBorder(null);
		scroll2.setBounds(0, 45, 1068, 415);
		scroll2.setViewportView(tableSapHetSP = new JTable(model2SP));
		tableSapHetSP.setRowHeight(25);
		tableSapHetSP.setAutoCreateRowSorter(true);
		tableSapHetSP.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableSapHetSP.setLayout(null);

		tableSapHetSP.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableSapHetSP.getColumnModel().getColumn(1).setPreferredWidth(90);
		tableSapHetSP.getColumnModel().getColumn(2).setPreferredWidth(300);
		tableSapHetSP.getColumnModel().getColumn(7).setPreferredWidth(200);
		panel_SP_SizeMau.setLayout(null);

		loadDataQLSP2(model2SP,listSP);
		panel_SP_SizeMau.add(scroll2);
		
		String sh[]= {"Tất cả","Sắp hết (Số lượng <50)"};
		JComboBox comboBoxSPSH = new JComboBox(sh);
		comboBoxSPSH.setBounds(878, 11, 175, 20);
		panel_SP_SizeMau.add(comboBoxSPSH);
		
				JButton btn_XuatFile = new JButton("Xuất file");
				btn_XuatFile.setBounds(753, 11, 85, 20);
				panel_SP_SizeMau.add(btn_XuatFile);
				btn_XuatFile.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						JFileChooser excel = new JFileChooser();FileOutputStream excelFileOut = null;
						excel.setDialogTitle("Save As");
						FileNameExtensionFilter fn = new FileNameExtensionFilter("EXCEL FILES", "xls","xlsx","xlsm");
						excel.setFileFilter(fn);
						int excelChooser = excel.showSaveDialog(null);
						BufferedOutputStream excelBuffOut = null;
						XSSFWorkbook sx = new XSSFWorkbook();
						XSSFSheet shet = sx.createSheet("JTable Sheet");
						XSSFRow row = null;
						XSSFCell cell = null;

						row = shet.createRow(0);
						cell = row.createCell(6);
						cell.setCellValue("DANH SÁCH SẢN PHẨM TẠI CỬA HÀNG");

						XSSFFont font = shet.getWorkbook().createFont();
						font.setFontName("Times New Roman");
						CellStyle cellstyle = shet.getWorkbook().createCellStyle();
						font.setBold(true);
						font.setFontHeightInPoints((short)14);
						font.setColor(IndexedColors.RED.getIndex());
						cellstyle.setFont(font);
						cell.setCellStyle(cellstyle);


						if (excelChooser == JFileChooser.APPROVE_OPTION) {
							try {
								XSSFFont ont = shet.getWorkbook().createFont();
								ont.setFontName("Times New Roman");
								CellStyle ce = shet.getWorkbook().createCellStyle();
								ont.setBold(true);
								ont.setFontHeightInPoints((short)14);
								ont.setColor(IndexedColors.BLACK.getIndex());
								ce.setFont(ont);

								row = shet.createRow(2);
								Cell cell1 = row.createCell(4);
								cell1.setCellValue("MÃ SẢN PHẨM");
								cell1.setCellStyle(ce);

								Cell cell2 = row.createCell(5);
								cell2.setCellValue("MÃ CHI TIẾT SẢN PHẨM");
								cell2.setCellStyle(ce);

								Cell cell3 = row.createCell(6);
								cell3.setCellValue("TÊN SẢN PHẨM");
								cell3.setCellStyle(ce);

								Cell cell4 = row.createCell(7);
								cell4.setCellValue("MÀU");
								cell4.setCellStyle(ce);

								Cell cell5 = row.createCell(8);
								cell5.setCellValue("SIZE");
								cell5.setCellStyle(ce);

								Cell cell6 = row.createCell(9);
								cell6.setCellValue("SỐ LƯỢNG");
								cell6.setCellStyle(ce);

								Cell cell7 = row.createCell(10);
								cell7.setCellValue("LOẠI");
								cell7.setCellStyle(ce);

								Cell cell8 = row.createCell(11);
								cell8.setCellValue("NHÀ CUNG CẤP");
								cell8.setCellStyle(ce);

//								Cell cell9 = row.createCell(12);
//								cell9.setCellValue("TÌNH TRẠNG");
								//cell9.setCellStyle(ce);

								for (int i = 0; i<model2SP.getRowCount();i++) {
									shet.setColumnWidth(i+4, 35*250);;
								}

								for (int i = 0 ;i < model2SP.getRowCount();i++) {
									row = shet.createRow(i+4);
									for (int j = 0;j<model2SP.getColumnCount();j++) {
										cell = row.createCell(j+4);
										cell.setCellValue(model2SP.getValueAt(i, j).toString());
										XSSFFont f = shet.getWorkbook().createFont();
										f.setFontName("Times New Roman");
										f.setFontHeightInPoints((short)12);
										CellStyle cs = shet.getWorkbook().createCellStyle();
										cs.setFont(f);
										cell.setCellStyle(cs);
									}
								}

								excelFileOut = new FileOutputStream(excel.getSelectedFile() +".xlsx");
								excelBuffOut  = new BufferedOutputStream(excelFileOut);
								sx.write(excelBuffOut);
								JOptionPane.showMessageDialog(null, "Export Excel Sucess");
							}catch(FileNotFoundException fe) {
								fe.printStackTrace();
							}catch(IOException ex) {
								ex.printStackTrace();
							}finally {
								try {
									if(excelBuffOut != null) {
										excelBuffOut.close();
									}
									if(excelFileOut != null) {
										excelFileOut.close();
									}

									if(sx != null) {
										sx.close();
									}
								}catch (IOException eo) {
									// TODO: handle exception
									eo.printStackTrace();
								}
							}
							
						}
					}
				});

		//Trang sản phẩm lỗi


		JLabel lbl_Title_QLSP = new JLabel("Quản lí sản phẩm");
		lbl_Title_QLSP.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbl_Title_QLSP.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title_QLSP.setBounds(0, 35, 1070, 35);
		panel_QLSP.add(lbl_Title_QLSP);

		JLabel lbl_MaSP = new JLabel("Mã sản phẩm:");
		lbl_MaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_MaSP.setBounds(10, 80, 111, 23);
		panel_QLSP.add(lbl_MaSP);

		text_MaSP = new JTextField();
		text_MaSP.setOpaque(false);
		text_MaSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_MaSP.setBounds(130, 80, 256, 23);
		panel_QLSP.add(text_MaSP);
		text_MaSP.setColumns(10);

		JLabel lbl_TenSP = new JLabel("Tên sản phẩm:");
		lbl_TenSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_TenSP.setBounds(396, 80, 117, 23);
		panel_QLSP.add(lbl_TenSP);

		text_TenSP = new JTextField();
		text_TenSP.setOpaque(false);
		text_TenSP.setColumns(10);
		text_TenSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_TenSP.setBounds(523, 82, 256, 23);
		panel_QLSP.add(text_TenSP);

		JLabel lbl_LoaiSP = new JLabel("Loại:");
		lbl_LoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_LoaiSP.setBounds(852, 80, 61, 23);
		panel_QLSP.add(lbl_LoaiSP);


		ArrayList<String> dsLoai = new ArrayList<String>();
		for(SanPham sp: listSP) {
			if(!(dsLoai.contains(sp.getLoai()))) {
				dsLoai.add(sp.getLoai());
			}

		}

		String[] dsTenLoaiStr = new String[dsLoai.size()];
		dsTenLoaiStr[0]= "Tất cả";
		for(int i =1;i< dsTenLoaiStr.length;i++) {
			dsTenLoaiStr[i]= dsLoai.get(i);
		}

		JComboBox comboBox_LoaiSP = new JComboBox(dsTenLoaiStr);

		comboBox_LoaiSP.setBounds(923, 82, 89, 21);
		panel_QLSP.add(comboBox_LoaiSP);

		JButton btn_XemChiTietSP = new JButton("Xem chi tiết >>");
		btn_XemChiTietSP.setBounds(455, 122, 128, 23);
		panel_QLSP.add(btn_XemChiTietSP);

		JButton btn_LamMoi_SP = new JButton("Làm mới");		
		btn_LamMoi_SP.setBounds(311, 122, 131, 23);
		panel_QLSP.add(btn_LamMoi_SP);
		btn_LamMoi_SP.setIcon(new ImageIcon("image/Very-Basic-Reload-icon.png"));

		JMenuBar menuBar_QLSP = new JMenuBar();
		menuBar_QLSP.setBorder(null);
		menuBar_QLSP.setBounds(0, 0, 1070, 35);
		panel_QLSP.add(menuBar_QLSP);

		JMenu mn_SP_Them = new JMenu("Thêm sản phẩm");

		mn_SP_Them.setBorder(null);
		mn_SP_Them.setIcon(new ImageIcon("image/add-icon.png"));
		menuBar_QLSP.add(mn_SP_Them);

		JMenu mn_SP_ThemN = new JMenu("Thêm nhiều SP");
		mn_SP_ThemN.setBorder(null);
		mn_SP_ThemN.setIcon(new ImageIcon("image/Add-File-icon.png"));
		menuBar_QLSP.add(mn_SP_ThemN);

		JMenu mn_SP_CN = new JMenu("Cập nhật");
		mn_SP_CN.setBorder(null);
		mn_SP_CN.setIcon(new ImageIcon("image/edit-icon.png"));
		menuBar_QLSP.add(mn_SP_CN);

		JMenu mn_SP_CTT = new JMenu("Chuyển trạng thái");
		mn_SP_CTT.setBorder(null);
		mn_SP_CTT.setIcon(new ImageIcon("image/another-change-4.png"));
		menuBar_QLSP.add(mn_SP_CTT);
		// Quản lí nhân viên
		JPanel panel_QLNV = new JPanel();
		panel_QLNV.setBackground(new Color(255, 255, 255));
		tab_Main.addTab("New tab", null, panel_QLNV, null);
		panel_QLNV.setLayout(null);

		JPanel panel_NV_TraCuu = new JPanel();
		panel_NV_TraCuu.setBackground(new Color(255, 255, 255));
		panel_NV_TraCuu.setBounds(0, 70, 1060, 81);
		panel_QLNV.add(panel_NV_TraCuu);
		panel_NV_TraCuu.setLayout(null);

		JLabel lbl_MaNV = new JLabel("Mã nhân viên:");
		lbl_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_MaNV.setBounds(10, 10, 107, 24);
		panel_NV_TraCuu.add(lbl_MaNV);

		text_MaNV = new JTextField();
		text_MaNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_MaNV.setOpaque(false);
		text_MaNV.setBounds(127, 13, 151, 19);
		panel_NV_TraCuu.add(text_MaNV);
		text_MaNV.setColumns(10);

		JLabel lbl_TenNV = new JLabel("Tên nhân viên:");
		lbl_TenNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_TenNV.setBounds(314, 10, 94, 24);
		panel_NV_TraCuu.add(lbl_TenNV);

		txt_TenNV = new JTextField();

		txt_TenNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txt_TenNV.setOpaque(false);
		txt_TenNV.setColumns(10);
		txt_TenNV.setBounds(418, 15, 271, 19);
		panel_NV_TraCuu.add(txt_TenNV);

		JLabel lbl_SdtNV = new JLabel("Số điện thoại:");
		lbl_SdtNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_SdtNV.setBounds(699, 9, 79, 27);
		panel_NV_TraCuu.add(lbl_SdtNV);

		text_SdtNV = new JTextField();

		text_SdtNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_SdtNV.setOpaque(false);
		text_SdtNV.setColumns(10);
		text_SdtNV.setBounds(788, 15, 151, 19);
		panel_NV_TraCuu.add(text_SdtNV);

		JButton btn_LamMoi_NV = new JButton("Làm mới");
		btn_LamMoi_NV.setIcon(new ImageIcon("image/Very-Basic-Reload-icon.png"));
		btn_LamMoi_NV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_LamMoi_NV.setBounds(570, 44, 119, 27);
		panel_NV_TraCuu.add(btn_LamMoi_NV);
		
		JLabel lbl_TT_NhanVien = new JLabel("Trạng thái:");
		lbl_TT_NhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_TT_NhanVien.setBounds(810, 44, 79, 27);
		panel_NV_TraCuu.add(lbl_TT_NhanVien);
		
		String ttNhanVien[] = {"Tất Cả","Đang làm","Nghỉ việc"};
		JComboBox comboBox_TT_NhanVien = new JComboBox(ttNhanVien);
		comboBox_TT_NhanVien.setBounds(899, 44, 151, 27);
		panel_NV_TraCuu.add(comboBox_TT_NhanVien);
		// Panel danh sách nhân viên		
		JPanel panel_NV = new JPanel();
		panel_NV.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		panel_NV.setBounds(10, 154, 1050, 244);
		panel_QLNV.add(panel_NV);


		String []headerDsNV = "Mã nhân viên;Tên nhân viên;Số điện thoại ;Địa chỉ;Chức vụ;Giới tính;Ngày sinh;Ngày vào làm;Trạng thái".split(";");
		modelDsNV = new DefaultTableModel(headerDsNV,0);

		JScrollPane scroll_NV;
		scroll_NV = new JScrollPane();
		scroll_NV.setBorder(null);
		scroll_NV.setBounds(0, 0, 1050, 244);
		scroll_NV.setViewportView(table_NV = new JTable(modelDsNV));
		table_NV.setRowHeight(25);
		table_NV.setAutoCreateRowSorter(true);
		table_NV.getColumnModel().getColumn(0).setPreferredWidth(70);
		table_NV.getColumnModel().getColumn(1).setPreferredWidth(170);
		table_NV.getColumnModel().getColumn(3).setPreferredWidth(170);
		table_NV.getColumnModel().getColumn(4).setPreferredWidth(130);
		table_NV.setLayout(null);
		panel_NV.setLayout(null);
		panel_NV.add(scroll_NV);
		ArrayList<NhanVien> listNV = dao_NV.getAllNhanVien2();
		loadDataQLNV(modelDsNV, listNV);
		///------------load data Table nhân viên	
		JPanel panel_NV_CaLam = new JPanel();
		panel_NV_CaLam.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_NV_CaLam.setBounds(10, 471, 1050, 120);
		panel_QLNV.add(panel_NV_CaLam);
		panel_NV_CaLam.setLayout(null);

		ArrayList<NhanVien> dsTenNhanVienCalam = new ArrayList<NhanVien>();
		dsTenNhanVienCalam=dao_NV.getAllNhanVien();
		ArrayList<String> dsTenNV = new ArrayList<String>();
		for(NhanVien nvv:dsTenNhanVienCalam) {
			dsTenNV.add(nvv.getTenNV());
		}

		String[] dsTenNVstr = new String[dsTenNhanVienCalam.size()];
		for(int i =0;i< dsTenNVstr.length;i++) {
			dsTenNVstr[i]= dsTenNV.get(i);
		}

		cbbSang = new JComboBox(dsTenNVstr);

		ArrayList<CaLam> arrCalam = new ArrayList<CaLam>();
		arrCalam = dao_Calam.getAllCaLam2();

		modelCalam = new DefaultTableModel();	
		tableCalam = new JTable(modelCalam);
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
		TableColumn tbc1 = tableCalam.getColumnModel().getColumn(1);
		TableColumn tbc2 = tableCalam.getColumnModel().getColumn(2);
		TableColumn tbc3 = tableCalam.getColumnModel().getColumn(3);
		TableColumn tbc4 = tableCalam.getColumnModel().getColumn(4);
		TableColumn tbc5 = tableCalam.getColumnModel().getColumn(5);
		TableColumn tbc6 = tableCalam.getColumnModel().getColumn(6);
		TableColumn tbc7 = tableCalam.getColumnModel().getColumn(7);
		tbc1.setCellEditor(new DefaultCellEditor(cbbSang));
		tbc2.setCellEditor(new DefaultCellEditor(cbbSang));
		tbc3.setCellEditor(new DefaultCellEditor(cbbSang));
		tbc4.setCellEditor(new DefaultCellEditor(cbbSang));
		tbc5.setCellEditor(new DefaultCellEditor(cbbSang));
		tbc6.setCellEditor(new DefaultCellEditor(cbbSang));
		tbc7.setCellEditor(new DefaultCellEditor(cbbSang));
		JScrollPane scrollPane = new JScrollPane(tableCalam);
		scrollPane.setLocation(0, 0);
		scrollPane.setSize(1052, 120);
		tableCalam.setEnabled(false);
		tableCalam.setRowHeight(48);
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
		panel_NV_CaLam.add(scrollPane);

		JLabel lbl_Title_QLNV = new JLabel("Quản lí nhân viên");
		lbl_Title_QLNV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title_QLNV.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_Title_QLNV.setBounds(0, 34, 1070, 35);
		panel_QLNV.add(lbl_Title_QLNV);

		JMenuBar menuBar_QLNV = new JMenuBar();
		menuBar_QLNV.setBorder(null);
		menuBar_QLNV.setBounds(0, 0, 1070, 35);
		panel_QLNV.add(menuBar_QLNV);

		JMenu mn_NV_Them = new JMenu("Thêm nhân viên");
		mn_NV_Them.setIcon(new ImageIcon("image/add-icon.png"));
		menuBar_QLNV.add(mn_NV_Them);

		JMenu mn_NV_CN = new JMenu("Cập nhật nhân viên");
		mn_NV_CN.setIcon(new ImageIcon("image/edit-icon.png"));
		menuBar_QLNV.add(mn_NV_CN);

		JMenu mn_NV_X = new JMenu("Chuyển trạng thái");
		mn_NV_X.setIcon(new ImageIcon("image/another-change-4.png"));
		menuBar_QLNV.add(mn_NV_X);

		JButton btnPhanCongCalam = new JButton("Chỉnh sữa");
		btnPhanCongCalam.setHorizontalAlignment(SwingConstants.LEADING);
		btnPhanCongCalam.setBounds(829, 593, 121, 33);
		panel_QLNV.add(btnPhanCongCalam);
		btnPhanCongCalam.setBackground(UIManager.getColor("Button.background"));
		btnPhanCongCalam.setIcon(new ImageIcon("image/Actions-view-calendar-timeline-icon.png"));


		JButton btnLuuCalam_1 = new JButton("Lưu");
		btnLuuCalam_1.setEnabled(false);
		btnLuuCalam_1.setIcon(new ImageIcon("image/Save.png"));
		btnLuuCalam_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnLuuCalam_1.setBounds(960, 593, 100, 32);
		panel_QLNV.add(btnLuuCalam_1);
		
				JLabel lbl_Title_LichLamViec = new JLabel("Lịch làm việc");
				lbl_Title_LichLamViec.setBounds(10, 428, 1050, 33);
				panel_QLNV.add(lbl_Title_LichLamViec);
				lbl_Title_LichLamViec.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_Title_LichLamViec.setFont(new Font("Tahoma", Font.BOLD, 25));
				
				JPanel panelTemp = new JPanel();
				panelTemp.setBackground(new Color(0, 160, 215));
				panelTemp.setBounds(0, 398, 1070, 5);
				panel_QLNV.add(panelTemp);
				panelTemp.setLayout(null);
				
				JLabel lbl_temp = new JLabel("");
				lbl_temp.setBounds(0, 0, 1070, 5);
				panelTemp.add(lbl_temp);
				lbl_temp.setBackground(new Color(0, 160, 215));
		btnLuuCalam_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv = new NhanVien();
				int  j=1;
				try {
					for(int i = 1;i<14;i+=2) {
						nv = dao_NV.timKiemNV_Ten((String)tableCalam.getValueAt(0, j));
						CaLam cl = new CaLam("CL"+String.format("%04d",i),nv);
						dao_Calam.updateCL2(cl);
						j+=1;
					}
					int jj=1;
					for(int i = 2;i<15;i+=2) {
						nv = dao_NV.timKiemNV_Ten((String)tableCalam.getValueAt(1, jj));
						CaLam cl = new CaLam("CL"+String.format("%04d",i),nv);
						dao_Calam.updateCL2(cl);
						jj+=1;
					}
					JOptionPane.showMessageDialog(null, "Lưu thành công");
					btnLuuCalam_1.setEnabled(false);
					tableCalam.setEnabled(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.err.println("Có lỗi chỗ nào rồi! Cứu");
				}
				

			}
		});
		//-------------------------------Sự kiện nhân viên------------------------------
		btnPhanCongCalam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableCalam.setEnabled(true);
				tableCalam.setRowSelectionInterval(0, 0);
				btnLuuCalam_1.setEnabled(true);
			}
		});
		//Panel nhà cung cấp		
		JPanel panel_NCC = new JPanel();
		panel_NCC.setBackground(new Color(255, 255, 255));

		tab_Main.addTab("New tab", null, panel_NCC, null);
		panel_NCC.setLayout(null);

		JLabel lblTitleNCC = new JLabel("Quản lí nhà cung cấp");
		lblTitleNCC.setBounds(10, 50, 636, 37);
		lblTitleNCC.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleNCC.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_NCC.add(lblTitleNCC);

		JPanel panelTableNCC = new JPanel();
		panelTableNCC.setBounds(0, 186, 636, 464);
		panel_NCC.add(panelTableNCC);
		//Table nhà cung cáp
		tableNCC = new JTable();	
		String []headerNCC = "Mã nhà cung cấp;Tên nhà cung cấp;Số điện thoại; địa chỉ".split(";");

		modelNCC = new DefaultTableModel(headerNCC,0);

		JScrollPane scrollNCC;
		scrollNCC = new JScrollPane();
		scrollNCC.setBorder(null);
		scrollNCC.setBounds(1, 1, 635, 459);
		scrollNCC.setViewportView(tableNCC = new JTable(modelNCC));
		tableNCC.setRowHeight(25);
		tableNCC.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableNCC.setLayout(null);
		tableNCC.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableNCC.getColumnModel().getColumn(3).setPreferredWidth(200);
		panelTableNCC.setLayout(null);
		panelTableNCC.add(scrollNCC);
		ArrayList<NhaCungCap> listNCC = dao_NCC.getAllNCC();
		loadDataNCC(modelNCC,listNCC);
		//--------------------------------		

		JPanel panelControlNCC = new JPanel();
		panelControlNCC.setBackground(new Color(255, 255, 255));
		panelControlNCC.setBounds(0, 98, 636, 81);
		panel_NCC.add(panelControlNCC);
		panelControlNCC.setLayout(null);

		JLabel lblMaNCC = new JLabel("Mã NCC\r\n");
		lblMaNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNCC.setBounds(10, 38, 62, 31);
		panelControlNCC.add(lblMaNCC);

		txtMaNCC = new JTextField();

		txtMaNCC.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtMaNCC.setOpaque(false);
		txtMaNCC.setBounds(82, 39, 190, 30);
		panelControlNCC.add(txtMaNCC);
		txtMaNCC.setColumns(10);

		JLabel lblTenNCC = new JLabel("Tên NCC");
		lblTenNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNCC.setBounds(10, 94, 62, 31);
		panelControlNCC.add(lblTenNCC);

		txtTenMCC = new JTextField();
		txtTenMCC.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTenMCC.setOpaque(false);
		txtTenMCC.setColumns(10);
		txtTenMCC.setBounds(82, 96, 460, 30);
		panelControlNCC.add(txtTenMCC);

		JLabel lblSdtNCC = new JLabel("Số điện thoại");
		lblSdtNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdtNCC.setBounds(282, 38, 100, 31);
		panelControlNCC.add(lblSdtNCC);

		txtSdtNCC = new JTextField();
		txtSdtNCC.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtSdtNCC.setOpaque(false);
		txtSdtNCC.setColumns(10);
		txtSdtNCC.setBounds(392, 40, 150, 30);
		panelControlNCC.add(txtSdtNCC);

		JButton btnReNCC = new JButton("");
		btnReNCC.setIcon(new ImageIcon("image/Very-Basic-Reload-icon.png"));
		btnReNCC.setBounds(570, 42, 49, 31);
		panelControlNCC.add(btnReNCC);

		JPanel panel_NCC_SPLoi = new JPanel();
		panel_NCC_SPLoi.setBounds(646, 121, 414, 529);
		panel_NCC.add(panel_NCC_SPLoi);

		tableLoiSP = new JTable();	
		String []header3SP = "Mã SP;Tên sản phẩm;Loại;Lỗi".split(";");

		model3SP = new DefaultTableModel(header3SP,0);

		JScrollPane scroll3;
		scroll3 = new JScrollPane();
		scroll3.setBorder(null);
		scroll3.setBounds(10, 10, 394, 509);
		scroll3.setViewportView(tableLoiSP = new JTable(model3SP));
		tableLoiSP.setRowHeight(25);
		tableLoiSP.setAutoCreateRowSorter(true);
		tableLoiSP.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableLoiSP.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableLoiSP.setLayout(null);
		panel_NCC_SPLoi.setLayout(null);
		loadDataQLSP3(model3SP, listSP);
		panel_NCC_SPLoi.add(scroll3);

		JLabel lblNewLabel_1 = new JLabel("Danh sách sản phẩm lỗi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(646, 87, 414, 37);
		panel_NCC.add(lblNewLabel_1);
		
		JMenuBar menuBar_QLNCC = new JMenuBar();
		menuBar_QLNCC.setBorder(null);
		menuBar_QLNCC.setBounds(0, 0, 1070, 35);
		panel_NCC.add(menuBar_QLNCC);
		
		JMenu mnNewMenu = new JMenu("Thêm nhà cung cấp");
		mnNewMenu.setIcon(new ImageIcon("image/add-icon.png"));
		menuBar_QLNCC.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Cập nhật ");
		mnNewMenu_1.setIcon(new ImageIcon("image/edit-icon.png"));
		menuBar_QLNCC.add(mnNewMenu_1);

		JPanel panel_TK = new JPanel();
		panel_TK.setBackground(new Color(255, 255, 255));
		tab_Main.addTab("New tab", null, panel_TK, null);
		panel_TK.setLayout(null);

		JTabbedPane tabbedPaneTK = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneTK.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPaneTK.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPaneTK.setBounds(10, 92, 1050, 548);
		panel_TK.add(tabbedPaneTK);


		JPanel panelNgayTK = new JPanel();
		panelNgayTK.setBackground(new Color(0, 160, 215));
		tabbedPaneTK.addTab("Ngày", null, panelNgayTK, null);
		panelNgayTK.setLayout(null);
		// Biểu đồ ngày thống kê

		//----------------		
		JPanel panelTongDoanhThuTK = new JPanel();
		panelTongDoanhThuTK.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelTongDoanhThuTK.setBounds(10, 10, 420, 163);
		panelNgayTK.add(panelTongDoanhThuTK);
		panelTongDoanhThuTK.setLayout(null);

		JLabel lblTongDT = new JLabel("Tổng doanh thu");
		lblTongDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongDT.setBounds(10, 10, 400, 37);
		panelTongDoanhThuTK.add(lblTongDT);

		double tongDoanhThuNgay = dao_HD.TongDoanhThuNgay(currentDate);

		String str1 = currencyVN.format(tongDoanhThuNgay);

		JLabel lbl_DT_TDT_Ngay = new JLabel(str1);
		lbl_DT_TDT_Ngay.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DT_TDT_Ngay.setFont(new Font("Tahoma", Font.BOLD, 45));
		lbl_DT_TDT_Ngay.setBounds(10, 57, 400, 96);
		panelTongDoanhThuTK.add(lbl_DT_TDT_Ngay);

		JPanel panelSoHdTK = new JPanel();
		panelSoHdTK.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelSoHdTK.setBounds(440, 10, 220, 163);
		panelNgayTK.add(panelSoHdTK);
		panelSoHdTK.setLayout(null);

		JLabel lblSoHDDT = new JLabel("Số hóa đơn");
		lblSoHDDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoHDDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoHDDT.setBounds(10, 10, 200, 36);
		panelSoHdTK.add(lblSoHDDT);

		JLabel lbl_DT_THD_Ngay = new JLabel(dao_HD.TongHDNgay(currentDate)+"");
		lbl_DT_THD_Ngay.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DT_THD_Ngay.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lbl_DT_THD_Ngay.setBounds(10, 56, 200, 97);
		panelSoHdTK.add(lbl_DT_THD_Ngay);
		//Table sản phẩm bán chạy THỐNG KÊ	
		JPanel panelSpBanChayTK = new JPanel();
		panelSpBanChayTK.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelSpBanChayTK.setBounds(670, 49, 365, 462);
		panelNgayTK.add(panelSpBanChayTK);
		panelSpBanChayTK.setLayout(null);

		JTable tableSpTK;
		tableSpTK = new JTable();	
		String []headerSpTK = "STT;Tên sản phẩm;SL".split(";");
		DefaultTableModel modelspTK = new DefaultTableModel(headerSpTK,0);

		JScrollPane scrollspTK;
		scrollspTK = new JScrollPane();
		scrollspTK.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollspTK.setBounds(10, 62, 345, 390);
		scrollspTK.setViewportView(tableSpTK = new JTable(modelspTK));
		tableSpTK.setRowHeight(25);
		tableSpTK.setAutoCreateRowSorter(true);
		tableSpTK.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableSpTK.setLayout(null);
		panelSpBanChayTK.setLayout(null);
		panelSpBanChayTK.add(scrollspTK);
		ArrayList<SanPham> listSPngay =dao_SP.getSPBanChayNgay(currentDate);
		loadDataSPTK(modelspTK, listSPngay);
		tableSpTK.getColumnModel().getColumn(1).setPreferredWidth(200);

		JLabel lbSpBanChayTK = new JLabel("Sản phẩm bán chạy");
		lbSpBanChayTK.setHorizontalAlignment(SwingConstants.CENTER);
		lbSpBanChayTK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSpBanChayTK.setBounds(10, 10, 345, 42);
		panelSpBanChayTK.add(lbSpBanChayTK);
		// Tháng thống kê		
		JPanel panelThangTK = new JPanel();
		panelThangTK.setBackground(new Color(0, 160, 215));
		tabbedPaneTK.addTab("Tháng", null, panelThangTK, null);
		panelThangTK.setLayout(null);

		JPanel panelTongDoanhThuTK_1 = new JPanel();
		panelTongDoanhThuTK_1.setLayout(null);
		panelTongDoanhThuTK_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelTongDoanhThuTK_1.setBounds(10, 10, 420, 163);
		panelThangTK.add(panelTongDoanhThuTK_1);

		JLabel lblTongDT_1 = new JLabel("Tổng doanh thu");
		lblTongDT_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongDT_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongDT_1.setBounds(10, 10, 400, 37);
		panelTongDoanhThuTK_1.add(lblTongDT_1);

		double tongDoanhThuThang = dao_HD.TongDoanhThuThang(currentDate);
		String str2 = currencyVN.format(tongDoanhThuThang);

		JLabel lbl_DT_TDT_Thang = new JLabel(str2);
		lbl_DT_TDT_Thang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DT_TDT_Thang.setFont(new Font("Tahoma", Font.BOLD, 45));
		lbl_DT_TDT_Thang.setBounds(10, 57, 400, 96);
		panelTongDoanhThuTK_1.add(lbl_DT_TDT_Thang);

		JPanel panelSoHdTK_1 = new JPanel();
		panelSoHdTK_1.setLayout(null);
		panelSoHdTK_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelSoHdTK_1.setBounds(440, 10, 220, 163);
		panelThangTK.add(panelSoHdTK_1);

		JLabel lblSoHDDT_1 = new JLabel("Số hóa đơn");
		lblSoHDDT_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoHDDT_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoHDDT_1.setBounds(10, 10, 200, 36);
		panelSoHdTK_1.add(lblSoHDDT_1);

		JLabel lbl_DT_THD_Thang = new JLabel(dao_HD.TongHDThang(currentDate)+"");
		lbl_DT_THD_Thang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DT_THD_Thang.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lbl_DT_THD_Thang.setBounds(10, 56, 200, 97);
		panelSoHdTK_1.add(lbl_DT_THD_Thang);

		JPanel panelSpBanChayTK_1 = new JPanel();
		panelSpBanChayTK_1.setLayout(null);
		panelSpBanChayTK_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelSpBanChayTK_1.setBounds(670, 51, 365, 460);
		panelThangTK.add(panelSpBanChayTK_1);

		JLabel lbSpBanChayTK_1 = new JLabel("Sản phẩm bán chạy");
		lbSpBanChayTK_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbSpBanChayTK_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSpBanChayTK_1.setBounds(10, 10, 345, 42);
		panelSpBanChayTK_1.add(lbSpBanChayTK_1);


		JTable tableSpTK_1;
		tableSpTK_1 = new JTable();	
		String []headerSpTK_1 = "STT;Tên sản phẩm;Số lượng".split(";");
		DefaultTableModel modelspTK_1 = new DefaultTableModel(headerSpTK_1,0);

		JScrollPane scrollspTK_1;
		scrollspTK_1 = new JScrollPane();
		scrollspTK_1.setBorder(null);
		scrollspTK_1.setBounds(10, 62, 345, 388);
		scrollspTK_1.setViewportView(tableSpTK_1 = new JTable(modelspTK_1));
		tableSpTK_1.setRowHeight(25);
		tableSpTK_1.setAutoCreateRowSorter(true);
		tableSpTK_1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableSpTK_1.setLayout(null);
		panelSpBanChayTK_1.setLayout(null);
		panelSpBanChayTK_1.add(scrollspTK_1);
		ArrayList<SanPham> listSPThang = dao_SP.getSPBanChay_Thang(currentDate);
		loadDataSPTK(modelspTK_1, listSPThang);
		tableSpTK_1.getColumnModel().getColumn(1).setPreferredWidth(200);
		JPanel panel_TableTK_Thang = new JPanel();
		panel_TableTK_Thang.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_TableTK_Thang.setBounds(10, 185, 650, 326);
		panelThangTK.add(panel_TableTK_Thang);

		final DefaultCategoryDataset dataset_1 = new DefaultCategoryDataset();       
		for (int i=1;i<13;i++) {    	

			LocalDate lcd =  LocalDate.of(currentDate.getYear(), i, 1);
			dataset_1.addValue(dao_HD.TongHDThang(lcd), "Số hóa đơn", i+"");
		}
		JFreeChart barChart_1 = ChartFactory.createBarChart(
				"Biểu đồ doanh thu","Tháng", "Số lượng hóa đơn",
				dataset_1, PlotOrientation.VERTICAL, false, false, false);
		//	panelTableTK.setLayout(new GridLayout(0, 1, 0, 0));

		JDateChooser dateChooser_TK_Ngay = new JDateChooser();
		dateChooser_TK_Ngay.setBounds(880, 10, 155, 31);
		panelNgayTK.add(dateChooser_TK_Ngay);

		JButton btn_TK_Ngay = new JButton("Lọc");
		btn_TK_Ngay.setBounds(778, 10, 85, 31);
		panelNgayTK.add(btn_TK_Ngay);
		
		ImageBox img = new ImageBox("image/logo8rec.png", 600,250);
		JPanel panel_LogoTK = new JPanel();
		panel_LogoTK.setLayout(new BoxLayout(panel_LogoTK, BoxLayout.X_AXIS));
		panel_LogoTK.add(img);
		panel_LogoTK.setBounds(38, 213, 600, 250);
		panelNgayTK.add(panel_LogoTK);
		panel_TableTK_Thang.setLayout(new GridLayout(0, 1, 0, 0));


		ChartPanel chartPanel_1 = new ChartPanel(barChart_1);
		panel_TableTK_Thang.add(chartPanel_1);

		String strThangTK[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};

		JYearChooser yearChooser_Thang = new JYearChooser();
		yearChooser_Thang.setBounds(963, 10, 70, 25);
		panelThangTK.add(yearChooser_Thang);

		JButton btn_TK_L_T = new JButton("Lọc");
		btn_TK_L_T.setBounds(778, 10, 69, 25);
		panelThangTK.add(btn_TK_L_T);

		JMonthChooser monthChooser_TD_TDT_Thang = new JMonthChooser();
		monthChooser_TD_TDT_Thang.setBounds(857, 10, 105, 25);
		panelThangTK.add(monthChooser_TD_TDT_Thang);
		// Năm thống kê
		JPanel paneNamTK = new JPanel();
		paneNamTK.setBackground(new Color(0, 160, 215));
		tabbedPaneTK.addTab("Năm", null, paneNamTK, null);
		paneNamTK.setLayout(null);

		JPanel panelTongDoanhThuTK_2 = new JPanel();
		panelTongDoanhThuTK_2.setLayout(null);
		panelTongDoanhThuTK_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelTongDoanhThuTK_2.setBounds(10, 10, 420, 163);
		paneNamTK.add(panelTongDoanhThuTK_2);

		JLabel lblTongDT_2 = new JLabel("Tổng doanh thu");
		lblTongDT_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongDT_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongDT_2.setBounds(10, 10, 400, 37);
		panelTongDoanhThuTK_2.add(lblTongDT_2);

		Double dtNam = dao_HD.TongDoanhThuNam(currentDate);
		String dtNamstr = currencyVN.format(dtNam);

		JLabel lbl_DT_TDT_Nam = new JLabel(dtNamstr);
		lbl_DT_TDT_Nam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DT_TDT_Nam.setFont(new Font("Tahoma", Font.BOLD, 45));
		lbl_DT_TDT_Nam.setBounds(10, 57, 400, 96);
		panelTongDoanhThuTK_2.add(lbl_DT_TDT_Nam);

		JPanel panelSoHdTK_2 = new JPanel();
		panelSoHdTK_2.setLayout(null);
		panelSoHdTK_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelSoHdTK_2.setBounds(440, 10, 220, 163);
		paneNamTK.add(panelSoHdTK_2);

		JLabel lblSoHDDT_2 = new JLabel("Số hóa đơn");
		lblSoHDDT_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoHDDT_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoHDDT_2.setBounds(10, 10, 200, 36);
		panelSoHdTK_2.add(lblSoHDDT_2);

		JLabel lbl_DT_THD_Nam = new JLabel(dao_HD.TongHDNam(currentDate)+"");
		lbl_DT_THD_Nam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DT_THD_Nam.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lbl_DT_THD_Nam.setBounds(10, 56, 200, 97);
		panelSoHdTK_2.add(lbl_DT_THD_Nam);

		JPanel panelSpBanChayTK_2 = new JPanel();
		panelSpBanChayTK_2.setLayout(null);
		panelSpBanChayTK_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelSpBanChayTK_2.setBounds(670, 41, 365, 470);
		paneNamTK.add(panelSpBanChayTK_2);

		JLabel lbSpBanChayTK_2 = new JLabel("Sản phẩm bán chạy");
		lbSpBanChayTK_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbSpBanChayTK_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSpBanChayTK_2.setBounds(10, 10, 345, 42);
		panelSpBanChayTK_2.add(lbSpBanChayTK_2);

		JTable tableSpTK_2;
		tableSpTK_2 = new JTable();	
		String []headerSpTK_2 = "STT;Tên sản phẩm;Số lượng".split(";");
		DefaultTableModel modelspTK_2 = new DefaultTableModel(headerSpTK_2,0);

		JScrollPane scrollspTK_2;
		scrollspTK_2 = new JScrollPane();
		scrollspTK_2.setBorder(null);
		scrollspTK_2.setBounds(10, 59, 345, 401);
		scrollspTK_2.setViewportView(tableSpTK_2 = new JTable(modelspTK_2));
		tableSpTK_2.setRowHeight(25);
		tableSpTK_2.setAutoCreateRowSorter(true);
		tableSpTK_2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableSpTK_2.setLayout(null);
		panelSpBanChayTK_2.setLayout(null);
		panelSpBanChayTK_2.add(scrollspTK_2);
		ArrayList<SanPham> listSPNam = dao_SP.getSPBanChay_Nam(currentDate);
		loadDataSPTK(modelspTK_2, listSPNam);
		tableSpTK_2.getColumnModel().getColumn(1).setPreferredWidth(200);

		JPanel panel_TableTK_2 = new JPanel();
		panel_TableTK_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_TableTK_2.setBounds(10, 185, 650, 326);
		paneNamTK.add(panel_TableTK_2);

		final DefaultCategoryDataset dataset_2 = new DefaultCategoryDataset();     
		int yy = currentDate.getYear()-5;
		for (int i=yy;i<currentDate.getYear()+1;i++) {
			LocalDate lcd =  LocalDate.of(i,6, 6);
			dataset_2.addValue(dao_HD.TongHDNam(lcd), "Số hóa đơn", String.valueOf(i));
		}
		JFreeChart barChart_2 = ChartFactory.createBarChart(
				"Biểu đồ doanh thu","Năm", "",
				dataset_2, PlotOrientation.VERTICAL, false, false, false);
		panel_TableTK_2.setLayout(new GridLayout(0, 1, 0, 0));
		ChartPanel chartPanel_2 = new ChartPanel(barChart_2);
		panel_TableTK_2.add(chartPanel_2);

		JYearChooser yearChooser_DT_Nam = new JYearChooser();
		yearChooser_DT_Nam.setBounds(926, 10, 109, 27);
		paneNamTK.add(yearChooser_DT_Nam);

		JButton btn_L_Nam = new JButton("Lọc");

		btn_L_Nam.setBounds(831, 10, 85, 27);
		paneNamTK.add(btn_L_Nam);


		JLabel lblNewLabel = new JLabel("Thống kê doanh thu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 850, 52);
		panel_TK.add(lblNewLabel);
		
				JButton btnTKHD = new JButton("Thống kê hóa đơn >>");
				btnTKHD.setBounds(860, 10, 200, 40);
				panel_TK.add(btnTKHD);
				btnTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnTKHD.setBackground(UIManager.getColor("Button.background"));
				btnTKHD.setIcon(new ImageIcon("image/Finance-Bill-icon.png"));
				
						btnTKHD.setHorizontalAlignment(SwingConstants.LEADING);
						//-------------------------------Sự kiện Thống kê-------------------------------		
						btnTKHD.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								tab_Main.setSelectedIndex(4);
							}
						});

		JPanel panel_TK2 = new JPanel();
		panel_TK2.setBackground(new Color(255, 255, 255));
		tab_Main.addTab("New tab", null, panel_TK2, null);
		panel_TK2.setLayout(null);

		JTabbedPane tabbedPaneTKHD = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneTKHD.setBounds(10, 109, 1050, 531);
		panel_TK2.add(tabbedPaneTKHD);
		// Trang  1 thóng kê hóa đơn		
		JPanel panelNgayTKHD = new JPanel();
		panelNgayTKHD.setBackground(new Color(0, 160, 215));
		tabbedPaneTKHD.addTab("Ngày", null, panelNgayTKHD, null);
		panelNgayTKHD.setLayout(null);

		JPanel panelNV_NgayTKHD = new JPanel();
		panelNV_NgayTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNV_NgayTKHD.setBounds(10, 48, 383, 446);
		panelNgayTKHD.add(panelNV_NgayTKHD);
		panelNV_NgayTKHD.setLayout(null);

		JPanel panel_TitleNgayTKHD = new JPanel();
		panel_TitleNgayTKHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_TitleNgayTKHD.setBounds(10, 10, 363, 119);
		panelNV_NgayTKHD.add(panel_TitleNgayTKHD);
		panel_TitleNgayTKHD.setLayout(null);

		JLabel lblMaNVTKHD = new JLabel("Mã nhân viên :");
		lblMaNVTKHD.setBounds(5, 24, 114, 30);
		panel_TitleNgayTKHD.add(lblMaNVTKHD);
		lblMaNVTKHD.setFont(new Font("Dialog", Font.BOLD, 14));

		JLabel lblTenNVTKHD = new JLabel("Tên nhân viên :");
		lblTenNVTKHD.setBounds(5, 79, 109, 30);
		panel_TitleNgayTKHD.add(lblTenNVTKHD);
		lblTenNVTKHD.setFont(new Font("Dialog", Font.BOLD, 14));

		txtMa_TK_NV_Ngay = new JTextField();
		txtMa_TK_NV_Ngay.setOpaque(false);
		txtMa_TK_NV_Ngay.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtMa_TK_NV_Ngay.setBounds(124, 27, 229, 30);
		panel_TitleNgayTKHD.add(txtMa_TK_NV_Ngay);
		txtMa_TK_NV_Ngay.setColumns(10);

		txtTen_TK_NV_Ngay = new JTextField();
		txtTen_TK_NV_Ngay.setOpaque(false);
		txtTen_TK_NV_Ngay.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTen_TK_NV_Ngay.setBounds(132, 79, 221, 30);
		panel_TitleNgayTKHD.add(txtTen_TK_NV_Ngay);
		txtTen_TK_NV_Ngay.setColumns(10);
		//Table ngày TKHD		
		JPanel panel_tableNgayTKHD = new JPanel();
		panel_tableNgayTKHD.setBounds(10, 136, 363, 300);
		panelNV_NgayTKHD.add(panel_tableNgayTKHD);

		tableNgayTKHD = new JTable();	
		String []headernTKHD = "Mã NV;Tên NV".split(";");
		modelnTKHD = new DefaultTableModel(headernTKHD,0);

		JScrollPane scrollnTKHD;
		scrollnTKHD = new JScrollPane();
		scrollnTKHD.setBorder(null);
		scrollnTKHD.setBounds(10, 10, 343, 280);
		scrollnTKHD.setViewportView(table_NV_TKHD_Ngay = new JTable(modelnTKHD));
		table_NV_TKHD_Ngay.setRowHeight(25);
		//		tableNgayTKHD.setAutoCreateRowSorter(true);
		table_NV_TKHD_Ngay.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table_NV_TKHD_Ngay.setLayout(null);
		panel_tableNgayTKHD.setLayout(null);
		panel_tableNgayTKHD.add(scrollnTKHD);
		loadDataTKNV(modelnTKHD, listNV);

		JDateChooser dateChooser_TK_NV_Ngay = new JDateChooser();
		dateChooser_TK_NV_Ngay.setBounds(148, 10, 174, 28);
		panelNgayTKHD.add(dateChooser_TK_NV_Ngay);

		JLabel lblNgayTKHD = new JLabel("Ngày thống kê");
		lblNgayTKHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayTKHD.setBounds(10, 10, 128, 28);
		panelNgayTKHD.add(lblNgayTKHD);

		JPanel panelNgaySoTKHD = new JPanel();
		panelNgaySoTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNgaySoTKHD.setBounds(403, 10, 200, 140);
		panelNgayTKHD.add(panelNgaySoTKHD);
		panelNgaySoTKHD.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Số hóa đơn\r\n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 180, 19);
		panelNgaySoTKHD.add(lblNewLabel_3);

		JLabel lbl_TK_NV_SDH_Ngay = new JLabel("0");
		lbl_TK_NV_SDH_Ngay.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lbl_TK_NV_SDH_Ngay.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TK_NV_SDH_Ngay.setBounds(10, 39, 180, 91);
		panelNgaySoTKHD.add(lbl_TK_NV_SDH_Ngay);

		JPanel panelNgayDtTKHD = new JPanel();
		panelNgayDtTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNgayDtTKHD.setBounds(613, 10, 422, 140);
		panelNgayTKHD.add(panelNgayDtTKHD);
		panelNgayDtTKHD.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Doanh thu");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 10, 402, 22);
		panelNgayDtTKHD.add(lblNewLabel_5);

		JLabel lbl_TK_NV_DT_Ngay = new JLabel("0đ");
		lbl_TK_NV_DT_Ngay.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lbl_TK_NV_DT_Ngay.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TK_NV_DT_Ngay.setBounds(10, 42, 402, 88);
		panelNgayDtTKHD.add(lbl_TK_NV_DT_Ngay);

		//Table hóa đơn TKHD
		JPanel panel_Table_HdTKHD = new JPanel();
		panel_Table_HdTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Table_HdTKHD.setBounds(403, 160, 632, 334);
		panelNgayTKHD.add(panel_Table_HdTKHD);

		JTable tablehdNgayTKHD;
		tablehdNgayTKHD = new JTable();	
		String []headernhdTKHD = "Mã HD;Mã KH;Tên KH;SDT KH;Tổng tiền;Ngay".split(";");
		DefaultTableModel modelnhdTKHD = new DefaultTableModel(headernhdTKHD,0);

		JScrollPane scrollnhdTKHD;
		scrollnhdTKHD = new JScrollPane();
		scrollnhdTKHD.setBorder(null);
		scrollnhdTKHD.setBounds(10, 10, 612, 314);
		scrollnhdTKHD.setViewportView(tablehdNgayTKHD = new JTable(modelnhdTKHD));
		tablehdNgayTKHD.setRowHeight(25);
		tablehdNgayTKHD.setAutoCreateRowSorter(true);
		tablehdNgayTKHD.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tablehdNgayTKHD.setLayout(null);
		panel_Table_HdTKHD.setLayout(null);
		panel_Table_HdTKHD.add(scrollnhdTKHD);

		JPanel panelThangTKHD = new JPanel();
		panelThangTKHD.setBackground(new Color(0, 160, 215));
		panelThangTKHD.setLayout(null);
		tabbedPaneTKHD.addTab("Tháng", null, panelThangTKHD, null);

		JPanel panelNV_ThangTKHD = new JPanel();
		panelNV_ThangTKHD.setLayout(null);
		panelNV_ThangTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNV_ThangTKHD.setBounds(10, 48, 383, 446);
		panelThangTKHD.add(panelNV_ThangTKHD);

		JPanel panel_TitleNgayTKHD_1 = new JPanel();
		panel_TitleNgayTKHD_1.setLayout(null);
		panel_TitleNgayTKHD_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_TitleNgayTKHD_1.setBounds(10, 10, 363, 119);
		panelNV_ThangTKHD.add(panel_TitleNgayTKHD_1);

		JLabel lblMaNVTKHD_1 = new JLabel("Mã nhân viên :");
		lblMaNVTKHD_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMaNVTKHD_1.setBounds(5, 24, 114, 30);
		panel_TitleNgayTKHD_1.add(lblMaNVTKHD_1);

		JLabel lblTenNVTKHD_1 = new JLabel("Tên nhân viên :");
		lblTenNVTKHD_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTenNVTKHD_1.setBounds(5, 79, 109, 30);
		panel_TitleNgayTKHD_1.add(lblTenNVTKHD_1);

		textMa_TK_NV_Thang = new JTextField();
		textMa_TK_NV_Thang.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textMa_TK_NV_Thang.setOpaque(false);
		textMa_TK_NV_Thang.setColumns(10);
		textMa_TK_NV_Thang.setBounds(124, 27, 229, 30);
		panel_TitleNgayTKHD_1.add(textMa_TK_NV_Thang);

		textTen_TK_NV_Thang = new JTextField();
		textTen_TK_NV_Thang.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textTen_TK_NV_Thang.setOpaque(false);
		textTen_TK_NV_Thang.setColumns(10);
		textTen_TK_NV_Thang.setBounds(132, 79, 221, 30);
		panel_TitleNgayTKHD_1.add(textTen_TK_NV_Thang);

		JPanel panel_tableNgayTKHD_1 = new JPanel();
		panel_tableNgayTKHD_1.setLayout(null);
		panel_tableNgayTKHD_1.setBounds(10, 136, 363, 300);
		panelNV_ThangTKHD.add(panel_tableNgayTKHD_1);
		//Table nhân viên tháng TKHD
		JTable tableThangTKHD;
		tableThangTKHD = new JTable();	
		String []headertTKHD = "Mã NV;Tên NV".split(";");
		DefaultTableModel model_TK_NV_thang = new DefaultTableModel(headertTKHD,0);

		JScrollPane scrolltTKHD;
		scrolltTKHD = new JScrollPane();
		scrolltTKHD.setBorder(null);
		scrolltTKHD.setBounds(10, 10, 343, 280);
		scrolltTKHD.setViewportView(table_TK_NV_Thang = new JTable(model_TK_NV_thang));
		table_TK_NV_Thang.setRowHeight(25);
		table_TK_NV_Thang.setAutoCreateRowSorter(true);
		table_TK_NV_Thang.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table_TK_NV_Thang.setLayout(null);
		panel_tableNgayTKHD_1.setLayout(null);
		panel_tableNgayTKHD_1.add(scrolltTKHD);
		loadDataTKNV(model_TK_NV_thang, listNV);

		JLabel lblThangTKHD = new JLabel("Chọn tháng");
		lblThangTKHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThangTKHD.setBounds(10, 10, 99, 28);
		panelThangTKHD.add(lblThangTKHD);

		JPanel panelThangSoTKHD = new JPanel();
		panelThangSoTKHD.setLayout(null);
		panelThangSoTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelThangSoTKHD.setBounds(403, 10, 200, 140);
		panelThangTKHD.add(panelThangSoTKHD);

		JLabel lblNewLabel_3_1 = new JLabel("Số hóa đơn\r\n");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(10, 10, 180, 19);
		panelThangSoTKHD.add(lblNewLabel_3_1);

		JLabel lbl_NV_TK_SHD_Thang = new JLabel("0");
		lbl_NV_TK_SHD_Thang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NV_TK_SHD_Thang.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lbl_NV_TK_SHD_Thang.setBounds(10, 39, 180, 91);
		panelThangSoTKHD.add(lbl_NV_TK_SHD_Thang);

		JPanel panelThangDtTKHD = new JPanel();
		panelThangDtTKHD.setLayout(null);
		panelThangDtTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelThangDtTKHD.setBounds(613, 10, 422, 140);
		panelThangTKHD.add(panelThangDtTKHD);

		JLabel lblNewLabel_5_1 = new JLabel("Doanh thu");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(10, 10, 402, 22);
		panelThangDtTKHD.add(lblNewLabel_5_1);

		JLabel lbl_NV_TK_DT_Thang = new JLabel("0đ");
		lbl_NV_TK_DT_Thang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NV_TK_DT_Thang.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lbl_NV_TK_DT_Thang.setBounds(10, 42, 402, 88);
		panelThangDtTKHD.add(lbl_NV_TK_DT_Thang);
		//Table thang hóa đơn TKHD		
		JPanel panel_Table_tHdTKHD = new JPanel();
		panel_Table_tHdTKHD.setLayout(null);
		panel_Table_tHdTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Table_tHdTKHD.setBounds(403, 160, 632, 334);
		panelThangTKHD.add(panel_Table_tHdTKHD);

		JTable tableThanghdTKHD;
		tableThanghdTKHD = new JTable();	
		String []headertTKHD1 = "Mã HD;Mã KH;Tên KH;SDT KH;Tổng tiền;Ngay".split(";");
		DefaultTableModel model_TK_HD_Thang = new DefaultTableModel(headertTKHD1,0);

		JScrollPane scrolltTKHD1;
		scrolltTKHD1 = new JScrollPane();
		scrolltTKHD1.setBorder(null);
		scrolltTKHD1.setBounds(10, 10, 612, 314);
		scrolltTKHD1.setViewportView(table_TK_HD_Nam_2 = new JTable(model_TK_HD_Thang));
		table_TK_HD_Nam_2.setRowHeight(25);
		table_TK_HD_Nam_2.setAutoCreateRowSorter(true);
		table_TK_HD_Nam_2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table_TK_HD_Nam_2.setLayout(null);
		panel_Table_tHdTKHD.setLayout(null);
		panel_Table_tHdTKHD.add(scrolltTKHD1);

		JYearChooser yearChooser_TK_NV_Thang = new JYearChooser();
		yearChooser_TK_NV_Thang.setBounds(253, 10, 79, 28);
		panelThangTKHD.add(yearChooser_TK_NV_Thang);

		JMonthChooser monthChooser_TK_NV_Thang = new JMonthChooser();
		monthChooser_TK_NV_Thang.setBounds(135, 10, 108, 28);
		panelThangTKHD.add(monthChooser_TK_NV_Thang);
		/// Trang 3 TKHD		
		JPanel panelNamTKHD = new JPanel();
		panelNamTKHD.setBackground(new Color(0, 160, 215));
		panelNamTKHD.setLayout(null);
		tabbedPaneTKHD.addTab("Năm", null, panelNamTKHD, null);

		JPanel panelNV_NamTKHD = new JPanel();
		panelNV_NamTKHD.setLayout(null);
		panelNV_NamTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNV_NamTKHD.setBounds(10, 48, 383, 446);
		panelNamTKHD.add(panelNV_NamTKHD);

		JPanel panel_TitleNgayTKHD_1_1 = new JPanel();
		panel_TitleNgayTKHD_1_1.setLayout(null);
		panel_TitleNgayTKHD_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_TitleNgayTKHD_1_1.setBounds(10, 10, 363, 119);
		panelNV_NamTKHD.add(panel_TitleNgayTKHD_1_1);

		JLabel lblMaNVTKHD_1_1 = new JLabel("Mã nhân viên :");
		lblMaNVTKHD_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMaNVTKHD_1_1.setBounds(5, 24, 114, 30);
		panel_TitleNgayTKHD_1_1.add(lblMaNVTKHD_1_1);

		JLabel lblTenNVTKHD_1_1 = new JLabel("Tên nhân viên :");
		lblTenNVTKHD_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTenNVTKHD_1_1.setBounds(5, 79, 109, 30);
		panel_TitleNgayTKHD_1_1.add(lblTenNVTKHD_1_1);

		textMa_TK_NV_Nam = new JTextField();
		textMa_TK_NV_Nam.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textMa_TK_NV_Nam.setOpaque(false);
		textMa_TK_NV_Nam.setColumns(10);
		textMa_TK_NV_Nam.setBounds(124, 27, 229, 30);
		panel_TitleNgayTKHD_1_1.add(textMa_TK_NV_Nam);

		textTen_TK_NV_Nam = new JTextField();
		textTen_TK_NV_Nam.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textTen_TK_NV_Nam.setOpaque(false);
		textTen_TK_NV_Nam.setColumns(10);
		textTen_TK_NV_Nam.setBounds(132, 79, 221, 30);
		panel_TitleNgayTKHD_1_1.add(textTen_TK_NV_Nam);
		// Table NV nam TKHD		
		JPanel panel_tableNamTKHD = new JPanel();
		panel_tableNamTKHD.setLayout(null);
		panel_tableNamTKHD.setBounds(10, 136, 363, 300);
		panelNV_NamTKHD.add(panel_tableNamTKHD);

		JTable tableNamhdTKHD;
		tableNamhdTKHD = new JTable();	
		String []headertTKHD2 = "Mã nhân viên;Tên nhân viên".split(";");
		DefaultTableModel model_NV_TK_Nam = new DefaultTableModel(headertTKHD2,0);

		JScrollPane scrolltTKHD2;
		scrolltTKHD2 = new JScrollPane();
		scrolltTKHD2.setBorder(null);
		scrolltTKHD2.setBounds(10, 10, 343, 290);
		scrolltTKHD2.setViewportView(table_TK_NV_Nam = new JTable(model_NV_TK_Nam));
		table_TK_NV_Nam.setRowHeight(25);
		table_TK_NV_Nam.setAutoCreateRowSorter(true);
		table_TK_NV_Nam.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table_TK_NV_Nam.setLayout(null);
		panel_tableNamTKHD.setLayout(null);
		panel_tableNamTKHD.add(scrolltTKHD2);
		loadDataTKNV(model_NV_TK_Nam, listNV);

		JLabel lblNgayTKHD_1_1 = new JLabel("Chọn năm :");
		lblNgayTKHD_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayTKHD_1_1.setBounds(10, 10, 128, 28);
		panelNamTKHD.add(lblNgayTKHD_1_1);

		JPanel panelNamSoTKHD = new JPanel();
		panelNamSoTKHD.setLayout(null);
		panelNamSoTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNamSoTKHD.setBounds(403, 10, 200, 140);
		panelNamTKHD.add(panelNamSoTKHD);

		JLabel lblNewLabel_3_1_1 = new JLabel("Số hóa đơn\r\n");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(10, 10, 180, 19);
		panelNamSoTKHD.add(lblNewLabel_3_1_1);

		JLabel lbl_NV_TK_SHD_Nam = new JLabel();
		lbl_NV_TK_SHD_Nam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NV_TK_SHD_Nam.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lbl_NV_TK_SHD_Nam.setBounds(10, 39, 180, 91);
		panelNamSoTKHD.add(lbl_NV_TK_SHD_Nam);

		JPanel panelNamDtTKHD = new JPanel();
		panelNamDtTKHD.setLayout(null);
		panelNamDtTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNamDtTKHD.setBounds(613, 10, 422, 140);
		panelNamTKHD.add(panelNamDtTKHD);

		JLabel lblNewLabel_5_1_1 = new JLabel("Doanh thu");
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_5_1_1.setBounds(10, 10, 402, 22);
		panelNamDtTKHD.add(lblNewLabel_5_1_1);

		JLabel lbl_NV_TK_DT_Nam = new JLabel();
		lbl_NV_TK_DT_Nam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NV_TK_DT_Nam.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lbl_NV_TK_DT_Nam.setBounds(10, 42, 402, 88);
		panelNamDtTKHD.add(lbl_NV_TK_DT_Nam);

		JPanel panel_Table_nHdTKHD = new JPanel();
		panel_Table_nHdTKHD.setLayout(null);
		panel_Table_nHdTKHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Table_nHdTKHD.setBounds(403, 160, 632, 334);
		panelNamTKHD.add(panel_Table_nHdTKHD);

		JTable tableNamhdTKHD2;
		tableNamhdTKHD2 = new JTable();	
		String []headernaTKHD = "Mã HD;Mã KH;Tên KH;SDT KH;Tổng tiền;Ngay".split(";");
		DefaultTableModel model_NV_HD_Nam = new DefaultTableModel(headernaTKHD,0);

		JScrollPane scrollnaTKHD;
		scrollnaTKHD = new JScrollPane();
		scrollnaTKHD.setBorder(null);
		scrollnaTKHD.setBounds(10, 10, 612, 314);
		scrollnaTKHD.setViewportView(table_TK_HD_Nam = new JTable(model_NV_HD_Nam));
		table_TK_HD_Nam.setRowHeight(25);
		table_TK_HD_Nam.setAutoCreateRowSorter(true);
		table_TK_HD_Nam.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table_TK_HD_Nam.setLayout(null);
		panel_Table_nHdTKHD.setLayout(null);
		panel_Table_nHdTKHD.add(scrollnaTKHD);

		JYearChooser yearChooser_TK_NV_Nam = new JYearChooser();
		yearChooser_TK_NV_Nam.setBounds(148, 10, 136, 28);
		panelNamTKHD.add(yearChooser_TK_NV_Nam);



		JLabel lblTitleTKHD = new JLabel("Thống kê hóa đơn");
		lblTitleTKHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleTKHD.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitleTKHD.setBounds(10, 23, 803, 46);
		panel_TK2.add(lblTitleTKHD);
		
				JButton btnTKDT = new JButton("Thống kê doanh thu >>");
				btnTKDT.setBounds(860, 10, 200, 40);
				panel_TK2.add(btnTKDT);
				btnTKDT.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnTKDT.setBackground(UIManager.getColor("Button.background"));
				btnTKDT.setIcon(new ImageIcon("image/US-dollar-icon.png"));
				btnTKDT.setHorizontalAlignment(SwingConstants.LEADING);
				btnTKDT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tab_Main.setSelectedIndex(3);
					}
				});

		JPanel panel_GD = new JPanel();
		panel_GD.setBackground(new Color(255, 255, 255));
		tab_Main.addTab("New tab", null, panel_GD, null);
		panel_GD.setLayout(null);

		JTabbedPane tab_GD = new JTabbedPane(JTabbedPane.TOP);
		tab_GD.setBounds(10, -27, 1060, 667);
		panel_GD.add(tab_GD);

		JPanel panel_GD_SP = new JPanel();
		tab_GD.addTab("New tab", null, panel_GD_SP, null);
		panel_GD_SP.setLayout(new BoxLayout(panel_GD_SP, BoxLayout.X_AXIS));



		JPanel panel_GD_NV = new JPanel();
		tab_GD.addTab("New tab", null, panel_GD_NV, null);

		JPanel panel_GD_NCC = new JPanel();
		tab_GD.addTab("New tab", null, panel_GD_NCC, null);

		JPanel panel_GD_TK = new JPanel();
		tab_GD.addTab("New tab", null, panel_GD_TK, null);

		//----------------


		//-------------------------------Sự kiện Tác vụ-------------------------------
		btn_M_QLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_Main.setSelectedIndex(0);
			}
		});
		btn_M_QLSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_M_QLSP.setBackground(Color.WHITE);
				btnmnQLNV.setBackground(new Color(0,191,255));
				btnmnQLNCC.setBackground(new Color(0,191,255));
				btnmnTK.setBackground(new Color(0,191,255));
				btnmnGD.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btn_M_QLSP.getBackground().equals(new Color(0,191,255))) {
					btn_M_QLSP.setBackground(new Color(30,144,255));
				}
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btn_M_QLSP.getBackground().equals(new Color(30,144,255))) {
					btn_M_QLSP.setBackground(new Color(0,191,255));
				}
			}
		});
		btnmnQLNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_Main.setSelectedIndex(1);
			}
		});
		btnmnQLNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnmnQLNV.setBackground(Color.WHITE);
				btn_M_QLSP.setBackground(new Color(0,191,255));			
				btnmnQLNCC.setBackground(new Color(0,191,255));
				btnmnTK.setBackground(new Color(0,191,255));
				btnmnGD.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnmnQLNV.getBackground().equals(new Color(0,191,255))) {
					btnmnQLNV.setBackground(new Color(30,144,255));
				}
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnmnQLNV.getBackground().equals(new Color(30,144,255))) {
					btnmnQLNV.setBackground(new Color(0,191,255));
				}
			}
		});
		btnmnQLNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_Main.setSelectedIndex(2);
			}
		});
		btnmnQLNCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnmnQLNCC.setBackground(Color.WHITE);
				btn_M_QLSP.setBackground(new Color(0,191,255));
				btnmnQLNV.setBackground(new Color(0,191,255));	
				btnmnTK.setBackground(new Color(0,191,255));
				btnmnGD.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnmnQLNCC.getBackground().equals(new Color(0,191,255))) {
					btnmnQLNCC.setBackground(new Color(30,144,255));
				}
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnmnQLNCC.getBackground().equals(new Color(30,144,255))) {
					btnmnQLNCC.setBackground(new Color(0,191,255));
				}
			}
		});
		btnmnTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab_Main.setSelectedIndex(3);
			}
		});
		btnmnTK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnmnTK.setBackground(Color.WHITE);
				btn_M_QLSP.setBackground(new Color(0,191,255));
				btnmnQLNV.setBackground(new Color(0,191,255));
				btnmnQLNCC.setBackground(new Color(0,191,255));		
				btnmnGD.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnmnTK.getBackground().equals(new Color(0,191,255))) {
					btnmnTK.setBackground(new Color(30,144,255));
				}
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnmnTK.getBackground().equals(new Color(30,144,255))) {
					btnmnTK.setBackground(new Color(0,191,255));
				}
			}
		});
		btnmnGD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				tab_Main.setSelectedIndex(5);
				runFile.run("HD/HTML/html1.html");
			}
		});
		btnmnGD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnmnGD.setBackground(Color.WHITE);
				btn_M_QLSP.setBackground(new Color(0,191,255));
				btnmnQLNV.setBackground(new Color(0,191,255));
				btnmnQLNCC.setBackground(new Color(0,191,255));
				btnmnTK.setBackground(new Color(0,191,255));				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnmnGD.getBackground().equals(new Color(0,191,255))) {
					btnmnGD.setBackground(new Color(30,144,255));
				}
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnmnGD.getBackground().equals(new Color(30,144,255))) {
					btnmnGD.setBackground(new Color(0,191,255));
				}
			}
		});
		btn_XemChiTietSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma =" ";
				int ii = tab_SP.getSelectedIndex();
				if(ii==0) {
					if(tableTatCaSP.getSelectedRow()!=-1) {
						ma = model1SP.getValueAt(tableTatCaSP.getSelectedRow(), 0).toString();					
						new FormChiTietSanPham(dao_SP.getSanPham_Ma(ma)).setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sản phẩm");
					}
				}
				if(ii==1) {
					if(tableSapHetSP.getSelectedRow()!=-1) {
						ma = model2SP.getValueAt(tableSapHetSP.getSelectedRow(), 0).toString();

						new FormChiTietSanPham(dao_SP.getSanPham_Ma(ma)).setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sản phẩm");
					}
				}
			}
		});
		text_MaSP.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<SanPham> listSPsk = dao_SP.getAllSanPham_V2_1(text_MaSP.getText());
				loadDataQLSP1(model1SP, listSPsk);
				loadDataQLSP2(model2SP, listSPsk);

			}
		});
		text_TenSP.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();

			}
			public void all() {
				ArrayList<SanPham> listSPsk = dao_SP.getAllSanPham_V2_2(text_TenSP.getText());

				loadDataQLSP1(model1SP, listSPsk);
				loadDataQLSP2(model2SP, listSPsk);

			}
		});
		comboBoxTH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th = (String) comboBoxTH.getSelectedItem();	
				String xx = (String) comboBoxXX.getSelectedItem();			
				String cl = (String) comboBoxCL.getSelectedItem();
				String loai = (String) comboBox_LoaiSP.getSelectedItem();
				String tt = (String) comboBoxTT.getSelectedItem();
				if(th.equalsIgnoreCase("Tất cả")) th="";
				if(xx.equalsIgnoreCase("Tất cả")) xx="";
				if(cl.equalsIgnoreCase("Tất cả")) cl="";
				if(loai.equalsIgnoreCase("Tất cả")) loai="";
				if(tt.equalsIgnoreCase("Tất cả")) tt="";
				
				ArrayList<SanPham> list = dao_SP.getAllSanPham_V2(th, xx, cl, loai, tt);
				loadDataQLSP1(model1SP, list);

			}

		});
		comboBoxXX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th = (String) comboBoxTH.getSelectedItem();	
				String xx = (String) comboBoxXX.getSelectedItem();			
				String cl = (String) comboBoxCL.getSelectedItem();
				String loai = (String) comboBox_LoaiSP.getSelectedItem();
				String tt = (String) comboBoxTT.getSelectedItem();
				if(th.equalsIgnoreCase("Tất cả")) th="";
				if(xx.equalsIgnoreCase("Tất cả")) xx="";
				if(cl.equalsIgnoreCase("Tất cả")) cl="";
				if(loai.equalsIgnoreCase("Tất cả")) loai="";
				if(tt.equalsIgnoreCase("Tất cả")) tt="";
				
				ArrayList<SanPham> list = dao_SP.getAllSanPham_V2(th, xx, cl, loai, tt);
				loadDataQLSP1(model1SP, list);
		
			}
		});
		comboBoxCL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th = (String) comboBoxTH.getSelectedItem();	
				String xx = (String) comboBoxXX.getSelectedItem();			
				String cl = (String) comboBoxCL.getSelectedItem();
				String loai = (String) comboBox_LoaiSP.getSelectedItem();
				String tt = (String) comboBoxTT.getSelectedItem();
				if(th.equalsIgnoreCase("Tất cả")) th="";
				if(xx.equalsIgnoreCase("Tất cả")) xx="";
				if(cl.equalsIgnoreCase("Tất cả")) cl="";
				if(loai.equalsIgnoreCase("Tất cả")) loai="";
				if(tt.equalsIgnoreCase("Tất cả")) tt="";
				
				ArrayList<SanPham> list = dao_SP.getAllSanPham_V2(th, xx, cl, loai, tt);
				loadDataQLSP1(model1SP, list);
				
			}
		});
		comboBoxTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th = (String) comboBoxTH.getSelectedItem();	
				String xx = (String) comboBoxXX.getSelectedItem();			
				String cl = (String) comboBoxCL.getSelectedItem();
				String loai = (String) comboBox_LoaiSP.getSelectedItem();
				String tt = (String) comboBoxTT.getSelectedItem();
				if(th.equalsIgnoreCase("Tất cả")) th="";
				if(xx.equalsIgnoreCase("Tất cả")) xx="";
				if(cl.equalsIgnoreCase("Tất cả")) cl="";
				if(loai.equalsIgnoreCase("Tất cả")) loai="";
				if(tt.equalsIgnoreCase("Tất cả")) tt="";
				
				ArrayList<SanPham> list = dao_SP.getAllSanPham_V2(th, xx, cl, loai, tt);
				loadDataQLSP1(model1SP, list);
			}
		});
		comboBox_LoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th = (String) comboBoxTH.getSelectedItem();	
				String xx = (String) comboBoxXX.getSelectedItem();			
				String cl = (String) comboBoxCL.getSelectedItem();
				String loai = (String) comboBox_LoaiSP.getSelectedItem();
				String tt = (String) comboBoxTT.getSelectedItem();
				String sh = (String) comboBoxSPSH.getSelectedItem();
				if(th.equalsIgnoreCase("Tất cả")) th="";
				if(xx.equalsIgnoreCase("Tất cả")) xx="";
				if(cl.equalsIgnoreCase("Tất cả")) cl="";
				if(loai.equalsIgnoreCase("Tất cả")) loai="";
				if(tt.equalsIgnoreCase("Tất cả")) tt="";
				int i =0;
				if(sh.equalsIgnoreCase("Sắp hết (Số lượng <50)")) i=1;
				ArrayList<SanPham> list = dao_SP.getAllSanPham_V2(th, xx, cl, loai, tt);
				loadDataQLSP1(model1SP, list);
				ArrayList<SanPham> listSk = dao_SP.getAllSanPham_V2_SM(loai);
				if(i==0) loadDataQLSP2(model2SP, listSk);
				else loadDataQLSP22(model2SP, listSk);
				
				
			}
		});
		comboBoxSPSH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loai = (String) comboBox_LoaiSP.getSelectedItem();
				String sh = (String) comboBoxSPSH.getSelectedItem();
				if(loai.equalsIgnoreCase("Tất cả")) loai="";
				int i =0;
				if(sh.equalsIgnoreCase("Sắp hết (Số lượng <50)")) i=1;
				ArrayList<SanPham> listSk = dao_SP.getAllSanPham_V2_SM(loai);
				if(i==0) loadDataQLSP2(model2SP, listSk);
				else loadDataQLSP22(model2SP, listSk);
			}
		});
		btn_LamMoi_SP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<SanPham> listSk = dao_SP.getAllSanPhamV2();
				loadDataQLSP1(model1SP, listSk);
				loadDataQLSP2(model2SP, listSk);
			}
		});
		comboBox_TT_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str =(String) comboBox_TT_NhanVien.getSelectedItem();
				if(str.equalsIgnoreCase("Tất cả")) {
					ArrayList<NhanVien> listskNV = dao_NV.getAllNhanVien2();
					loadDataQLNV(modelDsNV, listskNV);
				}
				else {
					ArrayList<NhanVien> listskNV = dao_NV.getAllNhanVien_TT(str);
					loadDataQLNV(modelDsNV, listskNV);
				}
				
			}
		});
		text_MaNV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				text_MaNV.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {

			}
		});
		text_MaNV.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhanVien> arrNV = dao_NV.timKiemMaNV(text_MaNV.getText());
				loadDataQLNV(modelDsNV, arrNV);
			}
		});
		txt_TenNV.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhanVien> arrTenNV = dao_NV.timKiemTenNV(txt_TenNV.getText());
				loadDataQLNV(modelDsNV, arrTenNV);
			}
		});
		text_SdtNV.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhanVien> arrTenNV = dao_NV.timKiemsdtNV(text_SdtNV.getText());
				loadDataQLNV(modelDsNV, arrTenNV);
			}
		});
		txt_TenNV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_TenNV.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {

			}
		});	
		text_SdtNV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				text_SdtNV.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		
		btn_LamMoi_NV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<NhanVien> arrNVsuKien = dao_NV.getAllNhanVien();
				loadDataQLNV(modelDsNV, arrNVsuKien);

				panel_NV_CaLam.removeAll();
				panel_NV_CaLam.repaint();
				ArrayList<CaLam> arrCalam = new ArrayList<CaLam>();
				arrCalam = dao_Calam.getAllCaLam2();

				modelCalam = new DefaultTableModel();	
				tableCalam = new JTable(modelCalam);
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
				TableColumn tbc1 = tableCalam.getColumnModel().getColumn(1);
				TableColumn tbc2 = tableCalam.getColumnModel().getColumn(2);
				TableColumn tbc3 = tableCalam.getColumnModel().getColumn(3);
				TableColumn tbc4 = tableCalam.getColumnModel().getColumn(4);
				TableColumn tbc5 = tableCalam.getColumnModel().getColumn(5);
				TableColumn tbc6 = tableCalam.getColumnModel().getColumn(6);
				TableColumn tbc7 = tableCalam.getColumnModel().getColumn(7);
				tbc1.setCellEditor(new DefaultCellEditor(cbbSang));
				tbc2.setCellEditor(new DefaultCellEditor(cbbSang));
				tbc3.setCellEditor(new DefaultCellEditor(cbbSang));
				tbc4.setCellEditor(new DefaultCellEditor(cbbSang));
				tbc5.setCellEditor(new DefaultCellEditor(cbbSang));
				tbc6.setCellEditor(new DefaultCellEditor(cbbSang));
				tbc7.setCellEditor(new DefaultCellEditor(cbbSang));
				JScrollPane scrollPane = new JScrollPane(tableCalam);
				scrollPane.setLocation(0, 0);
				scrollPane.setSize(1052, 120);
				tableCalam.setEnabled(false);
				tableCalam.setRowHeight(48);
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
				panel_NV_CaLam.add(scrollPane);
				
				panel_NV_CaLam.repaint();
				panel_NV_CaLam.revalidate();

			}
		});
		btnReNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<NhaCungCap> listNCCsk = dao_NCC.getAllNCC();
				loadDataNCC(modelNCC,listNCCsk);
			}
		});
		txtMaNCC.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhaCungCap> listNCCsk = dao_NCC.getDsMaNCC(txtMaNCC.getText());
				loadDataNCC(modelNCC,listNCCsk);
			}
		});
		txtTenMCC.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhaCungCap> listNCCsk = dao_NCC.getDsTenNCC(txtTenMCC.getText());
				loadDataNCC(modelNCC, listNCCsk);
			}
		});
		txtSdtNCC.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhaCungCap> listNCCsk = dao_NCC.getDsSdtNCC(txtSdtNCC.getText());
				loadDataNCC(modelNCC, listNCCsk);
			}
		});
		btn_TK_L_T.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearChooser_Thang.getValue();
				monthChooser_TD_TDT_Thang.getMonth();
				LocalDate lcd = LocalDate.of(yearChooser_Thang.getValue(), monthChooser_TD_TDT_Thang.getMonth()+1, 1);
				String str = currencyVN.format(dao_HD.TongDoanhThuThang(lcd));
				lbl_DT_TDT_Thang.setText(str);
				lbl_DT_THD_Thang.setText(dao_HD.TongHDThang(lcd)+"");
				panel_TableTK_Thang.removeAll();
				panel_TableTK_Thang.repaint();

				final DefaultCategoryDataset dataset_1 = new DefaultCategoryDataset();       
				for (int i=1;i<13;i++) {    	

					LocalDate lcdd =  LocalDate.of(yearChooser_Thang.getValue(), i, 1);
					dataset_1.addValue(dao_HD.TongHDThang(lcdd), "Số hóa đơn", i+"");
				}
				JFreeChart barChart_1 = ChartFactory.createBarChart(
						"Biểu đồ doanh thu","Tháng", "Số lượng hóa đơn",
						dataset_1, PlotOrientation.VERTICAL, false, false, false);
				panel_TableTK_Thang.setLayout(new GridLayout(0, 1, 0, 0));		

				ChartPanel chartPanel_1 = new ChartPanel(barChart_1);
				panel_TableTK_Thang.add(chartPanel_1);
				panel_TableTK_Thang.repaint();
				panel_TableTK_Thang.revalidate();
				ArrayList<SanPham> listSPThang = dao_SP.getSPBanChay_Thang(lcd);
				loadDataSPTK(modelspTK_1, listSPThang);

			}
		});
		btn_L_Nam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearChooser_DT_Nam.getValue();
				LocalDate lcd = LocalDate.of(yearChooser_DT_Nam.getValue(), 1, 1);
				String str = currencyVN.format(dao_HD.TongDoanhThuNam(lcd));
				lbl_DT_TDT_Nam.setText(str);
				lbl_DT_THD_Nam.setText(dao_HD.TongHDNam(lcd)+"");

				ArrayList<SanPham> list = dao_SP.getSPBanChay_Nam(lcd);
				loadDataSPTK(modelspTK_2, list);
			}
		});
		btn_TK_Ngay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try {
					LocalDate lcd = LocalDate.of(dateChooser_TK_Ngay.getDate().getYear()+1900,
							dateChooser_TK_Ngay.getDate().getMonth()+1, dateChooser_TK_Ngay.getDate().getDate());
					String str = currencyVN.format(dao_HD.TongDoanhThuNgay(lcd));
					lbl_DT_TDT_Ngay.setText(str);
					lbl_DT_THD_Ngay.setText(dao_HD.TongHDNgay(lcd)+"");
					ArrayList<SanPham> list =dao_SP.getSPBanChayNgay(lcd);
					loadDataSPTK(modelspTK, list);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Hay chọn ngày để thống kê");
				}
			}

		});
		txtMa_TK_NV_Ngay.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhanVien> lisNVsk = dao_NV.timKiemMaNV(txtMa_TK_NV_Ngay.getText());
				loadDataTKNV(modelnTKHD, lisNVsk);
			}
		});
		txtTen_TK_NV_Ngay.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhanVien> lisNVsk = dao_NV.timKiemTenNV(txtTen_TK_NV_Ngay.getText());
				loadDataTKNV(modelnTKHD, lisNVsk);
			}
		});
		table_NV_TKHD_Ngay.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//				int row = table_NV_TKHD_Ngay.getSelectedRow();
				//				int col = table_NV_TKHD_Ngay.getSelectedColumn();
				//				System.out.println(row+" "+col);
				String ma = (String) table_NV_TKHD_Ngay.getValueAt(table_NV_TKHD_Ngay.getSelectedRow(), 0);
				try {		
					LocalDate lcd = LocalDate.of(dateChooser_TK_NV_Ngay.getDate().getYear()+1900,
							dateChooser_TK_NV_Ngay.getDate().getMonth()+1, dateChooser_TK_NV_Ngay.getDate().getDate());
					loadDataHDTK(modelnhdTKHD, dao_HD.getHD_TK_Ngay(ma,lcd ));
					String str = currencyVN.format(dao_HD.TongDoanhThuNgay_NV(lcd, ma));
					lbl_TK_NV_DT_Ngay.setText(str);
					lbl_TK_NV_SDH_Ngay.setText(dao_HD.TongHDNgay_NV(lcd, ma)+"");
				} catch (Exception e1) {
					loadDataHDTK(modelnhdTKHD, dao_HD.getHD_TK_Ngay(ma,currentDate ));
					String str = currencyVN.format(dao_HD.TongDoanhThuNgay_NV(currentDate, ma));
					lbl_TK_NV_DT_Ngay.setText(str);
					lbl_TK_NV_SDH_Ngay.setText(dao_HD.TongHDNgay_NV(currentDate, ma)+"");
				}
			}
		});
		textMa_TK_NV_Thang.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhanVien> lisNVsk = dao_NV.timKiemMaNV(textMa_TK_NV_Thang.getText());
				loadDataTKNV(model_TK_NV_thang, lisNVsk);
			}
		});
		textTen_TK_NV_Thang.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhanVien> lisNVsk = dao_NV.timKiemTenNV(textTen_TK_NV_Thang.getText());
				loadDataTKNV(model_TK_NV_thang, lisNVsk);
			}
		});
		table_TK_NV_Thang.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//				int row = table_NV_TKHD_Ngay.getSelectedRow();
				//				int col = table_NV_TKHD_Ngay.getSelectedColumn();
				//				System.out.println(row+" "+col);
				String ma = (String) table_TK_NV_Thang.getValueAt(table_TK_NV_Thang.getSelectedRow(), 0);	
				LocalDate lcd = LocalDate.of(yearChooser_TK_NV_Thang.getValue(),monthChooser_TK_NV_Thang.getMonth()+1,2);
				loadDataHDTK(model_TK_HD_Thang, dao_HD.getHD_TK_Thang(ma,lcd ));
				String str = currencyVN.format(dao_HD.TongDoanhThuThang_NV(lcd, ma));
				lbl_NV_TK_DT_Thang.setText(str);
				lbl_NV_TK_SHD_Thang.setText(dao_HD.TongHDThang_NV(lcd, ma)+"");

			}
		});
		textMa_TK_NV_Nam.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhanVien> lisNVsk = dao_NV.timKiemMaNV(textMa_TK_NV_Nam.getText());
				loadDataTKNV(model_NV_TK_Nam, lisNVsk);
			}
		});
		textTen_TK_NV_Nam.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				all();
			}
			public void all() {
				ArrayList<NhanVien> lisNVsk = dao_NV.timKiemTenNV(textTen_TK_NV_Nam.getText());
				loadDataTKNV(model_NV_TK_Nam, lisNVsk);
			}
		});
		table_TK_NV_Nam.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String ma = (String) table_TK_NV_Nam.getValueAt(table_TK_NV_Nam.getSelectedRow(), 0);
				try {		
					LocalDate lcd = LocalDate.of(yearChooser_TK_NV_Nam.getValue(),
							7, 8);
					loadDataHDTK(model_NV_HD_Nam, dao_HD.getHD_TK_Nam(ma,lcd ));
					String str = currencyVN.format(dao_HD.TongDoanhThuNam_NV(lcd, ma));
					lbl_NV_TK_DT_Nam.setText(str);
					lbl_NV_TK_SHD_Nam.setText(dao_HD.TongHDNam_NV(lcd, ma)+"");
				} catch (Exception e1) {
					System.out.println("loi");
				}
			}
		});
		table_TK_NV_Thang.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String ma = (String) table_TK_NV_Thang.getValueAt(table_TK_NV_Thang.getSelectedRow(), 0);
				LocalDate lcd = LocalDate.of(yearChooser_TK_NV_Thang.getValue(),monthChooser_TK_NV_Thang.getMonth()+1,2);
				loadDataHDTK(model_TK_HD_Thang, dao_HD.getHD_TK_Thang(ma,lcd ));
				String str = currencyVN.format(dao_HD.TongDoanhThuThang_NV(lcd, ma));
				lbl_NV_TK_DT_Thang.setText(str);
				lbl_NV_TK_SHD_Thang.setText(dao_HD.TongHDThang_NV(lcd, ma)+"");

			}
		});
		tableNCC.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String ma = (String) tableNCC.getValueAt(tableNCC.getSelectedRow(), 0);
				loadDataQLSP3_NCC(model3SP, listSP, ma);



			}
		});
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  i = JOptionPane.showConfirmDialog(null,"Đăng xuất" );
				if(i==JOptionPane.YES_OPTION) {
					new DangNhap().setVisible(true);
					dispose();
				}		
			}
		});
		lbl_TT_NV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TaiKhoan tk = new TaiKhoan();
				for(TaiKhoan tkk:dao_TK.getAllTaiKhoan()) {
					if(tkk.getId().equalsIgnoreCase(nv.getMaNV())) {
						tk= tkk;
						System.out.println(tk);
					}
				}
				tk.setMaNV(nv);
				new Form_TT_NV(nv, tk).setVisible(true);
			}
		});
		//------------------Menu--------------------------
		mn_SP_ThemN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel importDataFromExcelModel = (DefaultTableModel) tableTatCaSP.getModel();
				DefaultTableModel importDataSize = (DefaultTableModel) tableSapHetSP.getModel();
				DAO_XuatXu xx = new DAO_XuatXu();
				DAO_ChatLieu cl = new DAO_ChatLieu();
				DAO_ThuongHieu th = new DAO_ThuongHieu();
				DAO_NhaCungCap ncc = new DAO_NhaCungCap();
				//importDataFromExcelModel.setRowCount(0);

				FileInputStream fileInput = null;
				BufferedInputStream excelBuff = null;
				XSSFWorkbook excelImportWorkBook = null;

				String filePath = "";
				JFileChooser file = new JFileChooser(filePath);

				FileNameExtensionFilter excelfnef = new FileNameExtensionFilter("EXCEL FILES", "xls","xlsx");
				file.addChoosableFileFilter(excelfnef);

				int fileChoser = file.showOpenDialog(null);

				if (fileChoser == JFileChooser.APPROVE_OPTION) {
					try {
						File excelFile = file.getSelectedFile();
						fileInput = new FileInputStream(excelFile);
						excelBuff = new BufferedInputStream(fileInput);
						excelImportWorkBook = new XSSFWorkbook(excelBuff);
						XSSFSheet sheet = excelImportWorkBook.getSheetAt(0);
						ArrayList<ChiTietSanPham> list = new ArrayList<ChiTietSanPham>();
						for (int i = 0; i <=sheet.getLastRowNum();i++) {
							String textMaSP = getMaMoi(dao_SP.getAllSanPham());
							XSSFRow excelRow = sheet.getRow(i);
							XSSFCell excelCellName = excelRow.getCell(0);
							XSSFCell excelCellThuongHieu = excelRow.getCell(1);
							XSSFCell excelCellXuatXu = excelRow.getCell(2);
							XSSFCell excelCellChatLieu = excelRow.getCell(3);
							XSSFCell excelCellGioiTinh = excelRow.getCell(4);
							XSSFCell excelCellLoai = excelRow.getCell(5);
							XSSFCell excelCellGiaGoc = excelRow.getCell(6);
							XSSFCell excelCellSize = excelRow.getCell(7);
							XSSFCell excelCellMau = excelRow.getCell(8);
							XSSFCell excelCellNCC = excelRow.getCell(9);
////							System.out.println(excelCellChatLieu.toString());
////							System.out.println(excelCellThuongHieu.toString());
							String sizeDo = excelCellSize.toString().trim();
							String [] cat = sizeDo.split(",");
							for (String item:cat) {
								sizeDo = item;
							}
							String maXX = xx.getMaXXTheoTen(excelCellXuatXu.toString()).toString();
//							System.out.println(maXX);
//
							String maTH = th.getMaTHTheoTen(excelCellThuongHieu.toString()).toString();
////							System.out.println(maTH);
//							
							String maCL = cl.getMaCLTheoTen(excelCellChatLieu.toString()).toString();
////							System.out.println(maCL);
//
							ChiTietSanPham spct = new ChiTietSanPham(getCTMoi(list,textMaSP,sizeDo),textMaSP, sizeDo, excelCellMau.toString(),100);
							list.add(spct);
							SanPham sp = new SanPham(textMaSP,excelCellName.toString(),
									Double.parseDouble(excelCellGiaGoc.toString()), " "," ", 
									excelCellGioiTinh.toString().trim(), " ",excelCellLoai.toString().trim(), 
									" ", 0, new ChatLieu(maCL), new ThuongHieu(maTH), 
									new XuatXu(maXX), new NhaCungCap("NCC0001"),"Còn bán", list);
//							System.out.println(sp.toString());
							dao_SP.themMoi_SP(sp);
//					
//							model1SP.addRow(new Object[] {textMaSP,excelCellName,excelCellThuongHieu,excelCellXuatXu,excelCellChatLieu,excelCellGioiTinh,excelCellLoai,excelCellGiaGoc,"Còn bán"});
//							model2SP.addRow(new Object[] {textMaSP,getCTMoi(list, textMaSP, sizeDo),excelCellName,excelCellMau,excelCellSize,100,excelCellLoai,excelCellNCC});
//							
					}
//						
						
					}catch(FileNotFoundException f) {
						System.err.println("?");
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						System.err.println("?");
					}
					JOptionPane.showMessageDialog(null, "Import Successfully");
				}
			}
		});
		mn_SP_Them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FormThemMoiSanPham().setVisible(true);
			}
		});
		mn_SP_CN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ma =" ";
				int ii = tab_SP.getSelectedIndex();
				tab_SP.setSelectedIndex(0);
				if(ii==0) {
					if(tableTatCaSP.getSelectedRow()!=-1) {
						ma = model1SP.getValueAt(tableTatCaSP.getSelectedRow(), 0).toString();	
						if(dao_SP.getSanPham_Ma(ma).getTinhTrang().equalsIgnoreCase("Ngừng bán")) {
							JOptionPane.showMessageDialog(null, "Sản phẩm đã ngừng bán");
						}
						else {
							new FormCapNhatSP(dao_SP.getSanPham_Ma(ma)).setVisible(true);
						}		
					}
					else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sản phẩm");
					}
				}	
			}
		});
		mn_SP_CTT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableTatCaSP.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sản phẩm");
				}
				else {
					Object[] options = {"Còn bán","Ngừng bán",};
					int n = JOptionPane.showOptionDialog(null,"Chọn trạng thái muốn chuyển","Trạng thái",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
					String ma = model1SP.getValueAt(tableTatCaSP.getSelectedRow(), 0).toString();
					System.out.println(n);
					SanPham spsk = dao_SP.getSanPham_Ma(ma);
					if(n==1) {
						spsk.setTinhTrang("Ngừng bán");
						dao_SP.capNhat_SP(spsk);
						JOptionPane.showMessageDialog(null, "Chuyển thành công");
						ArrayList<SanPham> listSP = dao_SP.getAllSanPhamV2();
						loadDataQLSP1(model1SP,listSP);
					}
					else if(n==0) {
						spsk.setTinhTrang("Còn bán");
						dao_SP.capNhat_SP(spsk);
						JOptionPane.showMessageDialog(null, "Chuyển thành công");
						ArrayList<SanPham> listSP = dao_SP.getAllSanPhamV2();
						loadDataQLSP1(model1SP,listSP);
					}
				}
			}
		});
		mn_NV_Them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<NhanVien> dsNV = dao_NV.getAllNhanVien();			
				new FormThemNV().setVisible(true);
			}
		});
		mn_NV_CN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table_NV.getSelectedRow()!=-1) {
					int r = table_NV.getSelectedRow();
					String maNVsk = modelDsNV.getValueAt(r, 0).toString();
					NhanVien nvv = new NhanVien();
					for(NhanVien nv :dao_NV.getAllNhanVien()) {
						if(nv.getMaNV().equalsIgnoreCase(maNVsk)) {
							nvv=nv;
						}
					}
					TaiKhoan tk = new TaiKhoan();
					for(TaiKhoan tkk:dao_TK.getAllTaiKhoan()) {
						if(tkk.getId().equalsIgnoreCase(maNVsk)) {
							tk= tkk;
						}
					}
					tk.setMaNV(nvv);
					new FormSuaNV(nvv, tk).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Hãy chọn một nhân viên");
				}
			}
		});
		mn_NV_X.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table_NV.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null,"Hãy chọn một nhân viên");
				}
				else {
					Object[] options = {"Đang làm","Nghỉ việc"};
					int n = JOptionPane.showOptionDialog(null,"Chọn trạng thái muốn chuyển","Trạng thái",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
					String ma = modelDsNV.getValueAt(table_NV.getSelectedRow(), 0).toString();
					NhanVien nv = dao_NV.getNhanVienMa(ma);	
					if(n==1) {
						nv.setTinhTrang("Nghỉ việc");
						dao_NV.updateNV(nv);
						JOptionPane.showMessageDialog(null, "Chuyển thành công");
						ArrayList<NhanVien> listsk = dao_NV.getAllNhanVien();
						loadDataQLNV(modelDsNV, listsk);
					}
					else if(n==0) {
						nv.setTinhTrang("Đang làm");
						dao_NV.updateNV(nv);
						JOptionPane.showMessageDialog(null, "Chuyển thành công");
						ArrayList<NhanVien> listsk = dao_NV.getAllNhanVien();
						loadDataQLNV(modelDsNV, listsk);
					}
				}
					
//					int r = table_NV.getSelectedRow();
//					String maNVsk = modelDsNV.getValueAt(r, 0).toString();
//					try {
//						int i=JOptionPane.showConfirmDialog(null,"Xác nhận chon nhân viên nghỉ làm ?");
//						if(i==JOptionPane.OK_OPTION) {
//							dao_NV.deleteNV2(maNVsk);
//							ArrayList<NhanVien> arrNVsuKien = dao_NV.getAllNhanVien();
//							loadDataQLNV(modelDsNV, arrNVsuKien);
//						}			
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						System.err.println("loi");
//					}
//				}
//				else {
//					
//				}
//				if(tableTatCaSP.getSelectedRow()==-1) {
//					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sản phẩm");
//				}
//				else {
//					Object[] options = {"Còn bán","Ngừng bán",};
//					int n = JOptionPane.showOptionDialog(null,"Chọn trạng thái muốn chuyển","Trạng thái",
//					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
//					String ma = model1SP.getValueAt(tableTatCaSP.getSelectedRow(), 0).toString();
//					System.out.println(n);
//					SanPham spsk = dao_SP.getSanPham_Ma(ma);
//					if(n==1) {
//						spsk.setTinhTrang("Ngừng bán");
//						dao_SP.capNhat_SP(spsk);
//						JOptionPane.showMessageDialog(null, "Chuyển thành công");
//						ArrayList<SanPham> listSP = dao_SP.getAllSanPhamV2();
//						loadDataQLSP1(model1SP,listSP);
//					}
//					else if(n==0) {
//						spsk.setTinhTrang("Còn bán");
//						dao_SP.capNhat_SP(spsk);
//						JOptionPane.showMessageDialog(null, "Chuyển thành công");
//						ArrayList<SanPham> listSP = dao_SP.getAllSanPhamV2();
//						loadDataQLSP1(model1SP,listSP);
//					}
//				}

			}
			
		});
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FormThemNCC().setVisible(true);
			}
		});
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableNCC.getSelectedRow()!=-1) {
					int r = tableNCC.getSelectedRow();
					String maNCC = modelNCC.getValueAt(r, 0).toString();
					ArrayList<NhaCungCap> listNCC =dao_NCC.getAllNCC();
					NhaCungCap nccSk = new NhaCungCap();
					for(NhaCungCap ncc:listNCC) {
						if(ncc.getMaNCC().equalsIgnoreCase(maNCC)) {
							nccSk=ncc;
							break;
						}
					}
					new FormCapNhatNCC(nccSk).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Hãy chọn một nhà cung cấp");
				}
			}
		});

	}
	


	//----------------------------load Data---------------------------------------------------
	private void loadDataNCC(DefaultTableModel modelNCC, ArrayList<NhaCungCap> listNCC) {
		// TODO Auto-generated method stub
		dao_NCC = new DAO_NhaCungCap();
		modelNCC.setRowCount(0);
		for(NhaCungCap ncc: listNCC) {
			String[] row = {ncc.getMaNCC(),ncc.getTenNCC(),ncc.getSoDienThoai(),ncc.getDiaChi()};
			modelNCC.addRow(row);
		}

	}
	private void loadDataQLNV(DefaultTableModel modelQLNV, ArrayList<NhanVien> listNV) {
		// TODO Auto-generated method stub
		//if(listNV.isEmpty()) return;
		modelQLNV.setRowCount(0);
		for(NhanVien nv: listNV) {
			String pattern = "dd-MM-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String ns = simpleDateFormat.format(nv.getNgaySinh());
			String nvl = simpleDateFormat.format(nv.getNgayVaoLam());
			String[] row = {nv.getMaNV(),nv.getTenNV(),nv.getSoDienThoai(),
					nv.getDiaChi(),nv.getChucVu(),nv.getGioiTinh(),ns,
					nvl,nv.getTinhTrang() };
			modelQLNV.addRow(row);
		}

	}
	private void loadDataTKNV(DefaultTableModel modelNV, ArrayList<NhanVien> listNV) {
		// TODO Auto-generated method stub
		modelNV.setRowCount(0);
		for(NhanVien nv: listNV) {
			String[] row = {nv.getMaNV(),nv.getTenNV()};
			modelNV.addRow(row);
		}

	}
	private void loadDataQLSP1(DefaultTableModel modelQLSP1, ArrayList<SanPham> list) {
		// TODO Auto-generated method stub
		modelQLSP1.setRowCount(0);
		for(SanPham sp : list){
			String strGia = currencyVN.format(sp.getGiaGoc());
			String[] row = {sp.getMaSanPham(),sp.getTenSanPham(),sp.getThuongHieu().getTenTH()
					, sp.getXuatXu().getTenXX(),sp.getChatLieu().getTenCL(),sp.getGioiTinh()
					, sp.getLoai(),strGia , sp.getTinhTrang()};
			modelQLSP1.addRow(row);			
		}

	}
	private void loadDataQLSP2(DefaultTableModel modelQLSP2, ArrayList<SanPham> list) {
		// TODO Auto-generated method stub
		modelQLSP2.setRowCount(0);
		for(SanPham sp : list){
			for(ChiTietSanPham ct : sp.getChiTietSanPham()) {
				String[] row = {sp.getMaSanPham(),ct.getMaChiTietSanPham(),sp.getTenSanPham(),ct.getMau(),ct.getSize()
						,String.valueOf(ct.getSoLuong()),sp.getLoai(),sp.getNhaCungCap().getTenNCC()};
				modelQLSP2.addRow(row);	

			}
		}

	}
	private void loadDataQLSP22(DefaultTableModel modelQLSP2, ArrayList<SanPham> list) {
		// TODO Auto-generated method stub
		modelQLSP2.setRowCount(0);
		for(SanPham sp : list){
			for(ChiTietSanPham ct : sp.getChiTietSanPham()) {
				if(ct.getSoLuong()<50) {
					String[] row = {sp.getMaSanPham(),ct.getMaChiTietSanPham(),sp.getTenSanPham(),ct.getMau(),ct.getSize()
							,String.valueOf(ct.getSoLuong()),sp.getLoai(),sp.getNhaCungCap().getTenNCC()};
					modelQLSP2.addRow(row);	
				}
			}
		}

	}
	private void loadDataQLSP3(DefaultTableModel modelQLSP3, ArrayList<SanPham> list) {
		// TODO Auto-generated method stub
		//if(listNV.isEmpty()) return;
		modelQLSP3.setRowCount(0);
		for(SanPham sp : list){
			if(sp.getSoLuongLoi()>0) {
				String[] row = {sp.getMaSanPham(),sp.getTenSanPham(),sp.getLoai(),String.valueOf(sp.getSoLuongLoi())};
				modelQLSP3.addRow(row);		
			}

		}

	}
	private void loadDataQLSP3_NCC(DefaultTableModel modelQLSP3, ArrayList<SanPham> list,String mancc) {
		// TODO Auto-generated method stub
		//if(listNV.isEmpty()) return;
		modelQLSP3.setRowCount(0);
		for(SanPham sp : list){
			if(sp.getSoLuongLoi()>0&&sp.getNhaCungCap().getMaNCC().equalsIgnoreCase(mancc)) {
				String[] row = {sp.getMaSanPham(),sp.getTenSanPham(),
						sp.getLoai(),String.valueOf(sp.getSoLuongLoi())};
				modelQLSP3.addRow(row);		
			}
		}

	}
	private void loadDataSPTK(DefaultTableModel modelspTK, ArrayList<SanPham> list) {
		// TODO Auto-generated method stub
		modelspTK.setRowCount(0);
		int i = 1;
		for(SanPham sp : list){		
			String[] row = {i+"",sp.getTenSanPham(),sp.getSoLuongLoi()+""};
			modelspTK.addRow(row);	
			i++;
		}

	}
	private void loadDataHDTK(DefaultTableModel model, ArrayList<HoaDonBanHang> list) {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		for(HoaDonBanHang hd : list){		
			String[] row = {hd.getMaHoaDon(),hd.getMaKhachHang().getMaKhachHang(),
					hd.getMaKhachHang().getHoTenKhachHang(),hd.getMaKhachHang().getSoDienThoai(),
					hd.getTongTienHD()+"",hd.getNgayLapHoaDon().toString()};
			model.addRow(row);	
		}

	}
	private String getMaS(ArrayList<SanPham> list) {
		SanPham sp = list.get(list.size()-1);
		String ma = sp.getMaSanPham().substring(2);
		return ma;
	}
	private String getMaXX(ArrayList<XuatXu> list) {
		XuatXu xx = list.get(list.size()-1);
		String ma = xx.getMaXX();
		return ma;
	}
	private String getMaCL(ArrayList<ChatLieu> list) {
		ChatLieu cl = list.get(list.size()-1);
		String ma = cl.getMaCL();
		return ma;
	}
	private String getMaTH (ArrayList<ThuongHieu> list) {
		ThuongHieu th = list.get(list.size()-1);
		String ma = th.getMaTH();
		return ma;
	}
	private String getCTMoi(ArrayList<ChiTietSanPham> list, String ma,String size) {
		String str = ma ;
		if(list.isEmpty()) {
			return str +"-00"+1+"-"+size;
		}
		ChiTietSanPham ct = list.get(list.size()-1);
		String so = (String) ct.getMaChiTietSanPham().subSequence(7,10);
		int soMoi = Integer.parseInt(so)+1;
		String str2 =String.format("%03d", soMoi);
		return str+"-"+str2+"-"+size;
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
	private String getMaMoi(ArrayList<SanPham> list) {
		String str="";
		SanPham sp = list.get(list.size()-1);
		String ma = sp.getMaSanPham().substring(2);
		int ma3 = Integer.parseInt(ma);
		ma3+=1;
		str = String.format("%04d", ma3);
		return "SP"+str;
	}
}
