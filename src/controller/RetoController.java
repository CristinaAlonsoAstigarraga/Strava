package controller;

import remote.ServiceLocator;

import java.rmi.RemoteException;
import java.util.List;

//import clases.Reto;
//import clases.Reto;
import dto.RetoDTO;
import remote.IFachadaRemota;

public class RetoController {
	
	private ServiceLocator serviceLocator;
	
	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public List<RetoDTO> getRetos(long token){		//No lo hemos puesto en el diagrama, hay que ponerlo?

		try {
			return this.serviceLocator.getService().getRetos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("# Error obteniendo todos los retos: " + e);
			return null;
		}
		
	}	
	
	public boolean crearReto(long token, RetoDTO nuevoReto) {
		try {
			return this.serviceLocator.getService().crearReto(token, nuevoReto);
		} catch (RemoteException e) {
			System.out.println("# Error creando el reto: " + e);
		}
		return false;
	}

	public List<RetoDTO> obtenerRetosActivos(long token){
		try {
			return this.serviceLocator.getService().obtenerRetosActivos(token);
		} catch (RemoteException e) {
			System.out.println("# Error obteniendo los retos activos: " + e);
			return null;
		}
	}
	
	public boolean aceptarReto(long token, RetoDTO reto) {
		try {
			return this.serviceLocator.getService().aceptarReto(token, reto);
		} catch (RemoteException e) {
			System.out.println("# Error aceptando el reto: " + e);
			return false;
		}
	}
	
	//Falta consultarReto - lo hemos puesto en el diagrama
}
