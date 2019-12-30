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
        wordsList.add(new Words("One", "Lutti", R.mipmap.ic_launcher));
        wordsList.add(new Words("Two", "Otiiko", R.mipmap.ic_launcher));
        wordsList.add(new Words("Three", "Tolookosu", R.mipmap.ic_launcher));
        wordsList.add(new Words("Four", "Oyyisa", R.mipmap.ic_launcher));
        wordsList.add(new Words("Five", "Massokka", R.mipmap.ic_launcher));
        wordsList.add(new Words("Six", "Temmokka", R.mipmap.ic_launcher));
        wordsList.add(new Words("Seven", "Kanekaku", R.mipmap.ic_launcher));
        wordsList.add(new Words("Eight", "Kawinta", R.mipmap.ic_launcher));
        wordsList.add(new Words("Nine", "Wo'e", R.mipmap.ic_launcher));
        wordsList.add(new Words("Ten", "Na'aacha", R.mipmap.ic_launcher));

        WordAdapter words = new WordAdapter (this, wordsList);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
