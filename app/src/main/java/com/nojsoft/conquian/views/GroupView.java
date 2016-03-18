package com.nojsoft.conquian.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.nojsoft.conquian.constants.CardConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 3/10/16.
 */
public class GroupView extends LinearLayout {

    private List<CardView> cards = new ArrayList<CardView>();
    private int idGroup;
    private CardConstants.GameType gameType = CardConstants.GameType.NONE;

    public GroupView(Context context) {
        super(context, null);
        setOrientation(LinearLayout.HORIZONTAL);
        setWeightSum(1);
    }

    public GroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setGameType (CardConstants.GameType gameType){
        this.gameType = gameType;
    }

    public CardConstants.GameType getGameType () {
        return this.gameType;
    }

    public void setCard(CardView cardView) {
        addView(cardView);
        cards.add(cardView);
        if (cards.size() > 0) {
            setWeightSum(cards.size());
        } else {
            setWeightSum(1);
        }
    }

    public List<CardView> getCards() {
        return cards;
    }

    public void removeView(CardView cardView) {
        removeView(cardView);
        cards.remove(cardView);
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }
}
