package pp.block1.cc.dfa;

import java.util.LinkedList;
import java.util.List;

public class MyScanner implements Scanner {

	@Override
	public List<String> scan(State dfa, String text) {
		List<String> result = new LinkedList<String>();
		String word = "";
		State current = dfa;
		String lastAcceptingWord = "";
		int lastAcceptingIndex = 0;
		
		for (int i = 0; i < text.length(); i++) {
			char c = text.toCharArray()[i];
			if (current.hasNext(c)) {
				current = current.getNext(c);
				word += c;
				if (current.isAccepting()) {
					lastAcceptingWord = word;
					lastAcceptingIndex = i;
				}
			} else if (lastAcceptingWord.length() > 0) {
				result.add(lastAcceptingWord);
				i = lastAcceptingIndex;
				current = dfa;
				lastAcceptingWord = "";
				word = "";
			}
		}
		if (current.isAccepting()) {
			result.add(word);
			current = dfa;
			word = "";
		}
		return result;
	}

}
