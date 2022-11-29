package main;

import controller.LogInController;
import controller.RetoController;
import controller.SesionEntrenamientoController;
import controller.UsuarioController;
import remote.ServiceLocator;
//import services.StravaAppService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServiceLocator serviceLocator = new ServiceLocator();
		
		LogInController logInController = new LogInController(serviceLocator);
		RetoController retoController = new RetoController(serviceLocator);
		SesionEntrenamientoController sesionEntrenamientoController = new SesionEntrenamientoController(serviceLocator);
		UsuarioController usuarioController = new UsuarioController(serviceLocator);
		
		
		//Solo podemos acceder a IFachadaRemota.
	}

}
