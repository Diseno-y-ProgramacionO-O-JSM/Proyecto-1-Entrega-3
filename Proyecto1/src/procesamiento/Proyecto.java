package procesamiento;

import java.util.ArrayList;

import modelo.Dueño;
import modelo.Participante;

public class Proyecto {
	
	//private Proyecto nombre;
	private String descripcion;
	private Dueño dueño; //Queda por defecto
	private ArrayList<Participante> participantes;
	private String fechain;
	private String fechafin;
	private ArrayList<String> tipos;
	
	
	public Proyecto( String descripcion1, String dueño1, String correo, String fechain1, String fechafin1,ArrayList<String> tipos1)
	{
		//this.nombre = nombre1;
		this.descripcion = descripcion1;
		this.dueño = new Dueño(dueño1, correo); /// crear dueño
		this.fechain = fechain1;
		this.fechafin = fechafin1;
		this.tipos = new ArrayList<String>();
		this.participantes = new ArrayList<Participante>();
	
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Dueño getDueño() {
		return dueño;
	}
	
	public String getfechain() {
		return fechain;
	}
	
	public String getfechafin() {
		return fechafin;
	}
	
	public ArrayList<String> getTiposAvtividades() {
		return tipos;
	}
	
	public ArrayList<Participante> getParticipantes() {
		return participantes;								
	}
	
	public void AgregarParticipantes( Participante participante) {////
		participantes.add(participante);
	}
	
	
	
	
	
}
