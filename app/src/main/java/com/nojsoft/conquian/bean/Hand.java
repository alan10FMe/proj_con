package com.nojsoft.conquian.bean;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.nojsoft.conquian.Util.Utility;
import com.nojsoft.conquian.constants.CardConstants;
import com.nojsoft.conquian.views.CardView;

/**
 * Created by jorge on 11/02/16.
 */
public class Hand {
    private LinearLayout[] cards = new LinearLayout[8];//Array with cards, the player will get 8, the 9th card is the objective
    private CardView[] cardsView;
    private Context context;
    private int id;

    /**
     * Default constructor
     */
    public Hand() {
    }

    public LinearLayout[] getCards() {
        return cards;
    }

    public void setCards(CardView[] cardsView) {
        this.cardsView = cardsView;
    }

    public void initializeHand(Context context, int id, boolean isPlayer) {
        this.context = context;
        this.id = id;
        LinearLayout linearHand = (LinearLayout) ((Activity) context).findViewById(context.getResources().getIdentifier("hand_player_" + id, "id", context.getPackageName()));
        for (int i = 0; i < linearHand.getChildCount(); i++) {
            cards[i] = (LinearLayout) linearHand.getChildAt(i);
            cardsView[i].setLocation(CardConstants.LOCATION_HAND);
            if (!isPlayer) {
                Utility.displayImageBack(cardsView[i]);
            }
            cards[i].addView(cardsView[i]);
        }
        cardsView = null;
    }


    /**
     * return the cards that the user wants to drop from his/her hand, and removes them from hand
     *
     * @param ids this method receives the position of the cards to be dropped, this is the
     *            position of the card in the deck after shuffling it, since this value is
     *            unique it can be used as identifier.
     * @return null if the size of the position's list is 0 or no coincidences were found
     */
    public CardView[] dropCard(int[] ids) {
        CardView[] droppedCards = null;
        int position = 0;
        if (ids != null && ids.length > 0) {
            droppedCards = new CardView[ids.length];
            for (int id : ids) {
                for (LinearLayout card : cards) {
                    if (card.getChildAt(0) != null && ((CardView) card.getChildAt(0)).getIdCard() == id) {
                        droppedCards[position++] = (CardView) card.getChildAt(0);
                    }
                }
            }

            if (position > 0) {
                for (CardView dropped : droppedCards) {
                    for (int i = 0; i < cards.length; i++) {
                        if (cards[i].getChildAt(0) == dropped) {
                            cards[i].removeAllViews();
                            break;
                        }
                    }
                }
            } else {
                droppedCards = null;
            }
        }
        return droppedCards;
    }

    /**
     * Changes the position of two cards, useful if the user wants to re organize his/her cards
     *
     * @param currentPos current position of the card in the hand (array)
     * @param futurePos  the desired position of the card
     */
    public void changePosition(int currentPos, int futurePos) {
        boolean changed = false;
        CardView holder = (CardView) cards[currentPos].getChildAt(0);
        cards[currentPos].removeAllViews();
        cards[currentPos].addView(cards[futurePos].getChildAt(0));
        cards[futurePos].removeAllViews();
        cards[futurePos].addView(holder);
    }

    /**
     * returns the position of the card in the hand
     *
     * @param id the card's id in which we are interested
     * @return the position in hand (array)
     */
    public int getHandPosition(int id) {
        int position = -1;
        CardView card;
        for (int i = 0; i < cards.length; i++) {
            card = (CardView) cards[i].getChildAt(0);
            if (card != null && card.getIdCard() == id) {
                position = i;
            }
        }
        return position;
    }

    public void enableDrag() {
        if (context instanceof View.OnTouchListener) {
            for (int i = 0; i < cards.length; i++) {
                if (cards[i].getChildCount() > 0) {
                    cards[i].getChildAt(0).setOnTouchListener((View.OnTouchListener) context);
                }
            }
        }
    }

    public void enableDrop() {
        if (context instanceof View.OnDragListener) {
            for (int i = 0; i < cards.length; i++) {
                if (cards[i].getChildCount() == 0) {
                    cards[i].setOnDragListener((View.OnDragListener) context);
                }
            }
        }
    }

    public void disableDrag() {
        for (int i = 0; i < cards.length; i++) {
            cards[i].getChildAt(0).setOnTouchListener(null);
        }
    }

    public void disableDrop() {
        for (int i = 0; i < cards.length; i++) {
            cards[i].setOnDragListener(null);
        }
    }
}