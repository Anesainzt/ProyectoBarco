package ventana;

import java.awt.Color;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

public class BD extends JFrame{
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
			conn = DriverManager.getConnection("jdbc:sqlite:hotelJava.db");
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
	public void registro(Cliente nuevo) {
		try {			
			PreparedStatement pstmt = conn.prepareStatement("UPDATE cliente SET nombre = ?, apellido = ?, dni = ?, tarjeta = ? WHERE usuario = '"+ nuevo.getLogin() +"' AND contraseya = '"+ nuevo.getPassword() +"';");
			
			pstmt.setString(1, nuevo.getNombre());
			pstmt.setString(2, nuevo.getApellido());
			pstmt.setString(3, nuevo.getDni());
			pstmt.setString(4, nuevo.getTarjeta());
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e2) {
			logger.warning(e2.getMessage());
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
	public Cliente cliente(String usu, String password) {
		Cliente cl = new Cliente();
		try(Statement stmt = (Statement) conn.createStatement()) {
			//SELECIONAR A QUE CLIENTE CORRESPONDE EL USUARIO Y CONTRASE�A ESCRITOS
			ResultSet cliente = stmt.executeQuery("SELECT nombre, apellido, dni, contraseya, usuario FROM cliente WHERE (usuario = '" + usu + "' AND contraseya = '"+ password +"');");
			while(cliente.next()) {
				String nombreBD = cliente.getString("nombre");
				String apellidoBD = cliente.getString("apellido");
				String dniBD = cliente.getString("dni");
				String contraseya = cliente.getString("contraseya");
				String usuario = cliente.getString("usuario");
				
				cl.setNombre(nombreBD);
				cl.setApellido(apellidoBD);
				cl.setDni(dniBD);
				cl.setPassword(contraseya);
				cl.setLogin(usuario);
				
			}
			
		} catch (SQLException e2) {
			logger.warning(e2.getMessage());
		}
		return cl;
	}
	
	//MIRAR EN LA BD CUALES HAN SIDO SUS RESERVAS ANTERIORES
	public void historial(Cliente cliente, DefaultTableModel modelo) {
		try(Statement stmt = (Statement) conn.createStatement()) {	
			
			Integer numFilas = 0 ;
			ResultSet res1 = stmt.executeQuery("SELECT COUNT(usuario) numero FROM historialregistros WHERE usuario = '"+ cliente.getLogin() +"'");
			
			while (res1.next()) {
				numFilas = res1.getInt("numero");
			}
			
			String [] tabla = new String[3];
			
			
			int i = 0;
			ResultSet res2 = stmt.executeQuery("SELECT fechaEntrada, fechaSalida, tipo FROM historialregistros WHERE usuario = '"+ cliente.getLogin() +"'");
			while(res2.next()) {
				
				String fila = res2.getString("fechaEntrada");
				tabla[0] = fila;
				fila = res2.getString("fechaSalida");
				tabla[1] = fila;
				fila = res2.getString("tipo");
				tabla[2] = fila;
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
	public void servicio(String fechaEntrada, String fechaSalida, String tipo, String numero, Cliente cliente) {
		try(Statement stmt = (Statement) conn.createStatement()) {	
			int res2 = stmt.executeUpdate("INSERT INTO historialregistros VALUES('"+ fechaEntrada +"', '"+ fechaSalida +"', '"+ tipo +"', "+ Integer.parseInt(numero) +", '"+ cliente.getLogin() +"', 1);");
		} catch (SQLException e2) {
			e2.printStackTrace();;
		}
	}
	
	//MUESTRA CUANDO SE HA HECHO LA RESERVA
	public String getHoraReserva(String fichero) {
		
    	String linea = null;
		Scanner sc1 = null;
		String hora = "";
		try {
			sc1 = new Scanner(new FileInputStream(fichero));

			while(sc1.hasNext()) {
				linea = sc1.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return linea;
	}
	
	
	
	
	//EN EL CASO DE QUE RESERVES UNA ACTIVIDAD INTRODUCIR EN LA TABLA CLASES LOS DATOS
	public void eleccionClaseDeporte(Cliente cliente, String fecha, String tipo) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO clases VALUES(?, ?, ?);");
			
			pstmt.setString(1, fecha);
			pstmt.setString(2, tipo);
			pstmt.setString(3, cliente.getLogin());

			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//MIRAR QUE ACTIVIDADES ESTÁN RESEVADAS PARA HOY
	public void clasesHoy(DefaultTableModel modelo2) {
	
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
			
			ResultSet res = stmt.executeQuery("SELECT usuario, tipo FROM clases WHERE fechaClase = '"+ hoy +"'");
			while (res.next()) {
				
				String fila =  res.getString("usuario");
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