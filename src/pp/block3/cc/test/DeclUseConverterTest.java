package pp.block3.cc.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import pp.block3.cc.antlr.CalcAttrLexer;
import pp.block3.cc.symbol.DeclUseConverter;
import pp.block3.cc.symbol.DeclUseConverter.Error;
import pp.block3.cc.symbol.DeclUseLexer;

public class DeclUseConverterTest {

	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final DeclUseConverter decl = new DeclUseConverter();

	@Test
	public void test() {
		test("(D:aap (U:aap D:noot D:aap (U:noot) (D:noot U:noot)) U:aap)");
	}

	private void test(String expr, Error ... expected ) {
		Boolean ok = true;
		List<Error> errors = parseDeclUse(expr);
		for (Error e : errors) {
			System.out.println(e.toString());
		}
		System.out.println(expected.length + " " + errors.size());
		assertTrue(expected.length == errors.size());
		for (int i = 0; i < expected.length; i++) {
			if (!errors.get(i).equals(expected[i])) {
				ok = false;
			}
		}
		
		assertTrue(ok);
	}

	private List<Error> parseDeclUse(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new DeclUseLexer(chars);
		decl.init();
		return decl.parse(lexer);
	}
}
