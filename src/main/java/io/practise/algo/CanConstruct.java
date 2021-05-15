package io.practise.algo;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

	public static boolean canConstruct(String target,String[] strArr) {
		if("".equals(target)) return true;
		
		for(String str:strArr) {
			if(target.startsWith(str)) {
				String suffix = target.substring(str.length(), target.length());
				if(canConstruct(suffix, strArr)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean canConstruct(String target,String[] strArr, Map<String,Boolean> memo) {
		
		if(memo.get(target)!=null) {
			return memo.get(target);
		}
		if("".equals(target)) return true;
		
		
		for(String str:strArr) {
			if(target.startsWith(str)) {
				String suffix = target.substring(str.length(), target.length());
				if(canConstruct(suffix, strArr,memo)) {
					memo.put(target,true);
					return true;
				}
			}
		}
		memo.put(target,false);
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Divide Conquer " + canConstruct("abcdef", new String[] {"ab","cd","e"}));
		
		System.out.println("Dynamic Program " + 
		canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {"ee","eeee","eeeeeee"},new HashMap<String,Boolean>()));
	}

}
