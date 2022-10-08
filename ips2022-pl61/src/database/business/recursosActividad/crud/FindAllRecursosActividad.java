/**
 * 
 */
package database.business.recursosActividad.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.business.recursosActividad.RecursosActividadService.RecursosActividadBLDto;

/**
 * @author UO285176
 *
 */
public class FindAllRecursosActividad {
	private static final String SQL = "select * from RecursosActividad";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public List<RecursosActividadBLDto> execute() {
		List<RecursosActividadBLDto> recursosActividades = new ArrayList<>();

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				RecursosActividadBLDto recursosActividad = new RecursosActividadBLDto();
				recursosActividad.actividad = rs.getString("id_a");
				recursosActividad.recurso = rs.getString("nombre_r");
				recursosActividades.add(recursosActividad);
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
		return recursosActividades;
	}
}
