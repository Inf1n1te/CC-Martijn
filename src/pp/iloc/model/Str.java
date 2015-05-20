package pp.iloc.model;

/**
 * Literal string operand.
 * This is not part of official ILOC
 *
 * @author Arend Rensink
 */
public class Str extends Operand {
	private final static String BSLASH = "\\";
	private final static String DQUOTE = "\"";
	private final String text;

	/**
	 * Constructs a string operand with a given (string) value.
	 */
	public Str(String value) {
		super(Type.STR);
		this.text = value;
	}

	/**
	 * Returns the text of this string.
	 */
	public String getText() {
		return this.text;
	}

	@Override
	public String toString() {
		return DQUOTE + this.text.replaceAll(DQUOTE, BSLASH + DQUOTE) + DQUOTE;
	}

	@Override
	public int hashCode() {
		return getText().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Str)) {
			return false;
		}
		Str other = (Str) obj;
		return getText().equals(other.getText());
	}
}