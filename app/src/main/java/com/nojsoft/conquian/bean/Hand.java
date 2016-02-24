package com.nojsoft.conquian.bean;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nojsoft.conquian.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 11/02/16.
 */
public class Hand {
    private Card [] cards;//Array with cards, the player will get 8, the 9th card is the objective
    private ImageView[] imageCards;//Array with the image representation in the UI for each card
    private Context context;
    private int id;

    /**
     * Default constructor
     */
    public Hand(){}

    public void initializeHand(Context context, int id){
        this.context = context;
        this.id = id;
        LinearLayout linearHand = (LinearLayout)((Activity)context).findViewById(context.getResources().getIdentifier("hand_player_"+id, "id", context.getPackageName()));
        imageCards = new ImageView[8];
        for(int i=0; i < linearHand.getChildCount(); i++){
            if(linearHand.getChildAt(i) instanceof ImageView){
                imageCards[i] = (ImageView)linearHand.getChildAt(i);
            }
        }
    }

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


    public ImageView[] getImageCards() {
        return imageCards;
    }

    public void setImageCards(ImageView[] imageCards) {
        this.imageCards = imageCards;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
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

    public void transformCardsToViews(){
        for(int i = 0; i < cards.length; i++){
            imageCards[i].setImageResource(context.getResources().getIdentifier(cards[i].getName(), "drawable", context.getPackageName()));
            imageCards[i].setTag(cards[i].getName());
        }
    }

    public void enableDD() {
        if (context instanceof View.OnDragListener && context instanceof View.OnTouchListener) {
            for (int i = 0; i < imageCards.length; i++) {
                if(imageCards[i].getTag().equals(context.getString(R.string.background_tag))){
                    imageCards[i].setOnDragListener((View.OnDragListener) context);
                }else {
                    imageCards[i].setOnTouchListener((View.OnTouchListener) context);
                }
            }
        }
    }

    public void disableDD() {
        for (int i = 0; i < imageCards.length; i++) {
            imageCards[i].setOnTouchListener(null);
            imageCards[i].setOnDragListener(null);
        }
    }
}
