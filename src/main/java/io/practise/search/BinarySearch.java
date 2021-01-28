package io.practise.search;

public class BinarySearch {

	public static void main(String[] args) {
		int searchNum =  2;
		int sortedArr[] = {1,2,3,4,5,6,7,8,9,10,11};
		int i =0 , l = sortedArr.length-1;
		while(i<=l) {
			int m= (i+l)/2;
			if(sortedArr[m] == searchNum) {
				System.out.println("Number found at " + m);
				break;
			}
			
			if(sortedArr[m] < searchNum) {
				i=m+1;
			}else {
				l = m -1;
			}
		}
		

	}

}
