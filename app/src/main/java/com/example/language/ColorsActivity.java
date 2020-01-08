package com.example.language;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Words> wordsList = new ArrayList<Words>();
        wordsList.add(new Words("Red", "Wetetti", R.drawable.color_red, R.raw.color_red));
        wordsList.add(new Words("Mustard yellow", "Chiwiita",
                R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        wordsList.add(new Words("Dusty yellow", "Topiisa",
                R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        wordsList.add(new Words("Green", "Chokokki", R.drawable.color_green, R.raw.color_green));
        wordsList.add(new Words("Brown", "Takaakki", R.drawable.color_brown, R.raw.color_brown));
        wordsList.add(new Words("Gray", "Topoppi", R.drawable.color_gray, R.raw.color_gray));
        wordsList.add(new Words("Black", "Kululli", R.drawable.color_black, R.raw.color_black));
        wordsList.add(new Words("White", "Kelelli", R.drawable.color_white, R.raw.color_white));

        WordAdapter words = new WordAdapter (this, wordsList, R.color.category_colors);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);

        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Words word = wordsList.get(i);

                releaseMedia();

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
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

    private void releaseMedia(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
