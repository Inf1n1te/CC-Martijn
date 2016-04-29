package pp.s1466895.q2_2;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.iloc.parse.ILOCBaseListener;
import pp.iloc.parse.ILOCListener;
import pp.iloc.parse.ILOCParser.CommentContext;
import pp.iloc.parse.ILOCParser.DeclContext;
import pp.iloc.parse.ILOCParser.InstrListContext;
import pp.iloc.parse.ILOCParser.LabelContext;
import pp.iloc.parse.ILOCParser.OpCodeContext;
import pp.iloc.parse.ILOCParser.OperandContext;
import pp.iloc.parse.ILOCParser.ProgramContext;
import pp.iloc.parse.ILOCParser.RealOpContext;
import pp.iloc.parse.ILOCParser.SingleInstrContext;
import pp.iloc.parse.ILOCParser.SourcesContext;
import pp.iloc.parse.ILOCParser.TargetsContext;

public class CFGGenerator extends ILOCBaseListener {

	public CFG parse() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDecl(DeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitDecl(DeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterSources(SourcesContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitSources(SourcesContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterInstrList(InstrListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitInstrList(InstrListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterComment(CommentContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitComment(CommentContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterRealOp(RealOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitRealOp(RealOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterOpCode(OpCodeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitOpCode(OpCodeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterSingleInstr(SingleInstrContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitSingleInstr(SingleInstrContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLabel(LabelContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitLabel(LabelContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTargets(TargetsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTargets(TargetsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterOperand(OperandContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitOperand(OperandContext ctx) {
		// TODO Auto-generated method stub

	}

}
