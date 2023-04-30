package ua.lviv.iot.algo;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextTest {


    @Test
    public void testRemoveWordsWithConsonant_emptyText_returnsEmptyString() {
        Text text = new Text("", 5);
        assertEquals("", text.removeWordsWithConsonant());
    }


    @Test
    public void testRemoveWordsWithConsonant_WordLengthLessThanSpecifiedLength() {
        Text text = new Text("hello world", 6);
        assertEquals("hello world", text.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_WordLengthMoreThanSpecifiedLength() {
        Text text = new Text("hello my friends", 1);
        assertEquals("hello my friends", text.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_onlyConsonants() {
        Text text = new Text("This dress is pink", 5);
        assertEquals("This is pink", text.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_EndOfSentence() {
        Text text = new Text("This is a test sentence.", 8);
        assertEquals("This is a test .", text.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_StartOfSentence() {
        Text text = new Text("Sentence starts with S.", 8);
        assertEquals("starts with S.", text.removeWordsWithConsonant());
    }


    @Test
    public void testRemoveWordsWithConsonant_removesWordsWithVowel() {
        Text text = new Text("Absolutely amazing avocado and apple.", 7);
        assertEquals("Absolutely amazing avocado and apple.", text.removeWordsWithConsonant());
    }


    @Test
    public void testRemoveWordsWithConsonant_zeroLength_returnsOriginalText() {
        Text text = new Text("Hello world!", 0);
        assertEquals("Hello world!", text.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_negativeLength_returnsOriginalText() {
        Text text = new Text("Hello world!", -3);
        assertEquals("Hello world!", text.removeWordsWithConsonant());
    }


}
