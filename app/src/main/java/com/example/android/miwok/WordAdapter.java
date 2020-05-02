package com.example.android.miwok;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter  extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public  WordAdapter(Activity context, ArrayList<Word> words,int colorResourceId){

        super(context,0,words);
        mColorResourceId=colorResourceId;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Check if the existing view is being reused,otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.id.list,parent,false);
        }

        //Get the{@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        //Find the textView in the list_item.xml layout with the ID miwok_textView
        TextView miaowTextView =(TextView) listItemView.findViewById(R.id.miwok_textView);
        //Get the miaow translation from the current  Word object and ser this text on the view
        miaowTextView.setText(currentWord.getmMiaowTranslation());

        //Find the textView in the list_item.xml layout with the ID default_textView
        TextView defaultTextView =(TextView) listItemView.findViewById(R.id.default_textView);
        //Get the default translation from the current  Word object and ser this text on the view
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        ImageView imageView =(ImageView) listItemView.findViewById(R.id.img1);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getmImageResourceId());
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        View textContainer =listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}
