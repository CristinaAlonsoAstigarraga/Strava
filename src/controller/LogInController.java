package controller;

import java.rmi.RemoteException;
import java.util.Date;
import dto.UsuarioDTO;
import remote.ServiceLocator;

public class LogInController {

	private ServiceLocator serviceLocator;
	
	private long token = -1; //si el login no se hace bien se genera un token con -1 (numero no valido para token)
	
	public LogInController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	/*
	public void registroLocal(String nombre, String email, String contrasena, Date fNac, double peso, double altura,
			double fcm, double fcr) {
		
		try {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setAltura(altura);
			dto.setContrasena(contrasena);
			dto.setEmail(email);
			dto.setFcm(fcm);
			dto.setFcr(fcr);
			dto.setFechaNac(fNac);
			dto.setNombre(nombre);
			dto.setPeso(peso);
			dto.setUsuarioTipo(UsuarioTipo.LOCAL);
			this.serviceLocator.getService().registarLocal(dto);
		} catch (RemoteException e) {
			System.out.println("# Error during registration: " + e);
		}
		
	}
	
	public void registroGoogle(String nombre, String email, Date fNac, double peso, double altura,
			double fcm, double fcr) {
		
		try {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setAltura(altura);
			dto.setEmail(email);
			dto.setFcm(fcm);
			dto.setFcr(fcr);
			dto.setFechaNac(fNac);
			dto.setNombre(nombre);
			dto.setPeso(peso);
			dto.setUsuarioTipo(UsuarioTipo.GOOGLE);
			this.serviceLocator.getService().registrarGoogle(dto);
		} catch (RemoteException e) {
			System.out.println("# Error during registration: " + e);
		}
		
	}
	
	public void registroFacebook(String nombre, String email, Date fNac, double peso, double altura,
			double fcm, double fcr) {
		
		try {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setAltura(altura);
			dto.setEmail(email);
			dto.setFcm(fcm);
			dto.setFcr(fcr);
			dto.setFechaNac(fNac);
			dto.setNombre(nombre);
			dto.setPeso(peso);
			dto.setUsuarioTipo(UsuarioTipo.FACEBOOK);
			this.serviceLocator.getService().registarFacebook(dto);
		} catch (RemoteException e) {
			System.out.println("# Error during registration: " + e);
		}
		
	}
	*
	*	CAMBIAMOS TODOS LOS REGISTROS POR UNO ÚNICO CONJUNTO:
	*/
	
	public void registro(String nombre, String email, String contrasena, Date fNac, double peso, double altura,
			double fcm, double fcr, int proveedor) {
		
		try {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setAltura(altura);
			dto.setContrasena(contrasena);
			dto.setEmail(email);
			dto.setFcm(fcm);
			dto.setFcr(fcr);
			dto.setFechaNac(fNac);
			dto.setNombre(nombre);
			dto.setPeso(peso);
			dto.setProveedor(proveedor);
			this.serviceLocator.getService().registrar(dto);
		} catch (RemoteException e) {
			System.out.println("# Error during registration: " + e);
		}
		
	}
	
	/*
	public boolean loginLocal(String email, String contrasena) {
		try {
			this.token = this.serviceLocator.getService().loginLocal(email, contrasena);
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	public boolean loginFacebook(String email) {
		try {
			this.token = this.serviceLocator.getService().loginFacebook(email);
			return true;
		} catch (Exception e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	public boolean loginGoogle(String email) {
		try {
			this.token = this.serviceLocator.getService().loginGoogle(email);
			return true;
		} catch (Exception e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	*
	*	CAMBIAMOS TODOS LOS LOGIN POR UNO ÚNICO CONJUNTO:
	*/
	
	public boolean login(String email, String contrasena) {
		try {
			this.token = this.serviceLocator.getService().logIn(email, contrasena);
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
		} catch (Exception e) {
			System.out.println("# Error during logout: " + e);
		}
	}

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public long getToken() {
		return token;
	}
	
}
