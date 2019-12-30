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
        wordsList.add(new Words("Father", "Epa", R.mipmap.ic_launcher));
        wordsList.add(new Words("Mother", "Eta", R.mipmap.ic_launcher));
        wordsList.add(new Words("Son", "Angsi", R.mipmap.ic_launcher));
        wordsList.add(new Words("Daughter", "Tune", R.mipmap.ic_launcher));
        wordsList.add(new Words("Older brother", "Taachi", R.mipmap.ic_launcher));
        wordsList.add(new Words("Younger brother", "Chalitti", R.mipmap.ic_launcher));
        wordsList.add(new Words("Older sister", "Tete", R.mipmap.ic_launcher));
        wordsList.add(new Words("Younger sister", "Kolliti", R.mipmap.ic_launcher));
        wordsList.add(new Words("Grand Mother", "Ema", R.mipmap.ic_launcher));
        wordsList.add(new Words("Grand Father", "Paapa", R.mipmap.ic_launcher));

        WordAdapter words = new WordAdapter (this, wordsList);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
