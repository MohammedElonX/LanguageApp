package com.example.language;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Words> {

    public WordAdapter(@NonNull Context context, @NonNull List<Words> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Inflate view if not being reused
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_activities, parent, false);
        }

        //Get object located at this position
        Words currentWord = getItem(position);

        //Find TextView and ID and set Text
        TextView miwokText = listItemView.findViewById(R.id.miwok_word);
        miwokText.setText(currentWord.getMiwok());

        TextView englishWord = listItemView.findViewById(R.id.english_word);
        englishWord.setText(currentWord.getEnglish());

        //Find ImageView and ID and set appropriate image
        ImageView icons = listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            icons.setImageResource(currentWord.getImageId());
            //Makes sure the view is visible
            icons.setVisibility(View.VISIBLE);
        } else {
            //If no image found, prevents image from showing on activity
            icons.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
