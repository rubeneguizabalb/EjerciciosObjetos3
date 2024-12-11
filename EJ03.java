package EjerciciosObjetos3;
import java.util.Scanner;

public class EJ03 {
	/*EJ03.- Calculadora de Fracciones
	Diseña una calculadora que permita al usuario realizar operaciones con dos fracciones ingresadas como strings en el formato a/b.
	Permite sumar, restar, multiplicar y dividir fracciones.
	Devuelve el resultado como fracción simplificada.*/


    public static void main(String[] args) {
    	//OJO: No se controla que se meta cualquier cosa.
    	
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la primera fracción (formato a/b): ");
        String fraccion1 = scanner.nextLine();
        System.out.println("Introduce la segunda fracción (formato a/b): ");
        String fraccion2 = scanner.nextLine();
        System.out.println("Elige la operación (+, -, *, /): ");
        char operacion = scanner.next().charAt(0);

        //Se realiza la operacion y se devuelve el resultado
        String resultado = operarFracciones(fraccion1, fraccion2, operacion);
        System.out.println("Resultado: " + resultado);
        
        scanner.close();
    }

    public static String operarFracciones(String fraccion1, String fraccion2, char operacion) {
    	//Buscar la posición del carácter '/' en las fracciones
        int index1 = fraccion1.indexOf('/');
        int index2 = fraccion2.indexOf('/');

        //Extraer el numerador y denominador de la primera fracción
        int num1 = Integer.parseInt(fraccion1.substring(0, index1));
        //En esta segunda se puede poner la length o dejar solo con index + 1, que entonces
        //la substring llegara hasta el final
        int den1 = Integer.parseInt(fraccion1.substring(index1 + 1,fraccion1.length()));

        //Extraer el numerador y denominador de la segunda fracción
        int num2 = Integer.parseInt(fraccion2.substring(0, index2));
        int den2 = Integer.parseInt(fraccion2.substring(index2 + 1));

        int numResultado = 0, denResultado = 1;

        //Se hace la operación que se ha pasado a la función: +, -, *, /
        switch (operacion) {
            case '+':
                numResultado = num1 * den2 + num2 * den1;
                denResultado = den1 * den2;
                break;
            case '-':
                numResultado = num1 * den2 - num2 * den1;
                denResultado = den1 * den2;
                break;
            case '*':
                numResultado = num1 * num2;
                denResultado = den1 * den2;
                break;
            case '/':
                numResultado = num1 * den2;
                denResultado = den1 * num2;
                break;
        }

        //Calcular el maximo comun divisor
        //Se hace el maximo comun divisor para poder realizar las operaciones y devolver las funciones de forma correcta
        //Por ejemplo 1/2 + 1/4 = 3/4 --> 0.5 + 0.25 = 0.75
        int a, b, temp, mcd;
        
        a = numResultado;
        b = denResultado;
        
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        mcd = a; //El resultado es que a es el mcd tras todas las operaciones
        
        return (numResultado / mcd) + "/" + (denResultado / mcd);
    }
}
