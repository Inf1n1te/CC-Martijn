// Generated from /home/inf1n1te/workspace/Programming Paradigms/CC/src/pp/block1/cc/antlr/ID6.g4 by ANTLR 4.5
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
public class ID6 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, WS=2;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "DIGIT", "LETDIG", "WORD", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WORD", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ID6(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ID6.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\4#\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\4\3\4\5\4\24\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6\36\n\6\r\6\16\6\37\3\6\3\6\2\2\7\3\2"+
		"\5\2\7\2\t\3\13\4\3\2\4\4\2C\\c|\5\2\13\f\17\17\"\"!\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\3\r\3\2\2\2\5\17\3\2\2\2\7\23\3\2\2\2\t\25\3\2\2\2\13\35\3\2"+
		"\2\2\r\16\t\2\2\2\16\4\3\2\2\2\17\20\4\62;\2\20\6\3\2\2\2\21\24\5\3\2"+
		"\2\22\24\5\5\3\2\23\21\3\2\2\2\23\22\3\2\2\2\24\b\3\2\2\2\25\26\5\3\2"+
		"\2\26\27\5\7\4\2\27\30\5\7\4\2\30\31\5\7\4\2\31\32\5\7\4\2\32\33\5\7\4"+
		"\2\33\n\3\2\2\2\34\36\t\3\2\2\35\34\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2"+
		"\2\37 \3\2\2\2 !\3\2\2\2!\"\b\6\2\2\"\f\3\2\2\2\5\2\23\37\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}