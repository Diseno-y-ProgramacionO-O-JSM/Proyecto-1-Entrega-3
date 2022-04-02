package modelo;


import java.time.Instant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Actividad {
	private String Nombre;
	private String Descripcion;
	private String Tipo;
	private String Fecha;
	private String FechaFin;
	private String HoraInicio;
	private String HoraFin;
	private Participante participante;
	private int TiempoTotal; //mins
	private int DiasTrabajados;
	
	public Actividad(String nombre, String descripcion, String tipo, String fecha, String fechafin,String horaInicio, String horaFin,
			Participante participante1) {
		
		this.Nombre = nombre;
		this.Descripcion = descripcion;
		this.Tipo = tipo;
		this.Fecha = fecha;
		this.FechaFin = fechafin;
		this.HoraInicio = horaInicio;
		this.HoraFin = horaFin;
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
	
	public void newFechaIn(String FechaIn) {
		Fecha = FechaIn;
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
	
	//public int getDiasTrabajados()
	//Hacer calculos

	public Participante getParticipante() {
		return participante;
	}

	public void getTiempoTotal(String FechaIn, String HoraIn,String FechaFin,String HoraFin) {
		String FechaI = FechaIn+" "+HoraIn+":00";
		String FechaF = FechaFin+" "+HoraFin+":00";
		ArrayList<Integer> tiempos = findDifference(FechaI, FechaF);
		
		Integer mins = tiempos.get(0)*525960 + tiempos.get(1)*1440+tiempos.get(2)*60+tiempos.get(3); //hola :)
		
		Integer dias = tiempos.get(1);
		
		TiempoTotal = TiempoTotal + mins;
		DiasTrabajados = DiasTrabajados + dias;
		
		System.out.println(TiempoTotal);
		System.out.println(DiasTrabajados);
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
	
	
	
	public  ArrayList<Integer> findDifference(String start_date, String end_date)
    {
  
        SimpleDateFormat sdf
            = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");
  
        // Try Block
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
  
            
            int deltaTiempo = (int) difference_In_Time;
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
