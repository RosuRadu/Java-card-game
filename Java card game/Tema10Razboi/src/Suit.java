
// Implementeazaa clasa "suit" pentru un joc de carti.

import java.util.*;

public final class Suit implements Comparable {
    private String name;
    private String symbol;

    public final static Suit CLUBS = new Suit( "Clubs", "c" );
    public final static Suit DIAMONDS = new Suit( "Diamonds", "d" );
    public final static Suit HEARTS = new Suit( "Hearts", "h" );
    public final static Suit SPADES = new Suit( "Spades", "s" );
    public final static List VALUES =
            Collections.unmodifiableList(
                    Arrays.asList( new Suit[] { CLUBS, DIAMONDS, HEARTS, SPADES } ) );

    private Suit( String nameValue, String symbolValue ) {
        name = nameValue;
        symbol = symbolValue;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String toString() {
        return name;
    }

    public int compareTo( Object otherSuitObject ) {
        Suit otherSuit = (Suit) otherSuitObject;
        return VALUES.indexOf( this ) - VALUES.indexOf( otherSuit );
    }

}

    