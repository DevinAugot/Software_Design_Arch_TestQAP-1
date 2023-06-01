package com.keyin;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuggestionEngineTest {

    @Test
    public void testGenerateSuggestionsValidInputWordIsCorrect() throws Exception {
        // Create an instance of SuggestionEngine
        SuggestionEngine suggestionEngine = new SuggestionEngine();

        // Load the dictionary data from the words.txt file

        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").getPath()));


        // Set up test data
        String word = "code";  // A correct word from the dictionary

        // method under test
        String suggestions = suggestionEngine.generateSuggestions(word);

        // Assert the expected result
        assertEquals("", suggestions, "No suggestions should be generated for a correct word");
    }


    @Test
    public void testGenerateSuggestionsForIncorrectSpelling() throws Exception {
        // Create an instance of SuggestionEngine
        SuggestionEngine suggestionEngine = new SuggestionEngine();

        // Set up test data
        String word = "spellling";  // Misspelled word

        // method under test
        String suggestions = suggestionEngine.generateSuggestions(word);

        // Assert the expected result
        assertFalse(suggestions.equals(word), "Suggestions should not be empty for a misspelled word");

    }

    @Test
    public void EmptyInputReturnsEmptyString() throws Exception {
        // Create an instance of SuggestionEngine
        SuggestionEngine suggestionEngine = new SuggestionEngine();

        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").getPath()));

        // Set up test data
        String word = "";  // Empty input

        // method under test
        String suggestions = suggestionEngine.generateSuggestions(word);

        // Assert the expected result
        assertEquals("", suggestions, "No suggestions should be generated for an empty input");
    }

    @Test
    void wordNotInDictionaryReturnsEmptyString() throws Exception {
        // Create an instance of SuggestionEngine
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").getPath()));

        // Set up test data
        String word = "1d2k3l4h5j6";  // Word not present in the dictionary

        // method under test
        String suggestions = suggestionEngine.generateSuggestions(word);

        // Assert the expected result
        assertEquals("", suggestions, "No suggestions should be generated for a word not in the dictionary");
    }

    @Test
    @DisplayName("Daugot")
    public void testGenerateSuggestionExistingWord() throws IOException {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").getPath()));

        String name = "blahblahblah";
        String result = String.valueOf(suggestionEngine.generateSuggestions(name));

        Assertions.assertEquals("", result, "Expect Empty String");
    }
}


