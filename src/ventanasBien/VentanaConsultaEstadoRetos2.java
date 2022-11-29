package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LogInController;
import controller.RetoController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConsultaEstadoRetos2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private static LogInController logInController;
	private static RetoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultaEstadoRetos2 frame = new VentanaConsultaEstadoRetos2(logInController, controller);
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
	public VentanaConsultaEstadoRetos2(LogInController logIncontroller, RetoController controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenuPrincipal2 vmp = new VentanaMenuPrincipal2(logIncontroller, controller);
				vmp.setVisible(true);
				setVisible(false);
			}
		});
		panelNorte.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("CONSULTAR ESTADOS RETOS ACEPTADOS");
		panelNorte.add(lblTitulo);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panelNorte.add(btnLogOut);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JLabel lblFecha = new JLabel("FECHA:");
		panelOeste.add(lblFecha);
		
		textField = new JTextField();
		textField.setColumns(10);
		panelOeste.add(textField);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"NOMBRE", "ESTADO", "DESCRIPCIÓN", "PORCENTAJE COMPLETADO"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"NOMBRE", "ESTADO", "DESCRIPCIÓN", "PORCENTAJE COMPLETADO"
			}
		));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCentro.add(table);
	}

}
