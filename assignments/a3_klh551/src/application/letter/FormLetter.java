package application.letter;

import application.io.BufferedFileReader;
import application.tag.TagOccurrence;
import application.translate.Dictionary;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Generates a form letter from a template file using a Dictionary.
 *
 * @author JDT - KLH551
 */
public class FormLetter {

    private File templateFile;
    private ArrayList<String> lines;
    private Dictionary dictionary;

    /**
     * Loads the template from the given file path.
     *
     * @param templatePath the path to the template file
     */
    public FormLetter(String templatePath) throws IOException {
       templateFile = new File(templatePath);
       lines = new ArrayList<>();
       BufferedFileReader reader = new BufferedFileReader(templateFile);
       String line;
       while ((line = reader.nextNonBlankLine()) != null){
          lines.add(line);
       }
       reader.close();
    }

    /**
     * Sets the Dictionary used for tag translation.
     *
     * @param dictionary the dictionary to use
     */
    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Returns the template file.
     *
     * @return the template file
     */
    public File getTemplateFile() {
        return templateFile;
    }

    /**
     * Returns the given line with all recognized tags replaced by their translations.
     *
     * @param line the raw template line to translate
     * @return the translated line
     */
    public String translateLine(String line) {
       int curr = 0;
       String result = "";
       TagOccurrence occurrence;
       while ((occurrence = TagOccurrence.nextOccurrence(line, curr)) != null){
          result += line.substring(curr, occurrence.getBeginIndex());
          result += dictionary.translate(occurrence.getTag());
          curr = occurrence.getEndIndex();
       }
       result += line.substring(curr);
       return result;
    }

    /**
     * Writes the translated letter to the given output file.
     *
     * @param outputFile the file to write to
     */
    public void printLetter(File outputFile) throws IOException {
       PrintStream out = new PrintStream(outputFile);
       for (String l : lines){
          out.println(translateLine(l));
       }
       out.close();
    }
}
