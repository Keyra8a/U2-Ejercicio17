package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;

public class Ventana2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 window = new Ventana2();
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
	public Ventana2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 0));
	
		frame.setBounds(100, 100, 741, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBorder(new LineBorder(new Color(0, 255, 0),20));;
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblRegistroUsuario = new JLabel("   Registro de Usuario");
		lblRegistroUsuario.setBounds(10, 10, 687, 25);
		lblRegistroUsuario.setBackground(new Color(255, 0, 0));
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblRegistroUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 45, 687, 536);
		
		panel_1.setBackground(new Color(0, 255, 0));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 10, 10));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 255, 128));
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblDatosGenerales = new JLabel("Datos Generales");
		lblDatosGenerales.setBounds(10, 10, 338, 17);
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblDatosGenerales);
		
		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(60, 54, 60, 17);
		panel_4.add(lblNombre);
		
		JLabel lblApePaterno = new JLabel("Apellido Paterno:");
		lblApePaterno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApePaterno.setBounds(60, 81, 101, 13);
		panel_4.add(lblApePaterno);
		
		JLabel lblApeMaterno = new JLabel("Apellido Materno:");
		lblApeMaterno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApeMaterno.setBounds(60, 110, 101, 13);
		panel_4.add(lblApeMaterno);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaNacimiento.setBounds(60, 139, 113, 13);
		panel_4.add(lblFechaNacimiento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(60, 181, 45, 13);
		panel_4.add(lblSexo);
		
		JLabel lblNacio = new JLabel("Nacionalidad:");
		lblNacio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNacio.setBounds(60, 222, 90, 13);
		panel_4.add(lblNacio);
		
		textField = new JTextField();
		textField.setBounds(183, 52, 96, 19);
		panel_4.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(183, 79, 96, 19);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(183, 108, 96, 19);
		panel_4.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(183, 137, 96, 19);
		panel_4.add(textField_3);
		
		JComboBox comboBoxNacio = new JComboBox();
		comboBoxNacio.setBounds(183, 219, 103, 21);
		panel_4.add(comboBoxNacio);
		
		JRadioButton rdbtnMascu = new JRadioButton("Masculino");
		rdbtnMascu.setBackground(new Color(128, 255, 128));
		rdbtnMascu.setBounds(176, 162, 103, 21);
		panel_4.add(rdbtnMascu);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBackground(new Color(128, 255, 128));
		rdbtnFemenino.setBounds(176, 192, 103, 21);
		panel_4.add(rdbtnFemenino);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 128, 128));
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblPerfilUsuario = new JLabel("Perfil Usuario");
		lblPerfilUsuario.setBounds(10, 10, 338, 17);
		lblPerfilUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblPerfilUsuario);
		
		JCheckBox chckbxMosFotoPerfil = new JCheckBox("Mostrar Foto de Perfil");
		chckbxMosFotoPerfil.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		chckbxMosFotoPerfil.setBackground(new Color(255, 128, 128));
		chckbxMosFotoPerfil.setBounds(88, 170, 191, 21);
		panel_5.add(chckbxMosFotoPerfil);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Mostrar Fecha de Nacimiento");
		chckbxNewCheckBox_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		chckbxNewCheckBox_1.setBackground(new Color(255, 128, 128));
		chckbxNewCheckBox_1.setBounds(88, 204, 231, 21);
		panel_5.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\usuario-femenino (3).png"));
		lblNewLabel.setBounds(99, 52, 123, 112);
		panel_5.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 128));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDatosOpcionales = new JLabel("Datos Opcionales");
		lblDatosOpcionales.setBounds(10, 10, 338, 17);
		lblDatosOpcionales.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblDatosOpcionales);
		
		JLabel lblDescrip = new JLabel("Descripción:");
		lblDescrip.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblDescrip.setBounds(40, 54, 82, 16);
		panel_3.add(lblDescrip);
		
		JLabel lblPreferencias = new JLabel("Preferencias");
		lblPreferencias.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblPreferencias.setBounds(180, 56, 92, 13);
		panel_3.add(lblPreferencias);
		//txtDescrip.setText("holaholaholaholaholahola /n hola /n j /n R /n E /n N /n E");
		//txtDescrip.setBounds(65, 93, 5, 22);
		//panel_3.add(txtDescrip);*/
		
		JScrollPane desplegar = new JScrollPane();
		desplegar.setBounds(40,80,117,149);
		desplegar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplegar.setHorizontalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		panel_3.add(desplegar);
		
		JTextArea txtDescrip = new JTextArea(5,20);
		desplegar.setViewportView(txtDescrip);
		
		JTextArea txtPrefe = new JTextArea(5,20);
		/*txtPrefe.setBounds(188, 81, 5, 22);
		panel_3.add(txtPrefe);*/
		
		JScrollPane desplegar2 = new JScrollPane(txtPrefe);
		desplegar2.setBounds(180,80,117,149);
		desplegar2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplegar2.setHorizontalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		panel_3.add(desplegar2);
		
		
		
		JPanel pnlBotones = new JPanel();
		pnlBotones.setBackground(new Color(128, 255, 128));
		panel_1.add(pnlBotones);
		pnlBotones.setLayout(null);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(new Color(0, 0, 0));
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\disco-flexible.png"));
		btnGuardar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnGuardar.setBounds(118, 111, 107, 33);
		pnlBotones.add(btnGuardar);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\eliminar.png"));
		btnNuevo.setBackground(Color.BLACK);
		btnNuevo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnNuevo.setBounds(117, 68, 108, 33);
		pnlBotones.add(btnNuevo);
		
		JButton ntnSalir = new JButton("SALIR");
		ntnSalir.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\salida.png"));
		ntnSalir.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		ntnSalir.setBackground(new Color(0, 0, 0));
		ntnSalir.setBounds(118, 156, 107, 33);
		pnlBotones.add(ntnSalir);
		
	}
}
