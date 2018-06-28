package org.esiea.firmin_jacques_olivier_chamoinri_ifuja.comicsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static org.esiea.firmin_jacques_olivier_chamoinri_ifuja.comicsproject.page_3.EXTRA_CHARACTER;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String characterName = intent.getStringExtra(EXTRA_CHARACTER);


        TextView textViewCharacter = findViewById(R.id.text_view_character_detail);


        textViewCharacter.setText(characterName);

    }
}
