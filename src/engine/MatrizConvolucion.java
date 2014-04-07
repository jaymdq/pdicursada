package engine;

public class MatrizConvolucion {

	private int[][] matriz;
	private int tam;
	private int radio;
	
	public MatrizConvolucion (int tam, int[][] matriz){
		this.matriz = matriz;
		this.tam = tam;
		this.radio = tam / 2;
	}
	
	public int getRadio(){
		return radio;
	}
	
	public int getTam(){
		return tam;
	}
	
	public int get(int i, int j){
		return matriz[i][j];
	}
	
}
