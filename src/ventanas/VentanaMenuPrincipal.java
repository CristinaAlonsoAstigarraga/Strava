package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class VentanaMenuPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuPrincipal window = new VentanaMenuPrincipal();
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
	public VentanaMenuPrincipal() {
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
		
		JLabel lblTitulo = new JLabel("STRAVA");
		panelNorte.add(lblTitulo);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelNorte.add(panel);
		
		JButton btnLogOut = new JButton("LOG OUT");
		panel.add(btnLogOut);
		
		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelOeste = new JPanel();
		frame.getContentPane().add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		frame.getContentPane().add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnCrearManual = new JButton("CREAR MANUAL SESIÓN ENTRENAMIENTO");
		panelCentro.add(btnCrearManual);
		
		JButton btnCrearReto = new JButton("CREAR RETO");
		panelCentro.add(btnCrearReto);
		
		JButton btnInfoRetos = new JButton("INFORMACIÓN RETOS ACTIVOS");
		panelCentro.add(btnInfoRetos);
		
		JButton btnAceptarReto = new JButton("ACEPTACIÓN RETO");
		panelCentro.add(btnAceptarReto);
		
		JButton btnEstadoRetos = new JButton("ESTADO RETOS");
		panelCentro.add(btnEstadoRetos);
	}

}
