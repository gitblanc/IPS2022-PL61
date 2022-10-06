/**
 * 
 */
package database.business.monitor.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.business.monitor.MonitorService.MonitorBLDto;

/**
 * @author UO285176
 *
 */
public class FindAllMonitors {
	private static final String SQL = "select * from Monitor";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	public List<MonitorBLDto> execute() {
		List<MonitorBLDto> monitores = new ArrayList<>();

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				MonitorBLDto monitor = new MonitorBLDto();
				monitor.id = rs.getString("id_m");
				monitor.nombre = rs.getString("nombre_m");
				monitor.apellidos = rs.getString("apellidos_m");
				monitor.correo = rs.getString("correo_m");
				monitores.add(monitor);
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
		return monitores;
	}
}
