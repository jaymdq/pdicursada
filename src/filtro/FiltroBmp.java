package filtro;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FiltroBmp extends FileFilter {

	@Override
	public boolean accept(File file) {
		 if (file.isDirectory()) {
		      return true;
		    } else {
		      String path = file.getAbsolutePath().toLowerCase();
		        String extension = "bmp";
		        if ((path.endsWith(extension) && (path.charAt(path.length() 
		                  - extension.length() - 1)) == '.')) {
		          return true;
		        
		      }
		    }
		    return false;
	}

	@Override
	public String getDescription() {
		return "Archivos de mapa de bits (.bmp)";
	}

}
