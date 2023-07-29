package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import database.ConnectDB;
import dao.DAO_ChatLieu;
import dao.DAO_NhaCungCap;
import dao.DAO_ThuongHieu;
import dao.DAO_XuatXu;
import dao.Dao_SanPham;
import entity.ChatLieu;
import entity.ChiTietSanPham;
import entity.NhaCungCap;
import entity.SanPham;
import entity.ThuongHieu;
import entity.XuatXu;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class FormCapNhatSP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_MaSP;
	private JTextField text_TenSP;
	private JTextField text_Gia;
	private JTextField text_S;

	Dao_SanPham dao_SP = new Dao_SanPham();
	DAO_ChatLieu dao_CL = new DAO_ChatLieu();
	DAO_ThuongHieu dao_TH = new DAO_ThuongHieu();
	DAO_XuatXu dao_XX = new DAO_XuatXu();
	DAO_NhaCungCap dao_NCC = new DAO_NhaCungCap();
	ArrayList<ChiTietSanPham> list ;
	ArrayList<NhaCungCap> dsNCC = dao_NCC.getAllNCC();
	ArrayList<XuatXu> dsXX = dao_XX.getAllXuatXu();
	ArrayList<ThuongHieu> dsTH = dao_TH.getAllThuongHieu();
	ArrayList<ChatLieu> dsCL = dao_CL.getAllChatLieu();
	File f;
	String relative;
	private JTextField text_XXL;
	private JTextField text_L;
	private JTextField text_XL;
	private JTextField text_M;

	SanPham sp;
	private JTextField text_Loi_Loi;
	/**
	 * Create the frame.
	 */
	public FormCapNhatSP(SanPham sp) {
		this.sp=sp;
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		relative=sp.getHinhAnh();
		list = sp.getChiTietSanPham();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 930, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		setResizable(false);
		//		setAlwaysOnTop(true);
		setTitle("Cập nhật sản phẩm");
		JPanel panel_Hinh = new JPanel();
		panel_Hinh.add(new ImageBox(sp.getHinhAnh(), 300, 300));
		panel_Hinh.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Hinh.setBounds(10, 10, 300, 300);
		contentPane.add(panel_Hinh);
		panel_Hinh.setLayout(new BoxLayout(panel_Hinh, BoxLayout.X_AXIS));

		JButton btn_ThemHinh = new JButton("Thêm hình ảnh");
		btn_ThemHinh.setBounds(10, 320, 124, 21);
		contentPane.add(btn_ThemHinh);

		JLabel lbl_MaSP = new JLabel("Mã Sản phẩm");
		lbl_MaSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_MaSP.setBounds(320, 10, 124, 30);
		contentPane.add(lbl_MaSP);

		text_MaSP = new JTextField(sp.getMaSanPham());
		text_MaSP.setOpaque(false);
		text_MaSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_MaSP.setBounds(454, 10, 124, 30);
		contentPane.add(text_MaSP);
		text_MaSP.setColumns(10);
		text_MaSP.setEditable(false);

		JLabel lbl_TenSP = new JLabel("Tên Sản phẩm");
		lbl_TenSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_TenSP.setBounds(320, 50, 124, 30);
		contentPane.add(lbl_TenSP);

		text_TenSP = new JTextField(sp.getTenSanPham());
		text_TenSP.setOpaque(false);
		text_TenSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_TenSP.setColumns(10);
		text_TenSP.setBounds(454, 50, 392, 30);
		contentPane.add(text_TenSP);


		JLabel lbl_Gia = new JLabel("Giá gốc");
		lbl_Gia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Gia.setBounds(320, 90, 124, 30);
		contentPane.add(lbl_Gia);
		//		Locale localeVN = new Locale("vi", "VN");
		//	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		//	    String strGia = currencyVN.format(sp.getGiaGoc());
		String strGia = String.format("%.0f",sp.getGiaGoc() );

		text_Gia = new JTextField(strGia);
		text_Gia.setOpaque(false);
		text_Gia.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_Gia.setColumns(10);
		text_Gia.setBounds(454, 90, 191, 30);
		contentPane.add(text_Gia);

		JLabel lbl_GT = new JLabel("Giới tính :");
		lbl_GT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_GT.setBounds(320, 250, 80, 30);
		contentPane.add(lbl_GT);

		JLabel lbl_Loai = new JLabel("Loại");
		lbl_Loai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Loai.setBounds(654, 90, 46, 30);
		contentPane.add(lbl_Loai);

		JLabel lbl_CL = new JLabel("Chất liệu");
		lbl_CL.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_CL.setBounds(320, 130, 80, 30);
		contentPane.add(lbl_CL);

		JLabel lbl_TH = new JLabel("Thương hiệu");
		lbl_TH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_TH.setBounds(320, 170, 106, 30);
		contentPane.add(lbl_TH);

		JLabel lbl_XX = new JLabel("Xuất xứ");
		lbl_XX.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_XX.setBounds(320, 210, 80, 30);
		contentPane.add(lbl_XX);

		JLabel lbl_NCC = new JLabel("Nhà Cung Cấp");
		lbl_NCC.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_NCC.setBounds(320, 290, 124, 30);
		contentPane.add(lbl_NCC);

		JComboBox comboBox_NCC = new JComboBox();
		dsNCC=dao_NCC.getAllNCC();
		ArrayList<String> dsTenNCC = new ArrayList<String>();
		for(NhaCungCap ncc:dsNCC) {
			comboBox_NCC.addItem(ncc.getTenNCC());
		}
		comboBox_NCC.setSelectedItem(sp.getNhaCungCap().getTenNCC());

		comboBox_NCC.setBounds(454, 292, 246, 30);
		contentPane.add(comboBox_NCC);

		JTextArea textArea = new JTextArea();
		textArea.setText(sp.getMoTa());
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(10, 556, 896, 97);
		contentPane.add(textArea);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Mô tả sản phẩm");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2_2.setBounds(10, 516, 124, 30);
		contentPane.add(lblNewLabel_1_1_2_2);

		JPanel panel_CTSP = new JPanel();
		panel_CTSP.setBounds(10, 361, 896, 145);
		contentPane.add(panel_CTSP);
		panel_CTSP.setLayout(null);

		JCheckBox chckbx_S = new JCheckBox("S");
		chckbx_S.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_S.setBounds(50, 24, 129, 21);
		panel_CTSP.add(chckbx_S);

		text_S = new JTextField();
		text_S.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_S.setOpaque(false);
		text_S.setColumns(10);
		text_S.setBounds(50, 82, 99, 25);
		text_S.setEditable(false);
		panel_CTSP.add(text_S);

		JButton btn_CN_S = new JButton("Cập nhật");
		btn_CN_S.setBounds(50, 117, 129, 21);
		panel_CTSP.add(btn_CN_S);

		JLabel lbl_Mau_S = new JLabel("Màu:");
		lbl_Mau_S.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_S.setBounds(10, 55, 30, 21);
		panel_CTSP.add(lbl_Mau_S);

		JLabel lbl_Mau_XXL = new JLabel("Màu:");
		lbl_Mau_XXL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_XXL.setBounds(717, 55, 30, 21);
		panel_CTSP.add(lbl_Mau_XXL);

		JCheckBox chckbx_XXL = new JCheckBox("XXL");
		chckbx_XXL.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_XXL.setBounds(757, 24, 129, 21);
		panel_CTSP.add(chckbx_XXL);

		text_XXL = new JTextField();
		text_XXL.setOpaque(false);
		text_XXL.setEditable(false);
		text_XXL.setColumns(10);
		text_XXL.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_XXL.setBounds(757, 82, 99, 25);
		panel_CTSP.add(text_XXL);

		JButton btn_CN_XXL = new JButton("Cập nhật");
		btn_CN_XXL.setBounds(757, 117, 129, 21);
		panel_CTSP.add(btn_CN_XXL);

		JLabel lbl_Mau_L = new JLabel("Màu:");
		lbl_Mau_L.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_L.setBounds(361, 55, 30, 21);
		panel_CTSP.add(lbl_Mau_L);

		JCheckBox chckbx_L = new JCheckBox("L");
		chckbx_L.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_L.setBounds(401, 24, 129, 21);
		panel_CTSP.add(chckbx_L);

		text_L = new JTextField();
		text_L.setOpaque(false);
		text_L.setEditable(false);
		text_L.setColumns(10);
		text_L.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_L.setBounds(401, 82, 99, 25);
		panel_CTSP.add(text_L);

		JButton btn_CN_L =new JButton("Cập nhật");
		btn_CN_L.setBounds(401, 117, 129, 21);
		panel_CTSP.add(btn_CN_L);

		JLabel lbl_Mau_XL = new JLabel("Màu:");
		lbl_Mau_XL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_XL.setBounds(539, 55, 30, 21);
		panel_CTSP.add(lbl_Mau_XL);

		JCheckBox chckbx_XL = new JCheckBox("XL");
		chckbx_XL.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_XL.setBounds(579, 24, 125, 21);
		panel_CTSP.add(chckbx_XL);

		text_XL = new JTextField();
		text_XL.setOpaque(false);
		text_XL.setEditable(false);
		text_XL.setColumns(10);
		text_XL.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_XL.setBounds(579, 82, 99, 25);
		panel_CTSP.add(text_XL);

		JButton btn_CN_XL = new JButton("Cập nhật");
		btn_CN_XL.setBounds(579, 117, 128, 21);
		panel_CTSP.add(btn_CN_XL);

		JLabel lbl_Mau_M = new JLabel("Màu:");
		lbl_Mau_M.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_M.setBounds(189, 55, 30, 21);
		panel_CTSP.add(lbl_Mau_M);

		JCheckBox chckbx_M = new JCheckBox("M");
		chckbx_M.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_M.setBounds(229, 24, 99, 21);
		panel_CTSP.add(chckbx_M);

		text_M = new JTextField();
		text_M.setOpaque(false);
		text_M.setEditable(false);
		text_M.setColumns(10);
		text_M.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_M.setBounds(229, 82, 99, 25);
		panel_CTSP.add(text_M);

		JButton btn_CN_M = new JButton("Cập nhật");
		btn_CN_M.setBounds(229, 117, 129, 21);
		panel_CTSP.add(btn_CN_M);

		JComboBox comboBox_S = new JComboBox();
		loadCombobox(comboBox_S, "S");		
		comboBox_S.setBounds(50, 55, 99, 21);
		panel_CTSP.add(comboBox_S);

		JComboBox comboBox_M = new JComboBox();
		loadCombobox(comboBox_M, "M");
		comboBox_M.setBounds(229, 55, 99, 21);
		panel_CTSP.add(comboBox_M);

		JComboBox comboBox_L = new JComboBox();
		loadCombobox(comboBox_L, "L");
		comboBox_L.setBounds(401, 55, 99, 21);
		panel_CTSP.add(comboBox_L);

		JComboBox comboBox_XL = new JComboBox();
		loadCombobox(comboBox_XL, "XL");
		comboBox_XL.setBounds(579, 55, 99, 21);
		panel_CTSP.add(comboBox_XL);

		JComboBox comboBox_XXL = new JComboBox();
		loadCombobox(comboBox_XXL, "XXL");
		comboBox_XXL.setBounds(757, 55, 99, 21);
		panel_CTSP.add(comboBox_XXL);

		JButton btn_X_S = new JButton("");
		btn_X_S.setIcon(new ImageIcon("image/edit-icon.png"));
		btn_X_S.setBounds(158, 86, 21, 21);
		panel_CTSP.add(btn_X_S);

		JButton btn_X_M = new JButton("");
		btn_X_M.setIcon(new ImageIcon("image/edit-icon.png"));
		btn_X_M.setBounds(337, 82, 21, 21);
		panel_CTSP.add(btn_X_M);

		JButton btn_X_L = new JButton("");
		btn_X_L.setIcon(new ImageIcon("image/edit-icon.png"));
		btn_X_L.setBounds(509, 86, 21, 21);
		panel_CTSP.add(btn_X_L);

		JButton btn_X_XL = new JButton("");
		btn_X_XL.setIcon(new ImageIcon("image/edit-icon.png"));
		btn_X_XL.setBounds(688, 82, 21, 21);
		panel_CTSP.add(btn_X_XL);

		JButton btn_X_XXL = new JButton("");
		btn_X_XXL.setIcon(new ImageIcon("image/edit-icon.png"));
		btn_X_XXL.setBounds(865, 86, 21, 21);
		panel_CTSP.add(btn_X_XXL);
		
		JButton btn_Them_Mau_XXL = new JButton("");
		btn_Them_Mau_XXL.setIcon(new ImageIcon("image/add-icon.png"));

		btn_Them_Mau_XXL.setBounds(866, 55, 20, 20);
		panel_CTSP.add(btn_Them_Mau_XXL);
		
		JButton btn_Them_Mau_XL = new JButton("");
		btn_Them_Mau_XL.setIcon(new ImageIcon("image/add-icon.png"));
		btn_Them_Mau_XL.setBounds(688, 55, 20, 20);
		panel_CTSP.add(btn_Them_Mau_XL);
		
		JButton btn_Them_Mau_L = new JButton("");
		btn_Them_Mau_L.setIcon(new ImageIcon("image/add-icon.png"));
		btn_Them_Mau_L.setBounds(510, 55, 20, 20);
		panel_CTSP.add(btn_Them_Mau_L);
		
		JButton btn_Them_Mau_M = new JButton("");
		btn_Them_Mau_M.setIcon(new ImageIcon("image/add-icon.png"));
		btn_Them_Mau_M.setBounds(338, 55, 20, 20);
		panel_CTSP.add(btn_Them_Mau_M);
		
		JButton btn_Them_Mau_S = new JButton("");
		btn_Them_Mau_S.setIcon(new ImageIcon("image/add-icon.png"));
		btn_Them_Mau_S.setBounds(159, 55, 20, 20);
		panel_CTSP.add(btn_Them_Mau_S);

		JRadioButton rdbtn_Nam = new JRadioButton("Nam");
		rdbtn_Nam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtn_Nam.setBounds(454, 255, 70, 21);
		contentPane.add(rdbtn_Nam);

		JRadioButton rdbtn_Nu = new JRadioButton("Nữ");
		rdbtn_Nu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtn_Nu.setBounds(538, 255, 70, 21);
		contentPane.add(rdbtn_Nu);

		JRadioButton rdbtn_Unisex = new JRadioButton("Unisex");
		rdbtn_Unisex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtn_Unisex.setBounds(620, 255, 70, 21);
		rdbtn_Unisex.setSelected(true);
		contentPane.add(rdbtn_Unisex);

		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rdbtn_Nam);
		btnG.add(rdbtn_Nu);
		btnG.add(rdbtn_Unisex);
		if(sp.getGioiTinh().equalsIgnoreCase("Nam")) {
			rdbtn_Nam.setSelected(true);
		}
		else if(sp.getGioiTinh().equalsIgnoreCase("Nữ")){
			rdbtn_Nu.setSelected(true);
		}
		else {
			rdbtn_Unisex.setSelected(true);
		}

		JComboBox comboBox_XX = new JComboBox();
		dsXX=dao_XX.getAllXuatXu();
		ArrayList<String> dsTenXX = new ArrayList<String>();
		for(XuatXu xx:dsXX) {
			comboBox_XX.addItem(xx.getTenXX());
		}
		comboBox_XX.setSelectedItem(sp.getXuatXu().getTenXX());


		comboBox_XX.setBounds(454, 210, 246, 30);
		contentPane.add(comboBox_XX);

		JComboBox comboBox_TH = new JComboBox();
		dsTH=dao_TH.getAllThuongHieu();
		ArrayList<String> dsTenTH = new ArrayList<String>();
		for(ThuongHieu th:dsTH) {
			comboBox_TH.addItem(th.getTenTH());
		}
		comboBox_TH.setSelectedItem(sp.getThuongHieu().getTenTH());


		comboBox_TH.setBounds(454, 170, 246, 30);
		contentPane.add(comboBox_TH);

		JComboBox comboBox_CL = new JComboBox();
		dsCL=dao_CL.getAllChatLieu();
		ArrayList<String> dsTenCL = new ArrayList<String>();
		for(ChatLieu cl:dsCL) {
			comboBox_CL.addItem(cl.getTenCL());
		}
		comboBox_CL.setSelectedItem(sp.getChatLieu().getTenCL());

		comboBox_CL.setBounds(454, 130, 246, 30);
		contentPane.add(comboBox_CL);

		JButton btn_Thoat = new JButton("Thoát");
		btn_Thoat.setBounds(821, 663, 85, 26);
		contentPane.add(btn_Thoat);

		JButton btn_CN = new JButton("Cập nhật");
		btn_CN.setBounds(726, 663, 85, 26);
		contentPane.add(btn_CN);

		JButton btn_add_CL = new JButton("");
		btn_add_CL.setIcon(new ImageIcon("image/add-icon.png"));
		btn_add_CL.setBounds(710, 130, 36, 30);
		contentPane.add(btn_add_CL);

		JButton btn_add_TH = new JButton("");
		btn_add_TH.setIcon(new ImageIcon("image/add-icon.png"));
		btn_add_TH.setBounds(710, 170, 36, 30);
		contentPane.add(btn_add_TH);

		JButton btn_add_XX = new JButton("");
		btn_add_XX.setIcon(new ImageIcon("image/add-icon.png"));
		btn_add_XX.setBounds(710, 210, 36, 30);
		contentPane.add(btn_add_XX);

		JButton btn_Goback = new JButton("");
		btn_Goback.setIcon(new ImageIcon("image/Go-back-icon.png"));
		btn_Goback.setBounds(144, 320, 36, 21);
		contentPane.add(btn_Goback);
		
		text_Loi_Loi = new JTextField();
		text_Loi_Loi.setForeground(Color.RED);
		text_Loi_Loi.setFont(new Font("Tahoma", Font.ITALIC, 12));
		text_Loi_Loi.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		text_Loi_Loi.setOpaque(false);
		text_Loi_Loi.setBounds(654, 332, 195, 21);
		contentPane.add(text_Loi_Loi);
		text_Loi_Loi.setColumns(10);
		text_Loi_Loi.setEditable(false);
		
		String[] strLoai = {"Áo","Quần","Đầm","Váy","Kính"};
		JComboBox comboBox_Loai = new JComboBox(strLoai);
		comboBox_Loai.setSelectedItem(sp.getLoai());
		
		comboBox_Loai.setBounds(710, 97, 196, 23);
		contentPane.add(comboBox_Loai);
		ArrayList<ChiTietSanPham> ctsp = sp.getChiTietSanPham();
		for(ChiTietSanPham ct :ctsp) {
			if(ct.getSize().equalsIgnoreCase("S")) {
				chckbx_S.setSelected(true);
				btn_X_S.setEnabled(true);
				btn_CN_S.setEnabled(true);
			}
			if(ct.getSize().equalsIgnoreCase("M")) {
				chckbx_M.setSelected(true);
				btn_X_M.setEnabled(true);
				btn_CN_M.setEnabled(true);
			}
			if(ct.getSize().equalsIgnoreCase("L")) {
				chckbx_L.setSelected(true);
				btn_X_L.setEnabled(true);
				btn_CN_L.setEnabled(true);
			}
			if(ct.getSize().equalsIgnoreCase("XL")) {
				chckbx_XL.setSelected(true);
				btn_X_XL.setEnabled(true);
				btn_CN_XL.setEnabled(true);
			}
			if(ct.getSize().equalsIgnoreCase("XXL")) {
				chckbx_XXL.setSelected(true);
				btn_X_XXL.setEnabled(true);
				btn_CN_XXL.setEnabled(true);
			}

		}

		btn_ThemHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Hinh.removeAll();
				panel_Hinh.repaint();
				JFileChooser fileChooser = new JFileChooser("D:\\WorkspaceJava\\PTUD\\image");
				FileNameExtensionFilter imgFilter  = new FileNameExtensionFilter("Hinh anh", "jpg","png");
				fileChooser.setFileFilter(imgFilter);
				fileChooser.setMultiSelectionEnabled(false);
				int x = fileChooser.showDialog(null, "Chon");
				if (x == JFileChooser.APPROVE_OPTION) {

					f = fileChooser.getSelectedFile();
					String path =f.getAbsolutePath();
					String base =f.getParentFile().getParent();

					relative = new File(base).toURI().relativize(new File(path).toURI()).getPath();
					panel_Hinh.add(new ImageBox(relative, 300, 300));	
					panel_Hinh.repaint();
					panel_Hinh.revalidate();
					//					lblx.setIcon(new ImageIcon(
					//							new ImageIcon("HinhAnh/bg1.png").getImage().getScaledInstance(1500, 1, Image.SCALE_SMOOTH)));
				}

			}
		});
		btn_CN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gt = "" ; 			
				if( rdbtn_Nam.isSelected()) {
					gt= "Nam";
				}
				else if (rdbtn_Nu.isSelected()) {
					gt= "Nữ";
				}
				else if(rdbtn_Unisex.isSelected()) {
					gt="Uni";
				}
				ChatLieu cl = new ChatLieu() ;
				for (ChatLieu cll :dao_CL.getAllChatLieu()) {
					if(comboBox_CL.getSelectedItem().toString().equalsIgnoreCase(cll.getTenCL())) {
						cl=cll;
						break;
					}
				}

				ThuongHieu th = new ThuongHieu();
				for (ThuongHieu thh : dao_TH.getAllThuongHieu()) {
					if(comboBox_TH.getSelectedItem().toString().equalsIgnoreCase(thh.getTenTH())) {
						th=thh;
						break;
					}
				}

				XuatXu xx = new XuatXu();
				for (XuatXu xxx : dao_XX.getAllXuatXu()) {
					if(comboBox_XX.getSelectedItem().toString().equalsIgnoreCase(xxx.getTenXX())) {
						xx=xxx;
						break;
					}
				}

				NhaCungCap ncc = new NhaCungCap();
				for (NhaCungCap nccc : dao_NCC.getAllNCC()) {
					if(comboBox_NCC.getSelectedItem().toString().equalsIgnoreCase(nccc.getTenNCC())) {
						ncc=nccc;
						break;
					}
				}
				
				String mota="";
				try {
					mota = (String) textArea.getText().subSequence(0,99);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.err.println("Desciption < 100");
				}
				if(!isNumber(text_Gia)) {

					JOptionPane.showMessageDialog(null, "Giá phải là một số");
				}
				else if(text_TenSP.getText()==null||text_TenSP.getText().equals("")) {
					
						JOptionPane.showMessageDialog(null, "Tên SP không để trống"
								+ "\n(Chữ cái đầu viết hoa và không chứa kí tự đặt biệt)",
							      "Hey!", JOptionPane.ERROR_MESSAGE);		
				}
//				else if(text_Loai.getText()==null||text_Loai.getText().equals("")) {
//					JOptionPane.showMessageDialog(null, "Loại sản phẩm không được trống");
//				}
				else {
					String rex = "^[^!@#$%^&*]{1,}([^!@#$%&^*]{1,})";
					Pattern p = Pattern.compile(rex);
					Matcher m = p.matcher(text_TenSP.getText());
					if(!m.find()) {
						JOptionPane.showMessageDialog(null, "Tên SP không đúng định dạng"
								+ "\n(Chữ cái đầu viết hoa và không chứa kí tự đặt biệt)",
							      "Hey!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						SanPham spp = new SanPham(text_MaSP.getText(),text_TenSP.getText()
								, Double.parseDouble(text_Gia.getText()), relative, mota
								, gt, "", comboBox_Loai.getSelectedItem().toString(), "", 0, cl, th, xx, ncc, "Còn bán",sp.getChiTietSanPham());
						if(dao_SP.capNhat_SP(spp)) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công");
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
						}
					}					
				}
			}
		});
		btn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btn_add_CL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chatLieuMoi= JOptionPane.showInputDialog(btn_add_CL, "Nhập tên chất liệu mới");
				if(chatLieuMoi!=null) {
					int flag = 0;
					ArrayList<ChatLieu> listCLsk = dao_CL.getAllChatLieu();
					for(ChatLieu cl:listCLsk) {
						if(chatLieuMoi.equalsIgnoreCase(cl.getTenCL())) {
							JOptionPane.showMessageDialog(btn_add_CL,"Chất liệu đã tồn tại");
							comboBox_CL.setSelectedItem(cl.getTenCL());
							flag++;
							break;
						}
					}
					if(flag==0) {
						ChatLieu cl = new ChatLieu(getCLMoi(listCLsk),chatLieuMoi," ");
						dao_CL.createCL(cl);
						comboBox_CL.addItem(cl.getTenCL());
						comboBox_CL.setSelectedItem(cl.getTenCL());
						JOptionPane.showMessageDialog(btn_add_CL, "Thêm thành công");
					}
				}		
			}
		});
		btn_add_TH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String thMoi= JOptionPane.showInputDialog(btn_add_TH, "Nhập tên thương hiệu mới");
				if(thMoi!=null) {
					int flag = 0;
					ArrayList<ThuongHieu> listTHsk = dao_TH.getAllThuongHieu();
					for(ThuongHieu th:listTHsk) {
						if(thMoi.equalsIgnoreCase(th.getTenTH())) {
							JOptionPane.showMessageDialog(btn_add_TH,"Thương hiệu đã tồn tại");
							comboBox_TH.setSelectedItem(th.getTenTH());
							flag++;
							break;
						}
					}
					if(flag==0) {
						ThuongHieu th = new ThuongHieu(getTHMoi(listTHsk),thMoi," ");
						dao_TH.createTH(th);
						comboBox_TH.addItem(th.getTenTH());
						comboBox_TH.setSelectedItem(th.getTenTH());
						JOptionPane.showMessageDialog(btn_add_TH, "Thêm thành công");
					}
				}		
			}
		});
		btn_add_XX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xxMoi= JOptionPane.showInputDialog(btn_add_XX, "Nhập tên xuất xứ mới");
				if(xxMoi!=null) {
					int flag = 0;
					ArrayList<XuatXu> listXXsk = dao_XX.getAllXuatXu();
					for(XuatXu xx:listXXsk) {
						if(xxMoi.equalsIgnoreCase(xx.getTenXX())) {
							JOptionPane.showMessageDialog(btn_add_XX,"Xuất xứ đã tồn tại");
							comboBox_XX.setSelectedItem(xx.getTenXX());
							flag++;
							break;
						}
					}
					if(flag==0) {
						XuatXu xx = new XuatXu(getXXMoi(listXXsk),xxMoi," ");
						dao_XX.createXX(xx);
						comboBox_XX.addItem(xx.getTenXX());
						comboBox_XX.setSelectedItem(xx.getTenXX());
						JOptionPane.showMessageDialog(btn_add_XX, "Thêm thành công");
					}
				}		
			}
		});
		btn_X_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_S.setEnabled(true);
				text_S.setEditable(true);
				text_S.requestFocus();
			}
		});
		btn_X_M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_M.setEnabled(true);
				text_M.setEditable(true);
				text_M.requestFocus();
			}
		});
		btn_X_L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_L.setEnabled(true);
				text_L.setEditable(true);
				text_L.requestFocus();
			}
		});
		btn_X_XL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_XL.setEnabled(true);
				text_XL.setEditable(true);
				text_XL.requestFocus();
			}
		});
		btn_X_XXL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_XXL.setEnabled(true);
				text_XXL.setEditable(true);
				text_XXL.requestFocus();
			}
		});
		btn_Goback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_Hinh.removeAll();
				panel_Hinh.repaint();
				panel_Hinh.add(new ImageBox(sp.getHinhAnh(), 300, 300));
				panel_Hinh.repaint();
				panel_Hinh.revalidate();
			}
		});
		comboBox_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_S.setText(comboBox_S.getSelectedItem().toString());
			}
		});
		comboBox_M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_M.setText(comboBox_M.getSelectedItem().toString());
			}
		});
		comboBox_L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_L.setText(comboBox_L.getSelectedItem().toString());
			}
		});
		comboBox_XL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_XL.setText(comboBox_XL.getSelectedItem().toString());
			}
		});
		comboBox_XXL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_XXL.setText(comboBox_XXL.getSelectedItem().toString());
			}
		});
		btn_CN_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhat_size_Mau(text_S, "S", comboBox_S);
			}
		});
		btn_CN_M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhat_size_Mau(text_M, "M", comboBox_M);
			}
		});
		btn_CN_L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhat_size_Mau(text_L, "L", comboBox_L);
			}
		});
		btn_CN_XL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhat_size_Mau(text_XL, "XL", comboBox_XL);
			}
		});
		btn_CN_XXL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhat_size_Mau(text_XXL, "XXL", comboBox_XXL);
			}
		});
		btn_Them_Mau_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themMau(btn_Them_Mau_S, "S", comboBox_S);
			}
		});
		btn_Them_Mau_M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themMau(btn_Them_Mau_M, "M", comboBox_M);
			}
		});
		btn_Them_Mau_L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themMau(btn_Them_Mau_L, "L", comboBox_L);
			}
		});
		btn_Them_Mau_XL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themMau(btn_Them_Mau_XL, "XL", comboBox_XL);
			}
		});
		btn_Them_Mau_XXL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themMau(btn_Them_Mau_XXL, "XXL", comboBox_XXL);
			}
		});
		
	}

	//-------------------Event--------------------
	private void themMau(JButton btn, String size, JComboBox cbb) {
		String mauMoi = " ";
		mauMoi = JOptionPane.showInputDialog(btn,"Nhập màu mới");
		if(mauMoi==null) {
			return;
		}
		else if(mauMoi.trim().equals("")) {
			JOptionPane.showMessageDialog(btn, "Màu không được trống");
		}  else {
			cbb.setSelectedItem(mauMoi);
			if(cbb.getSelectedItem()!=null) {				
				if(cbb.getSelectedItem().equals(mauMoi)) {
					JOptionPane.showMessageDialog(null,"Màu đã tồn tại");
				} 
				
				else {;
					String ma = getCTMoi(dao_SP.getAllCTSanPham(sp.getMaSanPham()), sp.getMaSanPham(),size);
					ChiTietSanPham ct = new ChiTietSanPham(ma, sp.getMaSanPham(),
							size, mauMoi, 0);
					if(dao_SP.them_CTSP(ct)) {
						list.add(ct);
						JOptionPane.showMessageDialog(btn, "Thêm thành công");
						cbb.addItem(ct.getMau());
						cbb.setSelectedItem(ct.getMau());
					}
				}
			}
			else if((cbb.getItemCount()==0)) {
				String ma = getCTMoi(dao_SP.getAllCTSanPham(sp.getMaSanPham()), sp.getMaSanPham(),size);
				ChiTietSanPham ct = new ChiTietSanPham(ma, sp.getMaSanPham(),
						size, mauMoi, 0);
				if(dao_SP.them_CTSP(ct)) {
					list.add(ct);
					JOptionPane.showMessageDialog(btn, "Thêm thành công");
					cbb.addItem(ct.getMau());
					cbb.setSelectedItem(ct.getMau());
				}
			}
			
		
			
		}
	}
	private void capNhat_size_Mau(JTextField text,String size,JComboBox comboBox) {
		if(text.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null,"Màu không được để trống");
		}
		else {		
			for(ChiTietSanPham ct :list) {
				if(ct.getSize().equalsIgnoreCase(size)&&ct.getMau().equalsIgnoreCase(comboBox.getSelectedItem().toString())) {					
					String t= text.getText();
					String tt = comboBox.getSelectedItem().toString();
					if(contains(comboBox, t)) {
						JOptionPane.showMessageDialog(null,"Màu đã tồn tại");
					}
					else {						
						ct.setMau(text.getText());	
						comboBox.addItem(ct.getMau());
						comboBox.setSelectedItem(ct.getMau());
						comboBox.removeItem(tt);
					}	
				}
			}
		}
	}
	public static boolean contains(JComboBox<String> comboBox, String item) {
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            items.add(comboBox.getItemAt(i));
        }
        return items.contains(item);
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
	private String getCLMoi(ArrayList<ChatLieu> list) {
		String str="";
		ChatLieu cl = list.get(list.size()-1);
		String ma = cl.getMaCL().substring(2);
		int ma3 = Integer.parseInt(ma);
		ma3+=1;
		str = String.format("%04d", ma3);
		return "CL"+str;
	}
	private String getTHMoi(ArrayList<ThuongHieu> list) {
		String str="";
		ThuongHieu th = list.get(list.size()-1);
		String ma = th.getMaTH().substring(2);
		int ma3 = Integer.parseInt(ma);
		ma3+=1;
		str = String.format("%04d", ma3);
		return "TH"+str;
	}
	private String getXXMoi(ArrayList<XuatXu> list) {
		String str="";
		XuatXu xx = list.get(list.size()-1);
		String ma = xx.getMaXX().substring(2);
		int ma3 = Integer.parseInt(ma);
		ma3+=1;
		str = String.format("%04d", ma3);
		return "XX"+str;
	}
	boolean isNumber(JTextField txt) {
		try {
			double i = Double.parseDouble(txt.getText());
			if(i<1) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	boolean isNumber2(JTextField txt) {
		try {
			double i = Double.parseDouble(txt.getText());
			
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	private void loadCombobox(JComboBox cbb , String size) {
		cbb.removeAllItems();
		for(ChiTietSanPham ct: dao_SP.getAllCTSanPham(sp.getMaSanPham())) {
			if(ct.getSize().equals(size)) {
				cbb.addItem(ct.getMau());
			}
		}	
	}
}
