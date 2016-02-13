package com.nojsoft.conquian.bean;

/**
 * Created by jorge on 11/02/16.
 */
public class Table {
    private Card [] cards;//Array with cards, the player can have up to 9 cards


    public Table (){
        this.cards = new Card[9];
    }

    /**
     *
     * @param cards Array of Card objects, the cards the user has in the table
     */
    public  void set (Card [] cards ){
        this.cards = cards;
    }


    /**
     *
     * @return Array of Card objects, the cards the user has in the table
     */
    public Card[] getCards (){
        return this.cards;
    }

    /**
     * Set a card in a given position on the table, the position must be available (empty)
     * @param card the Card object that we want to set
     * @param tablePosition the position to set the card
     * @return true if the card was set, false if the place was not empty
     */
    public boolean setCard (Card card, int tablePosition){
        boolean flag = false;
        if(cards[tablePosition] == null){
            cards[tablePosition] = card;
            flag = true;
        }
        return flag;
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
     * returns the position of the card in the table
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
