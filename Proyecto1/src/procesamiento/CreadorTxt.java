package procesamiento;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Actividad;
import modelo.Participante;
import modelo.Proyecto;

public class CreadorTxt {
	
    public static void ejecutar(Proyecto proyecto){
    	
        try {
        	String nombre = proyecto.getNombre();
        	String ruta = "C:\\Users\\maril\\git\\proyecto1\\Proyecto1\\docs\\"+nombre +".txt";
            
            String desc = proyecto.getDescripcion();
            Participante dueno = proyecto.getDueño();
            String dueño1 = dueno.getNombre();
            String fechain = proyecto.getfechain();
            String fechafin = proyecto.getfechafin();
            ArrayList<String> tipos = proyecto.getTiposActividades();    
            ArrayList<Participante> part = proyecto.getParticipantes();
            
            File file = new File(ruta);
            
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("+ "+nombre+" +");
            bw.write("\n");
            bw.write("\nDescripcion: "+ desc);
            bw.write("\n");
            bw.write("\nDueño: "+ dueño1);
            bw.write("\n");
            bw.write("\nFecha de inicio: "+ fechain);
            bw.write("\n");
            bw.write("\nFecha de fin: "+ fechafin);
            bw.write("\n");
            bw.write("\nTipos de actividades: ");
            for(int i = 0; i < tipos.size(); i++) {
	            bw.write("\n\t-"+tipos.get(i));
	        }
            bw.write("\n");
            bw.write("\nParticipantes: ");
            for(int j = 0; j < part.size(); j++) {
            	Participante participante = part.get(j);
            	String nombrep = participante.getNombre();
	            bw.write("\n\t-"+nombrep);
	        }
            bw.write("\n");
            bw.write("\n+ Reporte por participante +");
            bw.write("\n");
            
            
            
            for(int  g= 0; g < part.size(); g++) {
            	HashMap<String,ArrayList<Integer>> valores = new HashMap<String,ArrayList<Integer>>();
                
            	Participante participante = part.get(g);
            	String nombrep = participante.getNombre();  
            	String correo = participante.getCorreo();
            	bw.write("\nParticipante: "+nombrep);
            	bw.write("\t Correo: "+correo);
            	ArrayList<Actividad> actividades = participante.getActividades(); 
            	for(int  i= 0; i < actividades.size(); i++) {
            		bw.write("\n");
            		bw.write("\n Actividad: "+actividades.get(i).getNombre());
            		bw.write("\n\t Descripción: "+actividades.get(i).getDescripcion());
            		bw.write("\n\t Tipo: "+actividades.get(i).getTipo());
            		bw.write("\n\t Fecha inicio actividad: "+actividades.get(i).getFecha());
            		bw.write("\n\t Fecha fin actividad: "+actividades.get(i).getFechaFin());
            		bw.write("\n\t Tiempo total: "+actividades.get(i).getTiempo()+ " minutos");
            		
            		String tipo = actividades.get(i).getTipo();
            		Integer tiempotot = actividades.get(i).getTiempo();
        			System.out.println(tipo);
        			
            		if (!(valores.containsKey(tipo))) {
            			ArrayList<Integer> val = new ArrayList<Integer>();
            			val.add(tiempotot);
            			System.out.println(val);
            			valores.put(tipo,val);
            		}
            		else {
            			ArrayList<Integer> lista = valores.get(tipo);
            			lista.add(tiempotot);
            			System.out.println(lista);
            			valores.put(tipo,lista);
            		}
            		
            		
            		System.out.println(valores);
            	}
            	
            	for (String llave:valores.keySet()) {
            		ArrayList<Integer> val = valores.get(llave);
            		
            	    int TotalSum=0;
            	    for (int i=0; i<val.size();i++){
            	            TotalSum=TotalSum+val.get(i);
            	        }
            	    bw.write("\n Tiempo promedio para el tipo de actividad "+llave+": "+TotalSum/val.size()+" minutos");
            	}
            	
            	
            	
            }
	            
	        
            bw.write("\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }


	
}
