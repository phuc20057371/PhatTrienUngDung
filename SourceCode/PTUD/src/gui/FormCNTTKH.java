package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO_KhachHang;
import entity.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;

public class FormCNTTKH extends JFrame {

	private JPanel contentPane;
	private JTextField tf_TenKH;
	private JTextField tf_SDT;
	private JTextField tf_maKH;
	private JLabel lblNewLabel_1;
	private JButton btn_Luu;
	JLabel lbl_KTTen;
	JLabel lbl_KTSDT;
	/**
	 * Launch the application.
	 */

	public JTextField getTf_TenKH() {
		return tf_TenKH;
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

	/**
	 * Create the frame.
	 */
	public FormCNTTKH(KhachHang khachHang) {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Mã KH: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 75, 117, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnKh = new JLabel("Tên KH: ");
		lblTnKh.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnKh.setBounds(10, 120, 117, 26);
		contentPane.add(lblTnKh);
		
		JLabel lblNewLabel_1_1 = new JLabel("SĐT: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 170, 117, 26);
		contentPane.add(lblNewLabel_1_1);
		
		tf_TenKH = new JTextField();
		tf_TenKH.setBounds(137, 121, 244, 26);
		contentPane.add(tf_TenKH);
		tf_TenKH.setColumns(10);
		tf_TenKH.setText(khachHang.getHoTenKhachHang());
		
		tf_SDT = new JTextField();
		tf_SDT.setColumns(10);
		tf_SDT.setBounds(137, 170, 244, 26);
		contentPane.add(tf_SDT);
		tf_SDT.setText(khachHang.getSoDienThoai());
		
		tf_maKH = new JTextField();
		tf_maKH.setColumns(10);
		tf_maKH.setBounds(137, 76, 244, 26);
		contentPane.add(tf_maKH);
		tf_maKH.setText(khachHang.getMaKhachHang());
		tf_maKH.setEditable(false);
		
		lblNewLabel_1 = new JLabel("Cập nhật thông tin khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 426, 37);
		contentPane.add(lblNewLabel_1);
		
		btn_Luu = new JButton("Lưu");
		btn_Luu.setBounds(192, 232, 85, 21);
		contentPane.add(btn_Luu);
		
		lbl_KTTen = new JLabel("");
		lbl_KTTen.setBounds(137, 147, 244, 18);
		contentPane.add(lbl_KTTen);
		 
		lbl_KTSDT = new JLabel("");
		lbl_KTSDT.setBounds(137, 194, 244, 18);
		contentPane.add(lbl_KTSDT);
	}

	public JButton getBtn_Luu() {
		return btn_Luu;
	}

	public void setBtn_Luu(JButton btn_Luu) {
		this.btn_Luu = btn_Luu;
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
		return true;
	}
}
