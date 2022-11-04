package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VentanaCreacionManualEntrenamiento {

	private JFrame frame;
	private JTextField textFieldTitulo;
	private JTextField textFieldDistancia;
	private JTextField textFieldFechaInicio;
	private JTextField textFieldFechaFin;
	private JTextField textFieldDuracion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacionManualEntrenamiento window = new VentanaCreacionManualEntrenamiento();
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
	public VentanaCreacionManualEntrenamiento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 675, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorte = new JPanel();
		frame.getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JButton btnVolver = new JButton("VOLVER");
		panelNorte.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("CREAR MANUAL SESIÓN ENTRENAMIENTO");
		panelNorte.add(lblNewLabel);
		
		JButton btnLogOut = new JButton("LOG OUT");
		panelNorte.add(btnLogOut);
		
		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnCrear = new JButton("CREAR");
		panelSur.add(btnCrear);
		
		JPanel panelOeste = new JPanel();
		frame.getContentPane().add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		frame.getContentPane().add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 10));
		
		JLabel lblTitulo = new JLabel("TITULO:");
		panelCentro.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		panelCentro.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel lblDeporte = new JLabel("DEPORTE");
		panelCentro.add(lblDeporte);
		
		JComboBox comboBoxDeporte = new JComboBox();
		panelCentro.add(comboBoxDeporte);
		
		JLabel lblDistancia = new JLabel("DISTANCIA (km):");
		panelCentro.add(lblDistancia);
		
		textFieldDistancia = new JTextField();
		panelCentro.add(textFieldDistancia);
		textFieldDistancia.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("FECHA INICIO:");
		panelCentro.add(lblFechaInicio);
		
		textFieldFechaInicio = new JTextField();
		panelCentro.add(textFieldFechaInicio);
		textFieldFechaInicio.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN:");
		panelCentro.add(lblFechaFin);
		
		textFieldFechaFin = new JTextField();
		panelCentro.add(textFieldFechaFin);
		textFieldFechaFin.setColumns(10);
		
		JLabel lblDuracion = new JLabel("DURACIÓN:");
		panelCentro.add(lblDuracion);
		
		textFieldDuracion = new JTextField();
		panelCentro.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
	}

}
