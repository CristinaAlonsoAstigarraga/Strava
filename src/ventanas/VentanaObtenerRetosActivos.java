package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridLayout;

public class VentanaObtenerRetosActivos {

	private JFrame frame;
	private JTextField textFieldFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaObtenerRetosActivos window = new VentanaObtenerRetosActivos();
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
	public VentanaObtenerRetosActivos() {
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
		
		JLabel lblTitulo = new JLabel("OBTENER INFORMACIÓN RETOS ACTIVOS");
		panelNorte.add(lblTitulo);
		
		JButton btnLogOut = new JButton("LOG OUT");
		panelNorte.add(btnLogOut);
		
		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnBuscar = new JButton("BUSCAR");
		panelSur.add(btnBuscar);
		
		JPanel panelOeste = new JPanel();
		frame.getContentPane().add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		frame.getContentPane().add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 10));
		
		JLabel lblFecha = new JLabel("FECHA:");
		panelCentro.add(lblFecha);
		
		textFieldFecha = new JTextField();
		panelCentro.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel lblNombreRetos = new JLabel("NOMBRE RETO:");
		panelCentro.add(lblNombreRetos);
		
		JComboBox comboBoxRetosAcitvos = new JComboBox();
		panelCentro.add(comboBoxRetosAcitvos);
	}

}
