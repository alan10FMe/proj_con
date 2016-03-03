package com.nojsoft.conquian.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

import com.nojsoft.conquian.R;

/**
 * Created by alan on 3/2/16.
 */
public class CardView extends ImageView{

    private String nameCard;
    private Integer position;
    private Integer previousPosition;
    private String group;
    private String previousGroup;

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.custom_image_view);
        CharSequence s = a.getString(R.styleable.custom_image_view_name_card);
        if (s != null) {
            this.setNameCard(s.toString());
        }

        s = a.getString(R.styleable.custom_image_view_group);
        if (s != null) {
            this.setGroup(s.toString());
        }

        s = a.getString(R.styleable.custom_image_view_previous_group);
        if (s != null) {
            this.setPreviousGroup(s.toString());
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPreviousGroup() {
        return previousGroup;
    }

    public void setPreviousGroup(String previousGroup) {
        this.previousGroup = previousGroup;
    }
}
