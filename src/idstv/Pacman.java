package idstv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import idstv.Paint.DrawingPanel;
import java.awt.Font;

public class Pacman implements KeyListener {

	private JFrame frame;
	private DrawingPanel tablero;
	private int velocidad = 10;
	private Player pacman;
	private List<Player> paredes = new ArrayList<>();
	
	private int direccionX = 0;
	private int direccionY = 0;
	private boolean enMovimiento = false;
	
	
	private JLabel tiempoLabel;
	private int mil = 0;
	private int segundos = 0;
	private Timer timerJuego;
	
	Timer timer;
	

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacman window = new Pacman();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pacman() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pacman = new Player(200, 200, 30, 30, Color.yellow);
		
		//paredes
		paredes.add(new Player(120, 300, 200, 30, Color.orange));
		paredes.add(new Player(120, 50, 200, 30, Color.orange));
		paredes.add(new Player(400, 50, 30, 200, Color.magenta));
			
		JPanel pnlNorte = new JPanel();
		pnlNorte.setBackground(new Color(0, 0, 128));
		frame.getContentPane().add(pnlNorte, BorderLayout.NORTH);
		pnlNorte.setLayout(null);
		pnlNorte.setLayout(new GridLayout(2, 1, 0, 0));
		pnlNorte.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		
		tiempoLabel = new JLabel("00:00");
		tiempoLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
	    tiempoLabel.setForeground(Color.WHITE);
	    tiempoLabel.setHorizontalAlignment(JLabel.CENTER);
	    //tiempoLabel.setFont(new Font("Arial", Font.BOLD, 20));
	    pnlNorte.add(tiempoLabel);
		
		JPanel footer = new JPanel();
		footer.setBackground(new Color(0, 0, 160));
		frame.getContentPane().add(footer, BorderLayout.SOUTH);
		footer.setLayout(new GridLayout(1, 2, 20, 20));
		footer.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		
		tablero = new DrawingPanel();
		tablero.setBackground(Color.BLACK);
		frame.getContentPane().add(tablero, BorderLayout.CENTER);
		tablero.setLayout(new GridLayout(1, 2, 20, 20));
		tablero.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		
		tablero.addKeyListener(this);
		tablero.setFocusable(true);
		
		JButton reiniciar = new JButton("Reiniciar");
		reiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pacman.x = 200;
				pacman.y = 100;
				//segundosTrans = 0;
		        actualizarTiempo();
				tablero.repaint();
				tablero.requestFocus();
				
			}
		});
		footer.add(reiniciar);

		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moverPacman();
				tablero.repaint();
				
			}
		});
		timer.start();	
		
		timerJuego = new Timer(10, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mil++;
					if(mil >= 100) {
		                mil = 0;
		                segundos++;
		            }
		            actualizarTiempo();
				}
		});
		//timerJuego.start();	
	}
	
	private void actualizarTiempo() {

		String tiempoFormateado = String.format("%02d:%02d", segundos, mil);
	    tiempoLabel.setText(tiempoFormateado);
	}
	
	 class DrawingPanel extends JPanel {
	        public DrawingPanel() {
	            setBackground(Color.WHITE);
	        }
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            Graphics2D g2d = (Graphics2D) g;
	            
	            g2d.setColor(pacman.c);
	            g2d.fillOval(pacman.x, pacman.y, pacman.w, pacman.h);
	            
	            for(Player pared : paredes) {
	            	g2d.setColor(pared.c);
	            	g2d.fillRect(pared.x, pared.y, pared.w, pared.h);  	
	            }
	            
	        }
	    }
	 
	 private void moverPacman() {
			if(!enMovimiento) return;
			
			int nuevaX = pacman.x + (direccionX * velocidad);
		    int nuevaY = pacman.y + (direccionY * velocidad);
		    
		    //BORDES
		    if (nuevaX <= -pacman.w) nuevaX = tablero.getWidth();
		    else if (nuevaX >= tablero.getWidth()) nuevaX = -pacman.w;
		    
		    if (nuevaY <= -pacman.h) nuevaY = tablero.getHeight();
		    else if (nuevaY >= tablero.getHeight()) nuevaY = -pacman.h;
		    
		    //COLISIONES
		    Player tempPacman = new Player(nuevaX, nuevaY, pacman.w, pacman.h, pacman.c);
		    boolean puedeMoverse = true;
		    
		    for (Player pared : paredes) {
		        if (tempPacman.colision(pared)) {
		            puedeMoverse = false;
		            break;
		        }
		    }
		    
		    if (puedeMoverse) {
		        pacman.x = nuevaX;
		        pacman.y = nuevaY;
		    } else {
		        //SI HAY COLISION, SE DETIENE EL PACMAN
		        enMovimiento = false;
		        direccionX = 0;
		        direccionY = 0;
		    }
		}
	 
	 class Player{
		   
		   int x,y,w,h;
		   Color c;
		   
		   public Player(int x,int y,int w, int h, Color c) {
			   this.x = x;
			   this.y = y;
			   this.w = w;
			   this.h = h;
			   this.c = c;
		   }   
		    public boolean colision(Player target) {
		        return this.x < target.x + target.w &&
		               this.x + this.w > target.x &&
		               this.y < target.y + target.h &&
		               this.y + this.h > target.y;
		    }
		}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();

		if(!timerJuego.isRunning()) { 
			mil = 0;
	        segundos = 0;
	        timerJuego.start();   
	    }
		
		if(keyCode == KeyEvent.VK_W){ //ARRIBA
			direccionY =-1;
			direccionX = 0;
			enMovimiento = true;
		}else if(keyCode == KeyEvent.VK_S) { //ABAJO
			direccionY = 1;
			direccionX = 0;
			enMovimiento = true;
		}else if(keyCode == KeyEvent.VK_A) {// IZQUIERDA
			direccionX = -1;
			direccionY = 0;
			enMovimiento = true;
		}else if(keyCode == KeyEvent.VK_D) { //DERECHA
			direccionX = 1;
			direccionY = 0;
			enMovimiento = true;
		}
		
		tablero.repaint();

	}
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
