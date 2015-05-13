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

import pp.block3.cc.antlr.operators.*;
import pp.block3.cc.antlr.operators.OperAttrParser.TContext;
import static org.junit.Assert.assertEquals;

public class OperTest {

	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final OperCalculator calc = new OperCalculator();

	@Test
	public void operTest() {
		test("5", "3+2");
		test("6", "1+2+3");
		test("27", "(1+2)^3");
		test("10", "2 ^ 3 + 2");
		test("64", "2 ^ 3 ^ 2"); // Power not right associative
		test("\"ababab\"", "\"ab\"^3");
	}

	private void test(String expected, String expr) {
		assertEquals(expected, parseOperAttr(expr).value);
		ParseTree tree = parseOper(expr);
		calc.init();
		walker.walk(calc, tree);
		assertEquals(expected, calc.value
				(tree));
	}

	private ParseTree parseOper(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new OperLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		OperParser parser = new OperParser(tokens);
		return parser.t();
	}

	private TContext parseOperAttr(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new OperAttrLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		OperAttrParser parser = new OperAttrParser(tokens);
		return parser.t();
	}
}
