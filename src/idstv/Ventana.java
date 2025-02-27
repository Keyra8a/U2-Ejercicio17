package idstv;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	public Ventana() {
		this.setTitle("Calculadora");//para el titulo de la ventana
		this.setVisible(true);
		this.setSize(390,500);
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para cerrar todas las ventanas/dejar de correr el programa
		
		//this.setResizable(true);//para cambiar el tamaño de la ventana
		this.setMaximumSize(new Dimension(1000,1000));
		this.setMinimumSize(new Dimension(390,400));
		
		
		//this.add(this.tabla2());
		//this.add(this.login2());
		//this.add(this.imagen());
		this.add(this.calculadora());
		
		/*//barra
		JMenuBar barra = new JMenuBar();
		JMenu file = new JMenu("Archivo");
		barra.add(file);
		
		//para las opciones del menu
		JMenuItem open = new JMenuItem("Abrir");
		file.add(open);
		
		JMenuItem close = new JMenuItem("Cerrar");
		file.add(close);
		
		JMenuItem guardar = new JMenuItem("Guardar");
		file.add(guardar);
		
		JMenuItem guardarcomo = new JMenuItem("Guardar como");
		file.add(guardarcomo);
		
		//para hacer otro menu
		JMenu menu_2 = new JMenu("Ayuda");
		barra.add(menu_2);
		
		JCheckBoxMenuItem op_5= new JCheckBoxMenuItem("Hola");
		menu_2.add(op_5);	
		
		this.setJMenuBar(barra);*/
		
		this.repaint();
		this.setVisible(true);
	}
	
	public JPanel login()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#ffe5dd")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(500,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setSize(230,40); //tamaño
		lblBienvenido.setOpaque(true);
		lblBienvenido.setBackground((Color.decode("#bd9892")));
		lblBienvenido.setLocation(130,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblBienvenido.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblBienvenido.setFont(new Font("American TYpewrite", Font.BOLD, 30));
		panel.add(lblBienvenido);
		
		JLabel lblEmail = new JLabel("Ingrese su email:");
		lblEmail.setSize(200,135);//tamaño de email
		lblEmail.setLocation(60,80);
		lblEmail.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setSize(350,30); //tamaño del recuadro
		txtEmail.setLocation(60,165);
		txtEmail.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(txtEmail);	
		
		JLabel lblContra = new JLabel("Ingrese su contraseña:");
		lblContra.setSize(250,30);
		lblContra.setLocation(60,195);
		lblContra.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(lblContra);
		
		JTextField txtcontra = new JTextField();
		txtcontra.setSize(350,30); //tamaño del recuadro
		txtcontra.setLocation(60,225);
		txtcontra.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(txtcontra);
		
		Checkbox cheRecordarme = new Checkbox("Recordarme");
		cheRecordarme.setSize(100,30);
		cheRecordarme.setLocation(60,250);
		cheRecordarme.setFont(new Font("American TYpewrite", Font.BOLD, 10));
		panel.add(cheRecordarme);
		
		
		JLabel lblOlvContra = new JLabel("¿Olvido su contraseña?");
		lblOlvContra.setSize(500,30);
		lblOlvContra.setLocation(290,250);
		lblOlvContra.setFont(new Font("American TYpewrite", Font.BOLD, 10));
		panel.add(lblOlvContra);
		
		Button btnAcceder = new Button("ACCEDER");
		btnAcceder .setSize(350,40); //tamaño
		btnAcceder .setLocation(60,300);
		btnAcceder.setBackground((Color.decode("#bd9892")));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btnAcceder .setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnAcceder );
		
		return panel;
	}
	public JPanel registro() {
		
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.decode("#bd9892")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(500,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setSize(230,40); //tamaño
		lblRegistro.setOpaque(true);
		lblRegistro.setBackground(Color.decode("#ffe5dd"));
		lblRegistro.setLocation(130,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblRegistro.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblRegistro.setFont(new Font("American TYpewrite", Font.BOLD, 30));
		panel.add(lblRegistro);
		
		JLabel lblNomUsuario = new JLabel("Nombre del usuario:");
		lblNomUsuario.setOpaque(true);
		lblNomUsuario.setBackground(Color.decode("#ffe5dd"));
		lblNomUsuario.setSize(350,30);//tamaño de email
		lblNomUsuario.setLocation(70,130);
		lblNomUsuario.setHorizontalAlignment(JLabel.CENTER);
		lblNomUsuario.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(lblNomUsuario);
		
		JTextField txtNomUsuario = new JTextField();
		txtNomUsuario.setSize(350,30); //tamaño del recuadro
		txtNomUsuario.setLocation(70,165);
		txtNomUsuario.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(txtNomUsuario);
		
		JLabel lblBio = new JLabel("B I O");
		lblBio.setSize(348,30);
		lblBio.setLocation(70,210);
		lblBio.setHorizontalAlignment(JLabel.CENTER);
		lblBio.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(lblBio);
		lblBio.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		JTextArea txtAreaBio = new JTextArea("");
		txtAreaBio.setSize(350,80);
		txtAreaBio.setLocation(70,250);
		txtAreaBio.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(txtAreaBio);
		
		JLabel lblPreferencias = new JLabel("PREFERENCIAS");
		lblPreferencias.setSize(200,30);
		lblPreferencias.setLocation(130,350);
		lblBio.setHorizontalAlignment(JLabel.CENTER);
		lblPreferencias.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(lblPreferencias);
		
		JCheckBox checkDulce = new JCheckBox("Dulce");
		checkDulce.setSize(100,30);
		checkDulce.setLocation(70,380);
		checkDulce.setOpaque(false);
		lblBio.setHorizontalAlignment(JLabel.CENTER);
		checkDulce.setFont(new Font("American TYpewrite", Font.BOLD, 15));
		panel.add(checkDulce);

		
		//checkDulce.setBorder(BorderFactory.createLineBorder(Color.BLACK,8));
		
		JCheckBox checkSalado = new JCheckBox("Salado");
		checkSalado.setSize(110,30);
		checkSalado.setLocation(160,380);
		checkSalado.setOpaque(false);
		checkSalado.setFont(new Font("American TYpewrite", Font.BOLD, 15));
		panel.add(checkSalado);
		
		JCheckBox checkSaludable = new JCheckBox("Saludable");
		checkSaludable.setSize(140,30);
		checkSaludable.setLocation(280,380);
		checkSaludable.setOpaque(false);
		checkSaludable.setFont(new Font("American TYpewrite", Font.BOLD, 15));
		panel.add(checkSaludable);
		
		JLabel lblTerminos = new JLabel("TERMINOS");
		lblTerminos.setOpaque(true);
		lblTerminos.setBackground(Color.decode("#ffe5dd"));
		lblTerminos.setSize(350,30);
		lblTerminos.setLocation(70,420);
		lblTerminos.setHorizontalAlignment(JLabel.CENTER);
		lblTerminos.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(lblTerminos);
		
		
		JRadioButton jrbAcepTerm = new JRadioButton("Acepto los terminos");
		jrbAcepTerm.setSize(200,40);
		jrbAcepTerm.setLocation(70,450);
		jrbAcepTerm.setOpaque(false);
		panel.add(jrbAcepTerm);
		
		JRadioButton jrbNoAcepTerm = new JRadioButton("No acepto los terminos", true);
		jrbNoAcepTerm.setSize(200,40);
		jrbNoAcepTerm.setLocation(230,450);
		jrbNoAcepTerm.setOpaque(false);
		panel.add(jrbNoAcepTerm);
		
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
		btnCrearCuenta.setLocation(70,550);
		//btnCrearCuenta.setOpaque(true);
		btnCrearCuenta.setBackground(Color.decode("#ffe5dd"));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btnCrearCuenta.setFont(new Font("American TYpewrite", Font.BOLD, 20));
		panel.add(btnCrearCuenta);
	
		return panel;
	}
	public JPanel tabla2()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#ffe5dd")); //PARA PONER OTRO COLOR 
		//Color.decode("numero del color que quieres"));
		panel.setOpaque(true);//para habilitar el fondo de pantalla
		panel.setSize(1000,1000);
		panel.setLocation(0,0);
		panel.setLayout(null);//quita el molde
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setSize(230,40); //tamaño
		lblBienvenido.setOpaque(true);
		lblBienvenido.setBackground((Color.decode("#bd9892")));
		lblBienvenido.setLocation(400,60);//DONNDE VAMOS A LOCALIZAR LA ETIQUETA
		lblBienvenido.setHorizontalAlignment(JLabel.CENTER);//CENTRAR LA ETIQUETA
		lblBienvenido.setFont(new Font("American TYpewrite", Font.BOLD, 30));
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
		btnDescargar.setBackground(Color.decode("#88453e"));
		//btn1.setHorizontalAlignment(JLabel.CENTER);
		btnDescargar.setForeground(Color.WHITE);
		btnDescargar.setFont(new Font("American TYpewrite", Font.BOLD, 12));
		panel.add(btnDescargar);
		
		Button btnAñadir = new Button("Añadir");
		btnAñadir.setSize(80,30); //tamaño
		btnAñadir.setLocation(830,230);
		//btnCrearCuenta.setOpaque(true);
		btnAñadir.setForeground(Color.WHITE);
		btnAñadir.setBackground(Color.decode("#88453e"));
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
}


