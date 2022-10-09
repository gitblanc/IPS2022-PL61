package logic;

import java.util.List;

public class Monitor {
	private int id;  //Identificador de monitor
	private String nombre;  //Nombre del monitor
	private String apellidos;  //Apellidos del monitor
	private String correo;  //Correo del monitor
	
	
	/**
	 * Constructor de la clase Monitor
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 */
	public Monitor(int id, String nombre, String apellidos, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public String getCorreo() {
		return correo;
	}
	
//	public List<Socio> getListaSociosMiActividad(Actividad actividad) throws Exception {
//		if (actividad.getMonitor().getId() == this.getId()) {
//			return actividad.getSociosApuntados();
//		} else {
//			throw new Exception();
//		}	
//	}
	
	 
	
}
