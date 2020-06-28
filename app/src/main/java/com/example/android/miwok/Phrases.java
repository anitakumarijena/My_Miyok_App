package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    /** Handles playback of all the sound files */
     private  MediaPlayer mMediaPlayer;
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create array of phrase
        final ArrayList<Word> numberArray = new ArrayList<Word>();
        numberArray.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        numberArray.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        numberArray.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        numberArray.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        numberArray.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        numberArray.add(new Word("Yes, I’m coming","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        numberArray.add(new Word("I'm coming","әәnәm",R.raw.phrase_im_coming));
        numberArray.add(new Word("Let's go","yoowutis",R.raw.phrase_lets_go));
        numberArray.add(new Word("Come here","әnni'nem",R.raw.phrase_come_here));


        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter itemsAdapter=
                new WordAdapter(this,numberArray,R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                Word word=numberArray.get(position);

                //Create and setup the{@link MediaPlayer} for the audio resource associated
                //with the current word
                mMediaPlayer = MediaPlayer.create(Phrases.this, word.getAudioResourceId());
                //Start the audio file
                mMediaPlayer.start(); // No need to call prepare(); create() does that for you
                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
