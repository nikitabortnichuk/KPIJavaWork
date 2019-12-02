package com.bortnichuk;

import java.io.Closeable;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    private FileReaders() {
    }

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {
        Path path = getPath(fileName);

        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new FileStatsException("Cannot read file");
        }

        Closeable

    }

    private static Path getPath(String filePath) {
        URL url = FileReaders.class.getClassLoader().getResource(filePath);
        Objects.requireNonNull(url);

        try {
            return Paths.get(url.toURI());
        } catch (URISyntaxException e) {
            throw new FileStatsException("Cannot open file");
        }
    }
}
