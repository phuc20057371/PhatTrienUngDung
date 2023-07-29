package gui;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dao.Dao_SanPham;
import entity.ChiTietSanPham;
import entity.SanPham;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import javax.swing.BoxLayout;

public class PanelItemGioHang extends JPanel implements ActionListener {

	private SanPham sp;
	private ChiTietSanPham ctsp;
	int xoa;
	private JPanel panel_deleteIcon;
	JLabel lblDeleteIcon;
	JSpinner spinner;
	JLabel lbl_ThanhTien1;
	JPanel panel;
	
	/**
	 * @wbp.parser.constructor
	 */

	public PanelItemGioHang(ChiTietSanPham ctsp) {

		// setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(new Color(255, 255, 255));
		this.ctsp = ctsp;
		this.sp = new Dao_SanPham().getSanPham_Ma(ctsp.getMaSanPham());
		

		setPreferredSize(new Dimension(415, 115));
		setLayout(null);

		JPanel panel_HinhAnh = new JPanel();
		panel_HinhAnh.setBackground(new Color(240, 240, 240));
		panel_HinhAnh.setBounds(0, 0, 105, 105);
		panel_HinhAnh.setLayout(new BoxLayout(panel_HinhAnh, BoxLayout.X_AXIS));

		panel_HinhAnh.add(new ImageBox(sp.getHinhAnh(), 105, 105));

//		ImageIcon imageIcon = new ImageIcon(sp.getHinhAnh()); // load the image to a imageIcon
//		
//		Image image = imageIcon.getImage(); // transform it 
//		Image newimg = image.getScaledInstance(105, 105, Image.SCALE_SMOOTH); // scale it the smooth way  
//		imageIcon = new ImageIcon(newimg);
		add(panel_HinhAnh);

		panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(105, 0, 300, 105);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("SL: ");
		lblNewLabel_5.setBounds(10, 82, 40, 13);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_2 = new JLabel("Size: ");
		lblNewLabel_2.setBounds(10, 56, 45, 13);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Màu: ");
		lblNewLabel_1.setBounds(10, 33, 45, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Tên: ");
		lblNewLabel.setBounds(10, 10, 45, 13);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel(ctsp.getSize());
		lblNewLabel_3.setBounds(40, 56, 45, 13);
		panel.add(lblNewLabel_3);

		SpinnerModel value = new SpinnerNumberModel(1, 1, 100, 1);
		spinner = new JSpinner(value);
		panel.add(spinner);
		spinner.setBounds(33, 79, 35, 20);


		panel_deleteIcon = new JPanel();
		panel_deleteIcon.setBackground(new Color(255, 255, 255));
		panel_deleteIcon.setBounds(275, 0, 16, 16);
		panel.add(panel_deleteIcon);
		panel_deleteIcon.setLayout(null);

		lblDeleteIcon = new JLabel("");
		lblDeleteIcon.setIcon(new ImageIcon("image/x icon.png"));
		lblDeleteIcon.setBounds(0, 0, 16, 16);
		panel_deleteIcon.add(lblDeleteIcon);

		JLabel lbl_DonGia = new JLabel("Đơn giá: ");
		lbl_DonGia.setBounds(95, 56, 65, 13);
		panel.add(lbl_DonGia);

		JLabel lbl_ThanhTien = new JLabel("Thành tiền: ");
		lbl_ThanhTien.setBounds(94, 82, 70, 13);
		panel.add(lbl_ThanhTien);

		JLabel lbl_MauOut = new JLabel(ctsp.getMau());
		lbl_MauOut.setBounds(40, 33, 45, 13);
		panel.add(lbl_MauOut);


		Locale localeVN = new Locale("vi", "VN");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
		numberFormat.setCurrency(Currency.getInstance(localeVN));

		JLabel lbl_DonGia_2 = new JLabel(numberFormat.format(sp.getGiaGoc()));
		lbl_DonGia_2.setBounds(160, 56, 100, 13);
		panel.add(lbl_DonGia_2);

		JLabel lbl_Ten1 = new JLabel(sp.getTenSanPham());
		lbl_Ten1.setBounds(40, 10, 225, 13);
		panel.add(lbl_Ten1);

		lbl_ThanhTien1 = new JLabel();
		lbl_ThanhTien1.setBounds(170, 82, 100, 13);
		panel.add(lbl_ThanhTien1);

	}
	
	public PanelItemGioHang(ChiTietSanPham ctsp, JSpinner spinner1) {

		// setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(new Color(255, 255, 255));
		this.ctsp = ctsp;
		this.sp = new Dao_SanPham().getSanPham_Ma(ctsp.getMaSanPham());
		

		setPreferredSize(new Dimension(415, 115));
		setLayout(null);

		JPanel panel_HinhAnh = new JPanel();
		panel_HinhAnh.setBackground(new Color(240, 240, 240));
		panel_HinhAnh.setBounds(0, 0, 105, 105);
		panel_HinhAnh.setLayout(new BoxLayout(panel_HinhAnh, BoxLayout.X_AXIS));

		panel_HinhAnh.add(new ImageBox(sp.getHinhAnh(), 105, 105));

//		ImageIcon imageIcon = new ImageIcon(sp.getHinhAnh()); // load the image to a imageIcon
//		
//		Image image = imageIcon.getImage(); // transform it 
//		Image newimg = image.getScaledInstance(105, 105, Image.SCALE_SMOOTH); // scale it the smooth way  
//		imageIcon = new ImageIcon(newimg);
		add(panel_HinhAnh);

		panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(105, 0, 300, 105);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("SL: ");
		lblNewLabel_5.setBounds(10, 82, 40, 13);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_2 = new JLabel("Size: ");
		lblNewLabel_2.setBounds(10, 56, 45, 13);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Màu: ");
		lblNewLabel_1.setBounds(10, 33, 45, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Tên: ");
		lblNewLabel.setBounds(10, 10, 45, 13);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel(ctsp.getSize());
		lblNewLabel_3.setBounds(40, 56, 45, 13);
		panel.add(lblNewLabel_3);
		
		this.spinner = spinner1;
		panel.add(spinner);
		spinner.setBounds(33, 79, 35, 20);


		panel_deleteIcon = new JPanel();
		panel_deleteIcon.setBackground(new Color(255, 255, 255));
		panel_deleteIcon.setBounds(275, 0, 16, 16);
		panel.add(panel_deleteIcon);
		panel_deleteIcon.setLayout(null);

		lblDeleteIcon = new JLabel("");
		lblDeleteIcon.setIcon(new ImageIcon("image/x icon.png"));
		lblDeleteIcon.setBounds(0, 0, 16, 16);
		panel_deleteIcon.add(lblDeleteIcon);

		JLabel lbl_DonGia = new JLabel("Đơn giá: ");
		lbl_DonGia.setBounds(95, 56, 65, 13);
		panel.add(lbl_DonGia);

		JLabel lbl_ThanhTien = new JLabel("Thành tiền: ");
		lbl_ThanhTien.setBounds(94, 82, 70, 13);
		panel.add(lbl_ThanhTien);

		JLabel lbl_MauOut = new JLabel(ctsp.getMau());
		lbl_MauOut.setBounds(40, 33, 45, 13);
		panel.add(lbl_MauOut);


		Locale localeVN = new Locale("vi", "VN");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
		numberFormat.setCurrency(Currency.getInstance(localeVN));

		JLabel lbl_DonGia_2 = new JLabel(numberFormat.format(sp.getGiaGoc()));
		lbl_DonGia_2.setBounds(160, 56, 100, 13);
		panel.add(lbl_DonGia_2);

		JLabel lbl_Ten1 = new JLabel(sp.getTenSanPham());
		lbl_Ten1.setBounds(40, 10, 225, 13);
		panel.add(lbl_Ten1);

		lbl_ThanhTien1 = new JLabel();
		lbl_ThanhTien1.setBounds(170, 82, 100, 13);
		panel.add(lbl_ThanhTien1);

	}

	public static BufferedImage convertToBufferedImage(Image img) {

		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		// Create a buffered image with transparency
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics2D = bi.createGraphics();
		graphics2D.drawImage(img, 0, 0, null);
		graphics2D.dispose();

		return bi;
	}

	public JLabel getLbl_ThanhTien1() {
		return lbl_ThanhTien1;
	}

	public String getSizeSP() {
		return ctsp.getSize();
	}

	public String getMau() {
		return ctsp.getMau();
	}

	public JPanel getPanel_deleteIcon() {
		return panel_deleteIcon;
	}

	public void setPanel_deleteIcon(JPanel panel_deleteIcon) {
		this.panel_deleteIcon = panel_deleteIcon;
	}

	public SanPham getSp() {
		return sp;
	}

	public void setSp(SanPham sp) {
		this.sp = sp;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public String getMaCTSP() {
		return ctsp.getMaChiTietSanPham();
	}

	public Double getThanhTien() {
		return sp.getGiaGoc() * Integer.parseInt(spinner.getValue().toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
