package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create array of numbers
        //Add picture to the numbers
        ArrayList<Word> numberArray = new ArrayList<Word>();
        numberArray.add(new Word("one","lutti",R.drawable.number_one));
        numberArray.add(new Word("two","otiiko",R.drawable.number_two));
        numberArray.add(new Word("three","tolookosu",R.drawable.number_three));
        numberArray.add(new Word("four","oyyisa",R.drawable.number_four));
        numberArray.add(new Word("five","massokka",R.drawable.number_five));
        numberArray.add(new Word("six","temmoka",R.drawable.number_six));
        numberArray.add(new Word("seven","kenekaku",R.drawable.number_seven));
        numberArray.add(new Word("eight","kawinta",R.drawable.number_eight));
        numberArray.add(new Word("nine","wo'e",R.drawable.number_nine));
        numberArray.add(new Word("ten","na'accha",R.drawable.number_ten));


        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter itemsAdapter=
                new WordAdapter(this,numberArray,R.color.category_numbers);

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


