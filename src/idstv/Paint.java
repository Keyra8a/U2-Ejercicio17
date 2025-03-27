package idstv;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;

public class Paint<drawingPanel> implements MouseListener , MouseMotionListener {

	private JFrame frame;
	private DrawingPanel drawingPanel; 
	//variables para el color
	boolean pincelActivado = false;
    Color colorActual = Color.BLACK;
    int grosorActual = 3;
 	
 	private Point lastPoint;// Para almacenar la última posición del mouse
    // Para almacenar los puntos dibujados
 	private List<PuntoConColor> points = new ArrayList<>();
 	private List<List<PuntoConColor>> listaDePuntos = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint window = new Paint();
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
	public Paint() {
		initialize();
	}

	class PuntoConColor {
	    Point punto;
	    Color color;
	    int grosor;

	    public PuntoConColor(Point punto, Color color, int grosor) {
	        this.punto = punto;
	        this.color = color;
	        this.grosor = grosor;
	    }
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		//panel_1.setBorder(new LineBorder(new Color(0, 255, 0),100));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel pnlDibujo = new JPanel();
		pnlDibujo.setLayout(new BorderLayout()); // Cambia a BorderLayout
		drawingPanel = new DrawingPanel();
		pnlDibujo.add(drawingPanel, BorderLayout.CENTER); 
		pnlDibujo.setBounds(207, 51, 539, 464);
		panel_1.add(pnlDibujo);
		pnlDibujo.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 51, 162, 464);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Herramientas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 126, 13);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("---------------------------------");
		lblNewLabel_1.setBounds(10, 24, 142, 13);
		panel_2.add(lblNewLabel_1);
		
		JButton btnPincel = new JButton("");
		//para poder pintar en el lienzo
		btnPincel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pincelActivado = true;
		        System.out.println("Pincel activado");
			}
		});
		btnPincel.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\pincel-de-arte.png"));
		btnPincel.setBounds(10, 38, 37, 21);
		panel_2.add(btnPincel);
		
		JButton btnBorrador = new JButton("");
		btnBorrador.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\herramienta-de-borrador.png"));
		btnBorrador.setBounds(10, 69, 37, 21);
		panel_2.add(btnBorrador);
		
		JSlider sldGrosor = new JSlider();
		//para el grosor
		sldGrosor.setMinimum(1);
	    sldGrosor.setMaximum(20);
	    sldGrosor.setValue(grosorActual);
	    sldGrosor.addChangeListener(e -> {
	        grosorActual = sldGrosor.getValue();
	    });
		sldGrosor.setBounds(55, 96, 97, 13);
		panel_2.add(sldGrosor);
		
		JLabel lblPincel = new JLabel("Pincel");
		lblPincel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPincel.setBounds(57, 42, 45, 13);
		panel_2.add(lblPincel);
		
		JLabel lblBorrador = new JLabel("Borrador");
		lblBorrador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBorrador.setBounds(57, 73, 79, 13);
		panel_2.add(lblBorrador);
		
		JLabel lblNewLabel_3 = new JLabel("Grosor");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 95, 45, 13);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblOpGeometricas = new JLabel("Formas Geometricas");
		lblOpGeometricas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOpGeometricas.setBounds(10, 121, 152, 21);
		panel_2.add(lblOpGeometricas);
		
		JLabel lblNewLabel_1_1 = new JLabel("--------------------------------");
		lblNewLabel_1_1.setBounds(10, 139, 142, 13);
		panel_2.add(lblNewLabel_1_1);
		
		JButton btnRectangulo = new JButton("");
		btnRectangulo.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\forma-rectangular.png"));
		btnRectangulo.setBounds(10, 152, 37, 21);
		panel_2.add(btnRectangulo);
		
		JButton btnCIrculo = new JButton("");
		btnCIrculo.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\circulo (1).png"));
		btnCIrculo.setBounds(10, 183, 37, 21);
		panel_2.add(btnCIrculo);
		
		JButton btnTriangulo = new JButton("");
		btnTriangulo.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\variante-de-contorno-de-triangulo.png"));
		btnTriangulo.setBounds(10, 214, 37, 21);
		panel_2.add(btnTriangulo);
		
		JButton btnLinea = new JButton("");
		btnLinea.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-de-linea.png"));
		btnLinea.setBounds(10, 247, 37, 21);
		panel_2.add(btnLinea);
		
		JLabel lblRectangulo = new JLabel("Rectangulo");
		lblRectangulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRectangulo.setBounds(57, 156, 79, 13);
		panel_2.add(lblRectangulo);
		
		JLabel lblCirculo = new JLabel("Círculo");
		lblCirculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCirculo.setBounds(57, 187, 45, 13);
		panel_2.add(lblCirculo);
		
		JLabel lblTriangulo = new JLabel("Triángulo");
		lblTriangulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTriangulo.setBounds(57, 218, 65, 13);
		panel_2.add(lblTriangulo);
		
		JLabel lblLinea = new JLabel("Línea");
		lblLinea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLinea.setBounds(57, 251, 45, 13);
		panel_2.add(lblLinea);
		
		JLabel lblColores = new JLabel("Colores");
		lblColores.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblColores.setBounds(10, 278, 126, 21);
		panel_2.add(lblColores);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("----------------------------------");
		lblNewLabel_1_1_1.setBounds(10, 299, 142, 13);
		panel_2.add(lblNewLabel_1_1_1);
		
		JButton btnRojo = new JButton("");
		btnRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.RED;
			}
		});
		btnRojo.setBackground(new Color(255, 0, 0));
		btnRojo.setBounds(10, 314, 37, 21);
		panel_2.add(btnRojo);
		
		JButton btnBlanco = new JButton("");
		btnBlanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.WHITE;
			}
		});
		btnBlanco.setBackground(new Color(255, 255, 255));
		btnBlanco.setBounds(55, 314, 37, 21);
		panel_2.add(btnBlanco);
		
		JButton btnAzul = new JButton("");
		btnAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.BLUE;
			}
		});
		btnAzul.setBackground(new Color(0, 0, 205));
		btnAzul.setBounds(99, 314, 37, 21);
		panel_2.add(btnAzul);
		
		JButton btnAmarillo = new JButton("");
		btnAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.YELLOW;
			}
		});
		btnAmarillo.setBackground(new Color(255, 255, 0));
		btnAmarillo.setBounds(10, 341, 37, 21);
		panel_2.add(btnAmarillo);
		
		JButton btnNegro = new JButton("");
		btnNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.BLACK;
			}
		});
		btnNegro.setBackground(new Color(0, 0, 0));
		btnNegro.setBounds(55, 341, 37, 21);
		panel_2.add(btnNegro);
		
		JButton btnRosa = new JButton("");
		btnRosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.PINK;
			}
		});
		btnRosa.setBackground(new Color(255, 20, 147));
		btnRosa.setBounds(99, 341, 37, 21);
		panel_2.add(btnRosa);
		
		JButton btn = new JButton("");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn.setBounds(99, 372, 37, 21);
		panel_2.add(btn);
		
		JButton btnVerde = new JButton("");
		btnVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.GREEN;
			}
		});
		btnVerde.setBackground(new Color(0, 255, 0));
		btnVerde.setBounds(57, 372, 37, 21);
		panel_2.add(btnVerde);
		
		JButton btnMorado = new JButton("");
		btnMorado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = new Color(148, 0, 211);
			}
		});
		btnMorado.setBackground(new Color(148, 0, 211));
		btnMorado.setBounds(10, 372, 37, 21);
		panel_2.add(btnMorado);
		
		JButton btnLimpiarLienzo = new JButton("Limpiar lienzo");
		btnLimpiarLienzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDePuntos.clear();
		        drawingPanel.repaint();
			}
		});
		btnLimpiarLienzo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiarLienzo.setBounds(10, 417, 126, 21);
		panel_2.add(btnLimpiarLienzo);
		//panel_1.setLayout(null);
		
		drawingPanel = new DrawingPanel();
		drawingPanel.setBounds(0, 0, pnlDibujo.getWidth(), pnlDibujo.getHeight());
		pnlDibujo.add(drawingPanel);
		
        drawingPanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub 
        	}

        	@Override
        	public void mousePressed(MouseEvent e) {
        		
        		if (pincelActivado) {
                    lastPoint = e.getPoint();
                    points.add(new PuntoConColor(lastPoint, colorActual, grosorActual));
                }
            }

        	@Override
        	public void mouseReleased(MouseEvent e) {
        		// TODO Auto-generated method stub 
        		
        		if (!points.isEmpty()) {
        	        listaDePuntos.add(new ArrayList<>(points));
        	        points.clear();
        	    }
            }

        	@Override
        	public void mouseEntered(MouseEvent e) {
        		// TODO Auto-generated method stub 
        	}

        	@Override
        	public void mouseExited(MouseEvent e) {
        		// TODO Auto-generated method stub 
        	}
        });
      
        
        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent e) {
        		// TODO Auto-generated method stub
        		if (pincelActivado) {
                    Point newPoint = e.getPoint();
                    points.add(new PuntoConColor(newPoint, colorActual, grosorActual));
                    drawingPanel.repaint();
                    lastPoint = newPoint;
                }
            }
        });	
	}

	class DrawingPanel extends JPanel {
	    public DrawingPanel() {
	        setBackground(Color.WHITE);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	    	super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            // Dibujar todos los trazos guardados
            for (List<PuntoConColor> trazo : listaDePuntos) {
                if (trazo.size() > 1) {
                	// Usamos el color y grosor del primer punto del trazo
                    g2d.setColor(trazo.get(0).color);
                    g2d.setStroke(new BasicStroke(trazo.get(0).grosor));
                    
                    for (int i = 1; i < trazo.size(); i++) {
                        Point p1 = trazo.get(i-1).punto;
                        Point p2 = trazo.get(i).punto;
                        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
                    }
                }
            }
            
            // Dibujar el trazo actual
            if (points.size() > 1) {
                g2d.setColor(points.get(0).color);
                g2d.setStroke(new BasicStroke(points.get(0).grosor));
                
                for (int i = 1; i < points.size(); i++) {
                    Point p1 = points.get(i-1).punto;
                    Point p2 = points.get(i).punto;
                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
