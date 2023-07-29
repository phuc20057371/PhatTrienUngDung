package gui;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.compress.harmony.pack200.NewAttribute;

import dao.DAO_HoaDonBanHang;
import dao.DAO_HoaDonTraHang;
import dao.DAO_KhachHang;
import dao.Dao_SanPham;
import database.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChiTietSanPham;
import entity.HoaDonBanHang;
import entity.HoaDonTraHang;
import entity.KhachHang;
import entity.NhanVien;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class FormDoiHang extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private HoaDonBanHang hoaDonBanHang;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	JPanel panel;
	private JLabel lbl_LoaiKH, lbl_SDT, lbl_TenKH, lbl_MaKH;
	JButton btn_XacNhan;
	private ArrayList<PanelItemGioHang> listItem = new ArrayList<PanelItemGioHang>();
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormDoiHang frame = new FormDoiHang();
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
	public FormDoiHang(NhanVien nhanVien, JPanel panel_item, ArrayList<Panel_Item> listItem1) {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 710);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Tạo hóa đơn trả hàng");
		setResizable(false);
		textField = new JTextField();
		textField.setBounds(10, 53, 306, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNewLabel = new JLabel("Mã KH: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 95, 100, 28);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Tên KH: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 133, 100, 28);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("SĐT: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 171, 100, 28);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Loại KH: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 209, 100, 28);
		contentPane.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 251, 416, 341);
		contentPane.add(scrollPane);

		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBounds(326, 52, 100, 32);
		contentPane.add(btnNewButton);

		lbl_MaKH = new JLabel("");
		lbl_MaKH.setBorder(null);
		lbl_MaKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MaKH.setBounds(96, 95, 176, 32);
		contentPane.add(lbl_MaKH);

		lbl_TenKH = new JLabel("");
		lbl_TenKH.setBorder(null);
		lbl_TenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TenKH.setBounds(96, 133, 176, 32);
		contentPane.add(lbl_TenKH);

		lbl_SDT = new JLabel("");
		lbl_SDT.setBorder(null);
		lbl_SDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_SDT.setBounds(96, 171, 176, 32);
		contentPane.add(lbl_SDT);

		lbl_LoaiKH = new JLabel("");
		lbl_LoaiKH.setBorder(null);
		lbl_LoaiKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_LoaiKH.setBounds(96, 209, 176, 32);
		contentPane.add(lbl_LoaiKH);

		btn_XacNhan = new JButton("Xác nhận");
		btn_XacNhan.setBounds(148, 632, 121, 32);
		contentPane.add(btn_XacNhan);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(0, 191, 255));
		lblNewLabel_4.setBounds(0, 0, 436, 20);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("(Nhập mã hóa đơn)");
		lblNewLabel_5.setBounds(10, 30, 262, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("(Giữ lại những sản phẩm cần trả và bấm xác nhận)");
		lblNewLabel_6.setBorder(null);
		lblNewLabel_6.setBounds(10, 602, 416, 20);
		contentPane.add(lblNewLabel_6);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String ma = textField.getText();
				if(kthd(ma)) {
					HoaDonBanHang hD = new DAO_HoaDonBanHang().getHoaDonBanHang(ma);
					if(!hD.equals(hoaDonBanHang)) {
						setHoaDonBanHang(hD);
						KhachHang kh = new DAO_KhachHang().getKhachHang(hD.getMaKhachHang().getMaKhachHang());
						setKhachHang(kh);
					}
					if(listItem.size() != hD.getChiTietHoaDon().size()) {
						setHoaDonBanHang(hD);
					}
				}
				
			}
		});

		btn_XacNhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(listItem.size() == 0) {
					JOptionPane.showMessageDialog(null, "Chưa chọn hàng.");
				} else {
					double tienHoan = 0;
					for (PanelItemGioHang pn : listItem) {
						double dg = pn.getSp().getGiaGoc();
						int sl = (Integer) pn.getSpinner().getValue();
						if (khachHang.getLoaiKhachHang().equals("Thân thiết")) {
							tienHoan += (dg * 0.95) * sl;
						} else {
							tienHoan += (dg * 1) * sl;
						}
					}
					System.out.println(tienHoan);
					int slHD = new DAO_HoaDonTraHang().getTongHoaDon();
					String maHDTH = "HDTH" + String.format("%04d", slHD + 1);

					DialogXacNhanDoiHang dialog = new DialogXacNhanDoiHang(khachHang, tienHoan, -tienHoan, nhanVien,
							listItem, hoaDonBanHang.getMaHoaDon(), maHDTH, panel_item, listItem1);
					dialog.setVisible(true);
					dispose();
				}
				
			}
		});
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
		lbl_MaKH.setText(khachHang.getMaKhachHang());
		lbl_LoaiKH.setText(khachHang.getLoaiKhachHang());
		lbl_TenKH.setText(khachHang.getHoTenKhachHang());
		lbl_SDT.setText(khachHang.getSoDienThoai());
	}

	public boolean kthd(String maHD) {
		ArrayList<HoaDonBanHang> lisHD = new DAO_HoaDonBanHang().getAllHoaDonBanHang();
		boolean a = false, b = false;
		for (HoaDonBanHang hoaDonBanHang : lisHD) {
			if (hoaDonBanHang.getMaHoaDon().equals(maHD)) {
				a = true;
			}
		}
		if (a == false) {
			JOptionPane.showMessageDialog(null, "Mã hóa đơn không hợp lệ.");
			return false;
		} else {
			ArrayList<String> listMaHD = new DAO_HoaDonTraHang().getMaHD();
			for (String ma : listMaHD) {
				if (ma.equals(maHD)) {
					b = true;
				}
			}
			if (b == true) {
				JOptionPane.showMessageDialog(null, "Hóa đơn chỉ được đổi 1 lần.");
				return false;
			}
		}
		return true;
	}

	public HoaDonBanHang getHoaDonBanHang() {
		return hoaDonBanHang;
	}

	public void setHoaDonBanHang(HoaDonBanHang hoaDonBanHang) {
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
		this.hoaDonBanHang = hoaDonBanHang;
		listItem.removeAll(listItem);
		for (ChiTietHoaDon ct : hoaDonBanHang.getChiTietHoaDon()) {

			SpinnerModel value = new SpinnerNumberModel(ct.getSoLuong(), 1, ct.getSoLuong(), 1);
			JSpinner spinner = new JSpinner(value);
			PanelItemGioHang item = new PanelItemGioHang(
					new Dao_SanPham().getChiTietSanPham(ct.getMaCTSP().getMaChiTietSanPham()), spinner);
			
			listItem.add(item);
			panel.add(item);
			item.getPanel_deleteIcon().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int xoa = JOptionPane.showConfirmDialog(null, "Xóa sản phẩm khỏi giỏ hàng ?",
							"Xóa sản phẩm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (xoa == 0) {
						listItem.remove(item);
						panel.removeAll();
						panel.repaint();
						panel.revalidate();

						for (PanelItemGioHang b : listItem) {
							panel.add(b);
							panel.repaint();
							panel.revalidate();
						}
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					item.getPanel_deleteIcon().setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			});
		}
	}
}
