package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

//import clases.UsuarioTipo;
import controller.LogInController;
import dto.UsuarioLocalDTO;
import remote.ServiceLocator;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaRegistro2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textFieldNombre, textFieldEmail, textFieldPeso, textFieldAltura, textFieldFCM, 
						textFieldFCR, textFieldContrasena;
	private JComboBox comboBoxTipo;
	private LogInController logincontoller;
	private JDateChooser jdcFechaNac;
	
	
	List<UsuarioLocalDTO> listaUsuarios = new ArrayList<UsuarioLocalDTO>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro2 frame = new VentanaRegistro2(null);
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
	public VentanaRegistro2(LogInController logInController) {
//		logincontoller = new LogInController(servicelocator);
		logincontoller = logInController;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		contentPane.add(lblRegistro);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEmail = new JLabel("EMAIL: ");
		panelCentro.add(lblEmail);
		
		textFieldEmail = new JTextField();
		panelCentro.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewContrasena = new JLabel("CONTRASEÑA");
		panelCentro.add(lblNewContrasena);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setText("");
		panelCentro.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		panelCentro.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panelCentro.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("FECHA NACIMIENTO");
		panelCentro.add(lblFechaNac);
		
		jdcFechaNac = new JDateChooser("dd-MM-yyyy", "##-##-####", '_');
		panelCentro.add(jdcFechaNac);
		
		JLabel lblPeso = new JLabel("PESO:");
		panelCentro.add(lblPeso);
		
		textFieldPeso = new JTextField();
		panelCentro.add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("ALTURA:");
		panelCentro.add(lblAltura);
		
		textFieldAltura = new JTextField();
		panelCentro.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblFCM = new JLabel("FRECUENCIA CARDIACA MAXIMA:");
		panelCentro.add(lblFCM);
		
		textFieldFCM = new JTextField();
		panelCentro.add(textFieldFCM);
		textFieldFCM.setColumns(10);
		
		JLabel lblFCR = new JLabel("FRECUENCIA CARDIACA REPOSO:");
		panelCentro.add(lblFCR);
		
		textFieldFCR = new JTextField();
		panelCentro.add(textFieldFCR);
		textFieldFCR.setColumns(10);
		
		JLabel lblProveedor = new JLabel("PROVEEDOR");
		panelCentro.add(lblProveedor);
		
		comboBoxTipo = new JComboBox<>();
		String[] s = new String[UsuarioTipo.values().length];
		int i = 0;
		for(UsuarioTipo ut : UsuarioTipo.values()) {
			s[i++] = ut.toString();
		}
		comboBoxTipo.setModel(new DefaultComboBoxModel<>(s));
		panelCentro.add(comboBoxTipo);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textFieldEmail.getText();
				String contrasena = textFieldContrasena.getText();
				String nombre = textFieldNombre.getText();
				Date fNac = jdcFechaNac.getDate();
				double peso = Double.parseDouble(textFieldPeso.getText());
				double altura = Double.parseDouble(textFieldAltura.getText());
				double fcm = Double.parseDouble(textFieldFCM.getText());
				double fcr = Double.parseDouble(textFieldFCR.getText());
				int proveedor = comboBoxTipo.getSelectedIndex();
				
				logincontoller.registro(nombre, email, contrasena, fNac, peso, altura, fcm, fcr, proveedor);
			}
		});
		panelSur.add(btnRegistrar);
		
		JButton btnverUsuarios = new JButton("VER USUARIOS");
		btnverUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String info ="";
//				int contador = 0;
//				for(UsuarioLocalDTO usuario : listaUsuarios) {
//					contador++;
//					info = info + "Usuario "+contador+" ["+usuario+"]\n";
//					System.out.println(listaUsuarios);
//				
//				}
//				JOptionPane.showMessageDialog(null,  "Usuarios creados: \n"+info+"\n", "USUARIOS CREADOS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		contentPane.add(btnverUsuarios);
		
//		JButton btnRegistroGoogle = new JButton("REGISTRO GOOGLE");
//		btnRegistroGoogle.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String email = textFieldEmail.getText();
//				String nombre = textFieldNombre.getText();
//				Date fNac = jdcFechaNac.getDate();
//				double peso = Double.parseDouble(textFieldPeso.getText());
//				double altura = Double.parseDouble(textFieldAltura.getText());
//				double fcm = Double.parseDouble(textFieldFCM.getText());
//				double fcr = Double.parseDouble(textFieldFCR.getText());
//				
//				logincontoller.registroGoogle(nombre, email, fNac, peso, altura, fcm, fcr);
//				
//			}
//		});
//		panelSur.add(btnRegistroGoogle);
//		
//		JButton btnRegistroFB = new JButton("REGISTRO FACEBOOK");
//		btnRegistroFB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String email = textFieldEmail.getText();
//				String nombre = textFieldNombre.getText();
//				Date fNac = jdcFechaNac.getDate();
//				double peso = Double.parseDouble(textFieldPeso.getText());
//				double altura = Double.parseDouble(textFieldAltura.getText());
//				double fcm = Double.parseDouble(textFieldFCM.getText());
//				double fcr = Double.parseDouble(textFieldFCR.getText());
//				
//				logincontoller.registroFacebook(nombre, email, fNac, peso, altura, fcm, fcr);
//			}
//		});
//		panelSur.add(btnRegistroFB);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
	}

}