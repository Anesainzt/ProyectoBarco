package Clases;



import java.util.ArrayList;
import java.util.HashMap;

public class Usuario{
	protected static String nombre;
	protected static String apellido;
	protected static String dni;
	protected static String fecha_ncto;
	protected static String tarjeta;
	protected static String login;
	protected static String password;

	
	public Usuario(String nombre, String apellido, String dni, String fecha_ncto, String tarjeta, String login, String password) {
		
		Usuario.nombre = nombre;
		Usuario.apellido = apellido;
		Usuario.dni = dni;
		Usuario.fecha_ncto = fecha_ncto;
		Usuario.tarjeta = tarjeta;
		Usuario.login = login;
		Usuario.password = password;
		
	}


	public Usuario() {
		
		Usuario.nombre = "";
		Usuario.apellido = "";
		Usuario.dni = "";
		Usuario.fecha_ncto = "";
		Usuario.tarjeta = "";
		Usuario.login = "";
		Usuario.password = "";
		
	}
	

	public static String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		Usuario.nombre = nombre;
	}

	public static String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		Usuario.apellido = apellido;
	}
	
	public static String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		Usuario.dni = dni;
	}
	
	public static String getFechaNcto() {
		return fecha_ncto;
	}
	
	public void setFechaNcto(String fecha_ncto) {
		Usuario.fecha_ncto = fecha_ncto;
	}
	
	public static String getTarjeta() {
		return tarjeta;
	}
	
	public void setTarjeta(String tarjeta) {
		Usuario.tarjeta = tarjeta;
	}
	
	public static String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		Usuario.login = login;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		Usuario.password = password;
	}
	
}