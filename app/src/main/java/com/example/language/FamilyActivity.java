package com.example.language;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Words> wordsList = new ArrayList<Words>();
        wordsList.add(new Words("Father", "Epa", R.drawable.family_father, R.raw.family_father));
        wordsList.add(new Words("Mother", "Eta", R.drawable.family_mother, R.raw.family_mother));
        wordsList.add(new Words("Son", "Angsi", R.drawable.family_son, R.raw.family_son));
        wordsList.add(new Words("Daughter", "Tune", R.drawable.family_daughter, R.raw.family_daughter));
        wordsList.add(new Words("Older brother", "Taachi", R.drawable.family_older_brother, R.raw.family_younger_brother));
        wordsList.add(new Words("Younger brother", "Chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        wordsList.add(new Words("Older sister", "Tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        wordsList.add(new Words("Younger sister", "Kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        wordsList.add(new Words("Grand Mother", "Ema", R.drawable.family_grandmother, R.raw.family_grandmother));
        wordsList.add(new Words("Grand Father", "Paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter words = new WordAdapter (this, wordsList, R.color.category_family);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);

        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Words word = wordsList.get(i);

                releaseMedia();

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMedia();
                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMedia();
    }

    private void releaseMedia() {
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
