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
import javax.swing.JPanel;
import javax.swing.Timer;

import idstv.Paint.DrawingPanel;

public class Pacman implements KeyListener {

	private JFrame frame;
	private DrawingPanel tablero;
	private int velocidad = 10;
	private Player pacman;
	private List<Player> paredes = new ArrayList<>();
	
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
				
				tablero.repaint();
				tablero.requestFocus();
				
			}
		});
		footer.add(reiniciar);
		//score jlabel
		//boton para reiniciar
		//boton reinicar
		//limites
		
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tablero.repaint();
				
			}
		});
		timer.start();	
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
		
		int nuevaX = pacman.x;
		int nuevaY = pacman.y;
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W: //ARRIBA
			nuevaY -= velocidad;
			if(nuevaY <= -30) {
				nuevaY = 460;
			}
			break;
		case KeyEvent.VK_S: // ABAJO
            nuevaY += velocidad;
            if(nuevaY >= 460) {
            	nuevaY = -30;
			}
            break;
        case KeyEvent.VK_A: // IZQUIERDA
            nuevaX -= velocidad;
            if(nuevaX <= -25){
            	nuevaX = 425;
			}
            break;
        case KeyEvent.VK_D: // DERECHA
            nuevaX += velocidad;
            if(nuevaX >= 445) {
            	nuevaX =-25;
			}
            break;
		}
		
		//VERIFICAR COLISION
		Boolean puedeMoverse = true;
		Player temp_pacman = new Player(nuevaX, nuevaY, pacman.w, pacman.h, pacman.c);
	
		for (Player pared : paredes) {
			if (temp_pacman.colision(pared)) {
				puedeMoverse = false;
				break;
			}
		}
		
		if (puedeMoverse) {
			pacman.x = nuevaX;
			pacman.y = nuevaY;
		}
		
       if (pacman.x <= -pacman.w) {
            pacman.x = tablero.getWidth();
        } else if (pacman.x >= tablero.getWidth()) {
            pacman.x = -pacman.w;
        }
        
        if (pacman.y <= -pacman.h) {
            pacman.y = tablero.getHeight();
        } else if (pacman.y >= tablero.getHeight()) {
            pacman.y = -pacman.h;
        }
        
		/*System.out.println(y);
		if(e.getKeyCode() == 87) {
			y-=5;
			//ARRIBA
			if(y <= -30) {
				y = 460;
			}
		}
		if(e.getKeyCode() == 83) {
			y+=5;
			//ABAJO
			if(y >= 460) {
				y = -30;
			}

		}
		if(e.getKeyCode() == 65) {
			x-=5;
			//LIMITE IZQUIERDA
			if(x <= -25){
				x = 425;
			}

		}
		if(e.getKeyCode() == 68) {
			x+=5;
			//LIMITE DE LA DERECHA
			if(x >= 445) {
				x =-25;
			}
		}*/
		tablero.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
