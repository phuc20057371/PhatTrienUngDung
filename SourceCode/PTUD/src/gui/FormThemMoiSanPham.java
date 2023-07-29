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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormThemMoiSanPham extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_MaSP;
	private JTextField text_TenSP;
	private JTextField text_Gia;
	private JTextField text_Mau_S;

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

	/**
	 * Create the frame.
	 */
	public FormThemMoiSanPham() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		list = new ArrayList<ChiTietSanPham>();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 858, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		setResizable(false);
//		setAlwaysOnTop(true);
		setTitle("Thêm mới sản phẩm");
		JPanel panel_Hinh = new JPanel();
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
		
		text_MaSP = new JTextField(getMaMoi(dao_SP.getAllSanPhamV2()));
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
		
		text_TenSP = new JTextField();
		text_TenSP.setOpaque(false);
		text_TenSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_TenSP.setColumns(10);
		text_TenSP.setBounds(454, 50, 380, 30);
		contentPane.add(text_TenSP);
		
		JLabel lbl_Gia = new JLabel("Giá gốc");
		lbl_Gia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Gia.setBounds(320, 90, 124, 30);
		contentPane.add(lbl_Gia);
		
		text_Gia = new JTextField();
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
		
		
		dsNCC=dao_NCC.getAllNCC();
		ArrayList<String> dsTenNCC = new ArrayList<String>();
		for(NhaCungCap ncc:dsNCC) {
			dsTenNCC.add(ncc.getTenNCC());
		}
		
		String[] dsTenNCCStr = new String[dsTenNCC.size()];
		for(int i =0;i< dsTenNCCStr.length;i++) {
			dsTenNCCStr[i]= dsTenNCC.get(i);
		}
		
		JComboBox comboBox_NCC = new JComboBox(dsTenNCCStr);
		comboBox_NCC.setBounds(454, 292, 156, 30);
		contentPane.add(comboBox_NCC);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(10, 566, 824, 54);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Mô tả sản phẩm");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2_2.setBounds(10, 526, 124, 30);
		contentPane.add(lblNewLabel_1_1_2_2);
		
		JPanel panel_CTSP = new JPanel();
		panel_CTSP.setBounds(10, 351, 824, 165);
		contentPane.add(panel_CTSP);
		panel_CTSP.setLayout(null);
		
		JCheckBox chckbx_S = new JCheckBox("S");
		chckbx_S.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_S.setBounds(10, 24, 125, 21);
		panel_CTSP.add(chckbx_S);
		
		text_Mau_S = new JTextField();
		text_Mau_S.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_Mau_S.setOpaque(false);
		text_Mau_S.setColumns(10);
		text_Mau_S.setBounds(50, 51, 84, 25);
		text_Mau_S.setEditable(false);
		panel_CTSP.add(text_Mau_S);
		
		JButton btn_Them_S = new JButton("Thêm");
		btn_Them_S.setBounds(10, 86, 124, 21);
		btn_Them_S.setEnabled(false);
		panel_CTSP.add(btn_Them_S);
		
		JLabel lbl_Mau_S = new JLabel("Màu:");
		lbl_Mau_S.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_S.setBounds(10, 51, 30, 21);
		panel_CTSP.add(lbl_Mau_S);
		
		JLabel lbl_Mau_XXL = new JLabel("Màu:");
		lbl_Mau_XXL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_XXL.setBounds(693, 51, 30, 21);
		panel_CTSP.add(lbl_Mau_XXL);
		
		JCheckBox chckbx_XXL = new JCheckBox("XXL");
		chckbx_XXL.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_XXL.setBounds(693, 24, 125, 21);
		panel_CTSP.add(chckbx_XXL);
		
		text_XXL = new JTextField();
		text_XXL.setOpaque(false);
		text_XXL.setEditable(false);
		text_XXL.setColumns(10);
		text_XXL.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_XXL.setBounds(733, 51, 84, 25);
		panel_CTSP.add(text_XXL);
		
		JButton btn_Them_XXL = new JButton("Thêm");
		btn_Them_XXL.setEnabled(false);
		btn_Them_XXL.setBounds(693, 86, 124, 21);
		panel_CTSP.add(btn_Them_XXL);
		
		JLabel lbl_Mau_L = new JLabel("Màu:");
		lbl_Mau_L.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_L.setBounds(351, 51, 30, 21);
		panel_CTSP.add(lbl_Mau_L);
		
		JCheckBox chckbx_L = new JCheckBox("L");
		chckbx_L.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_L.setBounds(351, 24, 125, 21);
		panel_CTSP.add(chckbx_L);
		
		text_L = new JTextField();
		text_L.setOpaque(false);
		text_L.setEditable(false);
		text_L.setColumns(10);
		text_L.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_L.setBounds(391, 51, 84, 25);
		panel_CTSP.add(text_L);
		
		JButton btn_Them_L = new JButton("Thêm");
		btn_Them_L.setEnabled(false);
		btn_Them_L.setBounds(351, 86, 124, 21);
		panel_CTSP.add(btn_Them_L);
		
		JLabel lbl_Mau_XL = new JLabel("Màu:");
		lbl_Mau_XL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_XL.setBounds(529, 51, 30, 21);
		panel_CTSP.add(lbl_Mau_XL);
		
		JCheckBox chckbx_XL = new JCheckBox("XL");
		chckbx_XL.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_XL.setBounds(529, 24, 125, 21);
		panel_CTSP.add(chckbx_XL);
		
		text_XL = new JTextField();
		text_XL.setOpaque(false);
		text_XL.setEditable(false);
		text_XL.setColumns(10);
		text_XL.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_XL.setBounds(569, 51, 84, 25);
		panel_CTSP.add(text_XL);
		
		JButton btn_Them_XL = new JButton("Thêm");
		btn_Them_XL.setEnabled(false);
		btn_Them_XL.setBounds(529, 86, 124, 21);
		panel_CTSP.add(btn_Them_XL);
		
		JLabel lbl_Mau_M = new JLabel("Màu:");
		lbl_Mau_M.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Mau_M.setBounds(179, 51, 30, 21);
		panel_CTSP.add(lbl_Mau_M);
		
		JCheckBox chckbx_M = new JCheckBox("M");
		chckbx_M.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbx_M.setBounds(179, 24, 125, 21);
		panel_CTSP.add(chckbx_M);
		
		text_M = new JTextField();
		text_M.setOpaque(false);
		text_M.setEditable(false);
		text_M.setColumns(10);
		text_M.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_M.setBounds(219, 51, 84, 25);
		panel_CTSP.add(text_M);
		
		JButton btn_Them_M = new JButton("Thêm");
		btn_Them_M.setEnabled(false);
		btn_Them_M.setBounds(179, 86, 124, 21);
		panel_CTSP.add(btn_Them_M);
		
		JComboBox comboBox_S = new JComboBox();
		comboBox_S.setBounds(10, 117, 99, 21);
		panel_CTSP.add(comboBox_S);
		
		JComboBox comboBox_M = new JComboBox();
		comboBox_M.setBounds(179, 117, 99, 21);
		panel_CTSP.add(comboBox_M);
		
		JComboBox comboBox_L = new JComboBox();
		comboBox_L.setBounds(351, 117, 99, 21);
		panel_CTSP.add(comboBox_L);
		
		JComboBox comboBox_XL = new JComboBox();
		comboBox_XL.setBounds(529, 117, 99, 21);
		panel_CTSP.add(comboBox_XL);
		
		JComboBox comboBox_XXL = new JComboBox();
		comboBox_XXL.setBounds(693, 117, 99, 21);
		panel_CTSP.add(comboBox_XXL);
		
		JButton btn_X_S = new JButton("");
		btn_X_S.setIcon(new ImageIcon("image/Actions-edit-delete-icon.png"));
		btn_X_S.setBounds(114, 117, 21, 21);
		panel_CTSP.add(btn_X_S);
		
		JButton btn_X_M = new JButton("");
		btn_X_M.setIcon(new ImageIcon("image/Actions-edit-delete-icon.png"));
		btn_X_M.setBounds(283, 117, 21, 21);
		panel_CTSP.add(btn_X_M);
		
		JButton btn_X_L = new JButton("");
		btn_X_L.setIcon(new ImageIcon("image/Actions-edit-delete-icon.png"));
		btn_X_L.setBounds(455, 117, 21, 21);
		panel_CTSP.add(btn_X_L);
		
		JButton btn_X_XL = new JButton("");
		btn_X_XL.setIcon(new ImageIcon("image/Actions-edit-delete-icon.png"));
		btn_X_XL.setBounds(633, 117, 21, 21);
		panel_CTSP.add(btn_X_XL);
		
		JButton btn_X_XXL = new JButton("");
		btn_X_XXL.setIcon(new ImageIcon("image/Actions-edit-delete-icon.png"));
		btn_X_XXL.setBounds(797, 117, 21, 21);
		panel_CTSP.add(btn_X_XXL);
		
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
		
		dsXX=dao_XX.getAllXuatXu();
		ArrayList<String> dsTenXX = new ArrayList<String>();
		for(XuatXu xx:dsXX) {
			dsTenXX.add(xx.getTenXX());
		}
		
		String[] dsTenXXStr = new String[dsTenXX.size()];
		for(int i =0;i< dsTenXXStr.length;i++) {
			dsTenXXStr[i]= dsTenXX.get(i);
		}
		
		JComboBox comboBox_XX = new JComboBox(dsTenXXStr);
		comboBox_XX.setBounds(454, 210, 191, 30);
		contentPane.add(comboBox_XX);

		dsTH=dao_TH.getAllThuongHieu();
		ArrayList<String> dsTenTH = new ArrayList<String>();
		for(ThuongHieu th:dsTH) {
			dsTenTH.add(th.getTenTH());
		}
		
		String[] dsTenTHStr = new String[dsTenTH.size()];
		for(int i =0;i< dsTenTHStr.length;i++) {
			dsTenTHStr[i]= dsTenTH.get(i);
		}
		
		JComboBox comboBox_TH = new JComboBox(dsTenTHStr);
		comboBox_TH.setBounds(454, 170, 191, 30);
		contentPane.add(comboBox_TH);

		dsCL=dao_CL.getAllChatLieu();
		ArrayList<String> dsTenCL = new ArrayList<String>();
		for(ChatLieu cl:dsCL) {
			dsTenCL.add(cl.getTenCL());
		}
		
		String[] dsTenCLStr = new String[dsTenCL.size()];
		for(int i =0;i< dsTenCLStr.length;i++) {
			dsTenCLStr[i]= dsTenCL.get(i);
		}
		
		JComboBox comboBox_CL = new JComboBox(dsTenCLStr);
		comboBox_CL.setBounds(454, 130, 191, 30);
		contentPane.add(comboBox_CL);
		
		JButton btn_Thoat = new JButton("Thoát");
		btn_Thoat.setBounds(749, 663, 85, 26);
		contentPane.add(btn_Thoat);
		
		JButton btn_Them = new JButton("Thêm");
		btn_Them.setBounds(654, 663, 85, 26);
		contentPane.add(btn_Them);
		
		JButton btn_add_CL = new JButton("");
		btn_add_CL.setIcon(new ImageIcon("image/add-icon.png"));
		btn_add_CL.setBounds(673, 130, 36, 30);
		contentPane.add(btn_add_CL);
		
		JButton btn_add_TH = new JButton("");
		btn_add_TH.setIcon(new ImageIcon("image/add-icon.png"));
		btn_add_TH.setBounds(673, 170, 36, 30);
		contentPane.add(btn_add_TH);
		
		JButton btn_add_XX = new JButton("");
		btn_add_XX.setIcon(new ImageIcon("image/add-icon.png"));
		btn_add_XX.setBounds(673, 210, 36, 30);
		contentPane.add(btn_add_XX);
		String[] strLoai = {"Áo","Quần","Đầm","Váy","Kính"};
		
		JComboBox comboBox_Loai = new JComboBox(strLoai);
		comboBox_Loai.setBounds(710, 97, 124, 23);
		contentPane.add(comboBox_Loai);
		
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
		chckbx_S.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbx_S.isSelected()) {
					btn_Them_S.setEnabled(true);
					text_Mau_S.setEditable(true);
					text_Mau_S.requestFocus();
				}
				else {
					btn_Them_S.setEnabled(false);
					text_Mau_S.setEditable(false);
				}
			}
		});
		btn_Them_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_Mau_S.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập màu");
				}
				else {
					ChiTietSanPham ct = new ChiTietSanPham(getCTMoi(list,text_MaSP.getText(),"S"), text_MaSP.getText(), "S",text_Mau_S.getText() , 0);
					if(list.contains(ct)) {
						JOptionPane.showMessageDialog(null, "Đã tồn tại");
					}
					else {
						list.add(ct);
						System.out.println(ct.getMaChiTietSanPham());
						comboBox_S.addItem(text_Mau_S.getText());
						comboBox_S.setSelectedItem(ct.getMau());
					}	
				}			
			}
		});
		btn_X_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_S.getSelectedItem()!=null) {
					for(ChiTietSanPham ct:list) {
						if(ct.getMau().equalsIgnoreCase(comboBox_S.getSelectedItem().toString())) {
							comboBox_S.removeItem(ct.getMau());
							list.remove(ct);
							break;
						}
					}
				}
				
			}
		});
		chckbx_M.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbx_M.isSelected()) {
					btn_Them_M.setEnabled(true);
					text_M.setEditable(true);
					text_M.requestFocus();
				}
				else {
					btn_Them_M.setEnabled(false);
					text_M.setEditable(false);
				}
			}
		});
		btn_Them_M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_M.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập màu");
				}
				else {
					ChiTietSanPham ct = new ChiTietSanPham(getCTMoi(list,text_MaSP.getText(),"M"), text_MaSP.getText(), "M",text_M.getText() , 0);
					if(list.contains(ct)) {
						JOptionPane.showMessageDialog(null, "Đã tồn tại");
					}
					else {
						list.add(ct);
						System.out.println(ct.getMaChiTietSanPham());
						comboBox_M.addItem(text_M.getText());
						comboBox_M.setSelectedItem(ct.getMau());
					}	
				}			
			}
		});
		btn_X_M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_M.getSelectedItem()!=null) {
					for(ChiTietSanPham ct:list) {
						if(ct.getMau().equalsIgnoreCase(comboBox_M.getSelectedItem().toString())) {
							comboBox_M.removeItem(ct.getMau());
							list.remove(ct);
							break;
						}
					}
				}
				
			}
		});
		chckbx_L.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbx_L.isSelected()) {
					btn_Them_L.setEnabled(true);
					text_L.setEditable(true);
					text_L.requestFocus();
				}
				else {
					btn_Them_L.setEnabled(false);
					text_L.setEditable(false);
				}
			}
		});
		btn_Them_L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_L.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập màu");
				}
				else {
					ChiTietSanPham ct = new ChiTietSanPham(getCTMoi(list,text_MaSP.getText(),"L"), text_MaSP.getText(), "L",text_L.getText() , 0);
					if(list.contains(ct)) {
						JOptionPane.showMessageDialog(null, "Đã tồn tại");
					}
					else {
						list.add(ct);
						System.out.println(ct.getMaChiTietSanPham());
						comboBox_L.addItem(text_L.getText());
						comboBox_L.setSelectedItem(ct.getMau());
					}	
				}			
			}
		});
		btn_X_L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_L.getSelectedItem()!=null) {
					for(ChiTietSanPham ct:list) {
						if(ct.getMau().equalsIgnoreCase(comboBox_L.getSelectedItem().toString())) {
							comboBox_L.removeItem(ct.getMau());
							list.remove(ct);
							break;
						}
					}
				}
				
			}
		});
		chckbx_XL.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbx_XL.isSelected()) {
					btn_Them_XL.setEnabled(true);
					text_XL.setEditable(true);
					text_XL.requestFocus();
				}
				else {
					btn_Them_XL.setEnabled(false);
					text_XL.setEditable(false);
				}
			}
		});
		btn_Them_XL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_XL.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập màu");
				}
				else {
					ChiTietSanPham ct = new ChiTietSanPham(getCTMoi(list,text_MaSP.getText(),"XL"), text_MaSP.getText(), "XL",text_XL.getText() , 0);
					if(list.contains(ct)) {
						JOptionPane.showMessageDialog(null, "Đã tồn tại");
					}
					else {
						list.add(ct);
						System.out.println(ct.getMaChiTietSanPham());
						comboBox_XL.addItem(text_XL.getText());
						comboBox_XL.setSelectedItem(ct.getMau());
					}	
				}			
			}
		});
		btn_X_XL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_XL.getSelectedItem()!=null) {
					for(ChiTietSanPham ct:list) {
						if(ct.getMau().equalsIgnoreCase(comboBox_XL.getSelectedItem().toString())) {
							comboBox_XL.removeItem(ct.getMau());
							list.remove(ct);
							break;
						}
					}
				}
				
			}
		});
		chckbx_XXL.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbx_XXL.isSelected()) {
					btn_Them_XXL.setEnabled(true);
					text_XXL.setEditable(true);
					text_XXL.requestFocus();
				}
				else {
					btn_Them_XXL.setEnabled(false);
					text_XXL.setEditable(false);
				}
			}
		});
		btn_Them_XXL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_XXL.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập màu");
				}
				else {
					ChiTietSanPham ct = new ChiTietSanPham(getCTMoi(list,text_MaSP.getText(),"XXL"), text_MaSP.getText(), "XXL",text_XXL.getText() , 0);
					if(list.contains(ct)) {
						JOptionPane.showMessageDialog(null, "Đã tồn tại");
					}
					else {
						list.add(ct);
						System.out.println(ct.getMaChiTietSanPham());
						comboBox_XXL.addItem(text_XXL.getText());
						comboBox_XXL.setSelectedItem(ct.getMau());
					}	
				}			
			}
		});
		btn_X_XXL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_XXL.getSelectedItem()!=null) {
					for(ChiTietSanPham ct:list) {
						if(ct.getMau().equalsIgnoreCase(comboBox_XXL.getSelectedItem().toString())) {
							comboBox_XXL.removeItem(ct.getMau());
							list.remove(ct);
							break;
						}
					}
				}
				
			}
		});
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy thêm ít nhất 1 size cho sản phẩm");
				}
				else {
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
					for (ThuongHieu thh :dao_TH.getAllThuongHieu()) {
						if(comboBox_TH.getSelectedItem().toString().equalsIgnoreCase(thh.getTenTH())) {
							th=thh;
							break;
						}
					}
					
					XuatXu xx = new XuatXu();
					for (XuatXu xxx :dao_XX.getAllXuatXu()) {
						if(comboBox_XX.getSelectedItem().toString().equalsIgnoreCase(xxx.getTenXX())) {
							xx=xxx;
							break;
						}
					}
					
					NhaCungCap ncc = new NhaCungCap();
					for (NhaCungCap nccc :dao_NCC.getAllNCC()) {
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

						JOptionPane.showMessageDialog(null, "Tên SP không đúng định dạng"
								+ "\n(Chữ cái đầu viết hoa và không chứa kí tự đặt biệt)",
							      "Hey!", JOptionPane.ERROR_MESSAGE);
					}
//					else if(text_Loai.getText()==null||text_Loai.getText().equals("")) {
//						JOptionPane.showMessageDialog(null, "Hảy thêm loại sản phẩm");
//					}
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
							SanPham sp = new SanPham(text_MaSP.getText(),text_TenSP.getText()
									, Double.parseDouble(text_Gia.getText()), relative, mota
									, gt, "", comboBox_Loai.getSelectedItem().toString(), "", 0, cl, th, xx, ncc, "Còn bán", list);
							if(dao_SP.themMoi_SP(sp)) {
								JOptionPane.showMessageDialog(null, "Thêm thành công");
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại");
							}
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
	}
	//-------------------Event--------------------
	
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
}
