package logica;

import java.util.ArrayList;
import logica.Carta.Color;

public class Estrategias {
    public static Carta estrategia(int turno, Carta ultimaCarta, ArrayList<Carta> cartasJugables,ArrayList<Carta> mazo, boolean sentido){
        Carta cartaAJugar = cartasJugables.getFirst();

        //Hay que comprobar que si la carta es un comodín, le asignemos un color aleatorio.
        if(cartaAJugar.getColor().equals(Color.NEGRO)){
            int aux = (int) (Math.random() * 4);
            switch (aux) {
                case 0 -> cartaAJugar.setColor(Color.VERDE);
                case 1 -> cartaAJugar.setColor(Color.ROJO);
                case 2 -> cartaAJugar.setColor(Color.AZUL);
                case 3 -> cartaAJugar.setColor(Color.AMARILLO);
            }
        }

        return cartaAJugar;
    }
}
