package com.nojsoft.conquian.bean;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.nojsoft.conquian.views.GroupView;

/**
 * Created by jorge on 11/02/16.
 */
public class Table {

    private GroupView[] groups = new GroupView[3];//Array with cards, the player can have up to 9 cards
    private Context context;
    private int id;


    private Table() {
    }

    public Table(Context context, int id) {
        this.context = context;
        this.id = id;
        LinearLayout linearTable = (LinearLayout) (((Activity) context).findViewById(context.getResources().getIdentifier("table_player_" + id, "id", context.getPackageName())));
        for (int i = 0; i < linearTable.getChildCount(); i++) {
            groups[i] = (GroupView) linearTable.getChildAt(i);
            groups[i].setIdGroup(id);
        }
    }

    public GroupView[] getGroups() {
        return groups;
    }

    public void setGroups(GroupView[] groups) {
        this.groups = groups;
    }

//    /**
//     * Set a card in a given position on the table, the position must be available (empty)
//     *
//     * @param card          the Card object that we want to set
//     * @param tablePosition the position to set the card
//     * @return true if the card was set, false if the place was not empty
//     */
//    public boolean setCard(CardView card, int tablePosition) {
//        boolean flag = false;
//        if (cards[tablePosition].getChildAt(0) != null) {
//            cards[tablePosition].addView(card);
//            flag = true;
//        }
//        return flag;
//    }
//
//    /**
//     * Changes the position of two cards, useful if the user wants to re organize his/her cards
//     *
//     * @param currentPos current position of the card in the hand (array)
//     * @param futurePos  the desired position of the card
//     */
//    public void changePosition(int currentPos, int futurePos) {
//        boolean changed = false;
//        CardView holder = (CardView) cards[currentPos].getChildAt(0);
//        cards[currentPos].removeAllViews();
//        cards[currentPos].addView(cards[futurePos].getChildAt(0));
//        cards[futurePos].removeAllViews();
//        cards[futurePos].addView(holder);
//    }

    //    /**
//     * returns the position of the card in the table
//     *
//     * @param id the card's id in which we are interested
//     * @return the position in hand (array)
//     */
//    public int getTablePosition(int id) {
//        int position = -1;
//        CardView card;
//        for (int i = 0; i < cards.length; i++) {
//            card = (CardView) cards[i].getChildAt(0);
//            if (card != null && card.getIdCard() == id) {
//                position = i;
//            }
//        }
//        return position;
//    }
//
//
    public void enableDrag() {
        if (context instanceof View.OnTouchListener) {
            for (int i = 0; i < groups.length; i++) {
                if (groups[i].getChildCount() > 0) {
                    for (int j = 0; j < groups[i].getChildCount(); j++) {
                        groups[i].getChildAt(j).setOnTouchListener((View.OnTouchListener) context);
                    }
                }
            }
        }
    }

    public void enableDrop() {
        if (context instanceof View.OnDragListener) {
            for (int i = 0; i < groups.length; i++) {
                if (groups[i].getChildCount() == 0) {
                    groups[i].setOnDragListener((View.OnDragListener) context);
                }
            }
        }
    }

    public void disableDrag() {
        if (context instanceof View.OnTouchListener) {
            for (int i = 0; i < groups.length; i++) {
                if (groups[i].getChildCount() > 0) {
                    for (int j = 0; j < groups[i].getChildCount(); j++) {
                        groups[i].getChildAt(j).setOnTouchListener(null);
                    }
                }
            }
        }
    }

    public void disableDrop() {
        for (int i = 0; i < groups.length; i++) {
            groups[i].setOnDragListener(null);
        }
    }
}
