package logica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

    private static final Scanner scanner = new Scanner(System.in);

    public static int ObtenerNumeroAmbosIncluidos(int valorMin, int valorMax) {
        int numero;
        boolean numeroValido = false;
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

    public static void printMazo(ArrayList<Carta> mazo){
        if(!mazo.isEmpty()){
            String text = "";
            for (int i = 0; i < mazo.size(); i++) {
                text += mazo.get(i).toString() + " - ";
            }
            text = text.substring(0, text.length()-3);
            System.out.println(text);
        } else
            System.out.println("Mazo vacío.");
    }
    
}