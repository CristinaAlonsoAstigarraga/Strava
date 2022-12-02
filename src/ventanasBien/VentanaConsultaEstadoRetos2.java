package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LogInController;
import controller.RetoController;
import dto.RetoDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaConsultaEstadoRetos2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modeloTable;
	private JScrollPane scrollTable;
	private JTextField textField;
	private static LogInController logInController;
	private static RetoController controller;
	private List<RetoDTO> retos = new ArrayList<>();
	
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
		
		
		
		modeloTable = new DefaultTableModel();
		//titulos de la tabla
		String [] titulos = {"NOMBRE", "ESTADO", "DESCRIPCIÓN", "PORCENTAJE COMPLETADO"};
		modeloTable.setColumnIdentifiers(titulos);
		
		//añadir retos a una lista
		RetoDTO reto0 = new RetoDTO();
		//reto0.setUsuario(usuario0);
		//reto0.setSesionEntrenamiento(sesion0);
		reto0.setNombre("Gran Fondo");
		reto0.setSfechaIni("13-02-2022");
		reto0.setSfechaFin("21-03-2022");
		reto0.setDistancia(300);
		reto0.setTiempoObjetivo(90);
//		reto0.setDeporte(DeporteDTO.CICLISMO);
		reto0.setEstado(false);
		
		RetoDTO reto1 = new RetoDTO();
		//reto1.setUsuario(usuario1);
		//reto1.setSesionEntrenamiento(sesion1);
		reto1.setNombre("Carrera (resistencia)");
		reto1.setSfechaIni("31-05-2022");
		reto1.setSfechaFin("15-06-2022");
		reto1.setDistancia(2);
		reto1.setTiempoObjetivo(60);
//		reto1.setDeporte(DeporteDTO.RUNNING);
		reto1.setEstado(true);
		
		RetoDTO reto2 = new RetoDTO();
		//reto2.setUsuario(usuario1);
		//reto2.setSesionEntrenamiento(sesion1);
		reto2.setNombre("Carrera (resistencia)");
		reto2.setSfechaIni("31-05-2022");
		reto2.setSfechaFin("15-06-2022");
		reto2.setDistancia(2);
		reto2.setTiempoObjetivo(60);
//		reto2.setDeporte(DeporteDTO.RUNNING);
		reto2.setEstado(false);
		
		RetoDTO reto3 = new RetoDTO();
		//reto3.setUsuario(usuario1);
		//reto3.setSesionEntrenamiento(sesion1);
		reto3.setNombre("100 metros");
		reto3.setSfechaIni("31-05-2022");
		reto3.setSfechaFin("15-06-2022");
		reto3.setDistancia(2);
		reto3.setTiempoObjetivo(60);
//		reto3.setDeporte(DeporteDTO.RUNNING);
		reto3.setEstado(true);
		
		retos.add(reto0);
		retos.add(reto1);
		retos.add(reto2);
		retos.add(reto3);
		
		
		for(RetoDTO r: retos) {
			if(r.getEstado() == true) {
				//"NOMBRE", "ESTADO", "DESCRIPCIÓN", "PORCENTAJE COMPLETADO"
				String [] datos = {r.getNombre(), Boolean.toString(r.getEstado())};
				modeloTable.addRow(datos); //Añadimos al modelo de la tabla la persona
			}
			
		}
		
		
		table = new JTable(modeloTable);
		scrollTable  = new JScrollPane(table);
		table.setBounds(100, 100, 450, 300);
		
		//scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//Añado al panel el scroll que contiene la tabla
		contentPane.add(scrollTable, BorderLayout.CENTER);
		
		
		/*
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
		*/
		//table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		//panelCentro.add(table);
	}

}
