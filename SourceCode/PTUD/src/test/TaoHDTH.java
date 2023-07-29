package test;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JPanel;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import ch.qos.logback.core.util.Loader;
import dao.DAO_HoaDonBanHang;
import dao.DAO_HoaDonTraHang;
import dao.Dao_SanPham;
import entity.ChiTietHoaDon;
import entity.ChiTietSanPham;
import entity.ChiTietTraHang;
import entity.HoaDonBanHang;
import entity.HoaDonTraHang;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import gui.PanelGioHang;
import gui.PanelItemGioHang;
import gui.Panel_Item;

public class TaoHDTH {
	// public static final String DEST = "hoa don/hello1.pdf";
	public static final String REGULAR = "font/calibri.ttf";
	public static final String BOLD = "font/calibrib.ttf";
	public static final String DEST = "hoa don/hd1.pdf";
	DAO_HoaDonBanHang dao_HoaDonBanHang = new DAO_HoaDonBanHang();
	Dao_SanPham dao_SanPham = new Dao_SanPham();
	// private HoaDonBanHang hoaDonBanHang;
	private HoaDonTraHang hoaDonTraHang;
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public TaoHDTH(KhachHang khachHang, double tienGiam, double tienTraLai, NhanVien nv, ArrayList<PanelItemGioHang> listSP,
			String maHD, String maHDTH,JPanel panel_item, ArrayList<Panel_Item> listItem) throws IOException {
		
		LocalDate today = LocalDate.now();
		Date ngayDate = java.sql.Date.valueOf(today);

		double giamGia = tienGiam;
		// double tongTienHD = pnGioHang.getTongCong();

		ArrayList<ChiTietTraHang> listCTTH = new ArrayList<ChiTietTraHang>();
		for (PanelItemGioHang panelGioHang : listSP) {
			ChiTietSanPham CTSP = new ChiTietSanPham(panelGioHang.getMaCTSP());
			int sl = Integer.parseInt(panelGioHang.getSpinner().getValue().toString());
			listCTTH.add(new ChiTietTraHang(CTSP, maHDTH, sl));
		}

		hoaDonTraHang = new HoaDonTraHang(maHDTH, maHD, ngayDate, khachHang, nv, tienTraLai, listCTTH);
		new DAO_HoaDonTraHang().createHDTH(hoaDonTraHang);
		path = "hoa don/" + maHDTH + ".pdf";

		FontProgram fontProgram = FontProgramFactory.createFont(REGULAR);
		PdfFont fontR = PdfFontFactory.createFont(fontProgram, PdfEncodings.IDENTITY_H, true);
		PdfFont fontB = PdfFontFactory.createFont(FontProgramFactory.createFont(BOLD), PdfEncodings.IDENTITY_H, true);
		PdfDocument pdf = new PdfDocument(new PdfWriter(path));

		Text title = new Text("Shop Quần Áo");
		// Text author = new Text("Robert Louis Stevenson").setFont(font);
		Document document = new Document(pdf, new PageSize(new Rectangle(350, 1000)));
		// String line = "Phạm Việt Nhật";
		// Paragraph paragraph = new Paragraph().setFont(font).add(title);
		document.add(new Paragraph(title).setFont(fontR).setTextAlignment(TextAlignment.CENTER).setFontSize(20));

		document.add(new Paragraph("ĐC: 29 Lê Lợi, Phường 4, Gò Vấp, TP. HCM \n" + "SĐT: 0563395235").setFont(fontR)
				.setTextAlignment(TextAlignment.CENTER));
		document.add(
				new Paragraph("HÓA ĐƠN TRẢ HÀNG").setFont(fontR).setTextAlignment(TextAlignment.CENTER).setFontSize(15));
		document.setFont(fontR);

		Locale localeVD = new Locale("vi", "VN");
		NumberFormat nbFormat = NumberFormat.getCurrencyInstance(localeVD);

		Table table;

		Text text = new Text("Ngày: " + today + " \n" + "Khách hàng: " + khachHang.getHoTenKhachHang()
				+ " \n" + "SĐT: " + khachHang.getSoDienThoai() + " \n" + "Thu ngân: " + nv.getTenNV()
				+ " \n" + "");
		document.add(new Paragraph(text));
		float[] colWidths = new float[] { 3, 1.5f, 2, 3 };
		table = new Table(UnitValue.createPercentArray(colWidths));
		table.setWidthPercent(100f);

		// table2.setWidthPercent(tableWidth);

		table.addCell("Tên hàng");
		table.addCell("SL");
		table.addCell("Đơn giá");
		table.addCell("Thành tiền");

		for (PanelItemGioHang p : listSP) {
			table.addCell(p.getSp().getTenSanPham() + ", " + p.getMau() + ", " + p.getSizeSP());
			table.addCell(p.getSpinner().getValue() + "");
			table.addCell(nbFormat.format(p.getSp().getGiaGoc()) + "");
			table.addCell(
					nbFormat.format(Integer.parseInt(p.getSpinner().getValue().toString()) * p.getSp().getGiaGoc())
							+ "");
			dao_SanPham.capNhatSoLuong(p.getMaCTSP(), Integer.parseInt(p.getSpinner().getValue().toString()));
		}

		table.setHorizontalAlignment(HorizontalAlignment.CENTER);
		document.add(table);

		Text text2 = new Text("Tiền Trả Lại: " + tienTraLai + "\n" + "Tiền giảm: " + tienGiam);
		document.add(new Paragraph(text2));

		Text text3 = new Text("Giá trên đã bao gồm thuế GTGT");
		document.add(new Paragraph(text3).setTextAlignment(TextAlignment.CENTER));

		document.close();
		System.out.println("1");
		
		dao_SanPham.getAllSanPham();
		ArrayList<SanPham> listSPMoi = dao_SanPham.getAllSanPham();

		int i = 0;
		for (SanPham sp : listSPMoi) {
			for(ChiTietSanPham cTietSanPham : sp.getChiTietSanPham()) {
				listItem.get(i).setCtsp(cTietSanPham);
				i++;
			}
		}

		panel_item.removeAll();
		panel_item.repaint();
		panel_item.revalidate();
		for (Panel_Item item : listItem) {

			panel_item.add(item); // add panelitem và panel chính (panel lớn chứa nhiều
			// panelitem)
			panel_item.repaint();
			panel_item.revalidate();
		}
	}
}
