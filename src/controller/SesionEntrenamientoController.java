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
			return this.serviceLocator.getService().getSesiones();
		} catch (RemoteException e) {
			System.out.println("# Error obteniendo todas las sesiones: " + e);
			return null;
		}
	}
	
	public boolean crearSesionEntrenamiento(long token, SesionEntrenamientoDTO sesionDTO) {
		try {
			return this.serviceLocator.getService().crearSesionEntrenamiento(token, sesionDTO);
		} catch (RemoteException e) {
			System.out.println("# Error creando el reto: " + e);
		}
		return false;
		
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
