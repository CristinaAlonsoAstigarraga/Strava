package main;

import java.awt.EventQueue;

import controller.LogInController;
import controller.RetoController;
import controller.SesionEntrenamientoController;
import controller.UsuarioController;
import remote.ServiceLocator;
//import services.StravaAppService;
import ventanasBien.VentanaInicio2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServiceLocator serviceLocator = new ServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		LogInController logInController = new LogInController(serviceLocator);
		RetoController retoController = new RetoController(serviceLocator);
		SesionEntrenamientoController sesionEntrenamientoController = new SesionEntrenamientoController(serviceLocator);
		UsuarioController usuarioController = new UsuarioController(serviceLocator);
		
		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					VentanaInicio2 frame = new VentanaInicio2();

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});
		
		
		//Solo podemos acceder a IFachadaRemota.
	}

}
