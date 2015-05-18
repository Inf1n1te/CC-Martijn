package pp.block3.cc.symbol;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.block3.cc.symbol.DeclUseParser.*;


public class DeclUseConverter extends DeclUseBaseListener {

	List<Error> errors = new LinkedList<Error>();
	MySymbolTable symbolTable = new MySymbolTable();
	
	public void init() {
		errors = new LinkedList<Error>();
		symbolTable = new MySymbolTable();
	}
	
	public List<Error> parse(Lexer lexer) {
		DeclUseParser parser = new DeclUseParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.program();
		new ParseTreeWalker().walk(this, tree);
		return errors;
	}
	
	@Override
	public void enterSeries(SeriesContext ctx) {
		symbolTable.openScope();
	}
	
	@Override
	public void exitSeries(SeriesContext ctx) {
		symbolTable.closeScope();
	}
	
	public void enterDecl(DeclContext ctx) {
		symbolTable.add(ctx.ID().getText());
	};
	
	@Override
	public void enterUse(UseContext ctx) {
		if (!symbolTable.contains(ctx.ID().getText())) {
			errors.add(new Error(ctx.getText() + " not declared", 
					ctx.ID().getSymbol().getLine(), 
					ctx.ID().getSymbol().getCharPositionInLine()));
		}
	}
	
	@Override
	public void visitErrorNode(ErrorNode node) {
		errors.add(new Error(node.getText(), node.getSymbol().getLine(), node.getSymbol().getCharPositionInLine()));
	}
	public class Error {
		public String text;
		public int line;
		public int row;
		
		public Error(String text, int line, int row) {
			this.text = text;
			this.line = line;
			this.row = row;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Error) {
				return ((Error)obj).text == this.text && ((Error)obj).line == this.line && ((Error)obj).row == this.row;
			} else {
				return false;
			} 
		} 
		@Override
		public String toString() {
			return text + " " + line + " " + row;
		}
	}
}


