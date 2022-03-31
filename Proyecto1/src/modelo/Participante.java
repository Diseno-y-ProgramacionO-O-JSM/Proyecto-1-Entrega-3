package modelo;

import java.util.ArrayList;

public class Participante {
	
	private String nombre;
	private String correo;
	private ArrayList<Actividad> actividades;
	private Boolean dueño;
	private Integer id;
	

	public Participante(String nombre, String correo, Integer num, Boolean dueño1) {
		
		this.nombre = nombre;
		this.correo = correo;
		this.id = num; 
		this.actividades = new ArrayList<Actividad>();
		this.dueño = dueño1;
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
	
	void CambiarADueño() {
		dueño = true;
	}
	
	
}
