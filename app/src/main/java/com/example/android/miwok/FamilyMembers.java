package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

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

        //create array of familyMember
        //Adding all miwok family words with english words with image
        //Add pictures to the family member
         final ArrayList<Word> numberArray = new ArrayList<Word>();
        numberArray.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        numberArray.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        numberArray.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        numberArray.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        numberArray.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        numberArray.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        numberArray.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        numberArray.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        numberArray.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        numberArray.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));


        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter itemsAdapter=
                new WordAdapter(this,numberArray,R.color.category_family);

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
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                Word word=numberArray.get(position);
                //Create and setup the{@link MediaPlayer} for the audio resource associated
                //with the current word
                mMediaPlayer = MediaPlayer.create(FamilyMembers.this, word.getAudioResourceId());
                //Start the audio file
                mMediaPlayer.start();// No need to call prepare(); create() does that for you
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