package pp.block5.cc.simple;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import pp.block5.cc.pascal.SimplePascalBaseVisitor;
import pp.block5.cc.pascal.SimplePascalParser;
import pp.block5.cc.pascal.SimplePascalParser.*;
import pp.iloc.Simulator;
import pp.iloc.model.*;

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
		Op result = visit(ctx.expr());
		Label end = createLabel(ctx, "ifend");
		Label then = createLabel(ctx, "then");
		if (ctx.stat().size() > 1) {
			Label elseL = createLabel(ctx, "else");
			emit(OpCode.cbr, reg(ctx.expr()), then, elseL);
			emit(then, OpCode.nop);
			visit(ctx.stat(0));
			emit(OpCode.jumpI, end);
			emit(elseL, OpCode.nop);
			visit(ctx.stat(1));
		} else {
			emit(OpCode.cbr, reg(ctx.expr()), then, end);
			emit(then, OpCode.nop);
			visit(ctx.stat(0));
		}
		emit(end, OpCode.nop);
		return result;
	}

	@Override
	public Op visitWhileStat(@NotNull SimplePascalParser.WhileStatContext ctx) {
//<<<<<<< HEAD
	//	Op result = visit(ctx.expr());
	//	Label end = createLabel(ctx, "whileend");
	//	Label whileBegin = createLabel(ctx, "whilebegin");
	//	result.setLabel(whileBegin);
	//	emit(OpCode.cbr, reg(ctx.expr()), whileBegin, end);
//=======
		Label begin = createLabel(ctx, "begin");
		Label body = createLabel(ctx, "body");
		Label end = createLabel(ctx, "end");

		emit(begin, OpCode.nop);

		Op result = visit(ctx.expr());
//		result.setLabel(begin);

		emit(OpCode.cbr, reg(ctx.expr()), body, end);

		emit(body, OpCode.nop);
//>>>>>>> f1ec579d82a186ab97eb983ec42b54784fb31b9f
		visit(ctx.stat());

		emit(OpCode.jumpI, begin);
		emit(end, OpCode.nop);
		return result;
	}

	@Override
	public Op visitInStat(@NotNull SimplePascalParser.InStatContext ctx) {
		String input = ctx.STR().getText().replaceAll("\"", "");
		Op result = emit(OpCode.in, new Str(input), reg(ctx));
		emit(OpCode.storeAI, reg(ctx), arp, offset(ctx.target()));
		return result;
	}
	
	@Override
	public Op visitOutStat(OutStatContext ctx) {
		String str = ctx.STR().getText().replaceAll("\"", "");
		visit(ctx.expr());
		return emit(OpCode.out, new Str(str), reg(ctx.expr()));
	}
	
	@Override
	public Op visitPrfExpr(PrfExprContext ctx) {
		Op result;
		visit(ctx.expr());
		if (ctx.prfOp().NOT() != null) {
			result = emit(OpCode.xorI, reg(ctx.expr()), TRUE_VALUE, reg(ctx));
		} else {
			result = emit(OpCode.multI, reg(ctx.expr()), new Num(-1), reg(ctx));
		}
		return result;
	}
	
	@Override
	public Op visitPlusExpr(PlusExprContext ctx) {
		Op result;
		visit(ctx.expr(0)); visit(ctx.expr(1));
		if (ctx.plusOp().PLUS() != null) {
			result = emit(OpCode.add, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		} else {
			result = emit(OpCode.sub, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}
		return result;
	}
	
	@Override
	public Op visitMultExpr(MultExprContext ctx) {
		Op result;
		visit(ctx.expr(0)); visit(ctx.expr(1));
		if (ctx.multOp().STAR() != null) {
			result = emit(OpCode.mult, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		} else {
			result = emit(OpCode.div, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}
		return result;
	}
	
	@Override
	public Op visitBoolExpr(BoolExprContext ctx) {
		Op result;
		visit(ctx.expr(0)); visit(ctx.expr(1));
		if (ctx.boolOp().AND() != null) {
			result = emit(OpCode.and, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		} else {
			result = emit(OpCode.or, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}
		return result;
	}
	
	@Override
	public Op visitCompExpr(CompExprContext ctx) {
		Op result = null;
		visit(ctx.expr(0)); visit(ctx.expr(1));
		switch (ctx.compOp().getStart().getType()) {
		case SimplePascalParser.LE:
			result = emit(OpCode.cmp_LE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
			break;
		case SimplePascalParser.LT:
			result = emit(OpCode.cmp_LT, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
			break;
		case SimplePascalParser.GE:
			result = emit(OpCode.cmp_GE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
			break;
		case SimplePascalParser.GT:
			result = emit(OpCode.cmp_GT, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
			break;
		case SimplePascalParser.EQ:
			result = emit(OpCode.cmp_EQ, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
			break;
		case SimplePascalParser.NE:
			result = emit(OpCode.cmp_NE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
			break;
		default:
			break;
		}
		return result;
	}
	
	@Override
	public Op visitParExpr(ParExprContext ctx) {
		setReg(ctx, reg(ctx.expr()));
		return visit(ctx.expr());
	}
	
	@Override
	public Op visitIdExpr(IdExprContext ctx) {
		return emit(OpCode.loadAI, arp, offset(ctx), reg(ctx));
	}
	
	@Override
	public Op visitNumExpr(NumExprContext ctx) {
		return emit(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), reg(ctx));
	}
	
	@Override
	public Op visitTrueExpr(TrueExprContext ctx) {
		return emit(OpCode.loadI, TRUE_VALUE, reg(ctx));
	}
	
	@Override
	public Op visitFalseExpr(FalseExprContext ctx) {
		return emit(OpCode.loadI, FALSE_VALUE, reg(ctx));
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
		return emit(null, opCode, args);
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
