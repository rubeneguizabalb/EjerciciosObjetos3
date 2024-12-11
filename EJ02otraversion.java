package EjerciciosObjetos3;
import java.util.Random;

public class EJ02otraversion {
	/* EJ02.- Generador de Poemas Aleatorios
		Crea un programa que construya un poema de tres líneas al combinar palabras aleatorias elegidas de listas predefinidas de sustantivos, verbos y adjetivos.
		Las palabras se eligen aleatoriamente.
		Las líneas deben tener estructura gramatical: Sustantivo + verbo + adjetivo.*/
	
	public static void main(String[] args) {
        //Cadenas de palabras separadas por comas
        String sustantivos = "gato,luna,mar,sol,viento";
        String verbos = "baila,corre,brilla,susurra,salta";
        String adjetivos = "hermoso,tranquilo,rápido,misterioso,alegre";

        Random random = new Random();
        
        //Tres líneas de poema
        for (int i = 0; i < 3; i++) { 
        	//Se genera un random entre 0 y 4. 
        	//Como hacemos + 1, lo que hara es que sea entre 1 y 5.
        	int r1 = random.nextInt(5) + 1;
        	int r2 = random.nextInt(5) + 1;
        	int r3 = random.nextInt(5) + 1;
        	
            String sustantivo = obtenerPalabra(sustantivos, r1);
            String verbo = obtenerPalabra(verbos, r2);
            String adjetivo = obtenerPalabra(adjetivos, r3);
            
            System.out.println(r1 + " - " + r2 + " - " + r3 + ".");
            System.out.println(sustantivo + " " + verbo + " " + adjetivo);
        }
    }


    public static String obtenerPalabra(String palabras, int indice) {      
        //Calcular inicio de la palabra
        int inicioPalabra = 0;

        for(int i=1; i<indice ;i++) {
        	inicioPalabra = palabras.indexOf(',') + 1;
        	palabras = palabras.substring(inicioPalabra);
        }        
        //Esto esta comentado porque el random lo cogemos entre 1 y 5
        //Si lo hacemos entre 0 y 4 necesitamos esta linea extra, porque sino
        //se come una palabra
        //inicioPalabra = palabras.indexOf(',') + 1;
        
        //Calcular fin de la palabra (buscamos la siguiente coma, pero empezando por la 
        //posicion de la anterior coma que hemos calculado
        int finalPalabra = palabras.indexOf(',',inicioPalabra);
        
        //Si da la casualidad que no hay mas comas porque era la ultima palabra
        //devuelve -1. En ese caso nos tenemos que quedar con el largo de la palabra
        if (finalPalabra == -1)
        {
        	finalPalabra = palabras.length();
        }
                        
        //Devolvemos la palabra (tenemos la posicion de inicio, y luego la posicion de fin).
        return palabras.substring(inicioPalabra, finalPalabra);
    }
}
