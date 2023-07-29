package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;


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
import database.ConnectDB;
import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class FormSuaNV extends JFrame {

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
	
	DAO_NhanVien dao_NV = new DAO_NhanVien();
	DAO_TaiKhoan dao_TK = new DAO_TaiKhoan();
	NhanVien nv;
	TaiKhoan tk;
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
	private JTextField textFieldNS;
	private JTextField text_Email;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public FormSuaNV(NhanVien nv, TaiKhoan tk) {
		this.nv = nv;
		this.tk = tk;
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setBounds(100, 100, 603, 668);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 589, 590);
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
			lblaCh.setBounds(42, 315, 112, 45);
			panel.add(lblaCh);
			
			JLabel lblChcV = new JLabel("Chức vụ");
			lblChcV.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblChcV.setBounds(42, 370, 112, 45);
			panel.add(lblChcV);
			
			JLabel lblGiiTnh = new JLabel("Giới tính");
			lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblGiiTnh.setBounds(42, 425, 112, 45);
			panel.add(lblGiiTnh);
			
			JLabel lblNgySinh = new JLabel("Ngày sinh");
			lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNgySinh.setBounds(42, 480, 112, 45);
			panel.add(lblNgySinh);
			
			JLabel lblNgyVoLm = new JLabel("Ngày vào làm");
			lblNgyVoLm.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNgyVoLm.setBounds(42, 535, 112, 45);
			panel.add(lblNgyVoLm);
			
			textFieldMaNV = new JTextField();
			textFieldMaNV.setOpaque(false);
			textFieldMaNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldMaNV.setBounds(164, 103, 225, 27);
			panel.add(textFieldMaNV);
			textFieldMaNV.setColumns(10);
			textFieldMaNV.setText(nv.getMaNV());
			textFieldMaNV.setEditable(false);
			

			
			
			JLabel lblNewLabel_1 = new JLabel("Cập nhật nhân viên");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(10, 37, 569, 45);
			panel.add(lblNewLabel_1);
			
			textFieldTenNV = new JTextField();
			textFieldTenNV.setOpaque(false);
			textFieldTenNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldTenNV.setColumns(10);
			textFieldTenNV.setBounds(164, 162, 225, 27);
			textFieldTenNV.setText(nv.getTenNV());
			panel.add(textFieldTenNV);
			
			
			textFieldSDT = new JTextField();
			textFieldSDT.setOpaque(false);
			textFieldSDT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldSDT.setColumns(10);
			textFieldSDT.setBounds(164, 217, 225, 27);
			textFieldSDT.setText(nv.getSoDienThoai());
			panel.add(textFieldSDT);
			
			textFieldDiaChi = new JTextField();
			textFieldDiaChi.setOpaque(false);
			textFieldDiaChi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldDiaChi.setColumns(10);
			textFieldDiaChi.setBounds(164, 327, 225, 27);
			textFieldDiaChi.setText(nv.getDiaChi());
			panel.add(textFieldDiaChi);
			
			String[] strCV = {"Nhân viên bán hàng","Quản lí"};
			comboBoxCV = new JComboBox(strCV);
			comboBoxCV.setBounds(164, 381, 225, 27);
			comboBoxCV.setSelectedItem(nv.getChucVu());
			panel.add(comboBoxCV);
			
			textFieldNVL = new JTextField();
			textFieldNVL.setOpaque(false);
			textFieldNVL.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldNVL.setColumns(10);
			textFieldNVL.setBounds(164, 547, 225, 27);
			String strDateNVL = dateFormat.format(nv.getNgayVaoLam());  
			textFieldNVL.setText(strDateNVL);
			panel.add(textFieldNVL);
			textFieldNVL.setEditable(false);
			
			ButtonGroup btnG = new ButtonGroup();
			
			rdbtnNam = new JRadioButton("Nam");
			rdbtnNam.setBounds(160, 439, 103, 21);
			panel.add(rdbtnNam);
			
			rdbtnNu = new JRadioButton("Nữ");
			rdbtnNu.setBounds(265, 439, 103, 21);
			panel.add(rdbtnNu);
			
			btnG.add(rdbtnNam);
			btnG.add(rdbtnNu);
			if(nv.getGioiTinh().equalsIgnoreCase("Nam")) {
				rdbtnNam.setSelected(true);
			}
			else {
				rdbtnNu.setSelected(true);
			}
			rdbtnNam.setEnabled(false);
			rdbtnNu.setEnabled(false);
			
			
			textFieldNS = new JTextField();
			textFieldNS.setOpaque(false);
			textFieldNS.setColumns(10);
			textFieldNS.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldNS.setBounds(164, 492, 225, 27);
			String strDateNS = dateFormat.format(nv.getNgaySinh());  
			textFieldNS.setText(strDateNS);
			textFieldNS.setEditable(false);
			panel.add(textFieldNS);
			
			JLabel lbl_Emaik = new JLabel("Email");
			lbl_Emaik.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbl_Emaik.setBounds(42, 257, 112, 45);
			panel.add(lbl_Emaik);
			
			text_Email = new JTextField();
			text_Email.setText(tk.getEmail());
			text_Email.setOpaque(false);
			text_Email.setColumns(10);
			text_Email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			text_Email.setBounds(164, 269, 225, 27);
			panel.add(text_Email);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 160, 215));
			panel_1.setBounds(0, 0, 589, 27);
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
						String tenNV = textFieldTenNV.getText();
						String SDT = textFieldSDT.getText();
						String diaChi = textFieldDiaChi.getText();
						String chucVu = comboBoxCV.getSelectedItem().toString();
						
						nv.setTenNV(tenNV);
						nv.setSoDienThoai(SDT);
						nv.setDiaChi(diaChi);
						nv.setChucVu(chucVu);
						String mail = text_Email.getText();
						tk.setEmail(mail);
						if(Rex(nv,tk)) {
							dao_NV.updateNV(nv);
							dao_TK.updateMail(tk);
							dispose();	
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Hủy");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
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
