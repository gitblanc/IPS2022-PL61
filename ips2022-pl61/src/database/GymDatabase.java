/**
 * 
 */
package database;

import java.sql.*;

/**
 * @author UO285176
 *
 */
public class GymDatabase {
	
	public static void main(String[] args) {
	      
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet result = null;
	      
	      try {
	         Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1521/", "SA", "");
	         stmt = con.createStatement();
	         
	         result = stmt.executeQuery("SELECT * FROM PUBLIC.ACTIVIDADES;");
	         
	         while(result.next()) {					
					System.out.println(result.getString("NOMBRE"));
			}
				
	      }  catch (Exception e) {
	         e.printStackTrace(System.out);
	      }
	   }
}
