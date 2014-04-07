package transformacion;

public class TLineal extends TransformacionPunto {

	int inMin, inMax, outMin, outMax;
	
	public TLineal(int inMin, int inMax, int outMin, int outMax) {
		this.inMin = inMin;
		this.inMax = inMax;
		this.outMin = outMin;
		this.outMax = outMax;
		
		calcular();
	}

	@Override
	protected int get(int i) {
		if (i < inMin)
			return 0;
		
		if (i > inMax)
			return 255;
		
		return (outMax - outMin) * (i - inMin) / (inMax - inMin) + outMin;
	}

}
