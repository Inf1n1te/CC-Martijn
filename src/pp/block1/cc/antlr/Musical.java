// Generated from Musical.g4 by ANTLR 4.4
package pp.block1.cc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Musical extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LA=1, LALA=2, LALALALI=3;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'"
	};
	public static final String[] ruleNames = {
		"FLA", "LA", "LALA", "LALALALI"
	};


	public Musical(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Musical.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5\'\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\6\2\16\n\2\r\2\16\2\17\3\2\7\2\23\n\2\f"+
		"\2\16\2\26\13\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5#\n\5\f"+
		"\5\16\5&\13\5\2\2\6\3\2\5\3\7\4\t\5\3\2\2(\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\3\13\3\2\2\2\5\27\3\2\2\2\7\31\3\2\2\2\t\34\3\2\2\2\13\r\7N\2"+
		"\2\f\16\7c\2\2\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20"+
		"\24\3\2\2\2\21\23\7\"\2\2\22\21\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24"+
		"\25\3\2\2\2\25\4\3\2\2\2\26\24\3\2\2\2\27\30\5\3\2\2\30\6\3\2\2\2\31\32"+
		"\5\3\2\2\32\33\5\3\2\2\33\b\3\2\2\2\34\35\5\3\2\2\35\36\5\3\2\2\36\37"+
		"\5\3\2\2\37 \7N\2\2 $\7k\2\2!#\7\"\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2"+
		"$%\3\2\2\2%\n\3\2\2\2&$\3\2\2\2\6\2\17\24$\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}