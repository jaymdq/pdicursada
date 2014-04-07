package engine;
import ij.ImagePlus;
import ij.gui.NewImage;


public class MatrizImagen {

	int[][] img;
	int alto;
	int ancho;
	
	public MatrizImagen(int alto, int ancho){
		this.alto = alto;
		this.ancho = ancho;
		img = new int[alto][ancho];
		
//		for (int i = 0; i < alto; i++){
//			for (int j = 0; j < ancho; j++){
//				set(i, j, 0);
//			}
//		}
	}
	
	public void set(int i, int j, int valor){
		img[i][j] = valor;
	}
	
	public int get(int i, int j){
		return img[i][j];
	}
	
	public ImagePlus getNormalizadoLineal(){
		ImagePlus norm = NewImage.createImage("norm", ancho, alto, 1, 8, 0);
		
		// Obtener maximo / minimo
		int max = 0, min = 0;
		for(int[] i : img){
			for(int j : i){
				if (j > max){
					max = j;
				}
				
				if (j < min){
					min = j;
				}
			}
		}
		
		System.out.println("Max:" + max);
		System.out.println("Min" + min);
		
		for (int i = 0; i < alto; i++){
			for (int j = 0; j < ancho; j++){
				int color = 255 * (get(i, j) - min) / (max - min);
				Imagen.setPixel(norm, i, j, color);
			}
		}
		
		return norm;
	}
	
	public ImagePlus getNormalizadoAbsoluto(){
		ImagePlus norm = NewImage.createImage("norm", ancho, alto, 1, 8, 0);
		
		// Obtener maximo / minimo
		int max = 0, min = 0;
		for(int[] i : img){
			for(int j : i){
				if (j > max){
					max = j;
				}
				
				if (j < min){
					min = j;
				}
			}
		}
		
		System.out.println("Max:" + max);
		System.out.println("Min" + min);
		
		for (int i = 0; i < alto; i++){
			for (int j = 0; j < ancho; j++){
				int color = Math.abs(get(i, j));
				Imagen.setPixel(norm, i, j, color);
			}
		}
		
		return norm;
	}
	
}
