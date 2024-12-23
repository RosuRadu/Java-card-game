
// Implementarea unei carti de joc. Folosesti clasele Rank si Suit pentru a exprima valoarea cartii.

import javax.swing.*;

public class Card implements Comparable {

    private Suit suitValue;
    private Rank rankValue;
    private ImageIcon cardImage;
    private static boolean sortRankMajorOrder = true;

    public Card( Suit suit, Rank rank, ImageIcon cardFace ) {
        cardImage = cardFace;
        suitValue = suit;
        rankValue = rank;
    }

    public static String getFilename( Suit suit, Rank rank ) {
        return rank.getSymbol() + suit.getSymbol() + ".gif";
    }


    public Suit getSuit() {
        return suitValue;
    }


    public Rank getRank() {
        return rankValue;
    }


    public ImageIcon getCardImage() {
        return cardImage;
    }

    public String toString() {
        return rankValue.toString() + " of " + suitValue.toString();
    }

    public String rankToString() {
        return rankValue.toString();
    }

    public String suitToString() {
        return suitValue.toString();
    }

    public static void setRankMajorSort() {
        sortRankMajorOrder = true;
    }

    public static void setSuitMajorSort() {
        sortRankMajorOrder = false;
    }

    public int compareTo( Object otherCardObject ) {
        Card otherCard = (Card) otherCardObject;
        int suitDiff = suitValue.compareTo( otherCard.suitValue );
        int rankDiff = rankValue.compareTo( otherCard.rankValue );

        if ( sortRankMajorOrder ) {
            if ( rankDiff != 0 )
                return rankDiff;
            else
                return suitDiff;
        }
        else {
            if ( suitDiff != 0 )
                return suitDiff;
            else
                return rankDiff;
        }
    }

    public boolean isSameAs( Card card ) {
        if ( ( rankValue != card.rankValue ) || ( suitValue != card.suitValue ) )
            return false;
        else
            return true;
    }

}
