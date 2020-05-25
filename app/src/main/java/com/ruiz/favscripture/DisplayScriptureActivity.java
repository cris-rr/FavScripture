package com.ruiz.favscripture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayScriptureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        Intent intent = getIntent();
        String book = intent.getStringExtra(MainActivity.EXTRA_BOOK);
        String chapter = intent.getStringExtra(MainActivity.EXTRA_CHAPTER);
        String verse = intent.getStringExtra(MainActivity.EXTRA_VERSE);

        TextView scriptureText = findViewById(R.id.scriptureText);
        String scripture = String.format("%s %s:%s", book, chapter, verse);
        scriptureText.setText(scripture);
    }
}
