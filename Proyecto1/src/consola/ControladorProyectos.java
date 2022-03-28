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

import modelo.Due�o;
import modelo.Participante;
import procesamiento.Proyecto;

public class ControladorProyectos {

		HashMap<String, Proyecto> proyectos = new HashMap<>();
		/**
		 * Ejecuta la aplicación: le muestra el menú al usuario y la pide que ingrese
		 * una opción, y ejecuta la opción seleccionada por el usuario. Este proceso se
		 * repite hasta que el usuario seleccione la opción de abandonar la aplicación.
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
				System.out.println("6. Reporte usuario");
			
				System.out.println("7. Salir de la aplicacion\n");
			}
		
			
			private void RegistroUsuario() {
				
			;
			
			}
			
			private void CrearProyecto() {
				//Por defecto el que cre� el proyecto queda como due�o
				
				String nombre = input("Ingrese el nombre del proyecto");
					
				Proyecto elProyecto = proyectos.get(nombre);
				if (elProyecto == null)
				{
					String due�o = input("Por ser la persona que va a crear este proyecto quedar� asignado como el due�o\n Ingrese su nombre");
					String correo = input("Ingrese su correo");
					
					String descripcion = input("Ingrese una descripcion para el proyecto");
					String tiposs = input("Ingrese los tipos de actividades que se podran realizar en este proyecto separados por comas");
					String pattern = "dd-MM-yyyy";
					String fechain = new SimpleDateFormat(pattern).format(new Date());
					System.out.println(fechain);
					String fechafin = null; //Finalizar proyecto
					
					ArrayList<String> tipos = new ArrayList<String>(Arrays.asList(tiposs.split(",")));
					ArrayList<Participante> participantes = new ArrayList<Participante>(); ////Lista con los participantes debe agregar al due�o
					
					elProyecto = new Proyecto( descripcion, due�o, correo, fechain, fechafin, tipos);				
					proyectos.put(nombre, elProyecto);
				}
				else {
					Due�o due�o = elProyecto.getDue�o();
					System.out.println("-Ya existe un proyecto con ese nombre creado por "+ due�o.toString()+"-");
				}
				}
			
			private void IniciarActividad(){
				//Puede ser a nombre de cualquier persona
				;
				
				}
			private void AgregarParticipante(){
				//Cualquier persona registrada podr� agregar participantes a una actividad
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
