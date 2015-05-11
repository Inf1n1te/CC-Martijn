//package pp.block2.cc.ll;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import pp.block2.cc.NonTerm;
//import pp.block2.cc.Symbol;
//import pp.block2.cc.Term;
//
//public class MyLLCalc implements LLCalc {
//
//	private Grammar grammar;
//
//	public MyLLCalc(Grammar g) {
//		grammar = g;
//	}
//
//	@Override
//	public Map<Symbol, Set<Term>> getFirst() {
//		HashMap<Symbol, Set<Term>> first = new HashMap<Symbol, Set<Term>>();
//
//		for (Term t : grammar.getTerminals()) {
//			HashSet<Term> term = new HashSet<Term>();
//			term.add(t);
//			first.put(t, term);
//		}
//		HashSet<Term> term1 = new HashSet<Term>();
//		term1.add(Symbol.EOF);
//		first.put(Symbol.EOF, term1);
//
//		HashSet<Term> term2 = new HashSet<Term>();
//		term2.add(Symbol.EMPTY);
//		first.put(Symbol.EMPTY, term2);
//
//		for (NonTerm nt : grammar.getNonterminals()) {
//			first.put(nt, new HashSet<Term>());
//		}
//
//		boolean change = true;
//		while (change) {
//			change = false;
//
//		}
//		System.out.println(first);
//		return first;
//	}
//
//	private Map<Rule, Set<Term>> getRuleFirsts() {
//		Map<Rule, Set<Term>> first = new HashMap<Rule, Set<Term>>();
//		for (Rule rule : grammar.getRules()) {
//			List<Symbol> ruleRHS = rule.getRHS();
//			HashSet<Term> rhs = new HashSet<Term>();
//			rhs.addAll(first.get(ruleRHS.get(0)));
//			rhs.remove(Symbol.EMPTY);
//			int i = 0;
//			while(i < ruleRHS.size()-1 && first.get(ruleRHS.get(i)).contains(Symbol.EMPTY)) {
//				rhs.addAll(first.get(ruleRHS.get(i+1)));
//				rhs.remove(Symbol.EMPTY);
//				i++;
//			}
//			if (first.get(ruleRHS.get(i)).contains(Symbol.EMPTY) && first.get(ruleRHS.get(i-1)).contains(Symbol.EMPTY)) {
//				rhs.add(Symbol.EMPTY);
//			}
//
//			if (!first.get(rule).containsAll(rhs)) {
//				change = true;
//				first.get(rule).addAll(rhs);
//			}
//		}
//
//	}
//
//	@Override
//	public Map<NonTerm, Set<Term>> getFollow() {
//		HashMap<NonTerm, Set<Term>> follow = new HashMap<NonTerm, Set<Term>>();
//
//		for (NonTerm nt : grammar.getNonterminals()) {
//			follow.put(nt, new HashSet<Term>());
//		}
//		follow.get(grammar.getStart()).add(Symbol.EOF);
//		boolean change = true;
//		while (change) {
//			change = false;
//			for (Rule rule : grammar.getRules()) {
//				List<Symbol> rhs = rule.getRHS();
//				Set<Term> trailer = follow.get(rule.getLHS());
//				for (int i = rhs.size() - 1; i >= 0; i--) {
//					if (rhs.get(i) instanceof NonTerm) {
//						if (!follow.get(rhs.get(i)).containsAll(trailer)) {
//							follow.get(rhs.get(i)).addAll(trailer);
//							change = true;
//						}
//						if (getFirst().get(rhs.get(i)).contains(Symbol.EMPTY)) {
//							trailer.addAll(getFirst().get(rhs.get(i)));
//							trailer.remove(Symbol.EMPTY);
//						} else {
//							trailer = getFirst().get(rhs.get(i));
//						}
//					} else {
//						trailer = getFirst().get(rhs.get(i));
//					}
//				}
//			}
//		}
//		return follow;
//	}
//
//	@Override
//	public Map<Rule, Set<Term>> getFirstp() {
//		HashMap<Rule, Set<Term>> firstp = new HashMap<Rule, Set<Term>>();
//		Map<Symbol, Set<Term>> first = getFirst();
//		for (Rule r : grammar.getRules()) {
//			firstp.put(r, first.get(r.getLHS()));
//			if (first.get(r.getLHS()).contains(Symbol.EMPTY)) {
//				firstp.put(r, getFollow().get(r.getLHS()));
//			}
//		}
//		return firstp;
//	}
//
//	@Override
//	public boolean isLL1() {
//		Map<Rule, Set<Term>> firstp = getFirstp();
//		HashMap <NonTerm, List<Symbol>> firstpconcat = new HashMap <NonTerm, List<Symbol>>();
//
//		getFirst
//	}
//
//}
