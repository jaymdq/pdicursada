import ij.ImagePlus;
import ij.gui.NewImage;


public class Imagen {

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
		ImagePlus nueva = mat.getNormalizadoLineal();
		
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
	
	
	
}
