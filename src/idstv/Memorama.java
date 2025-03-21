package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class Memorama {

	private JFrame frame;
	public int cartas[] = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};
	public int c1 = -1, c2 = -1;
	public ArrayList<JButton> cartas2 = new ArrayList<JButton>();
	private int puntajeJugador1 = 0;
	private int puntajeJugador2 = 0;
	private boolean turnoJugador1 = true; 
	private JLabel lblTurno;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memorama window = new Memorama();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void revolverCartas() {
	    // Convertimos el arreglo a una lista, lo mezclamos y luego lo volvemos a convertir al arreglo
	    List<Integer> lista = Arrays.stream(cartas).boxed().collect(Collectors.toList());
	    Collections.shuffle(lista);
	    for (int i = 0; i < cartas.length; i++) {
	        cartas[i] = lista.get(i);
	    }
	}

	/*public void revolverCartas() {
	    // Convertir el arreglo de cartas en una lista para revolverlas
	    Collections.shuffle(Arrays.asList(cartas));
	}*/
	
	private boolean[] paresEncontrados = new boolean[cartas.length];


	/**
	 * Create the application.
	 */
	public Memorama() {
		revolverCartas();
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		revolverCartas();
		System.out.println("Cartas mezcladas: " + Arrays.toString(cartas));
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(74, 20, 140));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		JLabel lblTurno = new JLabel("Turno: Jugador 1");
		lblTurno.setForeground(Color.WHITE);
		lblTurno.setBounds(20, 10, 45, 13);
		lblTurno.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_1.add(lblTurno);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(74, 20, 140));
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(4, 4, 10, 10));
		
		for (int i = 0; i < cartas.length; i++) {
	        int valorCarta = cartas[i];

	        JButton boton = new JButton(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));

	        boton.addActionListener(e -> {
	        	
	        	boton.setIcon(new ImageIcon("C:\\Users\\keyra\\OneDrive\\Documents\\Programación lll\\LoginRegistro\\src\\kirby\\" + valorCarta + ".jpeg"));
	            cartas2.add(boton);
	            boton.setEnabled(false); // Deshabilitar el botón al ser clickeado
	            boton.setEnabled(true);

	            if (c1 == -1) {
	                c1 = valorCarta;
	            } else if (c2 == -1) {
	                c2 = valorCarta;

	                if (c1 == c2) {
	                    JOptionPane.showMessageDialog(null, "¡Es un par!", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	                    for (JButton btn : cartas2) {
	                        btn.setEnabled(false); 
	                    }

	                    // punto al jugador correspondiente
	                    if (turnoJugador1) {
	                        puntajeJugador1++;
	                    } else {
	                        puntajeJugador2++;
	                    }

	                    // Marcamos como encontrado el par
	                    for (int j = 0; j < cartas.length; j++) {
	                        if (cartas[j] == c1) {
	                            paresEncontrados[j] = true;
	                        }
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "No es un par", "Incorrecto", JOptionPane.ERROR_MESSAGE);
	                    Timer timer = new Timer(1000, e2 -> {
	                        for (int j = 0; j < cartas2.size(); j++) {
	                            JButton btn = cartas2.get(j);

	                            // Buscar el índice de la carta actual en el arreglo 'cartas'
	                            int index = -1;
	                            for (int x = 0; x < cartas.length; x++) {
	                                if (btn.getIcon().toString().contains(String.valueOf(cartas[x])) && !paresEncontrados[x]) {
	                                    index = x;
	                                    break;
	                                }
	                            }

	                            // Girar únicamente las cartas que no forman un par
	                            if (index != -1 && !paresEncontrados[index]) {
	                                btn.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
	                                btn.setEnabled(true);

	                            }
	                        }
	                        cartas2.clear();
	                    });
	                    timer.setRepeats(false);
	                    timer.start();

	                    // Alternar turno si no es un par
	                    turnoJugador1 = !turnoJugador1;
	                    lblTurno.setText(turnoJugador1 ? "Turno: Jugador 1" : "Turno: Jugador 2");

	                    // Refrescar el JLabel
	                    lblTurno.revalidate();
	                    lblTurno.repaint();
	                }

	                c1 = -1;
	                c2 = -1;
	                
                    boolean juegoTerminado = true;
                    for (boolean par : paresEncontrados) {
                        if (!par) {
                            juegoTerminado = false;
                            break;
                        }
                    }

                    if (juegoTerminado) {
                        String mensajeFinal = "¡Juego terminado!\n" +
                                "Jugador 1: " + puntajeJugador1 + " puntos\n" +
                                "Jugador 2: " + puntajeJugador2 + " puntos\n";
                        if (puntajeJugador1 > puntajeJugador2) {
                            mensajeFinal += "¡Jugador 1 gana!";
                        } else if (puntajeJugador2 > puntajeJugador1) {
                            mensajeFinal += "¡Jugador 2 gana!";
                        } else {
                            mensajeFinal += "¡Es un empate!";
                        }

                        JOptionPane.showMessageDialog(null, mensajeFinal, "Resultados", JOptionPane.INFORMATION_MESSAGE);
                    }
	            }
	           
	        });

	        panel_2.add(boton);
	    }
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(74, 20, 140));
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        revolverCartas();
		        System.out.println("Cartas mezcladas: " + Arrays.toString(cartas));

		        // Restablecer las variables de estado
		        c1 = -1;
		        c2 = -1;
		        cartas2.clear();
		        Arrays.fill(paresEncontrados, false); // Reiniciar el estado de los pares encontrados
				puntajeJugador1 = 0;
	            puntajeJugador2 = 0;
	            turnoJugador1 = true;
	            lblTurno.setText("Turno: Jugador 1");

		        for (Component comp : panel_2.getComponents()) {
		            if (comp instanceof JButton) {
		                JButton boton = (JButton) comp;
		                boton.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		                boton.setEnabled(true);
		                boton.removeActionListener(boton.getActionListeners()[0]); 
		            }
		        }

		        for (int i = 0; i < cartas.length; i++) {
		            int valorCarta = cartas[i];
		            JButton boton = (JButton) panel_2.getComponent(i);

		            boton.addActionListener(e2 -> {
		                boton.setIcon(new ImageIcon("C:\\Users\\keyra\\OneDrive\\Documents\\Programación lll\\LoginRegistro\\src\\kirby\\" + valorCarta + ".jpeg"));
		                cartas2.add(boton);
		                boton.setEnabled(false);
		                boton.setEnabled(true);

		                // Lógica de juego
		                if (c1 == -1) {
		                    c1 = valorCarta;
		                } else if (c2 == -1) {
		                    c2 = valorCarta;

		                    if (c1 == c2) {
		                        JOptionPane.showMessageDialog(null, "¡Es un par!", "Correcto", JOptionPane.INFORMATION_MESSAGE);
		                        for (JButton btnPar : cartas2) {
		                            btnPar.setEnabled(false);
		                        }
		                        for (int j = 0; j < cartas.length; j++) {
		                            if (cartas[j] == c1) {
		                                paresEncontrados[j] = true;
		                            }
		                        }
		                    } else {
		                        JOptionPane.showMessageDialog(null, "No es un par", "Incorrecto", JOptionPane.ERROR_MESSAGE);
		                        Timer timer = new Timer(1000, e3 -> {
		                            for (JButton btn : cartas2) {
		                                btn.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		                                btn.setEnabled(true);
		                            }
		                            cartas2.clear();
		                        });
		                        timer.setRepeats(false);
		                        timer.start();
		                    }
		                    c1 = -1;
		                    c2 = -1;
		                }
		                
		                
		                // Revisar si el juego ha terminado
		                boolean juegoTerminado = true;
		                for (boolean par : paresEncontrados) {
		                    if (!par) {
		                        juegoTerminado = false;
		                        break;
		                    }
		                }

		                if (juegoTerminado) {
		                    String mensajeFinal = "¡Juego terminado!\n"
		                        + "Jugador 1: " + puntajeJugador1 + " puntos\n"
		                        + "Jugador 2: " + puntajeJugador2 + " puntos\n";

		                    if (puntajeJugador1 > puntajeJugador2) {
		                        mensajeFinal += "¡Jugador 1 gana!";
		                    } else if (puntajeJugador2 > puntajeJugador1) {
		                        mensajeFinal += "¡Jugador 2 gana!";
		                    } else {
		                        mensajeFinal += "¡Es un empate!";
		                    }

		                    JOptionPane.showMessageDialog(null, mensajeFinal, "Resultados", JOptionPane.INFORMATION_MESSAGE);
		                }
		                
		            });  
		        }
			}
		});
		btnReiniciar.setBackground(new Color(186, 104, 200));
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_3.add(btnReiniciar);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(74, 20, 140));
		frame.getContentPane().add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new GridLayout(8, 1, 10, 10));
		
		JLabel lblM = new JLabel("M");
		lblM.setForeground(Color.white);
		lblM.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblM);
		
		JLabel lblE = new JLabel("E");
		lblE.setForeground(Color.white);
		lblE.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblE);
		
		JLabel lblM2 = new JLabel("M");
		lblM2.setForeground(Color.white);
		lblM2.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblM2);
		
		JLabel lblO = new JLabel("O");
		lblO.setForeground(Color.white);
		lblO.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblO);
		
		JLabel lblR = new JLabel("R");
		lblR.setForeground(Color.white);
		lblR.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblR);
		
		JLabel lblA2 = new JLabel("A");
		lblA2.setForeground(Color.white);
		lblA2.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblA2);
		
		JLabel lblM3 = new JLabel("M");
		lblM3.setForeground(Color.white);
		lblM3.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblM3);
		
		JLabel lblA = new JLabel("A\r\n");
		lblA.setForeground(Color.white);
		lblA.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblA);
		
		
	}
}
