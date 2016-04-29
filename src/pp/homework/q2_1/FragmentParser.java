// Generated from Fragment.g4 by ANTLR 4.4
package pp.homework.q2_1;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FragmentParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, SEMI=2, COMMA=3, LSQ=4, RSQ=5, ASSIGN=6, NOT=7, OR=8, AND=9, BIT_OR=10, 
		BIT_AND=11, PLUS=12, MINUS=13, LT=14, GT=15, EQ=16, NE=17, LCURLY=18, 
		RCURLY=19, LPAR=20, RPAR=21, IN=22, PRINT=23, BOOL=24, FOR=25, INT=26, 
		WHILE=27, IF=28, ELSE=29, TRUE=30, FALSE=31, BREAK=32, CONTINUE=33, ID=34, 
		NUM=35, STRING=36, WS=37;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "';'", "','", "'['", "']'", "'='", "'!'", "'||'", 
		"'&&'", "'|'", "'&'", "'+'", "'-'", "'<'", "'>'", "'=='", "'!='", "'{'", 
		"'}'", "'('", "')'", "'in'", "'printf'", "'boolean'", "'for'", "'int'", 
		"'while'", "'if'", "'else'", "'true'", "'false'", "'break'", "'continue'", 
		"ID", "NUM", "STRING", "WS"
	};
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_target = 2, RULE_expr = 3, RULE_type = 4;
	public static final String[] ruleNames = {
		"program", "stat", "target", "expr", "type"
	};

	@Override
	public String getGrammarFileName() { return "Fragment.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FragmentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FragmentParser.EOF, 0); }
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
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10); stat();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << PRINT) | (1L << BOOL) | (1L << FOR) | (1L << INT) | (1L << WHILE) | (1L << IF) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID))) != 0) );
			setState(15); match(EOF);
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
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatContext {
		public TerminalNode ELSE() { return getToken(FragmentParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(FragmentParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitIfStat(this);
		}
	}
	public static class BlockStatContext extends StatContext {
		public TerminalNode RCURLY() { return getToken(FragmentParser.RCURLY, 0); }
		public TerminalNode LCURLY() { return getToken(FragmentParser.LCURLY, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitBlockStat(this);
		}
	}
	public static class ContStatContext extends StatContext {
		public TerminalNode CONTINUE() { return getToken(FragmentParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public ContStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterContStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitContStat(this);
		}
	}
	public static class DeclContext extends StatContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(FragmentParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitDecl(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public List<TerminalNode> ID() { return getTokens(FragmentParser.ID); }
		public TerminalNode PRINT() { return getToken(FragmentParser.PRINT, 0); }
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FragmentParser.COMMA); }
		public TerminalNode STRING() { return getToken(FragmentParser.STRING, 0); }
		public TerminalNode ID(int i) {
			return getToken(FragmentParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(FragmentParser.COMMA, i);
		}
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitPrintStat(this);
		}
	}
	public static class AssignStatContext extends StatContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FragmentParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitAssignStat(this);
		}
	}
	public static class BreakStatContext extends StatContext {
		public TerminalNode BREAK() { return getToken(FragmentParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitBreakStat(this);
		}
	}
	public static class ForStatContext extends StatContext {
		public List<TerminalNode> ID() { return getTokens(FragmentParser.ID); }
		public List<TerminalNode> ASSIGN() { return getTokens(FragmentParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(FragmentParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(FragmentParser.SEMI); }
		public TerminalNode FOR() { return getToken(FragmentParser.FOR, 0); }
		public TerminalNode SEMI(int i) {
			return getToken(FragmentParser.SEMI, i);
		}
		public TerminalNode ID(int i) {
			return getToken(FragmentParser.ID, i);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public ForStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitForStat(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public TerminalNode WHILE() { return getToken(FragmentParser.WHILE, 0); }
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitWhileStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(83);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
				_localctx = new DeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(17); type();
				setState(18); match(ID);
				setState(21);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(19); match(ASSIGN);
					setState(20); expr(0);
					}
				}

				setState(23); match(SEMI);
				}
				break;
			case ID:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25); target();
				setState(26); match(ASSIGN);
				setState(27); expr(0);
				setState(28); match(SEMI);
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(30); match(IF);
				setState(31); match(LPAR);
				setState(32); expr(0);
				setState(33); match(RPAR);
				setState(34); stat();
				setState(37);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(35); match(ELSE);
					setState(36); stat();
					}
					break;
				}
				}
				break;
			case WHILE:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(39); match(WHILE);
				setState(40); match(LPAR);
				setState(41); expr(0);
				setState(42); match(RPAR);
				setState(43); stat();
				}
				break;
			case FOR:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(45); match(FOR);
				setState(46); match(LPAR);
				setState(47); match(ID);
				setState(48); match(ASSIGN);
				setState(49); expr(0);
				setState(50); match(SEMI);
				setState(51); expr(0);
				setState(52); match(SEMI);
				setState(53); match(ID);
				setState(54); match(ASSIGN);
				setState(55); expr(0);
				setState(56); match(RPAR);
				setState(57); stat();
				}
				break;
			case LCURLY:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(59); match(LCURLY);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << PRINT) | (1L << BOOL) | (1L << FOR) | (1L << INT) | (1L << WHILE) | (1L << IF) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID))) != 0)) {
					{
					{
					setState(60); stat();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66); match(RCURLY);
				}
				break;
			case PRINT:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(67); match(PRINT);
				setState(68); match(LPAR);
				setState(69); match(STRING);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(70); match(COMMA);
					setState(71); match(ID);
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(77); match(RPAR);
				setState(78); match(SEMI);
				}
				break;
			case BREAK:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(79); match(BREAK);
				setState(80); match(SEMI);
				}
				break;
			case CONTINUE:
				_localctx = new ContStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(81); match(CONTINUE);
				setState(82); match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TargetContext extends ParserRuleContext {
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
	 
		public TargetContext() { }
		public void copyFrom(TargetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdTargetContext extends TargetContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public IdTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterIdTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitIdTarget(this);
		}
	}
	public static class ArrayTargetContext extends TargetContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQ() { return getToken(FragmentParser.RSQ, 0); }
		public TerminalNode LSQ() { return getToken(FragmentParser.LSQ, 0); }
		public ArrayTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterArrayTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitArrayTarget(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_target);
		try {
			setState(91);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new IdTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(85); match(ID);
				}
				break;
			case 2:
				_localctx = new ArrayTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86); match(ID);
				setState(87); match(LSQ);
				setState(88); expr(0);
				setState(89); match(RSQ);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQ() { return getToken(FragmentParser.RSQ, 0); }
		public TerminalNode LSQ() { return getToken(FragmentParser.LSQ, 0); }
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitArrayExpr(this);
		}
	}
	public static class InExprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public TerminalNode IN() { return getToken(FragmentParser.IN, 0); }
		public InExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterInExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitInExpr(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(FragmentParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitOrExpr(this);
		}
	}
	public static class FieldExprContext extends ExprContext {
		public TerminalNode DOT() { return getToken(FragmentParser.DOT, 0); }
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FieldExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterFieldExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitFieldExpr(this);
		}
	}
	public static class ParExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitParExpr(this);
		}
	}
	public static class BitOrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BIT_OR() { return getToken(FragmentParser.BIT_OR, 0); }
		public BitOrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterBitOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitBitOrExpr(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(FragmentParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitNotExpr(this);
		}
	}
	public static class AddExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(FragmentParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FragmentParser.MINUS, 0); }
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitAddExpr(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(FragmentParser.LT, 0); }
		public TerminalNode GT() { return getToken(FragmentParser.GT, 0); }
		public TerminalNode EQ() { return getToken(FragmentParser.EQ, 0); }
		public TerminalNode NE() { return getToken(FragmentParser.NE, 0); }
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitCompExpr(this);
		}
	}
	public static class BitAndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BIT_AND() { return getToken(FragmentParser.BIT_AND, 0); }
		public BitAndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterBitAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitBitAndExpr(this);
		}
	}
	public static class ConstExprContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(FragmentParser.FALSE, 0); }
		public TerminalNode NUM() { return getToken(FragmentParser.NUM, 0); }
		public TerminalNode TRUE() { return getToken(FragmentParser.TRUE, 0); }
		public ConstExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitConstExpr(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitIdExpr(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(FragmentParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitAndExpr(this);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(94); match(NOT);
				setState(95); expr(12);
				}
				break;
			case 2:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96); match(LPAR);
				setState(97); expr(0);
				setState(98); match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NUM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 4:
				{
				_localctx = new InExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101); match(IN);
				setState(102); match(LPAR);
				setState(103); match(RPAR);
				}
				break;
			case 5:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104); match(ID);
				setState(105); match(LSQ);
				setState(106); expr(0);
				setState(107); match(RSQ);
				}
				break;
			case 6:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(133);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(113);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(114); expr(12);
						}
						break;
					case 2:
						{
						_localctx = new BitAndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(116); match(BIT_AND);
						setState(117); expr(11);
						}
						break;
					case 3:
						{
						_localctx = new BitOrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(119); match(BIT_OR);
						setState(120); expr(10);
						}
						break;
					case 4:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(122); match(AND);
						setState(123); expr(9);
						}
						break;
					case 5:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(125); match(OR);
						setState(126); expr(8);
						}
						break;
					case 6:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(128);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << EQ) | (1L << NE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(129); expr(7);
						}
						break;
					case 7:
						{
						_localctx = new FieldExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(131); match(DOT);
						setState(132); match(ID);
						}
						break;
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(FragmentParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(FragmentParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !(_la==BOOL || _la==INT) ) {
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
		case 0: return precpred(_ctx, 11);
		case 1: return precpred(_ctx, 10);
		case 2: return precpred(_ctx, 9);
		case 3: return precpred(_ctx, 8);
		case 4: return precpred(_ctx, 7);
		case 5: return precpred(_ctx, 6);
		case 6: return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u008f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\5\3\30\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3(\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3@\n\3\f\3\16\3C\13\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3V"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4^\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5q\n\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0088"+
		"\n\5\f\5\16\5\u008b\13\5\3\6\3\6\3\6\2\3\b\7\2\4\6\b\n\2\6\4\2 !%%\3\2"+
		"\16\17\3\2\20\23\4\2\32\32\34\34\u00a3\2\r\3\2\2\2\4U\3\2\2\2\6]\3\2\2"+
		"\2\bp\3\2\2\2\n\u008c\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\17\3\2\2\2\17"+
		"\r\3\2\2\2\17\20\3\2\2\2\20\21\3\2\2\2\21\22\7\2\2\3\22\3\3\2\2\2\23\24"+
		"\5\n\6\2\24\27\7$\2\2\25\26\7\b\2\2\26\30\5\b\5\2\27\25\3\2\2\2\27\30"+
		"\3\2\2\2\30\31\3\2\2\2\31\32\7\4\2\2\32V\3\2\2\2\33\34\5\6\4\2\34\35\7"+
		"\b\2\2\35\36\5\b\5\2\36\37\7\4\2\2\37V\3\2\2\2 !\7\36\2\2!\"\7\26\2\2"+
		"\"#\5\b\5\2#$\7\27\2\2$\'\5\4\3\2%&\7\37\2\2&(\5\4\3\2\'%\3\2\2\2\'(\3"+
		"\2\2\2(V\3\2\2\2)*\7\35\2\2*+\7\26\2\2+,\5\b\5\2,-\7\27\2\2-.\5\4\3\2"+
		".V\3\2\2\2/\60\7\33\2\2\60\61\7\26\2\2\61\62\7$\2\2\62\63\7\b\2\2\63\64"+
		"\5\b\5\2\64\65\7\4\2\2\65\66\5\b\5\2\66\67\7\4\2\2\678\7$\2\289\7\b\2"+
		"\29:\5\b\5\2:;\7\27\2\2;<\5\4\3\2<V\3\2\2\2=A\7\24\2\2>@\5\4\3\2?>\3\2"+
		"\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DV\7\25\2\2EF\7"+
		"\31\2\2FG\7\26\2\2GL\7&\2\2HI\7\5\2\2IK\7$\2\2JH\3\2\2\2KN\3\2\2\2LJ\3"+
		"\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\27\2\2PV\7\4\2\2QR\7\"\2\2RV"+
		"\7\4\2\2ST\7#\2\2TV\7\4\2\2U\23\3\2\2\2U\33\3\2\2\2U \3\2\2\2U)\3\2\2"+
		"\2U/\3\2\2\2U=\3\2\2\2UE\3\2\2\2UQ\3\2\2\2US\3\2\2\2V\5\3\2\2\2W^\7$\2"+
		"\2XY\7$\2\2YZ\7\6\2\2Z[\5\b\5\2[\\\7\7\2\2\\^\3\2\2\2]W\3\2\2\2]X\3\2"+
		"\2\2^\7\3\2\2\2_`\b\5\1\2`a\7\t\2\2aq\5\b\5\16bc\7\26\2\2cd\5\b\5\2de"+
		"\7\27\2\2eq\3\2\2\2fq\t\2\2\2gh\7\30\2\2hi\7\26\2\2iq\7\27\2\2jk\7$\2"+
		"\2kl\7\6\2\2lm\5\b\5\2mn\7\7\2\2nq\3\2\2\2oq\7$\2\2p_\3\2\2\2pb\3\2\2"+
		"\2pf\3\2\2\2pg\3\2\2\2pj\3\2\2\2po\3\2\2\2q\u0089\3\2\2\2rs\f\r\2\2st"+
		"\t\3\2\2t\u0088\5\b\5\16uv\f\f\2\2vw\7\r\2\2w\u0088\5\b\5\rxy\f\13\2\2"+
		"yz\7\f\2\2z\u0088\5\b\5\f{|\f\n\2\2|}\7\13\2\2}\u0088\5\b\5\13~\177\f"+
		"\t\2\2\177\u0080\7\n\2\2\u0080\u0088\5\b\5\n\u0081\u0082\f\b\2\2\u0082"+
		"\u0083\t\4\2\2\u0083\u0088\5\b\5\t\u0084\u0085\f\17\2\2\u0085\u0086\7"+
		"\3\2\2\u0086\u0088\7$\2\2\u0087r\3\2\2\2\u0087u\3\2\2\2\u0087x\3\2\2\2"+
		"\u0087{\3\2\2\2\u0087~\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0084\3\2\2\2"+
		"\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\t\3"+
		"\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\t\5\2\2\u008d\13\3\2\2\2\f\17\27"+
		"\'ALU]p\u0087\u0089";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}