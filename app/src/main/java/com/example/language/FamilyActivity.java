package com.example.language;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Words> wordsList = new ArrayList<Words>();
        wordsList.add(new Words("Father", "Epa"));
        wordsList.add(new Words("Mother", "Eta"));
        wordsList.add(new Words("Son", "Angsi"));
        wordsList.add(new Words("Daughter", "Tune"));
        wordsList.add(new Words("Older brother", "Taachi"));
        wordsList.add(new Words("Younger brother", "Chalitti"));
        wordsList.add(new Words("Older sister", "Tete"));
        wordsList.add(new Words("Younger sister", "Kolliti"));
        wordsList.add(new Words("Grand Mother", "Ema"));
        wordsList.add(new Words("Grand Father", "Paapa"));

        WordAdapter words = new WordAdapter (this, wordsList);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
