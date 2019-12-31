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
        wordsList.add(new Words("One", "Lutti", R.drawable.number_one));
        wordsList.add(new Words("Two", "Otiiko", R.drawable.number_two));
        wordsList.add(new Words("Three", "Tolookosu", R.drawable.number_three));
        wordsList.add(new Words("Four", "Oyyisa", R.drawable.number_four));
        wordsList.add(new Words("Five", "Massokka", R.drawable.number_five));
        wordsList.add(new Words("Six", "Temmokka", R.drawable.number_six));
        wordsList.add(new Words("Seven", "Kanekaku", R.drawable.number_seven));
        wordsList.add(new Words("Eight", "Kawinta", R.drawable.number_eight));
        wordsList.add(new Words("Nine", "Wo'e", R.drawable.number_nine));
        wordsList.add(new Words("Ten", "Na'aacha", R.drawable.number_ten));

        WordAdapter words = new WordAdapter (this, wordsList, R.color.category_numbers);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);
    }
}
