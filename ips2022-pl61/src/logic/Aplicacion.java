/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UO285176
 *
 */
public class Aplicacion {
	private List<Actividad> actividadesCreadas = new ArrayList<>();
	
	protected void addActividad(Actividad actividad) {
			try {
				actividadesCreadas.add(actividad);
			} catch (Exception e) {
				System.out.println("No se pudo añadir la actividad");
			}
	}
}
