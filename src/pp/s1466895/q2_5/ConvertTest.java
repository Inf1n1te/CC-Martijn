package pp.s1466895.q2_5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

public class ConvertTest {

	public static void main(String[] args) {
		new ConvertTest().testConvert();;
	}
	
	private void testConvert() {
		Program p = parse("src/pp/s1466895/q2_5/convert");
		Simulator s = new Simulator(p);
		s.run();
	}

	private Program parse(String filename) {
		File file = new File(filename + ".iloc");
		try {
			Program result = Assembler.instance().assemble(file);
			return result;
		} catch (FormatException | IOException e) {
			fail(e.getMessage());
			return null;
		}
	}
}
