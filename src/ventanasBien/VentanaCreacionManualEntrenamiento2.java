package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import controller.LogInController;
import controller.SesionEntrenamientoController;
import dto.SesionEntrenamientoDTO;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaCreacionManualEntrenamiento2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldDistancia;
	private JTextField textFieldFechaHoraInicio;
	private static LogInController logInController;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private JTextField textFieldDuracion;
	private JComboBox comboBoxDeporte = new JComboBox<Deporte>();
	List<SesionEntrenamientoDTO> listaSesionesCreadas = new ArrayList<SesionEntrenamientoDTO>();
	
	private static SesionEntrenamientoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacionManualEntrenamiento2 frame = new VentanaCreacionManualEntrenamiento2(controller);
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
	public VentanaCreacionManualEntrenamiento2(SesionEntrenamientoController cont) {
		controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenuPrincipal2 vmp = new VentanaMenuPrincipal2(logInController);
				vmp.setVisible(true);
				setVisible(false);
			}
		});
		panelNorte.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("CREAR MANUAL SESIÓN ENTRENAMIENTO");
		panelNorte.add(lblNewLabel);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panelNorte.add(btnLogOut);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 10));
		
		JLabel lblTitulo = new JLabel("TITULO:");
		panelCentro.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		panelCentro.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel lblDeporte = new JLabel("DEPORTE");
		panelCentro.add(lblDeporte);
		
		JComboBox comboBoxDeporte = new JComboBox<Deporte>();
		for(Deporte d : Deporte.values()) {
			comboBoxDeporte.addItem(d);
		}
		panelCentro.add(comboBoxDeporte);
		
		JLabel lblDistancia = new JLabel("DISTANCIA (km):");
		panelCentro.add(lblDistancia);
		
		textFieldDistancia = new JTextField();
		panelCentro.add(textFieldDistancia);
		textFieldDistancia.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("FECHA INICIO:");
		panelCentro.add(lblFechaInicio);
		
		textFieldFechaHoraInicio = new JTextField();
		panelCentro.add(textFieldFechaHoraInicio);
		textFieldFechaHoraInicio.setColumns(10);

		JLabel lblDuracion = new JLabel("DURACIÓN:");
		panelCentro.add(lblDuracion);
		
		textFieldDuracion = new JTextField();
		panelCentro.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fyh = new Date();
				try {
					String sFecha = textFieldFechaHoraInicio.getSelectedText();
					fyh = sdf.parse(sFecha);
				} catch (Exception e2) {
					System.out.println("Error al convertir la fecha: " + e2);
				}
				String titulo = textFieldTitulo.getText();
				Deporte deporte = (Deporte) comboBoxDeporte.getSelectedItem();
				double distancia = Double.parseDouble(textFieldDistancia.getText());
				double duracion = Double.parseDouble(textFieldDuracion.getText());
				
				controller.crearSesion(titulo, deporte, distancia, fyh, duracion);
			}
		});
		panelSur.add(btnCrear);
		
		JButton btnVerSesiones = new JButton("VER SESIONES CREADAS");
		btnVerSesiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> sesiones = new ArrayList<String>();
				sesiones = controller.getSesiones();
				System.out.println(sesiones);
			}
		});
		panelSur.add(btnVerSesiones);
	}

}
