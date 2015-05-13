package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.*;
import pp.block3.cc.antlr.OperAttrParser.ExprContext;

import static org.junit.Assert.assertEquals;

public class OperTest {

	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final Calculator calc = new Calculator();

	@Test
	public void operTest() {
		test(5, "3+2");
		test(7, "1+2*3");
		test(9, "(1+2)*3");
		test(66, "16 * 4 + 2");
	}

	private void test(int expected, String expr) {
		assertEquals(expected, parseOperAttr(expr).val);
		ParseTree tree = parseCalc(expr);
		calc.init();
		walker.walk(calc, tree);
		assertEquals(expected, calc.val(tree));
	}

	private ParseTree parseCalc(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		return parser.expr();
	}

	private ExprContext parseOperAttr(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new OperAttrLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		OperAttrParser parser = new OperAttrParser(tokens);
		return parser.expr();
	}
}
