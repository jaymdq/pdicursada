package transformacion;

/* 
 * 
 * f(i) = m * i + b
 * 
 * m = (255 - iMin) / 255
 * b = iMin
 *
 */

public class TAumentoIntensidad extends TransformacionPunto {

	private int iMin;
	
	public TAumentoIntensidad (int iMin){
		this.iMin = iMin;
		
		calcular();
	}
	
	@Override
	protected int get(int i) {
		return (255 - iMin) * i / 255  + iMin;
	}

}
