package tes.fibbonaci;

import java.util.HashMap;

class Fibbonaci {
	static int fib(int n) {
		HashMap<Integer, Integer> memo = new HashMap<>();

		if (n <= 1)
			return n;

		if (!memo.containsValue(n)) {
			memo.put(n, fib(n - 1) + fib(n - 2));
		}
		return memo.get(n);
	}

	static int factorial(int n) {
		if (n <= 1)
			return n;
		return n * factorial(n - 1);
	}

	public static void main(String args[]) {
		int n = 5;
		System.out.println(fib(n));
		System.out.println(factorial(3));
	}
}