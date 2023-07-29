package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import dao.DAO_TaiKhoan;
import database.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form_DMK extends JFrame {

	private JPanel contentPane;
	private JTextField text_MKC;
	private JTextField text_MKM;
	private JTextField text_MKM2;
	private JTextField text_Loi;
	DAO_TaiKhoan dao_TK ;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() { 
//			public void run() {
//				NhanVien nv = new NhanVien("NV0001","Hồ Ngọc Thủy Ly","0909090909","Q.Gò Vấp,Tp.HCM"
//						,"Quản lí","Nam",new Date(2002,8,2),new Date(2002,8,2));
//				TaiKhoan tk = new TaiKhoan("NV0001","123456","foxfessor@gmail.com",nv);
//				try {
//					 
//					Form_DMK frame = new Form_DMK(nv,tk);
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
	public Form_DMK(NhanVien nv,TaiKhoan tk) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 491, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Đổi mật khẩu");
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 477, 264);
		contentPane.add(panel);
		panel.setLayout(null);
		
		setLocationRelativeTo(null);
		dao_TK = new DAO_TaiKhoan();
		JLabel lblNewLabel = new JLabel("Đổi mật khẩu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 457, 40);
		panel.add(lblNewLabel);
		
		JLabel lbl_TK = new JLabel("Tài khoản");
		lbl_TK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TK.setBounds(10, 60, 115, 23);
		panel.add(lbl_TK);
		
		JLabel lbl_MKC = new JLabel("Mật khẩu củ");
		lbl_MKC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MKC.setBounds(10, 93, 115, 23);
		panel.add(lbl_MKC);
		
		JLabel lbl_MKM = new JLabel("Mật khẩu mới");
		lbl_MKM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MKM.setBounds(10, 126, 194, 23);
		panel.add(lbl_MKM);
		
		JLabel lbl_MKM2 = new JLabel("Nhập lại mật khẩu mới");
		lbl_MKM2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MKM2.setBounds(10, 159, 194, 23);
		panel.add(lbl_MKM2);
		
		JLabel lbl_TK1 = new JLabel(tk.getId());
		lbl_TK1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TK1.setBounds(214, 60, 253, 23);
		panel.add(lbl_TK1);
		
		text_MKC = new JTextField();
		text_MKC.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_MKC.setOpaque(false);
		text_MKC.setBounds(214, 93, 253, 23);
		panel.add(text_MKC);
		text_MKC.setColumns(10);
		
		text_MKM = new JTextField();
		text_MKM.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_MKM.setOpaque(false);
		text_MKM.setColumns(10);
		text_MKM.setBounds(214, 126, 253, 23);
		panel.add(text_MKM);
		
		text_MKM2 = new JTextField();
		text_MKM2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		text_MKM2.setOpaque(false);
		text_MKM2.setColumns(10);
		text_MKM2.setBounds(214, 159, 253, 23);
		panel.add(text_MKM2);
		
		JButton btn_T = new JButton("Thoát");
		btn_T.setBounds(354, 226, 108, 28);
		panel.add(btn_T);
		
		JButton btn_XN = new JButton("Xác nhận");
		btn_XN.setBounds(236, 226, 108, 28);
		panel.add(btn_XN);
		
		text_Loi = new JTextField();
		text_Loi.setForeground(Color.RED);
		text_Loi.setFont(new Font("Tahoma", Font.ITALIC, 10));
		text_Loi.setOpaque(false);
		text_Loi.setColumns(10);
		text_Loi.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		text_Loi.setBounds(214, 192, 253, 23);
		panel.add(text_Loi);
		
		btn_XN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ktMK(tk.getMatKhau(),text_MKC,text_MKM,text_MKM2,text_Loi)) {
					int i = JOptionPane.showConfirmDialog(null,"Xác nhận đổi mật khẩu");
					if(i==JOptionPane.YES_OPTION) {
						tk.setMatKhau(text_MKM.getText());
						dao_TK.updateTK(tk);
						JOptionPane.showMessageDialog(null, "Cập nhật tài khoản thành công");
						dispose();
					}
				}
			}
		});
		btn_T.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	private boolean ktMK(String mk,JTextField t1, JTextField t2, JTextField t3, JTextField t4) {
		String tt1 = t1.getText();
		String tt2 = t2.getText();
		String tt3 = t3.getText();
		if(!tt1.equals(mk)) {
			t4.setText("Sai mật khẩu");
			return false;
		}
		else if(tt2.length()>19||tt3.length()>19) {
			t4.setText("Mật khẩu quá dài (<19)");
			return false;
		}
		else if (!tt2.equals(tt3)){
			t4.setText("Hai mật khẩu không khớp");
			return false;
		}
		
		return true;
	}
}
