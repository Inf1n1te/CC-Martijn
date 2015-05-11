package pp.block1.cc.dfa;

/**
 * Created by inf1n1te on 22-4-15.
 */
public class MyChecker implements Checker {

	@Override
	public boolean accepts(State start, String word) {
		State current = start;
		char[] chars = word.toCharArray();
		for (char character : chars) {
			if (current.hasNext(character)) {
				current = current.getNext(character);
			} else {
				return false;
			}
		}
		return current.isAccepting();
	}
}
