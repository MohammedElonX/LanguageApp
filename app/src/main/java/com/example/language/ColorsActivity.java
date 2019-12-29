package com.example.language;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Words> wordsList = new ArrayList<Words>();
        wordsList.add(new Words("Red", "Wetetti"));
        wordsList.add(new Words("Mustard yellow", "Chiwiita"));
        wordsList.add(new Words("Dusty yellow", "Topiisa"));
        wordsList.add(new Words("Green", "Chokokki"));
        wordsList.add(new Words("Brown", "Takaakki"));
        wordsList.add(new Words("Gray", "Topoppi"));
        wordsList.add(new Words("Black", "Kululli"));
        wordsList.add(new Words("White", "Kelelli"));

        WordAdapter words = new WordAdapter (this, wordsList);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
