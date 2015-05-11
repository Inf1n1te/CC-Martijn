package pp.block2.cc.antlr;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;
import pp.block2.cc.antlr.SentenceParser.ModSubjectContext;
import pp.block2.cc.antlr.SentenceParser.ModifierContext;
import pp.block2.cc.antlr.SentenceParser.ObjectContext;
import pp.block2.cc.antlr.SentenceParser.SentenceContext;
import pp.block2.cc.antlr.SentenceParser.SimpleSubjectContext;
import pp.block2.cc.antlr.SentenceParser.SubjectContext;
import pp.block2.cc.ll.AbcParser;
import pp.block2.cc.ll.Sentence;

public class SentenceConverter //
		extends SentenceBaseListener implements Parser {
	public SentenceConverter() {
		this.fact = new SymbolFactory(Sentence.class);
		error = false;
	}

	/** Factory needed to create terminals of the {@link Sentence}
	 * grammar. See {@link pp.block2.cc.ll.SentenceParser} for
	 * example usage. */
	private final SymbolFactory fact;
	
	private static final NonTerm SENT = new NonTerm("Sentence");
	private static final NonTerm SUBJ = new NonTerm("Subject");
	private static final NonTerm OBJ = new NonTerm("Object");
	private static final NonTerm MOD = new NonTerm("Modifier");
	private static final NonTerm ENDMARK = new NonTerm("Endmark");

	private AST sentence;
	private Map<ParseTree, AST> ASTs = new HashMap<ParseTree, AST>();
	private boolean error;

	private Lexer lexer;
	private AST process(String string) throws ParseException {
		Lexer lexer = new SentenceLexer(new ANTLRInputStream(string));
		return parse(lexer);
	}
	
	@Override
	public AST parse(Lexer lexer) throws ParseException {
		this.lexer = lexer;
		SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.sentence();
		new ParseTreeWalker().walk(this, tree);
		
		if (error) {
			throw new ParseException();
		}
		
		
		return sentence;
	}
	
	// From here on overwrite the listener methods
	// Use an appropriate ParseTreeProperty to
	// store the correspondence from nodes to ASTs
	
	@Override
	public void enterSentence(SentenceContext ctx) {
		//System.out.println(new ParseTreeProperty<>().get(ctx));
		ASTs.put(ctx, new AST(SENT));
		
	}
	@Override
	public void exitSentence(SentenceContext ctx) {
		AST sent = ASTs.get(ctx);
		for (int i = 0; i < ctx.getChildCount(); i++) {
			sent.addChild(ASTs.get(ctx.getChild(i)));
		}
		sentence = sent;
	};
	
	@Override
	public void enterModSubject(ModSubjectContext ctx) {
		ASTs.put(ctx, new AST(SUBJ));
	}
	@Override
	public void exitModSubject(ModSubjectContext ctx) {
		AST sent = ASTs.get(ctx);
		for (int i = 0; i < ctx.getChildCount(); i++) {
			sent.addChild(ASTs.get(ctx.getChild(i)));
		}
	}
	
	@Override
	public void enterSimpleSubject(SimpleSubjectContext ctx) {
		ASTs.put(ctx, new AST(SUBJ));
	}
	@Override
	public void exitSimpleSubject(SimpleSubjectContext ctx) {
		AST sent = ASTs.get(ctx);
		for (int i = 0; i < ctx.getChildCount(); i++) {
			sent.addChild(ASTs.get(ctx.getChild(i)));
		}
	}
	@Override
	public void enterObject(ObjectContext ctx) {
		ASTs.put(ctx, new AST(OBJ));
	}
	
	@Override
	public void exitObject(ObjectContext ctx) {
		AST sent = ASTs.get(ctx);
		for (int i = 0; i < ctx.getChildCount(); i++) {
			sent.addChild(ASTs.get(ctx.getChild(i)));
		}
	}
	
	@Override
	public void enterModifier(ModifierContext ctx) {
		ASTs.put(ctx, new AST(MOD));
	}
	
	@Override
	public void exitModifier(ModifierContext ctx) {
		AST sent = ASTs.get(ctx);
		for (int i = 0; i < ctx.getChildCount(); i++) {
			sent.addChild(ASTs.get(ctx.ADJECTIVE()));
		}
	}
	@Override
	public void visitErrorNode(ErrorNode node) {
		error = true;
	}
	
	@Override
	public void visitTerminal(TerminalNode node) {
		ASTs.put(node, new AST(new Term(node.getSymbol().getType(), lexer.getRuleNames()[node.getSymbol().getType()-1]), node.getSymbol()));
	}
	
	
	public static void main(String[] args) throws ParseException {
		SentenceConverter counter = new SentenceConverter();
		System.out.printf("Parse tree: %n%s%n",
				counter.process("students love students."));
		System.out.printf("Parse tree: %n%s%n",
				counter.process("all undergraduate students love all compilers."));
		System.out.printf("Parse tree: %n%s%n",
				counter.process("all smart students love all compilers"));
		System.out.printf("Parse tree: %n%s%n",
				counter.process("undergraduate students love love."));
		System.out.printf("Parse tree: %n%s%n",
				counter.process("all undergraduate students all compilers."));
		
	}

}
