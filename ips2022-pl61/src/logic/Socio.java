package logic;

import java.util.ArrayList;
import java.util.List;

public class Socio {

	//Atributos de la clase
	private String idSocio;
	private String nombreSocio;
	private String apellidosSocio;
	private String correoSocio;
	
	//Cada socio tiene una lista de actividades a la que está inscrito
	private List<Actividad> actividadesApuntas = new ArrayList<Actividad>();
	
	/*
	 * Constructor de la clase Socio
	 */
	public Socio(String idSocio, String nombreSocio, String apellidoSocio, String correoSocio) {
		setIdSocio(idSocio);
		setNombreSocio(nombreSocio);
		setApellidosSocio(apellidoSocio);
		setCorreoSocio(correoSocio);
		
	}

	public String getIdSocio() {
		return idSocio;
	}

	private void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	private void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}

	public String getApellidosSocio() {
		return apellidosSocio;
	}

	private void setApellidosSocio(String apellidosSocio) {
		this.apellidosSocio = apellidosSocio;
	}

	public String getCorreoSocio() {
		return correoSocio;
	}

	private void setCorreoSocio(String correoSocio) {
		this.correoSocio = correoSocio;
	}
	
	/**
	 * Mçetodo que añade una actividad al sociio
	 * @param actividad de tipo Actividad
	 */
	public void addActividad(Actividad actividad) {
		actividadesApuntas.add(actividad);
	}

	/**
	 * Método que devuelve todas las actividades apuntadas por el socio
	 * @return
	 */
	public List<Actividad> listarActividadesApuntadas() {
		return actividadesApuntas;
	}
	
	
}
