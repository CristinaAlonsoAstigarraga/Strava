package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import dto.SesionEntrenamientoDTO;
import remote.ServiceLocator;

public class SesionEntrenamientoController {

	private ServiceLocator serviceLocator;
	private long token;
	
	public SesionEntrenamientoController(ServiceLocator serviceLocator, long token) {
		this.serviceLocator = serviceLocator;
		this.token = token;
	}
	
	public void crearSesion(String titulo, int deporte, double distancia, Date sFyH, double duracion) {
		try {
			SesionEntrenamientoDTO dto = new SesionEntrenamientoDTO();
			dto.setDeporte(Deporte.values()[deporte]);
			dto.setDistancia(distancia);
			dto.setDuracion(duracion);
			dto.setsFyH(sFyH);
			dto.setTitulo(titulo);
			this.serviceLocator.getService().crearSesion(dto, token);
		} catch (Exception e) {
			System.out.println("# Error during crearSesion: " + e);
		}
	}
	
	public List<String> getSesiones() {
		try {
			List<SesionEntrenamientoDTO> sesiones = this.serviceLocator.getService().getSesiones(token);
			List<String> sSesiones = new ArrayList<>();
			for(SesionEntrenamientoDTO dto : sesiones) {
				sSesiones.add(dto.toString());
			}
			return sSesiones;
		} catch (Exception e) {
			System.out.println("# Error during getSesiones: " + e);
			return null;
		}
	}
}
