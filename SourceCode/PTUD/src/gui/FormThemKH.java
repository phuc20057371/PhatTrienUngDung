package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import dao.DAO_KhachHang;
import entity.KhachHang;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class FormThemKH extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_TenKH;
	private JTextField tf_SDT;
	private JLabel lbl_KTTen, lbl_KTSDT;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btn_XacNhan;
	private JLabel lblNewLabel_3;
	public JTextField textField;
	private JLabel lbl_KTTen_1;
	private JLabel lblNewLabel_4;

	public JTextField getTf_TenKH() {
		return tf_TenKH;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setTf_TenKH(JTextField tf_TenKH) {
		this.tf_TenKH = tf_TenKH;
	}

	public JTextField getTf_SDT() {
		return tf_SDT;
	}

	public void setTf_SDT(JTextField tf_SDT) {
		this.tf_SDT = tf_SDT;
	}

	public JButton getBtn_XacNhan() {
		return btn_XacNhan;
	}

	public void setBtn_XacNhan(JButton btn_XacNhan) {
		this.btn_XacNhan = btn_XacNhan;
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public FormThemKH() {
		setBounds(100, 100, 500, 430);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Thêm mới khách hàng");
		tf_TenKH = new JTextField();
		tf_TenKH.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
		tf_TenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_TenKH.setBounds(131, 187, 321, 30);
		contentPanel.add(tf_TenKH);
		tf_TenKH.setColumns(10);
		
		tf_SDT = new JTextField();
		tf_SDT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
		tf_SDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_SDT.setColumns(10);
		tf_SDT.setBounds(131, 268, 321, 30);
		contentPanel.add(tf_SDT);
		
		btn_XacNhan = new JButton("Xác nhận");
		btn_XacNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_XacNhan.setBounds(182, 350, 100, 30);
		contentPanel.add(btn_XacNhan);
		
		JLabel lblNewLabel = new JLabel("THÊM KHÁCH HÀNG MỚI");
		lblNewLabel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 38, 464, 65);
		contentPanel.add(lblNewLabel);
		
		lbl_KTTen = new JLabel("");
		
		lbl_KTTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_KTTen.setBounds(92, 227, 360, 30);
		contentPanel.add(lbl_KTTen);
		
		lbl_KTSDT = new JLabel("");
		lbl_KTSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_KTSDT.setBounds(92, 309, 360, 30);
		contentPanel.add(lbl_KTSDT);
		
		lblNewLabel_1 = new JLabel("Tên KH: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 187, 84, 30);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("SĐT: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 267, 111, 30);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mã KH: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 106, 84, 30);
		contentPanel.add(lblNewLabel_3);
		
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
		textField.setBounds(131, 106, 165, 30);
		contentPanel.add(textField);
		
		lbl_KTTen_1 = new JLabel("");
		lbl_KTTen_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_KTTen_1.setBounds(92, 146, 360, 30);
		contentPanel.add(lbl_KTTen_1);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(0, 191, 255));
		lblNewLabel_4.setBounds(0, 0, 484, 30);
		contentPanel.add(lblNewLabel_4);
		tf_TenKH.requestFocus();
		
		tf_TenKH.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ktTenKH();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ktTenKH();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ktTenKH();
			}
		});
		
		tf_SDT.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ktSDT();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ktSDT();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ktSDT();
			}
		});
	}
	
	public boolean ktTenKH() {
		String tenKH = tf_TenKH.getText();
		
		String rex = "^[^!@#$%^&*]{1,}([^!@#$%&^*]{1,})";						
		Pattern p = Pattern.compile(rex);
		Matcher m = p.matcher(tf_TenKH.getText());
		if(!m.find()) {
			lbl_KTTen.setForeground(new Color(255, 0, 0));
			lbl_KTTen.setText("(Chữ cái đầu viết hoa và không chứa kí tự đặt biệt)");
			return false;
		}
		if(tenKH.equals("")) {
			lbl_KTTen.setForeground(new Color(255, 0, 0));
			lbl_KTTen.setText("Tên khách hàng không được để trống.");
			return false;
		} else {
			lbl_KTTen.setText("");
			return true;
		}
	}
	
	public boolean ktSDT() {
		String sdt = tf_SDT.getText();
		
		String rex1 = "^[0]{1}[0-9]{9}$";
		Pattern p1 = Pattern.compile(rex1);
		Matcher m1 = p1.matcher(tf_SDT.getText());
		if(!m1.find()) {
			lbl_KTSDT.setForeground(new Color(255, 0, 0));
			lbl_KTSDT.setText("Phải đủ 10 số và bắt đầu là số 0");
			return false;
			
		}
		
		if(sdt.equals("")) {
			lbl_KTSDT.setForeground(new Color(255, 0, 0));
			lbl_KTSDT.setText("Số điện thoại không được để trống.");
			return false;
		}
		
		else {
			Boolean b = false;
			ArrayList<KhachHang> listKH = new DAO_KhachHang().getAllKhachHang();
			for (KhachHang khachHang : listKH) {
				if(sdt.equals(khachHang.getSoDienThoai())) {
					b = true;
					break;
				}
			}
			if(b) {
				lbl_KTSDT.setForeground(new Color(255, 0, 0));
				lbl_KTSDT.setText("Số điện thoại đã tồn tại.");
				return false;
			} else {
				lbl_KTSDT.setText("");
				return true;
			}
		}
	}
}
