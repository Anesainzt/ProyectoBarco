package clases;

import java.util.List;

public class Usuario{
	
	protected static String nombre;
	protected static String apellido;
	protected static String dni;
	protected static String tarjeta;
	protected static String login;
	protected static String contrasenya;
	protected static String email;
	protected static List<Viaje> listaViajes;

	
	public Usuario(String nombre, String apellido, String dni, String tarjeta, String login, String contrasenya, String email, List<Viaje> listaViajes) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tarjeta = tarjeta;
		this.login = login;
		this.contrasenya = contrasenya;
		this.email = email;
		this.listaViajes = listaViajes;
		
	}


	public Usuario() {
		
		this.nombre = "";
		this.apellido = "";
		this.dni = "";
		this.tarjeta = "";
		this.login = "";
		this.contrasenya = "";
		this.email = "";
		this.listaViajes = null;
	}


	public static String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public static String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public static String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public static String getTarjeta() {
		return tarjeta;
	}


	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}


	public static String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public static String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}


	public static String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Viaje> getListaViajes() {
		return listaViajes;
	}


	public void setListaViajes(List<Viaje> listaViajes) {
		this.listaViajes = listaViajes;
	}
	
	
}