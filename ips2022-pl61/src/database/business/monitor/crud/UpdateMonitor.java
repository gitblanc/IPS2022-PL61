/**
 * 
 */
package database.business.monitor.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.monitor.MonitorService.MonitorBLDto;

/**
 * @author UO285176
 *
 */
public class UpdateMonitor {
	private static String SQL = "update Monitor set nombre_m = ?, apellidos_m = ?, correo_m = ? where id_m = ?";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private MonitorBLDto monitor = null;

	public UpdateMonitor(MonitorBLDto monitor) {
		Argument.isNotNull(monitor);
		this.monitor = monitor;
	}

	public void execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);
			pst = c.prepareStatement(SQL);
			pst.setString(1, monitor.nombre);
			pst.setString(2, monitor.apellidos);
			pst.setString(3, monitor.correo);
			pst.setString(4, monitor.id);

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

	}
}
