package com.nojsoft.conquian.bean;

import android.widget.LinearLayout;
import com.nojsoft.conquian.views.CardView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 09/03/16.
 */
public class GameValidator {

    public static boolean validateGroups (Table table){
        boolean hasChanged = false;
//        LinearLayout [] layouts = table.getCards();
//        List <List<Integer>> cardGroups = getCardGroups(layouts); //TODO: se puede hacer sin generar otro lista? mismo caso que arriba\
//        //Validate if table contains at least 1 group with 3 cards
//        if(cardGroups.size() > 0){
//            //Checks if there are groups with the same numValue
//            hasChanged = checkSameNumGroups(layouts, cardGroups);
//            //If there was a change check if there are cards without group remaining
//            if(hasChanged) {
//                cardGroups = getCardGroups(layouts);
//            }
//            //If after the previous process there are still groups to check, validate straights
//            if (cardGroups.size() > 0) {
//                //Even if there are no Straights the previous changes, if any, must be reported
//                hasChanged = hasChanged || checkStraightGroups(layouts, cardGroups);
//            }
//        }
        return hasChanged;
    }

    public static boolean validateCurrentCardUtility (Player player, CardView currentCard){
        boolean hasChanged = false;

        return hasChanged;
    }

    public static boolean validateCardMatch (Table table, CardView card){
        boolean hasChanged = false;

        return hasChanged;
    }


    private static List <List <Integer> > getCardGroups (LinearLayout [] layouts){
        List <List <Integer> > groups = new ArrayList<List <Integer> >();
        List <Integer> group = new ArrayList<Integer>();
        LinearLayout linearLayout;

        for (int i = 0; i < layouts.length; i++) {
            linearLayout = layouts[i];
            if (linearLayout.getChildCount() > 0
                    && ( (CardView) linearLayout.getChildAt(0)).getGroup() != null){
                group.add(i);
            } else if (group.size() >= 3) {
                groups.add(group);
                group = new ArrayList<Integer>();
            }
        }

        return groups;
    }

    private static boolean checkSameNumGroups (LinearLayout [] layouts,
                                               List<List<Integer>> groups) {
        boolean hasGroups = false;

        return hasGroups;
    }

    private static boolean checkStraightGroups (LinearLayout [] layouts,
                                                List<List<Integer>> groups) {
        boolean hasGroups = false;

        return hasGroups;
    }

}
