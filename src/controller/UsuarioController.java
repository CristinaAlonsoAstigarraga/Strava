package controller;

import java.rmi.RemoteException;

import dto.UsuarioLocalDTO;
import remote.ServiceLocator;

public class UsuarioController {

	private ServiceLocator serviceLocator;
	
	public UsuarioController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public long registro(UsuarioLocalDTO usuario) {
		try {
			return this.serviceLocator.getService().registro(usuario);
		} catch (RemoteException e) {
			System.out.println("# Error en el registro: " + e);
			return 0;		//Qué tiene que devolver?
		}
	}
}
