package segmentacion;

import ij.ImagePlus;

public abstract class CriterioSegmentacion {

	// Dado una imagen y un punto, se determina si pertenece o no al objeto de interes
	public abstract boolean pertenece(ImagePlus im, int i, int j);
	
}
