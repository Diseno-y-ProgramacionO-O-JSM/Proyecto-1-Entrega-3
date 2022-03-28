package modelo;

public class Dueño {

	private String nombre;
	private String correo;

	
	public Dueño(String nombre1, String correo1) {
		this.nombre = nombre1;
		this.correo = correo1;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	}
