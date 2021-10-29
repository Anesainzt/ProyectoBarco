package ventana;

import java.io.*;
import java.sql.*;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import Clases.Usuario;

public class BD extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private static Logger logger = Logger.getLogger(BD.class.getName());
	
	//METODO PARA ESCRIBIR EN LOS FICHEROS
	public void escribirFichero(String fichero, String texto) {
		PrintWriter pw = null;
		try {
		    pw = new PrintWriter(new BufferedWriter(new FileWriter(fichero, true)));
		    pw.print(texto);
		    
		} catch (IOException e1) {
			logger.warning(e1.getMessage());
		} finally {
		    if (pw != null) {
		        pw.close();
		    }
		}
	}
	
	//CONECTA Y DESCONECTAR LA BD
	public void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:dataBase.db");
		} catch (ClassNotFoundException e) {
			logger.warning("Error cargando el driver de la BD");
		} catch (SQLException e) {
			logger.warning("Error conectando a la BD");
		}
	}
	
	public void disconnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			logger.warning(e.getMessage());
		}
	}
	
	//REGISTRAR EN LA BD UN CLIENTE NUEVO
	public void registro(Usuario unuevo) {
		try {			
			PreparedStatement pstmt = conn.prepareStatement("UPDATE usuario SET nombre = ?, apellido = ?, dni = ?, tarjeta = ? WHERE login = '"+ unuevo.getLogin() +"' AND contraseya = '"+ unuevo.getContraseña() +"';");
			
			pstmt.setString(1, unuevo.getNombre());
			pstmt.setString(2, unuevo.getApellido());
			pstmt.setString(3, unuevo.getDni());
			pstmt.setString(4, unuevo.getTarjeta());
			//...
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e2) {
			logger.warning(e2.getMessage());
		} 	
	}
	//MÉTODO para comprobar login --> miramos si COINDIDE el login && password
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

						//LLAMADA A LOGGER
						logger.warning("El login se ha realizado correctamente.");

						return true;
					}	
				}
				JOptionPane.showMessageDialog(null, "¡Contraseña o usuario incorrectos!", "Error", JOptionPane.ERROR_MESSAGE);

				ps.close();
				return false;


			} catch (Exception e) {

				//logger --> por si falla
				logger.warning("Ha habido un error al hacer el login. " + e.getMessage());
				e.printStackTrace();

				return false; //si no funciona pues devuelve false xd
			}
		}
	
	
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
	}
	
	
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
				cl.setContraseña(contraseya);
				
				
			}
			
		} catch (SQLException e2) {
			logger.warning(e2.getMessage());
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
			logger.warning(e2.getMessage());
		}
	}
	
	//MIRA QUE DIAS SE QUEDA EL CLIENTE EN EL BARCO Y SOLO DEJA COGER LA ACTIVIDAD DENTRO DE LAS FECHAS
	public void reservaActividad(String fechaEntrada, String fechaSalida, String tipo, String numero, Usuario usuario) {
		try(Statement stmt = (Statement) conn.createStatement()) {	
			int res2 = stmt.executeUpdate("INSERT INTO historialregistros VALUES('"+ fechaEntrada +"', '"+ fechaSalida +"', "+ Integer.parseInt(numero) +", '"+ usuario.getLogin() +"', 1);");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	
	
	//EN EL CASO DE QUE RESERVES UNA ACTIVIDAD INTRODUCIR EN LA TABLA ACTIVIDAD LOS DATOS
	public void actividad(Usuario usuario, String fecha, String tipo) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO actividades VALUES(?, ?, ?);");
			
			pstmt.setString(1, fecha);
			pstmt.setString(2, tipo);
			pstmt.setString(3, usuario.getLogin());

			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
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
		
	}
	
	
	
	
}