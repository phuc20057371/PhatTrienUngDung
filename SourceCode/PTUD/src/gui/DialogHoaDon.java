package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.Desktop;
import java.io.File;
import java.awt.Color;

public class DialogHoaDon extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static DialogHoaDon dialogHoaDon;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public DialogHoaDon(String mess, String path) {
		setModal(true);
		setBounds(100, 100, 500, 153);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		contentPanel.setBounds(0, 0, 486, 116);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JButton btn_XemHD = new JButton("Xem hóa đơn");
		btn_XemHD.setBounds(170, 85, 150, 25);
		contentPanel.add(btn_XemHD);
		btn_XemHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  try {

						File pdfFile = new File(path);
						if (pdfFile.exists()) {

							if (Desktop.isDesktopSupported()) {
								Desktop.getDesktop().open(pdfFile);
								dispose();
							} else {
								System.out.println("Awt Desktop is not supported!");
							}

						} else {
							System.out.println("File is not exists!");
						}

						System.out.println("Done");

					  } catch (Exception ex) {
						ex.printStackTrace();
					  }
				  dispose();
			}
			
		});
		
//		JButton btnBack = new JButton("Thoát");
//		btnBack.setBounds(351, 85, 125, 25);
//		contentPanel.add(btnBack);
////		btnBack.addActionListener(new ActionListener() {
////			
////			@Override
////			public void actionPerformed(ActionEvent e) {
////				// TODO Auto-generated method stub
////				 dispose();
////			}
////		});
		
		JLabel lblNewLabel = new JLabel(mess);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 35, 480, 25);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 191, 255));
		lblNewLabel_1.setBounds(0, 0, 490, 23);
		contentPanel.add(lblNewLabel_1);
		
	}
}
