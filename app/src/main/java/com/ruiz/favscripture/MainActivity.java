package com.ruiz.favscripture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_BOOK ="com.ruiz.favscripture.BOOK";
    public static final String EXTRA_CHAPTER ="com.ruiz.favscripture.CHAPTER";
    public static final String EXTRA_VERSE ="com.ruiz.favscripture.VERSE";

    public static final String DEFAULT = "N/A";

    EditText bookText;
    EditText chapterText;
    EditText verseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookText = (EditText) findViewById(R.id.bookText);
        chapterText = (EditText) findViewById(R.id.chapterText);
        verseText = (EditText) findViewById(R.id.verseText);
   }

    public void displayScripture(View view) {
        final String TAG = "MainActivityCR";

        //getting views and getting the text values
        String book = bookText.getText().toString();
        String chapter = chapterText.getText().toString();
        String verse = verseText.getText().toString();

        //creating the Intent and setting the message for logcat
        Log.d(TAG, String.format("About to create intent with %s %s:%s", book, chapter, verse));
        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        intent.putExtra(EXTRA_BOOK, book);
        intent.putExtra(EXTRA_CHAPTER, chapter);
        intent.putExtra(EXTRA_VERSE, verse);
        startActivity(intent);
    }

    public void loadScripture(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("scriptureData",
                MODE_PRIVATE);
        String bookSaved = sharedPreferences.getString("book", DEFAULT);
        String chapterSaved = sharedPreferences.getString("chapter", DEFAULT);
        String verseSaved = sharedPreferences.getString("verse", DEFAULT);
        if (!bookSaved.equals(DEFAULT)) {
            bookText.setText(bookSaved);
        }
        if (!chapterSaved.equals(DEFAULT)) {
            chapterText.setText(chapterSaved);
        }
        if (!verseSaved.equals(DEFAULT)) {
            verseText.setText(verseSaved);
        }



    }
}
