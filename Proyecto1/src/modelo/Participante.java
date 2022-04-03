package modelo;

import java.util.ArrayList;

public class Participante {
	
	private String nombre;
	private String correo;
	private ArrayList<Actividad> actividades;
	private Integer id;
	

	public Participante(String nombre, String correo, Integer num) {
		
		this.nombre = nombre;
		this.correo = correo;
		this.id = num; 
		this.actividades = new ArrayList<Actividad>();
	}




	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public ArrayList<Actividad> getActividades() {
		return actividades;
	}
	
	public void agregarActividad(Actividad actividad) {
		actividades.add(actividad);
	}
	
}
