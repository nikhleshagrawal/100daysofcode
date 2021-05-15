package io.practise.algo;

public class PrimeNumber {
	static void isPrime(int n) {

		if (n == 1 || n == 0) {
			System.out.println("Not prime");
			return;
		}

		boolean flag = false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Not prime");
		} else {
			System.out.println("Prime");
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400, 441, 484,
				529, 576, 625, 676, 729, 784, 841, 907 };
		for (int i = 0; i < a.length; i++) {
			isPrime(a[i]);
		}
	}
}
