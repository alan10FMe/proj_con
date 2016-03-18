package com.nojsoft.conquian.bean;

import android.view.ViewGroup;

import com.nojsoft.conquian.constants.CardConstants;
import com.nojsoft.conquian.views.CardView;
import com.nojsoft.conquian.views.GroupView;

import java.security.acl.Group;

/**
 * Created by jorge on 09/03/16.
 */
public class GameValidator {

    public static boolean validateGroup (GroupView group, CardView currentCard){
        boolean isValid = false;
        CardView previousCard;

        if (group.getChildCount() <= 1){
            group.setGameType(CardConstants.GameType.NONE);
            return true;//first card so it's correct no matter what
        }

        if (group.getChildCount() >= 1){
            previousCard = (CardView) group.getChildAt(group.getChildCount()-1);
            if (currentCard.getNumValue() == previousCard.getNumValue()) {
                if ( group.getGameType() == CardConstants.GameType.NONE) {
                    group.setGameType(CardConstants.GameType.SAME_KIND);
                    return true;
                }
                if ( group.getGameType() == CardConstants.GameType.SAME_KIND ){
                    return true;
                }
            }
            if (currentCard.getType().equals(previousCard.getType())) {
                if ( Math.abs( currentCard.getNumValue() - currentCard.getNumValue()) == 1) {
                    if ( group.getGameType() == CardConstants.GameType.NONE) {
                        group.setGameType(CardConstants.GameType.STRAIGHT);
                        return true;
                    }
                    if ( group.getGameType() == CardConstants.GameType.STRAIGHT ){
                        return true;
                    }
                }
            }
        }
        return isValid;
    }

    public static boolean validateGame (Table table){
        int totalCards = 0;
        boolean isValid = true;
        GroupView groups [] = table.getGroups();
        for (GroupView group : groups) {
            if (group != null){
                totalCards += group.getChildCount();
                isValid = isValid && (group.getChildCount() >= 3);
            }
        }
        return (totalCards == 9) && isValid;
    }

}
