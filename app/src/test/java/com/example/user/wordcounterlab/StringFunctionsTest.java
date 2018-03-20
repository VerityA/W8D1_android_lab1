package com.example.user.wordcounterlab;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 19/03/2018.
 */

public class StringFunctionsTest {

    StringFunctions stringFunctions;

    @Before
    public void before() {
        stringFunctions = new StringFunctions("I am trying out something new");
    }

    @Test
    public void canGetWordCount() {
        assertEquals(6, stringFunctions.wordCount());
    }

    @Test
    public void canGetWordCountTally() {
        StringFunctions string = new StringFunctions("hello world hello there hello world");
        HashMap<String, Integer> tally = new HashMap<>();
        tally.put("hello", 3);
        tally.put("world", 2);
        tally.put("there", 1);
        assertEquals(tally, string.getWordTally());
    }


    @Test
    public void canGetWordCountTallySorted() {
        StringFunctions string = new StringFunctions("orange blue yellow orange orange yellow orange yellow");
        String result = "orange : 4, yellow : 3, blue : 1";
        assertEquals(result, string.getWordTallySorted());
    }


}
