package com.nojsoft.conquian.bean;

import android.widget.LinearLayout;

import com.nojsoft.conquian.views.CardView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 09/03/16.
 */
public class GameValidator {

    public boolean validateGroups (Table table){
        boolean hasChanged = false;
        LinearLayout [] cards = table.getCards();
        //Validate if table contains at least 3 consecutive cards
        if(validateMinimumConsecutiveCards(cards)){
            //Checks if there are groups with the same numValue

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

    private boolean validateMinimumConsecutiveCards (LinearLayout [] layouts){
        boolean hasEnoughConsecutiveCards = false;
        int j = 0;

        for(LinearLayout linearLayout : layouts) {
            if (linearLayout.getChildCount() > 0
                    && ((CardView)linearLayout.getChildAt(0)).getGroup() != null){
                j++;
            } else {
                j = 0;
            }
            if(j >= 3){
                return true;
            }
        }

        return hasEnoughConsecutiveCards;
    }

    private boolean checkSameNumGroups (LinearLayout [] layouts) {
        boolean hasGroups = false;
        List <Integer> positions = getCardsPositions(layouts);

        return hasGroups;
    }

    private List <Integer> getCardsPositions (LinearLayout [] layouts){
        List <Integer> positions = new ArrayList <Integer> ();
        for (int i = 0; i < layouts.length; i++){
            LinearLayout linearLayout = layouts [i];
            if(linearLayout.getChildCount() > 0
                    && ((CardView)linearLayout.getChildAt(0)).getGroup() != null){
                positions.add(i);
            }
        }
        return positions;
    }
}
