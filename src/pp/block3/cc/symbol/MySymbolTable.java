package pp.block3.cc.symbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

public class MySymbolTable implements SymbolTable {

    private Map<String, Object> global = new HashMap<String, Object>();
    private Stack<Map<String, Object>> stack = new Stack<Map<String, Object>>();


    /**
     * Adds a next deeper scope level.
     */
    @Override
    public void openScope() {
        stack.add(new HashMap<String, Object>());
    }

    /**
     * Removes the deepest scope level.
     *
     * @throws RuntimeException if the table only contains the outer scope.
     */
    @Override
    public void closeScope() {
        if (stack.size() == 1) {
            throw new RuntimeException("Cannot close outer scope");
        } else {
            stack.pop();
        }
    }

    /**
     * Tries to declare a given identifier in the deepest scope level.
     *
     * @param id
     * @return <code>true</code> if the identifier was added,
     * <code>false</code> if it was already declared in this scope.
     */
    @Override
    public boolean add(String id) {
        boolean isGood = false;
        if (!stack.isEmpty() && !stack.peek().containsKey(id)) {
            stack.peek().put(id, null);
            isGood = true;
        } else if (stack.isEmpty() && global.containsKey(id)) {
            global.put(id, null);
            isGood = true;
        }
        return isGood;
    }

    /**
     * Tests if a given identifier is in the scope of any declaration.
     *
     * @param id
     * @return <code>true</code> if there is any enclosing scope in which
     * the identifier is declared; <code>false</code> otherwise.
     */
    @Override
    public boolean contains(String id) {
        boolean contained = false;
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).containsKey(id)) {
                contained = true;
            }
        }
        contained = contained || global.containsKey(id);
        return contained;
    }
}
