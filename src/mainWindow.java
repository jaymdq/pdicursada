import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.gui.ImageRoi;
import ij.gui.NewImage;
import ij.process.ImageProcessor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import java.awt.FlowLayout;


import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;

import com.jgoodies.forms.factories.FormFactory;

import engine.Histograma;
import engine.Imagen;
import engine.MatrizConvolucion;
import filtro.FiltroBmp;

import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.CardLayout;

import javax.swing.Box;
import javax.swing.border.SoftBevelBorder;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

import transformacion.TEcualizacionH;
import transformacion.TLineal;
import transformacion.TAumentoIntensidad;
import transformacion.TExponencial;
import transformacion.TNegativo;
import transformacion.TLogaritmica;
import transformacion.TUmbralado;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.JTextField;


public class mainWindow {

	private JFrame frmProcesamientoDigitalDe;
	private int paso = 1;
	private int colores3 = 256;
	private JRadioButton r128;
	private JRadioButton r2;
	private JRadioButton r16;
	private JRadioButton r64;
	private JRadioButton r32;
	private JRadioButton r256;
	private JLabel imagen1;
	private JLabel imagen3;
	private JLabel imagen4;
	private ImagePlus im4;
	private ImagePlus im4trabajo;
	private JComboBox nivelGris4;
	private ImagePlus im5;
	private ImagePlus im5trabajo;
	private JLabel Imagen5;
	private JTextField ej5ancho;
	private JTextField ej5alto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frmProcesamientoDigitalDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
		
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProcesamientoDigitalDe = new JFrame();
		frmProcesamientoDigitalDe.setFont(new Font("Verdana", Font.PLAIN, 14));
		frmProcesamientoDigitalDe.setResizable(false);
		frmProcesamientoDigitalDe.setTitle("Procesamiento Digital De Im\u00E1genes - CAIMMI, Brian - ROCHA Hern\u00E1n");
		int ancho = frmProcesamientoDigitalDe.getToolkit().getScreenSize().width;
		int alto = frmProcesamientoDigitalDe.getToolkit().getScreenSize().height;
		frmProcesamientoDigitalDe.setBounds(0,0,ancho - 100, alto - 100);
		frmProcesamientoDigitalDe.setLocationRelativeTo(null);
		frmProcesamientoDigitalDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmProcesamientoDigitalDe.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JTabbedPane tabsPane = new JTabbedPane(JTabbedPane.TOP);
		tabsPane.setForeground(Color.BLACK);
		tabsPane.setBackground(Color.GRAY);
		frmProcesamientoDigitalDe.getContentPane().add(tabsPane, BorderLayout.CENTER);
		
		JPanel inPane1 = new JPanel();
		inPane1.setBackground(new Color(255, 255, 102));
		inPane1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		JPanel inPane2 = new JPanel();
		inPane2.setBackground(new Color(255, 255, 102));
		inPane2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		JPanel inPane3 = new JPanel();
		inPane3.setBackground(new Color(255, 255, 102));

		JPanel inPane4 = new JPanel();
		inPane4.setBackground(new Color(255, 255, 102));
		
		JPanel inPane5 = new JPanel();
		inPane5.setBackground(new Color(255, 255, 102));
		
		tabsPane.addTab("Ej. 1", inPane1);
		tabsPane.addTab("Ej. 3", inPane2);
		tabsPane.addTab("Ej. 4", inPane3);
		tabsPane.addTab("Ej. 5", inPane4);
		tabsPane.addTab("Ej. 6", inPane5);;
		inPane4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setVgap(60);
		inPane4.add(panel_3, BorderLayout.SOUTH);
		
		JButton btn5cargar = new JButton("Cargar");
		btn5cargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarImagen5();
			}
		});
		btn5cargar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btn5cargar);
		
		JButton btn5procesar = new JButton("Procesar");
		btn5procesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar5();
			}
		});
		btn5procesar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btn5procesar);
		
		JButton btn5resetear = new JButton("Resetear");
		btn5resetear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			resetear5();
			}
		});
		
		JButton genHistograma = new JButton("Histograma");
		genHistograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				Histograma hist = new Histograma(im5trabajo);
				Imagen5.setIcon(new ImageIcon(hist.getHistograma().getImage()));
				
			}
		});
		genHistograma.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(genHistograma);
		btn5resetear.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btn5resetear);
		
		ej5ancho = new JTextField();
		ej5ancho.setText("80");
		panel_3.add(ej5ancho);
		ej5ancho.setColumns(10);
		
		ej5alto = new JTextField();
		ej5alto.setText("60");
		panel_3.add(ej5alto);
		ej5alto.setColumns(10);
		
		Imagen5 = new JLabel("");
		Imagen5.setHorizontalAlignment(SwingConstants.CENTER);
		inPane4.add(Imagen5, BorderLayout.CENTER);
		inPane3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(60);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		inPane3.add(panel_2, BorderLayout.SOUTH);
		
		JButton btn4Cargar = new JButton("Cargar");
		btn4Cargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarImagen4();
			}
		});
		btn4Cargar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(btn4Cargar);
		
		JButton btn4Procesar = new JButton("Procesar");
		btn4Procesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procesar4();
			}
		});
		btn4Procesar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(btn4Procesar);
		
		JButton btn4Resetear = new JButton("Resetear");
		btn4Resetear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetear4();
			}
		});
		btn4Resetear.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(btn4Resetear);
		
		JLabel lblNewLabel = new JLabel("Niveles de gris : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblNewLabel);
		
		nivelGris4 = new JComboBox();
		nivelGris4.setModel(new DefaultComboBoxModel(new String[] {"128", "64", "32", "16", "2"}));
		panel_2.add(nivelGris4);
		
		inPane2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(60);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		inPane2.add(panel, BorderLayout.SOUTH);
		
		JButton btnGenerar3 = new JButton("Generar");
		btnGenerar3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGenerar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p3Generar();
			}
		});
		panel.add(btnGenerar3);
		
		r256 = new JRadioButton("256");
		r256.setSelected(true);
		r256.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion3(256);
			}
		});
		
		JLabel lblEscalaDeGrises = new JLabel("Escala de Grises : ");
		lblEscalaDeGrises.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblEscalaDeGrises);
		panel.add(r256);
		
		r128 = new JRadioButton("128");
		r128.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion3(128);
			}
		});
		panel.add(r128);
		
		r64 = new JRadioButton("64");
		r64.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion3(64);
			}
		});
		panel.add(r64);
		
		r32 = new JRadioButton("32");
		r32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion3(32);
			}
		});
		panel.add(r32);
		
		r16 = new JRadioButton("16");
		r16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion3(16);
			}
		});
		panel.add(r16);
		
		r2 = new JRadioButton("2");
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion3(2);
			}
		});
		panel.add(r2);
		
		inPane1.setLayout(new BorderLayout(0, 0));
		
		imagen1 = new JLabel("");
		imagen1.setHorizontalAlignment(SwingConstants.CENTER);
		inPane1.add(imagen1, BorderLayout.CENTER);
		
		imagen3 = new JLabel("");
		imagen3.setHorizontalAlignment(SwingConstants.CENTER);
		inPane2.add(imagen3 ,BorderLayout.CENTER);
		
		imagen4 = new JLabel("");
		imagen4.setHorizontalAlignment(SwingConstants.CENTER);
		inPane3.add(imagen4 ,BorderLayout.CENTER);
			
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(60);
		inPane1.add(panel_1, BorderLayout.SOUTH);
		
		Button btnGenerar = new Button("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1Generar();
			}
		});
		btnGenerar.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(btnGenerar);
	
		
		
	}

	
	//--Ejercicio 1 ----------------------------------------------------------------------------------------------------
	private void rectFill(ImageProcessor im, int x, int y , int xx, int yy){
		
		for (int j = y; j < yy + y; j++)
			for (int i = x; i < xx + x; i++){
				im.drawDot(i, j);
			}
		
		
	}
	
	//Generar del ejercicio 1.
	protected void p1Generar() {
		
		ImagePlus im = null;
		im = NewImage.createImage("Imagen1", 400, 400, 1, 8, 0);
		//Valor elegido para ser igual
		Integer valorIguales = (int) (Math.random() * 117) + 70; //--70 - 187--
		Vector<Integer> v1 = new Vector<Integer>();
		for (int i = 0 ; i < 4 ; i++)
			v1.add(valorIguales);
		//Valores diferentes
		for(int i = 0 ; i < 5 ; i ++)
			v1.add( (int) (Math.random() * 117) + 70);
		//Realeatorizo el vector
		Collections.shuffle(v1);
		//Empiezo a dibujar
		im.getProcessor().setColor(0);
		im.getProcessor().drawRect(49, 49, 302, 302);
			for (int j = 50; j < 350 ; j++)
			for (int i = 50; i < 350; i++){
				if ( j < 150 && i < 150)			
					im.getProcessor().setColor(0);
				else
				if (  i < 250 && j < 150)			
					im.getProcessor().setColor(16);
				else
				if ( i < 350 && j < 150)
					im.getProcessor().setColor(32);
				else
				if ( i < 150 && j < 250)
					im.getProcessor().setColor(48);
				else
				if ( i < 250 && j < 250)
					im.getProcessor().setColor(64);
				else
				if ( i < 350 && j < 250)
					im.getProcessor().setColor(191);
				else
				if ( i < 150 && j < 350 )
					im.getProcessor().setColor(207);
				else
				if ( i < 250 && j < 350 )
					im.getProcessor().setColor(239);
				else
					im.getProcessor().setColor(255);
					
				im.getProcessor().drawDot(i, j);
					
			}
		
		//Dibujo los cuadraditos
		int pos = 0;	
		for (int j = 90; j < 350 ; j+= 100)
			for (int i = 90; i < 350; i+= 100)
			{
					im.getProcessor().setColor(v1.elementAt(pos));
					pos++;
					rectFill(im.getProcessor(),i,j,20,20);
			}
			
		//Seteo la imagen en pantalla
		imagen1.setIcon(new ImageIcon( im.getImage()));
	}

	//--Ejercicio 3 -----------------------------------------------------------------------------------------------
	
	protected void seleccion3(int i) {
		switch(i){
		case 256 : { paso = 1; 
		colores3=256;
		r128.setSelected(false);
		r64.setSelected(false);
		r32.setSelected(false);
		r16.setSelected(false);
		r2.setSelected(false);
		break;
		}
		case 128 : { paso = 2;
		colores3=128;
		r256.setSelected(false);
		r64.setSelected(false);
		r32.setSelected(false);
		r16.setSelected(false);
		r2.setSelected(false);
		break;
		}
		case 64 : { paso = 4;
		colores3=64;
		r128.setSelected(false);
		r256.setSelected(false);
		r32.setSelected(false);
		r16.setSelected(false);
		r2.setSelected(false);
		break;
		}
		case 32 : { paso = 8;
		colores3=32;
		r128.setSelected(false);
		r64.setSelected(false);
		r256.setSelected(false);
		r16.setSelected(false);
		r2.setSelected(false);
		break;
		}
		case 16 : { paso = 16;
		colores3=16;
		r128.setSelected(false);
		r64.setSelected(false);
		r32.setSelected(false);
		r256.setSelected(false);
		r2.setSelected(false);
		break;
		}
		case 2 : { paso = 128;
		colores3=2;
		r128.setSelected(false);
		r64.setSelected(false);
		r32.setSelected(false);
		r16.setSelected(false);
		r256.setSelected(false);
		break;
		}
		}

	}
	
	//Generar ejercicio 3
	protected void p3Generar() {

		ImagePlus im = null;
		im = NewImage.createImage("Imagen3", 256, 200, 1, 8, 0);
		
	
		int delta = 255 / (colores3 - 1);
		int []escala = new int[colores3 ];
		for (int i =0 ; i < colores3  ; i++){
			escala[i]=  i * delta ;
		}
		
		for (int i = 0; i < 255; i++){
				
				im.getProcessor().setColor( escala[(int) (i*colores3/256)]);
				im.getProcessor().drawLine(i, 0, i, 200);
				
		}
		//Seteo la imagen en pantalla
		imagen3.setIcon(new ImageIcon( im.getImage()));

	}

	//-----------------------------------------------------------------------------------------------------------------

//-- Ejercicio 4 ------------------------------------------------------------------------------------------------------
	


	protected void resetear4() {
		im4trabajo.setImage(im4.getImage());
		imagen4.setIcon(new ImageIcon(im4trabajo.getImage()));
	}

	protected void procesar4() {
		int f ,gris,grisnuevo,nivelGris;
		nivelGris =  Integer.parseInt((String) nivelGris4.getItemAt(nivelGris4.getSelectedIndex()));
		f = 256 / nivelGris;
		System.out.println("Nivel de gris " + nivelGris + "\n f: "+f);
		int total = im4trabajo.getHeight();
		for (int j = 0 ; j < im4trabajo.getHeight() ; j++){
			for (int i = 0 ; i < im4trabajo.getWidth(); i++){
				gris =(int) im4trabajo.getProcessor().getPixelValue(i,j);
				grisnuevo = ((int) (gris / f)) * f;
				im4trabajo.getProcessor().setColor(new Color(grisnuevo,grisnuevo,grisnuevo));
				im4trabajo.getProcessor().drawDot(i, j);

				System.out.println("("+i+"."+j+") gris: "+gris+ " grisnuevo: "+grisnuevo);
			}

			
		}
		imagen4.setIcon(new ImageIcon(im4trabajo.getImage()));

	}

	protected void cargarImagen4() {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Abrir archivo .bmp");
		fc.setFileFilter(new FiltroBmp());
		int returnVal = fc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			//Atenti al file
			File file = fc.getSelectedFile();
			
			//Seteo la imagen en pantalla
			im4 = new ImagePlus(file.getAbsolutePath());
			im4trabajo = new ImagePlus(file.getAbsolutePath());
			imagen4.setIcon(new ImageIcon(im4.getImage()));
			
		}
		
	}


//-- Ejercicio 5 ----------------------------------------------------------------------------------------------------------
	
	protected void cargarImagen5() {
		/*JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Abrir archivo .bmp");
		fc.setFileFilter(new FiltroBmp());
		int returnVal = fc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			//Atenti al file
			File file = fc.getSelectedFile();
			
			//Seteo la imagen en pantalla
			im5 = new ImagePlus(file.getAbsolutePath());
			im5trabajo = new ImagePlus(file.getAbsolutePath());
			Imagen5.setIcon(new ImageIcon(im5.getImage()));
			
		}
		
		*/
		im5 = Imagen.abrirImagen("prueba.jpg");
		im5trabajo = Imagen.abrirImagen("prueba.jpg");
		im5trabajo = Imagen.trasladar(im5, -15.2, 40.7);
		Imagen5.setIcon(new ImageIcon(im5trabajo.getImage()));
		

	}

	protected void resetear5() {
		im5trabajo.setImage(im5.getImage());
		Imagen5.setIcon(new ImageIcon(im5trabajo.getImage()));
		/*
		Histograma hist = new Histograma(im5trabajo);
		Imagen5.setIcon(new ImageIcon(hist.getHistograma().getImage()));
		*/
	}
	
	protected void procesar5() {
		
		ImagePlus im = null;
		int ancho = 640;
		int alto = 480;
		im = NewImage.createImage("Imagen5", ancho, alto, 1, 8, 0);
		
		
		int anchoN = Integer.parseInt( ej5ancho.getText());
		int altoN = Integer.parseInt( ej5alto.getText());
		
		double proporcion = ancho / anchoN;
				
		for (int j = 0 ; j < altoN ; j++){
			for (int i = 0 ; i < anchoN; i++){
				
				int acum = 0;
				
				for ( int x = 0; x < proporcion; x++){
					for ( int y = 0; y < proporcion; y++){
						 acum += im5.getProcessor().getPixelValue((int) (i*proporcion) + x, (int) (j*proporcion) + y);
					}
				}
				
				int gris =(int) ( acum / (proporcion * proporcion));
				
				for ( int x = 0; x < proporcion; x++){
					for ( int y = 0; y < proporcion; y++){
						im.getProcessor().setColor(gris);
						im.getProcessor().drawDot((int) (i*proporcion )+ x,(int) (j * proporcion) + y);
					}
				}				
			}
		}
		
		im5trabajo = im;
		Imagen5.setIcon(new ImageIcon(im5trabajo.getImage()));
		
		
//		im5trabajo = Imagen.aplicarFiltro(im5, new MatrizConvolucion(3, new int[][]{
//				{1, 1, 1}, 
//				{1, -9, 1}, 
//				{1, 1, 1}}));
		
//		im5trabajo = Imagen.aplicarFiltro(im5, new MatrizConvolucion(3, new int[][]{
//		{1, 1, 1}, 
//		{0, -3, 0}, 
//		{0, 0, 0}}));
		
//		im5trabajo = Imagen.aplicarFiltro(im5, new MatrizConvolucion(5, new int[][]{
//				{1, 1, 1, 1, 1}, 
//				{1, 1, 1, 1, 1}, 
//				{1, 1, 1, 1, 1}, 
//				{1, 1, 1, 1, 1}, 
//				{1, 1, 1, 1, 1}}));
		
//		im5trabajo = Imagen.aplicarTransformacion(im5, new TNegativo());
//		im5trabajo = Imagen.aplicarTransformacion(im5, new TUmbralado(scrollBar.getValue(), 30, 255));
//		im5trabajo = Imagen.aplicarTransformacion(im5, new TLogaritmica());
//		im5trabajo = Imagen.aplicarTransformacion(im5, new TRealceOscuros());
//		im5trabajo = Imagen.aplicarTransformacion(im5, new TExponencial(2.5));
//		im5trabajo = Imagen.aplicarTransformacion(im5, new TLineal(100, 200, 0, 255));
//		im5trabajo = Imagen.aplicarTransformacion(im5, new TEcualizacionH(new Histograma(im5)));
//		Imagen.guardarImagen(im5trabajo, "nueva.jpg");
		
		Imagen5.setIcon(new ImageIcon(im5trabajo.getImage()));
		
	}

}
