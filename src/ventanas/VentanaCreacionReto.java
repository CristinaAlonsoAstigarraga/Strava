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

public class VentanaCreacionReto {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldFechaIni;
	private JTextField textFieldFechaFin;
	private JTextField textFieldDistancia;
	private JTextField textFieldTiempoObjetivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacionReto window = new VentanaCreacionReto();
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
	public VentanaCreacionReto() {
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
		
		JButton btnVolver = new JButton("VOLVER");
		panelNorte.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("CREACIÓN DE UN RETO");
		panelNorte.add(lblTitulo);
		
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
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("NOMBRE: ");
		panelCentro.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panelCentro.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFechaIni = new JLabel("FECHA INICIO:");
		panelCentro.add(lblFechaIni);
		
		textFieldFechaIni = new JTextField();
		panelCentro.add(textFieldFechaIni);
		textFieldFechaIni.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN:");
		panelCentro.add(lblFechaFin);
		
		textFieldFechaFin = new JTextField();
		panelCentro.add(textFieldFechaFin);
		textFieldFechaFin.setColumns(10);
		
		JLabel lblDistancia = new JLabel("DISTANCIA");
		panelCentro.add(lblDistancia);
		
		textFieldDistancia = new JTextField();
		panelCentro.add(textFieldDistancia);
		textFieldDistancia.setColumns(10);
		
		JLabel lblTiempoObjetivo = new JLabel("TIEMPO OBJETIVO");
		panelCentro.add(lblTiempoObjetivo);
		
		textFieldTiempoObjetivo = new JTextField();
		panelCentro.add(textFieldTiempoObjetivo);
		textFieldTiempoObjetivo.setColumns(10);
		
		JLabel lblDeporte = new JLabel("DEPORTE");
		panelCentro.add(lblDeporte);
		
		JComboBox comboBoxDeporte = new JComboBox();
		panelCentro.add(comboBoxDeporte);
	}

}
