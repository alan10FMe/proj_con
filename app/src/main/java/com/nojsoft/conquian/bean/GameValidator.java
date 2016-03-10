package com.nojsoft.conquian.bean;

import android.widget.LinearLayout;

import com.nojsoft.conquian.views.CardView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jorge on 09/03/16.
 */
public class GameValidator {

    public boolean validateGroups (Table table){
        boolean hasChanged = false;
        LinearLayout [] layouts = table.getCards();
        CardView [] cards = convertLayoutsToViews(layouts);
        List <List<Integer>> cardGroups = getCardGroups(cards);
        //Validate if table contains at least 1 group with 3 cards
        if(cardGroups.size() > 0){
            //Checks if there are groups with the same numValue
            hasChanged = checkSameNumGroups(cards, cardGroups);
            //If there was a change check if there are cards without group remaining
            if(hasChanged) {
                cardGroups = getCardGroups(cards);
            }
            //If after the previous process there are still groups to check, validate straights
            if (cardGroups.size() > 0) {
                //Even if there are no Straights the previous changes, if any, must be reported
                hasChanged = hasChanged || checkStraightGroups(cards, cardGroups);
            }
        }
        return hasChanged;
    }

    public boolean validateCurrentCardUtility (Player player, CardView currentCard){
        boolean hasChanged = false;

        return hasChanged;
    }

    public boolean validateCardMatch (Table table, CardView card){
        boolean hasChanged = false;

        return hasChanged;
    }

    private CardView [] convertLayoutsToViews (LinearLayout [] layouts){
        CardView [] views = new CardView[9];
        for (int i = 0; i < layouts.length; i++) {
            if (layouts[i].getChildCount() > 0) {
                views [i] = (CardView) layouts[i].getChildAt(0);
            }
        }
        return views;
    }

    private List <List <Integer> > getCardGroups (CardView [] cardViews){
        List <List <Integer> > groups = new ArrayList<List <Integer> >();
        List <Integer> group = new ArrayList<Integer>();
        CardView cardView;

        for (int i = 0; i < cardViews.length; i++) {
            cardView = cardViews[i];
            if (cardView != null && cardView.getGroup() == null){
                group.add(i);
            } else if (group.size() >= 3) {
                groups.add(group);
                group = new ArrayList<Integer>();
            }
        }

        return groups;
    }

    private boolean checkSameNumGroups (CardView [] cards, List<List<Integer>> groups) {
        boolean hasGroups = false;

        return hasGroups;
    }

    private boolean checkStraightGroups (CardView [] cards, List<List<Integer>> groups) {
        boolean hasGroups = false;

        return hasGroups;
    }




}
