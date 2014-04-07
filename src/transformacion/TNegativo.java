package transformacion;

/* Transformacion: Negativo
 * 
 * - Convierte los valores oscuros en claros, y viceversa
 * 
 * f(i) = 255 - i
 * 
 */

public class TNegativo extends TransformacionPunto {
	
	public TNegativo(){
		calcular();
	}
	
	@Override
	protected int get(int i) {
		return 255 - i;
	}

}
