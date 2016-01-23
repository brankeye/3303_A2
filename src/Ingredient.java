
public enum Ingredient {
	BREAD("Bread"),
	BACON("Bacon"),
    BANANA("Banana");

    private final String text;

    /**
     * @param text
     */
    private Ingredient(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
