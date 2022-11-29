package ventanasBien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LogInController;
import controller.RetoController;

public class VentanaLogInGoogle2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private static LogInController logInController;
	private static RetoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogInGoogle2 frame = new VentanaLogInGoogle2(logInController, controller);
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
	public VentanaLogInGoogle2(LogInController logInController, RetoController controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		VentanaRegistro2 vr = new VentanaRegistro2();
		VentanaMenuPrincipal2 mp = new VentanaMenuPrincipal2(logInController, controller);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		panelNorte.add(lblLogIn);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 0, 0, 10));
		
		JLabel lblEmail = new JLabel("EMAIL:");
		panelCentro.add(lblEmail);
		
		textFieldEmail = new JTextField();
		panelCentro.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 1, 0, 10));
		
		JButton btnISGoogle = new JButton("INICIAR SESIÓN CON GOOGLE");
		btnISGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean inicioG = logInController.loginGoogle(textFieldEmail.getText());
				if (inicioG==true) {
					JOptionPane.showMessageDialog(null, "Inicio de sesión realizado con éxito", "INICIO SESIÓN CORRECTO", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					mp.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,  "El usuario introducido no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelSur.add(btnISGoogle);
		
		JButton btnRegistro = new JButton("REGISTRAR");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vr.setVisible(true);
				setVisible(false);
			}
		});
		panelSur.add(btnRegistro);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
	}

}
