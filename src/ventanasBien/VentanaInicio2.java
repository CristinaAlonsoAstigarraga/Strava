package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.LogInController;
import remote.ServiceLocator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private LogInController logInController;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaInicio2 frame = new VentanaInicio2(serviceLocator);
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
	public VentanaInicio2(ServiceLocator servicelocator) {
		logInController = new LogInController(servicelocator);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblInicioStrava_1 = new JLabel("AppStrava");
		lblInicioStrava_1.setHorizontalAlignment(SwingConstants.TRAILING);
		panelNorte.add(lblInicioStrava_1);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro);
		panelCentro.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						try {
							VentanaLogIn2 vLI = new VentanaLogIn2(servicelocator);
							vLI.setVisible(true);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						
					}
				});
			}
		});
		panelCentro.add(btnIniciarSesion);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
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
		panelCentro.add(btnRegistrarse);
	}

}
