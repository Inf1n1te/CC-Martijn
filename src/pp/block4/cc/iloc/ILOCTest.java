package pp.block4.cc.iloc;

import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ILOCTest {


	public void testMax() {
		Program p = parse("src/pp/block4/cc/iloc/max");
		Simulator s = new Simulator(p);
		Machine vm = s.getVM();
		vm.init("a", 1, 2, 3, 4, 5, 6);
		vm.init("alength", 6);
		vm.setReg("r_arp", 0);
		s.run();
		System.out.println("R_MAX: " + vm.getReg("r_max"));
	}

	@Test
	public void testFib() {
		Program p = parse("src/pp/block4/cc/iloc/fib");
		Simulator s = new Simulator(p);
		Machine vm = s.getVM();
		vm.setNum("n", 2);
		s.run();
		System.out.println("R_FIB: " + vm.getReg("r_z"));
	}

	private Program parse(String filename) {
		File file = new File(filename + ".iloc");
		try {
			Program result = Assembler.instance().assemble(file);
			String print = result.prettyPrint();
			System.out.println("Program " + file + ":");
			System.out.print(print);
			Program other = Assembler.instance().assemble(print);
			assertEquals(result, other);
			return result;
		} catch (FormatException | IOException e) {
			fail(e.getMessage());
			return null;
		}
	}
}