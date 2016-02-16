package com.nojsoft.conquian.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nojsoft.conquian.constants.CardConstants;
import com.nojsoft.conquian.exception.NoMoreCardsException;

/**
 * Created by jorge on 11/02/16.
 */
public class Deck {
    private List<Card> cards;

    /**
     * The constructor creates the 40 cards, 10 of each type
     */
    public Deck (){
//        cards = new ArrayList<Card>();
//        for (int i = 1; i <= 10; i++){
//            for(String type : CardConstants.types){
//                cards.add(new Card(i,type));
//            }
//        }
//        shuffleCards();
    }

    /**
     * This method shuffles the 40 cards and assign them an ID (position in the Deck)
     */
    private void shuffleCards (){
        List <Card> shuffledCards = new ArrayList<Card>();
        int randnumber = -1;
        int id=1;
        Card card = null;
        while(cards.size()>0){
            randnumber = (int)Math.floor(Math.random()*40+1);
            card = cards.remove(randnumber);
            card.setId(id++);
            shuffledCards.add(card);
        }
        cards = shuffledCards;
    }

    /**
     * This method returns the next card in the deck, throws exception if the deck is empty
     * @return the next Card
     * @throws NoMoreCardsException when there are no more cards
     */
    public Card getNextCard () throws NoMoreCardsException{
        if(cards.size()<1)
            throw new NoMoreCardsException();
        return cards.remove(0);
    }

    /**
     * This method Returns the hand for a player, 8 Cards
     * @return Array with 8 cards
     */
    public Hand getHand (){
        Card [] handCards = new Card[8];
        Hand hand = new Hand();
        for(int i= 0; i < 8; i++){
            handCards[i] = cards.remove(0);
        }
        hand.set(handCards);
        return hand;
    }
}
