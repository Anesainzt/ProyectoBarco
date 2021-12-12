package clases;

import java.util.List;

public class Usuario{
	
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected String tarjeta;
	protected String login;
	protected String contrasenya;
	protected String email;
	protected List<Viaje> listaViajes;

	
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getTarjeta() {
		return tarjeta;
	}


	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}


	public String getEmail() {
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