package vista;

import logica.Resultado;
import logica.Utility;
/*
 * Ésta clase sirve para interactuar con el usuario
*/
public class Menu {
    
    public static void InicioPrograma(){
        
         System.out.println("\n\n\n\n\n\n\n\n");
        System.out.println("--------------------------------------");
        System.out.println("BIENVENIDO AL CALCULADOR DE ESTRATEGIAS DE UNO");
        System.out.println("--------------------------------------");
        
        System.out.println("\nEste programa sirve para calcular la estratégia óptima para jugar al Uno por puntos.");
        
        //Obtener el numero de jugadores
        System.out.println("\nLo primero que debemos hacer es indicar el número de jugadores que habrá por partida (2-6):");
        int numeroJugadores = Utility.ObtenerNumeroAmbosIncluidos(2,6);
        
        //Obtener el numero de partidas
        System.out.println("\nFinalmente debemos indicar cuantas partidas queremos que calcule el sistema(1-1.000):");
        int numeroPartidas = Utility.ObtenerNumeroAmbosIncluidos(1,1_000);
        
        //Obtener resultados de las partidas
        Resultado resultadoFinal = Resultado.calcularResultadoFinal(numeroJugadores, numeroPartidas);

        System.out.println("El resultado de las " + numeroPartidas + " partidas es: ");
        
        for(int i = 0; i < numeroJugadores; i++){
            System.out.println("El jugador "+  (i+1) + " ha obtenido: " + resultadoFinal.getPuntosJugadores()[i] + " puntos.");
        }
        boolean[] ganadores = Resultado.calcularGanadores(resultadoFinal);

        for (int i = 0; i < ganadores.length; i++) {
            if(ganadores[i])
                System.out.println("El ganador es el jugador número " + (i+1) + " con un total de: " + resultadoFinal.getPuntosUnJugador(i) + " puntos.");
        }
        

    }
}