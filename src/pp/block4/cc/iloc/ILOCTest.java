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

	//	@Test
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
		int[] testValues = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 44, 45/*,46*/};
		int[] testResults = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 1134903170, 1836311903/*,2971215073*/};
		for (int i = 0; i < testValues.length; i++) {
			assertEquals(testResults[i], testFibMem(testValues[i]));
			assertEquals(testResults[i], testFibReg(testValues[i]));
		}
	}

	private int testFibReg(int input) {
		Program p = parse("src/pp/block4/cc/iloc/fib_reg");
		Simulator s = new Simulator(p);
		Machine vm = s.getVM();
		vm.setNum("n", input);
		s.run();
		System.out.println("R_FIB: " + vm.getReg("r_z"));
		return vm.getReg("r_z");
	}

	private int testFibMem(int input) {
		Program p = parse("src/pp/block4/cc/iloc/fib_mem");
		Simulator s = new Simulator(p);
		Machine vm = s.getVM();
		vm.init("x", 1);
		vm.init("y", 1);
		vm.init("z", 1);
		vm.init("n", input);
		vm.setReg("r_arp", 0);
		s.run();
		System.out.println("R_FIB: " + vm.getReg("r_z"));
		return vm.getReg("r_z");
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