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
        wordsList.add(new Words("Red", "Wetetti", R.drawable.color_red));
        wordsList.add(new Words("Mustard yellow", "Chiwiita", R.drawable.color_mustard_yellow));
        wordsList.add(new Words("Dusty yellow", "Topiisa", R.drawable.color_dusty_yellow));
        wordsList.add(new Words("Green", "Chokokki", R.drawable.color_green));
        wordsList.add(new Words("Brown", "Takaakki", R.drawable.color_brown));
        wordsList.add(new Words("Gray", "Topoppi", R.drawable.color_gray));
        wordsList.add(new Words("Black", "Kululli", R.drawable.color_black));
        wordsList.add(new Words("White", "Kelelli", R.drawable.color_white));

        WordAdapter words = new WordAdapter (this, wordsList, R.color.category_colors);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
