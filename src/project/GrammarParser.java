// Generated from Grammar.g4 by ANTLR 4.4
package project;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOL=2, ENUM=3, IF=4, ELSE=5, WHILE=6, RUN=7, JOIN=8, TRUE=9, FALSE=10, 
		ASS=11, EQ=12, GT=13, GE=14, LT=15, LE=16, NE=17, AND=18, OR=19, NOT=20, 
		LBRACE=21, RBRACE=22, LPAR=23, RPAR=24, LBRACK=25, RBRACK=26, SEMI=27, 
		DQUOTE=28, SQUOTE=29, COLON=30, COMMA=31, DOT=32, AMP=33, PLUS=34, MINUS=35, 
		SLASH=36, STAR=37, CARET=38, UND=39, COMMENT=40, WS=41, ID=42, NUM=43, 
		EID=44, STR=45;
	public static final String[] tokenNames = {
		"<INVALID>", "INT", "BOOL", "ENUM", "IF", "ELSE", "WHILE", "RUN", "JOIN", 
		"TRUE", "FALSE", "'='", "'=='", "'>'", "'>='", "'<'", "'<='", "'!='", 
		"'&&'", "'||'", "'!'", "'{'", "'}'", "'('", "')'", "'['", "']'", "';'", 
		"'\"'", "'''", "':'", "','", "'.'", "'&'", "'+'", "'-'", "'/'", "'*'", 
		"'^'", "'_'", "COMMENT", "WS", "ID", "NUM", "EID", "STR"
	};
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_type = 2, RULE_expr = 3, RULE_plusOp = 4, 
		RULE_multOp = 5, RULE_expOp = 6, RULE_boolOp = 7, RULE_cmpOp = 8, RULE_prfOp = 9;
	public static final String[] ruleNames = {
		"program", "stat", "type", "expr", "plusOp", "multOp", "expOp", "boolOp", 
		"cmpOp", "prfOp"
	};

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20); stat();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ENUM) | (1L << IF) | (1L << WHILE) | (1L << RUN) | (1L << LBRACE) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(GrammarParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(GrammarParser.IF, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(GrammarParser.LBRACE, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public TerminalNode WHILE() { return getToken(GrammarParser.WHILE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode RBRACE() { return getToken(GrammarParser.RBRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode EID(int i) {
			return getToken(GrammarParser.EID, i);
		}
		public TerminalNode RUN() { return getToken(GrammarParser.RUN, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public TerminalNode ENUM() { return getToken(GrammarParser.ENUM, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public List<TerminalNode> EID() { return getTokens(GrammarParser.EID); }
		public TerminalNode ASS() { return getToken(GrammarParser.ASS, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			int _alt;
			setState(106);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(25); type();
				setState(26); match(ID);
				setState(27); match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29); type();
				setState(30); match(ID);
				setState(31); match(ASS);
				setState(32); expr(0);
				setState(33); match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(35); match(ID);
				setState(36); match(ASS);
				setState(37); expr(0);
				setState(38); match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(40); match(ENUM);
				setState(41); match(ID);
				setState(42); match(ASS);
				setState(43); match(LBRACE);
				setState(44); match(EID);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(45); match(COMMA);
					setState(46); match(EID);
					}
					}
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(52); match(RBRACE);
				setState(53); match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(54); match(IF);
				setState(55); match(LPAR);
				setState(56); expr(0);
				setState(57); match(RPAR);
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(58); stat();
						}
						} 
					}
					setState(63);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(71);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(64); match(ELSE);
					setState(68);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(65); stat();
							}
							} 
						}
						setState(70);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(73); match(WHILE);
				setState(74); match(LPAR);
				setState(75); expr(0);
				setState(76); match(RPAR);
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(77); stat();
						}
						} 
					}
					setState(82);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(83); match(LBRACE);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ENUM) | (1L << IF) | (1L << WHILE) | (1L << RUN) | (1L << LBRACE) | (1L << ID))) != 0)) {
					{
					{
					setState(84); stat();
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(90); match(RBRACE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(91); match(RUN);
				setState(92); match(ID);
				setState(93); match(LPAR);
				setState(102);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << JOIN) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << LPAR) | (1L << MINUS) | (1L << ID) | (1L << NUM) | (1L << EID))) != 0)) {
					{
					setState(94); expr(0);
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(95); match(COMMA);
						setState(96); expr(0);
						}
						}
						setState(101);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(104); match(RPAR);
				setState(105); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(GrammarParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==BOOL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public PrfOpContext prfOp() {
			return getRuleContext(PrfOpContext.class,0);
		}
		public TerminalNode FALSE() { return getToken(GrammarParser.FALSE, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public TerminalNode TRUE() { return getToken(GrammarParser.TRUE, 0); }
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public CmpOpContext cmpOp() {
			return getRuleContext(CmpOpContext.class,0);
		}
		public PlusOpContext plusOp() {
			return getRuleContext(PlusOpContext.class,0);
		}
		public ExpOpContext expOp() {
			return getRuleContext(ExpOpContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}
		public TerminalNode EID() { return getToken(GrammarParser.EID, 0); }
		public TerminalNode JOIN() { return getToken(GrammarParser.JOIN, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			switch (_input.LA(1)) {
			case NOT:
			case MINUS:
				{
				setState(111); prfOp();
				setState(112); expr(7);
				}
				break;
			case JOIN:
				{
				setState(114); match(JOIN);
				setState(115); match(ID);
				}
				break;
			case LPAR:
				{
				setState(116); match(LPAR);
				setState(117); expr(0);
				setState(118); match(RPAR);
				}
				break;
			case ID:
				{
				setState(120); match(ID);
				}
				break;
			case NUM:
				{
				setState(121); match(NUM);
				}
				break;
			case EID:
				{
				setState(122); match(EID);
				}
				break;
			case TRUE:
				{
				setState(123); match(TRUE);
				}
				break;
			case FALSE:
				{
				setState(124); match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(147);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(128); plusOp();
						setState(129); expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(132); multOp();
						setState(133); expr(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(136); expOp();
						setState(137); expr(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(140); boolOp();
						setState(141); expr(10);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(144); cmpOp();
						setState(145); expr(9);
						}
						break;
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PlusOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(GrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GrammarParser.MINUS, 0); }
		public PlusOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPlusOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPlusOp(this);
		}
	}

	public final PlusOpContext plusOp() throws RecognitionException {
		PlusOpContext _localctx = new PlusOpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_plusOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultOpContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(GrammarParser.SLASH, 0); }
		public TerminalNode STAR() { return getToken(GrammarParser.STAR, 0); }
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMultOp(this);
		}
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !(_la==SLASH || _la==STAR) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpOpContext extends ParserRuleContext {
		public TerminalNode CARET() { return getToken(GrammarParser.CARET, 0); }
		public ExpOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpOp(this);
		}
	}

	public final ExpOpContext expOp() throws RecognitionException {
		ExpOpContext _localctx = new ExpOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(CARET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(GrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(GrammarParser.OR, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBoolOp(this);
		}
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmpOpContext extends ParserRuleContext {
		public TerminalNode GE() { return getToken(GrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(GrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(GrammarParser.GT, 0); }
		public TerminalNode LE() { return getToken(GrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(GrammarParser.EQ, 0); }
		public TerminalNode NE() { return getToken(GrammarParser.NE, 0); }
		public CmpOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmpOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmpOp(this);
		}
	}

	public final CmpOpContext cmpOp() throws RecognitionException {
		CmpOpContext _localctx = new CmpOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmpOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << NE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrfOpContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(GrammarParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(GrammarParser.MINUS, 0); }
		public PrfOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prfOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPrfOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPrfOp(this);
		}
	}

	public final PrfOpContext prfOp() throws RecognitionException {
		PrfOpContext _localctx = new PrfOpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_prfOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !(_la==NOT || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 12);
		case 1: return precpred(_ctx, 11);
		case 2: return precpred(_ctx, 10);
		case 3: return precpred(_ctx, 9);
		case 4: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u00a7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\6\2\30\n\2\r\2\16\2\31\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\62\n\3\f\3\16\3\65"+
		"\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3>\n\3\f\3\16\3A\13\3\3\3\3\3\7\3"+
		"E\n\3\f\3\16\3H\13\3\5\3J\n\3\3\3\3\3\3\3\3\3\3\3\7\3Q\n\3\f\3\16\3T\13"+
		"\3\3\3\3\3\7\3X\n\3\f\3\16\3[\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3d\n"+
		"\3\f\3\16\3g\13\3\5\3i\n\3\3\3\3\3\5\3m\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0080\n\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5"+
		"\u0096\n\5\f\5\16\5\u0099\13\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\2\3\b\f\2\4\6\b\n\f\16\20\22\24\2\b\3\2\3\4\3\2$%\3\2"+
		"&\'\3\2\24\25\3\2\16\23\4\2\26\26%%\u00b8\2\27\3\2\2\2\4l\3\2\2\2\6n\3"+
		"\2\2\2\b\177\3\2\2\2\n\u009a\3\2\2\2\f\u009c\3\2\2\2\16\u009e\3\2\2\2"+
		"\20\u00a0\3\2\2\2\22\u00a2\3\2\2\2\24\u00a4\3\2\2\2\26\30\5\4\3\2\27\26"+
		"\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33\34"+
		"\5\6\4\2\34\35\7,\2\2\35\36\7\35\2\2\36m\3\2\2\2\37 \5\6\4\2 !\7,\2\2"+
		"!\"\7\r\2\2\"#\5\b\5\2#$\7\35\2\2$m\3\2\2\2%&\7,\2\2&\'\7\r\2\2\'(\5\b"+
		"\5\2()\7\35\2\2)m\3\2\2\2*+\7\5\2\2+,\7,\2\2,-\7\r\2\2-.\7\27\2\2.\63"+
		"\7.\2\2/\60\7!\2\2\60\62\7.\2\2\61/\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\30\2\2\67m\7\35\2"+
		"\289\7\6\2\29:\7\31\2\2:;\5\b\5\2;?\7\32\2\2<>\5\4\3\2=<\3\2\2\2>A\3\2"+
		"\2\2?=\3\2\2\2?@\3\2\2\2@I\3\2\2\2A?\3\2\2\2BF\7\7\2\2CE\5\4\3\2DC\3\2"+
		"\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GJ\3\2\2\2HF\3\2\2\2IB\3\2\2\2IJ\3\2"+
		"\2\2Jm\3\2\2\2KL\7\b\2\2LM\7\31\2\2MN\5\b\5\2NR\7\32\2\2OQ\5\4\3\2PO\3"+
		"\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2Sm\3\2\2\2TR\3\2\2\2UY\7\27\2\2VX"+
		"\5\4\3\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2"+
		"\\m\7\30\2\2]^\7\t\2\2^_\7,\2\2_h\7\31\2\2`e\5\b\5\2ab\7!\2\2bd\5\b\5"+
		"\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2h`\3\2\2"+
		"\2hi\3\2\2\2ij\3\2\2\2jk\7\32\2\2km\7\35\2\2l\33\3\2\2\2l\37\3\2\2\2l"+
		"%\3\2\2\2l*\3\2\2\2l8\3\2\2\2lK\3\2\2\2lU\3\2\2\2l]\3\2\2\2m\5\3\2\2\2"+
		"no\t\2\2\2o\7\3\2\2\2pq\b\5\1\2qr\5\24\13\2rs\5\b\5\ts\u0080\3\2\2\2t"+
		"u\7\n\2\2u\u0080\7,\2\2vw\7\31\2\2wx\5\b\5\2xy\7\32\2\2y\u0080\3\2\2\2"+
		"z\u0080\7,\2\2{\u0080\7-\2\2|\u0080\7.\2\2}\u0080\7\13\2\2~\u0080\7\f"+
		"\2\2\177p\3\2\2\2\177t\3\2\2\2\177v\3\2\2\2\177z\3\2\2\2\177{\3\2\2\2"+
		"\177|\3\2\2\2\177}\3\2\2\2\177~\3\2\2\2\u0080\u0097\3\2\2\2\u0081\u0082"+
		"\f\16\2\2\u0082\u0083\5\n\6\2\u0083\u0084\5\b\5\17\u0084\u0096\3\2\2\2"+
		"\u0085\u0086\f\r\2\2\u0086\u0087\5\f\7\2\u0087\u0088\5\b\5\16\u0088\u0096"+
		"\3\2\2\2\u0089\u008a\f\f\2\2\u008a\u008b\5\16\b\2\u008b\u008c\5\b\5\r"+
		"\u008c\u0096\3\2\2\2\u008d\u008e\f\13\2\2\u008e\u008f\5\20\t\2\u008f\u0090"+
		"\5\b\5\f\u0090\u0096\3\2\2\2\u0091\u0092\f\n\2\2\u0092\u0093\5\22\n\2"+
		"\u0093\u0094\5\b\5\13\u0094\u0096\3\2\2\2\u0095\u0081\3\2\2\2\u0095\u0085"+
		"\3\2\2\2\u0095\u0089\3\2\2\2\u0095\u008d\3\2\2\2\u0095\u0091\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\t\3\2\2\2"+
		"\u0099\u0097\3\2\2\2\u009a\u009b\t\3\2\2\u009b\13\3\2\2\2\u009c\u009d"+
		"\t\4\2\2\u009d\r\3\2\2\2\u009e\u009f\7(\2\2\u009f\17\3\2\2\2\u00a0\u00a1"+
		"\t\5\2\2\u00a1\21\3\2\2\2\u00a2\u00a3\t\6\2\2\u00a3\23\3\2\2\2\u00a4\u00a5"+
		"\t\7\2\2\u00a5\25\3\2\2\2\17\31\63?FIRYehl\177\u0095\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}