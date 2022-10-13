/**
 * 
 */
package database.business.recurso.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.business.recurso.RecursoService.RecursoBLDto;

/**
 * @author uo276967
 *
 */
public class FindAllRecursos {
	private static final String SQL = "select * from Recurso";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	/**
	 * Método que ejecuta la transacción
	 * @return un RecursoBLDto
	 */
	public List<RecursoBLDto> execute() {
		List<RecursoBLDto> recursos = new ArrayList<>();
		
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				RecursoBLDto recurso = new RecursoBLDto();
				recurso.nombre = rs.getString("nombre_r");
				recurso.cantidad = rs.getInt("cantidad_r");
				recurso.instalacion = rs.getString("nombre_i");
				recursos.add(recurso);
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
		return recursos;
	}

}
