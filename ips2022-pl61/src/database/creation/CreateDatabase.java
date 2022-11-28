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
		String crearInstalacion = "create table instalacion(nombre_i varchar(20) primary key, plazas int not null, cerrada_para_alquileres varchar(10))";
		String crearTipoActividad = "create table TipoActividad(id_a varchar(150) primary key, tipo varchar(30) not null,"
				+ " intensidad varchar(10) check(intensidad = 'alta' or intensidad = 'moderada' or intensidad = 'baja'),"
				+ " acceso varchar(20) check(acceso = 'libre' or acceso = 'reserva'), hora_inicio varchar(6),"
				+ "hora_fin varchar(6), nombre_i varchar(20) foreign key references Instalacion(nombre_i),"
				+ "fecha varchar(20), plazas_a int)";
		String crearCursillo = "create table cursillo(id_c varchar(10) primary key, nombre_c varchar(20) not null, "
				+ "duracion varchar(20) not null, horario date not null)";
		String crearListaEspera = "create table lista_espera(id_lista varchar(10) primary key, cantidad int not null)";
		String crearAdministracion = "create table administracion(id_a varchar(10) primary key, nombre_a varchar(20) not null"
				+ ", apellidos_a varchar(50) not null, correo_a varchar(50) not null)";
		String crearRecursosActividad = "create table RecursosActividad(id_a varchar(150) foreign key references TipoActividad(id_a)"
				+ ",nombre_r varchar(20) foreign key references Recurso(nombre_r))";
		String crearActividadSocio = "create table ActividadSocio(correo_s varchar(50) foreign key references Socio(correo_s),"
				+ "id_a varchar(150) foreign key references TipoActividad(id_a))";
		String crearAlquileres = "create table Alquileres(id_a varchar(100) primary key, nombre_i varchar(20) foreign key references instalacion(nombre_i),"
				+ " id_socio varchar(10) foreign key references socio(id_s), fecha varchar(20), hora_inicio varchar(6), hora_fin varchar(6), cancelado int)"; // 1
		String crearRecursosALlevarSocio = "create table RecursosALlevarSocio(nombre_recurso_a_llevar varchar(20) primary key, nombre_i varchar(20) foreign key references Instalacion(nombre_i))";
		// no

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
		String dropAlquileres = "drop table alquileres";
		String dropRecursosALlevarSocio = "drop table recursosALlevarSocio";

		dropTables.add(dropMonitor);
		dropTables.add(dropNoSocio);
		dropTables.add(dropRecursosActividad);
		dropTables.add(dropCursillo);
		dropTables.add(dropListaEspera);
		dropTables.add(dropAdministracion);
		dropTables.add(dropActividadSocio);
		dropTables.add(dropAlquileres);
		dropTables.add(dropSocios);
		dropTables.add(dropTipoActividad);
		dropTables.add(dropRecurso);
		dropTables.add(dropRecursosALlevarSocio);
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
		createQueries.add(crearAlquileres);
		createQueries.add(crearRecursosALlevarSocio);

		// Inserción de datos
		// ACTIVIDADES
		String actividad1 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '1', 'Natación', 'alta', 'reserva', '13:00', '15:00', 'piscina', '07/12/2022', 12)";
		String actividad2 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '2', 'Sauna', 'baja', 'libre', '15:00', '16:00', 'piscina', '06/12/2022', 8)";
		String actividad3 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '3', 'Jacuzzi', 'baja', 'reserva', '16:00', '18:00', 'piscina', '05/12/2022', 4)";
		String actividad4 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '4', 'Peso muerto', 'alta', 'reserva', '13:00', '14:00', 'gimnasio', '07/12/2022', 15)";
		String actividad5 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '5', 'Biceps', 'moderada', 'libre', '14:00', '15:00', 'gimnasio', '07/12/2022', 8)";
		String actividad6 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '6', 'Calistenia', 'alta', 'libre', '21:00', '23:00', 'gimnasio', '07/12/2022', -1)";
		String actividad7 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '7', 'Carrera', 'alta', 'libre', '13:00', '15:00', 'pista', '07/12/2022', -1)";
		String actividad8 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '8', 'Jabalina', 'moderada', 'reserva', '17:00', '19:00', 'pista', '07/12/2022', 7)";
		String actividad9 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '9', 'Jabalina', 'moderada', 'reserva', '09:00', '11:00', 'pista', '07/12/2022', 7)";
		String actividad10 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '10', 'Yoga', 'moderada', 'reserva', '22:00', '23:00', 'gimnasio', '30/11/2022', 9)";
		String actividad11 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '11', 'Danza', 'moderada', 'reserva', '20:00', '22:00', 'pista', '07/12/2022', 10)";
		String actividad12 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '12', 'Danza', 'moderada', 'reserva', '16:00', '17:00', 'pista', '30/11/2022', 10)";
		///////////
		String actividad13 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '13', 'Natación', 'alta', 'reserva', '13:00', '15:00', 'piscina', '30/11/2022', 12)";
		String actividad14 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '14', 'Sauna', 'baja', 'libre', '15:00', '16:00', 'piscina', '28/11/2022', 8)";
		String actividad15 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '15', 'Jacuzzi', 'baja', 'reserva', '16:00', '18:00', 'piscina', '29/11/2022', 4)";
		String actividad16 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '16', 'Peso muerto', 'alta', 'reserva', '13:00', '14:00', 'gimnasio', '01/12/2022', 15)";
		String actividad17 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '17', 'Biceps', 'moderada', 'libre', '14:00', '16:00', 'gimnasio', '30/11/2022', 8)";
		String actividad18 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '18', 'Calistenia', 'alta', 'libre', '21:00', '23:00', 'gimnasio', '29/11/2022', -1)";
		String actividad19 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '19', 'Carrera', 'alta', 'libre', '13:00', '15:00', 'pista', '30/11/2022', -1)";
		String actividad20 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '20', 'Jabalina', 'moderada', 'reserva', '17:00', '19:00', 'pista', '03/12/2022', 7)";
		String actividad21 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '21', 'Jabalina', 'moderada', 'reserva', '09:00', '11:00', 'pista', '30/11/2022', 7)";
		String actividad22 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '22', 'Yoga', 'moderada', 'reserva', '22:00', '23:00', 'gimnasio', '03/12/2022', 9)";
		String actividad23 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '23', 'Danza', 'moderada', 'reserva', '20:00', '22:00', 'pista', '30/11/2022', 10)";
		String actividad24 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '24', 'Danza', 'moderada', 'reserva', '16:00', '17:00', 'pista', '11/10/2022', 10)";
		//////////
		String actividad25 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '25', 'Natación', 'alta', 'reserva', '13:00', '15:00', 'piscina', '01/12/2022', 12)";
		String actividad26 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '26', 'Sauna', 'baja', 'libre', '15:00', '16:00', 'piscina', '03/12/2022', 8)";
		String actividad27 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '27', 'Jacuzzi', 'baja', 'reserva', '16:00', '18:00', 'piscina', '04/12/2022', 4)";
		String actividad28 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '28', 'Peso muerto', 'alta', 'reserva', '13:00', '14:00', 'gimnasio', '08/11/2022', 15)";
		String actividad29 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '29', 'Biceps', 'moderada', 'libre', '14:00', '16:00', 'gimnasio', '25/11/2022', 8)";
		String actividad30 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '30', 'Calistenia', 'alta', 'libre', '21:00', '23:00', 'gimnasio', '08/11/2022', -1)";
		String actividad31 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '31', 'Carrera', 'alta', 'libre', '13:00', '15:00', 'pista', '25/11/2022', -1)";
		String actividad32 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '32', 'Jabalina', 'moderada', 'reserva', '17:00', '19:00', 'pista', '08/11/2022', 7)";
		String actividad33 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '33', 'Jabalina', 'moderada', 'reserva', '09:00', '11:00', 'pista', '25/11/2022', 7)";
		String actividad34 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '34', 'Yoga', 'moderada', 'reserva', '22:00', '23:00', 'gimnasio', '08/11/2022', 9)";
		String actividad35 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '35', 'Danza', 'moderada', 'reserva', '20:00', '22:00', 'pista', '25/11/2022', 10)";
		String actividad36 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '36', 'Danza', 'moderada', 'reserva', '16:00', '17:00', 'pista', '08/10/2022', 10)";
		String actividad37 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\", \"TIPO\",\"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '37', 'Carrera', 'alta', 'libre', '13:00', '15:00', 'pista', '03/12/2022', -1)";
		String actividad38 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '38', 'Jabalina', 'moderada', 'reserva', '17:00', '19:00', 'pista', '03/12/2022', 7)";
		String actividad39 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '39', 'Jabalina', 'moderada', 'reserva', '09:00', '11:00', 'pista', '03/12/2022', 7)";
		String actividad40 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '40', 'Yoga', 'moderada', 'reserva', '22:00', '23:00', 'gimnasio', '30/11/2022', 9)";
		String actividad41 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '41', 'Danza', 'moderada', 'reserva', '20:00', '22:00', 'pista', '30/11/2022', 10)";
		String actividad42 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '42', 'Danza', 'moderada', 'reserva', '16:00', '17:00', 'pista', '29/11/2022', 10)";
		String actividad43 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '43', 'Fútbol', 'moderada', 'reserva', '22:00', '23:00', 'campo', '1/12/2022', 9)";
		String actividad44 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '44', 'Rugby', 'moderada', 'reserva', '20:00', '22:00', 'campo', '30/11/2022', 10)";
		String actividad45 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '45', 'Balonpié', 'moderada', 'reserva', '16:00', '17:00', 'campo', '29/11/2022', 10)";
		String actividad46 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '46', 'Fútbol', 'moderada', 'reserva', '22:00', '23:00', 'campo', '5/12/2022', 9)";
		String actividad47 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '47', 'Rugby', 'moderada', 'reserva', '20:00', '22:00', 'campo', '7/12/2022', 10)";
		String actividad48 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '48', 'Balonpié', 'moderada', 'reserva', '16:00', '17:00', 'cancha', '8/12/2022', 10)";
		String actividad49 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '49', 'Basket', 'moderada', 'reserva', '22:00', '23:00', 'cancha', '1/12/2022', 9)";
		String actividad50 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '50', 'Tenis mesa', 'moderada', 'reserva', '20:00', '22:00', 'cancha', '30/11/2022', 10)";
		String actividad51 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '51', 'Patinaje', 'moderada', 'reserva', '16:00', '17:00', 'cancha', '29/11/2022', 10)";
		String actividad52 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '52', 'Basket', 'moderada', 'reserva', '22:00', '23:00', 'cancha', '5/12/2022', 9)";
		String actividad53 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '53', 'Patinaje', 'moderada', 'reserva', '20:00', '22:00', 'cancha', '7/12/2022', 10)";
		String actividad54 = "INSERT INTO TipoActividad\r\n"
				+ "( \"ID_A\",\"TIPO\", \"INTENSIDAD\", \"ACCESO\", \"HORA_INICIO\", \"HORA_FIN\", \"NOMBRE_I\", \"FECHA\", \"PLAZAS_A\" )\r\n"
				+ "VALUES ( '54', 'Hockey', 'moderada', 'reserva', '16:00', '17:00', 'cancha', '8/12/2022', 10)";
		// INSTALACIONES
		String instalacion1 = "INSERT INTO \"PUBLIC\".\"INSTALACION\"\r\n"
				+ "( \"NOMBRE_I\", \"PLAZAS\", \"CERRADA_PARA_ALQUILERES\" )\r\n" + "VALUES ( 'gimnasio', 40, null)";
		String instalacion2 = "INSERT INTO \"PUBLIC\".\"INSTALACION\"\r\n"
				+ "( \"NOMBRE_I\", \"PLAZAS\",  \"CERRADA_PARA_ALQUILERES\")\r\n" + "VALUES ( 'piscina', 30, null)";
		String instalacion3 = "INSERT INTO \"PUBLIC\".\"INSTALACION\"\r\n"
				+ "( \"NOMBRE_I\", \"PLAZAS\", \"CERRADA_PARA_ALQUILERES\" )\r\n" + "VALUES ( 'pista', 60, null)";
		String instalacion4 = "INSERT INTO \"PUBLIC\".\"INSTALACION\"\r\n"
				+ "( \"NOMBRE_I\", \"PLAZAS\", \"CERRADA_PARA_ALQUILERES\" )\r\n" + "VALUES ( 'cancha', 5, null)";
		String instalacion5 = "INSERT INTO \"PUBLIC\".\"INSTALACION\"\r\n"
				+ "( \"NOMBRE_I\", \"PLAZAS\", \"CERRADA_PARA_ALQUILERES\" )\r\n"
				+ "VALUES ( 'campo', 20, null)";
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
		String recurso10 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'banco', 5, 'gimnasio')";
		String recurso11 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'corcheras', 15, 'piscina')";
		String recurso12 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'banco pista', 15, 'pista')";
		String recurso13 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'cuerda', 15, 'gimnasio')";
		String recurso14 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'balón medicinal', 15, 'gimnasio')";
		String recurso15 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'altavoces', 10, 'gimnasio')";
		String recurso16 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'porteria', 2, 'campo')";
		String recurso17 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'petos', 30, 'campo')";
		String recurso18 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'red', 2, 'cancha')";
		String recurso19 = "INSERT INTO RECURSO\r\n" + "( \"NOMBRE_R\", \"CANTIDAD_R\", \"NOMBRE_I\" )\r\n"
				+ "VALUES ( 'sillas', 5, 'cancha')";
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

		// ALQUILERES
		String alquiler1 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('1', 'gimnasio','1','25/11/2022', '9:00', '11:00', 0)";
		String alquiler2 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('2', 'gimnasio','2','25/11/2022', '11:00', '13:00', 0)";
		String alquiler3 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('3', 'piscina','3','25/11/2022', '11:00', '13:00', 0)";
		String alquiler4 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('4', 'gimnasio','3','08/12/2022', '15:00', '17:00', 0)";
		String alquiler5 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('5', 'gimnasio','1','08/12/2022', '9:00', '11:00', 0)";
		String alquiler6 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('6', 'gimnasio','2','25/11/2022', '11:00', '13:00', 0)";
		String alquiler7 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('7', 'piscina','1','08/12/2022', '11:00', '13:00', 0)";
		String alquiler8 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('8', 'gimnasio','3','30/11/2022', '15:00', '17:00', 0)";
		////////////
		String alquiler9 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('9', 'gimnasio','1','30/11/2022', '9:00', '11:00', 0)";
		String alquiler10 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('10', 'gimnasio','2','30/11/2022', '11:00', '13:00', 0)";
		String alquiler11 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('11', 'piscina','3','30/11/2022', '11:00', '13:00', 0)";
		String alquiler12 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('12', 'gimnasio','3','30/11/2022', '15:00', '17:00', 0)";
		String alquiler13 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('13', 'gimnasio','1','03/12/2022', '9:00', '11:00', 0)";
		String alquiler14 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('14', 'gimnasio','2','03/12/2022', '11:00', '13:00', 0)";
		String alquiler15 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('15', 'piscina','1','03/12/2022', '11:00', '13:00', 0)";
		String alquiler16 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('16', 'gimnasio','3','03/12/2022', '15:00', '17:00', 0)";
		String alquiler17 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('17', 'gimnasio','1','03/12/2022', '9:00', '11:00', 0)";
		String alquiler18 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('18', 'gimnasio','2','30/11/2022', '11:00', '13:00', 0)";
		String alquiler19 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('19', 'piscina','1','28/11/2022', '11:00', '13:00', 0)";
		String alquiler20 = "insert into alquileres (id_a, nombre_i, id_socio, fecha, hora_inicio, hora_fin, cancelado)"
				+ " values ('20', 'gimnasio','3','30/12/2022', '15:00', '17:00', 0)";
		// RECURSOS A LLEVAR EL SOCIO
		String recursoALlevar1 = "INSERT INTO RECURSOSALLEVARSOCIO (NOMBRE_RECURSO_A_LLEVAR, NOMBRE_I )VALUES ( 'balon futbol', 'campo')";
		String recursoALlevar2 = "INSERT INTO RECURSOSALLEVARSOCIO (NOMBRE_RECURSO_A_LLEVAR, NOMBRE_I )VALUES ( 'raqueta', 'cancha')";
		String recursoALlevar3 = "INSERT INTO RECURSOSALLEVARSOCIO (NOMBRE_RECURSO_A_LLEVAR, NOMBRE_I )VALUES ( 'pelota', 'cancha')";
		String recursoALlevar4 = "INSERT INTO RECURSOSALLEVARSOCIO (NOMBRE_RECURSO_A_LLEVAR, NOMBRE_I )VALUES ( 'gorra', 'cancha')";
		String recursoALlevar5 = "INSERT INTO RECURSOSALLEVARSOCIO (NOMBRE_RECURSO_A_LLEVAR, NOMBRE_I )VALUES ( 'botas', 'campo')";
		String recursoALlevar6 = "INSERT INTO RECURSOSALLEVARSOCIO (NOMBRE_RECURSO_A_LLEVAR, NOMBRE_I )VALUES ( 'medias', 'campo')";

		// activiades a socios
		String actividadSocio1 = "insert into actividadSocio(correo_s, id_a) values ('imxiin@gmail.com', '9')";
		String actividadSocio2 = "insert into actividadSocio(correo_s, id_a) values ('bb345@gmail.com', '9')";
		String actividadSocio3 = "insert into actividadSocio(correo_s, id_a) values ('imxiin@gmail.com', '1')";
		String actividadSocio4 = "insert into actividadSocio(correo_s, id_a) values ('bb345@gmail.com', '2')";
		String actividadSocio5 = "insert into actividadSocio(correo_s, id_a) values ('imxiin@gmail.com', '3')";
		String actividadSocio6 = "insert into actividadSocio(correo_s, id_a) values ('bb345@gmail.com', '4')";

		createQueries.add(instalacion1);
		createQueries.add(instalacion2);
		createQueries.add(instalacion3);
		createQueries.add(instalacion4);
		createQueries.add(instalacion5);

		createQueries.add(actividad1);
		createQueries.add(actividad2);
		createQueries.add(actividad3);
		createQueries.add(actividad4);
		createQueries.add(actividad5);
		createQueries.add(actividad6);
		createQueries.add(actividad7);
		createQueries.add(actividad8);
		createQueries.add(actividad9);
		createQueries.add(actividad10);
		createQueries.add(actividad11);
		createQueries.add(actividad12);
		createQueries.add(actividad13);
		createQueries.add(actividad14);
		createQueries.add(actividad15);
		createQueries.add(actividad16);
		createQueries.add(actividad17);
		createQueries.add(actividad18);
		createQueries.add(actividad19);
		createQueries.add(actividad20);
		createQueries.add(actividad21);
		createQueries.add(actividad22);
		createQueries.add(actividad23);
		createQueries.add(actividad24);
		createQueries.add(actividad25);
		createQueries.add(actividad26);
		createQueries.add(actividad27);
		createQueries.add(actividad28);
		createQueries.add(actividad29);
		createQueries.add(actividad30);
		createQueries.add(actividad31);
		createQueries.add(actividad32);
		createQueries.add(actividad33);
		createQueries.add(actividad34);
		createQueries.add(actividad35);
		createQueries.add(actividad36);
		createQueries.add(actividad37);
		createQueries.add(actividad38);
		createQueries.add(actividad39);
		createQueries.add(actividad40);
		createQueries.add(actividad41);
		createQueries.add(actividad42);
		createQueries.add(actividad43);
		createQueries.add(actividad44);
		createQueries.add(actividad45);
		createQueries.add(actividad46);
		createQueries.add(actividad47);
		createQueries.add(actividad48);
		createQueries.add(actividad49);
		createQueries.add(actividad50);
		createQueries.add(actividad51);
		createQueries.add(actividad52);
		createQueries.add(actividad53);
		createQueries.add(actividad54);

		createQueries.add(recurso1);
		createQueries.add(recurso2);
		createQueries.add(recurso3);
		createQueries.add(recurso4);
		createQueries.add(recurso5);
		createQueries.add(recurso6);
		createQueries.add(recurso7);
		createQueries.add(recurso8);
		createQueries.add(recurso9);
		createQueries.add(recurso10);
		createQueries.add(recurso11);
		createQueries.add(recurso12);
		createQueries.add(recurso13);
		createQueries.add(recurso14);
		createQueries.add(recurso15);
		createQueries.add(recurso16);
		createQueries.add(recurso17);
		createQueries.add(recurso18);
		createQueries.add(recurso19);

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

		createQueries.add(alquiler1);
		createQueries.add(alquiler2);
		createQueries.add(alquiler3);
		createQueries.add(alquiler4);
		createQueries.add(alquiler5);
		createQueries.add(alquiler6);
		createQueries.add(alquiler7);
		createQueries.add(alquiler8);
		createQueries.add(alquiler9);
		createQueries.add(alquiler10);
		createQueries.add(alquiler11);
		createQueries.add(alquiler12);
		createQueries.add(alquiler13);
		createQueries.add(alquiler14);
		createQueries.add(alquiler15);
		createQueries.add(alquiler16);
		createQueries.add(alquiler17);
		createQueries.add(alquiler18);
		createQueries.add(alquiler19);
		createQueries.add(alquiler20);

		createQueries.add(actividadSocio1);
		createQueries.add(actividadSocio2);
		createQueries.add(actividadSocio3);
		createQueries.add(actividadSocio4);
		createQueries.add(actividadSocio5);
		createQueries.add(actividadSocio6);

		createQueries.add(recursoALlevar1);
		createQueries.add(recursoALlevar2);
		createQueries.add(recursoALlevar3);
		createQueries.add(recursoALlevar4);
		createQueries.add(recursoALlevar5);
		createQueries.add(recursoALlevar6);

	}
}
