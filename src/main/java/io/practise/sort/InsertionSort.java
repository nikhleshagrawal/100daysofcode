package io.practise.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int unSortedArr[] = {64, 25, 12, 22, 11,2,4,5};
		int n = unSortedArr.length;
		for(int i=0;i<n-1;i++) {
			for(int j = i+1;j>0;j--) {
				
			if(unSortedArr[j] < unSortedArr[j-1]) {
				int temp = unSortedArr[j];
				unSortedArr[j] = unSortedArr[j-1];
				unSortedArr[j-1] = temp;
			}		
			}
		}
		
		System.out.println(Arrays.toString(unSortedArr));

	}

}
