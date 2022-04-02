package modelo;


import java.time.Duration;
import java.time.Instant;

public class Cronometro {

		public static Instant Instante() {

	        Instant instantStarted = Instant.now();
			return instantStarted;
		}
        
        public static Long Calcular(Instant Inicial, Instant Final) {
        	
	        Duration DiferenciadeTiempos = Duration.between(Inicial, Final);
	        Long TiempoSec=DiferenciadeTiempos.toSeconds();
	
	        System.out.println("Get elapsed time in milliseconds: " + DiferenciadeTiempos.toMillis());
	        System.out.println("Get elapsed time in seconds: " + DiferenciadeTiempos.toSeconds());
	        System.out.println("Get elapsed time in minutes: " + DiferenciadeTiempos.toMinutes());
	        return TiempoSec;
        }


    }
