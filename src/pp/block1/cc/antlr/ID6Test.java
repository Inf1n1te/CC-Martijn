package pp.block1.cc.antlr;

import org.junit.Test;

public class ID6Test {
	private static LexerTester tester = new LexerTester(ID6.class);

	@Test
	public void test() {
		tester.yields("a9js43", ID6.WORD);
		tester.yields("A98fds	aas0fd asldkf", ID6.WORD, ID6.WORD, ID6.WORD);
		tester.correct("a0a0a0");
		tester.correct("A0a0a0");
		tester.wrong("0a0a0a");
	}
}
