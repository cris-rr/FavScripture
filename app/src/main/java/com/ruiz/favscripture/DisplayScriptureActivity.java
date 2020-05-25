package com.ruiz.favscripture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScriptureActivity extends AppCompatActivity {

    String book;
    String chapter;
    String verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String TAG = "ScriptureActivityCR";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        //Getting text values from EXTRAS setting the message for logcat
        Intent intent = getIntent();
        book = intent.getStringExtra(MainActivity.EXTRA_BOOK);
        chapter = intent.getStringExtra(MainActivity.EXTRA_CHAPTER);
        verse = intent.getStringExtra(MainActivity.EXTRA_VERSE);
        String scripture = String.format("%s %s:%s", book, chapter, verse);
        Log.d(TAG, String.format("Received intent with %s", scripture));

        //Displaying the scripture in view.
        TextView scriptureText = findViewById(R.id.scriptureText);
        scriptureText.setText(scripture);
    }

    public void saveScripture(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("scriptureData",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //get the data to save in shared preferences
        editor.putString("book", book);
        editor.putString("chapter", chapter);
        editor.putString("verse", verse);
        editor.commit();

        Toast.makeText(this, "Scripture details are saved!", Toast.LENGTH_SHORT).show();
    }
}
