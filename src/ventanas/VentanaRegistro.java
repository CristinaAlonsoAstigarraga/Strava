package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VentanaRegistro {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldEmail;
	private JTextField textFieldFechaNac;
	private JTextField textFieldPeso;
	private JTextField textFieldAltura;
	private JTextField textFieldFCM;
	private JTextField textFieldFCR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
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
	public VentanaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 675, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEmail = new JLabel("EMAIL: ");
		panelCentro.add(lblEmail);
		
		textFieldEmail = new JTextField();
		panelCentro.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		panelCentro.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panelCentro.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("FECHA NACIMIENTO");
		panelCentro.add(lblFechaNac);
		
		textFieldFechaNac = new JTextField();
		panelCentro.add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		JLabel lblPeso = new JLabel("PESO:");
		panelCentro.add(lblPeso);
		
		textFieldPeso = new JTextField();
		panelCentro.add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("ALTURA:");
		panelCentro.add(lblAltura);
		
		textFieldAltura = new JTextField();
		panelCentro.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblFCM = new JLabel("FRECUENCIA CARDIACA MAXIMA:");
		panelCentro.add(lblFCM);
		
		textFieldFCM = new JTextField();
		panelCentro.add(textFieldFCM);
		textFieldFCM.setColumns(10);
		
		JLabel lblFCR = new JLabel("FRECUENCIA CARDIACA REPOSO:");
		panelCentro.add(lblFCR);
		
		textFieldFCR = new JTextField();
		panelCentro.add(textFieldFCR);
		textFieldFCR.setColumns(10);
		
		JPanel panelNorte = new JPanel();
		frame.getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		panelNorte.add(lblRegistro);
		
		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		panelSur.add(btnRegistrar);
		
		JButton btnRegistroGoogle = new JButton("REGISTRAR CON GOOGLE");
		panelSur.add(btnRegistroGoogle);
		
		JButton btnRegistroFB = new JButton("REGISTRAR CON FACEBOOK");
		panelSur.add(btnRegistroFB);
		
		JPanel panelOeste = new JPanel();
		frame.getContentPane().add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		frame.getContentPane().add(panelEste, BorderLayout.EAST);
	}

}
