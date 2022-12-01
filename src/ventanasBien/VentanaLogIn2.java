package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LogInController;
import controller.RetoController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogIn2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasenya;
	private JPasswordField txtContrasenia;
	private static LogInController logInController;
	private static RetoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogIn2 frame = new VentanaLogIn2();
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
	public VentanaLogIn2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		VentanaRegistro2 vr = new VentanaRegistro2();
		VentanaMenuPrincipal2 vmp = new VentanaMenuPrincipal2(logInController, controller);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		panelNorte.add(lblLogIn);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 1, 0, 10));
		
		JButton btnIniciarSesion = new JButton("INICIAR SESIÓN");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(textFieldUsuario.getText() + textFieldContrasenya.getText());
//				logInController.loginLocal(textFieldUsuario.getText(), textFieldContrasenya.getText());
				JOptionPane.showMessageDialog(null,  "Usuario creado correctamente", "INICIO SESIÓN CORRECTO", JOptionPane.INFORMATION_MESSAGE);
//				System.out.println(logInController.getToken());
				textFieldUsuario.setText("");
				textFieldContrasenya.setText("");
				vmp.setVisible(true);
				setVisible(false);
			}
		});
		panelSur.add(btnIniciarSesion);
		
		JButton btnISGoogle = new JButton("INICIAR SESIÓN CON GOOGLE");
		panelSur.add(btnISGoogle);
		
		JButton btnISFaceBook = new JButton("INICIAR SESIÓN CON FACEBOOK");
		panelSur.add(btnISFaceBook);
		
		JButton btnRegistro = new JButton("REGISTRAR");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vr.setVisible(true);
				setVisible(false);
			}
		});
		panelSur.add(btnRegistro);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
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
