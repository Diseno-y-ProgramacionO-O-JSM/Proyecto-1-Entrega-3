package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import modelo.Actividad;
import modelo.Cronometro;
import modelo.Dueño;
import modelo.Participante;
import procesamiento.Proyecto;

public class ControladorProyectos {

		HashMap<String, Participante> participantes = new HashMap<>();
		HashMap<String, Proyecto> proyectos = new HashMap<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		/**
		 * Ejecuta la aplicaciÃ³n: le muestra el menÃº al usuario y la pide que ingrese
		 * una opciÃ³n, y ejecuta la opciÃ³n seleccionada por el usuario. Este proceso se
		 * repite hasta que el usuario seleccione la opciÃ³n de abandonar la aplicaciÃ³n.
		 */
		public void ejecutarAplicacion()
		{
			System.out.println("PROYECTOS\n");
			Instant Temporizador = null;

			boolean continuar = true;
			while (continuar)
			{
				try
				{
					mostrarMenu();
					int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
					if (opcion_seleccionada == 1)
						RegistroUsuario();
					else if (opcion_seleccionada == 2 )
						CrearProyecto();
					else if (opcion_seleccionada == 4 )
						Temporizador=IniciarActividad();
					else if (opcion_seleccionada == 3 )
						AgregarParticipante();
					else if (opcion_seleccionada == 5 )
						RegistrarActividad();
					else if (opcion_seleccionada == 6 )
						FinalizarActividad(Temporizador);
					else if (opcion_seleccionada == 7 )
						FinalizarProyecto();
					else if (opcion_seleccionada == 8 )
						GenerarReporte();
					
					else if (opcion_seleccionada == 9)
					{
						System.out.println("Saliendo de la aplicaciÃ³n ...");
						continuar = false;
					}
					else
					{
						System.out.println("Por favor seleccione una opciÃ³n vÃ¡lida.");
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los numeros de las opciones.");
				}
			}
			}
			/**
			 * Muestra al usuario el menu con las opciones para que escoja la siguiente
			 * accion que quiere ejecutar.
			 */
			public void mostrarMenu()
			{
				
				
				System.out.println("\nOpciones de la aplicacion\n");
				System.out.println("1. Registrar usuario");
				System.out.println("2. Crear proyecto"); 
				System.out.println("3. Agregar participante");
				System.out.println("4. Iniciar actividad");
				System.out.println("5. Registrar actividad fuera de tiempo");
				System.out.println("6. Finalizar actividad");
				System.out.println("7. Finalizar proyecto");
				System.out.println("8. Reporte usuario");
			
				System.out.println("9. Salir de la aplicacion\n");
			}
		
			
			private void RegistroUsuario() {
				String nombre = input("Ingrese su nombre");
				String correo = input("Ingrese su correo");
				
				Random numAleatorio = new Random();
				int id = numAleatorio.nextInt(1000) + 1;
				
				Participante elParticipante = participantes.get(nombre);
				if (elParticipante == null);
					elParticipante = new Participante(nombre, correo, id, false);
					participantes.put(nombre, elParticipante);
				
			}
			
			private void CrearProyecto() {
				//Por defecto el que creó el proyecto queda como dueño
				
				String nombre = input("Ingrese el nombre del proyecto");
					
				Proyecto elProyecto = proyectos.get(nombre);
				if (elProyecto == null)
				{
					String dueño = input("Por ser la persona que va a crear este proyecto quedará asignado como el dueño\n Ingrese su nombre");
					
					Participante elParticipante = participantes.get(dueño);
					if (elParticipante == null) {
						System.out.println("No se ha registrado como usuario el participante");}
					else {
						String correo = elParticipante.getCorreo();
						String descripcion = input("Ingrese una descripcion para el proyecto");
						String tiposs = input("Ingrese los tipos de actividades que se podran realizar en este proyecto separados por comas");
						String pattern = "dd-MM-yyyy";
						String fechain = new SimpleDateFormat(pattern).format(new Date());
						System.out.println(fechain);
						String fechafin = null; //Finalizar proyecto
						
						
						ArrayList<String> tipos = new ArrayList<String>(Arrays.asList(tiposs.split(",")));					
						
						elProyecto = new Proyecto( descripcion, elParticipante, correo, fechain, fechafin, tipos);				
						proyectos.put(nombre, elProyecto);
						
						elProyecto.AgregarParticipantes(elParticipante);
						System.out.println(elProyecto.getDescripcion());
						System.out.println(elProyecto.getDueño().getNombre());
						System.out.println(tipos);
						
					}
					
					
				}
				else {
					Participante dueño = elProyecto.getDueño();
					System.out.println("-Ya existe un proyecto con ese nombre creado por "+ dueño.toString()+"-");
				}
				}
			
			private Instant IniciarActividad(){
				//Puede ser a nombre de cualquier persona
			
				
				String proy = input("Ingrese el nombre del proyecto");
				
				Proyecto elProyecto = proyectos.get(proy);
				
				if (elProyecto == null) {
					System.out.println("El proyecto no existe");
					}
				else {
					String nombre = input("Ingrese el nombre de la actividad");
					
					HashMap<String, Actividad> map = elProyecto.getActividades();
					Actividad laActividad = map.get(nombre);
					if (laActividad == null) {
						
						String part = input("Ingrese su nombre");
						Participante elParticipante = participantes.get(part);
						if (elParticipante == null) {
							System.out.println("No se ha registrado como usuario el participante");
							}
						else {
							String descripcion = input("Ingrese una descripcion de la actividad");
							System.out.println("Elija un tipo de actividad:");
							System.out.println(elProyecto.getTiposActividades());
							String tipo = input("");
							String pattern = "dd-MM-yyyy";
							String fechain = new SimpleDateFormat(pattern).format(new Date());
							String fechafin = null;
							String horain = LocalTime.now().format(formatter);
							String horafin = null;
							laActividad = new Actividad(nombre, descripcion, tipo, fechain, fechafin, horain,horafin,elParticipante);
							map.put(nombre,laActividad);
						}
					}
					else {
						
						String part = input("Ingrese su nombre");
						Participante participante = laActividad.getParticipante();
					
						
					}
				}
			
				
				
				Instant Inicial= Actividad.IniciarCronometro();
				return Inicial;
				
				}
			private void AgregarParticipante(){
				//Cualquier persona registrada podrá agregar participantes a una actividad
				;
				
				}
			
			private void RegistrarActividad() {
				
				;
				}

			private void FinalizarActividad(Instant HoraIn) {
				
				Actividad.FinalizarCronometro(HoraIn);
			}
			
			private void FinalizarProyecto() {
				
				;
				}
			
			private void GenerarReporte() {
				
				;
				}	
			
			
			public String input(String mensaje)
			{
				try
				{
					System.out.print(mensaje + ": ");
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					return reader.readLine();
				}
				catch (IOException e)
				{
					System.out.println("Error leyendo de la consola");
					e.printStackTrace();
				}
				return null;
			}
			
			public static void main(String[] args)
			{
				ControladorProyectos consola = new ControladorProyectos();
				consola.ejecutarAplicacion();
			}
			
			

}
