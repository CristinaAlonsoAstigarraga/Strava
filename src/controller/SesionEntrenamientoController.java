package controller;

import java.rmi.RemoteException;
import java.security.Provider.Service;
import java.util.List;

//import clases.SesionEntrenamiento;
import dto.SesionEntrenamientoDTO;
import remote.ServiceLocator;

public class SesionEntrenamientoController {

	private ServiceLocator serviceLocator;
	
	public SesionEntrenamientoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public List<SesionEntrenamientoDTO> getSesiones(long token){
		try {
			return this.serviceLocator.getService().getSesiones(token);
		} catch (RemoteException e) {
			System.out.println("# Error obteniendo todas las sesiones: " + e);
			return null;
		}
	}
	
//	public SesionEntrenamiento crearSesionEntrenamiento(long token, SesionEntrenamientoDTO nuevaSesion) {
//		try {
//			return this.serviceLocator.getService().crearSesionEntrenamiento(token, nuevaSesion);
//		} catch (RemoteException e) {
//			System.out.println("# Error creando la sesión de entrenamiento: " + e);
//			return null;
//		}
//	}
}
