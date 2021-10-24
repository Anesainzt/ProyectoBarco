package Clases;



public class Usuario{
	protected static String nombre;
	protected static String apellido;
	protected static String dni;
	protected static String tarjeta;
	protected static String login;
	protected static String contraseña;

	
	public Usuario(String nombre, String apellido, String dni, String tarjeta, String login, String contraseña) {
		
		Usuario.nombre = nombre;
		Usuario.apellido = apellido;
		Usuario.dni = dni;
		Usuario.tarjeta = tarjeta;
		Usuario.login = login;
		Usuario.contraseña = contraseña;
		
	}


	public Usuario() {
		
		Usuario.nombre = "";
		Usuario.apellido = "";
		Usuario.dni = "";
		Usuario.tarjeta = "";
		Usuario.login = "";
		Usuario.contraseña = "";
		
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
	
	public static String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		Usuario.contraseña = contraseña;
	}
	
}