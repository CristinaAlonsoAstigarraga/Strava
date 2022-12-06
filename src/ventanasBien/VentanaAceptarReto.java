package ventanasBien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LogInController;
import controller.RetoController;
import dto.RetoDTO;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaAceptarReto extends JFrame {

	private JPanel contentPane;
	
	private static LogInController logInController;
	private static RetoController controller;
	
	private JTable tablaRetos;
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollTabla;
	private List<RetoDTO> retos = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAceptarReto frame = new VentanaAceptarReto();
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
	public VentanaAceptarReto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenuPrincipal2 vmp = new VentanaMenuPrincipal2(logInController, controller);
				vmp.setVisible(true);
				setVisible(false);
				
			}
		});
		panelNorte.add(btnVolver);
		
		
		
		JLabel lblAceptarReto = new JLabel("Aceptar un reto");
		panelNorte.add(lblAceptarReto);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panelNorte.add(btnLogOut);
		
		
		
		JButton btnAceptarReto = new JButton("ACEPTAR RETO");
		btnAceptarReto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = tablaRetos.getSelectedRow();
				modeloTabla.setValueAt(true, fila, 5);
			}
		});
		panelNorte.add(btnAceptarReto);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro);
		
		modeloTabla = new DefaultTableModel();
		String [] titulos = {"NOMBRE", "FECHA INICIO", "FECHA FIN", "DISTANCIA", "TIEMPO OBJETIVO", "ESTADO"};
		modeloTabla.setColumnIdentifiers(titulos);
		
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
		reto3.setNombre("Carrera (resistencia)");
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
		
		for(RetoDTO r : retos) {
			String [] datos = {r.getNombre(), r.getSfechaIni(), r.getSfechaFin(), Float.toString(r.getDistancia()), Float.toString(r.getTiempoObjetivo()), /*r.getDeporte().toString(),*/ Boolean.toString(r.getEstado())};
			modeloTabla.addRow(datos);
		}
		tablaRetos = new JTable(modeloTabla);
		scrollTabla  = new JScrollPane(tablaRetos);
		tablaRetos.setBounds(100, 100, 450, 300);
		panelCentro.add(scrollTabla, BorderLayout.CENTER);
		
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}

}
