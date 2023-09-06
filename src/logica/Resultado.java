package logica;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
 * La clase resultado es la definición de lo que quiero que se muestre al final de cada partida
 * Quien ha ganado, el numero de puntos, quizá el número de jugadas, un arraylist con las jugadas...
*/
public class Resultado {
    private int[] puntosJugadores; //Siguiendo el ejemplo anterior [23,4,0,13]. El jugador 0 ha terminado con 23 puntos y el jugador 1 con 4.

    public Resultado(int numeroJugadores) {
        this.puntosJugadores = new int[numeroJugadores];
    }

    public int[] getPuntosJugadores() {
        return puntosJugadores;
    }

    public int getPuntosUnJugador(int jugador) {
        return puntosJugadores[jugador];
    }

    public void setPuntosJugadores(int[] puntosJugadores) {
        this.puntosJugadores = puntosJugadores;
    }

    /*
     * Este método es para dar el resultado de todas las partidas juntas
     */
    public static Resultado calcularResultadoFinal(int numeroJugadores, int numeroPartidas){
        Resultado resultadoFinal = new Resultado(numeroJugadores);//Resultado que retornaremos
        Resultado resultado;//Resultado de las partidas que vayamos generando

        //Por cada una de las partidas sumaremos los puntos al resultado final
        for(int i = 0; i < numeroPartidas; i++){
            resultado = Partida.calcularPartida(numeroJugadores);
            int[] puntos = new int[numeroJugadores];

            for (int j = 0; j < numeroJugadores; j++) {
                puntos[j] = resultado.getPuntosUnJugador(j) + resultadoFinal.getPuntosUnJugador(j);
            }
            resultadoFinal.setPuntosJugadores(puntos);
        }
        return resultadoFinal;
    }

    public static boolean[] calcularGanadores(Resultado resultado){
        List<Integer> list = Arrays.stream(resultado.getPuntosJugadores()).boxed().toList();
        int numeroMinimoPuntos = Collections.min(list);
        boolean[] ganadores = new boolean[resultado.getPuntosJugadores().length];
        for (int i = 0; i < ganadores.length; i++) {
            if(numeroMinimoPuntos == resultado.getPuntosUnJugador(i))
                ganadores[i] = true;
        }
        return ganadores;
    } 
}