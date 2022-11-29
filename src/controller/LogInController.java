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
//	public boolean login(UsuarioLocalDTO usuario) {
//		try {
//			this.token = this.serviceLocator.getService().login(usuario);			
//			return true;
//		} catch (RemoteException e) {
//			System.out.println("# Error during login: " + e);
//			this.token = -1;
//			return false;
//		}
//	}
	
	public boolean loginLocal(String email, String contrasena) {
		try {
			this.token = this.serviceLocator.getService().loginLocal(email, contrasena);
			if(token == -1) {
				return false;
			} else {
				return true;
			}
		} catch (RemoteException e) {
			System.out.println("# Error durante el inicio de sesión " + e);
			this.token = -1;
			return false;
		}
	
	}
	
	public boolean loginGoogle(String email) {
		try {
			this.token = this.serviceLocator.getService().loginGoogle(email);
			if(token == -1) {
				return false;
			} else {
				return true;
			}
		} catch (RemoteException e) {
			System.out.println("# Error durante el inicio de sesión " + e);
			this.token = -1;
			return false;
		}
		
	}
	
	public boolean loginFacebook(String email) {
		try {
			this.token = this.serviceLocator.getService().loginFacebook(email);
			if(token == -1) {
				return false;
			} else {
				return true;
			}
		} catch (RemoteException e) {
			System.out.println("# Error durante el inicio de sesión " + e);
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
