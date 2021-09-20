package com.dash.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalyzeSentimentTest {

    @org.junit.jupiter.api.Test
    void backItUp() {
        String s = AnalyzeSentiment.backItUp("hello");
        assertEquals("olleh", s);
    }

    @org.junit.jupiter.api.Test
    void score() {
        int scoreNegative = AnalyzeSentiment.score_sentiment("hello, why are you so lame?");
        assertEquals(-1, scoreNegative);

        int scorePositive = AnalyzeSentiment.score_sentiment("wow, this is awesome!");
        assertEquals(1, scorePositive);

        int scoreNeutral = AnalyzeSentiment.score_sentiment("how are you?");
        assertEquals(0, scoreNeutral);

        int score1 = AnalyzeSentiment.sentiment_analysis("hello, why are you so lame?");
        assertEquals(1, score1);

        int score2 = AnalyzeSentiment.sentiment_analysis("how are you?");
        assertEquals(2, score2);

        int score4 = AnalyzeSentiment.sentiment_analysis("wow, this is awesome!");
        assertEquals(4, score4);
    }

}