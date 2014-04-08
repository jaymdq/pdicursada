package engine;
import java.io.File;

import transformacion.TransformacionPunto;
import ij.ImagePlus;
import ij.gui.NewImage;
import ij.io.FileSaver;


public class Imagen {
	
	public static ImagePlus abrirImagen(String path){
		return new ImagePlus(path);
	}
	
	public static void guardarImagen(ImagePlus im, String path){
		(new FileSaver(im)).saveAsJpeg(path);
	}

	// Setear la intensidad de un pixel (x,y)
	public static void setPixel (ImagePlus im, int x, int y, int color){
		
		im.getProcessor().setColor(color);
		im.getProcessor().drawDot(y, x);
		
	}
	
	// Obtener la intensidad de un pixel (x,y)
	public static int getPixel (ImagePlus im, int x, int y){
		
		return (int) im.getProcessor().getPixelValue(y, x);
		
	}
	
	// Aplicar un filtro a una imagen completa
	public static ImagePlus aplicarFiltro(ImagePlus im, MatrizConvolucion matriz){
		
		int ancho = im.getWidth();
		int alto = im.getHeight();
		int radio = matriz.getRadio();
		
		// Crear imagen de resultado
		
		//ImagePlus nueva = NewImage.createImage("nueva", ancho, alto, 1, 8, 0);
		MatrizImagen mat = new MatrizImagen(alto, ancho);
		
		// Recorrer imagen (excepto bordes)
		for (int i = radio; i < alto - radio; i++){
			for (int j = radio; j < ancho - radio; j++){
				
				int color = aplicarFiltro(im, matriz, i, j);
				mat.set(i, j, color);
				
			}
		}
		
		// Normalizar
		ImagePlus nueva = mat.getNormalizadoAbsoluto();
		
		// Devolver imagen nueva
		return nueva;
	}
	
	// Aplicar filtro a un pixel (i,j)
	public static int aplicarFiltro (ImagePlus im, MatrizConvolucion matriz, int i, int j){
		
		int tam = matriz.getTam();
		int radio = matriz.getRadio();
		int acumulador = 0;
		//int normalizacion = tam * tam;
		
		// Recorrer matriz de convolucion
		for (int x = 0; x < tam; x++){
			for (int y = 0; y < tam; y++){
				acumulador += matriz.get(x, y) * getPixel(im, i - radio + x, j - radio + y);
			}
		}
		
		// Devolver valor normalizado
		//return acumulador / normalizacion;
		return acumulador;
	}
	
	// Aplicar un filtro a una imagen completa
	public static ImagePlus aplicarTransformacion(ImagePlus im, TransformacionPunto transformacion){
		
		int ancho = im.getWidth();
		int alto = im.getHeight();
		
		// Crear imagen de resultado		
		ImagePlus nueva = NewImage.createImage("nueva", ancho, alto, 1, 8, 0);
		
		// Recorrer imagen (excepto bordes)
		for (int i = 0; i < alto; i++){
			for (int j = 0; j < ancho; j++){
				
				int color = getPixel(im, i, j);
				color = transformacion.getCalculado(color);
				setPixel(nueva, i, j, color);			
				
			}
		}
		
		// Devolver imagen nueva
		return nueva;
	}

	public static ImagePlus trasladar(ImagePlus im, double despI, double despJ) {
		int ancho = im.getWidth();
		int alto = im.getHeight();
		
		int iEnt = (int) Math.round(despI), jEnt = (int) Math.round(despJ);
		double alpha = despI - iEnt, beta = despJ - jEnt;
		
		// Crear imagen de resultado		
		ImagePlus nueva = NewImage.createImage("nueva", ancho, alto, 1, 8, 0);
		
		// Recorrer imagen (excepto bordes)
		for (int i = 0; i < alto; i++){
			for (int j = 0; j < ancho; j++){
				
				int color = (int) ( getPixel(im, i - iEnt, j - jEnt)         * (1 - alpha) * (1 - beta)) + 
						    (int) ( getPixel(im, i - iEnt, j - jEnt + 1)     * (alpha)     * (1 - beta)) +
						    (int) ( getPixel(im, i - iEnt + 1, j - jEnt)     * (1 - alpha) * (beta))     +
						    (int) ( getPixel(im, i - iEnt + 1, j - jEnt + 1) * (alpha)     * (beta));
				
				setPixel(nueva, i, j, color);			
				
			}
		}
		
		// Devolver imagen nueva
		return nueva;
	}
	
}
