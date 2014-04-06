package transformacion;

/* Transformacion: Umbralado
 * 
 * Convierte en valorUmbral(=255 por defecto) los valores de intensidad entre umbralMin y umbralMax(=255 por defecto)
 * Deja el resto como negro
 * 
 * f(i) = valorUmbral          umbralMin <= i <= umbralMax
 *        0                    En otro caso
 *  
 */

public class TUmbralado extends TransformacionPunto {

	private int umbralMin, umbralMax, valorUmbral;
	
	public TUmbralado(int umbralMin, int umbralMax, int valorUmbral){
		this.valorUmbral = valorUmbral;	
		this.umbralMin = umbralMin;
		this.umbralMax = umbralMax;
		
		calcular();
	}
	
	public TUmbralado(int umbral){
		this(umbral, 255, 255);
	}
	
	@Override
	protected int get(int i) {
		if ( (i >= umbralMin) && (i <= umbralMax) ){
			return valorUmbral;
		} else{
			return 0;
		}
	}

}
