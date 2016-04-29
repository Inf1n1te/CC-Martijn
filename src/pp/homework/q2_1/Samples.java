package pp.homework.q2_1;

/** Example code snippets for control flow graph generation. */
public class Samples {
	/** Find example with break statement, used in q2_1. */
	public void findBreak() {
		int[] a = { 0, 2, 4, 1 };
		int x = in();
		int i;
		for (i = 0; i < a.length; i = i + 1) {
			if (a[i] == x) {
				break;
			}
		}
		printf("Index: %d%n", i);
	}

	private int in() {
		int result;
		String line = System.console().readLine("Input? ");
		try {
			result = Integer.parseInt(line);
		} catch (RuntimeException exc) {
			result = 0;
		}
		return result;
	}

	private void printf(String format, Object... args) {
		System.out.printf(format, args);
	}
}
