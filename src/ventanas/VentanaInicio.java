package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
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
	public VentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte);
		panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblInicioStrava_1 = new JLabel("Inicio Strava");
		lblInicioStrava_1.setHorizontalAlignment(SwingConstants.TRAILING);
		panelNorte.add(lblInicioStrava_1);
		
		JButton btnLogOut = new JButton("Log Out");
		panelNorte.add(btnLogOut);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro);
		panelCentro.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnIniciarSesion = new JButton("Iniciar sesion");
		panelCentro.add(btnIniciarSesion);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		panelCentro.add(btnRegistrarse);
	}

}
