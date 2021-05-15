package io.practise.algo;

import java.util.Arrays;
import java.util.Map;

public class HowSum {

	
	public static int[] howSum(Integer targetSum, int[] numbers) {
		if(targetSum == 0) {
			return new int[]{};
		}
		if(targetSum <0) {
			return null;
		}
		
		for(Integer num : numbers) {
			Integer remainder = targetSum - num;
			
			int[] newArr = howSum(remainder,numbers) ;
			
			if(newArr !=null) {
				int[] tempARR = Arrays.copyOf(newArr, newArr.length+1);;
				tempARR[newArr.length] = num;
				System.out.println(Arrays.toString(tempARR));
				return tempARR;
			}
		}
		
		return null;
	}
	
	public static int[] howSum(Integer targetSum, int[] numbers,Map<Integer,int[]> memo) {
		if(memo.get(targetSum) !=null) {
			return memo.get(targetSum) ;
		}
		if(targetSum == 0) {
			return new int[] {};
		}
		if(targetSum <0) {
			return null;
		}
		
		for(Integer num : numbers) {
			Integer remainder = targetSum - num;
			int[] newArr = howSum(remainder,numbers) ;
			if(newArr!=null) {
				int[] tempARR = Arrays.copyOf(newArr, newArr.length+1);;
				tempARR[newArr.length] = num;
				memo.put(targetSum,tempARR); 
				return tempARR;
			}
		}
		memo.put(targetSum,null);
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("--------------" + Arrays.toString(howSum(7,new int[]{3,4,7})));
		//System.out.println(Arrays.toString(howSum(7,new int[]{7})));
		
		//System.out.println(Arrays.toString(howSum(7,new int[]{2,3})));

	}

}
