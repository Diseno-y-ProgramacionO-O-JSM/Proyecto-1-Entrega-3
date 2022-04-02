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
import modelo.Due�o;
import modelo.Participante;
import procesamiento.Proyecto;

public class ControladorProyectos {

		HashMap<String, Participante> participantes = new HashMap<>();
		HashMap<String, Proyecto> proyectos = new HashMap<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		Actividad actividad = null;
		ArrayList<Integer> ListaAbreYCierra = new ArrayList<Integer>();
		
		/**
		 * Ejecuta la aplicación: le muestra el menú al usuario y la pide que ingrese
		 * una opción, y ejecuta la opción seleccionada por el usuario. Este proceso se
		 * repite hasta que el usuario seleccione la opción de abandonar la aplicación.
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
					ListaAbreYCierra.add(opcion_seleccionada);
					if (opcion_seleccionada == 1)
						RegistroUsuario();
					else if (opcion_seleccionada == 2 )
						CrearProyecto();
					else if (opcion_seleccionada == 3 )
						AgregarParticipante();
					else if (opcion_seleccionada == 4 )
						Temporizador=IniciarActividad();
					else if (opcion_seleccionada == 5 )
						RegistrarActividad();
					else if (opcion_seleccionada == 6 )
						FinalizarActividad(Temporizador);
					else if (opcion_seleccionada == 7 )
						FinalizarProyecto();
					else if (opcion_seleccionada == 8 )
						if ((ListaAbreYCierra.stream().filter(t->t.equals(4)).count()) == 0){System.out.println("No se puede generar un reporte porque no se ha completado alguna actividad.");}
						else if ((ListaAbreYCierra.stream().filter(t->t.equals(4)).count()) == (ListaAbreYCierra.stream().filter(t->t.equals(6)).count()))
						{GenerarReporte();
					    	}
					
					else if (opcion_seleccionada == 9)
					{
						System.out.println("Saliendo de la aplicacion ...");
						continuar = false;
					}
					else
					{
						System.out.println("Por favor seleccione una opcion valida.");
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
				System.out.println("3. Agregar participante al proyecto");
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
				//Por defecto el que cre� el proyecto queda como due�o
				
				String nombre = input("Ingrese el nombre del proyecto");
					
				Proyecto elProyecto = proyectos.get(nombre);
				if (elProyecto == null)
				{
					String due�o = input("Por ser la persona que va a crear este proyecto quedar� asignado como el due�o\nIngrese su nombre");
					
					Participante elParticipante = participantes.get(due�o);
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
						System.out.println(elProyecto.getDue�o().getNombre());
						System.out.println(tipos);
						
					}		
				}
				else {
					Participante due�o = elProyecto.getDue�o();
					System.out.println("-Ya existe un proyecto con ese nombre creado por "+ due�o.toString()+"-");
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
							
							ArrayList<String> Listita =elProyecto.getTiposActividades();
							
							
							for(int i = 0; i < Listita.size(); i++) {
					            System.out.println((i+1) + ": " +Listita.get(i));
					        }
					        
					        String EleccionAct = input("Digite el numero correspondiente a la actividad");
					        String tipo = Listita.get(Integer.parseInt(EleccionAct)-1);
					        
					        System.out.println(Listita.get(Integer.parseInt(EleccionAct)-1));
					        
					        
							String pattern = "dd-MM-yyyy";
							String fechain = new SimpleDateFormat(pattern).format(new Date());
							String fechafin = null;
							String horain = LocalTime.now().format(formatter);
							String horafin = null;
							laActividad = new Actividad(nombre, descripcion, tipo, fechain, fechafin, horain,horafin,elParticipante);
							actividad = laActividad;
							map.put(nombre,laActividad);
						}
					}
					else {
						
						String part = input("Ingrese su nombre");
						Participante participante = laActividad.getParticipante();
						String part2 = participante.getNombre();
						if (part.equals(part2)){
							String pattern = "dd-MM-yyyy";
							String fechain = new SimpleDateFormat(pattern).format(new Date());
							laActividad.newFechaIn(fechain);
							String fechafin = null;
							laActividad.newFechaFin(fechafin);
							String horain = LocalTime.now().format(formatter);
							laActividad.newHoraIn(horain);
							String horafin = null;
							laActividad.newHoraFin(horafin);
							actividad = laActividad;
						}
						else {
							System.out.println(part+part2);
							System.out.println("El participante que est� realizando esta actividad es otro.");
						}
						
					}
				}
			

				Instant Inicial= Actividad.IniciarCronometro();
				return Inicial;			
				}
			
			private void AgregarParticipante(){
				
				String proy = input("Ingrese el nombre del proyecto");
				
				Proyecto elProyecto = proyectos.get(proy);
				
				if (elProyecto == null) {
					System.out.println("El proyecto no existe");
					}
				else {
					String part = input("Ingrese el nombre del participante");
					
					Participante elParticipante = participantes.get(part);
					if (elParticipante == null) {
						System.out.println("No se ha registrado como usuario el participante");
						}
					else {
						elProyecto.AgregarParticipantes(elParticipante);
					}
				}
				
				}
			
			
			
			
			private void RegistrarActividad() {
				
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
							
							ArrayList<String> Listita =elProyecto.getTiposActividades();
							
							
							for(int i = 0; i < Listita.size(); i++) {
					            System.out.println((i+1) + ": " +Listita.get(i));
					        }
					        
					        String EleccionAct = input("Digite el numero correspondiente a la actividad");
					        String tipo = Listita.get(Integer.parseInt(EleccionAct)-1);
					        
							String fechain = input("Ingrese la fecha de inicio la forma dd-MM-yyyy");
							String fechafin = input("Ingrese la fecha de fin de la forma dd-MM-yyyy");
							String horain = input("Ingrese la hora de inicio en el formato de 24 horas hh:mm"); 
							String horafin =  input("Ingrese la hora de finalizaci�n en el formato de 24 horas hh:mm"); 
							laActividad = new Actividad(nombre, descripcion, tipo, fechain, fechafin, horain,horafin,elParticipante);
							map.put(nombre,laActividad);
							
							laActividad.getTiempoTotal(laActividad.getFecha(),laActividad.getHoraInicio(),laActividad.getFechaFin(),laActividad.getHoraFin());
						}
					}
					else {
						String part = input("Ingrese su nombre");
						Participante participante = laActividad.getParticipante();
						String part2 = participante.getNombre();
						if (part.equals(part2)){
							String fechain = input("Ingrese la fecha de inicio la forma dd-MM-yyyy");
							String fechafin = input("Ingrese la fecha de fin de la forma dd-MM-yyyy");
							String horain = input("Ingrese la hora de inicio en el formato de 24 horas hh:mm"); 
							String horafin =  input("Ingrese la hora de finalizaci�n en el formato de 24 horas hh:mm"); 
									
							laActividad.newFechaIn(fechain);
							laActividad.newFechaFin(fechafin);
							laActividad.newHoraIn(horain);
							laActividad.newHoraFin(horafin);
							
							laActividad.getTiempoTotal(laActividad.getFecha(),laActividad.getHoraInicio(),laActividad.getFechaFin(),laActividad.getHoraFin());
							
						}
						else {
							System.out.println(part+part2);
							System.out.println("El participante que est� realizando esta actividad es otro.");
						}
					}
				}
				}

			private void FinalizarActividad(Instant HoraIn) {
				
				String pattern = "dd-MM-yyyy";
				String fechafin = new SimpleDateFormat(pattern).format(new Date());
				String horafin = LocalTime.now().format(formatter);				
				actividad.newFechaFin(fechafin);
				actividad.newHoraFin(horafin);
				actividad.getTiempoTotal(actividad.getFecha(),actividad.getHoraInicio(),actividad.getFechaFin(),actividad.getHoraFin());

				
			}
			
			private void FinalizarProyecto() {
				//Solo los participantes de un proyecto podran finalizarlo
				
				String proy = input("Ingrese el nombre del proyecto");
				
				Proyecto elProyecto = proyectos.get(proy);
				
				if (elProyecto == null) {
					System.out.println("El proyecto no existe");
					}
				else {
					elProyecto.FechaFinal();
					}
				
				}
			
			private void GenerarReporte() {
				System.out.println("Reporte generado");
				
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
