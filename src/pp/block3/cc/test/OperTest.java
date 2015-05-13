package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.CalcLexer;
import pp.block3.cc.antlr.CalcParser;
import pp.block3.cc.antlr.Calculator;
import pp.block3.cc.antlr.operators.OperAttrLexer;
import pp.block3.cc.antlr.operators.OperAttrParser;

import static org.junit.Assert.assertEquals;

public class OperTest {

	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final Calculator calc = new Calculator();

	@Test
	public void operTest() {
		test("5", "3+2");
		test("6", "1+2+3");
		test("27", "(1+2)^3");
		test("10", "2 ^ 3 + 2");
		test("64", "2 ^ 3 ^ 2"); // Power not right associative
		test("\"ababab\"", "\"ab\"^3");
		test("true", "2=2=true");
		test("true", "\"x^2\"^3=\"x^2\"+\"x^2\"+\"x^2\"");
		test("true", "(\"x^2\"^3=\"x^2\"+\"x^2\"+\"x^2\")+false");
	}

	private void test(String expected, String expr) {
		assertEquals(expected, parseOperAttr(expr).value);
//		ParseTree tree = parseCalc(expr);
//		calc.init();
//		walker.walk(calc, tree);
//		assertEquals(expected, calc.val(tree));
	}

	private ParseTree parseCalc(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		return parser.expr();
	}

	private OperAttrParser.TContext parseOperAttr(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new OperAttrLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		OperAttrParser parser = new OperAttrParser(tokens);
		return parser.t();
	}
}
