package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import modelo.Actividad;
import modelo.Due�o;
import modelo.Participante;
import procesamiento.Proyecto;

public class ControladorProyectos {

		HashMap<String, Participante> participantes = new HashMap<>();
		HashMap<String, Proyecto> proyectos = new HashMap<>();
		HashMap<String, Actividad> actividades = new HashMap<>();
		
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
					if (opcion_seleccionada == 1)
						RegistroUsuario();
					else if (opcion_seleccionada == 2 )
						CrearProyecto();
					else if (opcion_seleccionada == 4 )
						Temporizador=IniciarActividad();
					else if (opcion_seleccionada == 3 )
						AgregarParticipante();
					else if (opcion_seleccionada == 5 )
						FinalizarActividad(Temporizador);
					else if (opcion_seleccionada == 6 )
						FinalizarProyecto();
					else if (opcion_seleccionada == 7 )
						GenerarReporte();
					
					else if (opcion_seleccionada == 8)
					{
						System.out.println("Saliendo de la aplicación ...");
						continuar = false;
					}
					else
					{
						System.out.println("Por favor seleccione una opción válida.");
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
				System.out.println("5. Finalizar actividad");
				System.out.println("6. Finalizar proyecto");
				System.out.println("7. Reporte usuario");
			
				System.out.println("8. Salir de la aplicacion\n");
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
					String due�o = input("Por ser la persona que va a crear este proyecto quedar� asignado como el due�o\n Ingrese su nombre");
					
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
				Instant Inicial= Actividad.IniciarCronometro();
				//Puede ser a nombre de cualquier persona
					return Inicial;
				
				}
			private void AgregarParticipante(){
				//Cualquier persona registrada podr� agregar participantes a una actividad
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
