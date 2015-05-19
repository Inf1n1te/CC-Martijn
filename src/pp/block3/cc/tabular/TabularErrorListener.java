package pp.block3.cc.tabular;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class TabularErrorListener extends BaseErrorListener {

	private boolean error = false;
	private List<String> errors = new LinkedList<String>();
	
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		
		
		errors.add(e.getLocalizedMessage() + "\n Error found at line "
		+ line + ", column " + charPositionInLine);
		error = true;
	}
	
	public boolean hasErrors() {
		return error;
	}
	
	public List<String> getAllErrors() {
		return errors;
	}
}
