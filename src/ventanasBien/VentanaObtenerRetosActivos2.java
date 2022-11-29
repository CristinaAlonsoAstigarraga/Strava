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

import controller.LogInController;
import controller.RetoController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaObtenerRetosActivos2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFecha;

	private static LogInController logInController;
	private static RetoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaObtenerRetosActivos2 frame = new VentanaObtenerRetosActivos2(logInController, controller);
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
	public VentanaObtenerRetosActivos2(LogInController logIncontroller, RetoController controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
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
		
		JLabel lblTitulo = new JLabel("OBTENER INFORMACIÓN RETOS ACTIVOS");
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
		
		JButton btnBuscar = new JButton("BUSCAR");
		panelSur.add(btnBuscar);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
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






/*		
JPanel panelCentro = new JPanel();
contentPane.add(panelCentro, BorderLayout.CENTER);


JLabel lblNombreRetos = new JLabel("NOMBRE RETO:");
panelCentro.add(lblNombreRetos);

JComboBox comboBoxRetosAcitvos = new JComboBox();
panelCentro.add(comboBoxRetosAcitvos);


modelo = new DefaultTableModel();
tablaRetosActivos = new JTable(modelo);

modelo.addColumn("Usuario");
modelo.addColumn("Nombre");
modelo.addColumn("Fecha Ini");
modelo.addColumn("Fecha Fin");
modelo.addColumn("Distancia");
modelo.addColumn("Tiempo Objetivo");
modelo.addColumn("Deporte");
modelo.addColumn("Codigo");

scrollTabla = new JScrollPane(tablaRetosActivos);
scrollTabla.setVisible(true);

panelCentro.add(tablaRetosActivos);
}


public void cargarTablaRetosActivos(StravaAppService stravaService) {
tablaRetosActivos.removeAll();
try {
	List<RetoDTO> listaRetosDTO = stravaService.obtenerRetosActivos();

	for (int i = 0; i < listaRetosDTO.size(); i++) {
		//columna[0] = listaRetosDTO.get(i).getUsuario();
		columna[1] = listaRetosDTO.get(i).getNombre();
		columna[2] = listaRetosDTO.get(i).getFechaIni();
		columna[3] = listaRetosDTO.get(i).getFechaFin();
		columna[4] = listaRetosDTO.get(i).getDistancia();
		columna[5] = listaRetosDTO.get(i).getTiempoObjetivo();
		columna[6] = listaRetosDTO.get(i).getCodigo();
		columna[7] = listaRetosDTO.get(i).getCodigo();
		
		modelo.addRow(columna);// agregamos una fila a nuestro modelo de tabla
	}
} catch (Exception e) {
	System.out.println("No se puede rellenar la tabla");
	e.printStackTrace();
}

}
*/
