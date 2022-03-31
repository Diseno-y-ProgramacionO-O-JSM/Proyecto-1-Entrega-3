package procesamiento;

import java.util.ArrayList;

import modelo.Due�o;
import modelo.Participante;

public class Proyecto {
	
	//private Proyecto nombre;
	private String descripcion;
	private Participante due�o; //Queda por defecto
	private ArrayList<Participante> participantes;
	private String fechain;
	private String fechafin;
	private ArrayList<String> tipos;
	
	
	public Proyecto( String descripcion1, Participante due�o1, String correo, String fechain1, String fechafin1,ArrayList<String> tipos1)
	{
		//this.nombre = nombre1;
		this.descripcion = descripcion1;
		this.due�o=due�o1;
		this.fechain = fechain1;
		this.fechafin = fechafin1;
		this.tipos = tipos1;
		this.participantes = new ArrayList<Participante>();
	
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Participante getDue�o() {
		return due�o;
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
	
	public ArrayList<Participante> getParticipantes() {
		return participantes;								
	}
	
	public void AgregarParticipantes( Participante participante) {////
		participantes.add(participante);
	}
	
	
	
	
	
}
