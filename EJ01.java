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
        //StringBuilder codificado = new StringBuilder();
        String codificado = "";
        //Recorremos la cadena del mensaje
        for (int i = 0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);
            //Para cada caracter, si es letra
            if (Character.isLetter(c)) {            	
            	char base;
            	//Si es mayuscula, nos quedamos con el caracter base Mayuscula 
                if (Character.isUpperCase(c)) {
                    base = 'A';
                } else {
                    base = 'a';
                }
                //Lo que hace es al caracter restarle la base (esta restando posiciones ASCII) y luego le suma el desplazamiento
                //que es sumar posiciones ASCII, de eso hacemos el resto entre 26 y luego le sumamos la base
                c = (char) ((c - base + desplazamiento) % 26 + base);
            }            
            //codificado.append(c);
            codificado = codificado + c;
        }
        return codificado.toString();
    }

    public static String decodificarMensaje(String mensajeCodificado, int desplazamiento) {
        //StringBuilder decodificado = new StringBuilder();
    	String decodificado = "";
        for (int i = 0; i < mensajeCodificado.length(); i++) {
            char c = mensajeCodificado.charAt(i);           
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                if (Character.isUpperCase(c)) {
                    base = 'A';
                } else {
                    base = 'a';
                }
                //Lo que hace es al caracter restarle la base (esta restando posiciones ASCII) y luego le resta el desplazamiento
                //que es restar posiciones ASCII, le suma 26, de eso hacemos el resto entre 26 y luego le sumamos la base
                c = (char) ((c - base - desplazamiento + 26) % 26 + base);
            }
            //decodificado.append(c);
            decodificado = decodificado + c;
        }
        return decodificado.toString();
    }
}
