package com.nojsoft.conquian.Util;

import android.content.Context;
import android.view.ViewGroup;

import com.nojsoft.conquian.R;
import com.nojsoft.conquian.bean.Player;
import com.nojsoft.conquian.views.CardView;
import com.nojsoft.conquian.views.GroupView;

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

    public static void displayGroups(GroupView groupView, Context context) {
        ViewGroup.LayoutParams params = groupView.getLayoutParams();
        params.height = 100;
        params.width = 100;
        groupView.setLayoutParams(params);
    }
}
