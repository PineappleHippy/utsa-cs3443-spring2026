package application.translate;

/**
 * Maps a source tag string to a target replacement string.
 *
 * @author JDT - KLH551
 */
public class Translation {

    private String source;
    private String target;

    /**
     * Creates a Translation from source to target.
     *
     * @param source the source tag
     * @param target the replacement text
     */
    public Translation(String source, String target) {
        this.source = source;
        this.target = target;
    }

    /**
     * Returns the source tag.
     *
     * @return the source tag
     */
    public String getSource() {
        return source;
    }

    /**
     * Returns the target replacement text.
     *
     * @return the target text
     */
    public String getTarget() {
        return target;
    }

    /**
     * Returns a readable string representation of this Translation.
     *
     * @return a string description of this Translation
     */
    @Override
    public String toString() {
        return "Translation{" + source + " -> " + target + "}";
    }
}
