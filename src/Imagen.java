import java.awt.Color;

import ij.ImagePlus;
import ij.gui.NewImage;


public class Imagen {

	public static void setPixel (ImagePlus im, int x, int y, Color c){
		im.getProcessor().setColor(c);
		im.getProcessor().drawDot(x, y);
	}
	
	public static Color getPixel (ImagePlus im, int x, int y){
		// TODO Implementar esto (Brian)
		return new Color(0);
	}
	
	public ImagePlus aplicarFiltro(ImagePlus im, int[][] matriz){
		//NewImage.createImage("nueva", width, height, nSlices, bitDepth, options)
		return null;
	}
	
}
