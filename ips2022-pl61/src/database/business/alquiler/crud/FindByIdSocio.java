package database.business.alquiler.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assertion.Argument;
import database.business.alquiler.AlquilerService.AlquilerBLDto;

public class FindByIdSocio {

	private static String SQL = "select * from Alquileres where id_socio = ?";

	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private String id;

	public FindByIdSocio(String idSocio) {
		Argument.isNotNull(id);
		this.id = idSocio;
	}

	public List<AlquilerBLDto> execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<AlquilerBLDto> alquiler = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, this.id);


			rs = pst.executeQuery();
			alquiler = getResult(rs);

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
		return alquiler;
	}
	
	private List<AlquilerBLDto> getResult(ResultSet r) throws SQLException {
		List<AlquilerBLDto> res = new ArrayList<>();
		while (r.next()) {
			res.add(resultSet(r));
		}
		return res;
	}

	private AlquilerBLDto resultSet(ResultSet r) throws SQLException {
		AlquilerBLDto a = new AlquilerBLDto();
		a.id = r.getString("id_a");
		a.id_socio = r.getString("id_socio");
		a.hora_inicio = r.getString("Hora_inicio");
		a.hora_fin = r.getString("Hora_fin");
		a.instalacion = r.getString("Nombre_i");
		a.fecha = r.getString("fecha");

		return a;
	}
		
	
}
