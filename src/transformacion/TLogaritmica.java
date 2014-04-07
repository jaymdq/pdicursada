package transformacion;

public class TLogaritmica extends TransformacionPunto {

	public TLogaritmica(){
		calcular();
	}
	
	@Override
	protected int get(int i) {
		return (int) (255 * Math.log(1 + i) / Math.log(255));
	}

}
