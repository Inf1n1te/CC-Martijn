package pp.s1466895.q2_2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import pp.iloc.Assembler;
import pp.iloc.model.Instr;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

public class ILOC2CFG {
	/** The singleton instance of this class. */
	private static final ILOC2CFG instance = new ILOC2CFG();

	/** Returns the singleton instance of this class. */
	public static ILOC2CFG instance() {
		return instance;
	}

	/** Converts an ILOC file given as parameter and prints out the
	 * resulting CFG. 
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: filename");
		}
		try {
			Program prog = Assembler.instance().assemble(new File(args[0]));
			System.out.println(instance().convert(prog));
		} catch (FormatException | IOException exc) {
			exc.printStackTrace();
		}
	}

	/** Private constructor for the singleton instance. */
	private ILOC2CFG() {
		// empty by design
	}

	public Graph convert(Program prog) {
		// TODO: Fill in
		List<Instr> instructions = prog.getInstr();
		
		Graph graph = new Graph();
		
		Node lastNode = null;
		for (Instr line : instructions) {
			
			if (line.hasLabel()) {
				Node dest = getNode(line.getLabel().getValue()); 
				if (dest == null) {
					
					dest = new Node(line.getLine(), 
							line.getLabel().getValue());
					nodeheap.put(line.getLabel().getValue(), dest);
				}
				lastNode = dest;
			}
			
			Iterator<Op> lineIter = line.iterator();
			Op instruction = lineIter.next(); 
			//has only 1 element
			if (instruction.getOpCode() == OpCode.jumpI) {
				
				
				Node dest = getNode(instruction.getArgs().get(0).toString()); 
				if (dest == null) {
					nodeheap.put(instruction.getArgs().get(0).toString(), 
							new Node(0, instruction.getArgs().get(0).toString()));
				}
				lastNode.addEdge(dest);
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
		return graph;
//		throw new UnsupportedOperationException();
	}
	
	HashMap<String, Node> nodeheap = new HashMap<String, Node>();
	
	private Node getNode(String label) {
		return nodeheap.get(label);
	}
}
