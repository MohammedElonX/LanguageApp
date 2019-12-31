package com.example.language;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Words> wordsList = new ArrayList<Words>();
        wordsList.add(new Words("Where are you going?", "Minto wuksus"));
        wordsList.add(new Words("What is your name?", "Tinna oyakse na"));
        wordsList.add(new Words("My name is ..", "Oyasset"));
        wordsList.add(new Words("How are you feeling?", "Michaksas"));
        wordsList.add(new Words("I'm feeling good", "Kuchi ache"));
        wordsList.add(new Words("Are you coming?", "Aanas'sa"));
        wordsList.add(new Words("Yes, I'm coming", "Haa' aanam"));
        wordsList.add(new Words("I'm coming", "Aanam"));
        wordsList.add(new Words("Let's go", "Yoowutis"));
        wordsList.add(new Words("Come here", "Anni'nem"));

        WordAdapter words = new WordAdapter (this, wordsList, R.color.category_phrases);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
