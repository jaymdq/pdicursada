package segmentacion;

import ij.ImagePlus;

public abstract class Objeto {

	// Procesa una imagen en busca de un objeto (dado por el criterio) y lo almacena internamente
	public abstract void procesar(ImagePlus im, CriterioSegmentacion criterio);
	
}
