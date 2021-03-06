package com.nojsoft.conquian;

import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.nojsoft.conquian.Util.Utility;
import com.nojsoft.conquian.bean.Deck;
import com.nojsoft.conquian.bean.GameValidator;
import com.nojsoft.conquian.bean.Hand;
import com.nojsoft.conquian.bean.Player;
import com.nojsoft.conquian.bean.Table;
import com.nojsoft.conquian.constants.CardConstants;
import com.nojsoft.conquian.exception.NoMoreCardsException;
import com.nojsoft.conquian.views.CardView;
import com.nojsoft.conquian.views.GroupView;


public class BoardActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener, View.OnClickListener {

    int numberPlayers = 3;
    int myPlayerId = 0;
    private ImageButton btnDeck;
    private LinearLayout cardPlaying;
    private Player[] players;
    private Deck deck;
    private Context context;
    private GameValidator gameValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        context = this;
        deck = new Deck(context);
        btnDeck = (ImageButton) findViewById(R.id.btn_deck);
        cardPlaying = (LinearLayout) findViewById(R.id.linear_card_playing);
        gameValidator = new GameValidator();
        initializePlayers();
        startTurnPlayer();
    }

    /**
     * Method to initialize array with players
     */
    private void initializePlayers() {
        players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            players[i] = initializePlayer(i);
        }
    }

    /**
     * Method to initialize each player, creating its hand and table
     *
     * @param id playerID
     * @return player
     */
    private Player initializePlayer(int id) {
        Player player = new Player();
        if (id == myPlayerId) {
            player.setIsPlayer(true);
        } else {
            player.setIsPlayer(false);
        }
        player.setTable(new Table(context, id));
        Hand hand = deck.getHand();
        hand.initializeHand(context, id, player.isPlayer());
        player.setHand(hand);

        return player;
    }

    /**
     * Method to start turn for the player
     */
    private void startTurnPlayer() {
        btnDeck.setOnClickListener(this);
        players[myPlayerId].enableDD();
    }

    /**
     * Method to get the next card from the deck
     */
    private void takeNextCard() {
        try {
            CardView cardView = deck.getNextCard();
            cardView.setLocation(CardConstants.LOCATION_ACTUAL);
            cardPlaying.addView(cardView);
            btnDeck.setOnClickListener(null);
        } catch (NoMoreCardsException ex) {
            Log.e("Error", "No more cards");
            //TODO end of game
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_deck: {
                takeNextCard();
                break;
            }
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);


//            if(view.getTag().equals(getString(R.string.tag_game))) {
//                Toast.makeText(this, "GAME" , Toast.LENGTH_SHORT).show();
//            } else if(view.getTag().equals(getString(R.string.tag_hand))) {
//                Toast.makeText(this, "HAND" , Toast.LENGTH_SHORT).show();
//            } else if(view.getTag().equals(getString(R.string.tag_board))) {
//                Toast.makeText(this, "BOARD" , Toast.LENGTH_SHORT).show();
//            }
            //view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        Drawable enterShape = getResources().getDrawable(R.drawable.background_active);
        Drawable normalShape = getResources().getDrawable(R.drawable.background);

        int action = event.getAction();
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                v.setBackgroundDrawable(enterShape);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                v.setBackgroundDrawable(normalShape);
                break;
            case DragEvent.ACTION_DROP:
                View view = (View) event.getLocalState();
                if (GameValidator.validateGroup((GroupView)v, (CardView)view)) {
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    owner.setOnDragListener(this);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    container.setBackgroundDrawable(normalShape);
                    Utility.displayGroups((GroupView)container,context);
                    view.setVisibility(View.VISIBLE);
                }
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                v.setBackgroundDrawable(normalShape);
            default:
                break;
        }
        return true;
    }


}
