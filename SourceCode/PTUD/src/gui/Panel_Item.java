package gui;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import dao.Dao_SanPham;
import entity.ChiTietSanPham;
import entity.SanPham;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.MatteBorder;

public class Panel_Item extends JPanel {

	// implements ActionListener,MouseListener

	Image image1;
	private SanPham sp;
	private ChiTietSanPham ctsp;
	Dao_SanPham dao_SP = new Dao_SanPham();

	public SanPham getSp() {
		return sp;
	}

	public JLabel getLblKhoData() {
		return lblKhoData;
	}

	public void setLblKhoData(JLabel lblKhoData) {
		this.lblKhoData = lblKhoData;
	}

	private JButton btnThem, btnXemChiTiet;
	JLabel lblKhoData;

	public JButton getBtn() {
		return btnThem;
	}

	public JButton getBtnXemChiTiet() {
		return btnXemChiTiet;
	}

	public void setBtnXemChiTiet(JButton btnXemChiTiet) {
		this.btnXemChiTiet = btnXemChiTiet;
	}

	public JButton getBtnThem() {
		return btnThem;
	}

	public void setBtnThem(JButton btnThem) {
		this.btnThem = btnThem;
	}

	/**
	 * Create the panel.
	 */
	public Panel_Item(ChiTietSanPham ctsp) {

		// super();
		this.sp = new Dao_SanPham().getSanPham_Ma(ctsp.getMaSanPham());
		this.ctsp = ctsp;
		setPreferredSize(new Dimension(810, 159));

		JPanel panel_img = new JPanel();
		panel_img.setBounds(0, 0, 150, 150);

		JPanel panel_text = new JPanel();
		panel_text.setBounds(148, 0, 659, 150);
		panel_text.setBackground(new Color(0, 210, 227));
		panel_text.setLayout(null);

		JLabel lblTenSanPham = new JLabel(sp.getTenSanPham());
		lblTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenSanPham.setBounds(53, 10, 342, 20);
		panel_text.add(lblTenSanPham);

		JLabel lblSize = new JLabel("Size: ");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSize.setBounds(10, 45, 64, 20);
		panel_text.add(lblSize);

		JLabel lblMau = new JLabel("Màu: ");
		lblMau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMau.setBounds(10, 80, 64, 20);
		panel_text.add(lblMau);

		ImageIcon imageIcon = new ImageIcon(sp.getHinhAnh()); 
		image1 = imageIcon.getImage(); 
		panel_img.setLayout(new BoxLayout(panel_img, BoxLayout.X_AXIS));
		panel_img.add(new ImageBox(sp.getHinhAnh(), 150, 150));

		JLabel lblGia = new JLabel("Giá: ");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGia.setBounds(400, 43, 40, 20);
		panel_text.add(lblGia);

		Locale localeVD = new Locale("vi", "VN");
		NumberFormat nbFormat = NumberFormat.getCurrencyInstance(localeVD);

		JLabel lblGia1 = new JLabel(nbFormat.format(sp.getGiaGoc()));
		lblGia1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGia1.setBounds(437, 43, 158, 20);
		panel_text.add(lblGia1);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(546, 115, 103, 25);
		panel_text.add(btnThem);
		setLayout(null);
		add(panel_img);
		add(panel_text);

		JLabel lblThngHiu = new JLabel("Thương hiệu: ");
		lblThngHiu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThngHiu.setBounds(10, 115, 100, 20);
		panel_text.add(lblThngHiu);

		JLabel lblU = new JLabel("Xuất xứ: ");
		lblU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblU.setBounds(220, 115, 75, 20);
		panel_text.add(lblU);

		JLabel lblGiiTnh = new JLabel("Giới tính: ");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiiTnh.setBounds(220, 80, 70, 20);
		panel_text.add(lblGiiTnh);

		JLabel lblTn = new JLabel("Tên:  ");
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTn.setBounds(10, 10, 100, 20);
		panel_text.add(lblTn);

		JLabel lblMSp = new JLabel("Mã: ");
		lblMSp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSp.setBounds(400, 10, 70, 20);
		panel_text.add(lblMSp);

		btnXemChiTiet = new JButton("Xem Chi tiết");
		btnXemChiTiet.setBounds(401, 115, 115, 25);
		panel_text.add(btnXemChiTiet);

		btnXemChiTiet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FormChiTietSanPham(sp).setVisible(true);
			}
		});

		JLabel lblKho = new JLabel("Kho: ");
		lblKho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKho.setBounds(400, 80, 40, 20);
		panel_text.add(lblKho);

		JLabel lblNewLabel_1 = new JLabel(ctsp.getMaChiTietSanPham());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(437, 10, 100, 20);
		panel_text.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(sp.getGioiTinh());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(300, 80, 70, 20);
		panel_text.add(lblNewLabel_2);

		JLabel lblThngHiu_1 = new JLabel(sp.getThuongHieu().getTenTH());
		lblThngHiu_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThngHiu_1.setBounds(110, 115, 100, 20);
		panel_text.add(lblThngHiu_1);

		lblKhoData = new JLabel(ctsp.getSoLuong() + "");
		lblKhoData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoData.setBounds(450, 80, 45, 20);
		panel_text.add(lblKhoData);

		JLabel lblXuatXu_1 = new JLabel(sp.getXuatXu().getTenXX());
		lblXuatXu_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblXuatXu_1.setBounds(291, 115, 100, 20);
		panel_text.add(lblXuatXu_1);

		JLabel lblNewLabel = new JLabel(ctsp.getMau());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(75, 80, 100, 20);
		panel_text.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel(ctsp.getSize());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(75, 45, 100, 20);
		panel_text.add(lblNewLabel_3);

	}

	public ChiTietSanPham getCtsp() {
		return ctsp;
	}

	public void setCtsp(ChiTietSanPham ctsp) {
		this.ctsp = ctsp;
		lblKhoData.setText(ctsp.getSoLuong() + "");
	}
}
