package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Loading extends JFrame {

	private JPanel contentPane;
	private static JProgressBar bar = new JProgressBar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Loading frame = new Loading();
		frame.setVisible(true);
		try {
			for(int x = 0; x<=100;x++) {
				Loading.bar.setValue(x);
				Thread.sleep(5);
			}
			new DangNhap().setVisible(true);
			frame.dispose();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * Create the frame.
	 */
	public Loading() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setBounds(100, 100, 627, 301);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		bar.setBounds(10, 261, 600, 30);

		bar.setValue(0);
		bar.setStringPainted(true);
		bar.setFont(new Font("MV Boli", Font.BOLD, 25));
		bar.setForeground(new Color(0,191,255));
		bar.setBackground(Color.BLACK);
		contentPane.add(bar);
		ImageBox imb = new ImageBox("image/logo8rec.png", 500, 175);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(imb);
		panel.setBounds(55, 36, 500, 175);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("2022-12");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(397, 221, 146, 30);
		contentPane.add(lblNewLabel);
		

	}
}
