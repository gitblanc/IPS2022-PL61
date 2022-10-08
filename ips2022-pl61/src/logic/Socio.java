package logic;

public class Socio {

	//Atributos de la clase
	private String idSocio;
	private String nombreSocio;
	private String apellidosSocio;
	private String correoSocio;
	
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
	
	
	
}
