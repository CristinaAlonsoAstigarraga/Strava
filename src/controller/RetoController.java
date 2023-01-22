package controller;

import remote.ServiceLocator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import dto.RetoDTO;

public class RetoController {
	
	private ServiceLocator serviceLocator;
	private long token;
	
	public RetoController(ServiceLocator serviceLocator, long token) {
		this.serviceLocator = serviceLocator;
		this.token = token;
	}
	
	public void crearReto(String nombre, Date fechaI, Date fechaF, double distancia, double tiempoObjetivo, 
			int deporte) {
		try {
			RetoDTO dto = new RetoDTO();
			dto.setDeporte(Deporte.values()[deporte]);
			dto.setDistancia(distancia);
			dto.setFechaFin(fechaF);
			dto.setFechaIni(fechaI);
			dto.setNombre(nombre);
			dto.setTiempoObjetivo(tiempoObjetivo);
			this.serviceLocator.getService().crearReto(dto, token);
		} catch (Exception e) {
			System.out.println(" # Error during crearReto: " + e);
		}
	}
	
	public List<String> getReto(){
		try {
			List<RetoDTO> retos = this.serviceLocator.getService().getReto(token);
			List<String> sRetos = new ArrayList<>();
			for(RetoDTO dto : retos) {
				sRetos.add(dto.toString());
			}
			return sRetos;
		} catch (Exception e) {
			System.out.println(" # Error during getRetos: " + e);
			return null;
		}
	}
	
	public List<String> getRetosActivos(){
		try {
			List<RetoDTO> retos = this.serviceLocator.getService().obtenerRetosActivos(token);
			List<String> sRetosActivos = new ArrayList<>();
			for(RetoDTO dto : retos) {
				sRetosActivos.add(dto.toString());
			}
			return sRetosActivos;
		} catch (Exception e) {
			System.out.println(" # Error during getRetosActivos: " + e);
			return null;
		}
	}
	
	public void aceptarReto(String reto) {
		try {
			this.serviceLocator.getService().aceptarReto(reto, token);
		} catch (Exception e) {
			System.out.println(" # Error aceptarReto: " + e);
		}
	}
}
