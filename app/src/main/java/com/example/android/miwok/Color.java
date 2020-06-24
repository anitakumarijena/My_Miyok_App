package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Enumeration;

public class Color extends AppCompatActivity {
     private  MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //create array of colors
        //Adding english words to the miyok word colors
        //Adding picture of the colors
        final ArrayList<Word> numberArray = new ArrayList<Word>();
        numberArray.add(new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        numberArray.add(new Word("green","chokokki" ,R.drawable.color_green,R.raw.color_green));
        numberArray.add(new Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        numberArray.add(new Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        numberArray.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
        numberArray.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        numberArray.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        numberArray.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter itemsAdapter=
                new WordAdapter(this,numberArray,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=numberArray.get(position);

                //Create and setup the{@link MediaPlayer} for the audio resource associated
                //with the current word
                mMediaPlayer = MediaPlayer.create(Color.this, word.getAudioResourceId());
                //Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}