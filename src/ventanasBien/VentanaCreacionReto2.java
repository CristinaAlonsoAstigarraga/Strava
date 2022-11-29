package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LogInController;
import controller.RetoController;
//import clases.Deporte;
//import controller.LogInController;
import controller.RetoController;
import dto.DeporteDTO;
import dto.RetoDTO;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class VentanaCreacionReto2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldFechaIni;
	private JTextField textFieldFechaFin;
	private JTextField textFieldDistancia;
	private JTextField textFieldTiempoObjetivo;
	//private RetoController controller;
	private JComboBox comboBoxDeporte = new JComboBox<DeporteDTO>();
	List<RetoDTO> listaRetosCreados = new ArrayList<RetoDTO>();
	private static LogInController logInController;
	private static RetoController controller;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacionReto2 frame = new VentanaCreacionReto2(logInController, controller);
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
	public VentanaCreacionReto2(LogInController logIncontroller, RetoController controller) {
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
				VentanaMenuPrincipal2 vmp = new VentanaMenuPrincipal2(logIncontroller, controller);
				vmp.setVisible(true);
				setVisible(false);
			}
		});
		panelNorte.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("CREACIÓN DE UN RETO");
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
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JComboBox comboBoxDeporte = new JComboBox<DeporteDTO>();
		for(DeporteDTO d : DeporteDTO.values()) {
			comboBoxDeporte.addItem(d);
		}
		panelCentro.add(comboBoxDeporte);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String erFechas = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
//				String erDistancia = "[0-9]{3}.[0-9]{2}";
				RetoDTO reto = new RetoDTO();
							
				reto.setNombre(textFieldNombre.getText());
				boolean fechaCrrecta = Pattern.matches(erFechas, textFieldFechaIni.getText());
				if(!fechaCrrecta) {
					JOptionPane.showMessageDialog(null,  "La fecha de inicio no tiene un formato correcto", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					reto.setSfechaIni(textFieldFechaIni.getText());
				}
				if(!fechaCrrecta) {
					JOptionPane.showMessageDialog(null,  "La fecha de fin no tiene un formato correcto", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					reto.setSfechaFin(textFieldFechaFin.getText());
				}
				reto.setDistancia(Float.parseFloat(textFieldDistancia.getText()));
				reto.setTiempoObjetivo(Float.parseFloat(textFieldTiempoObjetivo.getText()));
				
				if(comboBoxDeporte.getSelectedItem()==DeporteDTO.CICLISMO) {
//					reto.setDeporte(DeporteDTO.CICLISMO);
				}
//				reto.setDeporte((Deporte) comboBoxDeporte.getSelectedItem());	//No coge el valor, da null
				
				
				JOptionPane.showMessageDialog(null,  "RETO CREADO CORRECTAMENTE", "RETO CREADO", JOptionPane.INFORMATION_MESSAGE);
				
				textFieldNombre.setText("");
				textFieldFechaIni.setText("");
				textFieldFechaFin.setText("");
				textFieldDistancia.setText("");
				textFieldTiempoObjetivo.setText("");
				listaRetosCreados.add(reto);
//				System.out.println(listaRetosCreados);
				
//				controller.crearReto(logIncontroller.getToken(), reto);
				controller.crearReto(-1, reto);	//Hay que poner la línea de arriba, pero de momento no hay token que coger porque no hay login
			}
		});
		panelSur.add(btnCrear);
		
		JButton btnRetosCreados = new JButton("VER RETOS CREADOS");
		btnRetosCreados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info ="";
				int contador = 0;
				for(RetoDTO reto : listaRetosCreados) {
					contador++;
					info = info + "Reto "+contador+" ["+reto+"]\n";
				}
				JOptionPane.showMessageDialog(null,  "Listado retos creados: \n"+info+"\n", "RETOS CREADOS", JOptionPane.INFORMATION_MESSAGE);
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
		
		textFieldFechaIni = new JTextField();
		panelCentro.add(textFieldFechaIni);
		textFieldFechaIni.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN:");
		panelCentro.add(lblFechaFin);
		
		textFieldFechaFin = new JTextField();
		panelCentro.add(textFieldFechaFin);
		textFieldFechaFin.setColumns(10);
		
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
		
		
	}

}
