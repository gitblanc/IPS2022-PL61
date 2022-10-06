package database.business.recurso.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.recurso.RecursoService.RecursoBLDto;

/**
 * @author uo276967
 *
 */
public class DeleteRecurso {
	
	private static String SQL = "delete from Recurso where nombre_r = ?";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	private RecursoBLDto recurso = new RecursoBLDto();
	
	/**
	 * Constructor de la clase 
	 * @param recurso de tipo RecursoBLDto
	 */
	public DeleteRecurso(String nombreR) {
		Argument.isNotNull(PASSWORD);
		recurso.nombre = nombreR;
	}
	
	/**
	 * Método que ejecuta la transacción
	 * @return un RecursoBLDto
	 */
	public void execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, recurso.nombre);
			
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
