package ua.lviv.iot.algo;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextProcessorTest {


    @Test
    public void testRemoveWordsWithConsonant_emptyText_returnsEmptyString() {
        TextProcessor processor = new TextProcessor("", 5);
        assertEquals("", processor.removeWordsWithConsonant());
    }


    @Test
    public void testRemoveWordsWithConsonant_WordLengthLessThanSpecifiedLength() {
        TextProcessor processor = new TextProcessor("hello world", 6);
        assertEquals("hello world", processor.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_WordLengthMoreThanSpecifiedLength() {
        TextProcessor processor = new TextProcessor("hello my friends", 1);
        assertEquals("hello my friends", processor.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_onlyConsonants() {
        TextProcessor processor = new TextProcessor("This dress is pink", 5);
        assertEquals("This is pink", processor.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_EndOfSentence() {
        TextProcessor processor = new TextProcessor("This is a test sentence.", 8);
        assertEquals("This is a test .", processor.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_StartOfSentence() {
        TextProcessor processor = new TextProcessor("Sentence starts with S.", 8);
        assertEquals("starts with S.", processor.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_MiddleOfSentence() {
        TextProcessor processor = new TextProcessor("The quick brown fox jumps over the lazy dog.", 5);
        assertEquals("The fox over the lazy dog.", processor.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_removesWordsWithVowel() {
        TextProcessor processor = new TextProcessor("Absolutely amazing avocado and apple.", 7);
        assertEquals("Absolutely amazing avocado and apple.", processor.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_removesWordsWithConsonantAndSpecialCharacters() {
        TextProcessor processor = new TextProcessor("This sentence! It includes special characters @#$%^&*()_+[]{};':\",./<>?", 5);
        assertEquals("This sentence! It includes special characters @#$%^&*()_+[]{};':\",./<>?", processor.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_zeroLength_returnsOriginalText() {
        TextProcessor processor = new TextProcessor("Hello world!", 0);
        assertEquals("Hello world!", processor.removeWordsWithConsonant());
    }

    @Test
    public void testRemoveWordsWithConsonant_negativeLength_returnsOriginalText() {
        TextProcessor processor = new TextProcessor("Hello world!", -3);
        assertEquals("Hello world!", processor.removeWordsWithConsonant());
    }


}
