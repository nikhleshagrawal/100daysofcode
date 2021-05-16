package io.practise.algo;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

	public static int countConstruct(String target,String[] strArr) {
		if("".equals(target)) return 1;
		int count = 0;
		for(String str:strArr) {
			if(target.startsWith(str)) {
				String suffix = target.substring(str.length(), target.length());
				int temp = countConstruct(suffix, strArr);
				count += temp;
			}
		}
		
		return count;
	}
	
	public static int countConstruct(String target,String[] strArr, Map<String,Integer> memo) {
		
		if(memo.get(target)!=null) {
			return memo.get(target);
		}
		if("".equals(target)) return 1;
		
		int count = 0;
		for(String str:strArr) {
			if(target.startsWith(str)) {
				String suffix = target.substring(str.length(), target.length());
				int temp =countConstruct(suffix, strArr,memo); 
				count +=temp;
			}
		}
		memo.put(target,count);
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("Divide Conquer " + countConstruct("abcdef", new String[] {"ab","cd","ef"}));
		
		System.out.println("Divide Conquer " + countConstruct("purple", new String[] {"purp","p","ur","le","purpl"}));
		
		System.out.println("Dynamic Program " + 
		countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {"ee","eeee","eeeeeee"},new HashMap<String,Integer>()));
	}

}
