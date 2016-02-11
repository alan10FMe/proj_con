package com.nojsoft.conquian;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;


public class BoardActivity extends AppCompatActivity {

    private ImageButton btnDeck;
    private ImageView imgCardPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        btnDeck = (ImageButton)findViewById(R.id.btn_deck);
        imgCardPlaying = (ImageView)findViewById(R.id.img_card_playing);
    }

}
