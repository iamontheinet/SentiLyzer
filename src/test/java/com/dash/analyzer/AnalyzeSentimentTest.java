package com.dash.analyzer;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzeSentimentTest {

    @org.junit.jupiter.api.Test
    void backItUp() {
        String s = AnalyzeSentiment.backItUp("hello");
        assertEquals("olleh", s);
    }

    @org.junit.jupiter.api.Test
    void score() {
        int scoreNegative = AnalyzeSentiment.score("hello, why are you so lame?");
        assertEquals(-1, scoreNegative);

        int scorePositive = AnalyzeSentiment.score("wow, this is awesome!");
        assertEquals(1, scorePositive);

        int scoreNeutral = AnalyzeSentiment.score("how are you?");
        assertEquals(0, scoreNeutral);
    }

}