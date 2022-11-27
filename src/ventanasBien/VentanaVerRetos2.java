package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import clases.Reto;
import controller.LogInController;
import controller.RetoController;
import dto.RetoDTO;
//import services.StravaAppService;

//import services.StravaAppService;

public class VentanaVerRetos2 extends JFrame {

	private JPanel contentPane;
//	private List<Reto> retos = new ArrayList<>();
//	StravaAppService stravaService = new StravaAppService();
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private Object[] columna = new Object[7];
//	StravaAppService stravaService = new StravaAppService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerRetos2 frame = new VentanaVerRetos2();
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
	public VentanaVerRetos2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("VER TODOS LOS RETOS");
		panelNorte.add(lblTitulo);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		//String[] nombreColumnas = {"Nombre", "Fecha inicio", "Fecha final", "Distancia", "Tiempo objetivo", "Deporte", "Estado"};
		
		modeloTabla = new DefaultTableModel();
		tabla = new JTable(modeloTabla);
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Fecha inicio");
		modeloTabla.addColumn("Fecha final");
		modeloTabla.addColumn("Distancia");
		modeloTabla.addColumn("Tiempo objetivo");
		modeloTabla.addColumn("Deporte");
		modeloTabla.addColumn("Estado");
		
		
		panelCentro.add(tabla);

		
//		stravaService.getRetos();
	}
	
//	public void cargarRetosTabla(LogInController logInController, RetoController retoController) {
//		tabla.removeAll();
//		long token = 0;
//		
//		List<RetoDTO> listaRetos = retoController.getRetos(token);
//		
//		for (int i=0; i<listaRetos.size(); i++) {
//			columna[0] = listaRetos.get(i).getNombre();
//			columna[1] = listaRetos.get(i).getFechaIni();
//			columna[2] = listaRetos.get(i).getFechaFin();
//			columna[3] = listaRetos.get(i).getDistancia();
//			columna[4] = listaRetos.get(i).getTiempoObjetivo();
//			columna[5] = listaRetos.get(i).getDeporte();
//			columna[6] = listaRetos.get(i).getEstado();
//		}
//	}

}
