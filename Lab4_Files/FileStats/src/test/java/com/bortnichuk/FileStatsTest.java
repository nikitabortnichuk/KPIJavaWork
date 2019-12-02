package com.bortnichuk;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class FileStatsTest {

    @Test
    public void testNumberOfCharacters(){
        Map<Character, Long> characterLongMap = new HashMap<>();
        characterLongMap.put('a', (long)5);
        characterLongMap.put('b', (long)6);
        characterLongMap.put('c', (long)7);

        double actual = characterLongMap.values().stream()
                .mapToInt(Long::intValue)
                .average().orElseThrow();

        assertEquals(6, actual, 0.001);
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyMapAverage(){
        Map<Character, Long> characterLongMap = new HashMap<>();

        double actual = characterLongMap.values().stream()
                .mapToInt(Long::intValue)
                .average().orElseThrow();

    }

    @Test
    public void testCreateFileStatsFromExistingFile() {
        FileStats fileStats = FileStats.from("sotl.txt");
        boolean result = fileStats.containsCharacter('a');
        assertTrue(result);
    }

    @Test(expected = FileStatsException.class)
    public void testCreateFileStatsFromNonExistingFile() {
        FileStats fileStats = FileStats.from("blahblah.txt");
    }

    @Test
    public void testGetCharCount() {
        FileStats lambdaArticleFileStats = FileStats.from("sotl.txt");
        FileStats springCloudArticleFileStats = FileStats.from("scosb.txt");

        int aCharCountInLambdaArticle = lambdaArticleFileStats.getCharCount('a');
        int bCharCountInSpringArticle = springCloudArticleFileStats.getCharCount('b');

        assertEquals(2345, aCharCountInLambdaArticle);
        assertEquals(4, bCharCountInSpringArticle);
    }

    @Test
    public void testGetMostPopularCharacter() {
        FileStats lambdaArticleFileStats = FileStats.from("sotl.txt");
        FileStats springCloudArticleFileStats = FileStats.from("scosb.txt");

        char mostPopularCharacterInLambdaArticle = lambdaArticleFileStats.getMostPopularCharacter();
        char mostPopularCharacterInSpringArticle = springCloudArticleFileStats.getMostPopularCharacter();

        System.out.println(mostPopularCharacterInSpringArticle);

        assertEquals('e', mostPopularCharacterInLambdaArticle);
        assertEquals('e', mostPopularCharacterInSpringArticle);
    }

    @Test
    public void testContainsCharacter() {
        FileStats lambdaArticleFileStats = FileStats.from("sotl.txt");
        FileStats springCloudArticleFileStats = FileStats.from("scosb.txt");

        boolean lambdaArticleContainsExistingCharacter = lambdaArticleFileStats.containsCharacter('a');
        boolean lambdaArticleContainsWhitespace = lambdaArticleFileStats.containsCharacter(' ');
        boolean springArticleContainsExistingCharacter = springCloudArticleFileStats.containsCharacter('b');
        boolean springArticleContainsWhitespace = springCloudArticleFileStats.containsCharacter(' ');

        assertTrue(lambdaArticleContainsExistingCharacter);
        assertFalse(lambdaArticleContainsWhitespace);
        assertTrue(springArticleContainsExistingCharacter);
        assertFalse(springArticleContainsWhitespace);
    }
}
