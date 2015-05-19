package pp.block3.cc.tabular;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block3.cc.symbol.DeclUseParser;
import pp.block3.cc.tabular.TabularParser.ColContext;
import pp.block3.cc.tabular.TabularParser.LastcolContext;
import pp.block3.cc.tabular.TabularParser.RowContext;
import pp.block3.cc.tabular.TabularParser.TableContext;

public class HTMLGenerator extends TabularBaseListener {
	
	String htmlfile = "";
	
	public String parse(String filename){
		TabularLexer lexer;
		try {
			lexer = new TabularLexer(new ANTLRFileStream(filename));
			TabularParser parser = new TabularParser(new CommonTokenStream(lexer));
			lexer.removeErrorListeners();
			TabularErrorListener tel = new TabularErrorListener();
			lexer.addErrorListener(tel);
			ParseTree tree = parser.table();
			new ParseTreeWalker().walk(this, tree);
			
			if (tel.hasErrors()) {
				htmlfile = null;
			}
		} catch (IOException e) {
			htmlfile = null;
		} 
		return htmlfile;
	}
	
	
	@Override
	public void enterTable(TableContext ctx) {
		htmlfile += "<html>\n<body>\n<table border = \"1\">\n";
	}
	
	@Override
	public void exitTable(TableContext ctx) {
		htmlfile += "</table>\n</body>\n</html>";
	}
	
	@Override
	public void enterRow(RowContext ctx) {
		htmlfile += "<tr>\n";
	}
	
	@Override
	public void exitRow(RowContext ctx) {
		htmlfile += "</tr>\n";
	}
	
	@Override
	public void enterCol(ColContext ctx) {
		htmlfile += "<td>";
	}
	
	@Override
	public void exitCol(ColContext ctx) {
		htmlfile += "</td>";
	}
	
	@Override
	public void enterLastcol(LastcolContext ctx) {
		htmlfile += "<td>";
	}
	
	@Override
	public void exitLastcol(LastcolContext ctx) {
		htmlfile += "</td>";
	}
	
	@Override
	public void visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == TabularParser.STRING) {
			htmlfile += node.getText();
		}
	}
	
	
	
	public static void main(String[] args) {
		if (args.length >= 2) {
			HTMLGenerator generator = new HTMLGenerator();
			String output = generator.parse(args[0]);
			if (output != null) {
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
					
					
					out.write(output);
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Usage: inputfile outputfile");
		}
	}
	
}
