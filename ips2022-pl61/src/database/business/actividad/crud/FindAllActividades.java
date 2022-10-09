/**
 * 
 */
package database.business.actividad.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.business.actividad.ActividadService.ActividadBLDto;

/**
 * @author UO285176
 *
 */
public class FindAllActividades {
	private static final String SQL = "select * from Actividad";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public List<ActividadBLDto> execute() {
		List<ActividadBLDto> actividades = new ArrayList<>();

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				ActividadBLDto actividad = new ActividadBLDto();
				actividad.id = rs.getString("id_a");
				actividad.nombre = rs.getString("nombre_a");
				actividad.intensidad = rs.getString("intensidad");
				actividad.monitor = rs.getString("id_m");
				actividades.add(actividad);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignore */ }
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignore */ }
			if (c != null)
				try {
					c.close();
				} catch (SQLException e) {
					/* ignore */ }
		}
		return actividades;
	}
}
