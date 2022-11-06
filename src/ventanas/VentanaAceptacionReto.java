package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaAceptacionReto {

	private JFrame frame;
	private JTable tableRetos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAceptacionReto window = new VentanaAceptacionReto();
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
	public VentanaAceptacionReto() {
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
		
		JLabel lblTitulo = new JLabel("ACEPTAR UN RETO");
		panelNorte.add(lblTitulo);
		
		JButton btnLogOut = new JButton("LOG OUT");
		panelNorte.add(btnLogOut);
		
		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("ACEPTAR:");
		panelSur.add(btnAceptar);
		
		JPanel panelOeste = new JPanel();
		frame.getContentPane().add(panelOeste, BorderLayout.WEST);
		
		JLabel lblDeporte = new JLabel("DEPORTE:");
		panelOeste.add(lblDeporte);
		
		JComboBox comboBoxDeporte = new JComboBox();
		panelOeste.add(comboBoxDeporte);
		
		JPanel panelEste = new JPanel();
		frame.getContentPane().add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		tableRetos = new JTable();
		tableRetos.setModel(new DefaultTableModel(
			new Object[][] {
				{"NOMBRE", "DESCRIPCIÓN"},
				{null, null},
				{null, null},
			},
			new String[] {
				"NOMBRE", "DESCRIPCIÓN"
			}
		));
		panelCentro.add(tableRetos);
	}

}
