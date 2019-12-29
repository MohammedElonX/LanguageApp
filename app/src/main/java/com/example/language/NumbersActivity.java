package com.example.language;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Words> wordsList = new ArrayList<Words>();
        wordsList.add(new Words("One", "Lutti"));
        wordsList.add(new Words("Two", "Otiiko"));
        wordsList.add(new Words("Three", "Tolookosu"));
        wordsList.add(new Words("Four", "Oyyisa"));
        wordsList.add(new Words("Five", "Massokka"));
        wordsList.add(new Words("Six", "Temmokka"));
        wordsList.add(new Words("Seven", "Kanekaku"));
        wordsList.add(new Words("Eight", "Kawinta"));
        wordsList.add(new Words("Nine", "Wo'e"));
        wordsList.add(new Words("Ten", "Na'aacha"));

        WordAdapter words = new WordAdapter (this, wordsList);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
