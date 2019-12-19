package com.alvi.datastructure;

/**
 * Finding the index of a value from an array using Binary Search
 * 
 * @author Tanmoy Tushar
 * @since 2019-12-19
 *
 */
public class BinarySearch {

	int binarySearch(int[] arr, int arrSize, int value) {
		int firstIndex = 0;
		int mid = (firstIndex + arrSize) / 2;
		while (firstIndex <= arrSize) { // How many times loop will continue; first index to last index
			if (arr[mid] < value) firstIndex = mid + 1; // if value is greater than middle value of array then increase one of first index value 
			else if (arr[mid] == value)	return mid; // when value matches then return it.
			else arrSize = mid - 1; // if value is less than middle value of array then decrease one of array size
			mid = (firstIndex + arrSize) / 2; // changing the middle value while changing first index or total size of array 
		}
		return -1; // if value doesn't match with given array then return -1
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] arr = { 1, 2, 4, 5, 6, 8, 9 };
		int valIndex = bs.binarySearch(arr, arr.length - 1, 8);
		System.out.println("Index of finding value is: " + valIndex);
	}

}
