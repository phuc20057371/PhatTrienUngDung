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
import dao.Dao_SanPham;
import entity.ChiTietHoaDon;
import entity.ChiTietSanPham;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.NhanVien;
import gui.PanelGioHang;
import gui.PanelItemGioHang;

public class TaoHoaDonPDF {
	// public static final String DEST = "hoa don/hello1.pdf";
	public static final String REGULAR = "font/calibri.ttf";
	public static final String BOLD = "font/calibrib.ttf";
	public static final String DEST = "hoa don/hd1.pdf";
	DAO_HoaDonBanHang dao_HoaDonBanHang = new DAO_HoaDonBanHang();
	Dao_SanPham dao_SanPham = new Dao_SanPham();
	private HoaDonBanHang hoaDonBanHang;
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public TaoHoaDonPDF(PanelGioHang pnGioHang, NhanVien nv, ArrayList<PanelItemGioHang> listSP, String maHD) throws IOException {
		
		// maHD = "123456";
		LocalDate today = LocalDate.now();
		Date ngayDate = java.sql.Date.valueOf(today);
		KhachHang khachHang = new KhachHang(pnGioHang.getKhachHang().getMaKhachHang());
//		double giamGia = Double.parseDouble(pnGioHang.getLblTienGiamData().getText());
		double giamGia = pnGioHang.getTienGiam();
		Double tienKhachDua = Double.parseDouble(pnGioHang.getTf_TienKhachDua().getText());
		double tongTienHD = pnGioHang.getTongCong();
		
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		for(PanelItemGioHang panelGioHang : listSP) {
			
			ChiTietSanPham CTSP = new ChiTietSanPham(panelGioHang.getMaCTSP());
			int sl = Integer.parseInt(panelGioHang.getSpinner().getValue().toString());
			list.add(new ChiTietHoaDon(CTSP, maHD, sl));
		}
		
		hoaDonBanHang = new HoaDonBanHang(maHD, ngayDate, khachHang, nv, giamGia, tienKhachDua, tongTienHD, list);
		dao_HoaDonBanHang.createHDBH(hoaDonBanHang);
		
		path = "hoa don/" + maHD + ".pdf";
		
		FontProgram fontProgram = FontProgramFactory.createFont(REGULAR);
		PdfFont fontR = PdfFontFactory.createFont(fontProgram, PdfEncodings.IDENTITY_H, true);
		PdfFont fontB = PdfFontFactory.createFont(FontProgramFactory.createFont(BOLD), PdfEncodings.IDENTITY_H, true);
		PdfDocument pdf = new PdfDocument(new PdfWriter(path));
		
		Text title = new Text("Shop Quần Áo");
		// Text author = new Text("Robert Louis Stevenson").setFont(font);
		Document document =new Document(pdf, new PageSize(new Rectangle(350, 1000)));
		// String line = "Phạm Việt Nhật";
		// Paragraph paragraph = new Paragraph().setFont(font).add(title);
		document.add(new Paragraph(title).setFont(fontR).setTextAlignment(TextAlignment.CENTER).setFontSize(20));
		
		document.add(new Paragraph("ĐC: 29 Lê Lợi, Phường 4, Gò Vấp, TP. HCM \n"
				+ "SĐT: 0563395235").setFont(fontR).setTextAlignment(TextAlignment.CENTER));
		document.add(new Paragraph("HÓA ĐƠN BÁN HÀNG").setFont(fontR).setTextAlignment(TextAlignment.CENTER).setFontSize(15));
		document.setFont(fontR);
		
		
		Locale localeVD = new Locale("vi", "VN");
		NumberFormat nbFormat = NumberFormat.getCurrencyInstance(localeVD);
		
		Table table;
		
		Text text = new Text("Ngày: "+ today +" \n"
				+ "Khách hàng: "+pnGioHang.getKhachHang().getHoTenKhachHang()+" \n"
				+ "SĐT: "+pnGioHang.getKhachHang().getSoDienThoai()+" \n"
				+ "Thu ngân: "+nv.getTenNV()+" \n"
				+ "");
		document.add(new Paragraph(text));
	    float[] colWidths = new float[]{3, 1.5f,2,3};
	    table = new Table(UnitValue.createPercentArray(colWidths));
	    table.setWidthPercent(100f);
	    
	    // table2.setWidthPercent(tableWidth);
	    
	    table.addCell("Tên hàng");
	    table.addCell("SL");
	    table.addCell("Đơn giá");
	    table.addCell("Thành tiền");
	    
	    for (PanelItemGioHang p : listSP) {
	    	table.addCell(p.getSp().getTenSanPham() +", " +p.getMau() + ", "+ p.getSizeSP());
		    table.addCell(p.getSpinner().getValue() + "");
		    table.addCell(nbFormat.format(p.getSp().getGiaGoc()) + "");
		    table.addCell(nbFormat.format(Integer.parseInt(p.getSpinner().getValue().toString()) * p.getSp().getGiaGoc()) + "");
		    dao_SanPham.capNhatSoLuong(p.getMaCTSP(), -Integer.parseInt(p.getSpinner().getValue().toString()));
		}
	    
	    table.setHorizontalAlignment(HorizontalAlignment.CENTER);
	    document.add(table);
	    
	    Text text2 = new Text("Tiền hàng: "+pnGioHang.getLblTienHang1().getText()+"\n"
	    		+ "Tiền giảm: "+pnGioHang.getLblTienGiamData().getText()+"\n"
	    		+ "Tổng cộng: "+pnGioHang.getLblTongCongData().getText()+"\n"
	    		+ "Tiền khách đưa: "+pnGioHang.getTf_TienKhachDua().getText()+"\n"
	    		+ "Tiền trả lại khách: "+pnGioHang.getLblTienTraLaiKhach_1().getText());
		document.add(new Paragraph(text2));
		
		Text text3 = new Text("Giá trên đã bao gồm thuế GTGT");
		document.add(new Paragraph(text3).setTextAlignment(TextAlignment.CENTER));
	    
	    document.close();
	    System.out.println("1");
	}
}
