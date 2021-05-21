
package numerossociablesconpoo;

import java.util.Scanner;

/**
 * @author jose
 * En base a un menu: dividir 2 numeros, o determinar si es un numero sociable.
 * El programa termina hasta que no se desea continuar
 * Hacer excepciones (try y catch)
 */
public class Numero {
    
   /** Esta clase tiene un conjunto de 28 números cuya duración de ciclo es 28  */
	public static long[] cycle28 = { 14316, 19116, 31704, 47616, 83328, 177792, 295488, 629072, 589786, 294896, 358336,
			418904, 366556, 274924, 275444, 243760, 376736, 381028, 285778, 152990, 122410, 97946, 48976, 45946, 22976,
			22744, 19916, 17716 };

	/**
	 * Este es un escáner global. Elimina el problema de llamar al escáner,
	 * cada vez que damos una nueva entrada.
	 */
	public static Scanner scnr = new Scanner(System.in);

	/**
	 * Si el número que buscamos está en el ciclo largo (ciclo 28 de duración),
	 * devuelve la ubicación donde está ese número. De lo contrario, devuelve -1.
	 */
	public static int isInCycle28(long targetNumber) {
		int position = -1;
		/*
		 * dado que la posición comienza de 0 a 27, asignar -1 a la posición nos ayudará a
		 * comprobar si el número está ahí o no
		 */
		for (int index = 0; index < 28; index++) {
			if (targetNumber == cycle28[index]) {
				position = index;
				break;
			}
		}
		return position;
	}

	/**
	 * Si el número está en el ciclo 28, imprime el ciclo a partir de ese
	 * número.
	 */
	public static void printCycle28(int startFrom) {
		System.out.print(cycle28[startFrom] + " Es sociable de longitud 28. ");

		/**El if comprueba la posición del número y comienza a imprimir desde allí. */
		if (startFrom == 0) {
			for (int j = 0; j < 28; j++) {
				System.out.print(cycle28[j] + " --> ");
			}
			System.out.print(cycle28[0]);
		} else {
			for (int j = startFrom; j < 28; j++) {
				if (j == (startFrom - 1)) {
					System.out.print(cycle28[j]);
				} else {
					System.out.print(cycle28[j] + " --> ");
				}
			}
			for (int j = 0; j < (startFrom + 1); j++) {
				if (j == startFrom) {
					System.out.print(cycle28[j]);
				} else {
					System.out.print(cycle28[j] + " --> ");
				}
			}
		}

		System.out.println();
	}

	/**
	 * ¿Es "divisor" un divisor propio de "número objetivo"? Es decir, se divide uniformemente,
	 * aunque sea más pequeño que el número en sí mismo? Devuelve falso si el divisor es
	 * negativo o cero.
	 */
	public static boolean isProperDivisor(long targetNumber, long divisor) {
		boolean success = false;
		// Cambia su valor si el número es el divisor adecuado de targetNumber.

		/** Esto si la declaración comprueba si el divisor es correcto o no. */
		if (divisor > 0) {
			if ((targetNumber % divisor) == 0) {
				success = true;
			}
		} else {
			success = false;
		}
		return success;
	}

	/**  Devuelve la suma de todos los divisores adecuados de "targetNumber" */
	public static long sigma(long targetNumber) {
		long sigmaValue = 0;
		//  suma los factores para formar el sigma del targetNumber.
		boolean checkProperDivisor;
		//  llama a isProperDivisor y almacena el valor booleano.

		/**
		 * El bucle encontrará todos los divisores adecuados del targetNumber con la ayuda
		 * del método-isProperDivisor.
		 */
		for (long divisor = 1; divisor <= (targetNumber / 2); divisor++) {
			checkProperDivisor = isProperDivisor(targetNumber, divisor);
			if (checkProperDivisor == true) {
				sigmaValue = sigmaValue + divisor;
			}
		}
		return sigmaValue;
	}

	/**
	 * Calcula e imprime el ciclo de números sociables de la longitud especificada
	 * comenzando en el targetNumber especificado. Este método asume que el
	 * el punto de partida y la duración del ciclo describen una cadena numérica sociable real, y
	 * no valida esa suposición. Produce un número perfecto como cadenas de
	 * longitud 1 y números amistosos como cadenas de longitud 2. Se emite en el formato
	 * "6 -> 6", por ejemplo, incluido el número original al final de la cadena de
	 * números.
	 */
	public static void printCycle(long targetNumber, int cycleLength) {
		long sigmaValueReturned = targetNumber;
		/*
		 * Esta variable almacena targetNumber, pero también cambia al valor sigma de
		 * targetNumber.
		 */

		/**  La declaración if separa los números perfectos amistosos y sociables. */
		 if (cycleLength > 2) {
			System.out.print(targetNumber + " Es sociable con longitud de " + cycleLength + ". ");
                 }
		/**
		 * El ciclo de bucle imprime las sigmas del número hasta que obtenemos el targetNumber
		 * de nuevo.
		 */
		for (int i = 1; i <= cycleLength; i++) {
			System.out.print(sigmaValueReturned + " --> ");
			sigmaValueReturned = sigma(sigmaValueReturned);//deberia ser el valor retornado esta en tagetNumber
		}
		System.out.println(targetNumber);
	}

	/**
	 *  Comprueba si un número en particular es un número sociable. Si lo es, vuelve
	 * la duración del ciclo para ese número; si no es un número sociable,
	 * devuelve 0.
	 */
	public static int checkSociable(long targetNumber) {
		long sigmaValueReturned;
		/*
		 * Esta variable llama al método sigma y también almacena el valor devuelto por
		 * método sigma.
		 */
		long numberToBeChecked;
		// mantiene y actualiza el valor devuelto por sigma. Lo usamos para que fuera
		// más fácil de comparar.//
		int counter = 0;
		/*
		 *  devuelve la escala del número o devuelve 0 si el número no es perfecto o
		 * amistoso.
		 */
		/** (nota: el número aún puede ser sociable) */
		numberToBeChecked = targetNumber;

		for (int i = 1; i <= 10; i++) {
			sigmaValueReturned = sigma(numberToBeChecked); //Devuelve la suma de todos los divisores
			if (targetNumber == sigmaValueReturned) {
				counter = i;
				return counter;
			}
			numberToBeChecked = sigmaValueReturned;
		}
		return counter;
	}

	/**
	 * Emite el mensaje especificado, sin "retorno", espera una entrada de número de
	 * el usuario, y devuelve ese número. Utiliza un escáner global para que el
	 * El procedimiento se puede reutilizar.
	 */
	public static long getUserLong(String prompt) {
		System.out.print(prompt);
		long range = scnr.nextLong();
		return range;
		/*
		 * rango almacena y devuelve el número inicial y el número final cuando
		 * Se llama a getUserLong.
		 */
	}
        //Se encarga de la operacion de dividir segun el menú
        public void dividir (int numero1, int numero2){
        int resultado = numero1/numero2;
        System.out.println("El resultado es "+resultado);
    }

}
