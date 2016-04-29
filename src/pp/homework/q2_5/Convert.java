package pp.homework.q2_5;

import java.util.Scanner;

public class Convert {
	public static void main(String[] args) {
		int num = in("Number? ");
		int base = in("Base? ");
		out("Length: ", convert(num, base));
	}

	public static int convert(int num, int base) {
		int rest = num / base;
		out("Next digit: ", num - base * rest);
		return rest == 0 ? 1 : convert(rest, base) + 1;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static int in(String message) {
		System.out.print(message);
		return scan.nextInt();
	}

	public static void out(String message, int val) {
		System.out.println(message + val);
	}
}
