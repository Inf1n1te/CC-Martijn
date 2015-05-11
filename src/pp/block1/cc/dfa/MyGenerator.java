package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inf1n1te on 22-4-15.
 */
public class MyGenerator implements Generator {
	@Override
	public List<String> scan(State dfa, String text) {
		boolean loop = true;
		List<String> tokens = new ArrayList<>();
		ArrayList<Character> token = new ArrayList<>();
		String lastToken = null;
		int lastCounter = 0;
		State current = dfa;
		char[] chars = text.toCharArray();
		int counter = 0;
		while (loop && chars.length > 0) {
			char c = chars[counter];
			if (current.hasNext(c)) {
				token.add(c);
				current = current.getNext(c);
				if (current.isAccepting()) {
					lastToken = buildString(token);
					lastCounter = counter;
				}
			} else {
				if (lastToken != null) {
					tokens.add(lastToken);
					counter = lastCounter;
				}
				token.clear();
				lastToken = null;
				current = dfa;
			}
			if (counter == chars.length - 1) {
				if (lastToken != null && lastCounter != chars.length - 1) {
					tokens.add(lastToken);
					lastToken = null;
					token.clear();
					counter = lastCounter;
					current = dfa;
				} else {
					loop = false;
				}

			}
			counter++;
		}
		if (lastToken != null) {
			tokens.add(lastToken);
		}
		return tokens;
	}

	private String buildString(ArrayList<Character> chars) {
		StringBuilder builder = new StringBuilder();
		for (Character c : chars) {
			builder.append(c);
		}
		return builder.toString();
	}
}
