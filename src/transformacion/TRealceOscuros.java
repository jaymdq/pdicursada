package transformacion;

public class TRealceOscuros extends TransformacionPunto {

	@Override
	protected int get(int i) {
		return (int) (255 * Math.log(1 + i) / Math.log(255));
	}

}
