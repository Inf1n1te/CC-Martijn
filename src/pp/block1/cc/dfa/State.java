package pp.block1.cc.dfa;

import java.util.Map;
import java.util.TreeMap;

/**
 * State of a DFA.
 */
public class State {
	static final public State ID6_DFA;
	static final public State DFA_LALA;

	static {
		ID6_DFA = new State(0, false);
		State id61 = new State(1, false);
		State id62 = new State(2, false);
		State id63 = new State(3, false);
		State id64 = new State(4, false);
		State id65 = new State(5, false);
		State id66 = new State(5, true);
		State[] states = {ID6_DFA, id61, id62, id63, id64, id65, id66};
		for (char c = 'a'; c < 'z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = 'A'; c < 'Z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = '0'; c < '9'; c++) {
			for (int s = 1; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
	}

	static {
		DFA_LALA = new State(0, false);
		State dfa1 = new State(1, false);
		State dfa2 = new State(2, true);
		State dfa3 = new State(3, true);
		State dfa4 = new State(4, false);
		State dfa5 = new State(5, true);
		State dfa6 = new State(6, true);
		State dfa7 = new State(7, false);
		State dfa8 = new State(8, false);
		State dfa9 = new State(9, false);
		State dfa10 = new State(10, false);
		State dfa11 = new State(11, true);
		State[] states = {DFA_LALA, dfa1, dfa2, dfa3, dfa4, dfa5, dfa6, dfa7, dfa8, dfa9, dfa10, dfa11};
		int[] l1 = new int[]{0,3,6,9};
		int[] l2 = new int[]{2,5,8};
		int[] a = new int[]{1,4,7};
		int[] ar = new int[]{2,5,8};
		int[] s = new int[]{2,5,8};
		int[] sr = new int[]{3,6,9,11};
		for (int i : l1){
			states[i].addNext('L', states[i+1]);
		}
		for (int i : l2){
			states[i].addNext('L', states[i+2]);
		}
		for (int i : a){
			states[i].addNext('a', states[i+1]);
		}
		for (int i : ar){
			states[i].addNext('a', states[i]);
		}
		for (int i : s){
			states[i].addNext(' ', states[i+1]);
		}
		for (int i : sr){
			states[i].addNext(' ', states[i]);
		}
		states[10].addNext('i', states[11]);
	}

	/**
	 * State number
	 */
	private final int nr;
	/**
	 * Flag indicating if this state is accepting.
	 */
	private final boolean accepting;
	/**
	 * Mapping to next states.
	 */
	private final Map<Character, State> next;

	/**
	 * Constructs a new, possibly accepting state with a given number. The
	 * number is meant to identify the state, but there is no check for
	 * uniqueness.
	 */
	public State(int nr, boolean accepting) {
		this.next = new TreeMap<>();
		this.nr = nr;
		this.accepting = accepting;
	}

	/**
	 * Returns the state number.
	 */
	public int getNumber() {
		return nr;
	}

	/**
	 * Indicates if the state is accepting.
	 */
	public boolean isAccepting() {
		return accepting;
	}

	/**
	 * Adds an outgoing transition to a next state. This overrides any previous
	 * transition for that character.
	 */
	public void addNext(Character c, State next) {
		this.next.put(c, next);
	}

	/**
	 * Indicates if there is a next state for a given character.
	 */
	public boolean hasNext(Character c) {
		return getNext(c) != null;
	}

	/**
	 * Returns the (possibly <code>null</code>) next state for a given
	 * character.
	 */
	public State getNext(Character c) {
		return next.get(c);
	}

	@Override
	public String toString() {
		String trans = "";
		for (Map.Entry<Character, State> out : next.entrySet()) {
			if (!trans.isEmpty()) {
				trans += ", ";
			}
			trans += "--" + out.getKey() + "-> " + out.getValue().getNumber();
		}
		return String.format("State %d (%s) with outgoing transitions %s", nr,
				accepting ? "accepting" : "not accepting", trans);
	}
}
