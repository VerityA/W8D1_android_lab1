package com.example.user.wordcounterlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by user on 19/03/2018.
 */

public class StringFunctions {

    private String stringOfWords;

    public StringFunctions(String words) {
        this.stringOfWords = words;
    }

    public int wordCount() {

        String[] arrayOfWords = this.stringOfWords.split(" ");
        return arrayOfWords.length;
    }

    public String getWordTallySorted() {
        HashMap<String, Integer> wordTally = getWordTally();

        ArrayList<Integer> arrayOfWordCounts = new ArrayList<>();
        ArrayList<Integer> arrayOfWordCountsDuplicatesRemoved = new ArrayList<>();
        ArrayList<String> sortedWords = new ArrayList<>();

        for (HashMap.Entry<String, Integer> entry : wordTally.entrySet()) {
            arrayOfWordCounts.add(entry.getValue());
            arrayOfWordCountsDuplicatesRemoved.add(entry.getValue());
        }

        Collections.sort(arrayOfWordCounts);
        Collections.reverse(arrayOfWordCounts);
        Collections.sort(arrayOfWordCountsDuplicatesRemoved);
        Collections.reverse(arrayOfWordCountsDuplicatesRemoved);

        for (int i = 0; i <= arrayOfWordCountsDuplicatesRemoved.size(); i++) {
            for (int j = i + 1; j < arrayOfWordCountsDuplicatesRemoved.size(); j++) {
            if (arrayOfWordCountsDuplicatesRemoved.get(i).equals(arrayOfWordCountsDuplicatesRemoved.get(j))) {
                arrayOfWordCountsDuplicatesRemoved.remove(i);
            }
            }
        }

        for (Integer count : arrayOfWordCountsDuplicatesRemoved) {
            for (HashMap.Entry<String, Integer> entry : wordTally.entrySet()) {
                if (entry.getValue() == count) {
                    sortedWords.add(entry.getKey());
                }
            }
        }

        StringBuilder wordTallySortedAsString = new StringBuilder();
        for (int i = 0; i < sortedWords.size(); i++){

                wordTallySortedAsString.append(sortedWords.get(i) + " : " + arrayOfWordCounts.get(i) + ", ");
            }

        String string = wordTallySortedAsString.substring(0, wordTallySortedAsString.length() - 2);
        return string;
    }

    public HashMap<String,Integer> getWordTally() {
        String[] arrayOfWords = this.stringOfWords.split(" ");
        ArrayList<String> arrayListOfWords = new ArrayList<>(Arrays.asList(arrayOfWords));

        HashMap<String,Integer> wordTally = new HashMap<>();
        for ( String word : arrayOfWords) {
            int numberOfOccurrences = Collections.frequency(arrayListOfWords, word);
            wordTally.put(word, numberOfOccurrences);
        }

        return wordTally;
    }
}




