/**
 * 
 */
package database.business.socio.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.business.socio.SocioService.SocioBLDto;

/**
 * @author UO285176
 *
 */
public class FindAllSocios {
	private static final String SQL = "select distinct(*) from Socio";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public List<SocioBLDto> execute() {
		List<SocioBLDto> socios = new ArrayList<>();

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				SocioBLDto socio = new SocioBLDto();
				socio.id = rs.getString("id_s");
				socio.nombre = rs.getString("nombre_s");
				socio.apellidos = rs.getString("apellidos_s");
				socio.correo = rs.getString("correo_s");
				socio.contraseña = rs.getString("contraseña_s");
				socios.add(socio);
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
		return socios;
	}
}
