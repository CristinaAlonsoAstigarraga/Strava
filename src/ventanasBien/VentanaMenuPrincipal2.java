package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controller.LogInController;
import controller.RetoController;
import controller.SesionEntrenamientoController;
import dto.UsuarioLocalDTO;

public class VentanaMenuPrincipal2 extends JFrame {

	private JPanel contentPane;
	private static LogInController logInController;
	private static RetoController retoController;
	private static SesionEntrenamientoController sesionEntrenamientoController;
	protected int respuesta;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaMenuPrincipal2 frame = new VentanaMenuPrincipal2(logInController);
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
	public VentanaMenuPrincipal2(LogInController logInContro) {
		logInController = logInContro;
		retoController = new RetoController(logInContro.getServiceLocator(), logInController.getToken());
		sesionEntrenamientoController = new SesionEntrenamientoController(logInContro.getServiceLocator(), logInController.getToken());
		setTitle("MENÚ PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
//		VentanaCreacionManualEntrenamiento2 vcme = new VentanaCreacionManualEntrenamiento2(logIncontroller, controller);
//		VentanaCreacionReto2 vcr = new VentanaCreacionReto2(logIncontroller, controller);
//		VentanaObtenerRetosActivos2 vora = new VentanaObtenerRetosActivos2(logIncontroller, controller);
//
//		VentanaConsultaEstadoRetos2  vcer = new VentanaConsultaEstadoRetos2(logIncontroller, controller);
//		VentanaVerRetos2 vr2 = new VentanaVerRetos2(logIncontroller, controller);
//		
//		VentanaAceptarReto var2 = new VentanaAceptarReto();
		
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("STRAVA");
		panelNorte.add(lblTitulo);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelNorte.add(panel);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel.add(btnLogOut);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnCrearManual = new JButton("CREAR MANUAL SESIÓN ENTRENAMIENTO");
		btnCrearManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaCreacionManualEntrenamiento2 vcme = new VentanaCreacionManualEntrenamiento2(sesionEntrenamientoController);
							vcme.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	
		panelCentro.add(btnCrearManual);
		
		JButton btnCrearReto = new JButton("CREAR RETO");
		btnCrearReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaCreacionReto2 vcr = new VentanaCreacionReto2(retoController);
							vcr.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panelCentro.add(btnCrearReto);
		
		JButton btnInfoRetos = new JButton("INFORMACIÓN RETOS ACTIVOS");
		btnInfoRetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaConsultaEstadoRetos2 vcer = new VentanaConsultaEstadoRetos2(retoController);
							vcer.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panelCentro.add(btnInfoRetos);
		
		JButton btnAceptarReto = new JButton("ACEPTACIÓN RETO");
		btnAceptarReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaAceptarReto var = new VentanaAceptarReto(retoController);
							var.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panelCentro.add(btnAceptarReto);
		
		//Estado de los retos activos
		JButton btnEstadoRetos = new JButton("ESTADO RETOS");
		btnEstadoRetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaObtenerRetosActivos2 vora = new VentanaObtenerRetosActivos2(retoController);
							vora.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panelCentro.add(btnEstadoRetos);
		
		JButton btnVerRetos = new JButton("VER RETOS");
		btnVerRetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaVerRetos2 vcer = new VentanaVerRetos2(retoController);
							vcer.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panelCentro.add(btnVerRetos);
		
	}

}
