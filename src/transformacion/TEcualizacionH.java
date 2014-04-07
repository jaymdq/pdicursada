package transformacion;

import engine.Histograma;

public class TEcualizacionH extends TransformacionPunto {

	private Histograma h;
	private int n;
	
	public TEcualizacionH(Histograma h){
		this.h = h;
		this.n = h.getPixelCant();
		
		calcular();
		
		// Normalizar valores calculados
		for (int i = 0; i < 256; i++){
			funcion[i] = funcion[i] * 255 / n;
		}
	}
	
	@Override
	protected int get(int i) {
		if (i == 0)
			return h.getValue(i);
		
		return (funcion[i - 1] + h.getValue(i));
		
	}

}
