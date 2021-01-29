package io.practise.search;

public class BinarySearch {

	public int binarySearch(int sortedArr[],int searchNum) {
		int i =0 , l = sortedArr.length-1,index=-1;
		
		while(i<=l) {
			int m= (i+l)/2;
			if(sortedArr[m] == searchNum) {
				index = m;
				break;
			}
			
			if(sortedArr[m] < searchNum) {
				i=m+1;
			}else {
				l = m -1;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int searchNum =  50;
		int sortedArr[] = {1,2,3,4,5,6,7,8,9,10};
		BinarySearch search = new BinarySearch();
		int index = search.binarySearch(sortedArr, searchNum);
		if(index!=-1) {
			System.out.println("Number found at " + index);
		}else {
			System.out.println("Number not found");
		}
		
		

	}

}
