package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.KhachHang;
import entity.NhanVien;
import test.TaoHDTH;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class DialogXacNhanDoiHang extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DialogXacNhanDoiHang dialog = new DialogXacNhanDoiHang(0);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DialogXacNhanDoiHang(KhachHang khachHang, double tienGiam, double tienTraLai, NhanVien nv, ArrayList<PanelItemGioHang> listSP,
			String maHD, String maHDTH, JPanel panel_item, ArrayList<Panel_Item> listItem) {
		
		setModal(true);
		setBounds(100, 100, 450, 179);
		setLocationRelativeTo(null);
		setTitle("Xác nhận");
		Locale localeVD = new Locale("vi", "VN");
		NumberFormat nbFormat = NumberFormat.getCurrencyInstance(localeVD);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btn_XacNhan = new JButton("Xác nhận");
			btn_XacNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btn_XacNhan.setBounds(81, 111, 125, 25);
			contentPanel.add(btn_XacNhan);
			btn_XacNhan.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						new TaoHDTH(khachHang, tienGiam, tienTraLai, nv, listSP, maHD, maHDTH,panel_item, listItem);
						new DialogHoaDon("Thanh toán thành công, Mã hóa đơn: " + maHDTH,
								"hoa don/" + maHDTH + ".pdf").setVisible(true);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		JLabel lblNewLabel = new JLabel("Tiền trả lại:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 45, 93, 25);
		contentPanel.add(lblNewLabel);
		{
			JLabel lbl_TienHoan = new JLabel("" + nbFormat.format(tienTraLai));
			lbl_TienHoan.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			lbl_TienHoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbl_TienHoan.setBounds(113, 45, 313, 25);
			contentPanel.add(lbl_TienHoan);
		}
		
		JButton btn_XacNhan = new JButton("Hủy");
		btn_XacNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_XacNhan.setBounds(224, 111, 125, 25);
		contentPanel.add(btn_XacNhan);
	}
}
