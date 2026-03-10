package application.translate;

import java.util.ArrayList;

/**
 * A collection of Translation objects used to replace tags with text.
 *
 * @author JDT - KLH551
 */
public class Dictionary {

    private ArrayList<Translation> translations;

    /**
     * Creates an empty Dictionary.
     */
    public Dictionary() {
        translations = new ArrayList<>();
    }

    /**
     * Adds a translation to this dictionary.
     *
     * @param t the translation to add
     */
    public void addTranslation(Translation t) {
        translations.add(t);
    }

    /**
     * Returns the target text for the given tag, or the tag itself if no match exists.
     *
     * @param tag the tag to look up
     * @return the translated text, or tag if no match exists
     */
    public String translate(String tag) {
      for (Translation t : translations){
          if (t.getSource().equals(tag)) {
             return t.getTarget();
          }
       }
       return tag;
    }

    /**
     * Returns a string listing all translations in this dictionary.
     *
     * @return a string representation of all translations
     */
    @Override
    public String toString() {
        return translations.toString();
    }
}
