package com.example.language;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the correct View (NumbersActivity)
        TextView numbers = findViewById(R.id.numbers);
        //Set OnClickListener to that view
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbers = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbers);
            }
        });

        //Find the correct View (NumbersActivity)
        TextView phrases = findViewById(R.id.phrases);
        //Set OnClickListener to that view
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrase = new Intent(MainActivity.this, PhraseActivity.class);
                startActivity(phrase);
            }
        });

        //Find the correct View (NumbersActivity)
        TextView family = findViewById(R.id.family);
        //Set OnClickListener to that view
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent family = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(family);
            }
        });

        //Find the correct View (NumbersActivity)
        TextView colors = findViewById(R.id.colors);
        //Set OnClickListener to that view
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colors = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colors);
            }
        });
    }

}
