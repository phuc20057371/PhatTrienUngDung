package gui;

import javax.swing.JPanel;

import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;

import dao.DAO_KhachHang;
import entity.KhachHang;

public class PanelGioHang extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel_DSHang;
	private KhachHang khachHang;
	private JTextField tF_SDT;
	private JTextField tf_TienKhachDua;
	private JButton btnThem, btnThanhToan;
	private JLabel lblMaKH_1, lblTen_1, lbl_SDT_1, lbl_LoaiKH_1, lblTienHang1, lblTienGiamData, lblTongCongData,
			lblTienTraLaiKhach_1;
	private Double tongCong, tienGiam;
	public Double getTienGiam() {
		return tienGiam;
	}

	public void setTienGiam(Double tienGiam) {
		this.tienGiam = tienGiam;
	}

	public Double getTongCong() {
		return tongCong;
	}

	public void setTongCong(Double tongCong) {
		this.tongCong = tongCong;
	}

	DAO_KhachHang dao = new DAO_KhachHang();

	/**
	 * Create the panel.
	 */
	public PanelGioHang() {
		setLayout(null);

		setPreferredSize(new Dimension(415, 680));

		JLabel lblMaKH = new JLabel("Mã KH: ");
		lblMaKH.setBounds(10, 46, 55, 13);
		add(lblMaKH);

		JLabel lblTen = new JLabel("Tên KH: ");
		lblTen.setBounds(10, 69, 55, 13);
		add(lblTen);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 136, 415, 380);
		add(scrollPane);

		panel_DSHang = new JPanel();
		panel_DSHang.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel_DSHang);
		panel_DSHang.setLayout(new BoxLayout(panel_DSHang, BoxLayout.Y_AXIS));

		JLabel lblTienHang = new JLabel(" Tiền hàng: ");
		lblTienHang.setBounds(10, 526, 75, 13);
		add(lblTienHang);

		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBounds(140, 641, 125, 21);
		add(btnThanhToan);

		JLabel lblTienKhachDua = new JLabel("Tiền khách đưa: ");
		lblTienKhachDua.setBounds(10, 595, 100, 13);
		add(lblTienKhachDua);

		JLabel lblNewLabel = new JLabel("Tiền trả lại khách: ");
		lblNewLabel.setBounds(10, 618, 110, 13);
		add(lblNewLabel);

		JLabel lblSt = new JLabel("SĐT: ");
		lblSt.setBounds(10, 92, 45, 13);
		add(lblSt);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(320, 11, 85, 21);
		add(btnThem);

		tF_SDT = new JTextField();
		tF_SDT.setBounds(10, 11, 307, 21);
		add(tF_SDT);
		tF_SDT.setColumns(10);

		JLabel lbl_LoaiKH = new JLabel("Loại KH:");
		lbl_LoaiKH.setBounds(10, 115, 55, 13);
		add(lbl_LoaiKH);

		JLabel lbl_Giam = new JLabel("Giảm: ");
		lbl_Giam.setBounds(10, 549, 75, 13);
		add(lbl_Giam);

		tf_TienKhachDua = new JTextField();
		tf_TienKhachDua.setOpaque(false);
		tf_TienKhachDua.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tf_TienKhachDua.setBounds(110, 590, 191, 19);
		add(tf_TienKhachDua);
		tf_TienKhachDua.setColumns(10);

		lblMaKH_1 = new JLabel("");
		lblMaKH_1.setBounds(66, 46, 75, 13);
		add(lblMaKH_1);

		lblTen_1 = new JLabel("");
		lblTen_1.setBounds(66, 69, 120, 13);
		add(lblTen_1);

		lbl_SDT_1 = new JLabel("");
		lbl_SDT_1.setBounds(65, 92, 100, 13);
		add(lbl_SDT_1);

		lbl_LoaiKH_1 = new JLabel("");
		lbl_LoaiKH_1.setBounds(65, 115, 120, 13);
		add(lbl_LoaiKH_1);

		lblTienHang1 = new JLabel("");
		lblTienHang1.setBounds(80, 526, 75, 13);
		add(lblTienHang1);

		JLabel lblTongCong = new JLabel("Tổng cộng: ");
		lblTongCong.setBounds(10, 572, 75, 13);
		add(lblTongCong);

		lblTienGiamData = new JLabel("");
		lblTienGiamData.setBounds(66, 549, 75, 13);
		add(lblTienGiamData);

		lblTongCongData = new JLabel("");
		lblTongCongData.setBounds(80, 572, 75, 13);
		add(lblTongCongData);

		lblTienTraLaiKhach_1 = new JLabel("");
		lblTienTraLaiKhach_1.setBounds(120, 618, 150, 13);
		add(lblTienTraLaiKhach_1);

	}

	public JTextField getTf_TienKhachDua() {
		return tf_TienKhachDua;
	}

	public JPanel getPanel_DSHang() {
		return panel_DSHang;
	}

	public void setPanel_DSHang(JPanel panel_DSHang) {
		this.panel_DSHang = panel_DSHang;
	}

	public JTextField gettF_SDT() {
		return tF_SDT;
	}

	public JLabel getLblMaKH_1() {
		return lblMaKH_1;
	}

	public JLabel getLblTen_1() {
		return lblTen_1;
	}

	public JLabel getLbl_SDT_1() {
		return lbl_SDT_1;
	}

	public JLabel getLbl_LoaiKH_1() {
		return lbl_LoaiKH_1;
	}

	public JLabel getLblTienGiamData() {
		return lblTienGiamData;
	}

	public void setLblTienGiamData(JLabel lblTienGiamData) {
		this.lblTienGiamData = lblTienGiamData;
	}

	public JLabel getLblTienHang1() {
		return lblTienHang1;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
		lblMaKH_1.setText(khachHang.getMaKhachHang());
		lblTen_1.setText(khachHang.getHoTenKhachHang());
		lbl_SDT_1.setText(khachHang.getSoDienThoai());
		lbl_LoaiKH_1.setText(khachHang.getLoaiKhachHang());
	}

	public JLabel getLblTongCongData() {
		return lblTongCongData;
	}

	public JButton getBtnThem() {
		return btnThem;
	}

	public void setBtnThem(JButton btnThem) {
		this.btnThem = btnThem;
	}

	public JButton getBtnThanhToan() {
		return btnThanhToan;
	}

	public JLabel getLblTienTraLaiKhach_1() {
		return lblTienTraLaiKhach_1;
	}

	public void xoaBang() {
		khachHang = null;
		lblMaKH_1.setText("");
		lblTen_1.setText("");
		lbl_SDT_1.setText("");
		lbl_LoaiKH_1.setText("");
		lblTienHang1.setText("");
		lblTienGiamData.setText("");
		lblTongCongData.setText("");
		tF_SDT.setText("");
		tf_TienKhachDua.setText("");
		lblTienTraLaiKhach_1.setText("");
	}
}
