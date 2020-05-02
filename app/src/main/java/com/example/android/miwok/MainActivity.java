/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        //Find the view shows the NumberActivity
        TextView number = (TextView) findViewById(R.id.numbers);

        //set the onClickListener to the view
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //make an new intent to open the @NumbersActivity
                Intent numbersIntent = new Intent(MainActivity.this, NumberActivity.class);

                //start the new activity
                startActivity(numbersIntent);
            }
        });


        //Find the view shows the FamilyActivity
        TextView family = (TextView) findViewById(R.id.family);

        //set the onClickListener to the view
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //make an new intent to open the @familyActivity{
                Intent familyIntent = new Intent(MainActivity.this, FamilyMembers.class);

                //start the new activity
                startActivity(familyIntent);
            }
        });

        //Find the view shows the NumberActivity
        TextView color = (TextView) findViewById(R.id.colors);

        //set the onClickListener to the view
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //make an new intent to open the @colorsActivity{
                Intent colorsIntent = new Intent(MainActivity.this, Color.class);

                //start the new activity
                startActivity(colorsIntent);
            }
        });

        //Find the view shows the NumberActivity
        TextView phrase = (TextView) findViewById(R.id.Phrases);

        //set the onClickListener to the view
        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //make an new intent to open the @colorsActivity{
                Intent phraseIntent = new Intent(MainActivity.this, Phrases.class);

                //start the new activity
                startActivity(phraseIntent);
            }
        });
    }
}
