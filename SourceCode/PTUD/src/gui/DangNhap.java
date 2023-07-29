package gui;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.Image;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;
import database.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.Random;
public class DangNhap extends JFrame implements ActionListener {
	private static Random generator = new Random();
	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField pwdPassword;
	private JButton btnDN,btnNewButton;
	private DAO_TaiKhoan dao = new DAO_TaiKhoan();
	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String specials = "~=+%^*/()[]{}/!@#$?|";
	private static final String ALL = alpha + alphaUpperCase + digits + specials;
	
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	
	/**
	 * Create the frame.
	 */
	public DangNhap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(0, 0, 800, 531);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Đăng nhập");
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel panelDangNhap = new JPanel();
		panelDangNhap.setBackground(new Color(0, 191, 255));
		panelDangNhap.setForeground(new Color(0, 0, 0));
		panelDangNhap.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panelDangNhap.setBounds(397, 0, 400, 500);
		contentPane.add(panelDangNhap);
		panelDangNhap.setLayout(null);
		
		JLabel lblIconDN = new JLabel("");
		lblIconDN.setBackground(new Color(127, 255, 212));
		lblIconDN.setBounds(121, 13, 160, 149);
		panelDangNhap.add(lblIconDN);
		lblIconDN.setIcon(new ImageIcon("image/UsersGroup.png"));
		
		JLabel lblDN = new JLabel("ĐĂNG NHẬP");
		lblDN.setHorizontalAlignment(SwingConstants.CENTER);
		lblDN.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDN.setBounds(142, 169, 139, 25);
		panelDangNhap.add(lblDN);
		
		textFieldUserName = new JTextField("NV0001");
		textFieldUserName.setOpaque(false);
//		textFieldUserName.setForeground(Color.GRAY);
		textFieldUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textFieldUserName.getText().equals("Mã nhân viên")) {
					textFieldUserName.setText("");
					textFieldUserName.setForeground(Color.BLACK);
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldUserName.getText().isEmpty()) {
					textFieldUserName.setForeground(Color.GRAY);
					textFieldUserName.setText("Mã nhân viên");
		        }
			}
		});
		textFieldUserName.setToolTipText("");
		textFieldUserName.setColumns(10);
		textFieldUserName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldUserName.setBackground(new Color(128, 255, 255));
		textFieldUserName.setBounds(51, 226, 298, 34);
		panelDangNhap.add(textFieldUserName);
		
		btnDN = new JButton("ĐĂNG NHẬP");
		contentPane.getRootPane().setDefaultButton(btnDN);
		btnDN.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDN.setOpaque(true);
		btnDN.setIcon(new ImageIcon("image/Accept.png"));
		btnDN.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDN.setBackground(new Color(255, 255, 255));
		btnDN.setBounds(51, 378, 298, 42);
		panelDangNhap.add(btnDN);
		
		btnNewButton = new JButton("Quên mật khẩu ?");
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(51, 430, 298, 34);
		panelDangNhap.add(btnNewButton);
		
		pwdPassword = new JPasswordField("123456");
		panelDangNhap.add(pwdPassword);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Hiện mật khẩu");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected())
			    {
			    	pwdPassword.setEchoChar((char)0);
			    }
				else {
					pwdPassword.setEchoChar('*');
				}
			}
		});
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				chckbxNewCheckBox.setSelected(false);
				pwdPassword.setEchoChar('*');
				    String password = String.valueOf(pwdPassword.getPassword());
				    
				    if(password.toLowerCase().equals("password"))
				    {
				    	pwdPassword.setText("");
				    	pwdPassword.setForeground(Color.black);
				    }
			}
			@Override
			public void focusLost(FocusEvent e) {
				String password = String.valueOf(pwdPassword.getPassword());
			    
			    
			    if(password.toLowerCase().equals("password") || password.toLowerCase().equals("") )
			    {
			    	pwdPassword.setText("Password");
			    	pwdPassword.setEchoChar((char)0);
			    	pwdPassword.setForeground(new Color(153, 153, 153));
			    }
			}
		});
		pwdPassword.setOpaque(false);
		pwdPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pwdPassword.setBounds(51, 286, 298, 34);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(51, 326, 171, 34);
		chckbxNewCheckBox.setSelected(false);
	    
		panelDangNhap.add(chckbxNewCheckBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 55, 350, 350);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		ImageBox imgB = new ImageBox("image/logo8.png", 350, 350);
		imgB.setOpaque(true);
		panel.add(imgB);
		
		contentPane.add(panel);
		
		
		btnDN.addActionListener(this);
		btnNewButton.addActionListener(this);
	}
	public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
	public String randomPassword(int numberOfCharactor) {
        ArrayList<String> result = new ArrayList<>();
        Consumer<String> appendChar = s -> {
            int number = randomNumber(0, s.length() - 1);
            result.add("" + s.charAt(number));
        };
        appendChar.accept(digits);
        appendChar.accept(specials);
        while (result.size() < numberOfCharactor) {
            appendChar.accept(ALL);
        }
        Collections.shuffle(result, generator);
        return String.join("", result);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pass = pwdPassword.getText();
		Object o = e.getSource();
		if (o.equals(btnDN)) {
			String id = textFieldUserName.getText();
			String pw = pwdPassword.getText();
			try {
				ConnectDB.getInstance().connect();
				dao.getAllTaiKhoan();
				TaiKhoan tk = dao.getObject(id);
				if (tk == null || !pw.equals(tk.getMatKhau())) {
					JOptionPane.showMessageDialog(this,"Tài khoản không hợp lệ");
				}else {
					DAO_NhanVien daoNV = new DAO_NhanVien();
					NhanVien nv = new NhanVien();
					for(NhanVien nvv: daoNV.getAllNhanVien()) {
						if(nvv.getMaNV().equalsIgnoreCase(id)) {
							nv=nvv;
						}
					}
					if(nv.getChucVu().equalsIgnoreCase("Quản lí")) {
//						JOptionPane.showMessageDialog(this,"Đăng nhập thành công");
						new Form_TrangChu_QuanLi(nv).setVisible(true);				
						dispose();
					}
					else {
						try {
							
//							JOptionPane.showMessageDialog(this,"Đăng nhập thành công");
							new FormNhanVien(nv).setVisible(true);
							dispose();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
//					System.out.println(randomPassword(6));
					
					
				}
			}catch (SQLException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}
		if (o.equals(btnNewButton)) {
			if(JOptionPane.showConfirmDialog(null,"Bạn có muốn gởi về mật khẩu mới","Gửi mật khẩu",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				String id = textFieldUserName.getText();
				try {
					ConnectDB.getInstance().connect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dao.getAllTaiKhoan();
				String maNV = JOptionPane.showInputDialog("Nhập mã nhân viên: ");
				TaiKhoan tk1 = dao.getObject(maNV);
				if(tk1==null) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy tài khoản");
				}else {		
					dao.getAllTaiKhoan();
					tk1 = dao.getObject(maNV);
					String s = "Địa chỉ mail của bạn là: "+tk1.getEmail();
					if (JOptionPane.showConfirmDialog(this,s,"Địa chỉ mail của bạn",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(this,"Chúng tôi đã gởi mật khẩu về địa chỉ mail của bạn");
						String ran = randomPassword(6);
						String mail = tk1.getEmail();					
						String host = "smtp.gmail.com";
						Properties prop = new Properties();
						prop.put("mail.smtp.host", host);
						prop.put("mail.smtp.port", "465");
						prop.put("mail.smtp.auth", "true");
						prop.put("mail.smtp.ssl.enable", "true");

						Session session = Session.getInstance(prop, new Authenticator()  {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication("huongdamdang112@gmail.com", "xkaynrihxhwujwqp");
							}
						});
						session.setDebug(true);
						try {
							Message message = new MimeMessage(session);
							message.setFrom(new InternetAddress(mail));
							message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
							message.setSubject("Mã Xác Nhận");
							String t = "Mã xác nhận mật khẩu của bạn";
							message.setText(t +": "+ran);
							System.out.println("Sending....");
							Transport.send(message);
							System.out.println("Sending Successfull....");

						} catch (MessagingException messEx) {
							// TODO: handle exception
							messEx.printStackTrace();
						
						}
						String maXN= JOptionPane.showInputDialog("Nhập mã xác nhận: ");
						if (maXN.contains(ran)) {
						String mkMoi =	JOptionPane.showInputDialog("Nhập mật khẩu mới: ");
						dao.updatMatKhau(maNV, mkMoi);
						JOptionPane.showMessageDialog(this,"Đổi mật khẩu thành công");
						}
					}
				}
			
			}
			}
		}
//	public static void main(String[] args) {
////		try {
////			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
////		} catch (ClassNotFoundException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		} catch (InstantiationException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		} catch (IllegalAccessException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		} catch (UnsupportedLookAndFeelException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
//		new DangNhap().setVisible(true);
//
//
//	}
}
