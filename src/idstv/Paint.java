package idstv;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.ImageIcon;

public class Paint {

	private JFrame frame;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(207, 51, 539, 464);
		panel_1.add(panel);
		panel.setLayout(null);
		
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
		btnPincel.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\pincel-de-arte.png"));
		btnPincel.setBounds(10, 38, 37, 21);
		panel_2.add(btnPincel);
		
		JButton btnBorrador = new JButton("");
		btnBorrador.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\herramienta-de-borrador.png"));
		btnBorrador.setBounds(10, 69, 37, 21);
		panel_2.add(btnBorrador);
		
		JSlider slider = new JSlider();
		slider.setBounds(55, 96, 97, 13);
		panel_2.add(slider);
		
		JLabel lblPincel = new JLabel("Pincel");
		lblPincel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPincel.setBounds(57, 42, 45, 13);
		panel_2.add(lblPincel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Borrador");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(57, 73, 79, 13);
		panel_2.add(lblNewLabel_2_1);
		
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
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\forma-rectangular.png"));
		btnNewButton_1.setBounds(10, 152, 37, 21);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\circulo (1).png"));
		btnNewButton_2.setBounds(10, 183, 37, 21);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\variante-de-contorno-de-triangulo.png"));
		btnNewButton_3.setBounds(10, 214, 37, 21);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-de-linea.png"));
		btnNewButton_4.setBounds(10, 247, 37, 21);
		panel_2.add(btnNewButton_4);
		
		JLabel lblNewLabel_2_2 = new JLabel("Rectangulo");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(57, 156, 79, 13);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Círculo");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(57, 187, 45, 13);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Triángulo");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_4.setBounds(57, 218, 65, 13);
		panel_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Línea");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_5.setBounds(57, 251, 45, 13);
		panel_2.add(lblNewLabel_2_5);
		
		JLabel lblColores = new JLabel("Colores");
		lblColores.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblColores.setBounds(10, 278, 126, 21);
		panel_2.add(lblColores);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("----------------------------------");
		lblNewLabel_1_1_1.setBounds(10, 299, 142, 13);
		panel_2.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setBounds(10, 314, 37, 21);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setBounds(55, 314, 37, 21);
		panel_2.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setBounds(99, 314, 37, 21);
		panel_2.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("");
		btnNewButton_1_4.setBounds(10, 341, 37, 21);
		panel_2.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("");
		btnNewButton_1_5.setBounds(55, 341, 37, 21);
		panel_2.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_6 = new JButton("");
		btnNewButton_1_6.setBounds(99, 341, 37, 21);
		panel_2.add(btnNewButton_1_6);
		
		JButton btnNewButton_1_7 = new JButton("");
		btnNewButton_1_7.setBounds(99, 372, 37, 21);
		panel_2.add(btnNewButton_1_7);
		
		JButton btnNewButton_1_8 = new JButton("");
		btnNewButton_1_8.setBounds(57, 372, 37, 21);
		panel_2.add(btnNewButton_1_8);
		
		JButton btnNewButton_1_9 = new JButton("");
		btnNewButton_1_9.setBounds(10, 372, 37, 21);
		panel_2.add(btnNewButton_1_9);
		
		JButton btnNewButton_1_2_1 = new JButton("Limpiar lienzo");
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_2_1.setBounds(10, 417, 126, 21);
		panel_2.add(btnNewButton_1_2_1);
		//panel_1.setLayout(null);
	}
}
