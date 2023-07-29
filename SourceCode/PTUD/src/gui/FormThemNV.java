package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import entity.NhanVien;
import entity.TaiKhoan;

import com.toedter.calendar.JDateChooser;

import database.ConnectDB;
import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FormThemNV extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMaNV;
	private JTextField textFieldTenNV;
	private JTextField textFieldSDT;
	private JTextField textFieldDiaChi;
	private JTextField textFieldNVL;
	private JComboBox comboBoxCV;
	JRadioButton rdbtnNam;
	JRadioButton rdbtnNu;
	JDateChooser dateChooser;
	
	DAO_NhanVien dao_NV = new DAO_NhanVien();
	DAO_TaiKhoan dao_TK = new DAO_TaiKhoan();
	private JTextField text_Email;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public FormThemNV() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setBounds(100, 100, 603, 666);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 589, 588);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblMaNV = new JLabel("Mã nhân viên");
			lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMaNV.setBounds(42, 92, 112, 45);
			panel.add(lblMaNV);
			
			JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
			lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTnNhnVin.setBounds(42, 147, 112, 45);
			panel.add(lblTnNhnVin);
			
			JLabel lblSinThoi = new JLabel("Số điện thoại");
			lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblSinThoi.setBounds(42, 202, 112, 45);
			panel.add(lblSinThoi);
			
			JLabel lblaCh = new JLabel("Địa chỉ");
			lblaCh.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblaCh.setBounds(42, 313, 112, 45);
			panel.add(lblaCh);
			
			JLabel lblChcV = new JLabel("Chức vụ");
			lblChcV.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblChcV.setBounds(42, 368, 112, 45);
			panel.add(lblChcV);
			
			JLabel lblGiiTnh = new JLabel("Giới tính");
			lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblGiiTnh.setBounds(42, 423, 112, 45);
			panel.add(lblGiiTnh);
			
			JLabel lblNgySinh = new JLabel("Ngày sinh");
			lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNgySinh.setBounds(42, 478, 112, 45);
			panel.add(lblNgySinh);
			
			JLabel lblNgyVoLm = new JLabel("Ngày vào làm");
			lblNgyVoLm.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNgyVoLm.setBounds(42, 533, 112, 45);
			panel.add(lblNgyVoLm);
			
			textFieldMaNV = new JTextField();
			textFieldMaNV.setOpaque(false);
			textFieldMaNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldMaNV.setBounds(164, 103, 225, 27);
			panel.add(textFieldMaNV);
			textFieldMaNV.setColumns(10);
			textFieldMaNV.setEditable(false);
			
			ArrayList<NhanVien> arrNV = dao_NV.getAllNhanVien();	
			textFieldMaNV.setText(getMaMoi(arrNV));
			
			
			JLabel lblNewLabel_1 = new JLabel("Thêm mới nhân viên");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(10, 48, 569, 45);
			panel.add(lblNewLabel_1);
			
			textFieldTenNV = new JTextField();
			textFieldTenNV.setOpaque(false);
			textFieldTenNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldTenNV.setColumns(10);
			textFieldTenNV.setBounds(164, 162, 225, 27);
			panel.add(textFieldTenNV);
			
			textFieldSDT = new JTextField();
			textFieldSDT.setOpaque(false);
			textFieldSDT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldSDT.setColumns(10);
			textFieldSDT.setBounds(164, 217, 225, 27);
			panel.add(textFieldSDT);
			
			textFieldDiaChi = new JTextField();
			textFieldDiaChi.setOpaque(false);
			textFieldDiaChi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldDiaChi.setColumns(10);
			textFieldDiaChi.setBounds(164, 325, 225, 27);
			panel.add(textFieldDiaChi);
			
			String[] strCV = {"Nhân viên bán hàng","Quản lí"};
			comboBoxCV = new JComboBox(strCV);
			comboBoxCV.setBounds(164, 379, 225, 27);
			panel.add(comboBoxCV);
			
			textFieldNVL = new JTextField();
			textFieldNVL.setOpaque(false);
			textFieldNVL.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldNVL.setColumns(10);
			textFieldNVL.setBounds(164, 545, 225, 27);
			panel.add(textFieldNVL);
			
			long millis=System.currentTimeMillis();   
			java.sql.Date date=new java.sql.Date(millis);
			String pattern = "dd-MM-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String str = simpleDateFormat.format(date);
			
			textFieldNVL.setText(String.valueOf(str));
			textFieldNVL.setEditable(false);
			
			ButtonGroup btnG = new ButtonGroup();
			
			rdbtnNam = new JRadioButton("Nam");
			rdbtnNam.setBounds(160, 437, 103, 21);
			panel.add(rdbtnNam);
			rdbtnNam.setSelected(true);
			
			rdbtnNu = new JRadioButton("Nữ");
			rdbtnNu.setBounds(265, 437, 103, 21);
			panel.add(rdbtnNu);
			
			btnG.add(rdbtnNam);
			btnG.add(rdbtnNu);
			
			dateChooser = new JDateChooser();
			dateChooser.setBounds(161, 496, 228, 27);	
			panel.add(dateChooser);
			
			JLabel lbl_email = new JLabel("Email");
			lbl_email.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbl_email.setBounds(42, 258, 112, 45);
			panel.add(lbl_email);
			
			text_Email = new JTextField();
			text_Email.setOpaque(false);
			text_Email.setColumns(10);
			text_Email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			text_Email.setBounds(164, 273, 225, 27);
			panel.add(text_Email);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 160, 215));
			panel_1.setBounds(0, 0, 589, 30);
			panel.add(panel_1);
			

		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Xác nhận");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String maNV = textFieldMaNV.getText();
						String tenNV = textFieldTenNV.getText();
						String SDT = textFieldSDT.getText();
						String email=text_Email.getText();
						String diaChi = textFieldDiaChi.getText();
						String chucVu = comboBoxCV.getSelectedItem().toString();
						String gt =null;
						if(rdbtnNam.isSelected()) {
							gt = "0";
						}
						else if(rdbtnNu.isSelected()) {
							gt = "1";
						}
						
						int ngay=-1;
						int thang=-1;
						int nam=-1;
						try {
							ngay = dateChooser.getDate().getDate();
							thang = dateChooser.getDate().getMonth();
							nam = dateChooser.getDate().getYear();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Hãy chọn ngày sinh","ERROR", JOptionPane.ERROR_MESSAGE);
						}
						
						if(!(ngay==-1&&thang==-1&&nam==-1)) {
							Date ngaySinh = new Date(nam,thang-1,ngay);
							
							long millis=System.currentTimeMillis();   
							Date date=new Date(millis);
							
							
							NhanVien nv = new NhanVien(maNV, tenNV, SDT, diaChi, chucVu, gt, ngaySinh, date);
							TaiKhoan tk = new TaiKhoan(maNV,"123456", email, nv);
							if(Rex(nv,tk)) {
								try {
									dao_NV.createNV(nv);
									dao_TK.createTK(tk);
									JOptionPane.showMessageDialog(null,"Thêm thành công");
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(null,"Thêm thất bại","ERROR",JOptionPane.ERROR_MESSAGE,null);
								}
								dispose();
							}
						}
						
						
						
					}

					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Hủy");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	public String getMaMoi(ArrayList<NhanVien> list) {
		
		String str = null;
		NhanVien nv = list.get(list.size()-1);
		str = nv.getMaNV().substring(2);
		int ma = Integer.parseInt(str);
		ma=ma+1;
		String fm = String.format("%04d", ma);
		fm = "NV"+fm;
		return fm;
	}
	private boolean Rex(NhanVien nv, TaiKhoan tk) {
		String rex = "^[^!@#$%^&*]{1,}([^!@#$%&^*]{1,})";						
		Pattern p = Pattern.compile(rex);
		Matcher m = p.matcher(nv.getTenNV());
		Matcher mm = p.matcher(nv.getDiaChi());
		if(!m.find()) {
			JOptionPane.showMessageDialog(null, "Tên không đúng định dạng"
					+ "\n(Chữ cái đầu viết hoa và không chứa kí tự đặt biệt)",
				      "Hey!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (!mm.find()) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không đúng định dạng"
					+ "\n(Chữ cái đầu viết hoa và không chứa kí tự đặt biệt)",
				      "Hey!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		String rex1 = "^[0]{1}[0-9]{9}$";
		Pattern p1 = Pattern.compile(rex1);
		Matcher m1 = p1.matcher(nv.getSoDienThoai());
		if(!m1.find()) {
			JOptionPane.showMessageDialog(null, "SĐT không đúng định dạng"
					+ "\n(Phải đủ 10 số) và bắt đầu là số 0",
				      "Hey!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		String rex2 = "^[a-zA-Z0-9]{1,}@gmail.com$";
		Pattern p2 = Pattern.compile(rex2);
		Matcher m2 = p2.matcher(tk.getEmail());
		if(!m2.find()) {
			JOptionPane.showMessageDialog(null, "Email không đúng định dạng"
					+ "\n(Mẫu : xxx@gmail.com)",
				      "Hey!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		long millis=System.currentTimeMillis();   
		Date date=new Date(millis);
		if(date.getYear()-nv.getNgaySinh().getYear()<18) {
			JOptionPane.showMessageDialog(null, "Nhân viên không đủ 18 tuổi",
				      "Hey!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
