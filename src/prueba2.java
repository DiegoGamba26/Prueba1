
/**
 * 
 */

import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 */
public class prueba2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingreso de los números
        int[] a = new int[2];
        
        a[0] = 1234;

        
        a[1] = 2345;

        // Verificar que los números sean positivos
        if (a[0] <= 0 || a[1] <= 0) {
            System.out.println("Error: Ingrese solo números enteros positivos.");
        } else {
            int pasos = contarPasos(a[0], a[1]);
            System.out.println("Pasos necesarios: " + pasos);
        }

        scanner.close();
    }

    public static int contarPasos(int num1, int num2) {
        int pasos = 0;

        while (num1 != num2) {
            num1 = incrementarDigito(num1, num2);
            pasos++;
        }

        return pasos;
    }

    public static int incrementarDigito(int num1, int num2) {
        char[] digitos1 = String.valueOf(num1).toCharArray();
        char[] digitos2 = String.valueOf(num2).toCharArray();

        for (int i = 0; i < digitos1.length; i++) {
            if (digitos1[i] < digitos2[i]) {
                digitos1[i]++;
                break;
            }
        }

        return Integer.parseInt(new String(digitos1));
    }
}
