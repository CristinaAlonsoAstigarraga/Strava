package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LogInController;
import controller.RetoController;
import remote.ServiceLocator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaLogIn2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField txtContrasenia;
	private LogInController logInController;
	
	//NECESARI0?
	private RetoController retoController;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaLogIn2 frame = new VentanaLogIn2(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaLogIn2(ServiceLocator servicelocator) {
		logInController = new LogInController(servicelocator);
		
		System.out.println(servicelocator);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		panelNorte.add(lblLogIn);
		
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
		
		txtContrasenia = new JPasswordField();
		panelCentro.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 1, 0, 10));
		
		JButton btnIniciarSesion = new JButton("INICIAR SESIÓN");
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = textFieldUsuario.getText();
				String contrasena = txtContrasenia.getText(); 
				if(logInController.login(email, contrasena)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								VentanaMenuPrincipal2 vM = new VentanaMenuPrincipal2(logInController);
								vM.setVisible(true);
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
					});
				}else {
					System.out.println("Error durante loginLocal!");
				}
			}
		});
		panelSur.add(btnIniciarSesion);
		
//		JButton btnLoginGoogle = new JButton("INICIAR SESIÓN CON GOOGLE");
//		btnLoginGoogle.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String email = textFieldUsuario.getText();
//				if(logInController.loginGoogle(email)) {
//					EventQueue.invokeLater(new Runnable() {
//						public void run() {
//							try {
//								VentanaMenuPrincipal2 vM = new VentanaMenuPrincipal2(logInController, null);
//								vM.setVisible(true);
//							} catch (Exception e2) {
//								e2.printStackTrace();
//							}
//						}
//					});
//				}else {
//					System.out.println("Error durante loginGoogle!");
//				}
//			}
//		});
//		panelSur.add(btnLoginGoogle);
//		
//		JButton btnLoginFaceBook = new JButton("INICIAR SESIÓN CON FACEBOOK");
//		btnLoginFaceBook.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String email = textFieldUsuario.getText();
//				if(logInController.loginFacebook(email)) {
//					EventQueue.invokeLater(new Runnable() {
//						@Override
//						public void run() {
//							try {
//								VentanaMenuPrincipal2 vM = new VentanaMenuPrincipal2(logInController, null);
//								vM.setVisible(true);
//							} catch (Exception e2) {
//								e2.printStackTrace();
//							}
//							
//						}
//					});
//				}else {
//					System.out.println("Error durante loginFacebook!");
//				}
//			}
//		});
//		panelSur.add(btnLoginFaceBook);
	
		JButton btnRegistro = new JButton("REGISTRAR");
		btnRegistro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaRegistro2 vR = new VentanaRegistro2(logInController);
							vR.setVisible(true);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				});
			}
		});
		panelSur.add(btnRegistro);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelSur.add(btnSalir);
	}
}
