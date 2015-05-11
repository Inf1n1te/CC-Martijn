package pp.block1.cc.antlr;

import org.junit.Test;

public class QuoteTest {
	private static LexerTester tester = new LexerTester(Quote.class);

	@Test
	public void test() {
		tester.correct("\"kjdsaf;khdsflkjhdslkjfhdsa\"\"lkjdsahflkjdsahflkjdsahf\"\"lkjdsahflkjdsahflkjdsahff\"");
	}
}
