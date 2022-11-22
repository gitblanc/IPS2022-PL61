/**
 * 
 */
package database.business.actividad.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author UO285176
 *
 */
public class PlanificarActividad {

	String tipo = null;
	String fecha = null;
	String inicio = null;
	String fin = null;
	String id = null;

	public PlanificarActividad(String tipo, String fecha, String hora_inicio, String hora_fin, String id) {
		this.tipo = tipo;
		this.fecha = fecha;
		this.inicio = hora_inicio;
		this.fin = hora_fin;
		this.id = id;
	}

	private static String SQL = "UPDATE TIPOACTIVIDAD SET FECHA = ?, hora_inicio = ?, hora_fin = ?, TIPO = ? WHERE id_a = ?";

	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public Void execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, this.fecha);
			pst.setString(2, this.inicio);
			pst.setString(3, this.fin);
			pst.setString(4, this.tipo);
			pst.setString(5, this.id);

			pst.executeUpdate();

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
		return null;
	}

}
