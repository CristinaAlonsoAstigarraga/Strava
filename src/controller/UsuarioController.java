package controller;

import java.rmi.RemoteException;

import dto.UsuarioLocalDTO;
import dto.UsuarioTipoDTO;
import remote.ServiceLocator;

public class UsuarioController {

	private ServiceLocator serviceLocator;
	
	public UsuarioController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean registrarLocal(String nombre, String email, String contrasena, String fechaNac, double peso, 
			double altura, double fcm, double fcr, UsuarioTipoDTO usuarioTipo) {
		try {
			
			this.serviceLocator.getService().registrarLocal(nombre, email, contrasena, fechaNac, peso, altura, fcm, fcr, usuarioTipo);
			//long token = this.serviceLocator.getService().loginLocal(email, contrasena);
			//System.out.println(token);
			return true;
			
		} catch (RemoteException e) {
			System.out.println("# Error en el registro: " + e);
			return false;		//Qué tiene que devolver?
		}
	}
	
	public boolean registrarGoogle(String nombre, String email, String fechaNac, double peso, double altura, 
			double fcm, double fcr, UsuarioTipoDTO usuarioTipo) {
		try {
			this.serviceLocator.getService().registrarGoogle(nombre, email, fechaNac, peso, altura, fcm, fcr, usuarioTipo);
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error en el registro: " + e);
			return false;		//Qué tiene que devolver?
		}
	}
	
	public boolean registrarFacebook(String nombre, String email, String fechaNac, double peso, double altura, 
			double fcm, double fcr, UsuarioTipoDTO usuarioTipo) {
		try {
			this.serviceLocator.getService().registrarFacebook(nombre, email, fechaNac, peso, altura, fcm, fcr, usuarioTipo);
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error en el registro: " + e);
			return false;		//Qué tiene que devolver?
		}
	}
}
