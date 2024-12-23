
// Implementarea jocului "Razboi".

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CardDeckDemo extends JApplet
{

    private Deck cardDeck;
    private int player1score_value;
    private int player2score_value;
    private Deck cardDeck_adversar;
    private final String directory = "cards/";

    public void init()
    {
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.cyan);
        setSize(777,333);
        cardDisplayLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        cardDisplayLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        cardDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardDisplayLabel.setText("Draw a card...");
        cardDisplayLabel.setOpaque(true);
        getContentPane().add(cardDisplayLabel);
        cardDisplayLabel.setBackground(Color.lightGray);
        cardDisplayLabel.setForeground(Color.black);
        cardDisplayLabel.setBounds(48,24,132,168);
        drawCardBtn.setText("Draw a card...");
        getContentPane().add(drawCardBtn);
        drawCardBtn.setBounds(24,204,192,24);
        newDeckBtn.setText("New & shuffled deck...");
        getContentPane().add(newDeckBtn);
        newDeckBtn.setBounds(24,240,192,24);
        cardsLeftLbl.setText("Cards Left:");
        getContentPane().add(cardsLeftLbl);
        cardsLeftLbl.setForeground(Color.black);
        cardsLeftLbl.setBounds(24,276,193,24);

        cardDisplayLabel_adversar.setHorizontalTextPosition(SwingConstants.CENTER);
        cardDisplayLabel_adversar.setVerticalTextPosition(SwingConstants.BOTTOM);
        cardDisplayLabel_adversar.setHorizontalAlignment(SwingConstants.CENTER);
        cardDisplayLabel_adversar.setText("Draw a card...");
        cardDisplayLabel_adversar.setOpaque(true);
        getContentPane().add(cardDisplayLabel_adversar);
        cardDisplayLabel_adversar.setBackground(Color.lightGray);
        cardDisplayLabel_adversar.setForeground(Color.black);
        cardDisplayLabel_adversar.setBounds(248,24,132,168);

        player1score.setText("Player 1 score:");
        getContentPane().add(player1score);
        player1score.setForeground(Color.black);
        player1score.setBounds(224,276,193,24);

        player2score.setText("Player 2 score:");
        getContentPane().add(player2score);
        player2score.setForeground(Color.black);
        player2score.setBounds(224,246,193,24);

        winner.setText("Let's see who is going to be the winner!");
        getContentPane().add(winner);
        winner.setForeground(Color.black);
        winner.setBounds(224,216,293,24);

        cardDeck = new Deck();


        Iterator suitIterator = Suit.VALUES.iterator();
        while ( suitIterator.hasNext() )
        {
            Suit suit = (Suit) suitIterator.next();
            Iterator rankIterator = Rank.VALUES.iterator();
            while ( rankIterator.hasNext() )
            {
                Rank rank = (Rank) rankIterator.next();
                String imageFile = directory + Card.getFilename( suit, rank );
                ImageIcon cardImage = new ImageIcon( getImage( getCodeBase(), imageFile ) );
                Card card = new Card( suit, rank, cardImage );
                cardDeck.addCard( card );

            }
        }

        cardDeck_adversar = new Deck();


        Iterator suitIterator2 = Suit.VALUES.iterator();
        while ( suitIterator2.hasNext() )
        {
            Suit suit2 = (Suit) suitIterator2.next();
            Iterator rankIterator2 = Rank.VALUES.iterator();
            while ( rankIterator2.hasNext() )
            {
                Rank rank2 = (Rank) rankIterator2.next();
                String imageFile2 = directory + Card.getFilename( suit2, rank2 );
                ImageIcon cardImage2 = new ImageIcon( getImage( getCodeBase(), imageFile2 ) );
                Card card2 = new Card( suit2, rank2, cardImage2 );
                cardDeck_adversar.addCard( card2 );

            }
        }

        cardDeck_adversar.shuffle();


        cardsLeftLbl.setText( "Cards Left: " + cardDeck.getNumberOfCardsRemaining() );

        player1score_value = 0;
        player2score_value =0;

        SymAction lSymAction = new SymAction();
        drawCardBtn.addActionListener(lSymAction);
        newDeckBtn.addActionListener(lSymAction);
    }

    JLabel cardDisplayLabel = new JLabel();
    JButton drawCardBtn = new JButton();
    JButton newDeckBtn = new JButton();
    JLabel cardsLeftLbl = new JLabel();
    JLabel winner = new JLabel();
    JLabel cardDisplayLabel_adversar= new JLabel();
    JLabel player1score = new JLabel();
    JLabel player2score = new JLabel();
    JButton drawCardBtn_adversar= new JButton();
    JLabel cardsLeftLbl_adversar= new JLabel();


    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();
            if (object == drawCardBtn)
                drawCardBtn_actionPerformed(event);
            else if (object == newDeckBtn)
                newDeckBtn_actionPerformed(event);
        }
    }


    void drawCardBtn_actionPerformed(java.awt.event.ActionEvent event)
    {
        Card card = cardDeck.dealCard();
        cardDisplayLabel.setText( card.toString() );
        cardDisplayLabel.setIcon( card.getCardImage() );
        cardsLeftLbl.setText( "Cards Left: " + cardDeck.getNumberOfCardsRemaining() );


        Card card2 = cardDeck_adversar.dealCard();
        cardDisplayLabel_adversar.setText( card2.toString() );
        cardDisplayLabel_adversar.setIcon( card2.getCardImage() );

        if (0>card.compareTo(card2))
        {
            player2score_value++;
        }
        else if (0<card.compareTo(card2))
        {
            player1score_value++;
        }

        player1score.setText( "Player 1 score " +player1score_value);
        player2score.setText( "Player 2 score " +player2score_value);

        if ( cardDeck.getNumberOfCardsRemaining() == 0 )
        {
            drawCardBtn.setEnabled(false);
            if (player1score_value > player2score_value)
                winner.setText( "Player 1 has won! Congratulations!");
                else if (player1score_value < player2score_value)
                    winner.setText( "Player 2 has won! Congratulations!");
                    else
                        winner.setText( "It's a tie! Amazing!");
        }
    }





    void newDeckBtn_actionPerformed(java.awt.event.ActionEvent event)
    {
        cardDeck.restoreDeck();
        cardDeck.shuffle();
        drawCardBtn.setEnabled( true );
        cardDisplayLabel.setIcon( null );
        cardDisplayLabel.setText( "Draw a card..." );
        cardsLeftLbl.setText( "Cards Left: " + cardDeck.getNumberOfCardsRemaining() );

        cardDeck_adversar.restoreDeck();
        cardDeck_adversar.shuffle();
        drawCardBtn_adversar.setEnabled( true );
        cardDisplayLabel_adversar.setIcon( null );
        cardDisplayLabel_adversar.setText( "Draw a card..." );
        cardsLeftLbl_adversar.setText( "Cards Left: " + cardDeck_adversar.getNumberOfCardsRemaining() );

        player1score_value = 0;
        player2score_value = 0;

        player1score.setText( "Player 1 score " +player1score_value);
        player2score.setText( "Player 2 score " +player2score_value);
    }


}
