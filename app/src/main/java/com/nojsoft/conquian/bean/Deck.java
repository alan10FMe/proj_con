package com.nojsoft.conquian.bean;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nojsoft.conquian.Util.Utility;
import com.nojsoft.conquian.constants.CardConstants;
import com.nojsoft.conquian.exception.NoMoreCardsException;
import com.nojsoft.conquian.views.CardView;

/**
 * Created by jorge on 11/02/16.
 */
public class Deck {
    private List <Integer> cards;
    private int id = 1; //card position, each time getNExtCard is called this val is increased by 1
    private Context context;

    /**
     * The constructor creates the 40 cards, ints associated with values in constants
     */
    public Deck (Context context){
        this.context = context;
        cards = new ArrayList<Integer>();
        for (int i = 0; i < 40; i++) {
            cards.add(i);
        }
        shuffleCards();
    }

    /**
     * This method shuffles the 40 cards and assign them an ID (position in the Deck)
     */
    private void shuffleCards (){
        List <Integer> shuffledCards = new ArrayList<Integer>();
        int randnumber = -1;
        int id=0;
        int upperLimit = 40;

        while(cards.size()>0){
            randnumber = (int)Math.floor(Math.random()*upperLimit);
            if(randnumber>=0&&randnumber<cards.size()) {
                shuffledCards.add(cards.remove(randnumber));
                upperLimit--;
            }
        }
        cards = shuffledCards;
    }

    /**
     * This method returns the next card in the deck, throws exception if the deck is empty
     * @return the next Card
     * @throws NoMoreCardsException when there are no more cards
     */
    public CardView getNextCard () throws NoMoreCardsException{
        CardView cardView = null;
        int card = -1;
        if(cards.size()<1)
            throw new NoMoreCardsException();
        card = cards.remove(0);
        cardView = convertNameToCardView(context, card);
        return cardView;
    }

    /**
     * This method Returns the hand for a player, 8 Cards
     * @return Array with 8 cards
     */
    public Hand getHand (){
        CardView [] handCards = new CardView[8];
        Hand hand = new Hand();
        for(int i= 0; i < 8; i++){
            try {
                handCards[i] = getNextCard();
            }catch (NoMoreCardsException e){
                e.printStackTrace();
            }
        }
        hand.set(handCards);
        return hand;
    }

    /**
     *
     * @param context Context for the CardView
     * @param constPos the position that defines this card in the Constant array
     * @return the actual CardView object
     */
    private CardView convertNameToCardView (Context context, int constPos) {
        CardView cardView = null;
        String cardName = CardConstants.cardNames[constPos];
        String type = cardName.substring(0, 1);
        int numValue =  Integer.parseInt(cardName.substring(1));
        cardView = new CardView(context, numValue, type, id++);
        Utility.displayImageCard(context, cardView);
        return cardView;
    }
}
