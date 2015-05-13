package pp.block3.cc.symbol;

/**
 * Created by inf1n1te on 13-5-15.
 */
public class MySymbolTable implements SymbolTable {
	/**
	 * Adds a next deeper scope level.
	 */
	@Override
	public void openScope() {

	}

	/**
	 * Removes the deepest scope level.
	 *
	 * @throws RuntimeException if the table only contains the outer scope.
	 */
	@Override
	public void closeScope() {

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
		return false;
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
		return false;
	}
}
