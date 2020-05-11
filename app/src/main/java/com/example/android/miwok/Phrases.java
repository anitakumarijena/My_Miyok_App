package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create array of phrase
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?","minto wuksus"));
        phraseArray.add(new Word("What is your name?","tinnә oyaase'nә"));
        phraseArray.add(new Word("My name is...","oyaaset..."));
        phraseArray.add(new Word("How are you feeling?","michәksәs?"));
        phraseArray.add(new Word("I’m feeling good.","kuchi achit"));
        phraseArray.add(new phrase("Yes, I’m coming","hәә’ әәnәm"));
        phraseArray.add(new phrase("eight","әәnәm"));
        phraseArray.add(new phrase("I’m coming","yoowutis"));
        phraseArray.add(new phrase("Come here","әnni'nem"));


        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter phrasesAdapter=
                new WordAdapter(this,phraseArray);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(phrasesAdapter);
    }
}
