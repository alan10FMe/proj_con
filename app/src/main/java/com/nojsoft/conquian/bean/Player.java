package com.nojsoft.conquian.bean;

/**
 * Created by alan on 2/15/16.
 */
public class Player {

    private int id;
    private Hand hand;
    private Table table;
    private boolean isComputer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setIsComputer(boolean isComputer) {
        this.isComputer = isComputer;
    }
}
