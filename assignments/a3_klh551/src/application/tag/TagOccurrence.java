package application.tag;

/**
 * Stores a tag string and its character range within a line of text.
 *
 * @author JDT - KLH551
 */
public class TagOccurrence {

	private String tag;
	private int beginIndex;
	private int endIndex;

	/**
	 * Creates a TagOccurrence with the given tag and index range.
	 *
	 * @param tag        the tag string
	 * @param beginIndex the index of the opening '<' in the source line
	 * @param endIndex   the index one past the closing '>' in the source line
	 */
	public TagOccurrence(String tag, int beginIndex, int endIndex) {
		this.tag = tag;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}

	/**
	 * Returns the next tag occurrence in line at or after start, or null if none.
	 *
	 * @param line  the line of text to search
	 * @param start the character index at which to begin searching
	 * @return a TagOccurrence for the next tag, or null if none found
	 */
	public static TagOccurrence nextOccurrence(String line, int start) {
		int openIndex = line.indexOf('<',start);
		if (openIndex == -1) return null;
		int closeIndex = line.indexOf('>', openIndex);
		if (closeIndex == -1) return null;
		String tag = line.substring(openIndex, closeIndex +1);
		return new TagOccurrence(tag, openIndex, closeIndex +1);
	}

	/**
	 * Returns the tag string.
	 *
	 * @return the tag string
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Returns the begin index of the tag in the source line.
	 *
	 * @return the begin index
	 */
	public int getBeginIndex() {
		return beginIndex;
	}

	/**
	 * Returns the end index of the tag in the source line.
	 *
	 * @return the end index
	 */
	public int getEndIndex() {
		return endIndex;
	}

	/**
	 * Returns a readable string representation of this TagOccurrence.
	 *
	 * @return a string description of this TagOccurrence
	 */
	@Override
	public String toString() {
		return "TagOccurrence{tag=" + tag + ", begin=" + beginIndex + ", end=" + endIndex + "}";
	}
}
