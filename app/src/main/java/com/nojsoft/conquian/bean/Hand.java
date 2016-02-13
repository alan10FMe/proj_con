package com.nojsoft.conquian.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 11/02/16.
 */
public class Hand {
    private Card [] cards;//Array with cards, the player will get 8, the 9th card is the objective

    /**
     *
     * @param cards Array of Card objects, the cards the user has in his/her hand
     */
    public  void set (Card [] cards ){
        this.cards = cards;
    }


    /**
     *
     * @return Array of Card objects, the cards the user has in his/her hand
     */
    public Card[] getCards (){
        return this.cards;
    }

    /**
     * return the cards that the user wants to drop from his/her hand, and removes them from hand
     * @param ids this method receives the position of the cards to be dropped, this is the
     *                  position of the card in the deck after shuffling it, since this value is
     *                  unique it can be used as identifier.
     * @return null if the size of the position's list is 0 or no coincidences were found
     */
    public Card [] dropCard (int [] ids){
        Card [] droppedCards = null;
        int position = 0;
        if (ids!= null && ids.length>0) {
            droppedCards = new Card[ids.length];
            for (int id : ids) {
                for (Card card : cards) {
                    if (card.getId() == id) {
                        droppedCards[position++]=card;
                    }
                }
            }

            if(position>0){
                for(Card dropped: droppedCards){
                    for(int i = 0; i< cards.length; i++){
                        if(cards[i]==dropped)
                            cards[i]=null;
                    }
                }
            }else{
                droppedCards=null;
            }
        }
        return droppedCards;
    }

    /**
     * Changes the position of two cards, useful if the user wants to re organize his/her cards
     * @param currentPos current position of the card in the hand (array)
     * @param futurePos the desired position of the card
     */
    public void changePosition (int currentPos, int futurePos){
        boolean changed =false;
        Card holder = cards[currentPos];
        cards[currentPos] = cards[futurePos];
        cards[futurePos] = holder;
    }

    /**
     * returns the position of the card in the hand
     * @param id the card's id in which we are interested
     * @return the position in hand (array)
     */
    public int getHandPosition (int id){
        int position = -1;
        Card card;
        for(int i = 0; i < cards.length; i++){
            card = cards [i];
            if(card.getId() == id)
                position = i;
        }
        return position;
    }
}
