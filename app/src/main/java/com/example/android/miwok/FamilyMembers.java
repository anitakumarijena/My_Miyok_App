package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create array of familyMember
        //Adding all miwok family words with english words with image
        //Add pictures to the family member
        ArrayList<Word> numberArray = new ArrayList<Word>();
        numberArray.add(new Word("father","әpә",R.drawable.family_father));
        numberArray.add(new Word("mother","әṭa",R.drawable.family_mother));
        numberArray.add(new Word("son","angsi",R.drawable.family_son));
        numberArray.add(new Word("daughter","tune",R.drawable.family_daughter));
        numberArray.add(new Word("older brother","taachi",R.drawable.family_older_brother));
        numberArray.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother));
        numberArray.add(new Word("older sister","teṭe",R.drawable.family_older_sister));
        numberArray.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister));
        numberArray.add(new Word("grandmother","ama",R.drawable.family_grandmother));
        numberArray.add(new Word("grandfather","paapa",R.drawable.family_grandfather));


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
    }
}