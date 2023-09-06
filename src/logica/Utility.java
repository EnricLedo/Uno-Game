package logica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    
    public static int ObtenerNumeroAmbosIncluidos(int valorMin, int valorMax) {
        int numero = 0;
        boolean numeroValido = false;
        final Scanner scanner = new Scanner(System.in);
        do {
            try {
                numero = scanner.nextInt();
                if (numero >= valorMin && numero <= valorMax) {
                        return numero;
                    }
            } catch (InputMismatchException ime){
                scanner.next();
            }
        } while (!numeroValido);
        return -1;
    }
    
}
