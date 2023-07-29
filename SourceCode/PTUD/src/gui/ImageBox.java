package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageBox extends JPanel {

    private Image imgImage;
    private int w, h;
    private String imgURL;

    public ImageBox(String imgURL, int w, int h) {
      
    	this.h = h;
    	this.w = w;
    	this.imgURL = imgURL;
    	imgImage = new ImageIcon(imgURL).getImage();
        setSurfaceSize();
    }
    
    private void setSurfaceSize() {
        
        Dimension d = new Dimension();
        d.width = imgImage.getWidth(null);
        d.height = imgImage.getHeight(null);
        setPreferredSize(d); 
        // setSize(w, h);
    }

    public void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        Map<RenderingHints.Key,Object> hints = new HashMap<>();
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(hints);
		g2d.drawImage(imgImage, 0, 0, w, h, null);
		
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}