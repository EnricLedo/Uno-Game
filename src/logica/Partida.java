package logica;

import java.util.ArrayList;
import java.util.Collections;
import logica.Carta.Color;
import logica.Carta.TipoCarta;
import static logica.Estrategias.*;
import static logica.MecanicasJuego.*;



public class Partida {
    /*
     * Este método solo calcula una partida
     */

    //Para cada partida hay un mazo de cartas, un sentido, un turno y efectoCartaUsado
    //El efectoCartaUsado nos dirá si el efecto de la carta que hay sobre la mesa ya ha sido ejecutado
    //Cada jugador tiene una baraja
    //creamos el mazo -> repartimos 7 cartas -> jugador aleatorio tiene el turno
    
    private static int turno = 0;
    private static boolean sentido = true; //True es incremental 1 -> 2 -> 3 -> 0 -> 1 (en caso de 4 jugadores)
    private static boolean efectoCartaUsado = false;
    private static boolean partidaFinalizada = false;

    public static Resultado calcularPartida(int numeroJugadores){
        
        final int cartasARepartir = 7;
        
        turno = (int) (Math.random()*numeroJugadores);

        ArrayList<Carta> mazo = Carta.mazoProvider();
        Collections.shuffle(mazo); 
        Carta ultimaCarta = mazo.removeFirst(); //Esta va a ser la carta "que está encima".

        //Hay que comprobar que si la carta es un comodín, le asignemos un color aleatorio.
        if(ultimaCarta.getColor().equals(Color.NEGRO)){
            int aux = (int) (Math.random() * 4);
            switch (aux) {
                case 0 -> ultimaCarta.setColor(Color.VERDE);
                case 1 -> ultimaCarta.setColor(Color.ROJO);
                case 2 -> ultimaCarta.setColor(Color.AZUL);
                case 3 -> ultimaCarta.setColor(Color.AMARILLO);
            }
        }

        //Aqui declaramos los mazos de los jugadores. Cada mazo es un arraylist de cartas, por lo que metemos los 4 mazos en otro arraylist. 
        ArrayList<ArrayList<Carta>> jugadores = repartirCartasInicio(mazo, numeroJugadores, cartasARepartir);
        
        System.out.println("Da comienzo la partida con un " + ultimaCarta);
        while(!partidaFinalizada)
        {
            ultimaCarta = accionJugador(ultimaCarta, mazo, jugadores);
        }

        Resultado resultado = new Resultado(numeroJugadores);
        int[] puntos = new int[numeroJugadores];
        for (int i = 0; i < numeroJugadores; i++) {
            puntos[i]=Resultado.sumarPuntos(jugadores.get(i));
        }
        resultado.setPuntosJugadores(puntos);
        return resultado;
    }

    private static ArrayList<ArrayList<Carta>> repartirCartasInicio(ArrayList<Carta> mazo, int numeroJugadores, int cartasARepartir) {
        
        //Si el mazo es más pequeño que las cartas a repartir, la partida no se inicia
        if(mazo.size()<(numeroJugadores*cartasARepartir))
            return null;

        ArrayList<ArrayList<Carta>> jugadores = new ArrayList<>();

        for (int i = 0; i < numeroJugadores; i++) {
            ArrayList<Carta> mazoAuxiliar = new ArrayList<>();
            for (int j = 0; j < cartasARepartir; j++) {
                //Aqui damos 7 cartas a cada jugador sacándolas del mazo
                mazoAuxiliar.add(mazo.removeFirst());
            }
            jugadores.add(mazoAuxiliar);
        }
        return jugadores;
    }

    private static Carta accionJugador(Carta ultimaCarta, ArrayList<Carta> mazo, ArrayList<ArrayList<Carta>> jugadores) {

        //Debo comprobar que no me hayan tirado un +2 o +4
        if(ultimaCarta.getTipoCarta().equals(TipoCarta.MAS_DOS) && !efectoCartaUsado){
            //Sumamos 2
            for (int i = 0; i < 2; i++) {
                if(!mazo.isEmpty())
                    jugadores.get(turno).add(mazo.removeFirst());
                else{
                    mazo = rehacerMazo(jugadores, ultimaCarta);
                    jugadores.get(turno).add(mazo.removeFirst());
                }
            }
            efectoCartaUsado = true;
            System.out.println("El jugador " + turno + " roba 2.");    
        } else if(ultimaCarta.getTipoCarta().equals(TipoCarta.MAS_CUATRO) && !efectoCartaUsado){
            //Sumamos 4
            for (int i = 0; i < 4; i++) {
                if(!mazo.isEmpty())
                jugadores.get(turno).add(mazo.removeFirst());
                else{
                    mazo = rehacerMazo(jugadores, ultimaCarta);
                    jugadores.get(turno).add(mazo.removeFirst());
                }
            }
            efectoCartaUsado = true;
            System.out.println("El jugador " + turno + " roba 4.");
        } else{

            //Un jugador debe tirar una carta, para eso debe comprobar que cartas puede tirar.
            ArrayList<Carta> cartasJugables = cartasJugables(ultimaCarta, jugadores.get(turno));

            //El jugador debe robar puesto que no tiene ninguna carta disponible para tirar
            boolean jugarCartaRobada = true;
            if(cartasJugables.isEmpty()){
                if(mazo.isEmpty())
                    mazo = rehacerMazo(jugadores, ultimaCarta);
                
                jugadores.get(turno).add(mazo.removeFirst());
                jugarCartaRobada = false;
                
                //Comprobamos que la carta que acabamos de robar se pueda usar
                ArrayList<Carta> cartaRobada = new ArrayList<>();
                cartaRobada.add(jugadores.get(turno).getLast());
                if(!cartasJugables(ultimaCarta,cartaRobada).isEmpty()){
                    cartasJugables.add(jugadores.get(turno).getLast());
                    jugarCartaRobada = true;
                }

            }
            if(jugarCartaRobada){
                //El jugador utiliza una carta y se queda sin ella.
                ultimaCarta = estrategia(turno, ultimaCarta, cartasJugables, mazo, sentido);
                System.out.println("El jugador " + turno + " tira: " + ultimaCarta);    
                jugadores.get(turno).remove(ultimaCarta);
                efectoCartaUsado = false;
            }
        }
        //Ahora tengo que comprobar:
        //1. Que la partida no haya terminado, 2. Actualizar el sentido, 3. El siguiente turno

        //1. Partida finalizada?
        if(jugadores.get(turno).isEmpty()){
            partidaFinalizada = true;
        } else{
            //2. Actualizar el sentido
            if(ultimaCarta.getTipoCarta().equals(TipoCarta.CAMBIO_SENTIDO) && !efectoCartaUsado){
                sentido = !sentido;
                efectoCartaUsado = true;
            }
            //3. Adjudicar el siguiente turno

            //Solo pasamos dos turnos en caso de TipoCarta.SALTAR_TURNO
            //De este modo, con los otros tipos de cartas donde también pierdes el turno
            //se ejecuta nuevamente el metodo para robar 2 o 4 cartas.
            if(ultimaCarta.getTipoCarta().equals(TipoCarta.SALTAR_TURNO) && !efectoCartaUsado){
                turno = saltarTurno(turno, jugadores.size(), sentido, 2);
                efectoCartaUsado = true;
            }else {
                turno = saltarTurno(turno, jugadores.size(), sentido, 1);
            }
        }
        return ultimaCarta; //carta que se tira sobre la mesa
    }
}
