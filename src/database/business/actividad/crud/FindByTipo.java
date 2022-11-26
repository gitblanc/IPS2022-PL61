/**
 * 
 */
package database.business.actividad.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.business.actividad.ActividadService.ActividadBLDto;

/**
 * @author UO285176
 *
 */
public class FindByTipo {

	private static String SQL = "select * from TipoActividad where tipo = ?";

	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	String tipo = null;

	public FindByTipo(String tipo) {
		this.tipo = tipo;
	}

	public ActividadBLDto execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ActividadBLDto actividad = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, this.tipo);

			rs = pst.executeQuery();
			actividad = getResult(rs);

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
		return actividad;
	}

	private ActividadBLDto getResult(ResultSet r) throws SQLException {
		ActividadBLDto a = new ActividadBLDto();
		if (r.next()) {
			a.id = r.getString("id_a");
			a.acceso = r.getString("Acceso");
			a.tipo = r.getString("Tipo");
			a.intensidad = r.getString("Intensidad");
			a.hora_inicio = r.getString("Hora_inicio");
			a.hora_fin = r.getString("Hora_fin");
			a.instalacion = r.getString("Nombre_i");
			a.fecha = r.getString("fecha");
			a.plazas = r.getInt("Plazas_a");
		}
		return a;
	}

}
