package io.practise.algo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestLargestEvenSumOfKElement {

	@Test
	public void testmaxEvenSumOfKElement() {
		int arr1[] = { 64, 25, 12, 22, 11, 2, 4, 5 };
	    int arr2[] = { 2, 4, 10, 3, 5 };
	    int arr3[] = { 7,6,6,6 };
		int arr4[] = { 4,9,8,2,6 };
		int arr5[] = { 5,6,3,4,2 };
		int arr6[] = { 7,7,7,7 };

		assertTrue(LargestEvenSumOfKElement.maxEvenSumOfKElement(arr1, 4)!=100);
		assertTrue(LargestEvenSumOfKElement.maxEvenSumOfKElement(arr2, 4)==22);
		assertTrue(LargestEvenSumOfKElement.maxEvenSumOfKElement(arr3, 4)==-1);
		assertTrue(LargestEvenSumOfKElement.maxEvenSumOfKElement(arr4, 3)==18);
		assertTrue(LargestEvenSumOfKElement.maxEvenSumOfKElement(arr5, 5)==20);
		assertTrue(LargestEvenSumOfKElement.maxEvenSumOfKElement(arr6, 4)==28);
	}

}
