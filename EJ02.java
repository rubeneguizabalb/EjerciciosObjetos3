package EjerciciosObjetos3;
import java.util.Random;

public class EJ02 {
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
        	int r1 = random.nextInt(5);
        	int r2 = random.nextInt(5);
        	int r3 = random.nextInt(5);
        	
            String sustantivo = obtenerPalabra(sustantivos, r1);
            String verbo = obtenerPalabra(verbos, r2);
            String adjetivo = obtenerPalabra(adjetivos, r3);
            
            System.out.println(r1 + " - " + r2 + " - " + r3 + ".");
            System.out.println(sustantivo + " " + verbo + " " + adjetivo);
        }
    }


    public static String obtenerPalabra(String palabras, int indice) {
        int inicio = 0;
        int actual = 0;
        int contador = 0;

        //Mientras no hayamos localizado la palabra de la posición que decimos en el indice
        while (contador < indice) {
        	//Buscamos la coma, para quedarnos con la posicion de esa coma que es donde comienza una palabra
            if (palabras.charAt(actual) == ',') {
                contador++;
                inicio = actual + 1;
            }
            actual++;
            //Por ejemplo: para la palabra 3, tendra que hacer el bucle 3 veces y quedarnos con la posicion
            //de la 3 coma, que es la posicion de comienzo de la tercera palabra
        }

        int fin = inicio;
        //Mientras NO haya terminado de leerse la cadena de palabra, o lo que se lea NO sea una coma
        //vamos recorriendo caracter a caracter la cadena, hasta encontrar donde termina
        while (fin < palabras.length() && palabras.charAt(fin) != ',') {
            fin++;
        }
        
        //Devolvemos la palabra (tenemos la posicion de inicio, y luego la posicion de fin).
        return palabras.substring(inicio,fin);
    }
}
