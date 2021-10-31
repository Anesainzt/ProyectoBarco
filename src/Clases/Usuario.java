package Clases;



public class Usuario{
	protected static String nombre;
	protected static String apellido;
	protected static String dni;
	protected static String tarjeta;
	protected static String login;
	protected static String contrasenya;
	protected static String email;

	
	public Usuario(String nombre, String apellido, String dni, String tarjeta, String login, String contrasenya, String email) {
		
		Usuario.nombre = nombre;
		Usuario.apellido = apellido;
		Usuario.dni = dni;
		Usuario.tarjeta = tarjeta;
		Usuario.login = login;
		Usuario.contrasenya = contrasenya;
		Usuario.email = email;
		
	}


	public Usuario() {
		
		Usuario.nombre = "";
		Usuario.apellido = "";
		Usuario.dni = "";
		Usuario.tarjeta = "";
		Usuario.login = "";
		Usuario.contrasenya = "";
		Usuario.email = "";
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
	
	public static String getContrasenya() {
		return contrasenya;
	}
	
	public void setContrasenya(String contrasenya) {
		Usuario.contrasenya = contrasenya;
	}


	public static String getEmail() {
		return email;
	}


	public static void setEmail(String email) {
		Usuario.email = email;
	}
	
	
	
}