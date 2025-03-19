package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana3 {

	private JFrame frame;
	private JTextField txtNumTelCorreo;
	private JTextField txtCampo1;
	private JTextField txtCampo2;
	private JTextField txtCampo3;
	private JTextField txtCampo4;
	private JTextField txtCampo5;
	private JTextField txtCampo6;
	private JTextField txtNewContra;
	private JTextField txtConfirmarContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana3 window = new Ventana3();
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
	public Ventana3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 192));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCrearUsuario = new JLabel("Recuperación de cuenta");
		lblCrearUsuario.setBounds(310, 48, 335, 35);
		lblCrearUsuario.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblCrearUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(218, 134, 548, 501);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNomUsuario = new JLabel("Nombre del usuario:");
		lblNomUsuario.setOpaque(true);
		//lblNomUsuario.setBackground(new Color(255, 255, 255));
		lblNomUsuario.setSize(350,30);//tamaño de email
		lblNomUsuario.setLocation(93,33);
		lblNomUsuario.setHorizontalAlignment(JLabel.CENTER);
		lblNomUsuario.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(lblNomUsuario);
		
		JTextField txtNomUsuario = new JTextField();
		txtNomUsuario.setSize(350,30); //tamaño del recuadro
		txtNomUsuario.setLocation(93,73);
		txtNomUsuario.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(txtNomUsuario);
		
		JLabel lblBio = new JLabel("B I O");
		lblBio.setSize(348,30);
		lblBio.setLocation(93,113);
		lblBio.setHorizontalAlignment(JLabel.CENTER);
		lblBio.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(lblBio);
		lblBio.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		JTextArea txtAreaBio = new JTextArea("");
		txtAreaBio.setSize(350,80);
		txtAreaBio.setLocation(93,153);
		txtAreaBio.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(txtAreaBio);
		
		JLabel lblPreferencias = new JLabel("PREFERENCIAS");
		lblPreferencias.setSize(200,30);
		lblPreferencias.setLocation(179,243);
		lblBio.setHorizontalAlignment(JLabel.CENTER);
		lblPreferencias.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(lblPreferencias);
		
		JCheckBox checkDulce = new JCheckBox("Dulce");
		checkDulce.setSize(100,30);
		checkDulce.setLocation(93,279);
		checkDulce.setOpaque(false);
		lblBio.setHorizontalAlignment(JLabel.CENTER);
		checkDulce.setFont(new Font("American TYpewrite", Font.BOLD, 15));
		panel_1.add(checkDulce);

		
		//checkDulce.setBorder(BorderFactory.createLineBorder(Color.BLACK,8));
		
		JCheckBox checkSalado = new JCheckBox("Salado");
		checkSalado.setSize(110,30);
		checkSalado.setLocation(211,279);
		checkSalado.setOpaque(false);
		checkSalado.setFont(new Font("American TYpewrite", Font.BOLD, 15));
		panel_1.add(checkSalado);
		
		JCheckBox checkSaludable = new JCheckBox("Saludable");
		checkSaludable.setSize(140,30);
		checkSaludable.setLocation(323,279);
		checkSaludable.setOpaque(false);
		checkSaludable.setFont(new Font("American TYpewrite", Font.BOLD, 15));
		panel_1.add(checkSaludable);
		
		JLabel lblTerminos = new JLabel("TERMINOS");
		lblTerminos.setOpaque(true);
		lblTerminos.setBackground(Color.decode("#ffe5dd"));
		lblTerminos.setSize(350,30);
		lblTerminos.setLocation(103,315);
		lblTerminos.setHorizontalAlignment(JLabel.CENTER);
		lblTerminos.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(lblTerminos);
		
		
		JRadioButton jrbAcepTerm = new JRadioButton("Acepto los terminos");
		jrbAcepTerm.setSize(200,40);
		jrbAcepTerm.setLocation(93,351);
		jrbAcepTerm.setOpaque(false);
		panel_1.add(jrbAcepTerm);
		
		JRadioButton jrbNoAcepTerm = new JRadioButton("No acepto los terminos", true);
		jrbNoAcepTerm.setSize(200,40);
		jrbNoAcepTerm.setLocation(263,351);
		jrbNoAcepTerm.setOpaque(false);
		panel_1.add(jrbNoAcepTerm);
		
		ButtonGroup termsGrupo = new ButtonGroup();
		termsGrupo.add(jrbNoAcepTerm);
		termsGrupo.add(jrbAcepTerm);
		
		/*String dataset []= {"Camino Real", "Pedrenal", "Olas altas", "Santa Fe"};
		JComboBox colonias = new JComboBox();
		colonias.setSize(350,40);
		colonias.setLocation(70,500);
		colonias.setOpaque(true);
		panel.add(colonias);*/
		
		Button btnCrearCuenta = new Button("Crear Cuenta");
		btnCrearCuenta.setSize(350,40); //tamaño
		btnCrearCuenta.setLocation(93,413);
		//btnCrearCuenta.setOpaque(true);
		btnCrearCuenta.setBackground(Color.decode("#ffe5dd"));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btnCrearCuenta.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(btnCrearCuenta);
	
		btnCrearCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtNomUsuario.getText().equals("")) {
					txtNomUsuario.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					txtNomUsuario.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
				if(txtAreaBio.getText().equals("")) {
					txtAreaBio.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					txtAreaBio.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
			}
		});
		panel_1.add(btnCrearCuenta);
		
		/*Button btnIrAlLogin = new Button("Ir al Login");
		btnIrAlLogin.setSize(350,40); //tamaño
		btnIrAlLogin.setLocation(70,650);
		//btnCrearCuenta.setOpaque(true);
		btnIrAlLogin.setBackground(Color.decode("#ffe5dd"));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btnIrAlLogin.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnIrAlLogin);
		
		btnIrAlLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});*/
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.decode("#bd9892"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//router("login");
				
			}
		});
	}
}
