package database.business.actividad.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.actividad.ActividadService.ActividadBLDto;

public class FindById {

	private static String SQL = "select * from TipoActividad where id_a = ?";

	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private String id;

	public FindById(String id) {
		Argument.isNotNull(id);
		this.id = id;
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
			pst.setString(1, this.id);


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
		a.id = r.getString("id_a");
		a.acceso = r.getString("Acceso");
		a.tipo = r.getString("Tipo");
		a.intensidad = r.getString("Intensidad");
		a.hora_inicio = r.getString("Hora_inicio");
		a.hora_fin = r.getString("Hora_fin");
		a.instalacion = r.getString("Nombre_i");
		a.fecha = r.getString("fecha");
		a.plazas = r.getInt("Plazas");
		return a;
		
		
	}
}
