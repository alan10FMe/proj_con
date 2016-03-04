package com.nojsoft.conquian.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.nojsoft.conquian.R;

/**
 * Created by alan on 3/2/16.
 */
public class CardView extends ImageView{
    private int id; //Card's position, between 1-40, since it is unique we use it as id
    private String type; // Type of card: Spade, gold, etc. Just the initial is used
    private  int numValue;// Numeric value of the card between 1 and 10
    private String group;// This is a String code to store the group to which this cards belongs,
                         // if any, this group is set just for cards on the table.
    private String nameCard;
    private Integer position;
    private Integer previousPosition;
    private String location;
    private String previousLocation;

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.custom_image_view);
        CharSequence s = a.getString(R.styleable.custom_image_view_name_card);
        if (s != null) {
            this.setNameCard(s.toString());
        }

        s = a.getString(R.styleable.custom_image_view_group);
        if (s != null) {
            this.setLocation(s.toString());
        }

        s = a.getString(R.styleable.custom_image_view_previous_group);
        if (s != null) {
            this.setPreviousLocation(s.toString());
        }

        s = a.getString(R.styleable.custom_image_view_position);
        if (s != null) {
            this.setPosition(new Integer(s.toString()).intValue());
        }else{
            this.setPosition(null);
        }

        s = a.getString(R.styleable.custom_image_view_previous_position);
        if (s != null) {
            this.setPreviousPosition(new Integer(s.toString()).intValue());
        }else{
            this.setPreviousPosition(null);
        }
        a.recycle();
    }

    public CardView (Context context, int numValue, String type, int id) {
        super(context, null);
        this.numValue = numValue;
        this.type = type;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPreviousPosition() {
        return previousPosition;
    }

    public void setPreviousPosition(Integer previousPosition) {
        this.previousPosition = previousPosition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String group) {
        this.location = group;
    }

    public String getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(String previousLocation) {
        this.previousLocation = previousLocation;
    }

    /**
     *
     * @param group Group of crads to which this one belongs on table
     */
    public void setGroup (String group){
        this.group = group;
    }

    /**
     *
     * @return the group to which this card belongs in the table
     */
    public String getGroup (){
        return group;
    }
    /**
     *
     * @return the position of the card, a number between 1-40
     */
    public int getId(){
        return this.id;
    }

    /**
     *
     * @param id Number between 1 and 40, position of the card in the deck
     */
    public void setId(int id){
        this.id = id;
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
        return this.type +this.numValue;
    }
}
