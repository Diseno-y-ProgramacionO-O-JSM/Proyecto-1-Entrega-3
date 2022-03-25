package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ControladorProyectos {


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
			 * Muestra al usuario el menú con las opciones para que escoja la siguiente
			 * acción que quiere ejecutar.
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
				;
				
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
