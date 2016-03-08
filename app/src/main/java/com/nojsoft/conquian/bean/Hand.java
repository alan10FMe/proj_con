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
    private CardView[] cards;//Array with cards, the player will get 8, the 9th card is the objective
    private Context context;
    private int id;
    private LinearLayout linearHand;

    /**
     * Default constructor
     */
    public Hand() {
    }

    public void initializeHand(Context context, int id, boolean isPlayer) {
        this.context = context;
        this.id = id;
        linearHand = (LinearLayout) ((Activity) context).findViewById(context.getResources().getIdentifier("hand_player_" + id, "id", context.getPackageName()));
        for (int i = 0; i < linearHand.getChildCount(); i++) {
            cards[i].setPosition(i);
            cards[i].setLocation(CardConstants.LOCATION_HAND);
            if (!isPlayer) {
                Utility.displayImageBack(cards[i]);
            }
            ((LinearLayout) linearHand.getChildAt(i)).addView(cards[i]);
        }
    }

    /**
     * @param cards Array of Card objects, the cards the user has in his/her hand
     */
    public void set(CardView[] cards) {
        this.cards = cards;
    }

    public LinearLayout getLinearHand() {
        return linearHand;
    }

    public void setLinearHand(LinearLayout linearHand) {
        this.linearHand = linearHand;
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
                for (CardView card : cards) {
                    if (card.getId() == id) {
                        droppedCards[position++] = card;
                    }
                }
            }

            if (position > 0) {
                for (CardView dropped : droppedCards) {
                    for (int i = 0; i < cards.length; i++) {
                        if (cards[i] == dropped)
                            cards[i] = null;
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
        CardView holder = cards[currentPos];
        cards[currentPos] = cards[futurePos];
        cards[futurePos] = holder;
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
            card = cards[i];
            if (card.getId() == id)
                position = i;
        }
        return position;
    }

    public void enableDrag() {
        if (context instanceof View.OnTouchListener) {
            for (int i = 0; i < linearHand.getChildCount(); i++) {
                if (linearHand.getChildAt(i) != null && linearHand.getChildAt(i) instanceof LinearLayout
                        && ((LinearLayout) linearHand.getChildAt(i)).getChildAt(0) != null) {
                    ((LinearLayout) linearHand.getChildAt(i)).getChildAt(0).setOnTouchListener((View.OnTouchListener) context);
                }
            }
        }
    }

    public void enableDrop() {
        if (context instanceof View.OnDragListener) {
            for (int i = 0; i < linearHand.getChildCount(); i++) {
                if (linearHand.getChildAt(i) != null && linearHand.getChildAt(i) instanceof LinearLayout
                        && ((LinearLayout) linearHand.getChildAt(i)).getChildAt(0) == null) {
                    linearHand.getChildAt(i).setOnDragListener((View.OnDragListener) context);
                }
            }
        }
    }

//
//    public void disableDrag() {
//        for (int i = 0; i < cards.length; i++) {
//            cards[i].setOnTouchListener(null);
//        }
//    }
//
//    public void disableDrop() {
//        for (int i = 0; i < cards.length; i++) {
//            cards[i].setOnDragListener(null);
//        }
//    }
}