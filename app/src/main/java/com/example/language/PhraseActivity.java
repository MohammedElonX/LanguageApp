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
        wordsList.add(new Words("Coming Up Soon!", "I don't know!"));

        WordAdapter words = new WordAdapter (this, wordsList);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
