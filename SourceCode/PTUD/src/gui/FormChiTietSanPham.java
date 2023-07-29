package gui;


import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

import entity.ChiTietSanPham;
import entity.SanPham;

import javax.swing.BoxLayout;

public class FormChiTietSanPham extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public FormChiTietSanPham(SanPham sp) {
		setBounds(300, 300, 925, 518);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setTitle("Chi tiết sản phẩm"+"-"+sp.getTenSanPham());
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(336, 10, 121, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(sp.getMaSanPham());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(467, 10, 155, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(336, 61, 121, 25);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel(sp.getTenSanPham());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(467, 61, 311, 25);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Size :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(336, 113, 121, 25);
		getContentPane().add(lblNewLabel_1_1_1);
		
		String strSize = " " ;
		String strMau = " " ;
		for (ChiTietSanPham ct : sp.getChiTietSanPham()) {
			if(!strSize.contains(ct.getSize())) {
				strSize += ct.getSize() + " ,";
			}
			if(!strMau.contains(ct.getMau())) {
				strMau += ct.getMau() + " ,";
			}
			
		}
		
		JLabel lblNewLabel_3_1 = new JLabel(strSize);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(467, 113, 434, 25);
		getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Xuất xứ :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(336, 258, 121, 25);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(sp.getXuatXu().getTenXX());
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(467, 258, 155, 25);
		getContentPane().add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Loại :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(336, 212, 121, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel(sp.getLoai());
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1.setBounds(467, 212, 155, 25);
		getContentPane().add(lblNewLabel_3_1_1_1);
		
		JTextArea textArea = new JTextArea(sp.getMoTa());
		textArea.setBounds(10, 365, 891, 101);
		textArea.setEditable(false);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_2 = new JLabel("Chất liệu :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(632, 212, 121, 25);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel(sp.getChatLieu().getTenCL());
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1_2.setBounds(763, 212, 155, 25);
		getContentPane().add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Màu :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(336, 165, 121, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel(strMau);
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_2.setBounds(467, 165, 434, 25);
		getContentPane().add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Thương hiệu :");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2.setBounds(632, 258, 121, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_3_1_1_2_1 = new JLabel(sp.getThuongHieu().getTenTH());
		lblNewLabel_3_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1_2_1.setBounds(763, 258, 155, 25);
		getContentPane().add(lblNewLabel_3_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Giới tính :");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2_1.setBounds(336, 306, 121, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_2_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1 = new JLabel(sp.getGioiTinh());
		lblNewLabel_3_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1_2_1_1.setBounds(467, 306, 311, 25);
		getContentPane().add(lblNewLabel_3_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2_1_1 = new JLabel("Mô tả:");
		lblNewLabel_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2_1_1.setBounds(10, 330, 121, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_2_1_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 310, 310);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panel.add(new ImageBox(sp.getHinhAnh(), 310, 310));
		
		JLabel lblNewLabel_1_3 = new JLabel("Trạng thái :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(632, 10, 121, 25);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_1 = new JLabel(sp.getTinhTrang());
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(763, 10, 155, 25);
		getContentPane().add(lblNewLabel_2_1);
	}
}
