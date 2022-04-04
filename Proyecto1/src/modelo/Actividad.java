package modelo;


import java.time.Instant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Actividad {
	private String Nombre;
	private String Descripcion;
	private String Tipo;
	private String Fecha1; //fechas que varían para hacer calculos
	private String FechaIn;
	private String FechaFin;
	private String HoraInicio;
	private String HoraFin;
	private Participante participante;
	private Proyecto proyecto;
	private int TiempoTotal; //mins

	
	public Actividad(String nombre, String descripcion, String tipo, String fecha, String fechafin,String horaInicio, String horaFin,
			Participante participante1, Proyecto proyecto1) {
		
		this.Nombre = nombre;
		this.Descripcion = descripcion;
		this.Tipo = tipo;
		this.FechaIn = fecha;
		this.FechaFin = fechafin;
		this.HoraInicio = horaInicio;
		this.HoraFin = horaFin;
		this.participante = participante1;
		this.TiempoTotal = 0;
		this.Fecha1=null;
		this.proyecto=proyecto1;
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
		return FechaIn;
	}
	
	public void newFechaIn(String FechaIn) {
		Fecha1 = FechaIn;
		
	}
	
	public String getFechaFin() {
		return FechaFin;
	}
	
	public void newFechaFin(String Fechafin) {
		FechaFin = Fechafin;
	}

	public String getHoraInicio() {
		return HoraInicio;
	}
	
	public void newHoraIn(String Horain) {
		HoraInicio = Horain;
	}

	public String getHoraFin() {
		return HoraFin;
	}
	
	public void newHoraFin(String Horafin) {
		HoraFin = Horafin;
	}

	public Participante getParticipante() {
		return participante;
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public ArrayList<Integer> getTiempoTotal(String FechaIn, String HoraIn,String FechaFin,String HoraFin) {
	
		String FechaI = FechaIn+" "+HoraIn+":00";
		String FechaF = FechaFin+" "+HoraFin+":00";
		
		ArrayList<Integer> tiempos = tiemposs(FechaI, FechaF);
		
		Integer mins = tiempos.get(0)*525960 + tiempos.get(1)*1440+tiempos.get(2)*60+tiempos.get(3); //hola :)
		if (mins>=0)
			TiempoTotal = TiempoTotal + mins;
		else {
			System.out.println("Los valores de las horas que acaba de ingresar son incoherentes (la hora de fin es menor que la de incio)");
		}
		
		
		return tiempos;
	}
	
	public Integer getTiempo() {
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
	
	public  ArrayList<Integer> tiemposs(String start_date, String end_date)
    {
  
        SimpleDateFormat sdf
            = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");
  
        try {
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);
 
            long difference_In_Time
                = d2.getTime() - d1.getTime();
  
            long difference_In_Seconds
                = (difference_In_Time
                   / 1000)
                  % 60;
  
            long difference_In_Minutes
                = (difference_In_Time
                   / (1000 * 60))
                  % 60;
  
            long difference_In_Hours
                = (difference_In_Time
                   / (1000 * 60 * 60))
                  % 24;
  
            long difference_In_Years
                = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));
  
            long difference_In_Days
                = (difference_In_Time
                   / (1000 * 60 * 60 * 24))
                  % 365;
  
            
            
            int deltaSegundos = (int) difference_In_Seconds;
            int deltaMinutos = (int) difference_In_Minutes;
            int deltaHoras = (int) difference_In_Hours;
            int deltaAnios  = (int) difference_In_Years;
            int deltaDias  = (int) difference_In_Days;
            
            ArrayList<Integer> reporte = new ArrayList<Integer>();
            reporte.add(deltaAnios);
            reporte.add(deltaDias);
            reporte.add(deltaHoras);
            reporte.add(deltaMinutos);     
            reporte.add(deltaSegundos);
            
            return reporte;
        }
  
        // Catch the Exception
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
		
    }
	
}
