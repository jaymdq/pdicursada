package segmentacion;

import ij.ImagePlus;
import engine.Imagen;

public class SUmbral extends CriterioSegmentacion {

	private int umbral;
	
	public SUmbral(int umbral) {
		this.umbral = umbral;
	}

	@Override
	public boolean pertenece(ImagePlus im, int i, int j) {
		return Imagen.getPixel(im, i, j) >= umbral;
	}

}
