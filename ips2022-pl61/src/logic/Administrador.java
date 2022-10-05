/**
 * 
 */
package logic;

/**
 * @author UO281576
 *
 */
public class Administrador {

	private Aplicacion app;
	
	public Administrador(Aplicacion app) {
		if(app != null)
			this.app = app;
		System.out.println("No se pudo crear el administrador");
	}

	public void crearActividad() {
		app.addActividad(new Actividad());
	}
}
