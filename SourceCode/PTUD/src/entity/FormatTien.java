package entity;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatTien {
	private String tien;

	public FormatTien(double tien) {
		Locale localeVD = new Locale("vi","VN");
		NumberFormat nbFormat = NumberFormat.getCurrencyInstance(localeVD);
		this.tien = nbFormat.format(tien);
	}
	public String getTien() {
		return tien;
	}
}
