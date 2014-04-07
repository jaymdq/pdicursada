package transformacion;

public class TExponencial extends TransformacionPunto {

	private double delta;
	
	public TExponencial(double d){
		this.delta = d;
		
		calcular();
	}
	
	@Override
	protected int get(int i) {
		return (int) (255 * Math.pow(i, delta) / Math.pow(255, delta));
	}

}
