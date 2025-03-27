package idstv;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;

public class Examen {

	private JFrame frame;
	private JTextField txtDocumento;
	private JTextField txtDirección;
	private JTextField txtNombres;
	private JTextField txtTelefono;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtNoFactura;
	private JTextField txtFecha;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField txtSubTotal;
	private JTextField txtDescuento;
	private JTextField txtIva;
	private JTextField txtTotalFactura;
	private JTextField txtValorDescontado;
	private JButton btnEliminar;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen window = new Examen();
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
	public Examen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(0, 0, 686, 109);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Factura en Java - NetBeans -  ArrayList y POO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 21, 598, 35);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("[Sin Base de Datos]");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 60, 135, 13);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("  Datos del cliente  "));
		panel_2.setBounds(10, 127, 666, 121);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblDocumento.setBounds(46, 32, 84, 13);
		panel_2.add(lblDocumento);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblDireccin.setBounds(46, 69, 84, 13);
		panel_2.add(lblDireccin);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNombres.setBounds(341, 32, 84, 13);
		panel_2.add(lblNombres);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblTelfono.setBounds(341, 69, 84, 13);
		panel_2.add(lblTelfono);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDocumento.setBounds(140, 23, 180, 29);
		panel_2.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		txtDirección = new JTextField();
		txtDirección.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDirección.setColumns(10);
		txtDirección.setBounds(140, 60, 180, 29);
		panel_2.add(txtDirección);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNombres.setColumns(10);
		txtNombres.setBounds(423, 23, 186, 29);
		panel_2.add(txtNombres);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(423, 60, 186, 29);
		panel_2.add(txtTelefono);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder("   Datos de Factura   "));
		panel_3.setBounds(10, 268, 666, 78);
		panel.add(panel_3);
		
		JLabel lblNoFactura = new JLabel("No. Factura:");
		lblNoFactura.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNoFactura.setBounds(53, 35, 97, 13);
		panel_3.add(lblNoFactura);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblFecha.setBounds(350, 35, 84, 13);
		panel_3.add(lblFecha);
		
		txtNoFactura = new JTextField();
		txtNoFactura.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNoFactura.setColumns(10);
		txtNoFactura.setBounds(142, 26, 180, 29);
		panel_3.add(txtNoFactura);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtFecha.setColumns(10);
		txtFecha.setBounds(427, 26, 180, 29);
		panel_3.add(txtFecha);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(BorderFactory.createTitledBorder("-"));
		panel_3_1.setBounds(10, 368, 666, 50);
		panel.add(panel_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ver listado de facturas");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(49, 10, 211, 30);
		panel_3_1.add(lblNewLabel_2);
		
		JButton btnAñadir = new JButton("");
		btnAñadir.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\mas.png"));
		btnAñadir.setBounds(442, 10, 36, 35);
		panel_3_1.add(btnAñadir);
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\eliminar (1).png"));
		btnEliminar.setBounds(535, 10, 36, 30);
		panel_3_1.add(btnEliminar);
		
		JLabel lblAñadir = new JLabel("Añadir");
		lblAñadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAñadir.setBounds(488, 20, 45, 13);
		panel_3_1.add(lblAñadir);
		
		JLabel lblEliminar = new JLabel("Eliminar\r\n");
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEliminar.setBounds(581, 20, 75, 13);
		panel_3_1.add(lblEliminar);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\keyra\\Downloads\\menu (1).png"));
		lblNewLabel_3.setBounds(10, 10, 36, 35);
		panel_3_1.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 428, 666, 109);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		tabla = new JTable();
		
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
				{"Agua", "2", "500", "1000.0"},
				{"Cereal", "5", "1000", "5000.0"},
				{"Leche", "2", "300", "600.0"},
				{null, null, null, null},
			},
			new String[] {
				"PRODUCTO", "CANTIDAD", "VALOR", "SUB TOTAL"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBackground(null);
		scrollPane.setBounds(10, 10, 646, 89);
		panel_4.add(scrollPane);
		//tabla.setBounds(10, 20, 646, 89);
		//panel_4.add(tabla);
		
		
		
		JLabel lblSubTotal = new JLabel("Sub Total:");
		lblSubTotal.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblSubTotal.setBounds(41, 575, 103, 13);
		panel.add(lblSubTotal);
		
		JLabel lblDescuento = new JLabel("% descuento:");
		lblDescuento.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDescuento.setBounds(41, 618, 103, 13);
		panel.add(lblDescuento);
		
		JLabel lblIva = new JLabel("IVA 19%:");
		lblIva.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblIva.setBounds(41, 665, 103, 13);
		panel.add(lblIva);
		
		JLabel lblTotalFactura = new JLabel("Total Factura:");
		lblTotalFactura.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblTotalFactura.setBounds(41, 712, 129, 13);
		panel.add(lblTotalFactura);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBounds(170, 565, 115, 28);
		panel.add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		txtDescuento = new JTextField();
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(170, 603, 115, 28);
		panel.add(txtDescuento);
		
		txtIva = new JTextField();
		txtIva.setColumns(10);
		txtIva.setBounds(170, 650, 115, 28);
		panel.add(txtIva);
		
		txtTotalFactura = new JTextField();
		txtTotalFactura.setColumns(10);
		txtTotalFactura.setBounds(170, 699, 115, 28);
		panel.add(txtTotalFactura);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setBounds(299, 606, 21, 21);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblValorDescontado = new JLabel("Valor descontado:");
		lblValorDescontado.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblValorDescontado.setBounds(326, 610, 136, 13);
		panel.add(lblValorDescontado);
		
		txtValorDescontado = new JTextField();
		txtValorDescontado.setColumns(10);
		txtValorDescontado.setBounds(472, 603, 115, 28);
		panel.add(txtValorDescontado);
		
		JButton btnFinalizarFactura = new JButton("Finalizar Factura");
		btnFinalizarFactura.setBounds(472, 706, 115, 28);
		panel.add(btnFinalizarFactura);
		
		JButton btnLimpiar = new JButton("Limpiar");
		
		btnLimpiar.setBounds(592, 706, 84, 28);
		panel.add(btnLimpiar);
		
		
		
		
		
		/*JLabel lblDatosCliente = new JLabel("New label");
		//lblDatosCliente.setBorder(BorderFactory.createTitledBorder("Datos del cliente"));
		lblDatosCliente.setOpaque(true);
		lblDatosCliente.setBackground(Color.WHITE);
		lblDatosCliente.setBounds(10, -19, 105, 39);
		panel_2.add(lblDatosCliente);*/
		
	}
}
