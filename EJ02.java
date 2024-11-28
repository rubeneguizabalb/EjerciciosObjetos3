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

        for (int i = 0; i < 3; i++) { //Tres líneas de poema
            String sustantivo = obtenerPalabra(sustantivos, random.nextInt(5));
            String verbo = obtenerPalabra(verbos, random.nextInt(5));
            String adjetivo = obtenerPalabra(adjetivos, random.nextInt(5));
            System.out.println(sustantivo + " " + verbo + " " + adjetivo + ".");
        }
    }

    //Método para obtener una palabra en la posición indicada
    public static String obtenerPalabra(String palabras, int indice) {
        int inicio = 0;
        int actual = 0;
        int contador = 0;

        while (contador < indice) {
            if (palabras.charAt(actual) == ',') {
                contador++;
                inicio = actual + 1;
            }
            actual++;
        }

        int fin = inicio;
        while (fin < palabras.length() && palabras.charAt(fin) != ',') {
            fin++;
        }

        return palabras.substring(inicio, fin);
    }
}
