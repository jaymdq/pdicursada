package transformacion;

/* Transformacion: Umbralado
 * 
 * - Convierte en valorUmbral(=255 por defecto) los valores de intensidad entre umbralMin y umbralMax(=255 por defecto)
 * - Deja el resto sin modificar
 * 
 * f(i) = valorUmbral          umbralMin <= i <= umbralMax
 *        i                    En otro caso
 */

public class TUmbraladoParcial extends TransformacionPunto {

	private int umbralMin, umbralMax, valorUmbral;
	
	public TUmbraladoParcial(int umbralMin, int umbralMax, int valorUmbral){
		this.valorUmbral = valorUmbral;
		this.umbralMin = umbralMin;
		this.umbralMax = umbralMax;
		
		calcular();
	}
	
	public TUmbraladoParcial(int umbral){
		this(umbral, 255, 255);
	}
	
	@Override
	protected int get(int i) {
		if ( (i >= umbralMin) && (i <= umbralMax) ){
			return valorUmbral;
		} else{
			return i;
		}
	}

}
