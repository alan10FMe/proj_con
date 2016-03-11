package com.nojsoft.conquian.bean;

/**
 * Created by alan on 2/15/16.
 */
public class Player {

    private int id;
    private Hand hand;
    private Table table;
    private boolean isPlayer;

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

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setIsPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }

    public void enableDD() {
        this.hand.enableDrag();
        this.hand.enableDrop();
        this.table.enableDrop();
        this.table.enableDrag();
    }

    public void disableDD() {
        this.hand.disableDrag();
        this.table.disableDrop();
        this.table.disableDrag();
        this.hand.disableDrop();
    }
}
