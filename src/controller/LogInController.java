package controller;

import java.rmi.RemoteException;

import dto.UsuarioLocalDTO;
import remote.ServiceLocator;

public class LogInController {
	
	private ServiceLocator serviceLocator;
	
	//si el login no se hace bien se genera un token con -1 (numero no valido para token)
	private long token = -1; 
	
	public LogInController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	public boolean login(UsuarioLocalDTO usuario) {
		try {
			this.token = this.serviceLocator.getService().login(usuario);			
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	public void logout() {
		try {
			this.serviceLocator.getService().logout(this.token);
			this.token = -1;
		} catch (RemoteException e) {
			System.out.println("# Error during logout: " + e);
		}
	}
	
	public long getToken() {
		return token;
	}

}
