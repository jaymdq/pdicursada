package transformacion;

public abstract class TransformacionPunto {

	protected int[] funcion = new int[256];
	
	public TransformacionPunto(){
		//calcular();
	}

	// Calcular el resultado de la transformacion para un valor de intensidad
	protected abstract int get(int i);
	
	// Calcular la funcion completa de transformacion
	public void calcular(){
		System.out.println("Calculando");
		for (int i = 0; i < 256; i++){
			funcion[i] = get(i);
		}
	}
	
	// Obtener transformacion de un valor de intensidad
	public int getCalculado(int i){
		return funcion[i];
	}
	
	
}
