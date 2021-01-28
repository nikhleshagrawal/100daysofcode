package io.practise.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int unSortedArr[] = {64, 25, 12, 22, 11,2,4,5};
		for(int i=0;i<unSortedArr.length-1;i++) {
			int index = i;
			for(int j=i+1;j<unSortedArr.length;j++) {
				if(unSortedArr[j]> unSortedArr[index]) {
					index = j;
				}
			}
			
			if(i!=index) {
				int temp = unSortedArr[index];
				unSortedArr[index] = unSortedArr[i];
				unSortedArr[i] = temp;
			}
			
		}
		System.out.println(Arrays.toString(unSortedArr));
	}

}
