package modelo;


import java.time.Instant;
import java.util.ArrayList;


public class Actividad {
	private String Nombre;
	private String Descripcion;
	private String Tipo;
	private String Fecha;
	//private Time HoraInicio;
	//private Time HoraFin;
	private Participante participante;
	private int TiempoTotal; //min
	private int DiasTrabajados;
	
	public Actividad(String nombre, String descripcion, String tipo, String fecha, String fechafin,String horaInicio, String horaFin,
			Participante participante1) {
		
		this.Nombre = nombre;
		this.Descripcion = descripcion;
		this.Tipo = tipo;
		this.Fecha = fecha;
		//this.HoraInicio = horaInicio;
		//this.HoraFin = horaFin;
		this.participante = participante1;
		this.TiempoTotal = 0;
		this.DiasTrabajados = 0;
	}


	public String getNombre() {
		return Nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public String getTipo() {
		return Tipo;
	}

	public String getFecha() {
		return Fecha;
	}

	//public Time getHoraInicio() {
		//return HoraInicio;
	//}

	//public Time getHoraFin() {
		//return HoraFin;
	//}
	
	//public int getDiasTrabajados()
	//Hacer calculos

	public Participante getParticipante() {
		return participante;
	}

	public int getTiempoTotal() {
		return TiempoTotal;
	}
	
	
	public static Instant IniciarCronometro() {
		Instant Inicio=Cronometro.Instante();
		;
		return Inicio;
	}
	
	public static void FinalizarCronometro(Instant Inicial) {
		Instant Fin=Cronometro.Instante();
		Cronometro.Calcular(Inicial,Fin);
		;
	}
	void RegistrarTiempo() {
		;
	}
	
}
