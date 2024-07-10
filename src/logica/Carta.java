package logica;

import java.util.ArrayList;

/*
 * Este mètodo nos servirá para representar las 108 cartas que hay en el juego
 * no habrá setters puesto que las cartas serán inalterables, las crearemos solomente mediante el constructor
*/
public class Carta {
    
    private final Integer cartaId;
    private final TipoCarta tipoCarta;
    private Color color;
    private final int numero;
    
    public Carta(Integer cartaId, TipoCarta tipoCarta, Color color, int numero) {
        this.cartaId = cartaId;
        this.tipoCarta = tipoCarta;
        this.color = color;
        this.numero = numero;
    }

    public Integer getCartaId() {
        return cartaId;
    }
    
    public TipoCarta getTipoCarta() {
        return tipoCarta;
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getNumero() {
        return numero;
    }
    //Este setter debemos usarlo para cambiar el color NEGRO,
    //de este modo informamos sobre el color al que decidimos cambiar
    public void setColor(Color color) {
        this.color = color;
    }

    public enum TipoCarta {
        COLOR,
        CAMBIO_SENTIDO,
        SALTAR_TURNO,
        MAS_DOS,
        MAS_CUATRO,
        CAMBIO_COLOR
    }
    
    public enum Color {
        ROJO,
        AZUL,
        VERDE,
        AMARILLO,
        NEGRO
    }

    @Override
    public String toString() {
        switch (tipoCarta) {
            case COLOR -> {
                return numero + " " + color;
            }
            case SALTAR_TURNO, CAMBIO_SENTIDO, MAS_DOS -> {    
                return tipoCarta + " " + color;
            }
            case MAS_CUATRO, CAMBIO_COLOR -> {
                if(color.equals(Color.NEGRO))
                    return tipoCarta + "";
                else
                    return tipoCarta + " " + color;
            }
            default -> {
                return "Carta{" +
                        "cartaId=" + cartaId +
                        ", tipoCarta=" + tipoCarta +
                        ", color=" + color +
                        ", numero=" + numero +
                        '}';
            }
        }
    }


    public static ArrayList<Carta> mazoProvider(){
        ArrayList<Carta> mazo = new ArrayList<>();
        
        mazo.add(new Carta(1, TipoCarta.COLOR, Color.ROJO, 0));
        mazo.add(new Carta(2, TipoCarta.COLOR, Color.ROJO, 1));
        mazo.add(new Carta(3, TipoCarta.COLOR, Color.ROJO, 1));
        mazo.add(new Carta(4, TipoCarta.COLOR, Color.ROJO, 2));
        mazo.add(new Carta(5, TipoCarta.COLOR, Color.ROJO, 2));
        mazo.add(new Carta(6, TipoCarta.COLOR, Color.ROJO, 3));
        mazo.add(new Carta(7, TipoCarta.COLOR, Color.ROJO, 3));
        mazo.add(new Carta(8, TipoCarta.COLOR, Color.ROJO, 4));
        mazo.add(new Carta(9, TipoCarta.COLOR, Color.ROJO, 4));
        mazo.add(new Carta(10, TipoCarta.COLOR, Color.ROJO, 5));
        mazo.add(new Carta(11, TipoCarta.COLOR, Color.ROJO, 5));
        mazo.add(new Carta(12, TipoCarta.COLOR, Color.ROJO, 6));
        mazo.add(new Carta(13, TipoCarta.COLOR, Color.ROJO, 6));
        mazo.add(new Carta(14, TipoCarta.COLOR, Color.ROJO, 7));
        mazo.add(new Carta(15, TipoCarta.COLOR, Color.ROJO, 7));
        mazo.add(new Carta(16, TipoCarta.COLOR, Color.ROJO, 8));
        mazo.add(new Carta(17, TipoCarta.COLOR, Color.ROJO, 8));
        mazo.add(new Carta(18, TipoCarta.COLOR, Color.ROJO, 9));
        mazo.add(new Carta(19, TipoCarta.COLOR, Color.ROJO, 9));

        mazo.add(new Carta(20, TipoCarta.COLOR, Color.VERDE, 0));
        mazo.add(new Carta(21, TipoCarta.COLOR, Color.VERDE, 1));
        mazo.add(new Carta(22, TipoCarta.COLOR, Color.VERDE, 1));
        mazo.add(new Carta(23, TipoCarta.COLOR, Color.VERDE, 2));
        mazo.add(new Carta(24, TipoCarta.COLOR, Color.VERDE, 2));
        mazo.add(new Carta(25, TipoCarta.COLOR, Color.VERDE, 3));
        mazo.add(new Carta(26, TipoCarta.COLOR, Color.VERDE, 3));
        mazo.add(new Carta(27, TipoCarta.COLOR, Color.VERDE, 4));
        mazo.add(new Carta(28, TipoCarta.COLOR, Color.VERDE, 4));
        mazo.add(new Carta(29, TipoCarta.COLOR, Color.VERDE, 5));
        mazo.add(new Carta(30, TipoCarta.COLOR, Color.VERDE, 5));
        mazo.add(new Carta(31, TipoCarta.COLOR, Color.VERDE, 6));
        mazo.add(new Carta(32, TipoCarta.COLOR, Color.VERDE, 6));
        mazo.add(new Carta(33, TipoCarta.COLOR, Color.VERDE, 7));
        mazo.add(new Carta(34, TipoCarta.COLOR, Color.VERDE, 7));
        mazo.add(new Carta(35, TipoCarta.COLOR, Color.VERDE, 8));
        mazo.add(new Carta(36, TipoCarta.COLOR, Color.VERDE, 8));
        mazo.add(new Carta(37, TipoCarta.COLOR, Color.VERDE, 9));
        mazo.add(new Carta(38, TipoCarta.COLOR, Color.VERDE, 9));

        mazo.add(new Carta(39, TipoCarta.COLOR, Color.AZUL, 0));
        mazo.add(new Carta(40, TipoCarta.COLOR, Color.AZUL, 1));
        mazo.add(new Carta(41, TipoCarta.COLOR, Color.AZUL, 1));
        mazo.add(new Carta(42, TipoCarta.COLOR, Color.AZUL, 2));
        mazo.add(new Carta(43, TipoCarta.COLOR, Color.AZUL, 2));
        mazo.add(new Carta(44, TipoCarta.COLOR, Color.AZUL, 3));
        mazo.add(new Carta(45, TipoCarta.COLOR, Color.AZUL, 3));
        mazo.add(new Carta(46, TipoCarta.COLOR, Color.AZUL, 4));
        mazo.add(new Carta(47, TipoCarta.COLOR, Color.AZUL, 4));
        mazo.add(new Carta(48, TipoCarta.COLOR, Color.AZUL, 5));
        mazo.add(new Carta(49, TipoCarta.COLOR, Color.AZUL, 5));
        mazo.add(new Carta(50, TipoCarta.COLOR, Color.AZUL, 6));
        mazo.add(new Carta(51, TipoCarta.COLOR, Color.AZUL, 6));
        mazo.add(new Carta(52, TipoCarta.COLOR, Color.AZUL, 7));
        mazo.add(new Carta(53, TipoCarta.COLOR, Color.AZUL, 7));
        mazo.add(new Carta(54, TipoCarta.COLOR, Color.AZUL, 8));
        mazo.add(new Carta(55, TipoCarta.COLOR, Color.AZUL, 8));
        mazo.add(new Carta(56, TipoCarta.COLOR, Color.AZUL, 9));
        mazo.add(new Carta(57, TipoCarta.COLOR, Color.AZUL, 9));

        mazo.add(new Carta(58, TipoCarta.COLOR, Color.AMARILLO, 0));
        mazo.add(new Carta(59, TipoCarta.COLOR, Color.AMARILLO, 1));
        mazo.add(new Carta(60, TipoCarta.COLOR, Color.AMARILLO, 1));
        mazo.add(new Carta(61, TipoCarta.COLOR, Color.AMARILLO, 2));
        mazo.add(new Carta(62, TipoCarta.COLOR, Color.AMARILLO, 2));
        mazo.add(new Carta(63, TipoCarta.COLOR, Color.AMARILLO, 3));
        mazo.add(new Carta(64, TipoCarta.COLOR, Color.AMARILLO, 3));
        mazo.add(new Carta(65, TipoCarta.COLOR, Color.AMARILLO, 4));
        mazo.add(new Carta(66, TipoCarta.COLOR, Color.AMARILLO, 4));
        mazo.add(new Carta(67, TipoCarta.COLOR, Color.AMARILLO, 5));
        mazo.add(new Carta(68, TipoCarta.COLOR, Color.AMARILLO, 5));
        mazo.add(new Carta(69, TipoCarta.COLOR, Color.AMARILLO, 6));
        mazo.add(new Carta(70, TipoCarta.COLOR, Color.AMARILLO, 6));
        mazo.add(new Carta(71, TipoCarta.COLOR, Color.AMARILLO, 7));
        mazo.add(new Carta(72, TipoCarta.COLOR, Color.AMARILLO, 7));
        mazo.add(new Carta(73, TipoCarta.COLOR, Color.AMARILLO, 8));
        mazo.add(new Carta(74, TipoCarta.COLOR, Color.AMARILLO, 8));
        mazo.add(new Carta(75, TipoCarta.COLOR, Color.AMARILLO, 9));
        mazo.add(new Carta(76, TipoCarta.COLOR, Color.AMARILLO, 9));
        
        mazo.add(new Carta(77, TipoCarta.MAS_DOS, Color.ROJO, -1));
        mazo.add(new Carta(78, TipoCarta.MAS_DOS, Color.ROJO, -1));
        mazo.add(new Carta(79, TipoCarta.MAS_DOS, Color.VERDE, -1));
        mazo.add(new Carta(80, TipoCarta.MAS_DOS, Color.VERDE, -1));
        mazo.add(new Carta(81, TipoCarta.MAS_DOS, Color.AZUL, -1));
        mazo.add(new Carta(82, TipoCarta.MAS_DOS, Color.AZUL, -1));
        mazo.add(new Carta(83, TipoCarta.MAS_DOS, Color.AMARILLO, -1));
        mazo.add(new Carta(84, TipoCarta.MAS_DOS, Color.AMARILLO, -1));
        
        mazo.add(new Carta(85, TipoCarta.CAMBIO_SENTIDO, Color.ROJO, -1));
        mazo.add(new Carta(86, TipoCarta.CAMBIO_SENTIDO, Color.ROJO, -1));
        mazo.add(new Carta(87, TipoCarta.CAMBIO_SENTIDO, Color.VERDE, -1));
        mazo.add(new Carta(88, TipoCarta.CAMBIO_SENTIDO, Color.VERDE, -1));
        mazo.add(new Carta(89, TipoCarta.CAMBIO_SENTIDO, Color.AZUL, -1));
        mazo.add(new Carta(90, TipoCarta.CAMBIO_SENTIDO, Color.AZUL, -1));
        mazo.add(new Carta(91, TipoCarta.CAMBIO_SENTIDO, Color.AMARILLO, -1));
        mazo.add(new Carta(92, TipoCarta.CAMBIO_SENTIDO, Color.AMARILLO, -1));

        mazo.add(new Carta(93, TipoCarta.SALTAR_TURNO, Color.ROJO, -1));
        mazo.add(new Carta(94, TipoCarta.SALTAR_TURNO, Color.ROJO, -1));
        mazo.add(new Carta(95, TipoCarta.SALTAR_TURNO, Color.VERDE, -1));
        mazo.add(new Carta(96, TipoCarta.SALTAR_TURNO, Color.VERDE, -1));
        mazo.add(new Carta(97, TipoCarta.SALTAR_TURNO, Color.AZUL, -1));
        mazo.add(new Carta(98, TipoCarta.SALTAR_TURNO, Color.AZUL, -1));
        mazo.add(new Carta(99, TipoCarta.SALTAR_TURNO, Color.AMARILLO, -1));
        mazo.add(new Carta(100, TipoCarta.SALTAR_TURNO, Color.AMARILLO, -1));

        mazo.add(new Carta(101, TipoCarta.MAS_CUATRO, Color.NEGRO, -1));
        mazo.add(new Carta(102, TipoCarta.MAS_CUATRO, Color.NEGRO, -1));
        mazo.add(new Carta(103, TipoCarta.MAS_CUATRO, Color.NEGRO, -1));
        mazo.add(new Carta(104, TipoCarta.MAS_CUATRO, Color.NEGRO, -1));

        mazo.add(new Carta(105, TipoCarta.CAMBIO_COLOR, Color.NEGRO, -1));
        mazo.add(new Carta(106, TipoCarta.CAMBIO_COLOR, Color.NEGRO, -1));
        mazo.add(new Carta(107, TipoCarta.CAMBIO_COLOR, Color.NEGRO, -1));
        mazo.add(new Carta(108, TipoCarta.CAMBIO_COLOR, Color.NEGRO, -1));

        return mazo;
    }
}


