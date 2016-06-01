package pp.block5.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.block5.cc.ErrorListener;
import pp.block5.cc.ParseException;
import pp.block5.cc.antlr.NumWordGroupParser.GroupContext;
import pp.block5.cc.antlr.NumWordGroupParser.NumberContext;
import pp.block5.cc.antlr.NumWordGroupParser.PenultimateGroupContext;
import pp.block5.cc.antlr.NumWordGroupParser.SentenceContext;
import pp.block5.cc.antlr.NumWordGroupParser.WordContext;

/** Prettyprints a (number, word)-sentence and adds the numbers. */
public class NumWordGroupProcessor extends NumWordGroupBaseListener {
	public static void main(String[] args) {
		NumWordGroupProcessor grouper = new NumWordGroupProcessor();
		if (args.length == 0) {
			process(grouper, "1sock2shoes 3 holes");
			process(grouper, "3 strands 10 blocks 11 weeks 15 credits");
			process(grouper, "1 2 3");
		} else {
			for (String text : args) {
				process(grouper, text);
			}
		}
	}

	private static void process(NumWordGroupProcessor grouper, String text) {
		try {
			System.out.printf("Processing '%s':%n", text);
			int result = grouper.group(text);
			System.out.println("Total: " + result);
		} catch (ParseException exc) {
			exc.print();
		}
	}

	/** Mapping from parse tree nodes to (sums of) numbers. */
	private ParseTreeProperty<Integer> values;
	
	private int total = 0;
	private String sentence = "";

	/** Groups a given sentence and prints it to stdout.
	 * Returns the sum of the numbers in the sentence.
	 */
	public int group(String text) throws ParseException {
		CharStream chars = new ANTLRInputStream(text);
		ErrorListener listener = new ErrorListener();
		Lexer lexer = new NumWordGroupLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		NumWordGroupParser parser = new NumWordGroupParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.sentence();
		listener.throwException();
		this.values = new ParseTreeProperty<>();
		new ParseTreeWalker().walk(this, tree);
		return this.values.get(tree);
	}

	@Override
	public void exitGroup(GroupContext ctx) {
		sentence += ", ";
	}
	
	@Override
	public void exitPenultimateGroup(PenultimateGroupContext ctx) {
		sentence += " and ";
	}
	@Override
	public void exitWord(WordContext ctx) {
		sentence += ctx.getText() + " ";
	}
	
	@Override
	public void exitNumber(NumberContext ctx) {
		total += Integer.parseInt(ctx.getText());
		sentence += ctx.getText();
	}
	
	@Override
	public void enterSentence(SentenceContext ctx) {
		total = 0;
	}
	
	@Override
	public void exitSentence(SentenceContext ctx) {
		values.put(ctx, total);
	}
}
