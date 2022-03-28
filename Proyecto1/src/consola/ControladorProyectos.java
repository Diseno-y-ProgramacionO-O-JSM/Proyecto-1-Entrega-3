package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Dueño;
import modelo.Participante;
import procesamiento.Proyecto;

public class ControladorProyectos {

		HashMap<String, Proyecto> proyectos = new HashMap<>();
		/**
		 * Ejecuta la aplicaciÃ³n: le muestra el menÃº al usuario y la pide que ingrese
		 * una opciÃ³n, y ejecuta la opciÃ³n seleccionada por el usuario. Este proceso se
		 * repite hasta que el usuario seleccione la opciÃ³n de abandonar la aplicaciÃ³n.
		 */
		public void ejecutarAplicacion()
		{
			System.out.println("PROYECTOS\n");

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
					else if (opcion_seleccionada == 3 )
						IniciarActividad();
					else if (opcion_seleccionada == 4 )
						AgregarParticipante();
					else if (opcion_seleccionada == 5 )
						FinalizarActividad();
					else if (opcion_seleccionada == 6 )
						GenerarReporte();
					
					else if (opcion_seleccionada == 7)
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
				System.out.println("5. Finalizar actividad");
				System.out.println("6. Reporte usuario");
			
				System.out.println("7. Salir de la aplicacion\n");
			}
		
			
			private void RegistroUsuario() {
				
			;
			
			}
			
			private void CrearProyecto() {
				//Por defecto el que creó el proyecto queda como dueño
				
				String nombre = input("Ingrese el nombre del proyecto");
					
				Proyecto elProyecto = proyectos.get(nombre);
				if (elProyecto == null)
				{
					String dueño = input("Por ser la persona que va a crear este proyecto quedará asignado como el dueño\n Ingrese su nombre");
					String correo = input("Ingrese su correo");
					
					String descripcion = input("Ingrese una descripcion para el proyecto");
					String tiposs = input("Ingrese los tipos de actividades que se podran realizar en este proyecto separados por comas");
					String pattern = "dd-MM-yyyy";
					String fechain = new SimpleDateFormat(pattern).format(new Date());
					System.out.println(fechain);
					String fechafin = null; //Finalizar proyecto
					
					ArrayList<String> tipos = new ArrayList<String>(Arrays.asList(tiposs.split(",")));
					ArrayList<Participante> participantes = new ArrayList<Participante>(); ////Lista con los participantes debe agregar al dueño
					
					elProyecto = new Proyecto( descripcion, dueño, correo, fechain, fechafin, tipos);				
					proyectos.put(nombre, elProyecto);
				}
				else {
					Dueño dueño = elProyecto.getDueño();
					System.out.println("-Ya existe un proyecto con ese nombre creado por "+ dueño.toString()+"-");
				}
				}
			
			private void IniciarActividad(){
				//Puede ser a nombre de cualquier persona
				;
				
				}
			private void AgregarParticipante(){
				//Cualquier persona registrada podrá agregar participantes a una actividad
				;
				
				}
			
			private void FinalizarActividad() {
				
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
