package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import clases.Reto;
import controller.LogInController;
import controller.RetoController;
import dto.RetoDTO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import services.StravaAppService;

//import services.StravaAppService;

public class VentanaVerRetos2 extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private Object[] columna = new Object[7];
	private JScrollPane scrollTabla;
	private static RetoController controller;
	private static LogInController logInController;
	private List<RetoDTO> retos = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerRetos2 frame = new VentanaVerRetos2(logInController, controller);
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
	public VentanaVerRetos2(LogInController logInController, RetoController controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenuPrincipal2 vmp = new VentanaMenuPrincipal2(null, controller);
				vmp.setVisible(true);
				setVisible(false);
			}
		});
		panelNorte.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("VER TODOS LOS RETOS");
		panelNorte.add(lblTitulo);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		
		modeloTabla = new DefaultTableModel();
		//Añadimos la fila de titulos
		String [] titulos = {"NOMBRE", "FECHA INICIO", "FECHA FIN", "DISTANCIA", "TIEMPO OBJETIVO", /*"DEPORTE", */"ESTADO" };
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
		reto1.setEstado(false);
		
		retos.add(reto0);
		retos.add(reto1);
		
		//Rellenamos el modelo con los datos de los retos
//		ArrayList<RetoDTO> retos = controller.getRetos(0); 
		for(RetoDTO r: retos) { //Recorro cada Persona del ArrayList
			String [] datos = {r.getNombre(), r.getSfechaIni(), r.getSfechaFin(), Float.toString(r.getDistancia()), Float.toString(r.getTiempoObjetivo()), /*r.getDeporte().toString(),*/ Boolean.toString(r.getEstado())};
			modeloTabla.addRow(datos); //Añadimos al modelo de la tabla la persona
		}
		//Le asignamos el modelo a la JTable
		tabla = new JTable(modeloTabla);
		scrollTabla  = new JScrollPane(tabla);
		tabla.setBounds(100, 100, 450, 300);
		//Añadir el scrollHorizontal
		//scrollTabla.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollTabla.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTabla.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTabla.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//Añado al panel el scroll que contiene la tabla
		contentPane.add(scrollTabla, BorderLayout.CENTER);
	}

}
