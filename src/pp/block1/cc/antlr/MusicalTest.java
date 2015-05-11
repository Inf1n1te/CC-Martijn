package pp.block1.cc.antlr;

import org.junit.Test;

public class MusicalTest {
	private static LexerTester tester = new LexerTester(Musical.class);

	@Test
	public void test() {
		tester.correct("LaLaLaLi");
		tester.correct("Laaaaa     La ");
		tester.correct("Laaaaa     LaLaaaaaaaaaaaaa               Li");
		tester.wrong("Laaaaa     LaLaaaaaaaaaaaaa               Lii");
	}
}
