package idstv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import idstv.Paint.DrawingPanel;

public class Pacman implements KeyListener {

	private JFrame frame;
	private DrawingPanel tablero;
	private int x = 200, y = 100;

	/**
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
				x = 200;
				y = 100;
				
				tablero.repaint();
				tablero.requestFocus();
				
			}
		});
		footer.add(reiniciar);
		//score jlabel
		//boton para reiniciar
		//boton reinicar
		//limites

		
	}
	
	 class DrawingPanel extends JPanel {
	        public DrawingPanel() {
	            setBackground(Color.WHITE);
	        }

	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            Graphics2D g2d = (Graphics2D) g;
	            
	            g2d.setColor(Color.yellow);
	            g2d.fillOval(x,y, 30, 30);
	            
	        }
	    }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(y);
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
		}
		tablero.repaint();

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
