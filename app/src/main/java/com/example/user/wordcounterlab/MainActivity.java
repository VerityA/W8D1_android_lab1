package com.example.user.wordcounterlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText stringEditText;
    private Button wordCountButton;
    private TextView wordCountView;
    private TextView wordTallyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stringEditText = findViewById(R.id.stringInput);
        wordCountButton = findViewById(R.id.button_for_word_count);
        wordCountView = findViewById(R.id.view_word_count);
        wordTallyView = findViewById(R.id.word_tally_view);
    }

    public void onWordCountButtonClicked(View clickedView) {
        StringFunctions words = new StringFunctions(stringEditText.getText().toString());
        Log.d("MainActivity", "Test");
        Integer result = words.wordCount();
        String stringResult = result.toString();
        wordCountView.setText(stringResult);
    }

    public void onWordTallyButtonClicked(View clickedView) {
        StringFunctions words = new StringFunctions(stringEditText.getText().toString());
        String string = words.getWordTallySorted();
        wordTallyView.setText(string);
    }

//    public void onWordTallyButtonClicked(View clickedView) {
//        StringFunctions words = new StringFunctions(stringEditText.getText().toString());
//        HashMap<String, Integer> wordTally = words.getWordTally();
//        StringBuilder wordTallyAsString = new StringBuilder();
//        for (HashMap.Entry<String, Integer> entry: wordTally.entrySet()) {
//            wordTallyAsString.append(entry.getKey() + " : " + entry.getValue() + ", ");
//        }
//        String string = wordTallyAsString.substring(0, wordTallyAsString.length() - 2);
//        wordTallyView.setText(string);
//
//    }
}


