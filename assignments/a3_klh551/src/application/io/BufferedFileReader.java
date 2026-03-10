package application.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * A BufferedReader specialized for reading files (or file paths).
 *
 * @author JDT - KLH551
 */
public class BufferedFileReader extends BufferedReader {

    /**
     * Creates a BufferedFileReader for the file at the given path.
     *
     * @param fileName the path to the file to read
     */
    public BufferedFileReader(String fileName) throws IOException {
        super(new FileReader(fileName));
    }

    /**
     * Creates a BufferedFileReader for the given file.
     *
     * @param file the file to read
     */
    public BufferedFileReader(File file) throws IOException {
        super(new FileReader(file));
    }

    /**
     * Returns the next non-blank line in the file, or null at EOF.
     *
     * @return the next non-blank line, or null at EOF
     */
    public String nextNonBlankLine() throws IOException {
       String line;
       while ((line = readLine()) != null) {
           if (!line.trim().isEmpty()) {
               return line;
           }
       }
       return null;
    }
}
