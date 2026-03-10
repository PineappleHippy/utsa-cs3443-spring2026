package application.translate;

import application.io.BufferedFileReader;
import java.io.IOException;

/**
 * Reads Dictionary blocks sequentially from a dictionary file.
 *
 * @author JDT - KLH551
 */
public class DictionaryIterator {

    private BufferedFileReader reader;

    /**
     * Creates a DictionaryIterator that reads from the file at the given path.
     *
     * @param fileName the path to the dictionary file
     */
    public DictionaryIterator(String fileName) throws IOException {
        reader = new BufferedFileReader(fileName);
    }

    /**
     * Returns the next Dictionary from the file, or null if no more are available.
     *
     * @return the next Dictionary, or null at EOF
     */
    public Dictionary next() throws IOException {
       String line;
       while ((line = reader.nextNonBlankLine()) != null){
          if (line.equals("<begin-dictionary>")){
             Dictionary d = new Dictionary();
             while ((line = reader.nextNonBlankLine()) != null){
                if (line.equals("<end-dictionary>")){
                   return d;
                }
                int spaceIndex = line.indexOf(' ');
                int firstQuote = line.indexOf('"');
                int lastQuote = line.lastIndexOf('"');
                String tag = line.substring(0, spaceIndex);
                String translationText = line.substring(firstQuote + 1, lastQuote);
                Translation t = new Translation(tag, translationText);
                d.addTranslation(t);
             }return d;
          }
       }
        return null;
    }
}
