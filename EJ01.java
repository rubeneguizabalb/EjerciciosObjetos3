package EjerciciosObjetos3;
import java.util.Random;

public class EJ01 {
	//Implementa un programa que codifique un mensaje en base a una clave. 
	//Cada letra del mensaje se reemplaza por una letra generada con un desplazamiento aleatorio (entre 1 y 5 posiciones) dentro del alfabeto.
	//Solo transforma letras; otros caracteres permanecen iguales.
	//La clave para decodificar debe guardarse y mostrarse al final.

    public static void main(String[] args) {
        String mensaje = "Hola Mundo!";
        Random random = new Random();
        
        //Genera un desplazamiento aleatorio entre 1 y 5
        int desplazamiento = random.nextInt(5) + 1;
        System.out.println("El desplazamiento generado es: " + desplazamiento);

        //Codifica el mensaje
        String mensajeCodificado = codificarMensaje(mensaje, desplazamiento);
        System.out.println("Mensaje codificado: " + mensajeCodificado);

        //Decodifica el mensaje
        String mensajeDecodificado = decodificarMensaje(mensajeCodificado, desplazamiento);
        System.out.println("Mensaje decodificado: " + mensajeDecodificado);

        //Confirmamos si el mensaje original y decodificado coinciden
        if (mensaje.equals(mensajeDecodificado)) {
            System.out.println("El mensaje fue decodificado correctamente.");
        } else {
            System.out.println("Hubo un error en la decodificación.");
        }
    }

    public static String codificarMensaje(String mensaje, int desplazamiento) {
        StringBuilder codificado = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + desplazamiento) % 26 + base);
            }
            codificado.append(c);
        }
        return codificado.toString();
    }
    
    public static String decodificarMensaje(String mensajeCodificado, int desplazamiento) {
        StringBuilder decodificado = new StringBuilder();
        for (char c : mensajeCodificado.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base - desplazamiento + 26) % 26 + base);
            }
            decodificado.append(c);
        }
        return decodificado.toString();
    }

}
