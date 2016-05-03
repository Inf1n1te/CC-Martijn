package pp.block2.cc.antlr.arithmetic;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	private Class<? extends Lexer> lexerType;

	@Test
	public void testCalculator() {
		lexerType = ArithmeticLexer.class;
		Calculator calc = new Calculator();
		assertEquals(BigInteger.valueOf(34), calc.parse(scan("3^2+25")));
		assertEquals(BigInteger.valueOf(15625), calc.parse(scan("-5^5*5/-1")));
		assertEquals(BigInteger.valueOf(64), calc.parse(scan("70------- ---- --- -- - ----- -- - --6")));
		assertEquals(BigInteger.valueOf(7450580596923827396L), calc.parse(scan("5^(3*(4+5))-3^(5^1+1)")));
		assertEquals(BigInteger.valueOf(512), calc.parse(scan("2^3^2")));
		assertEquals(BigInteger.valueOf(-10), calc.parse(scan("---10")));
		assertEquals(BigInteger.valueOf(-12), calc.parse(scan("3-10+5")));
		assertEquals(BigInteger.valueOf(7), calc.parse(scan("10-3")));
	}

	/**
	 * Converts a text into a token stream, using the preset lexer type.
	 */
	private Lexer scan(String text) {
		Lexer result = null;
		CharStream stream = new ANTLRInputStream(text);
		try {
			Constructor<? extends Lexer> lexerConstr = lexerType
					.getConstructor(CharStream.class);
			result = lexerConstr.newInstance(stream);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| InvocationTargetException e) {
			// should never occur, as all Antlr-generated lexers are
			// well-behaved
			e.printStackTrace();
		}
		return result;
	}
}
