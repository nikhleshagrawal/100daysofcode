package io.practise.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSum {

	
	public static int[] bestSum(Integer targetSum, int[] numbers) {
		if(targetSum == 0) {
			return new int[]{};
		}
		if(targetSum <0) {
			return null;
		}
		
		int[] bestSum = null;
		
		for(Integer num : numbers) {
			Integer remainder = targetSum - num;
			
			int[] newArr = bestSum(remainder,numbers) ;
			
			if(newArr !=null) {
				int[] tempARR = Arrays.copyOf(newArr, newArr.length+1);;
				tempARR[newArr.length] = num;
				if(bestSum == null || tempARR.length < bestSum.length) {
					bestSum = tempARR;
				}
			}
		}
		
		return bestSum;
	}
	
	public static int[] bestSum(Integer targetSum, int[] numbers,Map<Integer,int[]> memo) {
		if(memo.get(targetSum) !=null) {
			return memo.get(targetSum) ;
		}
		if(targetSum == 0) {
			return new int[] {};
		}
		if(targetSum <0) {
			return null;
		}
		
		int[] bestSum = null;
		
		for(Integer num : numbers) {
			Integer remainder = targetSum - num;
			int[] newArr = bestSum(remainder,numbers,memo) ;
			if(newArr!=null) {
				int[] tempARR = Arrays.copyOf(newArr, newArr.length+1);;
				tempARR[newArr.length] = num;
				memo.put(targetSum,tempARR); 
				if(bestSum == null || tempARR.length < bestSum.length) {
					bestSum = tempARR;
				}
			}
		}
		memo.put(targetSum,bestSum);
		return bestSum;
	}
	
	public static void main(String[] args) {
		System.out.println("Divide and Conquer --------------" + Arrays.toString(bestSum(7,new int[]{1,3,4,7})));
		System.out.println("Dynamic Programming --------------" + Arrays.toString(bestSum(100,new int[]{1,3,4,25}, new HashMap<Integer, int[]>())));
		//System.out.println(Arrays.toString(howSum(7,new int[]{7})));
		
		//System.out.println(Arrays.toString(howSum(7,new int[]{2,3})));

	}

}
