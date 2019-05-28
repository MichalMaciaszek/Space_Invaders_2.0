package com.example.spaceinvaders;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity implements View.OnClickListener{

    TextView myText;
    TextView myGOText;
    TextView myScore;
    Typeface myFont;
    TextView B1;
    TextView B2;
    TextView B3;
    Button save;
    Button tryagain;
    Button back;
    int score;
    int score2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gameover);

        Intent intent = getIntent();

        score = intent.getIntExtra("jeden", -1);
        score2 = intent.getIntExtra("trzy", -1);
       // Log.d("Tojeststring", "co" + a);
        // Set widgets
        save = (Button) findViewById(R.id.b_save);
        tryagain = (Button) findViewById(R.id.b_tryagain);
        back = (Button) findViewById(R.id.b_back);
        myText = (TextView) findViewById(R.id.ScoreText);
        myGOText = (TextView) findViewById(R.id.GameOverText);
        myScore = (TextView) findViewById(R.id.Score);
        B1 = (TextView) findViewById(R.id.b_save);
        B2 = (TextView) findViewById(R.id.b_tryagain);
        B3 = (TextView) findViewById(R.id.b_back);

        // Set fonts
        myFont = Typeface.createFromAsset(this.getAssets(), "Fonts/ca.ttf");
        myText.setTypeface(myFont);
        myGOText.setTypeface(myFont);
        myScore.setTypeface(myFont);
        B1.setTypeface(myFont);
        B2.setTypeface(myFont);
        B3.setTypeface(myFont);

        if(score == -1){
            myScore.setText(Integer.toString(score2));
        }
        if (score2 == -1) {
            myScore.setText(Integer.toString(score));
        }


        // Actions
        save.setOnClickListener(this);
        tryagain.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == android.R.id.home)
            this.finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == save)
        {
            Intent intent = new Intent(this, Nick.class);
            intent.putExtra("dwa", score);
            finish();
            startActivity(intent);
        }

        if(v == tryagain)
        {
            finish();
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
        }

        if(v == back)
        {
            finish();
            Intent intent = new Intent(this, Play.class);
            startActivity(intent);
        }
    }

}