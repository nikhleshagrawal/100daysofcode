package io.practise.algo;

import java.util.Map;

public class CanSum {

	
	public static boolean canSum(Integer targetSum, int[] numbers) {
		if(targetSum == 0) {
			return true;
		}
		if(targetSum <0) {
			return false;
		}
		
		for(Integer num : numbers) {
			Integer remainder = targetSum - num;
			if(canSum(remainder,numbers)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean canSum(Integer targetSum, int[] numbers,Map<Integer,Boolean> memo) {
		if(memo.get(targetSum) !=null) {
			return memo.get(targetSum) ;
		}
		if(targetSum == 0) {
			memo.put(targetSum,true);
			return true;
		}
		if(targetSum <0) {
			memo.put(targetSum,false);
			return false;
		}
		
		for(Integer num : numbers) {
			Integer remainder = targetSum - num;
			if(canSum(remainder,numbers,memo)) {
				memo.put(targetSum,true); 
				return true;
			}
		}
		memo.put(targetSum,false);
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(canSum(7,new int[]{1,3,4,7}));
		System.out.println(canSum(7,new int[]{7}));
		
		System.out.println(canSum(7,new int[]{2,3}));

	}

}
