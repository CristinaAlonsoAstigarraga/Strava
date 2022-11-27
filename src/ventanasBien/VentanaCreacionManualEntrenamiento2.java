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

import clases.Deporte;
import dto.DeporteDTO;
import dto.RetoDTO;
import dto.SesionEntrenamientoDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class VentanaCreacionManualEntrenamiento2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldDistancia;
	private JTextField textFieldFechaHoraInicio;
//	private JTextField textFieldFechaFin;
	private JTextField textFieldDuracion;
	private JComboBox comboBoxDeporte = new JComboBox<DeporteDTO>();
	List<SesionEntrenamientoDTO> listaSesionesCreadas = new ArrayList<SesionEntrenamientoDTO>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacionManualEntrenamiento2 frame = new VentanaCreacionManualEntrenamiento2();
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
	public VentanaCreacionManualEntrenamiento2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
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
		
		JLabel lblNewLabel = new JLabel("CREAR MANUAL SESIÓN ENTRENAMIENTO");
		panelNorte.add(lblNewLabel);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panelNorte.add(btnLogOut);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 10));
		
		JLabel lblTitulo = new JLabel("TITULO:");
		panelCentro.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		panelCentro.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel lblDeporte = new JLabel("DEPORTE");
		panelCentro.add(lblDeporte);
		
		JComboBox comboBoxDeporte = new JComboBox<DeporteDTO>();
		for(DeporteDTO d : DeporteDTO.values()) {
			comboBoxDeporte.addItem(d);
		}
		panelCentro.add(comboBoxDeporte);
		
		JLabel lblDistancia = new JLabel("DISTANCIA (km):");
		panelCentro.add(lblDistancia);
		
		textFieldDistancia = new JTextField();
		panelCentro.add(textFieldDistancia);
		textFieldDistancia.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("FECHA INICIO:");
		panelCentro.add(lblFechaInicio);
		
		textFieldFechaHoraInicio = new JTextField();
		panelCentro.add(textFieldFechaHoraInicio);
		textFieldFechaHoraInicio.setColumns(10);

		JLabel lblDuracion = new JLabel("DURACIÓN:");
		panelCentro.add(lblDuracion);
		
		textFieldDuracion = new JTextField();
		panelCentro.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String erFechas = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
//				String erDistancia = "[0-9]{3}.[0-9]{2}";
				SesionEntrenamientoDTO sesion = new SesionEntrenamientoDTO();
				//controller.crearsesion(0, sesion);	//En vez de 0, getToken
				
				sesion.setTitulo(textFieldTitulo.getText());
				boolean fechaCrrecta = Pattern.matches(erFechas, textFieldFechaHoraInicio.getText());
				if(!fechaCrrecta) {
					JOptionPane.showMessageDialog(null,  "La fecha de inicio no tiene un formato correcto", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					sesion.setsFechaYHoraIni(textFieldFechaHoraInicio.getText());
				}
				sesion.setDistancia(Float.parseFloat(textFieldDistancia.getText()));
				sesion.setDuracion(Float.parseFloat(textFieldDuracion.getText()));
//				sesion.setDeporte((Deporte) comboBoxDeporte.getSelectedItem());	//No coge el valor, da null
				JOptionPane.showMessageDialog(null,  "SESIÓN CREADA CORRECTAMENTE", "SESIÓN CREADA", JOptionPane.INFORMATION_MESSAGE);
				
				textFieldTitulo.setText("");
				textFieldFechaHoraInicio.setText("");
				textFieldDistancia.setText("");
				textFieldDuracion.setText("");
				listaSesionesCreadas.add(sesion);
//				System.out.println(listasesionsCreados);
			}
		});
		panelSur.add(btnCrear);
		
		JButton btnVerSesiones = new JButton("VER SESIONES CREADAS");
		btnVerSesiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info ="";
				int contador = 0;
				for(SesionEntrenamientoDTO sesion : listaSesionesCreadas) {
					contador++;
					info = info + "Sesión "+contador+" ["+sesion+"]\n";
				}
				JOptionPane.showMessageDialog(null,  "Listado sesiones creadas: \n"+info+"\n", "SESIONES CREADASS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panelSur.add(btnVerSesiones);
	}

}
