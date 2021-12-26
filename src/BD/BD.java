package BD;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
import ventana.VentanaInicio;

public class BD extends JFrame{

	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
	private static Usuario uActual = new Usuario();
	static Logger logger = Logger.getLogger( "BaseDatos" );
	private static Handler handler;
	
	//No termina de funcionar
	public static void guardarLogger() {
		try {
			handler = new FileHandler("BaseDatos.log");
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public void disconnect() {
		try {
			conn.close();
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
            e.printStackTrace();
            return false;
        }
	}
	
	/**
	 * Metodo para comprobar si los datos introducidos por el usuario(login y contraseña) están en la base de datos 
	 * Se usa en la ventana Inicio
	 * @param login
	 * @param contrasenya
	 * @return
	 */
		public boolean comprobarLogin(String login, String contrasenya) {

			//LAS BD SE EMPIEZAN SIEMPRE CON TRYCATCH
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

						uActual = new Usuario(nombre, apellido, dni, tarjeta, log, contr, email, null);

						return true;
					}	
				}if (VentanaInicio.textoUsuario.getText().equals("")|| VentanaInicio.textoContrasenya.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "¡No has introducido la contraseña o el usuario!", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "¡Contraseña o usuario incorrectos!", "Error", JOptionPane.ERROR_MESSAGE);
					try {
						VentanaInicio.textoUsuario.setText("");
						VentanaInicio.textoContrasenya.setText("");
					} catch (Exception e) {
						
						logger.info("No se ha podido comprobar");
					}
				}
				

				ps.close();
				return false;
			} catch (Exception e) {

				//logger
				logger.warning("Ha habido un error al hacer el login.");
			}
			return true;
		}
		
	/**
	 * Método que sirve para identificar a el administrador
	 * Se usa en la ventana Inicio
	 * @param usuario
	 * @return
	 */

	public static boolean esAdministrador(String usuario){
		
		Statement st = null;         
		String sentSQL = "select administrador from usuario where nombre = '"+ usuario+"'";
		boolean esAdmin = false;         
		try {             
			st = conn.createStatement();             
			ResultSet rs = st.executeQuery(sentSQL);             
			if(rs.next()){                 
				esAdmin = rs.getBoolean("administrador");
				}         
			} catch (SQLException e) {             
				// TODO Auto-generated catch block             
				e.printStackTrace();         
				}                  
		return esAdmin;
		
		}

	//MÉTODO BORRAR USUARIO
	public void borrarUsuario(Usuario uActual) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
		Statement stmt = (Statement) conn.createStatement();

		String borrar = "DELETE FROM usuario where login='" + uActual.getLogin() + "';";
		int rs = stmt.executeUpdate(borrar); //update --> borrar o editar, query --> añadir o consultar
	}


	//MÉTODO CREAR USUARIO
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
				uActual = new Usuario(nombreText.getText(), apellidoText.getText(), dniText.getText(), tarjetaText.getText(), loginText.getText(), contrasenyaText.getText(), emailText.getText(), null);
				logger.warning("Usuario creado con exito");
			} else {
				JOptionPane.showMessageDialog(null, "¡Este usuario ya existe!");
				logger.warning("Usuario ya existe");
			}


		} catch (SQLException e) {
			System.out.println("Se ha ejecutado el metodo de crear usuario a pesar del error");
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

			uActual = new Usuario(usuario.getNombre(), usuario.getApellido(), usuario.getDni(), usuario.getTarjeta(), usuario.getLogin(), usuario.getContrasenya(), usuario.getEmail(), usuario.getListaViajes());
			logger.warning("El usuario se ha actualizado");
			JOptionPane.showMessageDialog(null, "¡El usuario se ha actualizado correctamente!");
		} catch (Exception e) {
			System.out.println("Se ha ejecutado el metodo de editar usuario a pesar del error");
			logger.warning("El usuario NO se ha actualizado");
		}



	}


	//En vez de en la BD hacer un hashmap en la ventana de cantidadPersonasBillete y cantidadPersonasActividad
	// los atributos de usuario no son static
	public void registrarCantidad(int cantidadNiyos, int cantidadAdultos) {

		try {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO cantidadpersonas VALUES('"+ uActual.getDni()+ "', '"+ cantidadNiyos+ "', '"+ cantidadAdultos+ "')");

			ps.executeUpdate();

			conn.close();
		} catch (SQLException e2) {
			logger.warning("No se ha podido insertar");
		}

	}
	

	/*
	public void ponerAlDiaBD() {

		try(Statement stmt = (Statement) conn.createStatement();){
			//CAMBIAR CADA DIA LA FECHA
			JCalendar calendario = new JCalendar();
			String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
			String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
			String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
			String hoy = "";

			if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
				hoy = year + "0" + mes + "0" + dia;
			} else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
				hoy = year + "0" + mes + "" + dia;
			} else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
				hoy = year + "" + mes + "0" + dia;
			} else {
				hoy = year + "" + mes + "" + dia;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/


	//OBTENEMOS LOS DATOS DEL CLIENTE
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

	//MIRAR EN LA BD CUALES HAN SIDO SUS RESERVAS ANTERIORES
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
			logger.warning("Ha habido un error al hacer el login.");
		}
	}

	//MIRA QUE DIAS SE QUEDA EL CLIENTE EN EL BARCO Y SOLO DEJA COGER LA ACTIVIDAD DENTRO DE LAS FECHAS
	public void reservaActividad(String fecha, Actividad tipo, Usuario usuario) {
		try(Statement stmt = (Statement) conn.createStatement()) {	
			int res2 = stmt.executeUpdate("INSERT INTO registroActividad VALUES('"+tipo.getNombre() +"' ,  '"+ fecha +"', '"+ usuario.getDni() +"'");
		} catch (SQLException e2) {
			logger.warning("No se ha podido reservar la actividad");
			
		}
	}

	//EN EL CASO DE QUE RESERVES UNA ACTIVIDAD INTRODUCIR EN LA TABLA ACTIVIDAD LOS DATOS
	//FALTA HACER QUE EL ADMIN PUEDA BORRAR O AÑADIR ACTIVIDADES Y MODIFICAR SU PRECIO
	public void actividad(int precio, Actividad tipo) {

		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO actividades VALUES(?, ?);");

			pstmt.setString(1, tipo.getNombre());
			pstmt.setInt(2, precio);

			pstmt.execute();
		} catch (Exception e) {
			logger.warning("No se ha podido reservar la actividad");
		}
	}

	/*
	//MIRAR QUE ACTIVIDADES ESTÁN RESEVADAS PARA HOY PARA EL ADMIN
	public void actividadesHoy(DefaultTableModel modelo2) {

		JCalendar calendario = new JCalendar();
		String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
		String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
		String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
		String hoy = "";
		String text = "";
		if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
			hoy = year + "-0" + mes + "-0" + dia;
		} else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
			hoy = year + "-0" + mes + "-" + dia;
		} else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
			hoy = year + "-" + mes + "-0" + dia;
		} else {
			hoy = year + "-" + mes + "-" + dia;
		}
		try(Statement stmt = (Statement) conn.createStatement()) {	

			String [] tabla = new String[2];

			ResultSet res = stmt.executeQuery("SELECT login, tipo FROM actividades WHERE fechaActividad = '"+ hoy +"'");
			while (res.next()) {

				String fila =  res.getString("login");
				tabla[0] = fila;
				fila = res.getString("tipo");
				tabla[1] = fila;
				modelo2.addRow(tabla);

			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	// public List<Actividad> getListaActividades(){
	// 	List<Actividad> listaActividades = new ArrayList();

	// 	try(Statement stmt = (Statement) conn.createStatement()){

	// 		ResultSet actividad = stmt.executeQuery("SELECT * FROM actividad;");

	// 		while(actividad.next()){

	// 			Actividad actividad1 = new Actividad(actividad.getString("codigo"), actividad.getString("nombre"), actividad.getInt("aforo"), actividad.getString("instructor"), actividad.getString("ubicacion"), actividad.getString("descripcion"), actividad.getString("imagen"));
	// 			listaActividades.add(actividad1);
	// 		}
	// 	} catch (Exception e) {
	// 		//TODO: handle exception
	// 	}
	// }

	// public List<Buceo> getListaBuceo(){

	// 	List<Buceo> listaBuceo = new ArrayList<Buceo>();

	// 	try(Statement stmt = (Statement) conn.createStatement()) {

	// 		ResultSet buceo = stmt.executeQuery("SELECT * FROM actividad WHERE nombre = Buceo");

	// 		while(buceo.next()) {

	// 			Buceo actividad = new Buceo(buceo.getString("codigo"), buceo.getString("nombre"), buceo.getInt("aforo"), buceo.getString("instructor"), buceo.getString("ubicacion"), buceo.getString("descripcion"), buceo.getString("imagen"), buceo.getInt("cantMaterial"));
	// 			listaBuceo.add(actividad);
	// 		}	
	// 	}catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
	// 	return listaBuceo;
	// }

	// public List<Ski> getListaSki(){

	// 	List<Ski> listaSki = new ArrayList<Ski>();

	// 	try(Statement stmt = conn.createStatement()) {

	// 		ResultSet rs = stmt.executeQuery("SELECT * FROM actividad");

	// 		while(rs.next()) {

	// 			Ski actividad = new Ski(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("aforo"),
	// 					rs.getString("instructor"), rs.getString("ubicacion"), rs.getString("descripcion"),
	// 					rs.getString("imagen"), rs.getInt("cantMaterial"));
	// 			if (actividad.getNombre() == "Ski") {
	// 				listaSki.add(actividad);
	// 			}
	// 		}
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
	// 	return listaSki;
	// }

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

	// public List<Surf> getListaSurf(){

	// 	List<Surf> listaSurf = new ArrayList<Surf>();

	// 	try(Statement stmt = (Statement) conn.createStatement()) {

	// 		ResultSet surf = stmt.executeQuery("SELECT * FROM actividad WHERE nombre = Surf");

	// 		while(surf.next()) {

	// 			Surf actividad = new Surf(surf.getString("codigo"), surf.getString("nombre"), surf.getInt("aforo"), surf.getString("instructor"), surf.getString("ubicacion"), surf.getString("descripcion"), surf.getString("imagen"), surf.getInt("cantMaterial"));
	// 			listaSurf.add(actividad);
	// 		}
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
	// 	return listaSurf;
	// }
}