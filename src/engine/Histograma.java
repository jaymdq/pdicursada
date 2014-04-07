package engine;
import ij.ImagePlus;
import ij.gui.NewImage;

public class Histograma {

	int[] valores = new int[256];
	ImagePlus im;
	
	public Histograma(){
		init();
	}
	
	public Histograma(ImagePlus im){
		cargarImagen(im);
	}

	public void cargarImagen(ImagePlus im) {
		this.im = im;
		update();
	}
	
	public int getValue(int i){
		return valores[i];
	}
	
	public int getPixelCant(){
		return im.getWidth() * im.getHeight();
	}
	
	public ImagePlus getHistograma() {
		// Obtener el maximo
		int max = 0;
		
		for (int i : valores){
			if (i > max){
				max = i;
			}
		}
		
		// Dibujar lineas
		int altoH = 200;
		ImagePlus hist = NewImage.createImage("hist", 256, altoH, 1, 8, 0);		
		hist.getProcessor().setColor(0);
		
		for (int i = 0; i < 256; i++){
			int h =  valores[i] * (altoH - 1) / max;
			hist.getProcessor().drawLine(i, altoH - 1 - h, i, altoH - 1);
		}
		
		return hist;
	}

	private void init() {
		for (int i = 0; i < 256; i++){
			valores[i] = 0;
		}		
	}
	
	private void update(){
		// Resetear valores
		init();
		
		// Calcular histograma
		int ancho = im.getWidth();
		int alto = im.getHeight();
		
		for (int i = 0; i < alto; i++){
			for (int j = 0; j < ancho; j++){
				//valores[Imagen.getPixel(im, i, j)]++;
				valores[(int) im.getProcessor().getPixelValue(j, i)]++;
			}
		}
	}
}
