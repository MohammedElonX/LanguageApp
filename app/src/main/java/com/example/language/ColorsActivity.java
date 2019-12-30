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
        wordsList.add(new Words("Red", "Wetetti", R.mipmap.ic_launcher));
        wordsList.add(new Words("Mustard yellow", "Chiwiita", R.mipmap.ic_launcher));
        wordsList.add(new Words("Dusty yellow", "Topiisa", R.mipmap.ic_launcher));
        wordsList.add(new Words("Green", "Chokokki", R.mipmap.ic_launcher));
        wordsList.add(new Words("Brown", "Takaakki", R.mipmap.ic_launcher));
        wordsList.add(new Words("Gray", "Topoppi", R.mipmap.ic_launcher));
        wordsList.add(new Words("Black", "Kululli", R.mipmap.ic_launcher));
        wordsList.add(new Words("White", "Kelelli", R.mipmap.ic_launcher));

        WordAdapter words = new WordAdapter (this, wordsList);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
