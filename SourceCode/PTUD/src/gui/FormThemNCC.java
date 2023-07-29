package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import database.ConnectDB;
import dao.DAO_NhaCungCap;
import entity.NhaCungCap;
import entity.NhanVien;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FormThemNCC extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMa;
	private JTextField textFieldTen;
	private JTextField textFieldSDT;
	private JTextField textFieldDc;
	DAO_NhaCungCap dao_NCC= new DAO_NhaCungCap();

	/**
	 * Create the frame.
	 */
	public FormThemNCC() {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				requestFocus();
				toFront();
				setAlwaysOnTop(true);
			}
		});
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblTitle = new JLabel("Thêm nhà cung cấp");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 20, 406, 40);
		panel.add(lblTitle);
		
		JLabel lblMa = new JLabel("Mã nhà cung cấp :");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMa.setBounds(20, 70, 125, 40);
		panel.add(lblMa);
		
		
		JLabel lblTen = new JLabel("Tên nhà cung cấp :");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTen.setBounds(20, 120, 125, 40);
		panel.add(lblTen);
		
		JLabel lblsdt = new JLabel("Số điện thoại :");
		lblsdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblsdt.setBounds(20, 170, 125, 40);
		panel.add(lblsdt);
		
		JLabel lblDc = new JLabel("Địa chỉ :");
		lblDc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDc.setBounds(20, 220, 125, 40);
		panel.add(lblDc);
		
		textFieldMa = new JTextField();
		textFieldMa.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldMa.setOpaque(false);
		textFieldMa.setBounds(155, 78, 156, 28);
		panel.add(textFieldMa);
		textFieldMa.setColumns(10);
		ArrayList<NhaCungCap> list = dao_NCC.getAllNCC();
		textFieldMa.setText(getMaMoi(list));
		textFieldMa.setEditable(false);
		
		textFieldTen = new JTextField();
		textFieldTen.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldTen.setOpaque(false);
		textFieldTen.setColumns(10);
		textFieldTen.setBounds(155, 132, 261, 28);
		panel.add(textFieldTen);
		
		textFieldSDT = new JTextField();
		textFieldSDT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldSDT.setOpaque(false);
		textFieldSDT.setColumns(10);
		textFieldSDT.setBounds(155, 182, 261, 28);
		panel.add(textFieldSDT);
		
		textFieldDc = new JTextField();
		textFieldDc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldDc.setOpaque(false);
		textFieldDc.setColumns(10);
		textFieldDc.setBounds(155, 232, 261, 28);
		panel.add(textFieldDc);
		
		JButton btnNewButton = new JButton("Hủy");
		
		btnNewButton.setBounds(331, 292, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setBounds(226, 292, 85, 21);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 160, 215));
		panel_1.setBounds(0, 0, 426, 15);
		panel.add(panel_1);
		
//---------------Sự kiện-----------------------
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = textFieldMa.getText();
				String ten = textFieldTen.getText();
				String sdt = textFieldSDT.getText();
				String dc = textFieldDc.getText();
				NhaCungCap ncc = new NhaCungCap(ma, ten, sdt, dc);
				if(Rex(ncc)) {
					dao_NCC.createNCC(ncc);
					JOptionPane.showMessageDialog(null,"Thêm thành công");
					dispose();
				}				
			}
		});
	}
	private String getMaMoi(ArrayList<NhaCungCap> list) {
		String str="";
		NhaCungCap ncc = list.get(list.size()-1);
		String ma = ncc.getMaNCC().substring(3);
		int ma3 = Integer.parseInt(ma);
		ma3+=1;
		str = String.format("%04d", ma3);
		return "NCC"+str;
	}
	private boolean Rex(NhaCungCap ncc) {
		String rex = "^[^!@#$%^&*]{1,}([^!@#$%&^*]{1,})";
		Pattern p = Pattern.compile(rex);
		Matcher m = p.matcher(ncc.getTenNCC());
		String rex1 = "^[0]{1}[0-9]{9}$";
		Pattern p1 = Pattern.compile(rex1);
		Matcher m1 = p1.matcher(ncc.getSoDienThoai());
		Matcher m2 = p.matcher(ncc.getDiaChi());
		if(!m.find()) {
			JOptionPane.showMessageDialog(null, "Tên không đúng định dạng"
					+ "\n(Chữ cái đầu viết hoa và không chứa kí tự đặt biệt)",
				      "Hey!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(!m1.find()) {
			JOptionPane.showMessageDialog(null, "SĐT không đúng định dạng"
					+ "\n(Phải đủ 10 số)",
				      "Hey!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(!m2.find()) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không đúng định dạng"
					+ "\n(Chữ cái đầu viết hoa và không chứa kí tự đặt biệt)",
				      "Hey!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
