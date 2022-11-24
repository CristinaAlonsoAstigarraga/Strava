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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaMenuPrincipal2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuPrincipal2 frame = new VentanaMenuPrincipal2();
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
	public VentanaMenuPrincipal2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		VentanaCreacionManualEntrenamiento2 vcme = new VentanaCreacionManualEntrenamiento2();
		VentanaCreacionReto2 vcr = new VentanaCreacionReto2();
		VentanaObtenerRetosActivos2 vora = new VentanaObtenerRetosActivos2();
		VentanaAceptacionReto2 var = new VentanaAceptacionReto2();
		VentanaConsultaEstadoRetos2  vcer = new VentanaConsultaEstadoRetos2();
		VentanaVerRetos2 vr2 = new VentanaVerRetos2();
		
		
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
				vcme.setVisible(true);
				setVisible(false);
			}
		});
	
		panelCentro.add(btnCrearManual);
		
		JButton btnCrearReto = new JButton("CREAR RETO");
		btnCrearReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vcr.setVisible(true);
				setVisible(false);
			}
		});
		panelCentro.add(btnCrearReto);
		
		JButton btnInfoRetos = new JButton("INFORMACIÓN RETOS ACTIVOS");
		btnInfoRetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vora.setVisible(true);
				setVisible(false);
			}
		});
		panelCentro.add(btnInfoRetos);
		
		JButton btnAceptarReto = new JButton("ACEPTACIÓN RETO");
		btnAceptarReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var.setVisible(true);
				setVisible(false);
			}
		});
		panelCentro.add(btnAceptarReto);
		
		JButton btnEstadoRetos = new JButton("ESTADO RETOS");
		btnEstadoRetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vcer.setVisible(true);
				setVisible(false);
			}
		});
		panelCentro.add(btnEstadoRetos);
		
		JButton btnVerRetos = new JButton("VER RETOS");
		btnEstadoRetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vr2.setVisible(true);
				setVisible(false);
			}
		});
		panelCentro.add(btnVerRetos);

	}

}
