package com.nojsoft.conquian.bean;

import android.view.ViewGroup;
import com.nojsoft.conquian.views.CardView;

/**
 * Created by jorge on 09/03/16.
 */
public class GameValidator {

    public static boolean validateGroup (ViewGroup group){
        boolean isValid = false;
        String flag = "sn";
        CardView currentCard;
        CardView previousCard;
        if (group.getChildCount() <= 1){
            //reset flag
            return true;//first card so it's correct no matter what
        }

        if (group.getChildCount() == 2){
            //Define type of group and set it to the flag
            currentCard = (CardView) group.getChildAt(1);
            previousCard = (CardView) group.getChildAt(0);
            if (currentCard.getNumValue() == previousCard.getNumValue()) {
                //set flag as same number
                return true;
            }
            if (currentCard.getType().equals(previousCard.getType())) {
                if ( Math.abs( currentCard.getNumValue() - currentCard.getNumValue()) == 1) {
                    //set flag as straight
                    return true;
                }
            }
        }

        if (group.getChildCount() > 2) {
            //getFlag
            currentCard = (CardView) group.getChildAt(group.getChildCount()-1);
            previousCard = (CardView) group.getChildAt(group.getChildCount()-2);
            if (flag.equals("sn")){//if group of the same number
                if (currentCard.getNumValue() == previousCard.getNumValue()) {
                    //set flag as same number
                    return true;
                }
            } else {
                if (currentCard.getType().equals(previousCard.getType())) {
                    if ( Math.abs( currentCard.getNumValue() - currentCard.getNumValue()) == 1) {
                        //set flag as straight
                        return true;
                    }
                }
            }
        }

        return isValid;
    }

    public static boolean validateGame (Table table){
        boolean isValid = false;

        return isValid;
    }

}
