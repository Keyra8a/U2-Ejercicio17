package idstv;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
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
	private int seg = 0;
	private int mil = 0;
	//ARREGLO DE LETRAS
	private final char[] letras = {
			'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
	        'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Ñ',
	        'Z', 'X', 'C', 'V', 'B', 'N', 'M'
	       
	};
	
	Timer timer;
	private ArrayList<String> palabras = new ArrayList<>();
	JLabel lblPalabraEsc;
	JLabel lblEsperando;
	JLabel lblTimer;
	String palabraActual;
	StringBuilder palabraEscrita = new StringBuilder();

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
					window.nuevaRonda();
					 // MOSTRAR MENÚ JUEGO
                    JOptionPane.showMessageDialog(window.frame, 
                            "Instrucciones:\n\n1. Se mostrará una palabra en pantalla\n" +
                            "2. Debes escribirla exactamente igual\n" +
                            "3. Presiona Enter para validar\n" +
                            "4. El juego mostrará tu tiempo de respuesta\n" +
                            "5. El juego continuará con una nueva palabra automáticamente\n",
                            "Instrucciones del Juego", 
                            JOptionPane.INFORMATION_MESSAGE);
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
		//nuevaRonda();
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
		
		listaPalabras();
		
		
		JPanel pnlNorte = new JPanel();
		
		pnlNorte.setBackground(new Color(179, 229, 252));
		pnlNorte.setOpaque(true);
		frame.getContentPane().add(pnlNorte, BorderLayout.NORTH);
		pnlNorte.setLayout(new BorderLayout(0, 0));
		
		lblEsperando = new JLabel("");
		lblEsperando.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		lblEsperando.setFont(new Font("Tahoma", Font.BOLD, 40));
		//lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		pnlNorte.add(lblEsperando);
		
		lblPalabraEsc = new JLabel();
		lblPalabraEsc.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlNorte.add(lblPalabraEsc, BorderLayout.SOUTH);
		
		lblTimer = new JLabel("0:0");
		lblTimer.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		pnlNorte.add(lblTimer, BorderLayout.EAST);
		
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
		
		palabraActual = palabras.get(random.nextInt(palabras.size()));
		lblPalabraEsc.setText("Palabra a escribir: " + palabraActual.toUpperCase());
		
		ActionListener taskPerformer = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String[] split_string = lblTimer.getText().split(":");
				int mil = Integer.parseInt(split_string[1]);
				
				mil+=1;
				
				if(mil >= 10) {
					seg++;
					mil= 1;
				}
				lblTimer.setText(seg+":"+mil+"");
				
			}
		};
		timer = new Timer(100, taskPerformer);
		
		
		
		
		for(char letra : letras) {
			pnlCentro.add(crearTecla(String.valueOf(letra), 20));
		}
	}
	
	 private void listaPalabras() {
	        palabras.add("chocolate");
	        palabras.add("medusa");
	        palabras.add("teclado");
	        palabras.add("pinol");
	        palabras.add("silla");
	        palabras.add("letras");
	        palabras.add("coche");
	        palabras.add("aguacate");
	        palabras.add("perejil");
	        palabras.add("cilantro");
	        palabras.add("mayonesa");
	        palabras.add("computadora");
	        palabras.add("ventana");
	        palabras.add("libro");
	        palabras.add("lapiz");
	        palabras.add("monitor");
	        palabras.add("mesa");
	        palabras.add("casa");
	        palabras.add("perro");
	        palabras.add("gato");
	        palabras.add("elefante");
	        palabras.add("jirafa");
	        palabras.add("leon");
	        palabras.add("tigre");
	        palabras.add("oso");
	        palabras.add("pajaro");
	        palabras.add("pez");
	        palabras.add("tortuga");
	        palabras.add("serpiente");
	        palabras.add("rana");
	        palabras.add("mariposa");
	        palabras.add("abeja");
	        palabras.add("mosca");
	        palabras.add("araña");
	        palabras.add("escorpion");
	        palabras.add("camaron");
	        palabras.add("pulpo");
	        palabras.add("ballena");
	        palabras.add("delfin");
	        palabras.add("tiburon");
	        palabras.add("caballo");
	        palabras.add("vaca");
	        palabras.add("cerdo");
	        palabras.add("oveja");
	        palabras.add("caballo");
	        palabras.add("gallina");
	        palabras.add("pato");
	        palabras.add("pavo");
	        palabras.add("conejo");
	        palabras.add("raton");
	        palabras.add("ardilla");
	        palabras.add("zorro");
	        palabras.add("lobo");
	        palabras.add("murcielago");
	        palabras.add("tucan");
	        palabras.add("colibri");
	        palabras.add("aguila");
	        palabras.add("halcon");
	        palabras.add("buitre");
	        palabras.add("paloma");
	        palabras.add("gorrion");
	        palabras.add("canario");
	        palabras.add("flamenco");
	        palabras.add("pingüino");
	        palabras.add("foca");
	        palabras.add("morsa");
	        palabras.add("orca");
	        palabras.add("medusa");
	        palabras.add("estrella");
	        palabras.add("erizo");
	        palabras.add("cangrejo");
	        palabras.add("langosta");
	        palabras.add("caracol");
	        palabras.add("babosa");
	        palabras.add("lombriz");
	        palabras.add("hormiga");
	        palabras.add("cucaracha");
	        palabras.add("grillo");
	        palabras.add("saltamontes");
	        palabras.add("mantis");
	        palabras.add("libelula");
	        palabras.add("escarabajo");
	        palabras.add("mariposa");
	        palabras.add("polilla");
	        palabras.add("mosquito");
	        palabras.add("zancudo");
	        palabras.add("avispa");
	        palabras.add("hormiga");
	        palabras.add("termino");
	        palabras.add("diccionario");
	        palabras.add("enciclopedia");
	        palabras.add("biblioteca");
	        palabras.add("universidad");
	        palabras.add("escuela");
	        palabras.add("colegio");
	        palabras.add("instituto");
	        palabras.add("academia");
	        
	    }
		
		private JLabel crearTecla(String texto, int tamañoFuente) {
			JLabel tecla = new JLabel(texto);
			tecla.setFont(new Font("Tahoma", Font.BOLD, tamañoFuente));
	        tecla.setHorizontalAlignment(JLabel.CENTER);
	        tecla.setOpaque(true);
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
	        }
	    
		}
		
		private void nuevaRonda() {
			palabraActual = palabras.get(random.nextInt(palabras.size()));
	        lblPalabraEsc.setText("Palabra a escribir: " + palabraActual.toUpperCase());
	        lblEsperando.setText("");
	        palabraEscrita.setLength(0); // Limpiar la palabra escrita
	        seg = 0;
	        mil = 0;
	        lblTimer.setText("0:0");

		}
		
		private void validarPalabra(){
			timer.stop();
			String palabraIngresada = palabraEscrita.toString();
			boolean correcto = palabraIngresada.equalsIgnoreCase(palabraActual);
			
			double tiempoSegundos = seg + mil /1000.0;
			
			String mensaje = correcto ? 
		            "¡Correcto!\nTardaste: " + String.format("%.3f", tiempoSegundos) + " segundos" :
		            "Incorrecto. La palabra era: " + palabraActual;
		        
		    JOptionPane.showMessageDialog(frame, mensaje, "Resultado", 
		        correcto ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
		        
		    nuevaRonda();
		}
		
	@Override
	public void keyTyped(KeyEvent e) {

        char c = e.getKeyChar();
        
        if (c == KeyEvent.VK_ENTER) {
            validarPalabra();
        } else if (c == KeyEvent.VK_BACK_SPACE && palabraEscrita.length() > 0) {
            palabraEscrita.deleteCharAt(palabraEscrita.length() - 1);
        } else if (Character.isLetter(c) || c == ' ') {
            palabraEscrita.append(c);
        }
        
        // Actualiza el display con lo escrito
        lblEsperando.setText("Palabra: "+palabraEscrita.toString().toUpperCase());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char letra = Character.toUpperCase(e.getKeyChar());
		timer.start();
		
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
		// Inicia el timer al primer caracter
        if (!timer.isRunning() && (Character.isLetter(e.getKeyChar()) || e.getKeyChar() == ' ')) {
            timer.start();
        }
  
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
