package logic;

import java.util.ArrayList;
import java.util.List;

public class MonitorBase {
	
	/**
	 * Clase que simula la utilización de la base de datos. Consta de toda la información necesaria para hacer las historias.
	 * @return
	 */
	
	public String[] getListaActividades() {
		String[] actividades = {"Baloncesto","Zumba","Natación","Ciclismo", "Pádel", "Clase abdominales" };
		return actividades;
	}
	
	
	public List<String> getSocios() {
		List<String> socios = new ArrayList<String> () {{add("Marcos González"); add("Marta Colemar");add( "Julia Mendez"); 
		add("Xavi García"); add("Pedro Suárez"); add("Lucía Iglesias");add( "Carolina Piedra");add( "Hugo Blanco");}};
		return socios;
	}
	
	public List<String> getActividades() {
		List<String> actividades = new ArrayList<String> () {{add("Natación"); add("Baloncesto");add( "Pádel"); 
		add("Zumba"); add("Ciclismo");}};
		return actividades;
	}
	public String[] getActividadesArray() {
		String[] a = {"","Natación","Baloncesto","Pádel","Zumba","Ciclismo"};
		return a;
	}
	
	public List<String> getNatacionSocios() {
		List<String> sociosN = new ArrayList<String> () {{add("Marcos González");add( "Julia Mendez"); 
		add("Xavi García"); add("Pedro Suárez");add( "Carolina Piedra");}};
		return sociosN;
	}
	
	public List<String> getBaloncestoSocios() {
		List<String> sociosB = new ArrayList<String> () {{add("Marta Colemar");add( "Julia Mendez"); 
		 add("Lucía Iglesias");add( "Hugo Blanco");}};
		return sociosB;
	}
	
	public List<String> getPadelSocios() {
		List<String> sociosP = new ArrayList<String> () {{add("Marcos González"); add("Marta Colemar");add( "Julia Mendez");}};
		return sociosP;
	}
	
	public List<String> getZumbaSocios() {
		List<String> sociosZ = new ArrayList<String> () {{add( "Julia Mendez"); add("Xavi García"); add("Pedro Suárez"); add("Lucía Iglesias");
		add( "Hugo Blanco");}};
		return sociosZ;
	}
	
	public List<String> getCiclismoSocios() {
		List<String> sociosC = new ArrayList<String> () {{add( "Julia Mendez");add("Xavi García"); add("Pedro Suárez"); 
		add("Lucía Iglesias");add( "Carolina Piedra");add( "Hugo Blanco");}};
		return sociosC;
	}
	
	public int plazasNatacion() {
		return 5;
	}
	
	public int plazasBaloncesto() {
		return 6;
	}
	
	public int plazasPadel() {
		return 4;
	}
	
	public int plazasZumba() {
		return 5;
	}
	
	public int plazasCiclismo() {
		return 6;
	}
	/**
	 * Método que devuelve una lista de los socios apuntados en la actividad que interesa
	 * @param actividad
	 * @return lista socios
	 */
	public List<String> getSocios(String actividad) {
		if (actividad.equals("Natación")) {
			return getNatacionSocios();
		}else if(actividad.equals("Baloncesto")) {
			return getBaloncestoSocios();
		}else if (actividad.equals("Pádel")) {
			return getPadelSocios();
		}else if(actividad.equals("Ciclismo")) {
			return getCiclismoSocios();
		}else if(actividad.equals("Zumba")){
			return getZumbaSocios();
		}else {
			return new ArrayList<>();
		}
	}
	
	/**
	 * Método que devuelve el número de plazas en cada actividad
	 * @param actividad
	 * @return
	 */
	public int getPlazas(String actividad) {
		if (actividad.equals("Natación")) {
			return plazasNatacion();
		}else if(actividad.equals("Baloncesto")) {
			return plazasBaloncesto();
		}else if (actividad.equals("Padel")) {
			return plazasPadel();
		}else if(actividad.equals("Ciclismo")) {
			return plazasCiclismo();
		}else if(actividad.equals("Zumba")){
			return plazasZumba();
		}else {
			return 0;
		}
	}
}
