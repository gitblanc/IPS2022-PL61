/**
 * 
 */
package fileUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import logic.Alquiler;
import logic.Socio;

/**
 * @author UO285176
 *
 */
public class FileUtil {

	public static void grabarCancelacionesAFichero(List<Alquiler> alquileresCancelados) throws IOException {
		FileWriter writer = new FileWriter("cancelaciones/cancelaciones.txt", true);
		String text = "";
		for (Alquiler a : alquileresCancelados) {
			Socio socio = Socio.buscarSocio(a.getId_socio());
			text = "Socio --> { id:" + socio.getId() + ", nombre: " + socio.getNombre() + ", apellidos: "
					+ socio.getApellidos() + ", correo: " + socio.getCorreo() + " }" + "\n" + "\t\tDía de cancelación: "
					+ a.getFecha() + "\n" + "\t\tInstalación: " + a.getInstalacion() + "\n";
			writer.write(text);
		}

		writer.write("<---/------/------/------/--->\n\n");
		writer.close();
	}

}
