/**
 * 
 */
package database.creation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author UO285176
 *
 */

//Execute this class only once to set up the database
public class CreateDatabase {

	private static List<String> createQueries = new ArrayList<>();
	private static List<String> dropTables = new ArrayList<>();

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1521/", "SA", "");
			stmt = con.createStatement();

			createQueries();

			// Eliminamos las tablas
			for (String query : dropTables) {
				stmt.executeQuery(query);
			}

			// Creamos las tablas
			for (String query : createQueries) {
				stmt.executeQuery(query);
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static void createQueries() {
		// Tablas
		String crearSocios = "create table socio(id_s varchar(10) primary key, nombre_s varchar(20) not null"
				+ ", apellidos_s varchar(50) not null, correo_s varchar(50) unique  not null, contraseña_s varchar(50) not null)";
		String crearMonitor = "create table monitor(id_m varchar(10) primary key, nombre_m varchar(20) not null"
				+ ", apellidos_m varchar(50) not null, correo_m varchar(50) not null )";
		String crearNoSocio = "create table no_socio(id_ns varchar(10) primary key, nombre_ns varchar(20) not null"
				+ ", apellidos_ns varchar(50) not null, correo_ns varchar(50) not null)";
		String crearRecurso = "create table recurso(nombre_r varchar(20) primary key, cantidad_r int check(cantidad_r >= 0)"
				+ ", nombre_i varchar(20) foreign key references Instalacion(nombre_i))";
		String crearInstalacion = "create table instalacion(nombre_i varchar(20) primary key, plazas int not null)";
		String crearTipoActividad = "create table TipoActividad(id_a varchar(150) primary key, tipo varchar(30) not null,"
				+ " intensidad varchar(10) check(intensidad = 'alta' or intensidad = 'moderada' or intensidad = 'baja'),"
				+ " acceso varchar(20) check(acceso = 'libre' or acceso = 'reserva'), hora_inicio varchar(6) not null,"
				+ "hora_fin varchar(6) not null, nombre_i varchar(20) foreign key references Instalacion(nombre_i),"
				+ "fecha varchar(20), plazas_a int check(plazas_a = -1 or plazas_a > 0))";
		String crearCursillo = "create table cursillo(id_c varchar(10) primary key, nombre_c varchar(20) not null, "
				+ "duracion varchar(20) not null, horario date not null)";
		String crearListaEspera = "create table lista_espera(id_lista varchar(10) primary key, cantidad int not null)";
		String crearAdministracion = "create table administracion(id_a varchar(10) primary key, nombre_a varchar(20) not null"
				+ ", apellidos_a varchar(50) not null, correo_a varchar(50) not null)";
		String crearRecursosActividad = "create table RecursosActividad(id_a varchar(10) foreign key references TipoActividad(id_a)"
				+ ",nombre_r varchar(20) foreign key references Recurso(nombre_r))";
		String crearActividadSocio = "create table ActividadSocio(correo_s varchar(50) foreign key references Socio(correo_s),"
				+ "id_a varchar(10) foreign key references TipoActividad(id_a))";

		String crearSinRecursos = "insert into Recurso(nombre_r, cantidad_r) values('sin recursos', '0')";

		String dropSocios = "drop table socio";
		String dropMonitor = "drop table monitor";
		String dropNoSocio = "drop table no_socio";
		String dropInstalacion = "drop table instalacion";
		String dropRecurso = "drop table recurso";
		String dropTipoActividad = "drop table TipoActividad";
		String dropCursillo = "drop table cursillo";
		String dropListaEspera = "drop table lista_espera";
		String dropAdministracion = "drop table administracion";
		String dropRecursosActividad = "drop table recursosactividad";
		String dropActividadSocio = "drop table actividadsocio";

		dropTables.add(dropMonitor);
		dropTables.add(dropNoSocio);
		dropTables.add(dropRecursosActividad);
		dropTables.add(dropCursillo);
		dropTables.add(dropListaEspera);
		dropTables.add(dropAdministracion);
		dropTables.add(dropActividadSocio);
		dropTables.add(dropSocios);
		dropTables.add(dropTipoActividad);
		dropTables.add(dropRecurso);
		dropTables.add(dropInstalacion);

		createQueries.add(crearSocios);
		createQueries.add(crearMonitor);
		createQueries.add(crearNoSocio);
		createQueries.add(crearInstalacion);
		createQueries.add(crearRecurso);
		createQueries.add(crearSinRecursos);
		createQueries.add(crearTipoActividad);
		createQueries.add(crearCursillo);
		createQueries.add(crearListaEspera);
		createQueries.add(crearAdministracion);
		createQueries.add(crearRecursosActividad);
		createQueries.add(crearActividadSocio);

		// Inserción de datos
		// ACTIVIDADES
		String actividad1 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '1', 'Natación', 'alta', 'reserva', '13:00', '15:00', 'piscina', '19/10/2022', 12)";
		String actividad2 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '2', 'Sauna', 'baja', 'libre', '13:00', '15:00', 'piscina', '19/10/2022', 8)";
		String actividad3 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '3', 'Jacuzzi', 'baja', 'reserva', '16:00', '18:00', 'piscina', '20/10/2022', 4)";
		String actividad4 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '4', 'Peso muerto', 'alta', 'reserva', '13:00', '14:00', 'gimnasio', '18/10/2022', 15)";
		String actividad5 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '5', 'Biceps', 'moderada', 'libre', '14:00', '16:00', 'gimnasio', '19/10/2022', 8)";
		String actividad6 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '6', 'Calistenia', 'alta', 'libre', '20:00', '23:00', 'gimnasio', '19/10/2022', 5)";
		String actividad7 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '7', 'Carrera', 'alta', 'libre', '13:00', '17:00', 'pista', '19/10/2022', -1)";
		String actividad8 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '8', 'Jabalina', 'moderada', 'reserva', '13:00', '16:00', 'pista', '18/10/2022', 7)";
		// INSTALACIONES
		String instalacion1 = "INSERT INTO \"PUBLIC\".\"INSTALACION\"\r\n" + "( \"NOMBRE_I\", \"PLAZAS\" )\r\n"
				+ "VALUES ( 'gimnasio', 40)";
		String instalacion2 = "INSERT INTO \"PUBLIC\".\"INSTALACION\"\r\n" + "( \"NOMBRE_I\", \"PLAZAS\" )\r\n"
				+ "VALUES ( 'piscina', 30)";
		String instalacion3 = "INSERT INTO \"PUBLIC\".\"INSTALACION\"\r\n" + "( \"NOMBRE_I\", \"PLAZAS\" )\r\n"
				+ "VALUES ( 'pista', 60)";
		// RECURSOS
		String recurso1 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'pesa 15kg', 6, 'gimnasio')";
		String recurso2 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'mancuerna 12kg', 6, 'gimnasio')";
		String recurso3 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'comba', 3, 'gimnasio')";
		String recurso4 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'manguito', 12, 'piscina')";
		String recurso5 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'tabla natación', 15, 'piscina')";
		String recurso6 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'flotador', 10, 'piscina')";
		String recurso7 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'toalla', 6, 'piscina')";
		String recurso8 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'jabalina', 8, 'pista')";
		String recurso9 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'barra olímpica', 10, 'gimnasio')";
		// RECURSOSACTIVIDAD
		String recursoAct1 = "INSERT INTO RECURSOSACTIVIDAD\r\n" + "( \"ID_A\", \"NOMBRE_R\" )\r\n"
				+ "VALUES ( '1', 'tabla natación')";
		String recursoAct2 = "INSERT INTO RECURSOSACTIVIDAD\r\n" + "( \"ID_A\", \"NOMBRE_R\" )\r\n"
				+ "VALUES ( '2', 'toalla')";
		String recursoAct3 = "INSERT INTO RECURSOSACTIVIDAD\r\n" + "( \"ID_A\", \"NOMBRE_R\" )\r\n"
				+ "VALUES ( '4', 'barra olímpica')";
		String recursoAct4 = "INSERT INTO RECURSOSACTIVIDAD\r\n" + "( \"ID_A\", \"NOMBRE_R\" )\r\n"
				+ "VALUES ( '5', 'mancuerna 12kg')";
		String recursoAct5 = "INSERT INTO RECURSOSACTIVIDAD\r\n" + "( \"ID_A\", \"NOMBRE_R\" )\r\n"
				+ "VALUES ( '8', 'jabalina')";
		String recursoAct6 = "INSERT INTO RECURSOSACTIVIDAD\r\n" + "( \"ID_A\", \"NOMBRE_R\" )\r\n"
				+ "VALUES ( '5', 'pesa 15kg')";
		// SOCIOS
		String socio1 = "INSERT INTO SOCIO\r\n"
				+ "( \"ID_S\", \"NOMBRE_S\", \"APELLIDOS_S\", \"CORREO_S\", \"CONTRASEÑA_S\" )\r\n"
				+ "VALUES ( '1', 'Juan', 'Pérez Galdós', 'juanperez@gmail.com', '1234qwerty')";
		String socio2 = "INSERT INTO SOCIO\r\n"
				+ "( \"ID_S\", \"NOMBRE_S\", \"APELLIDOS_S\", \"CORREO_S\", \"CONTRASEÑA_S\" )\r\n"
				+ "VALUES ( '2', 'Paula', 'Román Arias', 'pauuleta@gmail.com', 'uwu27')";
		String socio3 = "INSERT INTO SOCIO\r\n"
				+ "( \"ID_S\", \"NOMBRE_S\", \"APELLIDOS_S\", \"CORREO_S\", \"CONTRASEÑA_S\" )\r\n"
				+ "VALUES ( '3', 'Chen Xin', 'Pan Wang', 'imxiin@gmail.com', 'olaquetal')";
		String socio4 = "INSERT INTO SOCIO\r\n"
				+ "( \"ID_S\", \"NOMBRE_S\", \"APELLIDOS_S\", \"CORREO_S\", \"CONTRASEÑA_S\" )\r\n"
				+ "VALUES ( '4', 'Benito', 'González Ahmed', 'bb345@gmail.com', 'hgft234')";

		createQueries.add(instalacion1);
		createQueries.add(instalacion2);
		createQueries.add(instalacion3);

		createQueries.add(actividad1);
		createQueries.add(actividad2);
		createQueries.add(actividad3);
		createQueries.add(actividad4);
		createQueries.add(actividad5);
		createQueries.add(actividad6);
		createQueries.add(actividad7);
		createQueries.add(actividad8);

		createQueries.add(recurso1);
		createQueries.add(recurso2);
		createQueries.add(recurso3);
		createQueries.add(recurso4);
		createQueries.add(recurso5);
		createQueries.add(recurso6);
		createQueries.add(recurso7);
		createQueries.add(recurso8);
		createQueries.add(recurso9);

		createQueries.add(recursoAct1);
		createQueries.add(recursoAct2);
		createQueries.add(recursoAct3);
		createQueries.add(recursoAct4);
		createQueries.add(recursoAct5);
		createQueries.add(recursoAct6);

		createQueries.add(socio1);
		createQueries.add(socio2);
		createQueries.add(socio3);
		createQueries.add(socio4);
	}
}
