/**
 * 
 */
package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.business.BusinessFactory;
import database.business.alquiler.AlquilerService;
import database.business.alquiler.AlquilerService.AlquilerBLDto;

/**
 * @author UO285176
 *
 */
public class Alquiler {
	public static AlquilerService al = BusinessFactory.forAlquilerService();
	private String id;
	private String instalacion;
	private String id_socio;
	private String fecha;
	private String hora_inicio;
	private String hora_fin;

	public Alquiler(String id, String instalacion, String id_socio, String fecha, String hora_inicio, String hora_fin) {
		this.id = id;
		this.instalacion = instalacion;
		this.id_socio = id_socio;
		this.fecha = fecha;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}

	public Alquiler() {
	}

	public AlquilerService getAl() {
		return al;
	}

	public String getId() {
		return id;
	}

	public String getInstalacion() {
		return instalacion;
	}

	public String getId_socio() {
		return id_socio;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public List<Alquiler> listarAlquileres(String instalacion) {
		List<Alquiler> alquileres = new ArrayList<>();
		for (AlquilerBLDto a : al.findAll()) {
			if (a.instalacion.equals(instalacion)) {
				alquileres.add(new Alquiler(a.id, a.instalacion, a.id_socio, a.fecha, a.hora_inicio, a.hora_fin));
			}
		}
		return alquileres;
	}

	public String[] listarSociosConAlquileres() {
		String[] socios = new String[al.findAll().size()];
		int i = 0;
		for (AlquilerBLDto a : al.findAll()) {
			if (socios[0] == null) {
				socios[i] = a.id_socio;
				i++;
			} else if (!socioRepeated(a.id_socio, socios, i)) {
				socios[i] = a.id_socio;
				i++;
			}
		}
		return eliminarNull(socios);
	}

	private String[] eliminarNull(String[] socios) {
		ArrayList<String> removedNull = new ArrayList<String>();
		for (String str : socios)
			if (str != null)
				removedNull.add(str);
		return removedNull.toArray(new String[0]);
	}

	private boolean socioRepeated(String id_socio, String[] socios, int limit) {
		for (int i = 0; i < limit; i++) {
			if (socios[i].equals(id_socio))
				return true;
		}
		return false;
	}

	public String[] listarAlquileresPorSocio(String socio) {
		String[] alquileres = new String[al.findAll().size()];
		int i = 0;
		for (AlquilerBLDto a : al.findAll()) {
			if (a.id_socio.equals(socio)) {
				if (alquileres[0] == null) {
					alquileres[i] = a.instalacion + "-" + a.fecha + "-" + a.hora_inicio + "-" + a.hora_fin;
					i++;
				} else if (!socioRepeated(a.id_socio, alquileres, i)) {
					alquileres[i] = a.instalacion + "-" + a.fecha + "-" + a.hora_inicio + "-" + a.hora_fin;
					i++;
				}
			}
		}
		return eliminarNull(alquileres);
	}

	public void cancelarAlquiler(String socio, String instalacion, String fecha, String hora_inicio, String hora_fin) {
		al.cancelarAlquiler(socio, instalacion, fecha, hora_inicio, hora_fin);
	}

	public void crearAlquiler(String id_socio, String instalacion, String hora_inicio, String hora_fin, String fecha) {
		al.crearAlquiler(id_socio, instalacion, hora_inicio, hora_fin, fecha);
	}

	public static boolean comprobarRequisitosAlquilerCorrecto(LocalDate now, String fecha2) {
		String[] date = fecha2.split("/");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		LocalDate ac = LocalDate.of(year, month, day);
		LocalDate result = ac.minusDays(7);
		if(now.isBefore(result) || now.isEqual(result)) {
			return true;
		}
		return false;
		
	}

	public static boolean comprobarHoras(String inicio, String fin) {
		String[] i = inicio.split(":");
		int value1 = Integer.parseInt(i[0]);
		
		String[] j = fin.split(":");
		int value2 = Integer.parseInt(j[0]);
		if(Math.abs(value1 - value2) <= 2) {
			return true;
		}
		return false;
	}

	public static boolean comprobarRequisitoNoTieneMasAlquileres(String id_socio2, String fecha2, String inicio, String fin) {
		List<AlquilerBLDto> alquileres = al.findByIdSocio(id_socio2);
		if(alquileres != null && alquileres.size() != 0) {
			for(AlquilerBLDto a: alquileres) {
				if(!a.fecha.equals(fecha2) && !a.hora_inicio.equals(inicio) && !comprobarHoras(a.hora_inicio, inicio, fin)) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	private static boolean comprobarHoras(String horaRan, String inicio, String fin) {
		int hora1 = Integer.parseInt(horaRan);
		int hora_inicio = Integer.parseInt(inicio);
		int hora_fin = Integer.parseInt(fin);
		
		if(hora1 > hora_inicio && hora1 < hora_fin) {
			return false;
		}
		return true;
	}
}
