package procesamiento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import modelo.Actividad;
import modelo.Participante;

public class Proyecto {
	
	//private Proyecto nombre;
	private String descripcion;
	private Participante dueño; //Queda por defecto
	private ArrayList<Participante> participantes;
	private String fechain;
	private String fechafin;
	private ArrayList<String> tipos;
	private HashMap<String,Actividad> actividades;
	
	
	public Proyecto( String descripcion1, Participante dueño1, String correo, String fechain1, String fechafin1,ArrayList<String> tipos1)
	{
		//this.nombre = nombre1;
		this.descripcion = descripcion1;
		this.dueño=dueño1;
		this.fechain = fechain1;
		this.fechafin = fechafin1;
		this.tipos = tipos1;
		this.participantes = new ArrayList<Participante>();
		this.actividades = new HashMap<String,Actividad>();
	
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Participante getDueño() {
		return dueño;
	}
	
	public String getfechain() {
		return fechain;
	}
	
	public String getfechafin() {
		return fechafin;
	}
	
	public ArrayList<String> getTiposActividades() {
		return tipos;
	}
	
	public HashMap<String,Actividad> getActividades() {
		return actividades;
	}
	
	public ArrayList<Participante> getParticipantes() {
		return participantes;								
	}
	
	public void AgregarParticipantes( Participante participante) {////
		participantes.add(participante);
	}
	
	public void FechaFinal() {
		String pattern = "dd-MM-yyyy";
		String fechafinal = new SimpleDateFormat(pattern).format(new Date());
		fechafin = fechafinal;
	}
	
	
	
	
	
	
	
}
