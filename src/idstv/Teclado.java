package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.Color;
import java.awt.Component;

public class Teclado implements KeyListener {

	private JFrame frame;
	private Map<Character, JLabel> teclasMap;
	private JLabel UltTeclaPres;
	private Color colorFijo = new Color(192, 192, 192);
	private Random random = new Random();
	
	//ARREGLO DE LETRAS
	private final char[] letras = {
			'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
	        'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Ñ',
	        'Z', 'X', 'C', 'V', 'B', 'N', 'M'
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teclado window = new Teclado();
					window.frame.setVisible(true);
					window.frame.addKeyListener(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Teclado() {
		initialize();
		configurarTeclasMap();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		
		JPanel pnlNorte = new JPanel();
		
		pnlNorte.setBackground(new Color(179, 229, 252));
		pnlNorte.setOpaque(true);
		frame.getContentPane().add(pnlNorte, BorderLayout.NORTH);
		pnlNorte.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEsperando = new JLabel("ESPERANDO");
		lblEsperando.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		lblEsperando.setFont(new Font("Tahoma", Font.BOLD, 40));
		//lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		pnlNorte.add(lblEsperando);
		
		JLabel lblPalabraEsc = new JLabel("Palabra a escribir: ");
		lblPalabraEsc.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlNorte.add(lblPalabraEsc, BorderLayout.SOUTH);
		
		JPanel pnlSur = new JPanel();
		pnlSur.setBackground(new Color(179, 229, 252));
		frame.getContentPane().add(pnlSur, BorderLayout.SOUTH);
		pnlSur.setLayout(null);
		pnlSur.setLayout(new GridLayout(1, 0, 1, 2));
		
		JLabel lblEspacio = new JLabel("ESPACIO");
		lblEspacio.setHorizontalAlignment(JLabel.CENTER);
		lblEspacio.setFont(new Font("Tahoma", Font.BOLD, 40));
		pnlSur.add(lblEspacio);
		
		JLabel lblBorrado = new JLabel("BORRANDO");
		lblBorrado.setHorizontalAlignment(JLabel.CENTER);
		lblBorrado.setFont(new Font("Tahoma", Font.BOLD, 40));
		//lblBorrado.setBackground(UIManager.getColor("Button.background"));
		pnlSur.add(lblBorrado);
		
		JPanel pnlCentro = new JPanel();
		//pnlCentro.setBackground(UIManager.getColor("Button.shadow"));
		frame.getContentPane().add(pnlCentro, BorderLayout.CENTER);
		pnlCentro.setLayout(new GridLayout(3, 0, 3, 9));
		
		for(char letra : letras) {
			pnlCentro.add(crearTecla(String.valueOf(letra), 20));
		}
	}
		
		private JLabel crearTecla(String texto, int tamañoFuente) {
			JLabel tecla = new JLabel(texto);
			tecla.setFont(new Font("Tahoma", Font.BOLD, tamañoFuente));
	        tecla.setHorizontalAlignment(JLabel.CENTER);
	        tecla.setOpaque(true); // Necesario para que se vea el color de fondo
	        tecla.setBackground(colorFijo);
	        tecla.setFocusable(false);
	        return tecla;
		};
		
		private void configurarTeclasMap() {
			teclasMap = new HashMap<>();
			JPanel pnlCentro = null;
			
			for (Component comp : frame.getContentPane().getComponents()) {
	            if (comp instanceof JPanel) {
	                JPanel panel = (JPanel) comp;
	                if (panel.getComponentCount() == letras.length) {
	                    pnlCentro = panel;
	                    break;
	                }
	            }
	        }
	        
	        if (pnlCentro != null) {
	            for (int i = 0; i < letras.length; i++) {
	                Component comp = pnlCentro.getComponent(i);
	                if (comp instanceof JLabel) {
	                    teclasMap.put(letras[i], (JLabel) comp);
	                }
	            }
	        } else {
	            System.err.println("Error: No se encontró el panel con las teclas");
	        }
	    
		}
		
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char letra = Character.toUpperCase(e.getKeyChar());
		
		//VERIFICAR SI LA LETRA ESTA EN EL MAP
		if(teclasMap.containsKey(letra)) {
			//PARA RESTAURAR EL COLOR ANTERIOR
			if(UltTeclaPres != null) {
				UltTeclaPres.setBackground(colorFijo);
			}
			
			JLabel teclaActual = teclasMap.get(letra);
			
			//PARA GENERAR UN COLOR ALEATORIO
			Color colorAleatorio = new Color(
					random.nextInt(256),
					random.nextInt(256),
					random.nextInt(256)
					);
			
			//PARA CAMBIAR EL COLOR DE LA TECLA Q SE PRECIONO
			teclaActual.setBackground(colorAleatorio);
			UltTeclaPres = teclaActual;
					
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
