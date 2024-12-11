package EjerciciosObjetos3;
import java.util.Scanner;
import java.util.Random;

public class EJ04 {

	/* EJ04.- Generador de Contraseñas Seguras
		-Crea una función que genere una contraseña aleatoria basada en los requisitos del usuario (longitud, uso de números, mayúsculas y caracteres especiales).
		-Solicita al usuario los criterios de la contraseña. 
		Crea una funcion en la que puedas mandar un mensaje como parametro (el mensaje sera el criterio por el que se pregunta) y
		que devuelva true/false en funcion de la respuesta Si/No
		-Muestra la contraseña generada y su nivel de seguridad.*/
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicitar la longitud de la contraseña
        System.out.println("Introduce la longitud de la contraseña: ");
        int longitud = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        //Preguntar si incluir números, mayúsculas y caracteres especiales
        //Se usa una funcion para no repetir el codigo de pregunta 3 veces
        boolean incluirNumeros = preguntarSiNo("¿Incluir números? (sí/no): ");
        boolean incluirMayusculas = preguntarSiNo("¿Incluir mayúsculas? (sí/no): ");
        boolean incluirEspeciales = preguntarSiNo("¿Incluir caracteres especiales? (sí/no): ");

        //Generar la contraseña según las respuestas
        String contrasena = generarContrasena(longitud, incluirNumeros, incluirMayusculas, incluirEspeciales);
        System.out.println("Contraseña generada: " + contrasena);
        
        scanner.close();
    }

    //Función para preguntar sí o no, lo que cambia es el mensaje
    public static boolean preguntarSiNo(String mensaje) {
        Scanner scanner1 = new Scanner(System.in);
        String respuesta;
        while (true) {
            System.out.println(mensaje);
            respuesta = scanner1.nextLine().trim().toLowerCase();
            if (respuesta.equals("si")) {
                return true;
            } else if (respuesta.equals("no")) {
                return false;
            } else {
                System.out.println("Por favor, responde con 'si' o 'no'.");
            }
        }
    }

    //Función para generar la contraseña
    public static String generarContrasena(int longitud, boolean incluirNumeros, boolean incluirMayusculas, boolean incluirEspeciales) {
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String especiales = "!@#$%^&*";
        String mayusculas = minusculas.toUpperCase(); //Como ya tenemos las minusculas, pasamos las mayusculas tirando de funcion
        int indice; //Indice para agregar un caracter de la listra de caracteres que se pueden elegir.

        //Construimos los caracteres usados para la contraseña. 
        //Obligatorio minusculas, y por cada criterio opcional añadira mas caracteres.
        //StringBuilder pool = new StringBuilder(minusculas);
        String pool = minusculas;
        if (incluirNumeros) {
        	//pool.append(numeros);
        	pool = pool + numeros;
        }
        if (incluirMayusculas) {
        	//pool.append(mayusculas);
        	pool = pool + mayusculas;
        }
        if (incluirEspeciales) {
        	//pool.append(especiales);
        	pool = pool + especiales;
        }
        
        //Crear una instancia de Random para generar números aleatorios
        Random random = new Random();

        StringBuilder contrasena = new StringBuilder();
        //Obtiene un caracter aleatorio y se repite tantas veces como longitud hayamos pedido
        for (int i = 0; i < longitud; i++) {
        	 indice = random.nextInt(pool.length()); //Genera un índice aleatorio usando Random
             contrasena.append(pool.charAt(indice));  //Agrega el carácter al StringBuilder
        }
        return contrasena.toString();
    }
}
