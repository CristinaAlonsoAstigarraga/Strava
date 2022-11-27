package ventanasBien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import clases.Deporte;
import controller.LogInController;
import controller.RetoController;
import dto.DeporteDTO;
import dto.RetoDTO;
import dto.SesionEntrenamientoDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaAceptacionReto2 extends JFrame {

	private RetoController controller;
	private LogInController controllerL;
	private JPanel contentPane;
	private JTable tablaRetos;
	
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollTabla;
	
	private List<RetoDTO> retos = new ArrayList<>();
	private String datos[];

	
	public VentanaAceptacionReto2(RetoController controller) {
		this.controller = controller;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAceptacionReto2 frame = new VentanaAceptacionReto2();
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
	public VentanaAceptacionReto2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 700, 600);
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
		
		JLabel lblTitulo = new JLabel("ACEPTAR UN RETO");
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
		
		JButton btnAceptar = new JButton("ACEPTAR:");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.aceptarReto(controllerL.getToken(), controller);
				for(RetoDTO r : retos) {
					r.setEstado(true);
					modeloTabla.addRow(datos);
				}
			}
		});
		panelSur.add(btnAceptar);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JLabel lblDeporte = new JLabel("DEPORTE:");
		panelOeste.add(lblDeporte);
		
		JComboBox comboBoxDeporte = new JComboBox<DeporteDTO>();
		for(DeporteDTO d : DeporteDTO.values()) {
			comboBoxDeporte.addItem(d);
		}
		panelOeste.add(comboBoxDeporte);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		
		modeloTabla = new DefaultTableModel();
		String [] columnas = {"NOMBRE", "FECHA INICIO", "FECHA FIN", "DISTANCIA", "TIEMPO OBJETIVO", /*"DEPORTE", */"ESTADO" };
		modeloTabla.setColumnIdentifiers(columnas);
		modeloTabla.addRow(columnas);
		
		//Rellenamos la tabla
//		long token = 0;
		
		RetoDTO reto0 = new RetoDTO();
		//reto0.setUsuario(usuario0);
		//reto0.setSesionEntrenamiento(sesion0);
		reto0.setNombre("Gran Fondo");
		reto0.setFechaIni("13-02-2022");
		reto0.setFechaFin("21-03-2022");
		reto0.setDistancia(300);
		reto0.setTiempoObjetivo(90);
//		reto0.setDeporte(DeporteDTO.CICLISMO);
		reto0.setEstado(false);
		
		RetoDTO reto1 = new RetoDTO();
		//reto1.setUsuario(usuario1);
		//reto1.setSesionEntrenamiento(sesion1);
		reto1.setNombre("Carrera (resistencia)");
		reto1.setFechaIni("31-05-2022");
		reto1.setFechaFin("15-06-2022");
		reto1.setDistancia(2);
		reto1.setTiempoObjetivo(60);
//		reto1.setDeporte(DeporteDTO.RUNNING);
		reto1.setEstado(false);
		
		retos.add(reto0);
		retos.add(reto1);
		
		//Llamamos al Array con los retos
		for (RetoDTO r : retos) {
//			controller.getRetos(token);
			Object [] datos= {r.getNombre(), r.getFechaIni(), r.getFechaFin(), Float.toString(r.getDistancia()), Float.toString(r.getTiempoObjetivo()), /*r.getDeporte().toString(),*/ Boolean.toString(r.getEstado())};
			modeloTabla.addRow(datos);
		}
		
		tablaRetos = new JTable(modeloTabla);
		scrollTabla  = new JScrollPane(tablaRetos);
		scrollTabla.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollTabla.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		panelCentro.add(tablaRetos);
//		contentPane.add(tablaRetos);
		
		
		
		//Coloreamos la columna del estado en función del valor del estado -> true = verde, false = rojo
		tablaRetos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				// TODO Auto-generated method stub
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if(column == 5) {
					String estado = (String) modeloTabla.getValueAt(row, 5);
					if(estado == "true") {
						c.setBackground(Color.GREEN);
					}else if (estado == "false"){
						c.setBackground(Color.RED);
					}
				}else {
					c.setBackground(Color.WHITE);
				}
				
				
				return c;
			}
		});
		
	}
	
//	public boolean aceptarReto(RetoDTO reto) {
//		reto = tablaRetos.getSelectedRow();
//		return true;
//		
//	}
	
	public List<RetoDTO> getRetos() {
		for (int i=0;i<retos.size();i++) {
		      
		 System.out.println(retos.get(i));
		}
		return null;	//Hay que quitarlo
	}
	
//	public void aceptarReto() {
//		System.out.println(" - Aceptando reto...");		
//		this.controller.aceptarReto(ABORT, getName())
//		System.out.println("\t* Reto aceptado!");		
//
//	}

}
