package io.practise.hackerrank;

import java.util.Scanner;

public class Day6Problem1 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 3; int p =5;
		int n1 = 1;
		for(int i =1;i<=p;i++){
            n1 = n1 * n;
        }
		
		System.out.println(n1);
	}

}
