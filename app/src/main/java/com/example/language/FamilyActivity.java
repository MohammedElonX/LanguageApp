package com.example.language;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManger;

    private AudioManager.OnAudioFocusChangeListener mAudioFocusLIstener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if(i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }else if(i == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }else if(i == AudioManager.AUDIOFOCUS_LOSS){
                releaseMedia();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        mAudioManger = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

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

                int result = mAudioManger.requestAudioFocus(mAudioFocusLIstener, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMedia();
                        }
                    });
                }
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

            mAudioManger.abandonAudioFocus(mAudioFocusLIstener);
        }
    }
}
