package com.nojsoft.conquian.bean;

/**
 * Created by jorge on 09/02/16.
 */
public class Card {

    private int position; //Card's position, between 1-40
    private String type; // Type of card: Spade, gold, etc. Just the initial is used
    private  int numValue;// Numeric value of the card between 1 and 10

    /**
     *
     * @return the position of the card, a number between 1-40
     */
    public int getPosition(){
        return this.position;
    }

    /**
     *
     * @param position Number between 1 and 40, position of the card in the deck
     */
    public void setPosition(int position){
        this.position = position;
    }

    /**
     *
     * @return Initial letter of the type: C = Club, G = Gold, M = Mazer and S = Spade
     */

    public String getType() {
        return type;
    }

    /**
     *
     * @param type String for the initial letter of the type, intended to be uses only by the
     *             init () method
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return int with the numeric value of the card, this is the value regarding its type
     *         not the whole deck; example: 5S (5 of spades) would return 5
     */
    public int getNumValue(){
        return this.numValue;
    }

    /**
     *
     * @param numValue numeric value regarding the type, intended to be used only by the init()
     *                 method,
     */
    public void setNumValue(int numValue){
        this.numValue = numValue;
    }

    /**
     *
     * @return String with the name of the card, this name should coincide with the image name;
     *         example: 3G is 3Gold, 10S is the King of Spades
     */
    public String getName(){
        return this.numValue+this.type;
    }

}
