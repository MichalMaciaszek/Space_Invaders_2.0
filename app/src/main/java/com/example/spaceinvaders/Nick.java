package com.example.spaceinvaders;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nick extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    Button savescore;
    EditText edittextnick;
    TextView myView;
    TextView B1;
    Typeface myFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        // Set widgets
        savescore = (Button) findViewById(R.id.buttonSave);
        B1 = (TextView) findViewById(R.id.buttonSave);
        myView = (TextView) findViewById(R.id.TypeNick);
        edittextnick = (EditText) findViewById(R.id.editTextNick);

        // Set fonts
        myFont = Typeface.createFromAsset(this.getAssets(), "Fonts/ca.ttf");
        myView.setTypeface(myFont);
        B1.setTypeface(myFont);

        // Actions
        savescore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveScore();
            }
        });
    }

    public void saveScore() {
        String nick = edittextnick.getText().toString().trim();
        Integer score = 134;

        if (!TextUtils.isEmpty(nick)) {
            User u = new User(nick, score);
            String id = myRef.push().getKey();
            myRef.child(id).setValue(u);
            Toast.makeText(this, "Score saved!", Toast.LENGTH_SHORT).show();
            finish();
            Intent intent = new Intent(this, GameOver.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please enter a nick", Toast.LENGTH_LONG).show();
        }
    }
}