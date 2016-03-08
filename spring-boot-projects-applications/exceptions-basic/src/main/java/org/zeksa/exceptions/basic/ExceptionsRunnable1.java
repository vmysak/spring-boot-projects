package org.zeksa.exceptions.basic;

public class ExceptionsRunnable1 {

	public static void main(String[] args) {
		int result = f1();

		System.out.println(result);
		System.out.println("*");
	}

	private static int f1() {
		try {
			return 1;
		} finally {
			System.out.println(2);
		}
	}
}
