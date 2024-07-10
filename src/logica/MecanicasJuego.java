package logica;

import  java.util.ArrayList;
import java.util.Collections;
import logica.Carta.Color;
import logica.Carta.TipoCarta;

public class MecanicasJuego {

    //Calcula las cartas del mazo que se pueden jugar en base a la carta sobre la mesa y el color en caso de que ésta sea un comodín.
    public static ArrayList<Carta> cartasJugables(Carta ultimaCarta, ArrayList<Carta> mazo) {
        ArrayList<Carta> cartasJugables = new ArrayList<>();

        //Podemos tirar la carta si:
        //1. Es Negra (Comodín)
        //2. Coincide en color
        //3. Coincide en numero
        //4. Coincide en tipo
        for (int i = 0; i < mazo.size(); i++) {
            //1. Es un comodín (carta negra) ?
            if(mazo.get(i).getColor().equals(Color.NEGRO)){
                cartasJugables.add(mazo.get(i));
            } else
            //2. Coincide en color con la carta de la mesa o con el color que ha elegido el jugador que ha tirado el comodín?
            if(mazo.get(i).getColor().equals(ultimaCarta.getColor())){
                cartasJugables.add(mazo.get(i));
            } else
            //3. Coincide en número?
            if (mazo.get(i).getNumero() == ultimaCarta.getNumero() && ultimaCarta.getNumero() != -1) {
                cartasJugables.add(mazo.get(i));
            } else
            //4. Coincide en tipo, sin tipo ser color.
            if (mazo.get(i).getTipoCarta().equals(ultimaCarta.getTipoCarta()) && (!ultimaCarta.getTipoCarta().equals(TipoCarta.COLOR))) {
                cartasJugables.add(mazo.get(i));
            }
        }

        return cartasJugables;
    }

    public static int saltarTurno(int turno, int numeroJugadores, boolean sentido, int nTurnos){
        if(sentido){
            for(int i = 0; i<nTurnos; i++){
                    turno++;
                if(turno == numeroJugadores){
                    turno = 0;
                }
            }
        }else if(!sentido){
            for(int i = 0; i<nTurnos; i++){
                turno--;
                if(turno == -1){
                    turno = numeroJugadores-1;
                }
            }
        }
        return turno;
    }

    public static ArrayList<Carta> rehacerMazo(ArrayList<ArrayList<Carta>> jugadores, Carta ultimaCarta){
        ArrayList<Carta> mazo = Carta.mazoProvider();

        for(int i = 0; i < jugadores.size(); i++){
            for(int j = 0; j < jugadores.get(i).size(); j++){
                mazo.remove(jugadores.get(i).get(j));
            }
        }

        mazo.remove(ultimaCarta);
        Collections.shuffle(mazo);
        
        if(!mazo.isEmpty()){
            System.out.println("SE HA RELLENADO EL MAZO PERO LOS JUGADORES Y LA CARTA DE LA MESA SUMAN UN TOTAL DE 108 CARTAS!");
        }
        return mazo;
    }
}