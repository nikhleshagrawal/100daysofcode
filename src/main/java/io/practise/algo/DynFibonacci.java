package io.practise.algo;

import java.util.HashMap;
import java.util.Map;

public class DynFibonacci {

	public static int fib(int n, Map<Integer, Integer> mem) {
		if (mem != null && mem.get(n) != null) {
			return mem.get(n);
		}

		if (n <= 2) {
			return 1;
		}
		
		mem.put(n, fib(n - 1, mem) + fib(n - 2, mem));

		return mem.get(n);
	}
	
	public static int fib(int n) {
		if (n <= 2) {
			return 1;
		}

		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(fib(10, new HashMap<Integer, Integer>()));
		System.out.println(fib(10));

	}

}
