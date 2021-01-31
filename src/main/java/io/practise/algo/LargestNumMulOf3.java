package io.practise.algo;

import java.util.Arrays;

/**
 * Find the largest multiple of 3 from array of digits | (In O(n) time and O(1) space)

 * Given an array of digits (contain elements from 0 to 9). 
 * Find the largest number that can be made from some or all digits of array and is divisible by 3. 
 * The same element may appear multiple times in the array, but each element in the array may only be used once. 
 * 
 * Examples: 

 * Input : arr[] = {5, 4, 3, 1, 1} 
 * Output : 4311

 * Input : Arr[] = {5, 5, 5, 7} 
 * Output : 555 
 * Asked In : Google Interview
 *
 */
public class LargestNumMulOf3 {

	public int sum(int []arr) {
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public String buildNumber(int []arr) {
		StringBuffer buffer = new StringBuffer();
		for(int i=arr.length-1;i>=0;i--) {
			buffer.append(arr[i]);
		}
		return buffer.toString();
	}
	
	public int[] removeElementWithRemainder1(int arr[]) {
		int remIndex = -1;
		int []newArr = new int[arr.length-1];
		for(int i=0;i<arr.length;i++) {
			if(arr[i] % 3 ==1) {
				remIndex = i;
				break;
			}
		}
		if(remIndex !=-1) {
			
			int j = 0;
			for(int i=0;i<arr.length;i++) {
				if(remIndex != i) {
					newArr[j] = arr[i];	
					j++;
				}
				
				
			}
		}
		return newArr;
	}
	
	public int[] removeElementWithRemainder2(int arr[]) {
		int remIndex1 = -1;
		int remIndex2 = -1;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] % 3 ==2) {
				remIndex1 = i;
				break;
			}
		}
		if(remIndex1 ==-1) {
			for(int i=0;i<arr.length;i++) {
				if(remIndex1 != -1 &&  remIndex2 !=-1) {
					break;
				}
				if(arr[i] % 3 ==1) {
					if(remIndex1 == -1) {
						remIndex1 = i;
						continue;
					}
					if(remIndex2 == -1) {
						remIndex2 = i;
						continue;
					}
				}
			}
			
		}
		
		if(remIndex1 != -1 &&  remIndex2 !=-1) {
			int []newArr = new int[arr.length-2];
			int j = 0;
			for(int i=0;i<arr.length;i++) {
				if(remIndex1 != i && remIndex2 !=i) {
					newArr[j] = arr[i];	
					j++;
				}
				
			}
			return newArr;
		}else {
			int []newArr = new int[arr.length-1];
			int j = 0;
			for(int i=0;i<arr.length;i++) {
				if(remIndex1 != i) {
					newArr[j] = arr[i];	
					j++;
				}
				
			}
			return newArr;
		}
		
	}
	
	public String largestNumMulOf3(int []arr) {
		int sum = sum(arr);
		
		int remainder = sum % 3;
		Arrays.sort(arr);

		if(remainder ==0) {
			return buildNumber(arr);
		}
		
		if(remainder == 1) {
			 return buildNumber(removeElementWithRemainder1(arr));
		}
		
		if(remainder == 2) {
			return buildNumber(removeElementWithRemainder2(arr));
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {5,4,3,1,1};
		
		LargestNumMulOf3 mulOf3 = new LargestNumMulOf3();
		System.out.println(mulOf3.largestNumMulOf3(arr));
	}

}
