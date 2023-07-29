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

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Form_TT_NV extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMaNV;
	private JTextField textFieldTenNV;
	private JTextField textFieldSDT;
	private JTextField textFieldDiaChi;
	JRadioButton rdbtnNam;
	JRadioButton rdbtnNu;
	
	DAO_NhanVien dao_NV = new DAO_NhanVien();
	DAO_TaiKhoan dao_TK = new DAO_TaiKhoan();
	NhanVien nv;
	TaiKhoan tk;
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
	private JTextField text_Email;
	private JTextField text_CV;
	/**
	 * Create the dialog.
	 */
	public Form_TT_NV(NhanVien nv, TaiKhoan tk) {
		this.nv = nv;
		this.tk = tk;
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setBounds(100, 100, 433, 633);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Thông tin nhân viên");
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 419, 561);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblMaNV = new JLabel("Mã nhân viên");
			lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMaNV.setBounds(42, 112, 112, 45);
			panel.add(lblMaNV);
			
			JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
			lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTnNhnVin.setBounds(42, 167, 112, 45);
			panel.add(lblTnNhnVin);
			
			JLabel lblSinThoi = new JLabel("Số điện thoại");
			lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblSinThoi.setBounds(42, 222, 112, 45);
			panel.add(lblSinThoi);
			
			JLabel lblaCh = new JLabel("Địa chỉ");
			lblaCh.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblaCh.setBounds(42, 335, 112, 45);
			panel.add(lblaCh);
			
			JLabel lblChcV = new JLabel("Chức vụ");
			lblChcV.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblChcV.setBounds(42, 390, 112, 45);
			panel.add(lblChcV);
			
			JLabel lblGiiTnh = new JLabel("Giới tính");
			lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblGiiTnh.setBounds(42, 445, 112, 45);
			panel.add(lblGiiTnh);
			
			textFieldMaNV = new JTextField();
			textFieldMaNV.setOpaque(false);
			textFieldMaNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldMaNV.setBounds(164, 123, 225, 27);
			panel.add(textFieldMaNV);
			textFieldMaNV.setColumns(10);
			textFieldMaNV.setText(nv.getMaNV());
			textFieldMaNV.setEditable(false);
			

			
			
			JLabel lblNewLabel_1 = new JLabel("Thông tin nhân viên");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(10, 55, 384, 58);
			panel.add(lblNewLabel_1);
			
			textFieldTenNV = new JTextField();
			textFieldTenNV.setOpaque(false);
			textFieldTenNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldTenNV.setColumns(10);
			textFieldTenNV.setBounds(164, 182, 225, 27);
			textFieldTenNV.setText(nv.getTenNV());
			textFieldTenNV.setEditable(false);
			panel.add(textFieldTenNV);
			
			
			textFieldSDT = new JTextField();
			textFieldSDT.setOpaque(false);
			textFieldSDT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldSDT.setColumns(10);
			textFieldSDT.setBounds(164, 237, 225, 27);
			textFieldSDT.setText(nv.getSoDienThoai());
			textFieldSDT.setEditable(false);
			panel.add(textFieldSDT);
			
			textFieldDiaChi = new JTextField();
			textFieldDiaChi.setOpaque(false);
			textFieldDiaChi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			textFieldDiaChi.setColumns(10);
			textFieldDiaChi.setBounds(164, 347, 225, 27);
			textFieldDiaChi.setText(nv.getDiaChi());
			textFieldDiaChi.setEditable(false);
			panel.add(textFieldDiaChi);
			String strDateNVL = dateFormat.format(nv.getNgayVaoLam());
			
			ButtonGroup btnG = new ButtonGroup();
			
			rdbtnNam = new JRadioButton("Nam");
			rdbtnNam.setBounds(160, 459, 103, 21);
			panel.add(rdbtnNam);
			
			rdbtnNu = new JRadioButton("Nữ");
			rdbtnNu.setBounds(265, 459, 103, 21);
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
			String strDateNS = dateFormat.format(nv.getNgaySinh());
			
			JLabel lbl_Emaik = new JLabel("Email");
			lbl_Emaik.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbl_Emaik.setBounds(42, 277, 112, 45);
			panel.add(lbl_Emaik);
			
			text_Email = new JTextField();
			text_Email.setText(tk.getEmail());
			text_Email.setOpaque(false);
			text_Email.setColumns(10);
			text_Email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			text_Email.setBounds(164, 289, 225, 27);
			panel.add(text_Email);
			
			JButton btnNewButton = new JButton("Đổi mật khẩu");
			btnNewButton.setBounds(42, 500, 150, 36);
			panel.add(btnNewButton);
			
			text_CV = new JTextField();
			text_CV.setText(nv.getChucVu());
			text_CV.setOpaque(false);
			text_CV.setEditable(false);
			text_CV.setColumns(10);
			text_CV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			text_CV.setBounds(164, 382, 225, 27);
			panel.add(text_CV);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 160, 215));
			panel_1.setBounds(0, 0, 419, 27);
			panel.add(panel_1);
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Form_DMK(nv,tk).setVisible(true);
				}
			});
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Thoát");
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
}
