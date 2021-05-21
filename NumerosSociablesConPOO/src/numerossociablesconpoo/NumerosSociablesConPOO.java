
package numerossociablesconpoo;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumerosSociablesConPOO {

     /**
     * En base a un menu: dividir 2 numeros, o determinar si es un numero
     * sociable. El programa termina hasta que no se desea continuar Hacer
     * excepciones (try y catch)
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String respuesta = "";
        int opc = 0;

        try {
            do {
                System.out.println("Menú\n1 - Dividir 2 numeros enteros\n2 - Determinar si un numero es sociable\n3 - Salir\nIngrese una opcion");
                opc = teclado.nextInt();
                Numero Objeto = new Numero();
                switch (opc) {
                    case 1:
                        System.out.println("Ingresa el primer numero");
                        int num1 = teclado.nextInt();
                        System.out.println("Ingresa el segundo numero");
                        int num2 = teclado.nextInt();
                        Objeto.dividir(num1, num2);
                        break;
                    case 2:
                        //buscar numero sociable
                        int cycleLength; // Si se ha encontrado un ciclo sociable, ¿cuánto duró el ciclo?
                        System.out.println("Este programa busca un numero sociable");
                        long numero = Objeto.getUserLong("Ingresa un numero ");
                        cycleLength = Objeto.checkSociable(numero);
                        if (cycleLength > 0) {
                            Objeto.printCycle(numero, cycleLength);
                        } else if (Objeto.isInCycle28(numero) >= 0) {
                            int cycle28Location = Objeto.isInCycle28(numero);
                            Objeto.printCycle28(cycle28Location);
                        }
                        break;
                    case 3:
                        System.out.println("Gracias por usar el programa");
                        break;
                    default:
                        System.out.println("Opcion inválida");
                }

                if (opc != 3) {
                    System.out.println("¿Desea continuar? (escriba 'SI' o 'S' para continuar)");
                    respuesta = teclado.next();
                    respuesta = respuesta.toUpperCase();
                }
            } while (respuesta.equals("SI") || respuesta.equals("S") || opc != 3);

        } catch (InputMismatchException e) {
            System.out.println("Se ha introducido un dato erroneo, pudo haber sido ser una cadena de texto o un numero muy extenso, favor de reiniciar el programa");
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre cero, favor de reiniciar el programa");
        }

    }

}
