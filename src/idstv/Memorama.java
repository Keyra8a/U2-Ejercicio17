package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Memorama {

	private JFrame frame;
	private JButton btn16;

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

	/**
	 * Create the application.
	 */
	public Memorama() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 192));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("PUNTAJE:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 45, 13);
		//lblNewLabel.setHorizontalAlignment(BorderLayout.NORTH);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(4, 4, 10, 10));
		
		JButton btn1 = new JButton("");
		btn1.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn9);
		
		JButton btn10 = new JButton("");
		btn10.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn10);
		
		JButton btn11 = new JButton("");
		btn11.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn11);
		
		JButton btn12 = new JButton("");
		btn12.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn12);
		
		JButton btn13 = new JButton("");
		btn13.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn13);
		
		JButton btn14 = new JButton("");
		btn14.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn14);
		
		JButton btn15 = new JButton("");
		btn15.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn15);
		
		btn16 = new JButton("");
		btn16.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn16);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 192));
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("REINICIAR");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_3.add(btnNewButton);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 255, 0));
		frame.getContentPane().add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new GridLayout(8, 1, 10, 10));
		
		JLabel lblNewLabel_2 = new JLabel("M");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 70));
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("E");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 70));
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("M");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 70));
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("O");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 71));
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("R");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 70));
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("A");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 70));
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("M");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 70));
		panel_4.add(lblNewLabel_8);
		
		JLabel lblA = new JLabel("A\r\n");
		lblA.setFont(new Font("Times New Roman", Font.BOLD, 70));
		panel_4.add(lblA);
		
		
		/*JLabel lblNewLabel1 = new JLabel("New label");
		lblNewLabel1.setBounds(0, 0, 45, 13);
		panel_1.add(lblNewLabel1);*/
		
	}
}
