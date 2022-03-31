package modelo;


import java.time.Instant;
import java.util.ArrayList;


public class Actividad {
	public Actividad(String nombre, String descripcion, String tipo, String fecha, //Time horaInicio, Time horaFin,
			String participante, int tiempoTotal) {
		
		this.Nombre = nombre;
		this.Descripcion = descripcion;
		this.Tipo = tipo;
		this.Fecha = fecha;
		//this.HoraInicio = horaInicio;
		//this.HoraFin = horaFin;
		this.Participante = participante;
		this.TiempoTotal = tiempoTotal;
	}

	private String Nombre;
	private String Descripcion;
	private String Tipo;
	private String Fecha;
	//private Time HoraInicio;
	//private Time HoraFin;
	private String Participante;
	private int TiempoTotal;
	


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

	public String getParticipante() {
		return Participante;
	}

	public int getTiempoTotal() {
		return TiempoTotal;
	}
	
	void ModificarFecha() {
		;
	}
	void ModificarHora() {
		;
	}
	public static Instant IniciarCronometro() {
		Instant Inicio=Cronometro.Instante();
		;
		return Inicio;
	}
	void PausarCronometro() {
		;
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
