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

import com.toedter.calendar.JDateChooser;


import controller.RetoController;
import dto.RetoDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaCreacionReto2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JDateChooser jdcFechaIni;
	private JDateChooser jdcFechaFin;
	private JTextField textFieldDistancia;
	private JTextField textFieldTiempoObjetivo;
	private JComboBox comboBoxDeporte = new JComboBox<Deporte>();
	List<RetoDTO> listaRetosCreados = new ArrayList<RetoDTO>();
	private static RetoController controller;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacionReto2 frame = new VentanaCreacionReto2(controller);
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
	public VentanaCreacionReto2(RetoController cont) {
		controller = cont;
		setTitle("CREAR RETO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VentanaMenuPrincipal2 vmp = new VentanaMenuPrincipal2();
//				vmp.setVisible(true);
				setVisible(false);
			}
		});
		panelNorte.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("CREACIÓN DE UN RETO");
		panelNorte.add(lblTitulo);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				dispose();
			}
		});
		panelNorte.add(btnLogOut);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);	
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNombre.getText();
				Date fI = jdcFechaIni.getDate();
				Date fF = jdcFechaFin.getDate();
				double distancia = Double.parseDouble(textFieldDistancia.getText());
				double tO = Double.parseDouble(textFieldTiempoObjetivo.getText());
				Deporte deporte = (Deporte) comboBoxDeporte.getSelectedItem();
				controller.crearReto(nombre, fI, fF, distancia, tO, deporte);
			}
		});
		panelSur.add(btnCrear);
		
		JButton btnRetosCreados = new JButton("VER RETOS CREADOS");
		btnRetosCreados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> retos = new ArrayList<String>();
				retos = controller.getReto();
				System.out.println(retos);
			}
		});
		contentPane.add(btnRetosCreados);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JLabel lblNombre = new JLabel("NOMBRE: ");
		panelCentro.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panelCentro.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFechaIni = new JLabel("FECHA INICIO:");
		panelCentro.add(lblFechaIni);
		
		jdcFechaIni = new JDateChooser("dd-MM-yyyy", "##-##-####", '_');
		panelCentro.add(jdcFechaIni);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN:");
		panelCentro.add(lblFechaFin);
		
		jdcFechaFin = new JDateChooser("dd-MM-yyyy", "##-##-####", '_');
		panelCentro.add(jdcFechaFin);
		
		JLabel lblDistancia = new JLabel("DISTANCIA");
		panelCentro.add(lblDistancia);
		
		textFieldDistancia = new JTextField();
		panelCentro.add(textFieldDistancia);
		textFieldDistancia.setColumns(10);
		
		JLabel lblTiempoObjetivo = new JLabel("TIEMPO OBJETIVO");
		panelCentro.add(lblTiempoObjetivo);
		
		textFieldTiempoObjetivo = new JTextField();
		panelCentro.add(textFieldTiempoObjetivo);
		textFieldTiempoObjetivo.setColumns(10);
		
		JLabel lblDeporte = new JLabel("DEPORTE");
		panelCentro.add(lblDeporte);
		
		JComboBox comboBoxDeporte = new JComboBox<Deporte>();
		for(Deporte d : Deporte.values()) {
			comboBoxDeporte.addItem(d);
		}
		panelCentro.add(comboBoxDeporte);
		
		
	}

}
