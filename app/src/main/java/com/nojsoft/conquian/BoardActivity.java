package com.nojsoft.conquian;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nojsoft.conquian.bean.Card;
import com.nojsoft.conquian.bean.Deck;
import com.nojsoft.conquian.bean.Hand;
import com.nojsoft.conquian.bean.Player;
import com.nojsoft.conquian.bean.Table;
import com.nojsoft.conquian.exception.NoMoreCardsException;


public class BoardActivity extends AppCompatActivity {

    private ImageButton btnDeck;
    private ImageView imgCardPlaying;
    private Player[] players;
    int numberPlayers = 3;
    private Deck deck;
    private Card actualCard;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        context = this;
        deck = new Deck();
        btnDeck = (ImageButton)findViewById(R.id.btn_deck);
        btnDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeNextCard();
            }
        });
        imgCardPlaying = (ImageView)findViewById(R.id.img_card_playing);
        initializePlayers();
        displayCards();
    }

    /**
     * Method to get the next card from the deck
     */
    private void takeNextCard(){
        try{
            actualCard = deck.getNextCard();
        }catch(NoMoreCardsException ex){
            //TODO end of game
        }
    }

    /**
     * Method to initialize array with players
     */
    private void initializePlayers(){
        players = new Player[numberPlayers];
        Player player = null;
        for(int i = 0; i < numberPlayers; i++){
           players[i] = initializePlayer(i);
        }
    }

    /**
     * Method to initialize each player, creating its hand and table
     * @param id playerID
     * @return player
     */
    private Player initializePlayer(int id){
        Player player = new Player();

        Hand hand = deck.getHand();
        hand.setContext(context);
        LinearLayout linearHand = (LinearLayout)findViewById(getResources().getIdentifier("hand_player_"+id, "id", getPackageName()));
        ImageView[] imagesArray = new ImageView[8];
        for(int i=0; i < linearHand.getChildCount(); i++){
            if(linearHand.getChildAt(i) instanceof ImageView){
                imagesArray[i] = (ImageView)linearHand.getChildAt(i);
            }
        }
        hand.setImageCards(imagesArray);
        player.setHand(hand);

        Table table = new Table();
        table.setContext(context);
        linearHand = (LinearLayout)findViewById(getResources().getIdentifier("game_player_" + id, "id", getPackageName()));
        imagesArray = new ImageView[9];
        for(int i=0; i < linearHand.getChildCount(); i++){
            if(linearHand.getChildAt(i) instanceof ImageView){
                imagesArray[i] = (ImageView)linearHand.getChildAt(i);
            }
        }
        table.setImageCards(imagesArray);
        player.setTable(table);

        return player;
    }


    /**
     * Method to display in the UI the cards
     */
    private void displayCards(){

        //THIS IS JUST FOR TEST that is displaying the cards in the correct position and player

        for(int i =0; i < players[0].getHand().getImageCards().length; i++){
            players[0].getHand().getImageCards()[i].setImageDrawable(getResources().getDrawable(R.drawable.s3));
        }
        for(int i =0; i < players[0].getTable().getImageCards().length; i++){
            players[0].getTable().getImageCards()[i].setImageDrawable(getResources().getDrawable(R.drawable.s3));
        }
        for(int i =0; i < players[1].getHand().getImageCards().length; i++){
            players[1].getHand().getImageCards()[i].setImageDrawable(getResources().getDrawable(R.drawable.s3));
        }
        for(int i =0; i < players[1].getTable().getImageCards().length; i++){
            players[1].getTable().getImageCards()[i].setImageDrawable(getResources().getDrawable(R.drawable.s3));
        }
        for(int i =0; i < players[2].getHand().getImageCards().length; i++){
            players[2].getHand().getImageCards()[i].setImageDrawable(getResources().getDrawable(R.drawable.s3));
        }
        for(int i =0; i < players[2].getTable().getImageCards().length; i++){
            players[2].getTable().getImageCards()[i].setImageDrawable(getResources().getDrawable(R.drawable.s3));
        }

    }

}
