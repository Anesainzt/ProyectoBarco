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
	protected int administrador;
	protected List<Billete> listaBilletes;

	public Usuario(String nombre, String apellido, String dni, String tarjeta, String login, String contrasenya, String email, int administrador, List<Billete> listaBilletes) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tarjeta = tarjeta;
		this.login = login;
		this.contrasenya = contrasenya;
		this.email = email;
		this.administrador = administrador;
		this.listaBilletes = listaBilletes;
	}

	public Usuario() {
		this.nombre = "";
		this.apellido = "";
		this.dni = "";
		this.tarjeta = "";
		this.login = "";
		this.contrasenya = "";
		this.email = "";
		this.administrador= 0;
		this.listaBilletes = null;
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

	public int getAdministrador() {
		return administrador;
	}

	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}
	
	public List<Billete> getListaBilletes() {
		return listaBilletes;
	}

	public void setListaBilletes(List<Billete> listaBilletes) {
		this.listaBilletes = listaBilletes;
	}


}