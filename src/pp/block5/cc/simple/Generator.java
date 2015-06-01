package pp.block5.cc.simple;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block5.cc.pascal.ArrayPascalParser.VarContext;
import pp.block5.cc.pascal.SimplePascalBaseVisitor;
import pp.block5.cc.pascal.SimplePascalParser.AssStatContext;
import pp.block5.cc.pascal.SimplePascalParser.BlockContext;
import pp.block5.cc.pascal.SimplePascalParser.BlockStatContext;
import pp.block5.cc.pascal.SimplePascalParser.BodyContext;
import pp.block5.cc.pascal.SimplePascalParser.IfStatContext;
import pp.block5.cc.pascal.SimplePascalParser.ParExprContext;
import pp.block5.cc.pascal.SimplePascalParser.ProgramContext;
import pp.block5.cc.pascal.SimplePascalParser.StatContext;
import pp.block5.cc.pascal.SimplePascalParser.VarDeclContext;
import pp.iloc.Simulator;
import pp.iloc.model.Label;
import pp.iloc.model.Num;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;
import pp.iloc.model.Reg;
/** Class to generate ILOC code for Simple Pascal. */
public class Generator extends SimplePascalBaseVisitor<Op> {
	/** The representation of the boolean value <code>false</code>. */
	public final static Num FALSE_VALUE = new Num(Simulator.FALSE);
	/** The representation of the boolean value <code>true</code>. */
	public final static Num TRUE_VALUE = new Num(Simulator.TRUE);

	/** The base register. */
	private Reg arp = new Reg("r_arp");
	/** The outcome of the checker phase. */
	private Result checkResult;
	/** Association of statement nodes to labels. */
	private ParseTreeProperty<Label> labels;
	/** The program being built. */
	private Program prog;
	/** Register count, used to generate fresh registers. */
	private int regCount;
	/** Association of expression and target nodes to registers. */
	private ParseTreeProperty<Reg> regs;

	public Program generate(ParseTree tree, Result checkResult) {
		this.prog = new Program();
		this.checkResult = checkResult;
		this.regs = new ParseTreeProperty<>();
		this.labels = new ParseTreeProperty<>();
		this.regCount = 0;
		tree.accept(this);
		return this.prog;
	}

	// Override the visitor methods
//	
//	@Override
//	public Op visitVar(pp.block5.cc.pascal.SimplePascalParser.VarContext ctx) {
//		for (TerminalNode id : ctx.ID()) {
//			emit(OpCode.loadI, arp, offset(ctx), reg(ctx));
//		}
//		return null;
//	}
	
	@Override
	public Op visitProgram(ProgramContext ctx) {
		return visit(ctx.body());
	}
	
	@Override
	public Op visitBody(BodyContext ctx) {
		return visit(ctx.block());
	}
	
	@Override
	public Op visitBlockStat(BlockStatContext ctx) {
		return visit(ctx.block());
	}
	
	@Override
	public Op visitBlock(BlockContext ctx) {
		Op result = visit(ctx.stat(0));
		
		for (int i = 1; i < ctx.stat().size(); i++) {
			visit(ctx.stat(i));
		}
		
		return result;
	}
	
	@Override
	public Op visitAssStat(AssStatContext ctx) {
		visit(ctx.expr());
		return emit(OpCode.storeAI, reg(ctx.expr()), arp, offset(ctx.target()));
	}
	
	@Override
	public Op visitIfStat(IfStatContext ctx) {
		visit(ctx.expr());
		Label then = createLabel(ctx.stat(0), "then");
		Label end = createLabel(ctx, "endLabel");
		if (ctx.stat().size() > 1) {
			emit(OpCode.cbr, reg(ctx.expr()), then, createLabel(ctx.stat(1), "else"));
			visit(ctx.stat(0));
			
			visit(ctx.stat(1));
		} else {
			
			emit(OpCode.cbr, reg(ctx.expr()), then, end);
			visit(ctx.stat(0));
		}
		
		emit(end, OpCode.nop);
		
	}
	
	
	
	
	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(Label label, OpCode opCode, Operand... args) {
		Op result = new Op(label, opCode, args);
		this.prog.addInstr(result);
		return result;
	}

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(OpCode opCode, Operand... args) {
		return emit((Label) null, opCode, args);
	}

	/** 
	 * Looks up the label for a given parse tree node,
	 * creating it if none has been created before.
	 * The label is actually constructed from the entry node
	 * in the flow graph, as stored in the checker result.
	 */
	private Label label(ParserRuleContext node) {
		Label result = this.labels.get(node);
		if (result == null) {
			ParserRuleContext entry = this.checkResult.getEntry(node);
			result = createLabel(entry, "n");
			this.labels.put(node, result);
		}
		return result;
	}

	/** Creates a label for a given parse tree node and prefix. */
	private Label createLabel(ParserRuleContext node, String prefix) {
		Token token = node.getStart();
		int line = token.getLine();
		int column = token.getCharPositionInLine();
		String result = prefix + "_" + line + "_" + column;
		return new Label(result);
	}

	/** Retrieves the offset of a variable node from the checker result,
	 * wrapped in a {@link Num} operand. */
	private Num offset(ParseTree node) {
		return new Num(this.checkResult.getOffset(node));
	}

	/** Returns a register for a given parse tree node,
	 * creating a fresh register if there is none for that node. */
	private Reg reg(ParseTree node) {
		Reg result = this.regs.get(node);
		if (result == null) {
			result = new Reg("r_" + this.regCount);
			this.regs.put(node, result);
			this.regCount++;
		}
		return result;
	}

	/** Assigns a register to a given parse tree node. */
	private void setReg(ParseTree node, Reg reg) {
		this.regs.put(node, reg);
	}
}
