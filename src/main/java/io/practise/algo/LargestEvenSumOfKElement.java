package io.practise.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestEvenSumOfKElement {

	public static void main(String[] args) {
		//int arr[] = { 64, 25, 12, 22, 11, 2, 4, 5 };
		//int arr[] = { 2, 4, 10, 3, 5 };
		int arr[] = { 7,7,7,7 };
		//int arr[] = { 4,9,8,2,6 };
		//int arr[] = { 5,6,3,4,2 };
		int k = 4;
		System.out.println(maxEvenSumOfKElement(arr,k));

	}
	
	public static int maxEvenSumOfKElement(int arr[], int k) {
		//edge case , when k > length of the array return -1
		if(k>arr.length) {
			return -1;
		}
		
		//Step 1: Create even and odd list
		List<Integer> even = new ArrayList<Integer>();
		List<Integer> odd = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even.add(arr[i]);
			} else {
				odd.add(arr[i]);
			}
		}

		//Step 2: Sort desc even and odd list
		int[] newEven = sort(toIntArray(even));
		int[] newodd = sort(toIntArray(odd));

		System.out.println(Arrays.toString(newEven));
		System.out.println(Arrays.toString(newodd));

		//sum of even numbers is even
		// sum of even numbers of odd numbers is even
		// sum of even numbers of odd numbers is even + sum of even or odd numbers of even numbers is even
		
		//when k is odd and list of even numbers is empty return -1, sum of odd numbers of odd numbers is odd
		if(k%2==1 && newEven.length == 0) { 
			return -1;
		}
		
		//when odd list is not even and list of even numbers is greator then k
		if(newodd.length < 2 && newEven.length>=k) {
			return sum(newEven,k);
		}
		
		if(k%2 == 0 && newEven.length == 0 && newodd.length>=k) {
			return sum(newodd,k);
		}
		
		int l = k;
		if(k%2 == 0 && newodd.length == k ) {
			l= k+1;
		}
		int temp = -1;
		for (int i = 0; i < l; i = i + 2) {
			int sumEven = -1;
			int sumOdd = -1;
			if(i<=newodd.length) {
				sumOdd = sum(newodd, i);
			}
			if(newEven.length >= l-i) {
				sumEven = sum(newEven,l - i);	
			}
			
			if (sumOdd!=-1 && sumEven!=-1 && (sumOdd + sumEven) > temp) {
				temp = sumOdd + sumEven;
			}

		}
		return temp;
	}

	public static int sum(int arr[], int len) {
		int temp = 0;
		if(arr.length>0) {
			for (int i = 0; i < len && i < arr.length; i++) {
				temp = temp + arr[i];
			}	
		}
		
		return temp;
	}

	public static int[] sort(int unSortedArr[]) {
		for (int i = 0; i < unSortedArr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < unSortedArr.length; j++) {
				if (unSortedArr[j] > unSortedArr[index]) {
					index = j;
				}
			}

			if (i != index) {
				int temp = unSortedArr[index];
				unSortedArr[index] = unSortedArr[i];
				unSortedArr[i] = temp;
			}

		}
		return unSortedArr;
	}

	public static int[] toIntArray(List<Integer> listResult) {
		int size = listResult.size();
		int[] result = new int[size];
		Integer[] temp = listResult.toArray(new Integer[size]);
		for (int n = 0; n < size; ++n) {
			result[n] = temp[n];
		}
		return result;
	}

}
