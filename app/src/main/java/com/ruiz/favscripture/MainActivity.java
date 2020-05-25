package com.ruiz.favscripture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_BOOK ="com.ruiz.favscripture.BOOK";
    public static final String EXTRA_CHAPTER ="com.ruiz.favscripture.CHAPTER";
    public static final String EXTRA_VERSE ="com.ruiz.favscripture.VERSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayScripture(View view) {
        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        EditText bookText = findViewById(R.id.bookText);
        EditText chapterText = findViewById(R.id.chapterText);
        EditText verseText = findViewById(R.id.verseText);
        String book = bookText.getText().toString();
        String chapter = chapterText.getText().toString();
        String verse = verseText.getText().toString();
        intent.putExtra(EXTRA_BOOK, book);
        intent.putExtra(EXTRA_CHAPTER, chapter);
        intent.putExtra(EXTRA_VERSE, verse);
        startActivity(intent);
    }
}
