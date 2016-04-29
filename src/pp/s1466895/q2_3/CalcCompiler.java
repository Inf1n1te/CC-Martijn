package pp.s1466895.q2_3;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.homework.ErrorListener;
import pp.homework.q2_3.CalcBaseListener;
import pp.homework.q2_3.CalcLexer;
import pp.homework.q2_3.CalcParser;
import pp.homework.q2_3.CalcParser.CompleteContext;
import pp.homework.q2_3.CalcParser.MinusContext;
import pp.homework.q2_3.CalcParser.NumberContext;
import pp.homework.q2_3.CalcParser.ParContext;
import pp.homework.q2_3.CalcParser.PlusContext;
import pp.homework.q2_3.CalcParser.TimesContext;
import pp.iloc.Simulator;
import pp.iloc.model.Num;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;
import pp.iloc.model.Reg;
import pp.iloc.model.Str;

/** Compiler from Calc.g4 to stack-based ILOC. */
public class CalcCompiler extends CalcBaseListener {
	/** Calls the compiler, and simulates and prints the compiled program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [expr]+");
			return;
		}
		CalcCompiler compiler = new CalcCompiler();
		for (String expr : args) {
			System.out.println("Processing " + expr);
			Program prog = compiler.compile(expr);
			new Simulator(prog).run();
			System.out.println(prog.prettyPrint());
		}
	}

	/** Program under construction. */
	private Program prog;
	/** First of the two registers required. */
	private final Reg reg1 = new Reg("r_1");
	/** Second of the two registers required. */
	private final Reg reg2 = new Reg("r_2");

	/** Compiles a given expression string into an ILOC program. */
	public Program compile(String text) {
		Program result = null;
		ErrorListener listener = new ErrorListener();
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.complete();
		if (listener.hasErrors()) {
			System.out.printf("Parse errors in %s:%n", text);
			for (String error : listener.getErrors()) {
				System.err.println(error);
			}
		} else {
			result = compile(tree);
		}
		return result;
	}

	/** Compiles a given Calc-parse tree into an ILOC program. */
	public Program compile(ParseTree tree) {
		this.prog = new Program();
		new ParseTreeWalker().walk(this, tree);
		return this.prog;
	}
	
	@Override
	public void exitNumber(NumberContext ctx) {
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUMBER().getText())), reg1);
		emit(OpCode.push, reg1);
	}
	
	@Override
	public void exitMinus(MinusContext ctx) {
		emit(OpCode.pop, reg1);
		emit(OpCode.rsubI, reg1, new Num(0), reg2);
		emit(OpCode.push, reg2);
	}
	
	@Override
	public void exitPlus(PlusContext ctx) {
		emit(OpCode.pop, reg1);
		emit(OpCode.pop, reg2);
		emit(OpCode.add, reg1, reg2, reg2);
		emit(OpCode.push, reg2);
	}
	
	@Override
	public void exitTimes(TimesContext ctx) {
		emit(OpCode.pop, reg1);
		emit(OpCode.pop, reg2);
		emit(OpCode.mult, reg1, reg2, reg2);
		emit(OpCode.push, reg2);
	}
	
	@Override
	public void exitPar(ParContext ctx) {
		
	}

	@Override
	public void exitComplete(CompleteContext ctx) {
		emit(OpCode.pop, reg1);
		emit(OpCode.out, new Str("Outcome: "), reg1);
	}

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(OpCode opCode, Operand... args) {
		Op result = new Op(opCode, args);
		this.prog.addInstr(result);
		return result;
	}
}
