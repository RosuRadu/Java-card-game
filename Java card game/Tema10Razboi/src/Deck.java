
// Implementeaza un pachet de carti.Foloseste clasa Card.

import java.util.*;

public class Deck {
    private List deck;
    private int index;

    public Deck() {
        deck = new ArrayList();
        index = 0;
    }

    public void addCard( Card card ) {
        deck.add( card );
    }

    public int getSizeOfDeck() {
        return deck.size();
    }

    public int getNumberOfCardsRemaining() {
        return deck.size() - index;
    }

    public Card dealCard() {
        if ( index >= deck.size() )
            return null;
        else
            return (Card) deck.get( index++ );
    }

    public void shuffle() {
        Collections.shuffle( deck );
    }

    public boolean isEmpty() {
        if ( index >= deck.size() )
            return true;
        else
            return false;
    }

    public void restoreDeck() {
        index = 0;
    }

}
