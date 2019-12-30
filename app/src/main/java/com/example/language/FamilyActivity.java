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
        wordsList.add(new Words("Father", "Epa", R.drawable.family_father));
        wordsList.add(new Words("Mother", "Eta", R.drawable.family_mother));
        wordsList.add(new Words("Son", "Angsi", R.drawable.family_son));
        wordsList.add(new Words("Daughter", "Tune", R.drawable.family_daughter));
        wordsList.add(new Words("Older brother", "Taachi", R.drawable.family_older_brother));
        wordsList.add(new Words("Younger brother", "Chalitti", R.drawable.family_younger_brother));
        wordsList.add(new Words("Older sister", "Tete", R.drawable.family_older_sister));
        wordsList.add(new Words("Younger sister", "Kolliti", R.drawable.family_younger_sister));
        wordsList.add(new Words("Grand Mother", "Ema", R.drawable.family_grandmother));
        wordsList.add(new Words("Grand Father", "Paapa", R.drawable.family_grandfather));

        WordAdapter words = new WordAdapter (this, wordsList);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
