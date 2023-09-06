package logica;

import java.util.ArrayList;
import java.util.Collections;

public class Partida {
    /*
     * Este método es para calcular una sola partida
     */
    public static Resultado calcularPartida(int numeroJugadores){
        
        final int cartasARepartir = 7;
        //Código
        //Para cada partida hay un mazo de cartas, un sentido y un turno
        //Cada jugador tiene una baraja
        //creamos el mazo -> repartimos 7 cartas -> jugador aleatorio tiene el turno
        
        boolean partidaFinalizada = false;
        int turno = (int) (Math.random()*numeroJugadores);
        boolean sentido = true; //True es incremental 1 -> 2 -> 3 -> 0 -> 1 (en caso de 4 jugadores)
        
        ArrayList<Carta> mazo = Carta.mazoProvider();
        Collections.shuffle(mazo); 
        Carta ultimaCarta = mazo.remove(0); //Esta va a ser la carta "que está encima".

        ArrayList<ArrayList<Carta>> jugadores = repartirCartasInicio(mazo, numeroJugadores, cartasARepartir);
        if(jugadores == null)
            partidaFinalizada = true;

        while(!partidaFinalizada)
        {
            ultimaCarta = accionJugador(turno, ultimaCarta, mazo, jugadores, sentido);
        }

        Resultado resultado = new Resultado(numeroJugadores);
        int[] puntos = new int[numeroJugadores];
        resultado.setPuntosJugadores(puntos);
        return resultado;
    }

    private static ArrayList<ArrayList<Carta>> repartirCartasInicio(ArrayList<Carta> mazo, int numeroJugadores, int cartasARepartir) {
        
        //Si el mazo es más pequeño que las cartas a repartir, la partida no se inicia
        if(mazo.size()<(numeroJugadores*cartasARepartir))
            return null;

        ArrayList<ArrayList<Carta>> jugadores = new ArrayList<ArrayList<Carta>>();

        for (int i = 0; i < numeroJugadores; i++) {
            ArrayList<Carta> a = new ArrayList<Carta>();
            for (int j = 0; j < cartasARepartir; j++) {
                //Aqui damos 7 cartas a cada jugador sacándolas del mazo
                //jugadores[i].add(mazo.remove(0));
                
                a.add(mazo.remove(i));
            }
            jugadores.add(a);
        }
        return jugadores;
    }

    private static Carta accionJugador(int turno, Carta ultimaCarta, ArrayList<Carta> mazo,
            ArrayList<ArrayList<Carta>> jugadores, boolean sentido) {
                return ultimaCarta;
    }
}
