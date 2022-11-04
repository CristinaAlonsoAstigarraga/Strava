package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaLogIn {

	private JFrame frame;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasenya;
	private JPasswordField txtContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogIn window = new VentanaLogIn();
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
	public VentanaLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorte = new JPanel();
		frame.getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		panelNorte.add(lblLogIn);
		
		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 1, 0, 10));
		
		JButton btnIniciarSesion = new JButton("INICIAR SESIÓN");
		panelSur.add(btnIniciarSesion);
		
		JButton btnISGoogle = new JButton("INICIAR SESIÓN CON GOOGLE");
		panelSur.add(btnISGoogle);
		
		JButton btnISFaceBook = new JButton("INICIAR SESIÓN CON FACEBOOK");
		panelSur.add(btnISFaceBook);
		
		JButton btnRegistro = new JButton("REGISTRAR");
		panelSur.add(btnRegistro);
		
		JPanel panelOeste = new JPanel();
		frame.getContentPane().add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		frame.getContentPane().add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 0, 0, 10));
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		panelCentro.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		panelCentro.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasenya = new JLabel("CONTRASEÑA:");
		panelCentro.add(lblContrasenya);
		
		textFieldContrasenya = new JPasswordField();
		panelCentro.add(textFieldContrasenya);
		textFieldContrasenya.setColumns(10);
	}

}
