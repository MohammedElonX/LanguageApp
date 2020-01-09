package com.example.language;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Words> wordsList = new ArrayList<Words>();
        wordsList.add(new Words("Where are you going?", "Minto wuksus", R.raw.phrase_where_are_you_going));
        wordsList.add(new Words("What is your name?", "Tinna oyakse na", R.raw.phrase_what_is_your_name));
        wordsList.add(new Words("My name is ..", "Oyasset", R.raw.phrase_my_name_is));
        wordsList.add(new Words("How are you feeling?", "Michaksas", R.raw.phrase_how_are_you_feeling));
        wordsList.add(new Words("I'm feeling good", "Kuchi ache", R.raw.phrase_im_feeling_good));
        wordsList.add(new Words("Are you coming?", "Aanas'sa", R.raw.phrase_where_are_you_going));
        wordsList.add(new Words("Yes, I'm coming", "Haa' aanam", R.raw.phrase_yes_im_coming));
        wordsList.add(new Words("I'm coming", "Aanam", R.raw.phrase_im_coming));
        wordsList.add(new Words("Let's go", "Yoowutis", R.raw.phrase_lets_go));
        wordsList.add(new Words("Come here", "Anni'nem", R.raw.phrase_come_here));

        WordAdapter words = new WordAdapter (this, wordsList, R.color.category_phrases);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);

        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Words word = wordsList.get(i);

                releaseMedia();

                mMediaPlayer = MediaPlayer.create(PhraseActivity.this, word.getAudioResourceId());
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

    private void releaseMedia(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
