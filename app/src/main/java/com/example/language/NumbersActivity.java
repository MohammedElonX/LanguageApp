package com.example.language;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RemoteControlClient;
import android.media.RemoteController;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
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

        //Set up manager to request audio focus
        mAudioManger = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Words> wordsList = new ArrayList<Words>();
        wordsList.add(new Words("One", "Lutti", R.drawable.number_one, R.raw.number_one));
        wordsList.add(new Words("Two", "Otiiko", R.drawable.number_two, R.raw.number_two));
        wordsList.add(new Words("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        wordsList.add(new Words("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
        wordsList.add(new Words("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        wordsList.add(new Words("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
        wordsList.add(new Words("Seven", "Kanekaku", R.drawable.number_seven, R.raw.number_seven));
        wordsList.add(new Words("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        wordsList.add(new Words("Nine", "Wo'e", R.drawable.number_nine, R.raw.number_nine));
        wordsList.add(new Words("Ten", "Na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter words = new WordAdapter (this, wordsList, R.color.category_numbers);

        ListView lists = (ListView) findViewById(R.id.list);

        lists.setAdapter(words);

        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Words word = wordsList.get(i);

                //Releases player of any media resource
                releaseMedia();

                //Request audio focus
                int result = mAudioManger.requestAudioFocus(mAudioFocusLIstener, AudioManager.STREAM_MUSIC ,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    //We have audio focus now
                    //Plays the clicked media player
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
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

    private void releaseMedia(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();

            //Sets mediaplayer to null
            mMediaPlayer = null;

            mAudioManger.abandonAudioFocus(mAudioFocusLIstener);
        }
    }
}
