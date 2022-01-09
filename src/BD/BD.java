package BD;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import clases.Actividad;
import clases.Ski;
import clases.Usuario;
import clases.Viaje;
import ventanas.VentanaInicio;

public class BD extends JFrame{

	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
	private static Usuario uActual = new Usuario();
	static Logger logger = Logger.getLogger( "BaseDatos" );
	private static Handler handler;
	
	public static void ficheroLogger() {
		try {
			handler = new FileHandler("BaseDatos.txt", true);
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
		} catch (SecurityException e) {
			
			logger.log( Level.INFO, "No se ha podido guardar" );
		} catch (IOException e) {
			
			logger.log( Level.INFO, "No se ha podido guardar" );
		}
	}
	/**
	 * Metodo para conectar y desconectar la conexión a la base de datos
	 * @return
	 */
	public static Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:database.db");
			logger.log( Level.INFO, "Se ha conectado con la BBDD" );
		} catch (ClassNotFoundException e) {
			logger.log( Level.INFO, "Error cargando el driver de la BD" );
		} catch (SQLException e) {
			logger.log( Level.INFO, "Error al conectar con BD" );
		}
		return conn;
	}

	public static void disconnect() {
		try {
			conn.close();
			logger.log( Level.INFO, "Se ha desconectado de la BD" );
		} catch (SQLException e) {
			logger.warning("No se ha podido desconectar");
		}
	}

	/**
	 * Metodo para mirar si el login no estaba registrado anteriormente en la base de datos
	 * Se usa en la ventana registro
	 * @param usuario
	 * @return
	 */
	public boolean compararLogin(Usuario usuario) {
	  try {
            ResultSet rs;
            String consulta = "SELECT * FROM usuario WHERE login = ?";

            PreparedStatement ps = conn.prepareStatement(consulta); 
            ps.setString(1, usuario.getLogin()); //así comparamos login

            rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getString("login").equals(usuario.getLogin())) {
                    JOptionPane.showMessageDialog(null, "¡Prueba con otro nombre de usuario!", "Error", JOptionPane.ERROR_MESSAGE);
                    return true;
                }

            }
            logger.warning("Se ha comparado el login correctamente.");
            ps.close();
            return false;
        } catch (Exception e) {
            logger.warning("No se ha podido comparar el login.");
            return false;
        }
	}
	
	
	/**
	 * Metodo para comprobar si los datos introducidos por el usuario(login y contraseña) están en la base de datos 
	 * Se usa en la ventana Inicio
	 * @param login
	 * @param contrasenya
	 * @return
	 * @throws SQLException 
	 */
	
	public boolean comprobarLogin(String login, String contrasenya){

		try {
			ResultSet rs;
			//preparamos una sentencia donde la bd selecciona la FILA q tenga AMBOS VALORES q le hemos pasado por parámetro
			String consulta = "SELECT * FROM usuario WHERE login=? AND contrasenya=?;";

			PreparedStatement ps = conn.prepareStatement(consulta);
			ps.setString(1, login);
			ps.setString(2, contrasenya);

			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("login").equals(login) && rs.getString("contrasenya").equals(contrasenya)) {
						
					String nombre = rs.getString("nombre");
					String apellido = rs.getString("apellido");
					String dni = rs.getString("dni");
					String tarjeta = rs.getString("tarjeta");
					String log = rs.getString("login");
					String contr = rs.getString("contrasenya");
					String email = rs.getString("email");

					uActual = new Usuario(nombre, apellido, dni, tarjeta, log, contr, email, 0, null);

					return true;
				}	
			}if (VentanaInicio.textoUsuario.getText().equals("")|| VentanaInicio.textoContrasenya.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "¡No has introducido la contraseña o el usuario!", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "¡Contraseña o usuario incorrectos!", "Error", JOptionPane.ERROR_MESSAGE);
				
				VentanaInicio.textoUsuario.setText("");
				VentanaInicio.textoContrasenya.setText("");
				
				ps.close();
				return false;
			}
			
		} catch (Exception e) {
			logger.warning("No se ha podido comprobar");
		}
		return true;
		
		}
		
	/**
	 * Método que sirve para identificar a el administrador
	 * Se usa en la ventana Inicio
	 * @param usuario
	 * @return
	 */

	public static boolean esAdministrador(String dni){
		
		Statement st = null;         
		String sentSQL = "select administrador from usuario where dni = '"+ dni+"'";
		boolean esAdmin = false;         
		try {             
			st = conn.createStatement();             
			ResultSet rs = st.executeQuery(sentSQL);             
			if(rs.next()){                 
				esAdmin = rs.getBoolean("administrador");
				}         
			} catch (SQLException e) {             
				logger.warning( "No se ha podido comprobar el administrador" );
		}                  
		return esAdmin;
		
		}

	/**
	 * Método para borrar un Usuario
	 * @param uActual
	 * @throws SQLException
	 */
	public void borrarUsuario(Usuario uActual) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
		Statement stmt = (Statement) conn.createStatement();
		String borrar = "DELETE FROM usuario where login='" + uActual.getLogin() + "';";
		int rs = stmt.executeUpdate(borrar);
	}
	/**
	 * Método para borrar actividad
	 * @param codigo
	 * @throws SQLException
	 */
	public void borrarActividad(String codigo) throws SQLException {
		Statement statement = conn.createStatement();
		String borrar = "DELETE FROM actividad where codigo='"+codigo+"'";
		statement.executeUpdate(borrar);
		
	}

	/**
	 * Método para crear un usuario nuevo
	 * @param loginText
	 * @param contrasenyaText
	 * @param nombreText
	 * @param apellidoText
	 * @param dniText
	 * @param tarjetaText
	 * @param emailText
	 */
	public void crearUsuario(JTextField loginText, JTextField contrasenyaText, JTextField nombreText, JTextField apellidoText, JTextField dniText, JTextField tarjetaText, JTextField emailText) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
			Statement stmt = (Statement) conn.createStatement();

			ResultSet rs = stmt.executeQuery("Select * from usuario");

			ArrayList<String> usuariosBD = new ArrayList<>();

			while(rs.next()) {
				String loginBD = rs.getString("login");
				String contrasenyaBD = rs.getString("contrasenya");
				usuariosBD.add(loginBD);
			}

			if (!usuariosBD.contains(loginText.getText())) {																	// ('login', 'contr')
				String instruccion = "INSERT INTO usuario (login, contrasenya, nombre, apellido, dni, tarjeta, email) VALUES ('" + loginText.getText()  + "','" + contrasenyaText.getText() + "','" + nombreText.getText()  + "','" + apellidoText.getText()  + "','" + dniText.getText()  + "','" + tarjetaText.getText()  + "','" + emailText.getText() + "');";
				JOptionPane.showMessageDialog(null, "Usuario creado con exito");
				int rs2 = stmt.executeUpdate(instruccion);
				uActual = new Usuario(nombreText.getText(), apellidoText.getText(), dniText.getText(), tarjetaText.getText(), loginText.getText(), contrasenyaText.getText(), emailText.getText(),0, null);
				logger.warning("Usuario creado con exito");
			} else {
				JOptionPane.showMessageDialog(null, "¡Este usuario ya existe!");
				logger.warning("Usuario ya existe");
			}
		} catch (SQLException e) {
			logger.warning("No se ha creado el usuario");
		}	

	} 


	public static Usuario getuActual() {
		return uActual;
	}


	public static void setuActual(Usuario uActual) {
		BD.uActual = uActual;
	}

	//MÉTODO EDITAR USUARIO --> SIN TERMINAR
	//AÑADIR LISTAVIAJES AL USUARIO
	public void editarUsuario(Usuario usuario) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
		Statement stmt = (Statement) conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");

		try {
			String instruccion = "UPDATE usuario SET nombre = '" + usuario.getNombre() + "', apellido = '" + usuario.getApellido() + "', dni = '" + usuario.getDni() + "', tarjeta = '" + usuario.getTarjeta() + "', login = '" + usuario.getLogin() + "', contrasenya = '" + usuario.getContrasenya() + "', email = '" + usuario.getEmail() + "' WHERE dni = '" + usuario.getDni() + "'";

			//String instruccion = "UDPATE usuario (nombre, apellido, dni, tarjeta, login, contrasenya, email) VALUES ('" + uActual.getNombre() + "', '" + uActual.getApellido() + "', '" +uActual.getDni() + "', '" +uActual.getTarjeta() + "', '" +uActual.getLogin() + "', '" + uActual.getContrasenya() + "', '" +uActual.getEmail() + "');";
			int rs2 = stmt.executeUpdate(instruccion);

			uActual = new Usuario(usuario.getNombre(), usuario.getApellido(), usuario.getDni(), usuario.getTarjeta(), usuario.getLogin(), usuario.getContrasenya(), usuario.getEmail(),0, usuario.getListaBilletes());
			logger.warning("El usuario se ha actualizado");
			JOptionPane.showMessageDialog(null, "¡El usuario se ha actualizado correctamente!");
		} catch (Exception e) {
			System.out.println("Se ha ejecutado el metodo de editar usuario a pesar del error");
			logger.warning("El usuario NO se ha actualizado");
		}



	}
	
	public static ArrayList<Actividad> getActividades() {
		try (Statement statement = conn.createStatement()) {
			ArrayList<Actividad> ret = new ArrayList<>();
			String sent = "select * from actividad ORDER BY codigo ASC;";
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");
				int aforo = rs.getInt("aforo");
				String instructor = rs.getString("instructor");
				String ubicacion = rs.getString("ubicacion");
				String descripcion = rs.getString("descripcion");
				String imagen = rs.getString("imagen");
				ret.add( new Actividad( codigo, nombre, aforo, instructor, ubicacion, descripcion, imagen ) );
			}
			return ret;
		} catch (Exception e) {
			logger.warning("No se han podido obtener las actividades");
			return null;
		}
	}
	
	public static ArrayList<Usuario> getUsuarios() {
		try (Statement statement = conn.createStatement()) {
			ArrayList<Usuario> ret = new ArrayList<>();
			String sent = "select * from usuario;";
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String dni = rs.getString("dni");
				String tarjeta = rs.getString("tarjeta");
				String login = rs.getString("login");
				String contrasenya = rs.getString("contrasenya");
				String email = rs.getString("email");
				int administrador = rs.getInt("administrador");
				ret.add( new Usuario ( nombre, apellido, dni, tarjeta, login, contrasenya, email, administrador, null ) );
			}
			return ret;
		} catch (Exception e) {
			logger.warning("No se han podido obtener los usuarios");
			return null;
		}
	}
	
	/**
	 * Este método deja que el administrador edite los datos de los usuario o de las actividades desde la tabla que se le ofrece en la ventana
	 * @param nom
	 * @param apellido
	 * @param dni
	 * @param tarjeta
	 * @param login
	 * @param contrasenya
	 * @throws SQLException
	 */
	public static void modificarUsuario(String nom, String apellido, String dni, String tarjeta, String login, String contrasenya, String email) throws SQLException {
		Statement statement = conn.createStatement();
		String sent = "update usuario set nombre='"+nom+"',apellido='"+apellido+"', dni='"+dni+"', tarjeta='"+tarjeta+"', login='"+login+"', contrasenya='"+contrasenya+"', email='"+email+"'where dni= '"+dni+"'; ";
		statement.executeUpdate(sent);
	}
	
	public static void modificarActividad(String codigo, String nombre, int aforo, String instructor, String ubicacion, String descripcion, String imagen) throws SQLException {
		Statement statement = conn.createStatement();
		String sent = "update actividad set codigo='"+codigo+"',nombre='"+nombre+"', aforo='"+aforo+"', instructor='"+instructor+"', ubicacion='"+ubicacion+"', descripcion='"+descripcion+"', imagen='"+imagen+"'where codigo= '"+codigo+"'; ";
		statement.executeUpdate(sent);
	}
	
	
	/**
	 * Obtener los datos del usuario
	 * @param u
	 * @param contraseña
	 * @return
	 */
	
	public Usuario usuario(String u, String contraseña) {
		Usuario cl = new Usuario();
		try(Statement stmt = (Statement) conn.createStatement()) {
			//SELECIONAR A QUE CLIENTE CORRESPONDE EL USUARIO Y CONTRASEñA ESCRITOS
			ResultSet usuario = stmt.executeQuery("SELECT nombre, apellido, dni, login, contraseya FROM usuario WHERE (login = '" + u + "' AND contraseya = '"+ contraseña +"');");
			while(usuario.next()) {
				String nombreBD = usuario.getString("nombre");
				String apellidoBD = usuario.getString("apellido");
				String dniBD = usuario.getString("dni");
				String usuarioBD = usuario.getString("login");
				String contraseya = usuario.getString("contraseya");


				cl.setNombre(nombreBD);
				cl.setApellido(apellidoBD);
				cl.setDni(dniBD);
				cl.setLogin(usuarioBD);
				cl.setContrasenya(contraseya);

			}

		} catch (SQLException e2) {
			logger.warning("Error al obtener los datos");
		}
		return cl;
	}
	/**
	 * Mirar en la bd cuales han sido sus reservas anteriores
	 * @param usuario
	 * @param modelo
	 */

	public void historial(Usuario usuario, DefaultTableModel modelo) {
		try(Statement stmt = (Statement) conn.createStatement()) {	

			Integer numFilas = 0 ;
			ResultSet res1 = stmt.executeQuery("SELECT COUNT(usuario) numero FROM historialregistros WHERE login = '"+ usuario.getLogin() +"'");

			while (res1.next()) {
				numFilas = res1.getInt("numero");
			}
			String [] tabla = new String[3];

			int i = 0;
			ResultSet res2 = stmt.executeQuery("SELECT fechaEntrada, fechaSalida, tipo FROM historialregistros WHERE login = '"+ usuario.getLogin() +"'");
			while(res2.next()) {

				String fila = res2.getString("fechaEntrada");
				tabla[0] = fila;
				fila = res2.getString("fechaSalida");
				tabla[1] = fila;

				modelo.addRow(tabla);
				if (i != numFilas) {
					i = i + 1;
				}
			}

		} catch (SQLException e2) {
			logger.warning("Ha habido un error al mirar el historial");
		}
	}

	
	//MIRAR QUE ACTIVIDADES ESTÁN RESEVADAS PARA HOY PARA EL ADMIN
	

	
	/*
	 public List<Ski> getListaSki(){

	 	List<Ski> listaSki = new ArrayList<Ski>();

	 	try(Statement stmt = conn.createStatement()) {

	 		ResultSet rs = stmt.executeQuery("SELECT * FROM actividad");

	 		while(rs.next()) {

	 			Ski actividad = new Ski(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("aforo"),
	 					rs.getString("instructor"), rs.getString("ubicacion"), rs.getString("descripcion"),
	 					rs.getString("imagen"), rs.getInt("cantMaterial"));
	 			if (actividad.getNombre() == "Ski") {
	 				listaSki.add(actividad);
	 			}
	 		}
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 	}
	 	 	return listaSki;
	 }
*/

	public List<Ski> getListaSki(){

		List<Ski> listaSki = new ArrayList<Ski>();

		try(Statement stmt = (Statement) conn.createStatement()) {

			ResultSet ski = stmt.executeQuery("SELECT * FROM actividad WHERE nombre = Ski;");

			while(ski.next()) {

				Ski actividad = new Ski(ski.getString("codigo"), ski.getString("nombre"), ski.getInt("aforo"), ski.getString("instructor"), ski.getString("ubicacion"), ski.getString("descripcion"), ski.getString("imagen"), ski.getInt("cantMaterial"));
				listaSki.add(actividad);
			}
		} catch (Exception e) {
			logger.warning("No se ha podido cargar la información");
		}
		return listaSki;
	}


	public static TreeSet<String> obtenerDiferentesActividades() throws SQLException{
		
		conn = DriverManager.getConnection("jdbc:sqlite:database.db");
		Statement statement = conn.createStatement();
		String sent = "SELECT nombre from actividad";
		TreeSet<String> tsfechas = new TreeSet<>();
		ResultSet rs = statement.executeQuery(sent);
		while(rs.next()) {
			String nombre = rs.getString("nombre");
			tsfechas.add(nombre);
		}
		rs.close();
		return tsfechas;
		
	}

	
	public static void insertarNuevaActividad(String cod, String nombre, int aforo, String instructor, String ubicacion, String descripcion, String imagen, String cantMat) throws SQLException {
		Statement statement = conn.createStatement();
		String sent = "insert into actividad (codigo,nombre,aforo,instructor,ubicacion,descripcion,imagen,cantMaterial) values('"+cod+"','"+nombre+"','"+aforo+"','"+instructor+"','"+ubicacion+"','"+descripcion+"', '"+imagen+"','"+cantMat+"')";
		statement.executeUpdate(sent);
		
	}
	public static boolean existeActividadMismoCodigoYNombre(String cod, String nombre) throws SQLException {
		String sent = "select * from actividad where codigo='"+cod+"' or nombre='"+nombre+"'";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sent);
		boolean existe = false;
		if(rs.next())
			existe = true;
		rs.close();
		return existe;
}
	
    public Viaje getViaje(String origen, String destino, Date fecha) {
        return null;
    }
    
}