package pp.s1466895.q2_2;

import java.util.ArrayList;

public class CFG {
	
	public class CFGNode {
		String label;
		ArrayList<CFGNode> nodes;
		
		public CFGNode(String lbl) {
			label = lbl;
		}
		
		public CFGNode addLabel(CFGNode node) {
			nodes.add(node);
			return this;
		}
	}
}

