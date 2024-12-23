
// Implemantarea "rank" pentru o carte de joc.


import java.util.*;

public class Rank implements Comparable {
    private String name;
    private String symbol;
    private static boolean aceHigh = false;

    public final static Rank ACE = new Rank( "Ace", "a" );
    public final static Rank TWO = new Rank( "Two", "2" );
    public final static Rank THREE = new Rank( "Three", "3" );
    public final static Rank FOUR = new Rank( "Four", "4" );
    public final static Rank FIVE = new Rank( "Five", "5" );
    public final static Rank SIX = new Rank( "Six", "6" );
    public final static Rank SEVEN = new Rank( "Seven", "7" );
    public final static Rank EIGHT = new Rank( "Eight", "8" );
    public final static Rank NINE = new Rank( "Nine", "9" );
    public final static Rank TEN = new Rank( "Ten", "t" );
    public final static Rank JACK = new Rank( "Jack", "j" );
    public final static Rank QUEEN = new Rank( "Queen", "q" );
    public final static Rank KING = new Rank( "King", "k" );


    private final static List VALUES_KING_HIGH =
            Collections.unmodifiableList(
                    Arrays.asList( new Rank[] { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
                            EIGHT, NINE, TEN, JACK, QUEEN, KING      } ) );

    private final static List VALUES_ACE_HIGH =
            Collections.unmodifiableList(
                    Arrays.asList( new Rank[] { TWO, THREE, FOUR, FIVE, SIX, SEVEN,
                            EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE } ) );

    public final static List VALUES =
            Collections.unmodifiableList( VALUES_KING_HIGH );

    private Rank( String nameValue, String symbolValue ) {
        name = nameValue;
        symbol = symbolValue;
    }

    public static void setKingHigh() {
        aceHigh = false;
    }

    public static void setAceHigh() {
        aceHigh = true;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int compareTo( Object otherRankObject ) {
        Rank otherRank = (Rank) otherRankObject;
        if ( aceHigh )
            return VALUES_ACE_HIGH.indexOf( this ) - VALUES_ACE_HIGH.indexOf( otherRank );
        else
            return VALUES_KING_HIGH.indexOf( this ) - VALUES_KING_HIGH.indexOf( otherRank );
    }

}                                                                 