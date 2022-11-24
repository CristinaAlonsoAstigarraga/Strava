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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCreacionManualEntrenamiento2 extends JFrame {

	private JPanel contentPane;
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
					VentanaCreacionManualEntrenamiento2 frame = new VentanaCreacionManualEntrenamiento2();
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
	public VentanaCreacionManualEntrenamiento2() {
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
				VentanaMenuPrincipal2 vmp = new VentanaMenuPrincipal2();
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
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnCrear = new JButton("CREAR");
		panelSur.add(btnCrear);
		
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
