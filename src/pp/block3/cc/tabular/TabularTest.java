package pp.block3.cc.tabular;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.CalcParser;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertFalse;

public class TabularTest {


	
	private final ParseTreeWalker walker = new ParseTreeWalker();
//	private final Calc calc = TabularParser();

	@Test
	public void test() {
		test("src/pp/block3/cc/tabular/tabular-1.tex");
		test("src/pp/block3/cc/tabular/tabular-2.tex");
		test("src/pp/block3/cc/tabular/tabular-3.tex");
	}

	private void test(String filename) {
		CharStream chars = null;
		try {
			chars = new ANTLRInputStream(new FileInputStream(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Lexer lexer = new TabularLexer(chars);
		lexer.removeErrorListeners();
		
		TabularErrorListener tel = new TabularErrorListener();
		lexer.addErrorListener(tel);
		
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		parser.expr();
		
		System.out.println(tel.getAllErrors().toString());
		
		assertFalse(tel.hasErrors());
				
		
	}
}
