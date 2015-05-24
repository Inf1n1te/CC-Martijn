package pp.block4.cc.cfg;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.AddExprContext;
import pp.block4.cc.cfg.FragmentParser.AssignStatContext;
import pp.block4.cc.cfg.FragmentParser.BlockStatContext;
import pp.block4.cc.cfg.FragmentParser.BreakStatContext;
import pp.block4.cc.cfg.FragmentParser.ContStatContext;
import pp.block4.cc.cfg.FragmentParser.DeclContext;
import pp.block4.cc.cfg.FragmentParser.IfStatContext;
import pp.block4.cc.cfg.FragmentParser.PrintStatContext;
import pp.block4.cc.cfg.FragmentParser.ProgramContext;
import pp.block4.cc.cfg.FragmentParser.StatContext;
import pp.block4.cc.cfg.FragmentParser.WhileStatContext;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Template bottom-up CFG builder.
 */
public class BottomUpCFGBuilder extends FragmentBaseListener {
	/**
	 * The CFG being built.
	 */
	private Graph graph;
	
	private ParseTreeProperty<Node[]> nodes = new ParseTreeProperty<Node[]>();

	/**
	 * Main method to build and print the CFG of a simple Java program.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [filename]+");
			return;
		}
		BottomUpCFGBuilder builder = new BottomUpCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}

	/**
	 * Builds the CFG for a program contained in a given file.
	 */
	public Graph build(File file) {
		Graph result = null;
		ErrorListener listener = new ErrorListener();
		try {
			CharStream chars = new ANTLRInputStream(new FileReader(file));
			Lexer lexer = new FragmentLexer(chars);
			lexer.removeErrorListeners();
			lexer.addErrorListener(listener);
			TokenStream tokens = new CommonTokenStream(lexer);
			FragmentParser parser = new FragmentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(listener);
			ParseTree tree = parser.program();
			if (listener.hasErrors()) {
				System.out.printf("Parse errors in %s:%n", file.getPath());
//				listener.getErrors().forEach(System.err::println);
			} else {
				result = build(tree);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Builds the CFG for a program given as an ANTLR parse tree.
	 */
	public Graph build(ParseTree tree) {
		this.graph = new Graph();
		new ParseTreeWalker().walk(this, tree);

		return graph;
	}
	
	@Override
	public void exitProgram(ProgramContext ctx) {
		for (int i = 0; i < ctx.stat().size() - 1; i++) {
			Node[] stat1 = nodes.get(ctx.stat(i));
			Node[] stat2 = nodes.get(ctx.stat(i + 1));
			stat1[1].addEdge(stat2[0]);
			
		}
	}
	@Override
	public void exitDecl(DeclContext ctx) {
		Node n = addNode(ctx, "decl");
		nodes.put(ctx, new Node[] {n,n});
	}
	
	
	@Override
	public void exitAssignStat(AssignStatContext ctx) {
		Node n = addNode(ctx, "assign");
		nodes.put(ctx, new Node[] {n,n});
	}
	
	@Override
	public void exitIfStat(IfStatContext ctx) {
		Node exprNode = addNode(ctx.expr(), "ifStat");
		Node ifExit = addNode(ctx, "ifExit");
		for (StatContext s : ctx.stat()) {
			Node thenelse[] = nodes.get(s);
			exprNode.addEdge(thenelse[0]);
			thenelse[1].addEdge(ifExit);
		}
		if (ctx.stat().size() < 2) {
			exprNode.addEdge(ifExit);
		}
		
		nodes.put(ctx, new Node [] { exprNode, ifExit });
	}
	

	@Override
	public void exitWhileStat(WhileStatContext ctx) {
		Node exprNode = addNode(ctx.expr(), "whileStat");
		Node[] whileNode = nodes.get(ctx.stat());
		exprNode.addEdge(whileNode[0]);
		whileNode[1].addEdge(exprNode);
		Node exitNode = addNode(ctx.expr(), "whileExit");
		exprNode.addEdge(exitNode);
		nodes.put(ctx, new Node [] { exprNode, exitNode });
	}
	
	@Override
	public void exitBlockStat(BlockStatContext ctx) {
		for (int i = 0; i < ctx.stat().size() - 1; i++) {
			Node[] stat1 = nodes.get(ctx.stat(i));
			Node[] stat2 = nodes.get(ctx.stat(i + 1));
			System.out.println(stat1 + " |\n " + ctx.stat(i).getText());
			System.out.println(stat2 + " " + ctx.stat(i + 1).getText());
			stat1[1].addEdge(stat2[0]);
		}
		nodes.put(ctx, new Node[] {nodes.get(ctx.stat(0))[0], nodes.get(ctx.stat(ctx.stat().size() - 1))[1]});
	}
	
	@Override
	public void exitPrintStat(PrintStatContext ctx) {
		Node n = addNode(ctx, "print");
		nodes.put(ctx, new Node[] {n,n});
	}
	@Override
	public void exitBreakStat(BreakStatContext ctx) {
		Node n = addNode(ctx, "break");
		Node exit = nodes.get(ctx.getParent())[1];
		n.addEdge(exit);
		nodes.put(ctx, new Node[] {n,exit});
	}
	
	@Override
	public void exitContStat(ContStatContext ctx) {
		Node n = addNode(ctx, "cont");
		Node exit = nodes.get(ctx.getParent())[0];
		n.addEdge(exit);
		nodes.put(ctx, new Node[] {n,exit});
	}
	
	private void simpleExpr(ParserRuleContext ctx) {
		Node n = addNode(ctx, "simple");
		nodes.put(ctx, new Node[] {n,n});
	}
	

	/**
	 * Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(node.getStart().getLine() + ": " + text);
	}
}
