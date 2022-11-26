/**
 * 
 */
package database.business.alquiler.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.business.alquiler.AlquilerService.AlquilerBLDto;

/**
 * @author UO285176
 *
 */
public class FindAllAlquileres {

	private static final String SQL = "select * from alquileres";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public List<AlquilerBLDto> execute() {
		List<AlquilerBLDto> alquileres = new ArrayList<>();

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				AlquilerBLDto al = new AlquilerBLDto();
				al.id = rs.getString("id_a");
				al.instalacion = rs.getString("nombre_i");
				al.id_socio = rs.getString("id_socio");
				al.fecha = rs.getString("fecha");
				al.hora_inicio = rs.getString("hora_inicio");
				al.hora_fin = rs.getString("hora_fin");
				al.cancelado = rs.getInt("cancelado");
				alquileres.add(al);
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
		return alquileres;
	}

}
