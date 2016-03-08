package com.nojsoft.conquian.Util;

import android.content.Context;

import com.nojsoft.conquian.R;
import com.nojsoft.conquian.views.CardView;

/**
 * Created by alan on 3/7/16.
 */
public class Utility {

    /**
     * Method to display the correct image for the card
     * @param context
     * @param cardView
     */
    public static void displayImageCard(Context context, CardView cardView) {
        cardView.setImageResource(context.getResources().getIdentifier(cardView.getType() + cardView.getNumValue(), "drawable", context.getPackageName()));
    }

    /**
     * Method to display the back of a card
     * @param context
     * @param cardView
     */
    public static void displayImageBack(CardView cardView) {
        cardView.setImageResource(R.drawable.backcard);
    }
}
