package idstv;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	public Ventana() {
		this.setTitle("");//para el titulo de la ventana
		this.setVisible(true);
		this.setSize(1000,700);
		
		//cambiar el icono a la ventana
		ImageIcon img = new ImageIcon("src/api.png");
		Image imagen = img.getImage();
		setIconImage(imagen);
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para cerrar todas las ventanas/dejar de correr el programa
		
//		this.setLayout(new BorderLayout());
		//this.setResizable(true);//para cambiar el tamaño de la ventana
		this.setMaximumSize(new Dimension(1000,1000));
		this.setMinimumSize(new Dimension(390,400));
		
		//this.add(this.interfaz());
		this.add(this.memorama());
		//this.add(this.calculadora2());
		//this.add(this.tabla2());
		//this.add(this.login());
//		this.add(this.registro(), BorderLayout.EAST);
		//this.add(this.imagen());
		//this.add(this.calculadora2());
		
		//barra
		JMenuBar barra = new JMenuBar();
		JMenu cuenta = new JMenu("Cuenta");
		barra.add(cuenta);
		
		//MENU CUENTA
		JMenuItem login = new JMenuItem("Login");
		cuenta.add(login);
		
		JMenuItem registro = new JMenuItem("Registro");
		cuenta.add(registro);
		
		JMenuItem recuperacion = new JMenuItem("Recuperacion de cuenta");
		cuenta.add(recuperacion);
		
		registro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				router("register");
			}
		});
	
		login.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		
		recuperacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("recuperacion");
				
			}
		});
		
		//MENU USUARIOS
		JMenu usarios = new JMenu("Usuarios");
		barra.add(usarios);
		
		JMenuItem alta = new JMenuItem("Alta");
		usarios.add(alta);
		
		JMenuItem baja  = new JMenuItem("Baja");
		usarios.add(baja);
		
		JMenuItem consulta = new JMenuItem("Consulta");
		usarios.add(consulta);
		
		alta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("alta");
				
			}
		});		
		
		baja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("baja");
				
			}
		});
		
		consulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("consulta");
				
			}
		});
		
		//AYUDA
		JMenu ayuda = new JMenu("Ayuda");
		barra.add(ayuda);
		
		JMenuItem op1 = new JMenuItem("¿Cómo crear un usuario?");
		ayuda.add(op1);
		
		JMenuItem op2 = new JMenuItem("¿Cómo acceder al sistema?");
		ayuda.add(op2);
		
		JMenuItem op3 = new JMenuItem("¿Qé pasa si olvidé mi contraseña?");
		ayuda.add(op3);
		
		op1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("op1");
				
			}
		});
		
		op2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("op2");
				
			}
		});
		
		op3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				router("op3");
				
			}
		});
		
		
		
		this.setJMenuBar(barra);
		
		this.repaint();
		this.setVisible(true);
	}
	 //PARA LA SECCIÓN DE CUENTA
	public JPanel login()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		panel.setPreferredSize(new Dimension(500,1000));
		
		JLabel lblIniciarSesion = new JLabel("INICIAR SESIÓN");
		lblIniciarSesion.setSize(600,40); //tamaño
		lblIniciarSesion.setForeground(Color.WHITE);
		//lblBienvenido.setOpaque(true);
		//lblBienvenido.setBackground((Color.decode("#bd9892")));
		lblIniciarSesion.setLocation(200,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblIniciarSesion.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblIniciarSesion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblIniciarSesion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(187, 222, 251));
		panel_1.setBounds(229, 150, 540, 480);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmail = new JLabel("Ingrese su email:");
		lblEmail.setSize(200,54);//tamaño de email
		lblEmail.setLocation(106,72);
		lblEmail.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setSize(350,30); //tamaño del recuadro
		txtEmail.setLocation(106,136);
		txtEmail.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(txtEmail);	
		
		JLabel lblContra = new JLabel("Ingrese su contraseña:");
		lblContra.setSize(250,30);
		lblContra.setLocation(106,201);
		lblContra.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(lblContra);
		
		JPasswordField txtcontra = new JPasswordField();
		txtcontra.setSize(350,30); //tamaño del recuadro
		txtcontra.setLocation(106,255);
		txtcontra.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel_1.add(txtcontra);
		
		Checkbox cheRecordarme = new Checkbox("Recordarme");
		cheRecordarme.setSize(100,23);
		cheRecordarme.setLocation(116,287);
		cheRecordarme.setFont(new Font("American TYpewrite", Font.BOLD, 10));
		panel_1.add(cheRecordarme);
		
		
		JLabel lblOlvContra = new JLabel("¿Olvido su contraseña?");
		lblOlvContra.setSize(132,23);
		lblOlvContra.setLocation(335,287);
		lblOlvContra.setFont(new Font("American TYpewrite", Font.BOLD, 10));
		panel_1.add(lblOlvContra);
		
		JButton olvidoContra = new JButton("");
		olvidoContra.setSize(15,15);
		olvidoContra.setLocation(315,290);
		olvidoContra.setFont(new Font("American TYpewrite", Font.BOLD, 10));
		panel_1.add(olvidoContra);
		
		olvidoContra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("recuperacion");
				
			}
		});
		
		
		Button btnAcceder = new Button("ACCEDER");
		btnAcceder.setActionCommand("");
		btnAcceder .setSize(350,40); //tamaño
		btnAcceder .setLocation(106,358);
		btnAcceder.setForeground(Color.WHITE);
		btnAcceder.setBackground((Color.decode("#0d47a1")));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btnAcceder .setFont(new Font("American TYpewrite", Font.BOLD, 20));
		
		btnAcceder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean flag1 = false, flag2 = false;
				
				if(txtEmail.getText().equals("")) {
					txtEmail.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					txtEmail.setBorder(BorderFactory.createLineBorder(Color.green,3));
					flag1=true;
				}
				
				String password = new String(txtcontra.getPassword());
				if(password.equals("")) {
					txtcontra.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					txtcontra.setBorder(BorderFactory.createLineBorder(Color.green,3));
					flag2=true;
				}
				
				if(flag1 && flag2) {
					if(txtEmail.getText().equals("keyraochoa321@gmail.com")) {
						if(password.equals("keyrita")){
							JOptionPane.showMessageDialog(null, "Hola","Error",JOptionPane.WARNING_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Error","Error",JOptionPane.ERROR_MESSAGE);
						}
						
					}
				}
					
			}
		});
		panel_1.add(btnAcceder );
		btnAcceder.setBackground((Color.decode("#0d47a1")));
		
		/*JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.decode("#0d47a1"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		*/
		return panel;
	}
	
	public JPanel registro() {
		
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		panel.setPreferredSize(new Dimension(500,1000));
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setSize(570,40); //tamaño
		lblRegistro.setForeground(Color.WHITE);
		//lblRegistro.setOpaque(true);
		//lblRegistro.setBackground(Color.decode("#ffe5dd"));
		lblRegistro.setLocation(200,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblRegistro.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblRegistro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblRegistro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(187, 222, 251));
		panel_1.setBounds(218, 134, 548, 501);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNomUsuario = new JLabel("Nombre del usuario:");
		lblNomUsuario.setOpaque(true);
		lblNomUsuario.setBackground(Color.decode("#0d47a1"));
		lblNomUsuario.setSize(350,30);//tamaño de email
		lblNomUsuario.setForeground(Color.WHITE);
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
		lblTerminos.setForeground(Color.WHITE);
		lblTerminos.setBackground(Color.decode("#0d47a1"));
		lblTerminos.setSize(348,30);
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
		btnCrearCuenta.setSize(348,40); //tamaño
		btnCrearCuenta.setLocation(100,413);
		//btnCrearCuenta.setOpaque(true);
		btnCrearCuenta.setForeground(Color.WHITE);
		btnCrearCuenta.setBackground(Color.decode("#0d47a1"));
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
		btnRegresar.setBackground(Color.decode("#0d47a1"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		
		
		
		return panel;
	}
	
	public void router(String route) {
		this.getContentPane().removeAll();
		
		if(route.equals("register")){
			this.add(this.registro());
		}
		if(route.equals("login")){
			this.add(this.login());
		}
		if(route.equals("recuperacion")){
			this.add(this.recuperacionCuenta());
		}
		if(route.equals("alta")){
			this.add(this.alta());
		}
		if(route.equals("baja")){
			this.add(this.baja());
		}
		if(route.equals("consulta")){
			this.add(this.consultar());
		}
		if(route.equals("op1")){
			this.add(this.op1());
		}
		if(route.equals("op2")){
			this.add(this.op2());
		}
		if(route.equals("op3")){
			this.add(this.op3());
		}
		
		this.repaint();
	}

	public JPanel recuperacionCuenta() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblRecuperacionCuenta = new JLabel("RECUPERACIÓN DE CUENTA");
		lblRecuperacionCuenta.setSize(590,40); //tamaño
		lblRecuperacionCuenta.setForeground(Color.WHITE);
		/*lblRecuperacionCuenta.setOpaque(true);
		lblRecuperacionCuenta.setBackground((Color.decode("#bd9892")));*/
		lblRecuperacionCuenta.setLocation(200,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblRecuperacionCuenta.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblRecuperacionCuenta.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblRecuperacionCuenta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(187, 222, 251));
		panel_1.setBounds(122, 130, 742, 120);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNombreCorreo = new JLabel("Ingresa tu numero de telefono o correo electronico");
		lblNombreCorreo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNombreCorreo.setBounds(35, 23, 332, 13);
		panel_1.add(lblNombreCorreo);
		
		JTextField txtNumTelCorreo = new JTextField();
		txtNumTelCorreo.setBounds(45, 46, 590, 26);
		panel_1.add(txtNumTelCorreo);
		txtNumTelCorreo.setColumns(10);
		
		JButton btnNewButton = new JButton("Envíar código");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode("#0d47a1"));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnNewButton.setBounds(55, 82, 142, 28);
		panel_1.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Código enviado","Código",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(187, 222, 251));
		panel_2.setBounds(122, 260, 742, 120);
		panel.add(panel_2);
		
		JLabel lblIngresarElCdigo = new JLabel("Ingresar el código de verificacion");
		lblIngresarElCdigo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblIngresarElCdigo.setBounds(35, 23, 332, 13);
		panel_2.add(lblIngresarElCdigo);
		
		JTextField txtCampo1 = new JTextField();
		txtCampo1.setColumns(10);
		txtCampo1.setBounds(65, 46, 37, 26);
		panel_2.add(txtCampo1);
		
		JButton btnVerificarCdigo = new JButton("Verificar código");
		btnVerificarCdigo.setForeground(Color.WHITE);
		btnVerificarCdigo.setBackground(Color.decode("#0d47a1"));
		btnVerificarCdigo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnVerificarCdigo.setBounds(55, 82, 142, 28);
		panel_2.add(btnVerificarCdigo);
		
		btnVerificarCdigo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Código verificado","Código",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		
		JTextField txtCampo2 = new JTextField();
		txtCampo2.setColumns(10);
		txtCampo2.setBounds(112, 46, 37, 26);
		panel_2.add(txtCampo2);
		
		JTextField txtCampo3 = new JTextField();
		txtCampo3.setColumns(10);
		txtCampo3.setBounds(160, 46, 37, 26);
		panel_2.add(txtCampo3);
		
		JTextField txtCampo4 = new JTextField();
		txtCampo4.setColumns(10);
		txtCampo4.setBounds(207, 46, 37, 26);
		panel_2.add(txtCampo4);
		
		JTextField txtCampo5 = new JTextField();
		txtCampo5.setColumns(10);
		txtCampo5.setBounds(254, 46, 37, 26);
		panel_2.add(txtCampo5);
		
		JTextField txtCampo6 = new JTextField();
		txtCampo6.setColumns(10);
		txtCampo6.setBounds(301, 46, 37, 26);
		panel_2.add(txtCampo6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(187, 222, 251));
		panel_3.setBounds(122, 390, 742, 250);
		panel.add(panel_3);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contraseña");
		lblNuevaContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNuevaContrasea.setBounds(35, 23, 332, 13);
		panel_3.add(lblNuevaContrasea);
		
		JTextField txtNewContra = new JTextField();
		txtNewContra.setColumns(10);
		txtNewContra.setBounds(45, 44, 590, 28);
		panel_3.add(txtNewContra);
		
		JButton btnRestablecerContrasea = new JButton("Restablecer contraseña");
		btnRestablecerContrasea.setForeground(Color.WHITE);
		btnRestablecerContrasea.setBackground(Color.decode("#0d47a1"));
		btnRestablecerContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnRestablecerContrasea.setBounds(44, 156, 179, 28);
		panel_3.add(btnRestablecerContrasea);
		
		btnRestablecerContrasea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(
					    null, 
					    "Restablecer contraseña", 
					    "", 
					    JOptionPane.YES_NO_OPTION
					);

					if (option == JOptionPane.YES_OPTION) {
					    JOptionPane.showMessageDialog(
					        null, 
					        "Tu contraseña a sido actualizada con exito!!", 
					        "Confirmar contraseña", 
					        JOptionPane.INFORMATION_MESSAGE
					    );
					} else if (option == JOptionPane.NO_OPTION) {
					    // Salir o no hacer nada
					    System.out.println("Operación cancelada."); 
					}
					
			}
		});
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contraseña");
		lblConfirmarContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblConfirmarContrasea.setBounds(35, 82, 332, 13);
		panel_3.add(lblConfirmarContrasea);
		
		JTextField txtConfirmarContra = new JTextField();
		txtConfirmarContra.setColumns(10);
		txtConfirmarContra.setBounds(45, 105, 590, 28);
		panel_3.add(txtConfirmarContra);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesión");
		btnIniciarSesin.setBackground(Color.decode("#0d47a1"));
		btnIniciarSesin.setForeground(Color.WHITE);
		btnIniciarSesin.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnIniciarSesin.setBounds(297, 187, 142, 28);
		panel_3.add(btnIniciarSesin);
		
		
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.decode("#0d47a1"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		
		return panel;
	}
	
	//PARA LA SECCIÓN DE USUARIOS
	public JPanel alta() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,700);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		/*JLabel lblAlta = new JLabel("ALTA");
		lblAlta.setSize(600,40); //tamaño
		lblAlta.setOpaque(true);
		lblAlta.setBackground((Color.decode("#bd9892")));
		lblAlta.setLocation(200,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblAlta.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblAlta.setFont(new Font("American TYpewrite", Font.BOLD, 30));
		panel.add(lblAlta);*/
		
		JLabel lblAltaUsuario = new JLabel("ALTA DE USUARIOS");
		lblAltaUsuario.setForeground(Color.WHITE);
		lblAltaUsuario.setBounds(330, 49, 314, 35);
		lblAltaUsuario.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblAltaUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(187, 222, 251));
		panel_1.setBounds(56, 144, 885, 450);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFormularioRegistro = new JLabel("Formulario de Registro");
		lblFormularioRegistro.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 24));
		lblFormularioRegistro.setBackground(new Color(255, 255, 255));
		lblFormularioRegistro.setForeground(new Color(0, 0, 0));
		lblFormularioRegistro.setBounds(33, 29, 576, 22);
		panel_1.add(lblFormularioRegistro);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
		lblNombreCompleto.setForeground(Color.BLACK);
		lblNombreCompleto.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNombreCompleto.setBackground(Color.WHITE);
		lblNombreCompleto.setBounds(33, 101, 576, 22);
		panel_1.add(lblNombreCompleto);
		
		JLabel lblCorreo = new JLabel("Correo Electrónico:");
		lblCorreo.setForeground(Color.BLACK);
		lblCorreo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblCorreo.setBackground(Color.WHITE);
		lblCorreo.setBounds(33, 153, 576, 22);
		panel_1.add(lblCorreo);
		
		JLabel lblNumTelefono = new JLabel("Numero de teléfono:");
		lblNumTelefono.setForeground(Color.BLACK);
		lblNumTelefono.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNumTelefono.setBackground(Color.WHITE);
		lblNumTelefono.setBounds(33, 211, 576, 22);
		panel_1.add(lblNumTelefono);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(Color.BLACK);
		lblContraseña.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblContraseña.setBackground(Color.WHITE);
		lblContraseña.setBounds(33, 265, 576, 22);
		panel_1.add(lblContraseña);
		
		JTextField txtNomUsuario = new JTextField();
		txtNomUsuario.setBounds(196, 96, 616, 37);
		panel_1.add(txtNomUsuario);
		txtNomUsuario.setColumns(10);
		
		JTextField txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(196, 148, 616, 37);
		panel_1.add(txtCorreo);
		
		JTextField txtNumTel = new JTextField();
		txtNumTel.setColumns(10);
		txtNumTel.setBounds(196, 206, 616, 37);
		panel_1.add(txtNumTel);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBackground(Color.decode("#0d47a1"));
		btnCrearUsuario.setForeground(Color.WHITE);
		btnCrearUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnCrearUsuario.setBounds(346, 323, 192, 45);
		panel_1.add(btnCrearUsuario);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(196, 260, 616, 37);
		panel_1.add(passwordField);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.decode("#0d47a1"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		
		return panel;
	}
	
	public JPanel baja() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,700);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblBaja = new JLabel("BAJA DE USUARIOS");
		lblBaja .setSize(600,40); //tamaño
		//lblBaja .setOpaque(true);
		//lblBaja .setBackground((Color.decode("#bd9892")));
		lblBaja.setForeground(Color.WHITE);
		lblBaja .setLocation(200,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblBaja .setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblBaja .setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblBaja );
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(187, 222, 251));
		panel_1.setBounds(20, 144, 944, 494);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblListaUsuarios = new JLabel("Lista de usuarios");
		lblListaUsuarios.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 24));
		lblListaUsuarios.setBackground(new Color(255, 255, 255));
		lblListaUsuarios.setForeground(new Color(0, 0, 0));
		lblListaUsuarios.setBounds(53, 28, 268, 22);
		panel_1.add(lblListaUsuarios);
		
        String titles []= {"No.Control", "Nombres", "Apellidos", "Correo Electronico"};
		
		String data [][]  = {
				{"20238029", "Luis Angel", "Lucero Torres", "luisLu23@aluabcs.mx"},
				{"20238130", "Minerva", "Bojorquez Hernandez", "mineBojo23@aluabcs.mx"},
				{"20238230", "Ana Jetzahi", "Bernal Ochoa", "anaochoa@aluabcs.mx"},
				{"20238332", "Heriberto", "Lopez Ochoa", "herilopez@aluabcs.mx"},
				{"20238029", "Luis Angel", "Lucero Torres", "luisLu23@aluabcs.mx"},
				{"20238130", "Minerva", "Bojorquez Hernandez", "mineBojo23@aluabcs.mx"},
				{"20238230", "Ana Jetzahi", "Bernal Ochoa", "anaochoa@aluabcs.mx"},
				{"20238332", "Heriberto", "Lopez Ochoa", "herilopez@aluabcs.mx"},
				{"20238029", "Luis Angel", "Lucero Torres", "luisLu23@aluabcs.mx"},
				{"20238130", "Minerva", "Bojorquez Hernandez", "mineBojo23@aluabcs.mx"},
				{"20238230", "Ana Jetzahi", "Bernal Ochoa", "anaochoa@aluabcs.mx"},
				{"20238332", "Heriberto", "Lopez Ochoa", "herilopez@aluabcs.mx"},
				{"20238029", "Luis Angel", "Lucero Torres", "luisLu23@aluabcs.mx"},
				{"20238130", "Minerva", "Bojorquez Hernandez", "mineBojo23@aluabcs.mx"},
				{"20238230", "Ana Jetzahi", "Bernal Ochoa", "anaochoa@aluabcs.mx"},
				{"20238332", "Heriberto", "Lopez Ochoa", "herilopez@aluabcs.mx"},
				{"20238029", "Luis Angel", "Lucero Torres", "luisLu23@aluabcs.mx"},
				{"20238130", "Minerva", "Bojorquez Hernandez", "mineBojo23@aluabcs.mx"},
				{"20238230", "Ana Jetzahi", "Bernal Ochoa", "anaochoa@aluabcs.mx"},
				{"20238332", "Heriberto", "Lopez Ochoa", "herilopez@aluabcs.mx"},
				{"20238029", "Luis Angel", "Lucero Torres", "luisLu23@aluabcs.mx"},
				{"20238130", "Minerva", "Bojorquez Hernandez", "mineBojo23@aluabcs.mx"},
				{"20238230", "Ana Jetzahi", "Bernal Ochoa", "anaochoa@aluabcs.mx"},
				{"20238332", "Heriberto", "Lopez Ochoa", "herilopez@aluabcs.mx"},
			
			
		};
		
		JScrollPane desplegar = new JScrollPane();
		desplegar.setBounds(53, 121, 850, 300);
		//desplegar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(desplegar);
		
		JTable tabla = new JTable (data,titles);
		desplegar.setViewportView(tabla);
		
		JTextField txtBuscarUsuarios = new JTextField();
		txtBuscarUsuarios.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
		txtBuscarUsuarios.setForeground(new Color(192, 192, 192));
		txtBuscarUsuarios.setBackground(new Color(255, 255, 255));
		txtBuscarUsuarios.setText("BUSCAR USUARIOS");
		txtBuscarUsuarios.setBounds(51, 74, 811, 32);
		panel_1.add(txtBuscarUsuarios);
		txtBuscarUsuarios.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\lupa.png"));
		lblNewLabel.setBounds(864, 79, 24, 22);
		panel_1.add(lblNewLabel);
		
		JButton btnEliminar = new JButton("ELIMINAR USUARIO");
		btnEliminar.setBackground(Color.decode("#0d47a1"));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnEliminar.setBounds(715, 431, 188, 38);
		panel_1.add(btnEliminar);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.decode("#0d47a1"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		
		
		
		return panel;
	}
	
	
	public JPanel consultar()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblBienvenido = new JLabel("CONSULTAR USUARIOS");
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setSize(600,40); //tamaño
		//lblBienvenido.setOpaque(true);
		//lblBienvenido.setBackground((Color.decode("#bd9892")));
		lblBienvenido.setLocation(200,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblBienvenido.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblBienvenido.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblBienvenido);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setSize(230,60); //tamaño
		lblUsuario.setOpaque(true);
		lblUsuario.setBackground(Color.black );
		lblUsuario.setLocation(60,130);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblUsuario.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblUsuario.setFont(new Font("American TYpewrite", Font.BOLD, 30));
		lblUsuario.setForeground(Color.WHITE);
		panel.add(lblUsuario);
		
		JLabel lblNumUsuario = new JLabel("42");
		lblNumUsuario.setSize(230,60); //tamaño
		lblNumUsuario.setOpaque(true);
		lblNumUsuario.setBackground(Color.black );
		lblNumUsuario.setLocation(60,190);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblNumUsuario.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblNumUsuario.setFont(new Font("American TYpewrite", Font.BOLD, 30));
		lblNumUsuario.setForeground(Color.WHITE);
		panel.add(lblNumUsuario);
		
		Button btnDescargar = new Button("Descargar");
		btnDescargar.setSize(80,30); //tamaño
		btnDescargar.setLocation(740,230);
		//btnCrearCuenta.setOpaque(true);
		btnDescargar.setBackground(new Color(187, 222, 251));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btnDescargar.setForeground(Color.BLACK);
		btnDescargar.setFont(new Font("American TYpewrite", Font.BOLD, 12));
		panel.add(btnDescargar);
		
		Button btnAñadir = new Button("Añadir");
		btnAñadir.setSize(80,30); //tamaño
		btnAñadir.setLocation(830,230);
		//btnCrearCuenta.setOpaque(true);
		btnAñadir.setForeground(Color.black);
		btnAñadir.setBackground(new Color(187, 222, 251));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btnAñadir.setFont(new Font("American TYpewrite", Font.BOLD, 15));
		panel.add(btnAñadir);
		
		
		
		
		String titles []= {"Nombre", "Apellido", "Año", "pizza?"};
		
		String data [][]  = {
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
				{"Name", "lastname", "age", "pizza?"},
			
		};
		
		JTable tabla = new JTable (data,titles);
		
		JScrollPane desplegar = new JScrollPane(tabla);
		desplegar.setSize(850, 300);
		desplegar.setLocation(60, 280);
		panel.add(desplegar);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.decode("#0d47a1"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		
		
		return panel;
	}
	
	//PARA LA SECCIÓN DE AYUDA
	public JPanel op1() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblCrearUsuario = new JLabel("¿CÓMO CREAR UN USUARIO?");
		lblCrearUsuario.setForeground(Color.WHITE);
		lblCrearUsuario.setSize(600,40); //tamaño
		//lblCrearUsuario.setOpaque(true);
		//lblCrearUsuario.setBackground((Color.decode("#bd9892")));
		lblCrearUsuario.setLocation(200,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblCrearUsuario.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblCrearUsuario.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblCrearUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(187, 222, 251));
		panel_1.setBounds(122, 130, 742, 500);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblListaUsuarios = new JLabel("1.- Elegir la plataforma sitio web");
		lblListaUsuarios.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblListaUsuarios.setBackground(new Color(255, 255, 255));
		lblListaUsuarios.setForeground(new Color(0, 0, 0));
		lblListaUsuarios.setBounds(148, 49, 513, 33);
		panel_1.add(lblListaUsuarios);
		
		JLabel lblHacerClic = new JLabel("2. Hacer Clic en “Registrarse” o “Crear Cuenta”");
		lblHacerClic.setForeground(Color.BLACK);
		lblHacerClic.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblHacerClic.setBackground(Color.WHITE);
		lblHacerClic.setBounds(148, 92, 513, 33);
		panel_1.add(lblHacerClic);
		
		JLabel lblCompletarLa = new JLabel("3. Completar la Información Requerida");
		lblCompletarLa.setForeground(Color.BLACK);
		lblCompletarLa.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblCompletarLa.setBackground(Color.WHITE);
		lblCompletarLa.setBounds(148, 135, 490, 33);
		panel_1.add(lblCompletarLa);
		
		JTextArea txtrNormalmenteTePedirian = new JTextArea();
		txtrNormalmenteTePedirian.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		txtrNormalmenteTePedirian.setText("Normalmente te pedirian\r\n - Nombre\r\n - Correo Electronico\r\n - Contraseña\r\n");
		txtrNormalmenteTePedirian.setBounds(168, 187, 352, 81);
		panel_1.add(txtrNormalmenteTePedirian);
		
		JLabel lblVerificarLa = new JLabel("4. Verificar la Información");
		lblVerificarLa.setForeground(Color.BLACK);
		lblVerificarLa.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblVerificarLa.setBackground(Color.WHITE);
		lblVerificarLa.setBounds(148, 290, 503, 33);
		panel_1.add(lblVerificarLa);
		
		JLabel lblAceptarTrminos = new JLabel("5. Aceptar Términos y Condiciones");
		lblAceptarTrminos.setForeground(Color.BLACK);
		lblAceptarTrminos.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblAceptarTrminos.setBackground(Color.WHITE);
		lblAceptarTrminos.setBounds(148, 333, 393, 33);
		panel_1.add(lblAceptarTrminos);
		
		JLabel lblVerificacinDe = new JLabel("6. Verificación de Identidad (si es necesario)");
		lblVerificacinDe.setForeground(Color.BLACK);
		lblVerificacinDe.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblVerificacinDe.setBackground(Color.WHITE);
		lblVerificacinDe.setBounds(148, 377, 554, 33);
		panel_1.add(lblVerificacinDe);
		
		JLabel lblIniciarSesin = new JLabel("7. Iniciar Sesión");
		lblIniciarSesin.setForeground(Color.BLACK);
		lblIniciarSesin.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblIniciarSesin.setBackground(Color.WHITE);
		lblIniciarSesin.setBounds(148, 420, 393, 33);
		panel_1.add(lblIniciarSesin);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.decode("#0d47a1"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		
		return panel;
	}
	
	public JPanel op2() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblCAccederSistema = new JLabel("¿CÓMO ACCEDER AL SISTEMA?");
		lblCAccederSistema.setForeground(Color.WHITE);
		lblCAccederSistema.setSize(600,40); //tamaño
		//lblCAccederSistema.setOpaque(true);
		//lblCAccederSistema.setBackground((Color.decode("#bd9892")));
		lblCAccederSistema.setLocation(200,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblCAccederSistema.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblCAccederSistema.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblCAccederSistema);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(187, 222, 251));
		panel_1.setBounds(122, 130, 742, 500);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblListaUsuarios = new JLabel("1.- Elegir la plataforma sitio web");
		lblListaUsuarios.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblListaUsuarios.setBackground(new Color(255, 255, 255));
		lblListaUsuarios.setForeground(new Color(0, 0, 0));
		lblListaUsuarios.setBounds(157, 67, 513, 33);
		panel_1.add(lblListaUsuarios);
		
		JLabel lblHacerClic = new JLabel("2. Hacer Clic en “Iniciar Sesión” o “Acceder”");
		lblHacerClic.setForeground(Color.BLACK);
		lblHacerClic.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblHacerClic.setBackground(Color.WHITE);
		lblHacerClic.setBounds(157, 110, 513, 33);
		panel_1.add(lblHacerClic);
		
		JLabel lblCompletarLa = new JLabel("3. Introducir las Credenciales de Acceso");
		lblCompletarLa.setForeground(Color.BLACK);
		lblCompletarLa.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblCompletarLa.setBackground(Color.WHITE);
		lblCompletarLa.setBounds(157, 153, 490, 33);
		panel_1.add(lblCompletarLa);
		
		JTextArea txtrNormalmenteTePedirian = new JTextArea();
		txtrNormalmenteTePedirian.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		txtrNormalmenteTePedirian.setText("Normalmente te pedirian\r\n - Nombre\r\n - Correo Electronico\r\n - Contraseña\r\n");
		txtrNormalmenteTePedirian.setBounds(199, 198, 352, 81);
		panel_1.add(txtrNormalmenteTePedirian);
		
		JLabel lblVerificarLa = new JLabel("4. Verificación de Seguridad (si es necesario)");
		lblVerificarLa.setForeground(Color.BLACK);
		lblVerificarLa.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblVerificarLa.setBackground(Color.WHITE);
		lblVerificarLa.setBounds(150, 310, 503, 33);
		panel_1.add(lblVerificarLa);
		
		JLabel lblAceptarTrminos = new JLabel("5. Hacer Clic en “Entrar” o “Acceder”");
		lblAceptarTrminos.setForeground(Color.BLACK);
		lblAceptarTrminos.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblAceptarTrminos.setBackground(Color.WHITE);
		lblAceptarTrminos.setBounds(150, 353, 393, 33);
		panel_1.add(lblAceptarTrminos);
		
		JLabel lblVerificacinDe = new JLabel("6. Acceso al Panel o Área de Usuario");
		lblVerificacinDe.setForeground(Color.BLACK);
		lblVerificacinDe.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblVerificacinDe.setBackground(Color.WHITE);
		lblVerificacinDe.setBounds(150, 403, 450, 33);
		panel_1.add(lblVerificacinDe);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.decode("#0d47a1"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		
		return panel;
	}
	
	public JPanel op3() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblOlvidoContraseña = new JLabel("QUÉ PASA SI OLVIDÉ MI CONTRASEÑA?");
		lblOlvidoContraseña.setSize(600,40); //tamaño
		lblOlvidoContraseña.setForeground(Color.WHITE);
		//lblOlvidoContraseña.setOpaque(true);
		//lblOlvidoContraseña.setBackground((Color.decode("#bd9892")));
		lblOlvidoContraseña.setLocation(200,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblOlvidoContraseña.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblOlvidoContraseña.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblOlvidoContraseña);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(187, 222, 251));
		panel_1.setBounds(122, 130, 742, 500);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblListaUsuarios = new JLabel("1. Ir a la Página de Inicio de Sesión");
		lblListaUsuarios.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblListaUsuarios.setBackground(new Color(255, 255, 255));
		lblListaUsuarios.setForeground(new Color(0, 0, 0));
		lblListaUsuarios.setBounds(149, 28, 513, 33);
		panel_1.add(lblListaUsuarios);
		
		JLabel lblHacerClic = new JLabel("2. Hacer Clic en “¿Olvidaste tu Contraseña?” ");
		lblHacerClic.setForeground(Color.BLACK);
		lblHacerClic.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblHacerClic.setBackground(Color.WHITE);
		lblHacerClic.setBounds(149, 71, 616, 33);
		panel_1.add(lblHacerClic);
		
		JLabel lblCompletarLa = new JLabel("3. Ingresar tu Correo o Nombre de Usuario");
		lblCompletarLa.setForeground(Color.BLACK);
		lblCompletarLa.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblCompletarLa.setBackground(Color.WHITE);
		lblCompletarLa.setBounds(149, 210, 490, 33);
		panel_1.add(lblCompletarLa);
		
		JTextArea txtrNormalmenteTePedirian = new JTextArea();
		txtrNormalmenteTePedirian.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		txtrNormalmenteTePedirian.setText("Justo debajo del campo donde ingresas la contraseña, normalmente\r\n encontrarás un enlace que dice:\r\r\n -“¿Olvidaste tu contraseña?”\r\r\n -“Recuperar contraseña”\r\r\n -“Forgot Password”");
		txtrNormalmenteTePedirian.setBounds(149, 101, 470, 99);
		panel_1.add(txtrNormalmenteTePedirian);
		
		JLabel lblVerificarLa = new JLabel("4. Verificación de Identidad");
		lblVerificarLa.setForeground(Color.BLACK);
		lblVerificarLa.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblVerificarLa.setBackground(Color.WHITE);
		lblVerificarLa.setBounds(149, 253, 503, 33);
		panel_1.add(lblVerificarLa);
		
		JLabel lblAceptarTrminos = new JLabel("5. Revisar tu Correo o Mensaje SMS");
		lblAceptarTrminos.setForeground(Color.BLACK);
		lblAceptarTrminos.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblAceptarTrminos.setBackground(Color.WHITE);
		lblAceptarTrminos.setBounds(148, 296, 393, 33);
		panel_1.add(lblAceptarTrminos);
		
		JLabel lblVerificacinDe = new JLabel("6. Seguir el Enlace o Ingresar el Código");
		lblVerificacinDe.setForeground(Color.BLACK);
		lblVerificacinDe.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblVerificacinDe.setBackground(Color.WHITE);
		lblVerificacinDe.setBounds(149, 339, 554, 33);
		panel_1.add(lblVerificacinDe);
		
		JLabel lblIniciarSesin = new JLabel("7. Crear una Nueva Contraseña");
		lblIniciarSesin.setForeground(Color.BLACK);
		lblIniciarSesin.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblIniciarSesin.setBackground(Color.WHITE);
		lblIniciarSesin.setBounds(148, 382, 393, 33);
		panel_1.add(lblIniciarSesin);
		
		JLabel lblConfirmarLa = new JLabel("8. Confirmar la Nueva Contraseña");
		lblConfirmarLa.setForeground(Color.BLACK);
		lblConfirmarLa.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblConfirmarLa.setBackground(Color.WHITE);
		lblConfirmarLa.setBounds(149, 414, 393, 33);
		panel_1.add(lblConfirmarLa);
		
		JLabel lblIniciarSesin_1 = new JLabel("9. Iniciar Sesión con la Nueva Contraseña");
		lblIniciarSesin_1.setForeground(Color.BLACK);
		lblIniciarSesin_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblIniciarSesin_1.setBackground(Color.WHITE);
		lblIniciarSesin_1.setBounds(148, 457, 393, 33);
		panel_1.add(lblIniciarSesin_1);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setBackground(Color.decode("#0d47a1"));
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\flecha-izquierda (1).png"));
		btnRegresar.setBounds(10, 10, 24, 24);
		panel.add(btnRegresar);
		
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				router("login");
				
			}
		});
		
		return panel;
	}
	
	public JPanel memorama(){
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#0d47a1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(900,700);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 192));
		panel_1.getRootPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("PUNTAJE:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 45, 13);
		//lblNewLabel.setHorizontalAlignment(BorderLayout.NORTH);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.getRootPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(4, 4, 10, 10));
		
		JButton btn1 = new JButton("");
		//btn1.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn1);
		
		JButton btn2 = new JButton("");
		//btn2.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn2);
		
		JButton btn3 = new JButton("");
		//btn3.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn3);
		
		JButton btn4 = new JButton("");
		//btn4.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn4);
		
		JButton btn5 = new JButton("");
		//btn5.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn5);
		
		JButton btn6 = new JButton("");
		//btn6.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn6);
		
		JButton btn7 = new JButton("");
		//btn7.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn7);
		
		JButton btn8 = new JButton("");
		//btn8.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn8);
		
		JButton btn9 = new JButton("");
		//btn9.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn9);
		
		JButton btn10 = new JButton("");
		//btn10.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn10);
		
		JButton btn11 = new JButton("");
		//btn11.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn11);
		
		JButton btn12 = new JButton("");
		//btn12.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn12);
		
		JButton btn13 = new JButton("");
		//btn13.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn13);
		
		JButton btn14 = new JButton("");
		//btn14.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn14);
		
		JButton btn15 = new JButton("");
		//btn15.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn15);
		
		JButton btn16 = new JButton("");
		//btn16.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\preguntas-mas-frecuentes.png"));
		panel_2.add(btn16);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 192));
		panel_3.getRootPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_3.add(btnReiniciar);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 255, 0));
		panel_4.getRootPane().add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new GridLayout(8, 1, 10, 10));
		
		JLabel lblNewLabel_2 = new JLabel("M");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("E");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("M");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("O");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("R");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("A");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("M");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblNewLabel_8);
		
		JLabel lblA = new JLabel("A\r\n");
		lblA.setFont(new Font("Times New Roman", Font.BOLD, 75));
		panel_4.add(lblA);
			
		return panel;
	}
	
	
	
	
	
 	public JPanel login2() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#e0e0e0")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(500,1000);
		panel.setLocation(500,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblBienvenido = new JLabel("S I N G   U P");
		lblBienvenido.setSize(230,40); //tamaño
		//lblBienvenido.setOpaque(true);
		//lblBienvenido.setBackground((Color.decode("#bd9892")));
		lblBienvenido.setLocation(130,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblBienvenido.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblBienvenido.setFont(new Font("Calisto MT", Font.BOLD, 25));
		panel.add(lblBienvenido);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setSize(200,135);//tamaño de email
		lblFullName.setLocation(60,80);
		lblFullName.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		panel.add(lblFullName);
		
		JTextField txtFullName = new JTextField();
		txtFullName.setSize(350,30); //tamaño del recuadro
		txtFullName.setLocation(60,165);
		txtFullName.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		panel.add(txtFullName);	
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setSize(250,30);
		lblEmail.setLocation(60,195);
		lblEmail.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		panel.add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setSize(350,30); //tamaño del recuadro
		txtEmail.setLocation(60,225);
		txtEmail.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		panel.add(txtEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setSize(250,30);
		lblPassword.setLocation(60,260);
		lblPassword.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		panel.add(lblPassword);
		
		JPasswordField txtPassword = new JPasswordField(20);
		txtPassword.setSize(350,30); //tamaño del recuadro
		txtPassword.setLocation(60,290);
		txtPassword.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		panel.add(txtPassword);
		
		Button btnSingUp = new Button("Sing Up");
		btnSingUp.setSize(100,30); //tamaño
		btnSingUp.setLocation(60,340);
		btnSingUp.setBackground((Color.decode("#c1c1c1")));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btnSingUp .setFont(new Font("Baskerville Old Face", Font.BOLD, 12));
		panel.add(btnSingUp);
		
		JLabel lblTienesCuenta = new JLabel("I´ve an account");
		lblTienesCuenta.setSize(100,30);
		lblTienesCuenta.setLocation(60,400);
		lblTienesCuenta.setFont(new Font("Calibri", Font.BOLD, 15));
		panel.add(lblTienesCuenta);
		
		Button btnLogin = new Button("Login");
		btnLogin.setSize(90,30); //tamaño
		btnLogin.setLocation(180,400);
		btnLogin.setBackground((Color.WHITE));
		btnLogin.setForeground(Color.RED);
		//btnLogin.setHorizontalAlignment(JLabel.LEFT);
		btnLogin .setFont(new Font("Calibri", Font.BOLD, 12));
		panel.add(btnLogin);
		
		
		return panel;
	}
	public JPanel imagen() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#c1c1c1")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(500,1000);
		panel.setLocation(500,0);
		panel.setLayout(null);//quita el molde
		
		//mostrar imagen
		ImageIcon icon = new ImageIcon("C:\\Users\\keyra\\eclipse-workspace\\LoginRegistro\\src\\amd (2).png");
		Image img = icon.getImage();//obtenemos la imagen del icono
		Image tamañoImg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);//ajustar el tamño de la img
		ImageIcon tamañoIcon = new ImageIcon(tamañoImg);//creamos un nuevo imganIcon con la img redimensionada
		
		
		JLabel lblImagen = new JLabel(tamañoIcon);
		lblImagen.setSize(tamañoIcon.getIconWidth(), tamañoIcon.getIconHeight());
		lblImagen.setLocation(200,150);
		panel.add(lblImagen);
		
		JLabel lblNombre = new JLabel("Advanced Micro Devices");
		lblNombre.setSize(250,100);
		lblNombre.setLocation(160,350);
		lblNombre.setFont(new Font("Bell MT", Font.BOLD, 18));
		panel.add(lblNombre);

		 return panel;
	}
	public JPanel calculadora(){
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#380038")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(50,500);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JTextField txtVentana = new JTextField();
		txtVentana.setHorizontalAlignment(JTextField.RIGHT);
		//txtVentana.setForeground(Color.decode("#380038"));
		txtVentana.setSize(350,80); //tamaño del recuadro
		txtVentana.setLocation(10,10);
		txtVentana.setFont(new Font("Arial Rounded MT", Font.BOLD, 50));
		panel.add(txtVentana);	
		
		//BOTON CE
		Button btn1 = new Button("CE");
		btn1.setSize(80,60);
		btn1.setLocation(10,100);
		btn1.setBackground((Color.decode("#d97dd5")));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btn1.setFont(new Font("Arial Rounded MT", Font.BOLD, 20));
		panel.add(btn1);
		
		
		//LINEA VERTICAL 1 -------------------------------------------------
		//BOTON CE
		
		//display (todo)
		Button btn2 = new Button("%");
		btn2.setSize(260,60);
		btn2.setLocation(100,100);
		btn2.setBackground((Color.decode("#d97dd5")));
		//btn2.setHorizontalAlignment(JLabel.CENTER);
		btn2.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btn2);
		
		
		Button btnNum7 = new Button("7");
		btnNum7.setSize(80,60);
		btnNum7.setLocation(10,170);
		//btnNum7.setBackground((Color.decode("#bd9892")));
		//btnNum7.setHorizontalAlignment(JLabel.CENTER);
		btnNum7.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum7);
		
		
		Button btnNum4 = new Button("4");
		btnNum4.setSize(80,60);
		btnNum4.setLocation(10,240);
		//btnNum4.setBackground((Color.decode("#bd9892")));
		//btnNum4.setHorizontalAlignment(JLabel.CENTER);
		btnNum4.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum4);
		
		Button btnNum1 = new Button("1");
		btnNum1.setSize(80,60);
		btnNum1.setLocation(10,310);
		//btnNum1.setBackground((Color.decode("#bd9892")));
		//btnNum1.setHorizontalAlignment(JLabel.CENTER);
		btnNum1.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum1);
		
		Button btnNum0 = new Button("0");
		btnNum0.setSize(80,60);
		btnNum0.setLocation(10,380);
		//btnNum0.setBackground((Color.decode("#bd9892")));
		//btnNum0.setHorizontalAlignment(JLabel.CENTER);
		btnNum0.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum0);
		//------------------------------------------------------------------------
		//LINEA VERTICAL 2
		Button btnNum8 = new Button("8");
		btnNum8.setSize(80,60);
		btnNum8.setLocation(100,170);
		//btnNum8.setBackground((Color.decode("#bd9892")));
		//btnNum8.setHorizontalAlignment(JLabel.CENTER);
		btnNum8.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum8);
		
		Button btnNum5 = new Button("5");
		btnNum5.setSize(80,60);
		btnNum5.setLocation(100,240);
		//btnNum5.setBackground((Color.decode("#bd9892")));
		//btnNum5.setHorizontalAlignment(JLabel.CENTER);
		btnNum5.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum5);
		
		Button btnNum2 = new Button("2");
		btnNum2.setSize(80,60);
		btnNum2.setLocation(100,310);
		//btnNum2.setBackground((Color.decode("#bd9892")));
		//btnNum2.setHorizontalAlignment(JLabel.CENTER);
		btnNum2.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum2);
		
		Button btnPunto = new Button(".");
		btnPunto.setSize(80,60);
		btnPunto.setLocation(100,380);
		//btnPunto.setBackground((Color.decode("#bd9892")));
		//btnPunto.setHorizontalAlignment(JLabel.CENTER);
		btnPunto.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnPunto);
		//----------------------------------------------------------------
		//LINEA VERTICAL 3
		Button btnNum9 = new Button("9");
		btnNum9.setSize(80,60);
		btnNum9.setLocation(190,170);
		//btnNum9.setBackground((Color.decode("#bd9892")));
		//btnNum9.setHorizontalAlignment(JLabel.CENTER);
		btnNum9.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum9);
		
		Button btnNum6 = new Button("6");
		btnNum6.setSize(80,60);
		btnNum6.setLocation(190,240);
		//btnNum6.setBackground((Color.decode("#bd9892")));
		//btnNum6.setHorizontalAlignment(JLabel.CENTER);
		btnNum6.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum6);
		
		Button btnNum3 = new Button("3");
		btnNum3.setSize(80,60);
		btnNum3.setLocation(190,310);
		//btnNum3.setBackground((Color.decode("#bd9892")));
		//btnNum3.setHorizontalAlignment(JLabel.CENTER);
		btnNum3.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnNum3);
		
		Button btnIgual = new Button("=");
		btnIgual.setSize(80,60);
		btnIgual.setLocation(190,380);
		btnIgual.setBackground((Color.decode("#7b147b")));
		//btnIgual.setHorizontalAlignment(JLabel.CENTER);
		btnIgual.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnIgual);
		//--------------------------------------------------------------
		//LINEA VERTICAL 4
		Button btnDiv = new Button("/");
		btnDiv.setSize(80,60);
		btnDiv.setLocation(280,170);
		btnDiv.setBackground((Color.decode("#973095")));
		//btnDiv.setHorizontalAlignment(JLabel.CENTER);
		btnDiv.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnDiv);
		
		Button btnMulti = new Button("*");
		btnMulti.setSize(80,60);
		btnMulti.setLocation(280,240);
		btnMulti.setBackground((Color.decode("#973095")));
		//btnMulti.setHorizontalAlignment(JLabel.CENTER);
		btnMulti.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnMulti);
		
		Button btnResta = new Button("-");
		btnResta.setSize(80,60);
		btnResta.setLocation(280,310);
		btnResta.setBackground((Color.decode("#973095")));
		//btnResta.setHorizontalAlignment(JLabel.CENTER);
		btnResta.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnResta);

		Button btnSuma = new Button("+");
		btnSuma.setSize(80,60);
		btnSuma.setLocation(280,380);
		btnSuma.setBackground((Color.decode("#973095")));
		//btnSuma.setHorizontalAlignment(JLabel.CENTER);
		btnSuma.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnSuma);
		
		return panel;
	}
	public JPanel calculadora2() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#380038")); //PARA PONER OTRO COLOR 
		panel.setOpaque(true);		
		//Color.decode("numero del color que quieres"));
		panel.setLayout(new BorderLayout());
		
		JLabel ventana = new JLabel("20.00");
		ventana.setBackground(Color.BLACK);
		ventana.setOpaque(true);
		ventana.setFont(new Font("American TYpewrite", Font.BOLD, 40));
		ventana.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(ventana,BorderLayout.NORTH);
		
		JPanel centro = new JPanel();
		centro.setBackground(Color.BLUE);
		centro.setOpaque(true);
		centro.setLayout(new BorderLayout());
		panel.add(centro,BorderLayout.CENTER);
		
		JPanel btns = new JPanel();
		btns.setLayout(new GridLayout(4,3));
		centro.add(btns,BorderLayout.CENTER);
		
		String[] campos = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0", "."};
		
		for(String campoBtn : campos) {
			JButton boton = new JButton(campoBtn);
			btns.add(boton);
		}
		
		JPanel orilla = new JPanel();
		orilla.setLayout(new GridLayout(6,1));
		centro.add(orilla,BorderLayout.LINE_END);
		
		String[] campos1 = {"/", "*", "-", "+", "=","CE" };
		
		for(String campoBtn : campos1) {
			JButton boton = new JButton(campoBtn);
			orilla.add(boton);
		}
		
		return panel;
	}
	public JPanel interfaz() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE); //PARA PONER OTRO COLOR 
		panel.setOpaque(true);		
		//Color.decode("numero del color que quieres"));
		panel.setLayout(new BorderLayout());
		
		JLabel ventana = new JLabel("Interés");
		ventana.setBorder(BorderFactory.createLineBorder(Color.WHITE,10));
		ventana.setBorder(BorderFactory.createMatteBorder(0, 10, 1, 1, Color.WHITE));
		ventana.setOpaque(true);
		ventana.setForeground(Color.RED);
		ventana.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		ventana.setHorizontalAlignment(JLabel.LEFT);
		panel.add(ventana,BorderLayout.NORTH);
		
		
		//PARA EL PANEL CENTRAL
		JPanel centro = new JPanel();
		centro.setBorder(BorderFactory.createLineBorder(Color.WHITE,30));
		centro.setOpaque(true);
		centro.setBackground(Color.decode("#9de488"));

		String [] textos = {"Capital:", "Tiempo:","Tasa de Interés:"};
		for(String textoo : textos) {
			JLabel lbltexto = new JLabel(textoo);
			lbltexto.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
			lbltexto.setBorder(BorderFactory.createMatteBorder(10, 40, 1, 1, Color.decode("#9de488")));
			centro.add(lbltexto);
			JTextField txtCampo = new JTextField();
			txtCampo.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
			txtCampo.setBorder(BorderFactory.createMatteBorder(10, 10, 0, 20, Color.decode("#9de488")));
			centro.add(txtCampo);
		}
		String[] campos = {"Calcular", "Cancelar"};
		for(String campoBtn : campos) {
			JButton boton = new JButton(campoBtn);
			boton.setBackground(Color.BLACK);
			boton.setForeground(Color.WHITE);
			boton.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
			//boton.setBorder(BorderFactory.createLineBorder(Color.GREEN,20));
			//boton.setBorder(BorderFactory.createMatteBorder(10, 80, 0, 1, Color.GREEN));
			centro.add(boton);
		}
		centro.setLayout(new GridLayout(4,4,10,30));
		panel.add(centro,BorderLayout.CENTER);

		
		
		//PARA EL PANEL INFERIOR
		JPanel footer = new JPanel();
		footer.setBorder(BorderFactory.createLineBorder(Color.WHITE,30));
		footer.setOpaque(true);
		footer.setBackground(Color.decode("#ffa8d9"));
		
		String [] txt = {"Interes", "Monto"};
		for(String txts : txt) {
			JLabel lbltexto1 = new JLabel(txts);
			lbltexto1.setBorder(BorderFactory.createMatteBorder(10, 80, 1, 1, Color.decode("#ffa8d9")));
			lbltexto1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
			footer.add(lbltexto1);
			JTextField txtCampos = new JTextField();
			txtCampos.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
			txtCampos.setBorder(BorderFactory.createMatteBorder(0, 10, 0, 20, Color.decode("#ffa8d9")));
			
			footer.add(txtCampos);
		}
		footer.setLayout(new GridLayout(2,2,20,20));
		panel.add(footer,BorderLayout.SOUTH);
		
	
		
		
		
		return panel;
	}
	/*@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g.create();
		//para la linea del grosor
		g2d.setStroke(new BasicStroke(5));
		//para un cuadrado
		g2d.drawRect(100, 100, 80, 80);
		g2d.fillRect(120, 120, 80, 80);
		
		//g2d.setColor(Color.DARK_GRAY);
		
		g2d.setColor(Color.BLUE);
		//para escribir
		g2d.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
		g2d.drawString("Keyra", 160, 300);
		
		
		//para pintar una linea
		g2d.drawLine(0,0,400,400);
		
		//para el arco. fill es para rellenar de color el arco 
		g2d.drawArc(400,100,100,100,0,180);
		g2d.fillArc(400,100,100,100,0,-180);
		
		//ovalo
		g2d.drawOval(100,400,90,190);
		
		g2d.fillOval(140,400,90,190);
		g2d.setColor(Color.BLACK);
		
		//imagen
		try {
			BufferedImage image = ImageIO.read(new File("src/animal.png"));
			g2d.drawImage(image, 500, 50, null);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//poligono
		int[] xs= {400,350,450};
		int[] ys = {200,250,250};
		g2d.drawPolygon(xs,ys,3);
		
		int[] xs2= {400,350,450};
		int[] ys2 = {200,250,250};
		g2d.fillPolygon(xs2,ys2,3);
		
		//rectangulo
		g2d.drawRoundRect(500,400,100,100,30,30);
		g2d.fillRoundRect(550,440,100,100,30,30);
		
	}*/
	
	
}


