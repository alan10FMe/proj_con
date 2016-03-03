package com.nojsoft.conquian.bean;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.nojsoft.conquian.R;
import com.nojsoft.conquian.views.CardView;

/**
 * Created by jorge on 11/02/16.
 */
public class Table {

    private Card [] cards;//Array with cards, the player can have up to 9 cards
    private CardView[] imageCards;//Array with the image representation in the UI for each card
    private Context context;
    private int id;


    private Table (){
    }

    public Table(Context context, int id){
        this.context = context;
        this.id = id;
        this.cards = new Card[9];
        LinearLayout linearHand = (LinearLayout) (((Activity)context).findViewById(context.getResources().getIdentifier("game_player_" + id, "id", context.getPackageName())));
        imageCards = new CardView[9];
        for(int i=0; i < linearHand.getChildCount(); i++){
            if(linearHand.getChildAt(i) instanceof CardView){
                imageCards[i] = (CardView)linearHand.getChildAt(i);
            }
        }
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

    public CardView[] getImageCards() {
        return imageCards;
    }

    public void setImageCards(CardView[] imageCards) {
        this.imageCards = imageCards;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
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

    public void transformCardsToViews(){
        for(int i = 0; i < cards.length; i++){
            imageCards[i].setImageResource(context.getResources().getIdentifier(cards[i].getName(), "drawable", context.getPackageName()));
//            imageCards[i].setTag(cards[i].getName());
        }
    }

    public void enableDrop() {
        if (context instanceof View.OnDragListener) {
            for (int i = 0; i < imageCards.length; i++) {
                imageCards[i].setOnDragListener((View.OnDragListener) context);
            }
        }
    }

    public void enableDrag() {
        if (context instanceof View.OnTouchListener) {
            for (int i = 0; i < imageCards.length; i++) {
                imageCards[i].setOnTouchListener((View.OnTouchListener) context);
            }
        }
    }

    public void disableDrag() {
        for (int i = 0; i < imageCards.length; i++) {
            imageCards[i].setOnTouchListener(null);
        }
    }

    public void disableDrop() {
        for (int i = 0; i < imageCards.length; i++) {
            imageCards[i].setOnDragListener(null);
        }
    }
}
