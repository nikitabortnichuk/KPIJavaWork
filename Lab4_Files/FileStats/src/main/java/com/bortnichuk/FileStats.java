package com.bortnichuk;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * {@link FileStats} provides an API that allow to get character statistic based on text file. All whitespace characters
 * are ignored.
 */
public class FileStats {

    private Map<Character, Long> characterLongMap;

    public FileStats(String fileName){
        Path path = getPath(fileName);
        characterLongMap = getAllCharacterCount(path);
    }


    /**
     * Creates a new immutable {@link FileStats} objects using data from text file received as a parameter.
     *
     * @param fileName input text file name
     * @return new FileStats object created from text file
     */
    public static FileStats from(String fileName) {
        return new FileStats(fileName);
    }

    /**
     * Returns a number of occurrences of the particular character.
     *
     * @param character a specific character
     * @return a number that shows how many times this character appeared in a text file
     */
    public int getCharCount(char character) {
        return characterLongMap.get(character).intValue();
    }

    /**
     * Returns a character that appeared most often in the text.
     *
     * @return the most frequently appeared character
     */
    public char getMostPopularCharacter() {
        return getMaxKeyCharacter();
    }

    private Character getMaxKeyCharacter() {
        return characterLongMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow(() -> new FileStatsException("There is no characters in file"))
                .getKey();
    }

    /**
     * Returns {@code true} if this character has appeared in the text, and {@code false} otherwise
     *
     * @param character a specific character to check
     * @return {@code true} if this character has appeared in the text, and {@code false} otherwise
     */
    public boolean containsCharacter(char character) {
        return characterLongMap.containsKey(character);
    }


    public Map<Character, Long> getAllCharacterCount(Path path) {

        try {
            Stream<String> lines = Files.lines(path);
            return getCharCountFromLine(lines);

        } catch (IOException e) {
            throw new FileStatsException("Cannot read file");
        }

    }

    private Map<Character, Long> getCharCountFromLine(Stream<String> lines){
        return lines
                .flatMapToInt(String::chars)
                .filter(x -> x > 32)
                .mapToObj(c -> (char)c)
                .collect(groupingBy(identity(), counting()));
    }

    public Path getPath(String fileName){

        try {
            URL url = getClass().getClassLoader().getResource(fileName);
            return Paths.get(url.toURI());
        } catch (NullPointerException | URISyntaxException e) {
            throw new FileStatsException("Cannot open file: " + fileName);
        }
    }
}
