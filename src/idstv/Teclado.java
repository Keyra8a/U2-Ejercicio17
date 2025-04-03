package idstv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teclado window = new Teclado();
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
	public Teclado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel pnlNorte = new JPanel();
		frame.getContentPane().add(pnlNorte, BorderLayout.NORTH);
		pnlNorte.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEsperando = new JLabel("  ESPERANDO");
		lblEsperando.setFont(new Font("Tahoma", Font.BOLD, 14));
		//lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		pnlNorte.add(lblEsperando);
		
		JPanel pnlSur = new JPanel();
		pnlSur.setBackground(UIManager.getColor("Button.disabledForeground"));
		frame.getContentPane().add(pnlSur, BorderLayout.SOUTH);
		pnlSur.setLayout(null);
		pnlSur.setLayout(new GridLayout(1, 0, 1, 2));
		
		JLabel lblEspacio = new JLabel("ESPACIO");
		pnlSur.add(lblEspacio);
		
		JLabel lblBorrado = new JLabel("BORRANDO");
		lblBorrado.setBackground(UIManager.getColor("Button.background"));
		pnlSur.add(lblBorrado);
		
		JPanel pnlCentro = new JPanel();
		pnlCentro.setBackground(UIManager.getColor("CheckBox.light"));
		frame.getContentPane().add(pnlCentro, BorderLayout.CENTER);
		pnlCentro.setLayout(new GridLayout(3, 0, 3, 9));
		
		JLabel teclaQ = new JLabel("Q");
		teclaQ.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaQ.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaQ);
		
		JLabel teclaW = new JLabel("W");
		teclaW.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaW.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaW);
		
		JLabel teclaE = new JLabel("E");
		teclaE.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaE.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaE);
		
		JLabel teclaR = new JLabel("R");
		teclaR.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaR.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaR);
		
		JLabel teclaT = new JLabel("T");
		teclaT.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaT.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaT);
		
		JLabel teclaY = new JLabel("Y");
		teclaY.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaY);
		
		JLabel teclaU = new JLabel("U");
		teclaU.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaU.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaU);
		
		JLabel teclaI = new JLabel("I");
		teclaI.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaI.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaI);
		
		JLabel teclaO = new JLabel("O");
		teclaO.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaO.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaO);
		
		JLabel teclaP = new JLabel("P");
		teclaP.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaP.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaP);
		
		JLabel teclaA = new JLabel("A");
		teclaA.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaA.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaA);
		
		JLabel teclaS = new JLabel("S");
		teclaS.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaS.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaS);
		
		JLabel teclaD = new JLabel("D");
		teclaD.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaD.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaD);
		
		JLabel teclaF = new JLabel("F");
		teclaF.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaF.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaF);
		
		JLabel teclaG = new JLabel("G");
		teclaG.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaG.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaG);
		
		JLabel teclaH = new JLabel("H");
		teclaH.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaH.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaH);
		
		JLabel teclaJ = new JLabel("J");
		teclaJ.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaJ.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaJ);
		
		JLabel teclaK = new JLabel("K");
		teclaK.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaK.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaK);
		
		JLabel teclaL = new JLabel("L");
		teclaL.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaL.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaL);
		
		JLabel teclaÑ = new JLabel("Ñ");
		teclaÑ.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaÑ.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaÑ);
		
		JLabel teclaZ = new JLabel("Z");
		teclaZ.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaZ.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaZ);
		
		JLabel teclaX = new JLabel("X");
		teclaX.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaX.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaX);
		
		JLabel teclaC = new JLabel("C");
		teclaC.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaC.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaC);
		
		JLabel teclaV = new JLabel("V");
		teclaV.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaV.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaV);
		
		JLabel teclaB = new JLabel("B");
		teclaB.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaB.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaB);
		
		JLabel teclaN = new JLabel("N");
		teclaN.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaN.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaN);
		
		JLabel teclaM = new JLabel("M");
		teclaM.setFont(new Font("Tahoma", Font.BOLD, 15));
		teclaM.setHorizontalAlignment(JLabel.CENTER);
		pnlCentro.add(teclaM);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
