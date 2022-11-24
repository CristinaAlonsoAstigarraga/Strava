package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaRegistro2 extends JFrame {

	private JPanel contentPane;
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
					VentanaRegistro2 frame = new VentanaRegistro2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		contentPane.add(lblRegistro);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro);
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
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		panelSur.add(btnRegistrar);
		
		JButton btnRegistroGoogle = new JButton("REGISTRO GOOGLE");
		panelSur.add(btnRegistroGoogle);
		
		JButton btnRegistroFB = new JButton("REGISTRO FACEBOOK");
		panelSur.add(btnRegistroFB);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
	}

}
